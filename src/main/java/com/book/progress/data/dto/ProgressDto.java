package com.book.progress.data.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProgressDto {
    private Long id;
    private String status;
    private Date startDate;
    private Date endDate;
    private Long durationInDays;

}
