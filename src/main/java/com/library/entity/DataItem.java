package com.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class DataItem {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dataItemId;

    private String dataItemName;
    
    private String dataType;
    
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private TopicList topic;
}
