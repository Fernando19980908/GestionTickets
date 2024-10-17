package com.mycompany.gestiontickets.dao;

import com.mycompany.gestiontickets.model.tipoDocumento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class tipoDocumentoDAO {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/bdGestionTickets";
    private final String jdbcUsuario = "postgres";
    private final String jdbcContrasena = "sa";
        
    private static final String SELECT_ALL_TIPOS_DOCUMENTO = "select * from tipodocumento";
    private static final String SELECT_BYID_TIPO_DOCUMENTO = "select * from tipodocumento where id = ?";
    private static final String INSERT_TIPO_DOCUMENTO = "insert into tipodocumento(nombretipodocumento) values(?)";
    private static final String UPDATE_TIPO_DOCUMENTO = "update tipodocumento set nombretipodocumento = ? where id = ?";
    private static final String DELETE_TIPO_DOCUMENTO = "delete from tipodocumento where id = ?";
    
    public List<tipoDocumento> selectAllTiposDocumento() {
        List<tipoDocumento> tiposDocumento = new ArrayList<>();
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TIPOS_DOCUMENTO)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                tipoDocumento tipoDocumento = new tipoDocumento();
                
                tipoDocumento.setId(resultSet.getInt("id"));
                tipoDocumento.setTipoDocumento(resultSet.getString("nombretipodocumento"));
                
                tiposDocumento.add(tipoDocumento);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return tiposDocumento;
    }
       
    public tipoDocumento selectByTipoDocumento(int id) {
        tipoDocumento tiposDocumento = null;
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BYID_TIPO_DOCUMENTO)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
                tiposDocumento = new tipoDocumento();
                
                tiposDocumento.setId(resultSet.getInt("id"));
                tiposDocumento.setTipoDocumento(resultSet.getString("nombretipodocumento"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return tiposDocumento;
    }    
       
    public void insertTipoDocumento(tipoDocumento tipoDocumento) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TIPO_DOCUMENTO)) {
            preparedStatement.setString(1,tipoDocumento.getTipoDocumento());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void updateTipoDocumento(tipoDocumento TipoDocumento) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TIPO_DOCUMENTO)) {
            preparedStatement.setString(1,TipoDocumento.getTipoDocumento());
                        
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void deletePersona(tipoDocumento TipoDocumento) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TIPO_DOCUMENTO)) {
            preparedStatement.setInt(1,TipoDocumento.getId());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
