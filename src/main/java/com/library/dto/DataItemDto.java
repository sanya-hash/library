package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class DataItemDto {
	private Long dataItemId;

    private String dataItemName;
    private String dataType;
    private String program;//programcourse
    private String branch;
    private String  semester;
    private String subject;
   
//    private byte [] data;

}
