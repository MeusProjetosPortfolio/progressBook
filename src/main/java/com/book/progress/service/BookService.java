package com.book.progress.service;

import com.book.progress.model.Book;
import com.book.progress.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //LISTA TODOS OS LIVROS
    public List<Book> listAllBook() {
        return bookRepository.findAll();
    }

    //BUSCA O LIVRO POR ID
    public Optional<Book> findIdBook(Long id) {
        return bookRepository.findById(id);
    }

    //SALVA O LIVRO
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    //ATUALIZAR O LIVRO
    public  Book updateBook(Book book){
        return bookRepository.save(book);
    }

    //DELETAR O LIVRO
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
