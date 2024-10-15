package com.book.progress.data.mapper;

import com.book.progress.data.dto.ProgressDto;
import com.book.progress.model.Progress;
import org.springframework.stereotype.Component;

@Component
public class ProgressMapper {
    public static ProgressDto toDto(Progress progress){
        ProgressDto dto = new ProgressDto();
        dto.setId(progress.getId());
        dto.setStatus(progress.getStatus());
        dto.setAverageReadingProgress(progress.getAverageReadingProgress());
        dto.setReadingDurationInDays(progress.getReadingDurationInDays());

        if (progress.getReading() != null) {
        dto.setReadingDto(ReadingMapper.toDto(progress.getReading()));
        }
            return dto;
    }

    public static Progress toEntity(ProgressDto dto){
        Progress progress = new Progress();

        progress.setId(dto.getId());
        progress.setStatus(dto.getStatus());
        progress.setAverageReadingProgress(dto.getAverageReadingProgress());
        progress.setReadingDurationInDays(dto.getReadingDurationInDays());

        if (dto.getReadingDto() != null) {
           progress.setReading(ReadingMapper.toEntity(dto.getReadingDto()));
        }

        return progress;
    }
}
