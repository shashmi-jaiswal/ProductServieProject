package com.example.productservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This Controller supports  REST APIs (that is , HTTP requests)
//@COntroller - Spring will create a class of this at the time of initialization.
//@RequestMapping("/hello")- Requests coming to endpoint /hello , transfer them to this controller
@RestController
@RequestMapping("/hello")
public class SampleAPI {
    @GetMapping("{name}/{city}/{number}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("city") String city, @PathVariable("number") int number){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < number; i++){
            stringBuilder.append("Hello " + name + " from " + city+ ". " );

        }
        return stringBuilder.toString();
    }
}

