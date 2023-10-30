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
    @MappedCollection(idColumn = "client_id", keyColumn = "client_id")
    private List<Client> clients;
    private int price;
    @MappedCollection(idColumn = "session_id", keyColumn = "session_id")
    private List<Session> sessions;
}
