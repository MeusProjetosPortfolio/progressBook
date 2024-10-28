package com.book.progress.controller;

import com.book.progress.data.dto.ProgressDto;
import com.book.progress.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin("*")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @GetMapping("/all")
    public List<ProgressDto> progressDtoList() {
        return progressService.findAllProgress();
    }

    @GetMapping("/{id}")
    public ProgressDto findByProgressId(@PathVariable Long id) {
        return progressService.findIdProgress(id);
    }

    @PostMapping
    public ProgressDto createProgress(@RequestBody ProgressDto dtoProgress) {
        return progressService.saveProgress(dtoProgress);
    }

    @PutMapping("/{id}")
    public ProgressDto updateProgress(@PathVariable Long id, @RequestBody ProgressDto dtoProgress) {
        return progressService.updateProgress(id,dtoProgress);
    }

    @DeleteMapping("/{id}")
    public void progressDelete(@PathVariable Long id) {
        progressService.deleteProgress(id);
    }
}
