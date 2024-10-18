package com.book.progress.controller;

import com.book.progress.data.dto.ReadingDto;
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

    @GetMapping("/all")
    public List<ReadingDto> readingDtoList(){
        return readingService.listAllReading();
    }

    @GetMapping("/{id}")
    public ReadingDto findByReadingId(@PathVariable Long id){

        return readingService.findIdReading(id);
    }

    @PostMapping
    public ReadingDto createReading(@RequestBody ReadingDto dtoReading){
       return readingService.saveReading(dtoReading);
    }

    @PutMapping("/{id}")
    public ReadingDto updateReading(@PathVariable Long id, @RequestBody ReadingDto dtoReading) {
        return readingService.saveReading(dtoReading);
    }

    @DeleteMapping("/{id}")
    public void  readingDelete(@PathVariable Long id) {
        readingService.deleteReading(id);
    }
}
