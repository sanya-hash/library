package com.library.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.library.dto.DataItemDto;
import com.library.dto.TopicListDto;
import com.library.entity.DataItem;
import com.library.entity.TopicList;
import com.library.repository.DataItemRepository;
import com.library.repository.TopicListRepository;
import com.library.service.DataItemService;
import com.library.service.TopicListService;

import jakarta.transaction.Transactional;

@Service
public class DataItemServiceImpl implements DataItemService{

	@Autowired
	private DataItemRepository dataItemRepository;
	
	@Autowired
	private TopicListRepository topicListRepository;
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
                .program(dataItem.getProgram())
                .branch(dataItem.getBranch())
                .semester(dataItem.getSemester())
                .subject(dataItem.getSubject())
                .dataType(dataItem.getDataType())
                .filePath(dataItem.getFilePath())
                .build();
    }
    
    
	@Override
	public List<DataItem> uploadItem(Map dataItem) {
	
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
	
	@Transactional
    public void uploadData(MultipartFile file, String dataItemName, String dataType, String program,
                           String branch, String semester, String subject, String allowDownload, Long topicId) throws IOException {
        TopicList topic = topicListRepository.findById(topicId).orElseThrow(() -> new RuntimeException("Topic not found"));

        DataItem dataItem = new DataItem();
        dataItem.setDataItemName(dataItemName);
        dataItem.setDataType(dataType);
        dataItem.setProgram(program);
        dataItem.setBranch(branch);
        dataItem.setSemester(semester);
        dataItem.setSubject(subject);
        dataItem.setAllowDownload(allowDownload);
        dataItem.setTopic(topic);

        // Save the file and set the file path in the database
        String filePath = saveFile(file, dataItemName, dataType);
        dataItem.setFilePath(filePath);
        dataItemRepository.save(dataItem);
    }

    private String saveFile(MultipartFile file, String dataItemName, String dataType) throws IOException {
        String uploadDir = "D:\\uploading";

        // Create the upload directory if it doesn't exist
        Path uploadPath = Path.of(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = dataItemName + "_" + System.currentTimeMillis() + getFileExtension(file.getOriginalFilename());
        Path filePath = uploadPath.resolve(fileName);

        // Save the file to the upload path
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return uploadDir + "/" + fileName;
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex);
    }
		
}
