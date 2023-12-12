package com.example.cinema4.servicies;

import com.example.cinema4.DTO.FilmDTO;
import com.example.cinema4.entity.Film;
import com.example.cinema4.repos.FilmRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class FilmService {
    private final FilmRepos filmRepos;

    public void updInformation(Film film, FilmDTO filmDTO) {

        if (!Objects.equals(filmDTO.getName_film(), "")) {
            film.setName_film(filmDTO.getName_film());
        }

        if (filmDTO.getAge_limit() != -1){
            film.setAge_limit(filmDTO.getAge_limit());
        }

        if (filmDTO.getDuration() != null){
            film.setDuration(filmDTO.getDuration());
        }

        if(!Objects.equals(filmDTO.getGenre(), "")){
            film.setGenre(filmDTO.getGenre());
        }

        filmRepos.save(film);
    }
}
