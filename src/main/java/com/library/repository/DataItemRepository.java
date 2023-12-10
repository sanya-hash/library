package com.library.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.library.entity.DataItem;

public interface DataItemRepository extends CrudRepository<DataItem, Long>{
	List<DataItem> findByTopicTopicId(Long topicId);
}
