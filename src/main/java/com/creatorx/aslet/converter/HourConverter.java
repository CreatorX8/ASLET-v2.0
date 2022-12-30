package com.creatorx.aslet.converter;

import com.creatorx.aslet.dto.HourCreateDto;
import com.creatorx.aslet.dto.HourDto;
import com.creatorx.aslet.model.Hour;
import com.creatorx.aslet.service.ClassGroupService;
import com.creatorx.aslet.service.SubjectService;
import com.creatorx.aslet.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HourConverter {
    @Autowired
    private ClassGroupService classGroupService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SubjectService subjectService;

    public HourDto hourToDto(Hour hour) {
        return new HourDto(hour.getId(), hour.getClassGroup().getId(), hour.getTeacher().getId(), hour.getSubject().getId(), hour.getHoursAWeek());
    }

    public List<HourDto> hourToDto(List<Hour> hours) {
        List<HourDto> hourDtos = new ArrayList<>();
        for (Hour hour : hours) {
            hourDtos.add(new HourDto(hour.getId(), hour.getClassGroup().getId(), hour.getTeacher().getId(), hour.getSubject().getId(), hour.getHoursAWeek()));
        }
        return hourDtos;
    }

    public Hour hourCreateDtoToHour(HourCreateDto hourCreateDto) {
        Hour hour = new Hour();
        hour.setClassGroup(classGroupService.getClassGroupByIdDefault(hourCreateDto.getClassGroup()));
        hour.setTeacher(teacherService.getTeacherByIdDefault(hourCreateDto.getTeacher()));
        hour.setSubject(subjectService.getSubjectByIdDefault(hourCreateDto.getSubject()));
        hour.setHoursAWeek(hourCreateDto.getHoursAWeek());
        return hour;
    }
}
