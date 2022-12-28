package com.creatorx.aslet.controller;

import com.creatorx.aslet.dto.SubjectCreateDto;
import com.creatorx.aslet.dto.SubjectDto;
import com.creatorx.aslet.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping("/subject")
    public ResponseEntity<SubjectDto> createSubject(@RequestBody @Valid SubjectCreateDto newSubject) {
        return ResponseEntity.ok(subjectService.createSubject(newSubject));
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<SubjectDto>> getAllSubjects() {
        return ResponseEntity.ok(subjectService.getAllSubjects());
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<SubjectDto> getSubjectById(@PathVariable Long id) {
        return ResponseEntity.ok(subjectService.getSubjectById(id));
    }

    @PutMapping("/subject/{id}")
    public ResponseEntity<SubjectDto> updateSubject(@RequestBody @Valid SubjectDto updatedSubject, @PathVariable Long id) {
        return ResponseEntity.ok(subjectService.updateSubject(updatedSubject, id));
    }

    @DeleteMapping("/subject/{id}")
    public ResponseEntity deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
