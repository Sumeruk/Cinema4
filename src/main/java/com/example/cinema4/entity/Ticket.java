package com.example.cinema4.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@Table("Ticket")
public class Ticket {
    @Id
    private long ticket_id;
    private int num_place;
    private int num_row;
    private Client client;
    private int price;
    private Session session;
}
