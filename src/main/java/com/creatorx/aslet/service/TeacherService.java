package com.creatorx.aslet.service;

import com.creatorx.aslet.converter.TeacherConverter;
import com.creatorx.aslet.dto.TeacherCreateDto;
import com.creatorx.aslet.dto.TeacherDto;
import com.creatorx.aslet.exception.NotBelongsToUserException;
import com.creatorx.aslet.exception.TeacherNotFoundException;
import com.creatorx.aslet.model.Teacher;
import com.creatorx.aslet.repository.TeacherRepository;
import com.creatorx.aslet.utils.AccessUtils;
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
    private AccessUtils accessUtils;

    public TeacherDto createTeacher(TeacherCreateDto teacherCreateDto) {
        Teacher newTeacher = teacherConverter.teacherCreateDtoToTeacher(teacherCreateDto);
        newTeacher.setOwner(userService.getUserByIdDefault(accessUtils.getUserId()));
        teacherRepository.save(newTeacher);
        return teacherConverter.teacherToDto(newTeacher);
    }

    public List<TeacherDto> getAllTeachers() {
        if (accessUtils.isAdmin()) return teacherConverter.teacherToDto(teacherRepository.findAll());
        return teacherConverter.teacherToDto(teacherRepository.findAllByOwner_Id(accessUtils.getUserId()));
    }

    public TeacherDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(teacher.getOwner().getId())) throw new NotBelongsToUserException();
        return teacherConverter.teacherToDto(teacher);
    }

    public Teacher getTeacherByIdDefault(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
    }

    public TeacherDto updateTeacher(TeacherDto updatedTeacher, Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(teacher.getOwner().getId())) throw new NotBelongsToUserException();
        teacher.setName(updatedTeacher.getName());
        teacherRepository.save(teacher);
        return teacherConverter.teacherToDto(teacher);
    }

    public void deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new TeacherNotFoundException(id);
        }
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(getTeacherByIdDefault(id).getOwner().getId())) throw new NotBelongsToUserException();
        teacherRepository.deleteById(id);
    }
}
