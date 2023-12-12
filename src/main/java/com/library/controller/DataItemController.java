package com.library.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    @PostMapping("/upload")
    public String uploadItem(@RequestBody Map dataItem){
    	System.out.println(dataItem);
//    	return dataItemService.uploadItem(dataItem);
    	dataItemService.uploadItem(dataItem);
    	return "Success";
    }

}
