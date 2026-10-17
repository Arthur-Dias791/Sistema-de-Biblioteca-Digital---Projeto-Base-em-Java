package com.example.librarybackend.service;

import com.example.librarybackend.dto.LoginDTO;
import com.example.librarybackend.dto.UserDTO;
import com.example.librarybackend.entity.UsersEntity;
import com.example.librarybackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    UsersRepository repository;

    public String signUp(UserDTO registrationRequest) {

        //validações
        if(
                registrationRequest.name == null ||
                registrationRequest.email == null ||
                registrationRequest.password == null
        ) {
            System.out.println("campos obrigatores incorretos/vazios");
        }

        UsersEntity user = new UsersEntity(registrationRequest.name, registrationRequest.email, registrationRequest.password);

        //vou salvar credencias no Bd
        repository.save(user);

        return "usuario salvo com sucesso";
    }

    public Boolean signIn(LoginDTO loginData) {
        UsersEntity user = repository.findByEmail(loginData.email);

        if(user == null) {
            return false;
        }

        return Objects.equals(user.password, loginData.password);
    }
}
