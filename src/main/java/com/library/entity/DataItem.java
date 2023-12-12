package com.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
@Getter
@Setter
public class DataItem {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dataItemId;

    private String dataItemName;//title
    
    private String dataType;
    private String program;//programcourse
    private String branch;
    private String  semester;
    private String subject;
    
    private String allowDownload;
    
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private TopicList topic;
}
