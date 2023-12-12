package com.example.cinema4.controllers;

import com.example.cinema4.DTO.FilmDTO;
import com.example.cinema4.entity.Film;
import com.example.cinema4.repos.FilmRepos;
import com.example.cinema4.servicies.FilmService;
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
    private final FilmService filmService;

    @GetMapping("/films")
    public String getAllSupplies(ModelMap model) {
        model.addAttribute("film", new Film());
        model.addAttribute("films", filmRepos.findAll());
        return "Films";
    }
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

    @GetMapping("/film/delete/{id}")
    public String deleteFilmInformation( @PathVariable Long id){
        filmRepos.deleteById(id);
        System.out.println(filmRepos.findAll());
        return "redirect:/films";
    }

    @GetMapping("/film/update/{filmId}")
    public String getUpdFilm(@PathVariable("filmId") Long filmId, Model model){
        model.addAttribute("film", filmRepos.findFilmByFilm_id(filmId));
        model.addAttribute("newFilm", new FilmDTO());
        return "update_film";
    }

    @PostMapping("/film/update/{filmId}")
    public String setUpdFilm(@PathVariable("filmId") Long filmId, @ModelAttribute("newFilm") FilmDTO filmDTO){
        Film oldfilm = filmRepos.findFilmByFilm_id(filmId);
        filmService.updInformation(oldfilm, filmDTO);
        return "redirect:/film/update/{filmId}";
    }


}
