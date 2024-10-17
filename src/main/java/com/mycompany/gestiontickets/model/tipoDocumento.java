package com.mycompany.gestiontickets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class tipoDocumento {
    private int id;
    private String tipoDocumento;   
     
    public tipoDocumento(int id) {
        this.id = id;
    }    
} 
