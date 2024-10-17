package com.mycompany.gestiontickets.dao;

import com.mycompany.gestiontickets.model.rolUsuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class rolUsuarioDAO {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/bdGestionTickets";
    private final String jdbcUsuario = "postgres";
    private final String jdbcContrasena = "sa";
    
    
    private static final String SELECT_ALL_ROLES = "select * from rolusuario";
    private static final String SELECT_BYID_ROL = "select * from rolusuario where id = ?";
    private static final String INSERT_ROL = "insert into rolusuario(rolusuario) values(?)";
    private static final String UPDATE_ROL = "update rolusuario set rolusuario = ? where id = ?";
    private static final String DELETE_ROL = "delete from rolusuario where id = ?";
    
    public List<rolUsuario> selectAllRoles() {
        List<rolUsuario> roles = new ArrayList<>();
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROLES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                rolUsuario rol = new rolUsuario();
                
                rol.setId(resultSet.getInt("id"));
                rol.setRolUsuario(resultSet.getString("rolusuario"));
                roles.add(rol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return roles;
    }
       
    public rolUsuario selectByRol(int id) {
        rolUsuario rol = null;
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BYID_ROL)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
                rol = new rolUsuario();
                
                rol.setId(resultSet.getInt("id"));
                rol.setRolUsuario(resultSet.getString("rolusuario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rol;
    }    
       
    public void insertRol(rolUsuario rol) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROL)) {
            preparedStatement.setString(1,rol.getRolUsuario());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void updatePersona(rolUsuario rol) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROL)) {
            preparedStatement.setString(1,rol.getRolUsuario());
                        
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void deletePersona(rolUsuario rol) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ROL)) {
            preparedStatement.setInt(1,rol.getId());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
