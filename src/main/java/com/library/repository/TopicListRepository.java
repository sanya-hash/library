package com.library.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.library.entity.TopicList;

public interface TopicListRepository extends CrudRepository<TopicList, Long>{
	
	List<TopicList> findBySubjectSubjectId(Long subjectId);

}
