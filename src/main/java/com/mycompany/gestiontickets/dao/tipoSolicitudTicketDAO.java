package com.mycompany.gestiontickets.dao;

import com.mycompany.gestiontickets.model.tipoSolicitudTicket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class tipoSolicitudTicketDAO {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/bdGestionTickets";
    private final String jdbcUsuario = "postgres";
    private final String jdbcContrasena = "sa";
        
    private static final String SELECT_ALL_TIPO_SOLICITUD = "select * from tipoSolicitudTicket";
    private static final String SELECT_BYID_TIPO_SOLICITUD = "select * from tipoSolicitudTicket where id = ?";
    private static final String INSERT_TIPO_SOLICITUD = "insert into tipoSolicitudTicket(idticket, idespecialidad) values(?,?)";
    private static final String UPDATE_TIPO_SOLICITUD = "update tipoSolicitudTicket set idticket = ?, idespecialidad = ? where id = ?";
    private static final String DELETE_TIPO_SOLICITUD = "delete from tipoSolicitudTicket where id = ?";
    
    public List<tipoSolicitudTicket> selectAllTipoSolicitudTicket() {
        List<tipoSolicitudTicket> TiposSolicitudesTicket = new ArrayList<>();
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TIPO_SOLICITUD)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                tipoSolicitudTicket TipoSolicitudTicket = new tipoSolicitudTicket();
                
                TipoSolicitudTicket.setId(resultSet.getInt("id"));
                TipoSolicitudTicket.setIdTicket(resultSet.getInt("idticket"));
                TipoSolicitudTicket.setIdEspecialidad(resultSet.getInt("idespecialidad"));
                
                TiposSolicitudesTicket.add(TipoSolicitudTicket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return TiposSolicitudesTicket;
    }
       
    public tipoSolicitudTicket selectByTipoSolicitudTicket(int id) {
        tipoSolicitudTicket TipoSolicitudTicket = null;
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BYID_TIPO_SOLICITUD)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
                TipoSolicitudTicket = new tipoSolicitudTicket();
                
                TipoSolicitudTicket.setId(resultSet.getInt("id"));
                TipoSolicitudTicket.setIdEspecialidad(resultSet.getInt("idticket"));
                TipoSolicitudTicket.setIdTicket(resultSet.getInt("idespecialidad"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return TipoSolicitudTicket;
    }    
       
    public void insertTipoSolicitudTicket(tipoSolicitudTicket TipoSolicitudTicket) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TIPO_SOLICITUD)) {
            preparedStatement.setInt(1,TipoSolicitudTicket.getIdTicket());
            preparedStatement.setInt(2,TipoSolicitudTicket.getIdEspecialidad());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void updateTipoSolicitudTicket(tipoSolicitudTicket TipoSolicitudTicket) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TIPO_SOLICITUD)) {
            preparedStatement.setInt(1,TipoSolicitudTicket.getIdTicket());
            preparedStatement.setInt(2,TipoSolicitudTicket.getIdEspecialidad());
                        
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void deleteTipoSolicitudTicket(tipoSolicitudTicket TipoSolicitudTicket) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TIPO_SOLICITUD)) {
            preparedStatement.setInt(1,TipoSolicitudTicket.getId());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
