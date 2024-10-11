package com.book.progress.data.dto;
import java.util.Date;

public class ReadingDto {

    private Long id;
    private Integer currentPage;
    private Date startDate;
    private Date endDate;
    private Integer rating;

    private UserDto userDto;
    private BookDto bookDto;
    private ProgressDto progressDto;
}
