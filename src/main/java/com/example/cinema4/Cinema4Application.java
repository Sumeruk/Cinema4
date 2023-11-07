package com.example.cinema4;

import com.example.cinema4.repos.HallRepos;
import com.example.cinema4.repos.SessionRepos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Cinema4Application {

    public static void main(String[] args) {
        SpringApplication.run(Cinema4Application.class, args);
    }



//    scanBasePackages={"com.example.cinema4.repos", "com.example.cinema4.controllers"}
//    @Bean
//    CommandLineRunner commandLineRunner(SessionRepos  hr){
//
//        return args ->{
//
//            System.out.println(hr.findAll().toString());
//        };
//    }

}
