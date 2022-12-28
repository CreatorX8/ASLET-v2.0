package com.creatorx.aslet.converter;

import com.creatorx.aslet.dto.TeacherCreateDto;
import com.creatorx.aslet.dto.TeacherDto;
import com.creatorx.aslet.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherConverter {
    public TeacherDto teacherToDto(Teacher teacher) {
        return new TeacherDto(teacher.getId(), teacher.getName());
    }

    public List<TeacherDto> teacherToDto(List<Teacher> teachers) {
        List<TeacherDto> teacherDtos = new ArrayList<>();
        for (Teacher teacher : teachers) {
            teacherDtos.add(new TeacherDto(teacher.getId(), teacher.getName()));
        }
        return teacherDtos;
    }

    public Teacher teacherCreateDtoToTeacher(TeacherCreateDto teacherCreateDto) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherCreateDto.getName());
        return teacher;
    }
}
