package com.example.cinema4.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Time;
import java.util.List;

@Data
@Table("Session")
public class Session {
    @Id
    private long session_id;
    @MappedCollection(idColumn = "num_hall", keyColumn = "num_hall")
    private List<Hall> halls;
    private Time time_of_start;
    @MappedCollection(idColumn = "film_id", keyColumn = "film_id")
    private List<Film> films;
}
