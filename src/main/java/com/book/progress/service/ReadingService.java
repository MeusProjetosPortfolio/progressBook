package com.book.progress.service;

import com.book.progress.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadingService {

    @Autowired
    private ReadingRepository readingRepository;
}
