package com.book.progress.service;

import com.book.progress.model.Archievement;
import com.book.progress.repository.ArchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArchievementService {

    @Autowired
    private ArchievementRepository archivementRepository;

    //LISTAR TODAS AS CONQUISTAS
    public List<Archievement> findAllArchivement(){
        return archivementRepository.findAll();
    }

    //BUSCAR A CONQUISTA POR ID
    public Optional<Archievement> findIdArchivement(Long id){
        return archivementRepository.findById(id);
    }

    //
}
