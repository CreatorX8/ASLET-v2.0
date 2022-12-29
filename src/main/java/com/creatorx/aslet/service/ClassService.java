package com.creatorx.aslet.service;

import com.creatorx.aslet.converter.ClassConverter;
import com.creatorx.aslet.dto.ClassCreateDto;
import com.creatorx.aslet.dto.ClassDto;
import com.creatorx.aslet.exception.ClassExistsException;
import com.creatorx.aslet.exception.ClassNotFoundException;
import com.creatorx.aslet.exception.NotBelongsToUserException;
import com.creatorx.aslet.model.Class;
import com.creatorx.aslet.model.ClassGroup;
import com.creatorx.aslet.repository.ClassGroupRepository;
import com.creatorx.aslet.repository.ClassRepository;
import com.creatorx.aslet.utils.AccessUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ClassGroupRepository classGroupRepository;

    @Autowired
    private ClassConverter classConverter;

    @Autowired
    private UserService userService;

    @Autowired
    public AccessUtils accessUtils;

    public ClassDto createClass(ClassCreateDto classCreateDto) {
        if (classRepository.findByGradeAndLetter(classCreateDto.getGrade(), classCreateDto.getLetter()).size() > 0) throw new ClassExistsException();
        Class newClass = classConverter.classCreateDtoToClass(classCreateDto);
        newClass.setOwner(userService.getUserByIdDefault(accessUtils.getUserId()));
        classRepository.save(newClass);
        ClassGroup classGroup = new ClassGroup();
        classGroup.setName(newClass.getClassName());
        classGroup.setStudentsClass(newClass);
        classGroup.setPeopleCount(classCreateDto.getPeopleCount());
        classGroupRepository.save(classGroup);
        return classConverter.classToDto(newClass);
    }

    public List<ClassDto> getAllClasses() {
        if (accessUtils.isAdmin()) return classConverter.classToDto(classRepository.findAll());
        return classConverter.classToDto(classRepository.findAllByOwner_Id(accessUtils.getUserId()));
    }

    public ClassDto getClassById(Long id) {
        Class studentsClass = classRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException(id));
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(studentsClass.getOwner().getId())) throw new NotBelongsToUserException();
        return classConverter.classToDto(studentsClass);
    }

    public Class getClassByIdDefault(Long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException(id));
    }

    public ClassDto updateClass(ClassDto updatedClass, Long id) {
        Class studentsClass = classRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException(id));
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(studentsClass.getOwner().getId())) throw new NotBelongsToUserException();
        if (classRepository.findByGradeAndLetter(updatedClass.getGrade(), updatedClass.getLetter()).size() > 0) throw new ClassExistsException();
        studentsClass.setGrade(updatedClass.getGrade());
        studentsClass.setLetter(updatedClass.getLetter());
        classRepository.save(studentsClass);
        return classConverter.classToDto(studentsClass);
    }

    public void deleteClass(Long id) {
        if (!classRepository.existsById(id)) {
            throw new ClassNotFoundException(id);
        }
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(getClassByIdDefault(id).getOwner().getId())) throw new NotBelongsToUserException();
        classRepository.deleteById(id);
    }
}
