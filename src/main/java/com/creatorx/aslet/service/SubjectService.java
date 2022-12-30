package com.creatorx.aslet.service;

import com.creatorx.aslet.converter.SubjectConverter;
import com.creatorx.aslet.dto.SubjectCreateDto;
import com.creatorx.aslet.dto.SubjectDto;
import com.creatorx.aslet.exception.NotBelongsToUserException;
import com.creatorx.aslet.exception.SubjectNotFoundException;
import com.creatorx.aslet.model.Subject;
import com.creatorx.aslet.repository.SubjectRepository;
import com.creatorx.aslet.utils.AccessUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectConverter subjectConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private AccessUtils accessUtils;

    public SubjectDto createSubject(SubjectCreateDto subjectCreateDto) {
        Subject newSubject = subjectConverter.subjectCreateDtoToSubject(subjectCreateDto);
        newSubject.setOwner(userService.getUserByIdDefault(accessUtils.getUserId()));
        subjectRepository.save(newSubject);
        return subjectConverter.subjectToDto(newSubject);
    }

    public List<SubjectDto> getAllSubjects() {
        if (accessUtils.isAdmin()) return subjectConverter.subjectToDto(subjectRepository.findAll());
        return subjectConverter.subjectToDto(subjectRepository.findAllByOwner_Id(accessUtils.getUserId()));
    }

    public SubjectDto getSubjectById(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new SubjectNotFoundException(id));
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(subject.getOwner().getId())) throw new NotBelongsToUserException();
        return subjectConverter.subjectToDto(subject);
    }

    public Subject getSubjectByIdDefault(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new SubjectNotFoundException(id));
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(subject.getOwner().getId())) throw new NotBelongsToUserException();
        return subject;
    }

    public SubjectDto updateSubject(SubjectDto updatedSubject, Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new SubjectNotFoundException(id));
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(subject.getOwner().getId())) throw new NotBelongsToUserException();
        subject.setName(updatedSubject.getName());
        subjectRepository.save(subject);
        return subjectConverter.subjectToDto(subject);
    }

    public void deleteSubject(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new SubjectNotFoundException(id);
        }
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(getSubjectByIdDefault(id).getOwner().getId())) throw new NotBelongsToUserException();
        subjectRepository.deleteById(id);
    }
}
