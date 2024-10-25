package com.book.progress.data.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProgressDto {
    private Long id;
    private String status;
    private Integer currentPage;
    private Date startDate;
    private Date endDate;
    private Double averageReadingProgress;
    private Integer readingDurationInDays;

}
