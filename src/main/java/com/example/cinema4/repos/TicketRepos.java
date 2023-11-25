package com.example.cinema4.repos;

import com.example.cinema4.DTO.HallTicketDTO;
import com.example.cinema4.entity.Ticket;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepos extends CrudRepository<Ticket, Long> {
    @Query("SELECT * FROM public.\"Ticket\" WHERE session_id = :ses_id")
    Iterable<Ticket> findAllBySession_id(@Param("ses_id") Integer session_id);
    @Query("select num_hall, num_place, num_row, price " +
            "from \"Hall\" join \"Session\" USING(num_hall)" +
            "join \"Ticket\" USING(session_id) " +
            "WHERE session_id = :ses_id")
    Iterable<HallTicketDTO> findTicketsBySession_id(@Param("ses_id") Integer session_id);

}
