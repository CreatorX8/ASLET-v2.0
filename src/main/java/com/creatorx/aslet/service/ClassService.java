package com.creatorx.aslet.service;

import com.creatorx.aslet.converter.ClassConverter;
import com.creatorx.aslet.dto.ClassCreateDto;
import com.creatorx.aslet.dto.ClassDto;
import com.creatorx.aslet.exception.ClassExistsException;
import com.creatorx.aslet.exception.ClassNotFoundException;
import com.creatorx.aslet.model.Class;
import com.creatorx.aslet.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ClassConverter classConverter;

    public ClassDto createClass(ClassCreateDto classCreateDto) {
        if (classRepository.findByGradeAndLetter(classCreateDto.getGrade(), classCreateDto.getLetter()).size() > 0) throw new ClassExistsException();
        Class newClass = classConverter.classCreateDtoToClass(classCreateDto);
        classRepository.save(newClass);
        return classConverter.classToDto(newClass);
    }

    public List<ClassDto> getAllClasses() {
        return classConverter.classToDto(classRepository.findAll());
    }

    public ClassDto getClassById(Long id) {
        return classConverter.classToDto(classRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException(id)));
    }

    public Class getClassByIdDefault(Long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException(id));
    }

    public ClassDto updateClass(ClassDto updatedClass, Long id) {
        if (classRepository.findByGradeAndLetter(updatedClass.getGrade(), updatedClass.getLetter()).size() > 0) throw new ClassExistsException();
        return classConverter.classToDto(
                classRepository.findById(id)
                .map(studentsClass -> {
                    studentsClass.setGrade(updatedClass.getGrade());
                    studentsClass.setLetter(updatedClass.getLetter());
                    return classRepository.save(studentsClass);
                }).orElseThrow(() -> new ClassNotFoundException(id)));
    }

    public void deleteClass(Long id) {
        if (!classRepository.existsById(id)) {
            throw new ClassNotFoundException(id);
        }
        classRepository.deleteById(id);
    }
}
