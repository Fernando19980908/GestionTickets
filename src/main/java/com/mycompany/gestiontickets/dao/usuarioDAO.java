package com.mycompany.gestiontickets.dao;

import com.mycompany.gestiontickets.model.usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class usuarioDAO {
    
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/bdGestionTickets";
    private final String jdbcUsuario = "postgres";
    private final String jdbcContrasena = "sa";
    
    
    private static final String SELECT_ALL_USUARIOS = "select * from usuario";
    private static final String SELECT_BYID_USUARIO = "select * from usuario where id = ?";
    private static final String INSERT_USUARIO = "insert into usuario(idpersona,idrolusuario,idtipoespecialidad,correo,contrasena) values(?,?,?,?,?)";
    private static final String UPDATE_USUARIO = "update usuario set idpersona = ?,idrolusuario = ?,idtipoespecialidad = ?,correo = ?,contrasena = ? where id = ?";
    private static final String DELETE_USUARIO = "delete from usuario where id = ?";
    
    public List<usuario> selectAllUsuario() {
        List<usuario> usuarios = new ArrayList<>();
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USUARIOS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                usuario usuario1 = new usuario();
                
                usuario1.setId(resultSet.getInt("id"));
                usuario1.setIdPersona(resultSet.getInt("idpersona"));
                usuario1.setIdRolUsuario(resultSet.getInt("idrolusuario"));
                usuario1.setIdTipoEspecialidad(resultSet.getInt("idtipoespecialidad"));
                usuario1.setCorreo(resultSet.getString("correo"));
                usuario1.setContrasena(resultSet.getString("contrasena"));
                usuarios.add(usuario1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return usuarios;
    }
       
    public usuario selectByIdUsuario(int id) {
        usuario usuario1 = null;
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BYID_USUARIO)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
                usuario1 = new usuario();
                
                usuario1.setId(resultSet.getInt("id"));
                usuario1.setIdPersona(resultSet.getInt("idpersona"));
                usuario1.setIdRolUsuario(resultSet.getInt("idrolusuario"));
                usuario1.setIdTipoEspecialidad(resultSet.getInt("idtipoespecialidad"));
                usuario1.setCorreo(resultSet.getString("correo"));
                usuario1.setContrasena(resultSet.getString("contrasena"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return usuario1;
    }    
       
    public void insertUsuario(usuario usuario1) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USUARIO)) {
            preparedStatement.setInt(1,usuario1.getIdPersona());
            preparedStatement.setInt(2,usuario1.getIdRolUsuario());
            preparedStatement.setInt(3,usuario1.getIdTipoEspecialidad());
            preparedStatement.setString(4,usuario1.getCorreo());
            preparedStatement.setString(5,usuario1.getContrasena());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void updateUsuario(usuario usuario1) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USUARIO)) {
            preparedStatement.setInt(1,usuario1.getIdPersona());
            preparedStatement.setInt(2,usuario1.getIdRolUsuario());
            preparedStatement.setInt(3,usuario1.getIdTipoEspecialidad());
            preparedStatement.setString(4,usuario1.getCorreo());
            preparedStatement.setString(5,usuario1.getContrasena());
                        
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void deleteUsuario(usuario usuario1) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USUARIO)) {
            preparedStatement.setInt(1,usuario1.getId());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
