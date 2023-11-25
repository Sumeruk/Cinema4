package com.example.cinema4.controllers;

import com.example.cinema4.entity.Film;
import com.example.cinema4.entity.Ticket;
import com.example.cinema4.repos.TicketRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TicketControllers {

    private final TicketRepos ticketRepos;

    @GetMapping("/tickets")
    public String getTickets(Model model){
        model.addAttribute("newTicket", new Ticket());
        return "Tickets";
    }
    @GetMapping("/tickets/{sessionId}")
    public String getTicketsBySession(Model model, @PathVariable Integer sessionId){
        model.addAttribute("tickets", ticketRepos.findTicketsBySession_id(sessionId));
        return "Tickets";
    }

}
