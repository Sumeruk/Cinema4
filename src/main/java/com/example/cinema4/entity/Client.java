package com.example.cinema4.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Data
@Table("Client")
public class Client {
    @Id
    private long client_id;
    private String name;
    private Date birthday;
}
