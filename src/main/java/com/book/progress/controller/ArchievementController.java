package com.book.progress.controller;

import com.book.progress.repository.ArchievementRepository;
import com.book.progress.service.ArchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/archievements")
@CrossOrigin("*")
public class ArchievementController {

    @Autowired
    public ArchievementService archievementService;


}
