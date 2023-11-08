package com.example.cinema4.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Time;
import java.util.List;
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
    private int filmId;

    @MappedCollection(idColumn = "session_id", keyColumn = "session_id")
    private final Set<Ticket> tickets;
}
