package com.book.progress.data.mapper;

import com.book.progress.data.dto.ReadingDto;
import com.book.progress.model.Book;
import com.book.progress.model.Progress;
import com.book.progress.model.Reading;
import com.book.progress.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReadingMapper {
    public static ReadingDto toDto(Reading reading) {
        ReadingDto dto = new ReadingDto();
        dto.setId(reading.getId());
        dto.setCurrentPage(reading.getCurrentPage());
        dto.setStartDate(reading.getStartDate());
        dto.setEndDate(reading.getEndDate());
        dto.setRating(reading.getRating());

        if (reading.getUser() != null) {
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

    public static Reading toEntity(ReadingDto dto) {
        Reading reading = new Reading();
        reading.setId(dto.getId());
        reading.setCurrentPage(dto.getCurrentPage());
        reading.setStartDate(dto.getStartDate());
        reading.setEndDate(dto.getEndDate());
        reading.setRating(dto.getRating());

        if (dto.getUserDto() != null && dto.getUserDto().getId() != null) {
            User user = new User();
            user.setId(dto.getUserDto().getId());
            reading.setUser(user);
        }

        if (dto.getBookDto() != null && dto.getBookDto().getId() != null) {
            Book book = new Book();
            book.setId(dto.getBookDto().getId());
            reading.setBook(book);
        }

        if (dto.getProgressDto() != null && dto.getProgressDto().getId() != null) {
            Progress progress = new Progress();
            progress.setId(dto.getProgressDto().getId());
            reading.setProgress(progress);
        }
// Log final para ver o objeto criado
        System.out.println("Created Reading entity: " + reading);
        return reading;
    }

    // Converter uma lista de 'Reading' para uma lista de 'ReadingDto'
    public static List<ReadingDto> toDto(List<Reading> readings) {
        return readings.stream()
                .map(ReadingMapper::toDto)
                .collect(Collectors.toList());
    }

    // Converter uma lista de 'ReadingDto' para uma lista de 'Reading'
    public static List<Reading> toEntity(List<ReadingDto> readingDtos) {
        return readingDtos.stream()
                .map(ReadingMapper::toEntity)
                .collect(Collectors.toList());
    }
}
