package com.example.cinema4.controllers;

import com.example.cinema4.repos.HallRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HallControllers {

    private final HallRepos hallRepos;

//    public HallControllers(HallRepos hallRepos) {
//        this.hallRepos = hallRepos;
//    }

    @GetMapping("/halls")
    public String getAllSupplies(ModelMap model) {
        model.addAttribute("hallInformation", hallRepos.findAll());
        return "Hall";
    }

}
