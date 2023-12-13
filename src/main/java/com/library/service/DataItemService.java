package com.library.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.library.dto.DataItemDto;
import com.library.entity.DataItem;

public interface DataItemService {
	public List<DataItemDto> getDataItemsByTopicId(Long topicId);
	public List<DataItem> uploadItem(Map dataItem);
//	 void uploadItem(MultipartFile file, String dataItemName, String dataType,
//             String program, String branch, String semester, String subject,
//             String allowDownload, Long topicId) throws IOException;
	 public void uploadData(MultipartFile file, String dataItemName, String dataType, String program,
             String branch, String semester, String subject, String allowDownload, Long topicId) throws IOException;

}
