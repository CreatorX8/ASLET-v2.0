package com.creatorx.aslet.controller;

import com.creatorx.aslet.dto.ClassCreateDto;
import com.creatorx.aslet.dto.ClassDto;
import com.creatorx.aslet.service.ClassService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ClassController {
    @Autowired
    private ClassService classService;

    @PostMapping("/class")
    public ResponseEntity<ClassDto> createClass(@RequestBody @Valid ClassCreateDto newClass) {
        return new ResponseEntity<>(classService.createClass(newClass), HttpStatus.CREATED);
    }

    @GetMapping("/classes")
    public ResponseEntity<List<ClassDto>> getAllClasses() {
        return ResponseEntity.ok(classService.getAllClasses());
    }

    @GetMapping("/class/{id}")
    public ResponseEntity<ClassDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(classService.getClassById(id));
    }

    @PutMapping("/class/{id}")
    public ResponseEntity<ClassDto> updateUser(@RequestBody @Valid ClassDto updatedClass, @PathVariable Long id) {
        return ResponseEntity.ok(classService.updateClass(updatedClass, id));
    }

    @DeleteMapping("/class/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        classService.deleteClass(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
