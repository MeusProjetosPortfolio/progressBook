package com.book.progress.service;

import com.book.progress.data.dto.UserDto;
import com.book.progress.dozer.DozerConverter;
import com.book.progress.exception.CommonsException;
import com.book.progress.model.User;
import com.book.progress.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //LISTA TODOS OS USUÁRIOS
    public List<UserDto> listAllUser() {
        //   var users = userRepository.findAll();
       // var usersDto = DozerConverter.parseListObjects(users,UserDto.class);
        return DozerConverter.parseListObjects(userRepository.findAll(),UserDto.class);
    }

    //BUSCA O USUÁRIO POR ID
    public UserDto findIdUser(Long id) {
        var userEntity = userRepository.findById(id);
        if (userEntity.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND,"user.service.notfound","não foi encontrado");
        }
        //var userEntity = userRepository.findAll();
        //var userEntityDto = DozerConverter.ParseObject(userRepository.findById(id),UserDto.class);
        return DozerConverter.parseObject(userEntity.get(),UserDto.class);
    }

    //ATUALIZAR O USUÁRIO
    public UserDto updateUser(Long id, UserDto userDto){
        var existingUser = userRepository.findById(id);
        if (existingUser.isEmpty()){
            throw new CommonsException(HttpStatus.NOT_FOUND, "user.service.notfound", "Usuário não encontrado" );
        }

        User userToUpdate = DozerConverter.parseObject(userDto, User.class);
        userToUpdate.setId(id);

        return DozerConverter.parseObject(userRepository.save(userToUpdate), UserDto.class);
    }

    //SALVA O USUÁRIO
    public UserDto saveUser(UserDto userDto) {
        //var entity = DozerConverter.parseObject(userDto,User.class);
        //var entityDto = DozerConverter.parseObject(userRepository.save(entity),UserDto.class);
        return DozerConverter.parseObject(userRepository.save(DozerConverter.parseObject(userDto,User.class)),UserDto.class);
    }

    //DELETA O USUÁRIO
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
