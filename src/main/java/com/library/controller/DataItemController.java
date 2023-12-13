package com.library.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.library.dto.DataItemDto;
import com.library.entity.DataItem;
import com.library.service.DataItemService;

@RestController
@RequestMapping("/data-items")
public class DataItemController {
	@Autowired
    private DataItemService dataItemService;

    @GetMapping("/{topicId}")
    public List<DataItemDto> getDataItemsByTopic(@PathVariable Long topicId) {
        return dataItemService.getDataItemsByTopicId(topicId);
    }
    
//    @PostMapping("/upload")
//    public String uploadItem(@RequestBody Map dataItem){
//    	System.out.println(dataItem);
//
//    	dataItemService.uploadItem(dataItem);
//    	return "Success";
//    }
    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadItem(@RequestParam("file") MultipartFile file,
                                             @RequestParam("dataItemName") String dataItemName,
                                             @RequestParam("dataType") String dataType,
                                             @RequestParam("program") String program,
                                             @RequestParam("branch") String branch,
                                             @RequestParam("semester") String semester,
                                             @RequestParam("subject") String subject,
                                             @RequestParam("allowDownload") String allowDownload,
                                             @RequestParam("topicId") Long topicId) {
        try {
        	//System.out.print(file+dataItemName+topicId);
            dataItemService.uploadData(file, dataItemName, dataType, program, branch, semester, subject, allowDownload, topicId);
            return ResponseEntity.ok("File uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to upload file.");
        }
    }

}
