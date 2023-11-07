package com.example.cinema4.repos;

import com.example.cinema4.entity.Hall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface HallRepos extends CrudRepository<Hall,Integer> {
}
