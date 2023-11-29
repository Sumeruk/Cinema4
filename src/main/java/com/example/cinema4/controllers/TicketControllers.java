package com.example.cinema4.controllers;

import com.example.cinema4.DTO.HallTicketDTO;
import com.example.cinema4.DTO.SessionDTO;
import com.example.cinema4.entity.Film;
import com.example.cinema4.entity.Ticket;
import com.example.cinema4.repos.TicketRepos;
import com.example.cinema4.servicies.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class TicketControllers {

    private final TicketRepos ticketRepos;
    private final TicketService ticketService;
    private List<HallTicketDTO> hallTicketDTOS;
    private Map<Integer, List<Integer>> freeSeats;

    @GetMapping("/tickets")
    public String getTickets(Model model){
        model.addAttribute("newTicket", new HallTicketDTO());

        return "Tickets";
    }
    @GetMapping("/tickets/{sessionId}")
    public String getTicketsBySession(Model model, @PathVariable Integer sessionId){
        hallTicketDTOS = ticketRepos.findTicketsBySession_id(sessionId);

        model.addAttribute("tickets", hallTicketDTOS);

        freeSeats = ticketService.getFreeSeats(hallTicketDTOS);

        model.addAttribute("keys", freeSeats.keySet());
        model.addAttribute("values", new ArrayList<>());
        return "Tickets";
    }

    @PostMapping("/tickets/{sessionId}/saveTicket")
    public String saveTickets(Model model, @PathVariable Integer sessionId,
                              @RequestParam("num_place") Integer selectedKey){
        System.out.println("метод работает");
        return "Tickets";
    }
   // @ModelAttribute("tickets") List<HallTicketDTO> hallTicketDTOList

}
