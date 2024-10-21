package com.book.progress.service;

import com.book.progress.data.dto.BookDto;
import com.book.progress.dozer.DozerConverter;
import com.book.progress.exception.CommonsException;
import com.book.progress.model.Book;
import com.book.progress.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //LISTA TODOS OS LIVROS
    public List<BookDto> listAllBook() {
        return DozerConverter.parseListObjects(bookRepository.findAll(),BookDto.class);
    }

    //BUSCA O LIVRO POR ID
    public BookDto findIdBook(Long id) {
        var bookEntity = bookRepository.findById(id);
        if (bookEntity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,"book.service.notfound","não foi encontrado");
        }

        return DozerConverter.parseObject(bookRepository.findById(id),BookDto.class);
    }

    //ATUALIZAR O LIVRO
    public BookDto updateBook(Long id, BookDto bookDto) {
        var existingBook = bookRepository.findById(id);
        if (existingBook.isEmpty()) {
            throw new CommonsException(HttpStatus.NOT_FOUND, "book.service.notfound", "Livro não encontrado para atualização");
        }

        Book bookToUpdate = DozerConverter.parseObject(bookDto, Book.class);
        bookToUpdate.setId(id);

        return DozerConverter.parseObject(bookRepository.save(bookToUpdate), BookDto.class);
    }


    //SALVA O LIVRO
    public BookDto saveBook(BookDto bookDto) {
        return DozerConverter.parseObject(bookRepository.save(DozerConverter.parseObject(bookDto,Book.class)),BookDto.class);
    }

    //DELETAR O LIVRO
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
