package com.example.cinema4;

import com.example.cinema4.repos.HallRepos;
import com.example.cinema4.repos.SessionRepos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages={"com.example.cinema4.repos"})
public class Cinema4Application {

    public static void main(String[] args) {
        SpringApplication.run(Cinema4Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(SessionRepos  hr){

        return args ->{

            System.out.println(hr.findAll().toString());
        };
    }

}
