package com.example.cinema4.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Data
@Table("Session")
public class Session {
    @Id
    private Long session_id;
    @Column("num_hall")
    private int numHall;
    private Time time_of_start;
    @Column("film_id")
    private Long filmId;
    private Date date_film;


    public Session(int numHall, Time time_of_start, Long filmId, Date date_film) {
        this.numHall = numHall;
        this.time_of_start = time_of_start;
        this.filmId = filmId;
        this.date_film = date_film;
    }
}
