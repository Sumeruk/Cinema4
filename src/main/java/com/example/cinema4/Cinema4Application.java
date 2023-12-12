package com.example.cinema4;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Cinema4Application {

    public static void main(String[] args) {
        SpringApplication.run(Cinema4Application.class, args);
    }



//    scanBasePackages={"com.example.cinema4.repos", "com.example.cinema4.controllers"}
//    @Bean
//    CommandLineRunner commandLineRunner(FilmRepos hr){
//
//        return args ->{
//            System.out.println(hr.findFilm_id());
//        };
//    }

}
