package com.example.cinema4.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Data
@Table("Ticket")
@Component
public class Ticket {
    @Id
    private Long ticket_id;
    private int num_place;
    private int num_row;
    private Long client_id;
    private int price;
    private Long session_id;
}
