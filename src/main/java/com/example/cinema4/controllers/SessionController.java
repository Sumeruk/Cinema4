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
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("films", filmRepos.findAll());
        return "Sessions";
    }

    @PostMapping("/sessions/newSession")
    public String saveSession(@ModelAttribute("newSession") SessionDTO sessionDTO, Model model){
        sessionService.processingInputData(sessionDTO);
        model.addAttribute("resultOfSave", sessionService.isResult());
        return "redirect:/sessions";
    }

    @GetMapping("/sessions/update/{sessionId}")
    public String updateSession(@PathVariable Long sessionId, Model model){
        model.addAttribute("oldSession", sessionRepos.findAllWithNameFilmBySession_id(sessionId));
        model.addAttribute("updSession", new SessionDTO());
        model.addAttribute("films", filmRepos.findAll());
        model.addAttribute("halls", hallRepos.findAll());
        return "update_session";
    }

    @PostMapping("/sessions/update/{sessionId}")
    public String saveUpdSession(@PathVariable Long sessionId, @ModelAttribute("updSession") SessionDTO sessionDTO, Model model){
        Session oldSession = sessionRepos.findSessionBySession_id(sessionId);
        sessionService.saveUpdSession(oldSession, sessionDTO);
        return "redirect:/sessions";
    }

    //todo посмотреть в таблице удаление сеанса из билетов
    @GetMapping("/sessions/delete/{id}")
    public String deleteFilmInformation( @PathVariable Long id){
        sessionRepos.deleteById(id);
        return "redirect:/sessions";
    }
}
