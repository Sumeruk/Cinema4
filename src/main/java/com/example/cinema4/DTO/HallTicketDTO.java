package com.example.cinema4.DTO;

import lombok.Data;

@Data
public class HallTicketDTO {
    private Long num_hall;
    private Integer num_place;
    private Integer num_row;
    private Integer price;
    private Long session_id;
}
