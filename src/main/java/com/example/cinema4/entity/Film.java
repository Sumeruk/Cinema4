package com.example.cinema4.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Data
@Table("Film")
public class Film {
    @Id
    private Long film_id;
    private String name_film;
    private int age_limit;
    private int duration;
    private String genre;

    @MappedCollection(idColumn = "film_id", keyColumn = "filmId")
    private Set<Session> sessions;


}
