package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.SubjectListDto;
import com.library.entity.SubjectList;
//import com.library.service.SubjectListService;
import com.library.serviceImpl.SubjectListServiceImpl;


@RestController
@RequestMapping("/subjects")
public class SubjectListController {
	
//	@Autowired
//	private SubjectListServiceImpl subjectListService;
//	
//	@GetMapping("")
//	public List<SubjectList> getAllSubject(){
//		return subjectListService.getAllSubject();
//	}
    private final SubjectListServiceImpl subjectListServiceImpl;

    @Autowired
    public SubjectListController(SubjectListServiceImpl subjectListService) {
        this.subjectListServiceImpl = subjectListService;
    }

    @GetMapping
    public List<SubjectListDto> getAllSubjects() {
        return subjectListServiceImpl.getAllSubjects();
    }

}
