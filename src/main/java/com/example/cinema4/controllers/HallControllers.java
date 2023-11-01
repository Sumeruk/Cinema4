package com.example.cinema4.controllers;

import com.example.cinema4.entity.Hall;
import com.example.cinema4.repos.HallRepos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Scanner;

@Controller
public class HallControllers {

    HallRepos hallRepos;

    @GetMapping("/halls")
    public String getAllSupplies(ModelMap model) {

        return "Hall";
    }

}
