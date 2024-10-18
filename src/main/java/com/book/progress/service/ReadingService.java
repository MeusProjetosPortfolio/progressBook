package com.book.progress.service;

import com.book.progress.data.dto.ReadingDto;
import com.book.progress.dozer.DozerConverter;
import com.book.progress.exception.CommonsException;
import com.book.progress.model.Reading;
import com.book.progress.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReadingService {

    @Autowired
    private ReadingRepository readingRepository;

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
        return DozerConverter.parseObject(readingRepository.findById(id), ReadingDto.class);
    }

    //SALVAR A LEITURA
    public ReadingDto saveReading(ReadingDto readingDto){
        var entity = readingRepository.save(DozerConverter.parseObject(readingDto,Reading.class));
        return DozerConverter.parseObject(entity, ReadingDto.class);
    }

    //DELETAR A LEITURA
    public void deleteReading(Long id) {
        readingRepository.deleteById(id);
    }
}
