package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.TopicListDto;
import com.library.entity.TopicList;
import com.library.service.TopicListService;

@RestController
@RequestMapping("/topics")
public class TopicListController {
	@Autowired
    private TopicListService topicService;

    @GetMapping("/{subjectId}")
    public List<TopicListDto> getTopicsBySubject(@PathVariable Long subjectId) {
        return topicService.getTopicsBySubjectId(subjectId);
    }
    
}
