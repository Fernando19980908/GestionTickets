package com.mycompany.gestiontickets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class estadoTickets {
    private int id;
    private String estadoTicket;   
    

    public estadoTickets(int id) {
        this.id = id;
    }    
}
