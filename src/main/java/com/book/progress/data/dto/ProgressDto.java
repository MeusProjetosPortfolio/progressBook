package com.book.progress.data.dto;

import java.util.List;

public class ProgressDto {
    private Long id;
    private Integer booksRead;
    private Integer totalPoints;
    private Double averageReadingProgress;
    private Integer achievementsUnlocked;
    private Integer readingDurationInDays;

    private UserDto userDto;
    private List<ReadingDto> readingsDto;
}
