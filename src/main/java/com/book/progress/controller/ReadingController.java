package com.book.progress.controller;

import com.book.progress.data.dto.ReadingDto;
import com.book.progress.data.mapper.BookMapper;
import com.book.progress.data.mapper.ReadingMapper;
import com.book.progress.data.mapper.UserMapper;
import com.book.progress.model.Reading;
import com.book.progress.service.ReadingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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
                .orElseThrow(()->new EntityNotFoundException("Leitura não encontrada com o id " + id));
    }

    @PostMapping
    public ReadingDto createReading(@RequestBody ReadingDto dtoReading){
        Reading reading = ReadingMapper.toEntity(dtoReading);
        Reading readingSave = readingService.saveReading(reading);
        return ReadingMapper.toDto(readingSave);
    }

    @PutMapping("/{id}")
    public ReadingDto updateReading(@PathVariable Long id, @RequestBody ReadingDto dtoReading) {

        Optional<Reading> existingReadingOpt = readingService.findIdReading(id);

        if (!existingReadingOpt.isPresent()){
            throw new EntityNotFoundException("Leitura não encontrada com o id: " + id);
        }

        Reading existingReading = existingReadingOpt.get();

        existingReading.setCurrentPage(dtoReading.getCurrentPage());
        existingReading.setStartDate(dtoReading.getStartDate());
        existingReading.setEndDate(dtoReading.getEndDate());
        existingReading.setRating(dtoReading.getRating());

        if (dtoReading.getUserDto() != null){
            existingReading.setUser(UserMapper.toEntity(dtoReading.getUserDto()));
        }

        if (dtoReading.getBookDto() != null){
            existingReading.setBook(BookMapper.toEntity(dtoReading.getBookDto()));
        }

        Reading readingUpdate = readingService.updateReading(existingReading);

        return ReadingMapper.toDto(readingUpdate);

    }

    @DeleteMapping("/{id}")
    public void  readingDelete(@PathVariable Long id) {
        readingService.deleteReading(id);
    }
}
