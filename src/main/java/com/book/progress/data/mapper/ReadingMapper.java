package com.book.progress.data.mapper;

import com.book.progress.data.dto.ReadingDto;
import com.book.progress.model.Reading;

public class ReadingMapper {
    public static ReadingDto toDto(Reading reading){
        ReadingDto dto = new ReadingDto();
        dto.setId(reading.getId());
        dto.setCurrentPage(reading.getCurrentPage());
        dto.setStartDate(reading.getStartDate());
        dto.setEndDate(reading.getEndDate());
        dto.setRating(reading.getRating());

        if (reading.getUser() != null){
            dto.setUserDto(UserMapper.toDto(reading.getUser()));
        }

        if (reading.getBook() != null) {
            dto.setBookDto(BookMapper.toDto(reading.getBook()));
        }

        if (reading.getProgress() != null) {
            dto.setProgressDto(ProgressMapper.toDto(reading.getProgress()));
        }
            return dto;

    }

    public static Reading toEntity(ReadingDto dto){
        Reading reading = new Reading();
        reading.setId(dto.getId());
        reading.setCurrentPage(dto.getCurrentPage());
        reading.setStartDate(dto.getStartDate());
        reading.setEndDate(dto.getEndDate());
        reading.setRating(dto.getRating());

        reading.setUser(UserMapper.toEntity(dto.getUserDto()));
        reading.setBook(BookMapper.toEntity(dto.getBookDto()));
        reading.setProgress(ProgressMapper.toEntity(dto.getProgressDto()));

        return reading;
    }
}
