package com.example.demo;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.BasicUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "/hello" , produces = { MediaType.APPLICATION_JSON_VALUE})
    public String helloWorldAzureP(){
        return "{\"message\":\"Hello world Azure\"}";
    }

    @GetMapping(value = "/id/{id}" , produces = { MediaType.APPLICATION_JSON_VALUE})
    public String userInfo(@PathVariable("id") Long id){
        Optional<BasicUser> basicUser = userRepository.findById(id);
        return basicUser.map(user -> "{\"message\":\"Hello " + user.getName() + " to new world of possibilities\"}")
                .orElse("{\"message\":\"Hello guest to new world of possibilities\"}");
    }
}
