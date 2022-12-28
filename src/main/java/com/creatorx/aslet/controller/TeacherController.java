package com.creatorx.aslet.controller;

import com.creatorx.aslet.dto.TeacherCreateDto;
import com.creatorx.aslet.dto.TeacherDto;
import com.creatorx.aslet.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/teacher")
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody @Valid TeacherCreateDto newTeacher) {
        return new ResponseEntity<>(teacherService.createTeacher(newTeacher), HttpStatus.CREATED);
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id) {
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

    @PutMapping("/teacher/{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@RequestBody @Valid TeacherDto updatedTeacher, @PathVariable Long id) {
        return ResponseEntity.ok(teacherService.updateTeacher(updatedTeacher, id));
    }

    @DeleteMapping("/teacher/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
