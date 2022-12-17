package com.creatorx.aslet.service;

import com.creatorx.aslet.converter.ClassGroupConverter;
import com.creatorx.aslet.dto.ClassGroupCreateDto;
import com.creatorx.aslet.dto.ClassGroupDto;
import com.creatorx.aslet.exception.ClassGroupNotFoundException;
import com.creatorx.aslet.exception.ClassNotFoundException;
import com.creatorx.aslet.model.ClassGroup;
import com.creatorx.aslet.repository.ClassGroupRepository;
import com.creatorx.aslet.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassGroupService {
    @Autowired
    private ClassGroupRepository classGroupRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ClassGroupConverter classGroupConverter;

    @Autowired
    private ClassService classService;

    public ClassGroupDto createClassGroup(ClassGroupCreateDto classGroupCreateDto) {
        if (!classRepository.existsById(classGroupCreateDto.getStudentsClass()))
            throw new ClassNotFoundException(classGroupCreateDto.getStudentsClass());
        ClassGroup newClassGroup = classGroupConverter.classGroupCreateDtoToClassGroup(classGroupCreateDto);
        classGroupRepository.save(newClassGroup);
        return classGroupConverter.classGroupToDto(newClassGroup);
    }

    public List<ClassGroupDto> getAllClassGroups() {
        return classGroupConverter.classGroupToDto(classGroupRepository.findAll());
    }

    public ClassGroupDto getClassGroupById(Long id) {
        return classGroupConverter.classGroupToDto(classGroupRepository.findById(id)
                .orElseThrow(() -> new ClassGroupNotFoundException(id)));
    }

    public ClassGroupDto updateClassGroup(ClassGroupDto updatedClassGroup, Long id) {
        if (!classRepository.existsById(updatedClassGroup.getStudentsClass()))
            throw new ClassNotFoundException(updatedClassGroup.getStudentsClass());
        return classGroupConverter.classGroupToDto(
                classGroupRepository.findById(id)
                .map(classGroup -> {
                    classGroup.setName(updatedClassGroup.getName());
                    classGroup.setStudentsClass(classService.getClassByIdDefault(updatedClassGroup.getStudentsClass()));
                    classGroup.setPeopleCount(updatedClassGroup.getPeopleCount());
                    return classGroupRepository.save(classGroup);
                }).orElseThrow(() -> new ClassGroupNotFoundException(id)));
    }

    public void deleteClassGroup(Long id) {
        if (!classGroupRepository.existsById(id)) {
            throw new ClassGroupNotFoundException(id);
        }
        classGroupRepository.deleteById(id);
    }
}
