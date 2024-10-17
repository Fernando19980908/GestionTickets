package com.mycompany.gestiontickets.model;

import java.sql.Timestamp;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ticket {
    private int id;
    private int idpersona;
    private int idEstadoTicket;
    private int nroTicket;
    private Timestamp fechaHoraTicket;
    private Timestamp horaInicioAtencion;
    private Timestamp horaTerminoAtencion;    
       
    public ticket(int id) {
        this.id = id;
    }      
}
