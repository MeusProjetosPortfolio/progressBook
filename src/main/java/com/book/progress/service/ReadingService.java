package com.book.progress.service;

import com.book.progress.model.Book;
import com.book.progress.model.Reading;
import com.book.progress.model.User;
import com.book.progress.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadingService {

    @Autowired
    private ReadingRepository readingRepository;

    //Listar todas as leituras
    public List<Reading> listAllReading() {
        return readingRepository.findAll();
    }

    //BUSCA A LEITURA POR ID
    public Optional<Reading> findIdReading(Long id) {
        return readingRepository.findById(id);
    }

    //SALVAR A LEITURA
    public Reading saveReading(Reading reading){
        return readingRepository.save(reading);
    }

    //ATUALIZAR A LEITURA
    public Reading updateReading(Reading reading){
        if (reading.getUser() != null && reading.getBook() != null) {
            return readingRepository.save(reading);
        }
        throw new IllegalArgumentException("User and Book must be associated with Reading");
    }

    //DELETAR A LEITURA
    public void deleteReading(Long id) {
        readingRepository.deleteById(id);
    }
}
