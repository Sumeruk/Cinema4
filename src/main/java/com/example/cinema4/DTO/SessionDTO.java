package com.example.cinema4.DTO;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.stereotype.Component;

@Component
@Data
public class SessionDTO {

    private int numHall;
    private String time_of_start;
    private String film_name;
    private String date_film;
}
