package com.example.cinema4.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Data
@Table("Hall")
public class Hall {
    @Id
    private int num_hall;
    private int num_of_row;
    private int num_of_seat_row;

    @Override
    public String toString() {
        return "Hall{" +
                "num_hall=" + num_hall +
                ", num_of_row=" + num_of_row +
                ", num_of_seat_row=" + num_of_seat_row +
                '}';
    }

}
