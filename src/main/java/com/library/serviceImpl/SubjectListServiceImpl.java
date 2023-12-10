package com.library.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.SubjectListDto;
import com.library.entity.SubjectList;
import com.library.repository.SubjectListRepository;
import com.library.service.SubjectListService;

@Service
public class SubjectListServiceImpl implements SubjectListService{

	
	@Autowired
	private SubjectListRepository subjectListRepository;
	@Override
	public List<SubjectListDto> getAllSubjects() {
		List<SubjectList> subjects =  (List<SubjectList>) subjectListRepository.findAll();
		return subjects.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private SubjectListDto convertToDto(SubjectList subjectList) {
        return SubjectListDto.builder()
                .subjectId(subjectList.getSubjectId())
                .subjectCode(subjectList.getSubjectCode())
                .subjectTitle(subjectList.getSubjectTitle())
                .build();
    }



}
