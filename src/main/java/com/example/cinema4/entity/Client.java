package com.example.cinema4.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.util.Set;

@Data
@Table("Client")
public class Client {
    @Id
    private Long client_id;
    private String name;
    private Date birthday;

    @MappedCollection(idColumn = "client_id", keyColumn = "client_id")
    private final Set<Ticket> tickets;
}
