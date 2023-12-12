package com.library.serviceImpl;

import java.util.List;
import java.util.Map;
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
    
    
	@Override
	public List<DataItem> uploadItem(Map dataItem) {
		// TODO Auto-generated method stub
	     
//	    Long dataItemId =Long.parseLong(dataItem.get("dataItemId").toString());
		String Id = dataItem.get("topic").toString();
		Long topicId = Long.parseLong(Id);
		
		
		
	    String dataItemName = dataItem.get("title").toString();
	    String dataType = dataItem.get("contentType").toString();
	    String program = dataItem.get("programCourse").toString();
	    String branch = dataItem.get("branch").toString();
	    String semester = dataItem.get("semester").toString();
	    String subject = dataItem.get("subjectTitle").toString();
	    String allowDownload= dataItem.get("allowDownload").toString();//wait 11:30 p aya
	    
		DataItem dataItemToSave = new DataItem();
		
//		List<DataItem> listOfDataItems = new ArrayList<>();
		
		
//		dataItemToSave.setDataItemId(dataItemId);
		dataItemToSave.setDataItemName(dataItemName);
		dataItemToSave.setDataType(dataType);
		dataItemToSave.setProgram(program);
		dataItemToSave.setBranch(branch);
		dataItemToSave.setSemester(semester);
		dataItemToSave.setSubject(subject);
		dataItemToSave.setAllowDownload(allowDownload);
		
		TopicList topic = new TopicList();
		topic.setTopicId(topicId);
		
		dataItemToSave.setTopic(topic);
		
		dataItemRepository.save(dataItemToSave);
		
		
		
		return null;
	}
		
}
