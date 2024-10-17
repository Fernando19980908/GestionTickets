package com.mycompany.gestiontickets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class especialidades {
    private int id;
    private String tipoEspecialidad;

    public especialidades(int id) {
        this.id = id;
    }
} 
