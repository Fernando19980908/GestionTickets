package com.mycompany.gestiontickets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class rolUsuario {
    private int id;
    private String rolUsuario;

    public rolUsuario(int id) {
        this.id = id;
    }    
}
