package com.creatorx.aslet.service;

import com.creatorx.aslet.converter.SubjectConverter;
import com.creatorx.aslet.dto.SubjectCreateDto;
import com.creatorx.aslet.dto.SubjectDto;
import com.creatorx.aslet.exception.SubjectNotFoundException;
import com.creatorx.aslet.model.Subject;
import com.creatorx.aslet.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectConverter subjectConverter;

    public SubjectDto createSubject(SubjectCreateDto subjectCreateDto) {
        Subject newSubject = subjectConverter.subjectCreateDtoToSubject(subjectCreateDto);
        subjectRepository.save(newSubject);
        return subjectConverter.subjectToDto(newSubject);
    }

    public List<SubjectDto> getAllSubjects() {
        return subjectConverter.subjectToDto(subjectRepository.findAll());
    }

    public SubjectDto getSubjectById(Long id) {
        return subjectConverter.subjectToDto(subjectRepository.findById(id)
                .orElseThrow(() -> new SubjectNotFoundException(id)));
    }

    public SubjectDto updateSubject(SubjectDto updatedSubject, Long id) {
        return subjectConverter.subjectToDto(
                subjectRepository.findById(id)
                .map(subject -> {
                    subject.setName(updatedSubject.getName());
                    return subjectRepository.save(subject);
                }).orElseThrow(() -> new SubjectNotFoundException(id)));
    }

    public void deleteSubject(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new SubjectNotFoundException(id);
        }
        subjectRepository.deleteById(id);
    }
}
