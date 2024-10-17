package com.mycompany.gestiontickets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class tipoSolicitudTicket {
    private int id;
    private int idTicket;
    private int idEspecialidad;

    public tipoSolicitudTicket(int id) {
        this.id = id;
    }
}
