package com.example.cinema4.controllers;

import com.example.cinema4.repos.FilmRepos;
import com.example.cinema4.repos.SessionRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SessionController {
    private final SessionRepos sessionRepos;
    private final FilmRepos filmRepos;

    @GetMapping("/sessions")
    public String showSessions(Model model){
        model.addAttribute("filmSessions", sessionRepos.findAllWithNameFilm());
        return "Sessions";
    }


    @PostMapping("/sessionsByFilms")
    public String findFilms(@RequestParam("name_film") String name_film, Model model){
        model.addAttribute("sessionsWithFilm",sessionRepos.findAllByNameFilm(name_film));
        return "Sessions";
    }
}
