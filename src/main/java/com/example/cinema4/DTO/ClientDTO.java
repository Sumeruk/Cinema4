package com.example.cinema4.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ClientDTO {
    private Long client_id;
    private String name;
    private String birthday;
}
