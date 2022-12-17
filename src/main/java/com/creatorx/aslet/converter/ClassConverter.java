package com.creatorx.aslet.converter;

import com.creatorx.aslet.dto.ClassCreateDto;
import com.creatorx.aslet.model.Class;
import com.creatorx.aslet.dto.ClassDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassConverter {
    public ClassDto classToDto(Class studentsClass) {
        return new ClassDto(studentsClass.getId(), studentsClass.getGrade(), studentsClass.getLetter());
    }

    public List<ClassDto> classToDto(List<Class> classes) {
        List<ClassDto> classDtos = new ArrayList<>();
        for (Class studentsClass : classes) {
            classDtos.add(new ClassDto(studentsClass.getId(), studentsClass.getGrade(), studentsClass.getLetter()));
        }
        return classDtos;
    }

    public Class classCreateDtoToClass(ClassCreateDto classCreateDto) {
        Class studentsClass = new Class();
        studentsClass.setGrade(classCreateDto.getGrade());
        studentsClass.setLetter(classCreateDto.getLetter());
        return studentsClass;
    }
}
