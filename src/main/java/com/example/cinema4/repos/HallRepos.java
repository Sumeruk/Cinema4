package com.example.cinema4.repos;

import com.example.cinema4.entity.Hall;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface HallRepos extends CrudRepository<Hall,Integer> {
    @Query("SELECT num_hall from \"Hall\" ")
    List<Integer> findNum_hall();
}
