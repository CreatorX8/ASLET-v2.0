package com.creatorx.aslet.service;

import com.creatorx.aslet.converter.ClassGroupConverter;
import com.creatorx.aslet.dto.ClassGroupCreateDto;
import com.creatorx.aslet.dto.ClassGroupDto;
import com.creatorx.aslet.exception.ClassGroupNotFoundException;
import com.creatorx.aslet.exception.ClassNotFoundException;
import com.creatorx.aslet.exception.NotBelongsToUserException;
import com.creatorx.aslet.model.ClassGroup;
import com.creatorx.aslet.repository.ClassGroupRepository;
import com.creatorx.aslet.repository.ClassRepository;
import com.creatorx.aslet.utils.AccessUtils;
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

    @Autowired
    private AccessUtils accessUtils;

    public ClassGroupDto createClassGroup(ClassGroupCreateDto classGroupCreateDto) {
        if (!classRepository.existsById(classGroupCreateDto.getStudentsClass()))
            throw new ClassNotFoundException(classGroupCreateDto.getStudentsClass());
        ClassGroup newClassGroup = classGroupConverter.classGroupCreateDtoToClassGroup(classGroupCreateDto);
        classGroupRepository.save(newClassGroup);
        return classGroupConverter.classGroupToDto(newClassGroup);
    }

    public List<ClassGroupDto> getAllClassGroups() {
        if (accessUtils.isAdmin()) return classGroupConverter.classGroupToDto(classGroupRepository.findAll());
        return classGroupConverter.classGroupToDto(classGroupRepository.findAllByStudentsClass_Owner_Id(accessUtils.getUserId()));
    }

    public ClassGroupDto getClassGroupById(Long id) {
        ClassGroup classGroup = classGroupRepository.findById(id)
                .orElseThrow(() -> new ClassGroupNotFoundException(id));
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(classGroup.getStudentsClass().getOwner().getId())) throw new NotBelongsToUserException();
        return classGroupConverter.classGroupToDto(classGroup);
    }

    public ClassGroup getClassGroupByIdDefault(Long id) {
        return classGroupRepository.findById(id)
                .orElseThrow(() -> new ClassGroupNotFoundException(id));
    }

    public ClassGroupDto updateClassGroup(ClassGroupDto updatedClassGroup, Long id) {
        ClassGroup classGroup = classGroupRepository.findById(id)
                .orElseThrow(() -> new ClassGroupNotFoundException(id));
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(classGroup.getStudentsClass().getOwner().getId())) throw new NotBelongsToUserException();
        if (!classRepository.existsById(updatedClassGroup.getStudentsClass()))
            throw new ClassNotFoundException(updatedClassGroup.getStudentsClass());
        classGroup.setName(updatedClassGroup.getName());
        classGroup.setStudentsClass(classService.getClassByIdDefault(updatedClassGroup.getStudentsClass()));
        classGroup.setPeopleCount(updatedClassGroup.getPeopleCount());
        classGroupRepository.save(classGroup);
        return classGroupConverter.classGroupToDto(classGroup);
    }

    public void deleteClassGroup(Long id) {
        if (!classGroupRepository.existsById(id)) {
            throw new ClassGroupNotFoundException(id);
        }
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(getClassGroupByIdDefault(id).getStudentsClass().getOwner().getId())) throw new NotBelongsToUserException();
        classGroupRepository.deleteById(id);
    }
}
