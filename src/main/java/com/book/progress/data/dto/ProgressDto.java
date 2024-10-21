package com.book.progress.data.dto;

import lombok.Data;

@Data
public class ProgressDto {
    private Long id;
    private String status;
    private Double averageReadingProgress;
    private Integer readingDurationInDays;

}
