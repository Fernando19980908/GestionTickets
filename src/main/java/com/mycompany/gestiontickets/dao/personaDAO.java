package com.mycompany.gestiontickets.dao;

import com.mycompany.gestiontickets.model.persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class personaDAO {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/bdGestionTickets";
    private final String jdbcUsuario = "postgres";
    private final String jdbcContrasena = "sa";
    
    
    private static final String SELECT_ALL_PERSONAS = "select * from persona";
    private static final String SELECT_BYID_PERSONA = "select * from persona where id = ?";
    private static final String INSERT_PERSONA = "insert into persona(idtipodocumento,nrodocumento,nombres,apellidoPaterno,apellidoMaterno) values(?,?,?,?,?)";
    private static final String UPDATE_PERSONA = "update persona set idtipodocumento = ?,nrodocumento = ?,nombres = ?,apellidoPaterno = ?,apellidoMaterno = ? where id = ?";
    private static final String DELETE_PERSONA = "delete from persona where id = ?";
    
    public List<persona> selectAllPersonas() {
        List<persona> personas = new ArrayList<>();
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PERSONAS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                persona persona1 = new persona();
                
                persona1.setId(resultSet.getInt("id"));
                persona1.setIdTipoDocumento(resultSet.getInt("idtipodocumento"));
                persona1.setNroDocumento(resultSet.getString("nrodocumento"));
                persona1.setNombres(resultSet.getString("nombres"));
                persona1.setApellidoPaterno(resultSet.getString("apellidoPaterno"));
                persona1.setApellidoMaterno(resultSet.getString("apellidoMaterno"));
                personas.add(persona1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return personas;
    }
       
    public persona selectByIdEstadoTicket(int id) {
        persona persona1 = null;
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BYID_PERSONA)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
                persona1 = new persona();
                
                persona1.setId(resultSet.getInt("id"));
                persona1.setIdTipoDocumento(resultSet.getInt("idtipodocumento"));
                persona1.setNroDocumento(resultSet.getString("nrodocumento"));
                persona1.setNombres(resultSet.getString("nombres"));
                persona1.setApellidoPaterno(resultSet.getString("apellidoPaterno"));
                persona1.setApellidoMaterno(resultSet.getString("apellidoMaterno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return persona1;
    }    
       
    public void insertPersona(persona persona1) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSONA)) {
            preparedStatement.setInt(1,persona1.getIdTipoDocumento());
            preparedStatement.setString(2,persona1.getNroDocumento());
            preparedStatement.setString(3,persona1.getNombres());
            preparedStatement.setString(4,persona1.getApellidoPaterno());
            preparedStatement.setString(5,persona1.getApellidoMaterno());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void updatePersona(persona persona1) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PERSONA)) {
            preparedStatement.setInt(1,persona1.getIdTipoDocumento());
            preparedStatement.setString(2,persona1.getNroDocumento());
            preparedStatement.setString(3,persona1.getNombres());
            preparedStatement.setString(4,persona1.getApellidoPaterno());
            preparedStatement.setString(5,persona1.getApellidoMaterno());
                        
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void deletePersona(persona persona1) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PERSONA)) {
            preparedStatement.setInt(1,persona1.getId());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
