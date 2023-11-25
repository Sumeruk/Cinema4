package com.example.cinema4.controllers;

import com.example.cinema4.DTO.SessionDTO;

import com.example.cinema4.entity.Film;
import com.example.cinema4.entity.Session;
import com.example.cinema4.repos.FilmRepos;
import com.example.cinema4.repos.HallRepos;
import com.example.cinema4.repos.SessionRepos;
import com.example.cinema4.servicies.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

@Controller
@RequiredArgsConstructor
public class SessionController {
    private final SessionRepos sessionRepos;
    private final FilmRepos filmRepos;
    private final SessionService sessionService;
    private final HallRepos hallRepos;

    @GetMapping("/sessions")
    public String showSessions(Model model){
        model.addAttribute("newSession", new SessionDTO());
        model.addAttribute("filmSessions", sessionRepos.findAllWithNameFilm());
        model.addAttribute("resultOfSave", sessionService.isResult());
        model.addAttribute("halls", hallRepos.findNum_hall());
        model.addAttribute("films", filmRepos.findFilm_id());
        return "Sessions";
    }

    @PostMapping("/sessions/newSession")
    public String saveSession(@ModelAttribute("newSession") SessionDTO sessionDTO, Model model) throws ParseException {
        sessionService.processingInputData(sessionDTO);
        model.addAttribute("resultOfSave", sessionService.isResult());
        return "redirect:/sessions";
    }


    @PostMapping("/sessionsByFilms")
    public String findFilms(@RequestParam("name_film") String name_film, Model model){
        model.addAttribute("sessionsWithFilm",sessionRepos.findAllByNameFilm(name_film));
        return "Sessions";
    }
}
