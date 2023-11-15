package com.example.cinema4.controllers;

import com.example.cinema4.repos.TicketRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TicketControllers {

    private final TicketRepos ticketRepos;

    @GetMapping("/tickets")
    public String getTickets(){
        return "Tickets";
    }
// todo сделать красивую табличку
    @PostMapping("/ticketsBySessions")
    public String getTicketsBySession(Model model, @RequestParam("session_id") Integer session_id){
        model.addAttribute("tickets", ticketRepos.findAllBySession_id(session_id));
        return "Tickets";
    }
}
