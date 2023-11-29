package com.example.cinema4.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Data
@Table("Hall")
public class Hall {
    @Id
    private Long num_hall;
    private int num_of_row;
    private int num_of_seat_row;

//    @MappedCollection(idColumn = "num_hall", keyColumn = "numHall")
//    private final Set<Session> sessions;

    @Override
    public String toString() {
        return "Hall{" +
                "num_hall=" + num_hall +
                ", num_of_row=" + num_of_row +
                ", num_of_seat_row=" + num_of_seat_row +
                '}';
    }

}
