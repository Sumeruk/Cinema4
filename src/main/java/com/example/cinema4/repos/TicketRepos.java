package com.example.cinema4.repos;

import com.example.cinema4.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepos extends CrudRepository<Ticket, Long> {
}
