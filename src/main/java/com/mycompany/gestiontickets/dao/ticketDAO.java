package com.mycompany.gestiontickets.dao;

import com.mycompany.gestiontickets.model.ticket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ticketDAO {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/bdGestionTickets";
    private final String jdbcUsuario = "postgres";
    private final String jdbcContrasena = "sa";
    
    
    private static final String SELECT_ALL_TICKET = "select * from ticket";
    private static final String SELECT_BYID_TICKET = "select * from ticket where id = ?";
    private static final String INSERT_TICKET = "insert into ticket(idpersona,nroticket,fechahoraticket,horainicioatencion,horaterminoatencion,idEstadoTicket) values(?,?,?,?,?,?)";
    private static final String UPDATE_TICKET = "update ticket set idpersona = ?,nroticket = ?,fechahoraticket = ?,horainicioatencion = ?,horaterminoatencion = ?,idEstadoTicket = ? where id = ?";
    private static final String DELETE_TICKET = "delete from ticket where id = ?";
    
    public List<ticket> selectAllTickets() {
        List<ticket> tickets = new ArrayList<>();
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TICKET)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                ticket ticket1 = new ticket();
                
                ticket1.setId(resultSet.getInt("id"));
                ticket1.setIdpersona(resultSet.getInt("idpersona"));
                ticket1.setNroTicket(resultSet.getInt("nroticket"));
                ticket1.setFechaHoraTicket(resultSet.getTimestamp("fechahoraticket"));
                ticket1.setHoraInicioAtencion(resultSet.getTimestamp("horainicioatencion"));
                ticket1.setHoraTerminoAtencion(resultSet.getTimestamp("horaterminoatencion"));
                tickets.add(ticket1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return tickets;
    }
       
    public ticket selectByIdTicket(int id) {
        ticket ticket1 = null;
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BYID_TICKET)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
                ticket1 = new ticket();
                
                ticket1.setId(resultSet.getInt("id"));
                ticket1.setIdpersona(resultSet.getInt("idpersona"));
                ticket1.setNroTicket(resultSet.getInt("nroticket"));
                ticket1.setFechaHoraTicket(resultSet.getTimestamp("fechahoraticket"));
                ticket1.setHoraInicioAtencion(resultSet.getTimestamp("horainicioatencion"));
                ticket1.setHoraTerminoAtencion(resultSet.getTimestamp("horaterminoatencion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ticket1;
    }    
       
    public void insertTicket(ticket ticket1) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TICKET)) {
            preparedStatement.setInt(1,ticket1.getIdpersona());
            preparedStatement.setInt(2,ticket1.getNroTicket());
            preparedStatement.setTimestamp(3,ticket1.getFechaHoraTicket());
            preparedStatement.setTimestamp(4,ticket1.getHoraInicioAtencion());
            preparedStatement.setTimestamp(5,ticket1.getHoraTerminoAtencion());
            preparedStatement.setInt(6,ticket1.getIdEstadoTicket());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void updateTicket(ticket ticket1) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TICKET)) {
            preparedStatement.setInt(1,ticket1.getIdpersona());
            preparedStatement.setInt(2,ticket1.getNroTicket());
            preparedStatement.setTimestamp(3,ticket1.getFechaHoraTicket());
            preparedStatement.setTimestamp(4,ticket1.getHoraInicioAtencion());
            preparedStatement.setTimestamp(5,ticket1.getHoraTerminoAtencion());
            preparedStatement.setInt(6,ticket1.getIdEstadoTicket());
                        
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void deleteTicket(ticket ticket1) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TICKET)) {
            preparedStatement.setInt(1,ticket1.getId());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
