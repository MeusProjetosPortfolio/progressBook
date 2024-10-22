package com.book.progress.service;

import com.book.progress.data.dto.ProgressDto;
import com.book.progress.dozer.DozerConverter;
import com.book.progress.exception.CommonsException;
import com.book.progress.model.Progress;
import com.book.progress.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    //LISTAR TODOS OS PROGRESSOS
    public List<ProgressDto> findAllProgress() {
        return DozerConverter.parseListObjects(progressRepository.findAll(),ProgressDto.class);
    }

    //BUSCAR O PROGRESSO POR ID
    public ProgressDto findIdProgress(Long id) {
        var progressEntity = progressRepository.findById(id);
        if (progressEntity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,"progress.service.notfound","não foi encontrado");
        }
        return DozerConverter.parseObject(progressEntity.get(), ProgressDto.class);
    }

    //SALVAR O STATUS
    public ProgressDto saveProgress(ProgressDto progressDto) {
        return DozerConverter.parseObject(progressRepository.save(DozerConverter.parseObject(progressDto,Progress.class)),ProgressDto.class);
    }


    //DELETAR O PROGRESSO
    public void deleteProgress(Long id){
        progressRepository.deleteById(id);
    }
}
