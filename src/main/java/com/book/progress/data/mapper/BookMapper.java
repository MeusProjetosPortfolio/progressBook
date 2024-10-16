package com.book.progress.data.mapper;

import com.book.progress.data.dto.BookDto;
import com.book.progress.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public static BookDto toDto(Book book){
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setGenre(book.getGenre());
        dto.setTotalPages(book.getTotalPages());

        return dto;
    }

    public static Book toEntity(BookDto dto){
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setGenre(dto.getGenre());
        book.setTotalPages(dto.getTotalPages());


        return book;
    }
}
