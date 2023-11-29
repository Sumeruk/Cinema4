package com.example.cinema4.DTO;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.sql.Time;

@Data
public class FilmSessionDTO {
    private String name_film;
    private Long session_id;
    private Time time_of_start;
    private Date date_film;



}
