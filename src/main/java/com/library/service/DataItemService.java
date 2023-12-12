package com.library.service;

import java.util.List;
import java.util.Map;

import com.library.dto.DataItemDto;
import com.library.entity.DataItem;

public interface DataItemService {
	public List<DataItemDto> getDataItemsByTopicId(Long topicId);
	public List<DataItem> uploadItem(Map dataItem);

}
