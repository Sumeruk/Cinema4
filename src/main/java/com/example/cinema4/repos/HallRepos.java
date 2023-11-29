package com.example.cinema4.repos;

import com.example.cinema4.entity.Hall;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface HallRepos extends CrudRepository<Hall,Integer> {
    @Query("SELECT num_hall from \"Hall\" ")
    List<Integer> findNum_hall();
    @Query("SELECT num_of_seat_row from \"Hall\" WHERE num_hall = :num")
    Integer findNum_of_seat_rowByNum_hall(@Param("num") Long num_hall);
    @Query("SELECT num_of_row from \"Hall\" WHERE num_hall = :num")
    Integer findNum_of_rowByNum_hall(@Param("num") Long num_hall);

    @Query("SELECT num_place FROM \"Hall\" JOIN \"Session\" USING(num_hall) " +
            "JOIN \"Ticket\" USING(session_id) " +
            "WHERE num_row = :num_row AND num_hall = :num_hall AND session_id = :session")
    List<Integer> findOccupiedSeatsInRow(@Param("num_row") int num_row, @Param("num_hall") Long num_hall,
                                         @Param("session") Long session_id);
}
