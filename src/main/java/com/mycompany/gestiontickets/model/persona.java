
package com.mycompany.gestiontickets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class persona {
    private int id;
    private int idTipoDocumento;
    private String nroDocumento;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;   
       
    public persona(int id) {
        this.id = id;
    }   
}
