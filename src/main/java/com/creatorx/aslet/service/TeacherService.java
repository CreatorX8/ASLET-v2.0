package com.creatorx.aslet.service;

import com.creatorx.aslet.converter.TeacherConverter;
import com.creatorx.aslet.dto.RequestMetadata;
import com.creatorx.aslet.dto.TeacherCreateDto;
import com.creatorx.aslet.dto.TeacherDto;
import com.creatorx.aslet.exception.TeacherNotFoundException;
import com.creatorx.aslet.model.Teacher;
import com.creatorx.aslet.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherConverter teacherConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private RequestMetadata requestMetadata;

    public TeacherDto createTeacher(TeacherCreateDto teacherCreateDto) {
        Teacher newTeacher = teacherConverter.teacherCreateDtoToTeacher(teacherCreateDto);
        newTeacher.setOwner(userService.getUserByIdDefault(requestMetadata.getId()));
        teacherRepository.save(newTeacher);
        return teacherConverter.teacherToDto(newTeacher);
    }

    public List<TeacherDto> getAllTeachers() {
        return teacherConverter.teacherToDto(teacherRepository.findAll());
    }

    public TeacherDto getTeacherById(Long id) {
        return teacherConverter.teacherToDto(teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id)));
    }

    public TeacherDto updateTeacher(TeacherDto updatedTeacher, Long id) {
        return teacherConverter.teacherToDto(
                teacherRepository.findById(id)
                .map(teacher -> {
                    teacher.setName(updatedTeacher.getName());
                    return teacherRepository.save(teacher);
                }).orElseThrow(() -> new TeacherNotFoundException(id)));
    }

    public void deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new TeacherNotFoundException(id);
        }
        teacherRepository.deleteById(id);
    }
}
