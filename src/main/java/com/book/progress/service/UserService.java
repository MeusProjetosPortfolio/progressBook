package com.book.progress.service;

import com.book.progress.model.User;
import com.book.progress.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //LISTA TODOS OS USUÁRIOS
    public List<User> listAllUser() {
        return userRepository.findAll();
    }

    //BUSCA O USUÁRIO POR ID
    public Optional<User> findIdUser(Long id) {
        return userRepository.findById(id);
    }

    //SALVA O USUÁRIO
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //ATUALIZA O USUÁRIO
    public User updateUser(User user){
        return userRepository.save(user);
    }

    //DELETA O USUÁRIO
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
