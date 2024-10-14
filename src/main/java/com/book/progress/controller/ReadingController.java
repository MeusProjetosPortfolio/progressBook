package com.book.progress.controller;

import com.book.progress.data.dto.ReadingDto;
import com.book.progress.data.mapper.BookMapper;
import com.book.progress.data.mapper.ReadingMapper;
import com.book.progress.model.Reading;
import com.book.progress.service.ReadingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/readings")
@CrossOrigin("*")
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @GetMapping
    public List<ReadingDto> readingDtoList(){
        List<Reading> readings = readingService.listAllReading();

        return readings.stream() //TRATAMENTO DA LIST
                .map(ReadingMapper::toDto) //REFERÊNCIA DA CLASSE+MÉTOD
                .collect(Collectors.toList()); //COLETANDO ESSAS INFORM
    }

    /*
List<Reading> readings = readingService.listAllReading();
List<ReadingDto> readingDtos = new ArrayList<>();

for (Reading reading : readings) {
    readingDtos.add(ReadingMapper.toDto(reading));
}

return readingDtos;

*/

    @GetMapping("/{id}")
    public ReadingDto findByReadingId(@PathVariable Long id){

        return readingService.findIdReading(id)
                .map(ReadingMapper::toDto)
                .orElseThrow(()->new EntityNotFoundException("Pessoa não encontrada com o id " + id));
    }

    @PostMapping
    public ReadingDto createReading(@RequestBody ReadingDto dtoReading){
        Reading reading = ReadingMapper.toEntity(dtoReading);
        Reading readingSave = readingService.saveReading(reading);
        return ReadingMapper.toDto(readingSave);
    }

    @PutMapping("/{id}")
    public ReadingDto updateReading(@PathVariable Long id, @RequestBody ReadingDto dtoReading) {

        if (!readingService.findIdReading(id).isPresent()) {
            throw new EntityNotFoundException("Pessoa não encontrada com o id: " + id);
        }

        Reading reading = ReadingMapper.toEntity(dtoReading);
        reading.setId(id);
        Reading readingUpdate = readingService.updateReading(reading);
        return ReadingMapper.toDto(readingUpdate);
    }

    public void  readingDelete(@PathVariable Long id) {
        readingService.deleteReading(id);
    }
}
