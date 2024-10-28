package com.book.progress.data.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProgressDto {
    private Long id;
    private String status;
    private Date startDate;
    private Date endDate;
    private Long durationInDays;
    private Double percentage;
    private Integer booksRead = 0;
    private List<ArchievementDto> unlockedAchievements;


}
