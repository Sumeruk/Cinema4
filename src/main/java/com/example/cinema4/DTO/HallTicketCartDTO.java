package com.example.cinema4.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Data
public class HallTicketCartDTO {

    private List<HallTicketDTO> list = new ArrayList<>();

    public void addToCart(HallTicketDTO hallTicketDTO){
        list.add(hallTicketDTO);
    }
}
