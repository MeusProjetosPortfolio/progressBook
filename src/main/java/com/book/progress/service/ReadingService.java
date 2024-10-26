package com.book.progress.service;
import com.book.progress.data.dto.ReadingDto;
import com.book.progress.dozer.DozerConverter;
import com.book.progress.exception.CommonsException;
import com.book.progress.model.Reading;
import com.book.progress.repository.BookRepository;
import com.book.progress.repository.ProgressRepository;
import com.book.progress.repository.ReadingRepository;
import com.book.progress.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadingService {

    @Autowired
    private ReadingRepository readingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private ProgressService progressService;

    //Listar todas as leituras
    public List<ReadingDto> listAllReading() {
        return DozerConverter.parseListObjects(readingRepository.findAll(), ReadingDto.class);
    }

    //BUSCA A LEITURA POR ID
    public ReadingDto findIdReading(Long id) {
        var readingEntity = readingRepository.findById(id);
        if (readingEntity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,"reading.service.notfound","não foi encontrado");
        }
        return DozerConverter.parseObject(readingEntity.get(),ReadingDto.class);
    }

    //ATUALIZAR A LEITURA
    public  ReadingDto updateReading(Long id, ReadingDto readingDto){
        var existingReading = readingRepository.findById(id);
        if (existingReading.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND, "reading.service.notfound", "Leitura não encontrado");
        }

        Reading readingToUpdate = DozerConverter.parseObject(readingDto,Reading.class);
        readingToUpdate.setId(id);

        return DozerConverter.parseObject(readingRepository.save(readingToUpdate), ReadingDto.class);
    }

    //SALVAR A LEITURA
    public ReadingDto saveReading(ReadingDto readingDto){
        var user = userRepository.findById(readingDto.getUser().getId())
                .orElseThrow(()-> new CommonsException(HttpStatus.NOT_FOUND,"user.notfound", "Usuário não encontrado"));

        var book = bookRepository.findById(readingDto.getBook().getId())
                .orElseThrow(() -> new CommonsException(HttpStatus.NOT_FOUND, "book.notfound", "Livro não encontrado"));

        var progress = progressRepository.findById(readingDto.getProgress().getId())
                .orElseThrow(() -> new CommonsException(HttpStatus.NOT_FOUND, "progress.notfound", "Progresso não encontrado"));


        // Converter DTO para entidade Reading sem os relacionamentos
        var reading = DozerConverter.parseObject(readingDto, Reading.class);

        // Associar manualmente User e Book à entidade Reading
        reading.setUser(user);
        reading.setBook(book);
        reading.setProgress(progress);

        // Salvar a entidade Reading
        var savedReading = readingRepository.save(reading);

        ReadingDto savedReadingDto = DozerConverter.parseObject(savedReading, ReadingDto.class);
        progressService.calculateDuration(savedReadingDto.getProgress());

        return savedReadingDto;
    }


    //DELETAR A LEITURA
    public void deleteReading(Long id) {
        readingRepository.deleteById(id);
    }
}
