package com.library.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.TopicListDto;
import com.library.entity.TopicList;
import com.library.repository.TopicListRepository;
import com.library.service.TopicListService;

@Service
public class TopicListServiceImpl implements TopicListService {

	@Autowired
	private TopicListRepository topicListRepository;
	@Override
//	public List<TopicList> getTopicsBySubjectId(Long subjectId) {
//		List<TopicList> data = (List<TopicList>) topicListRepository.findBySubjectSubjectId(subjectId);
//		System.out.print(data);
//		return data;
//	}
	public List<TopicListDto> getTopicsBySubjectId(Long subjectId) {
        List<TopicList> topics = (List<TopicList>)topicListRepository.findBySubjectSubjectId(subjectId);
        return topics.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private TopicListDto convertToDto(TopicList topicList) {
        return TopicListDto.builder()
                .topicId(topicList.getTopicId())
                .topicName(topicList.getTopicName())
                .build();
    }
	@Override
	public List<TopicListDto> getAllTopics(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
