package com.book.progress.data.dto;

import com.book.progress.model.Reading;

public class ReadingMapper {
    public static ReadingMapper toDto(Reading reading){
        ReadingDto dto = new ReadingDto();
        dto.setId(reading.getId());
        dto.setCurrentPage(reading.getCurrentPage());
        dto.setStartDate(reading.getStartDate());
        dto.setEndDate(reading.getEndDate());

        if (reading.getUser() != null){
            dto.setUserDto(UserMapper.toDto(reading.getUser()));
        }

        if (reading.getBook() != null) {
            dto.setBookDto(BookMapper.toDto(reading.getBook()));
        }

      //falta progress
    }
}
