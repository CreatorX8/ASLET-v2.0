package com.creatorx.aslet.service;

import com.creatorx.aslet.converter.HourConverter;
import com.creatorx.aslet.dto.HourCreateDto;
import com.creatorx.aslet.dto.HourDto;
import com.creatorx.aslet.exception.HourNotFoundException;
import com.creatorx.aslet.exception.NotBelongsToUserException;
import com.creatorx.aslet.model.Hour;
import com.creatorx.aslet.repository.HourRepository;
import com.creatorx.aslet.utils.AccessUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HourService {
    @Autowired
    private HourRepository hourRepository;

    @Autowired
    private HourConverter hourConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private ClassGroupService classGroupService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private AccessUtils accessUtils;

    public HourDto createHour(HourCreateDto hourCreateDto) {
        Hour newHour = hourConverter.hourCreateDtoToHour(hourCreateDto);
        newHour.setOwner(userService.getUserByIdDefault(accessUtils.getUserId()));
        hourRepository.save(newHour);
        return hourConverter.hourToDto(newHour);
    }

    public List<HourDto> getAllHours() {
        if (!accessUtils.isAdmin()) return hourConverter.hourToDto(hourRepository.findAll());
        return hourConverter.hourToDto(hourRepository.findAllByOwner_Id(accessUtils.getUserId()));
    }

    public HourDto getHourById(Long id) {
        Hour hour = hourRepository.findById(id)
                .orElseThrow(() -> new HourNotFoundException(id));
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(hour.getOwner().getId())) throw new NotBelongsToUserException();
        return hourConverter.hourToDto(hour);
    }

    public Hour getHourByIdDefault(Long id) {
        Hour hour = hourRepository.findById(id)
                .orElseThrow(() -> new HourNotFoundException(id));
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(hour.getOwner().getId())) throw new NotBelongsToUserException();
        return hour;
    }

    public HourDto updateHour(HourDto updatedHour, Long id) {
        Hour hour = hourRepository.findById(id)
                .orElseThrow(() -> new HourNotFoundException(id));
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(hour.getOwner().getId())) throw new NotBelongsToUserException();
        hour.setClassGroup(classGroupService.getClassGroupByIdDefault(updatedHour.getClassGroup()));
        hour.setTeacher(teacherService.getTeacherByIdDefault(updatedHour.getTeacher()));
        hour.setSubject(subjectService.getSubjectByIdDefault(updatedHour.getSubject()));
        hour.setHoursAWeek(updatedHour.getHoursAWeek());
        hourRepository.save(hour);
        return hourConverter.hourToDto(hour);
    }

    public void deleteHour(Long id) {
        if (!hourRepository.existsById(id)) {
            throw new HourNotFoundException(id);
        }
        if (!accessUtils.isAdmin() && !accessUtils.doesBelongToUser(getHourByIdDefault(id).getOwner().getId())) throw new NotBelongsToUserException();
        hourRepository.deleteById(id);
    }
}
