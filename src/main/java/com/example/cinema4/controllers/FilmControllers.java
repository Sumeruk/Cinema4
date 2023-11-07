package com.example.cinema4.controllers;

import com.example.cinema4.entity.Film;
import com.example.cinema4.repos.FilmRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class FilmControllers {
//    @Autowired
    private final FilmRepos filmRepos;

    @GetMapping("/films")
    public String getAllSupplies(ModelMap model) {
        model.addAttribute("films", filmRepos.findAll());
        return "Films";
    }

    @GetMapping("/film/film_id/{id}")
    public String getFilmInformation(ModelMap model, @PathVariable Long id){
        model.addAttribute("filmInformation", filmRepos.findById(id).get());
        return "Film_Information";
    }
}
