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
    private Hall hall;
    private Time time_of_start;
    private Film film;
}
