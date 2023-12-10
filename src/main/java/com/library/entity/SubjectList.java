package com.library.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class SubjectList {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long subjectId;

	    private String subjectCode;

	    private String subjectTitle;

	    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	    private List<TopicList> topicLists;

}
