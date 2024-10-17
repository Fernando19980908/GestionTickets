package com.mycompany.gestiontickets.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class usuario {    
    private int id;
    private int idPersona;
    private int idRolUsuario;
    private int idTipoEspecialidad;
    private String correo;
    private String contrasena;   
       
    public usuario(int id) {
        this.id = id;
    }   
}
