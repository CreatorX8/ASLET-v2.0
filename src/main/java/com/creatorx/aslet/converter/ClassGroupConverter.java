package com.creatorx.aslet.converter;

import com.creatorx.aslet.dto.ClassGroupCreateDto;
import com.creatorx.aslet.dto.ClassGroupDto;
import com.creatorx.aslet.model.ClassGroup;
import com.creatorx.aslet.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassGroupConverter {
    @Autowired
    private ClassService classService;

    public ClassGroupDto classGroupToDto(ClassGroup classGroup) {
        return new ClassGroupDto(classGroup.getId(), classGroup.getName(), classGroup.getStudentsClass().getId(), classGroup.getPeopleCount());
    }

    public List<ClassGroupDto> classGroupToDto(List<ClassGroup> classGroups) {
        List<ClassGroupDto> classGroupDtos = new ArrayList<>();
        for (ClassGroup classGroup : classGroups) {
            classGroupDtos.add(new ClassGroupDto(classGroup.getId(), classGroup.getName(), classGroup.getStudentsClass().getId(), classGroup.getPeopleCount()));
        }
        return classGroupDtos;
    }

    public ClassGroup classGroupCreateDtoToClassGroup(ClassGroupCreateDto classGroupCreateDto) {
        ClassGroup classGroup = new ClassGroup();
        classGroup.setName(classGroupCreateDto.getName());
        classGroup.setStudentsClass(classService.getClassByIdDefault(classGroupCreateDto.getStudentsClass()));
        classGroup.setPeopleCount(classGroupCreateDto.getPeopleCount());
        return classGroup;
    }
}
