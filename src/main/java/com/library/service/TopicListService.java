package com.library.service;

import java.util.List;

import com.library.dto.TopicListDto;

public interface TopicListService {
	public List<TopicListDto> getTopicsBySubjectId(Long subjectId) ;
	List<TopicListDto> getAllTopics(Long id);
}
