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
    private Long ticket_id;
    private int num_place;
    private int num_row;
    private int client_id;
    private int price;
    private int session_id;
}
