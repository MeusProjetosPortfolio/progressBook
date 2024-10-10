package com.book.progress.controller;

import com.book.progress.data.dto.BookDto;
import com.book.progress.data.dto.BookMapper;
import com.book.progress.model.Book;
import com.book.progress.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDto> bookDtoList(){
        List<Book> books = bookService.listAllBook();

        return books.stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookDto findByBookId(@PathVariable Long id) {

        return bookService.findIdBook(id)
                .map(BookMapper::toDto)
                .orElseThrow(()-> new EntityNotFoundException("Pessoa não encontrada com o id: " + id));
    }



}
