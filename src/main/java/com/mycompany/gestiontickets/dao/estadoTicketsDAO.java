package com.mycompany.gestiontickets.dao;

import com.mycompany.gestiontickets.model.estadoTickets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class estadoTicketsDAO {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/bdGestionTickets";
    private final String jdbcUsuario = "postgres";
    private final String jdbcContrasena = "sa";
    
    
    private static final String SELECT_ALL_ESTADO_TICKETS = "select * from estadoTickets";
    private static final String SELECT_BYPATTERN_ESTADO_TICKETS = "select * from estadoTickets where estadoTicket like ?";
    private static final String SELECT_BYID_ESTADO_TICKETS = "select * from estadoTickets where id = ?";
    private static final String INSERT_ESTADO_TICKETS = "insert into estadoTickets(estadoTicket) values(?)";
    private static final String UPDATE_ESTADO_TICKETS = "update estadoTickets set estadoTicket = ? where id = ?";
    private static final String DELETE_ESTADO_TICKETS = "delete from estadoTickets where id = ?";
    
    public List<estadoTickets> selectAllEstadoTickets() {
        List<estadoTickets> estadoTickets1 = new ArrayList<>();
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ESTADO_TICKETS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                estadoTickets estadoTickets = new estadoTickets();
                
                estadoTickets.setId(resultSet.getInt("id"));
                estadoTickets.setEstadoTicket(resultSet.getString("estadoTicket"));
                
                estadoTickets1.add(estadoTickets);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return estadoTickets1;
    }    
       
    public estadoTickets selectByIdEstadoTicket(int id) {
        estadoTickets estadoTicket = null;
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BYID_ESTADO_TICKETS)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
                estadoTicket = new estadoTickets();
                
                estadoTicket.setId(resultSet.getInt("id"));
                estadoTicket.setEstadoTicket(resultSet.getString("estadoTicket"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return estadoTicket;
    }    
       
    public void insertEstadoTicket(estadoTickets estadoTicket) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ESTADO_TICKETS)) {
            preparedStatement.setString(1,estadoTicket.getEstadoTicket());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void updateEstadoTicket(estadoTickets estadTicket) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ESTADO_TICKETS)) {
            preparedStatement.setString(1,estadTicket.getEstadoTicket());
            preparedStatement.setInt(2,estadTicket.getId());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void deleteEstadoTicket(estadoTickets estadoTicket) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ESTADO_TICKETS)) {
            preparedStatement.setInt(1,estadoTicket.getId());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
