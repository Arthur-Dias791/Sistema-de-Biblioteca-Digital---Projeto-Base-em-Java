 package com.example.librarybackend.controller;

 import com.example.librarybackend.dto.LoginDTO;
 import com.example.librarybackend.dto.UserDTO;
 import com.example.librarybackend.entity.UsersEntity;
 import com.example.librarybackend.service.AuthService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import java.util.Scanner;

 @RestController
 @RequestMapping(value = "/auth")
 public class AuthController {

     /*
     public AuthController(AuthService service) {
         service = new AuthService();
     }
      */
     @Autowired
     AuthService svc;

    @PostMapping(value = "/signup")
    public String register(@RequestBody UserDTO userRegistrationRequest){
        //chamar a funcao register do service
        return svc.signUp(userRegistrationRequest);
    }

    @PostMapping(value = "/signin")
    public Boolean login(@RequestBody LoginDTO credenciais) {
        return svc.signIn(credenciais);


    }
}
