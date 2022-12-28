package com.creatorx.aslet.converter;

import com.creatorx.aslet.dto.SubjectCreateDto;
import com.creatorx.aslet.dto.SubjectDto;
import com.creatorx.aslet.model.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectConverter {
    public SubjectDto subjectToDto(Subject subject) {
        return new SubjectDto(subject.getId(), subject.getName());
    }

    public List<SubjectDto> subjectToDto(List<Subject> subjects) {
        List<SubjectDto> subjectDtos = new ArrayList<>();
        for (Subject subject : subjects) {
            subjectDtos.add(new SubjectDto(subject.getId(), subject.getName()));
        }
        return subjectDtos;
    }

    public Subject subjectCreateDtoToSubject(SubjectCreateDto subjectCreateDto) {
        Subject subject = new Subject();
        subject.setName(subjectCreateDto.getName());
        return subject;
    }
}
