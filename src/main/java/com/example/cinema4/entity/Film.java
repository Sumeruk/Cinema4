package com.example.cinema4.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Data
@Table("Film")
public class Film {
    @Id
    private long film_id;
    private String name_film;
    private int age_limit;
    private int duration;
    private String genre;


}
