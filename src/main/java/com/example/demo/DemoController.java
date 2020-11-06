package com.example.demo;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.BasicUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DemoController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/hello")
    public String helloWorldAzureP(){
        return "Hello world Azure";
    }

    @GetMapping("/id/{id}")
    public String userInfo(@PathVariable("id") Long id){
        Optional<BasicUser> basicUser = userRepository.findById(id);
        return basicUser.map(user -> "Hello " + user.getName() + " to new world of possibilities")
                .orElse("Hello guest to new world of possibilities");
    }
}
