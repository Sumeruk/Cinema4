package com.example.cinema4.controllers;

import com.example.cinema4.entity.Film;
import com.example.cinema4.repos.FilmRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class FilmControllers {

    private final FilmRepos filmRepos;

    @GetMapping("/films")
    public String getAllSupplies(ModelMap model) {
        model.addAttribute("film", new Film());
        model.addAttribute("films", filmRepos.findAll());
        return "Films";
    }
    // todo сделать добавление
    @PostMapping("/films")
    public String saveFilm(@ModelAttribute("film") Film film) {
        filmRepos.save(film);
        return "redirect:/films";
    }

    @GetMapping("/film/film_id/{id}")
    public String getFilmInformation(ModelMap model, @PathVariable Long id) {
        model.addAttribute("filmInformation", filmRepos.findById(id).get());
        return "Film_Information";
    }



}
