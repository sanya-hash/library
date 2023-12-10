package com.library.service;

import java.util.List;

import com.library.dto.DataItemDto;
import com.library.entity.DataItem;

public interface DataItemService {
	public List<DataItemDto> getDataItemsByTopicId(Long topicId);
}
