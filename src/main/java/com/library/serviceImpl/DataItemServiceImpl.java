package com.library.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.DataItemDto;
import com.library.dto.TopicListDto;
import com.library.entity.DataItem;
import com.library.entity.TopicList;
import com.library.repository.DataItemRepository;
import com.library.service.DataItemService;

@Service
public class DataItemServiceImpl implements DataItemService{

	@Autowired
	private DataItemRepository dataItemRepository;
	@Override
	public List<DataItemDto> getDataItemsByTopicId(Long topicId) {
		List<DataItem> data = (List<DataItem>)dataItemRepository.findByTopicTopicId(topicId);
		return data.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private DataItemDto convertToDto(DataItem dataItem) {
        return DataItemDto.builder()
                .dataItemId(dataItem.getDataItemId())
                .dataItemName(dataItem.getDataItemName())
                .dataType(dataItem.getDataType())
                .build();
    }
}
