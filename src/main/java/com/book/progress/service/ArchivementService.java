package com.book.progress.service;

import com.book.progress.repository.ArchivementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchivementService {

    @Autowired
    private ArchivementRepository archivementRepository;
}
