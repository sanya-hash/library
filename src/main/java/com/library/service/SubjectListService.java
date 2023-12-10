package com.library.service;

import java.util.List;

import com.library.dto.SubjectListDto;
import com.library.entity.SubjectList;

public interface SubjectListService {
	public List<SubjectListDto> getAllSubjects();
}

