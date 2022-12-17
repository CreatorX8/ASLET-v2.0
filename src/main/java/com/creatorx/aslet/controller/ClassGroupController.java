package com.creatorx.aslet.controller;

import com.creatorx.aslet.dto.ClassGroupCreateDto;
import com.creatorx.aslet.dto.ClassGroupDto;
import com.creatorx.aslet.service.ClassGroupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ClassGroupController {
    @Autowired
    private ClassGroupService classGroupService;

    @PostMapping("/classGroup")
    public ResponseEntity<ClassGroupDto> createClassGroup(@RequestBody @Valid ClassGroupCreateDto newClassGroup) {
        return new ResponseEntity<>(classGroupService.createClassGroup(newClassGroup), HttpStatus.CREATED);
    }

    @GetMapping("/classGroups")
    public ResponseEntity<List<ClassGroupDto>> getAllClassGroups() {
        return ResponseEntity.ok(classGroupService.getAllClassGroups());
    }

    @GetMapping("/classGroup/{id}")
    public ResponseEntity<ClassGroupDto> getClassGroupById(@PathVariable Long id) {
        return ResponseEntity.ok(classGroupService.getClassGroupById(id));
    }

    @PutMapping("/classGroup/{id}")
    public ResponseEntity<ClassGroupDto> updateClassGroup(@RequestBody @Valid ClassGroupDto updatedClassGroup, @PathVariable Long id) {
        return ResponseEntity.ok(classGroupService.updateClassGroup(updatedClassGroup, id));
    }

    @DeleteMapping("/classGroup/{id}")
    public ResponseEntity deleteClassGroup(@PathVariable Long id) {
        classGroupService.deleteClassGroup(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
