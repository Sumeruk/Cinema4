package com.example.cinema4.DTO;

import com.example.cinema4.entity.Film;
import lombok.Data;

@Data
public class FilmDTO {
    private String name_film;
    private Integer age_limit;
    private Integer duration;
    private String genre;
}
