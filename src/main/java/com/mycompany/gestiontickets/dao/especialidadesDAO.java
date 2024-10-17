package com.mycompany.gestiontickets.dao;

import com.mycompany.gestiontickets.model.especialidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class especialidadesDAO {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/bdGestionTickets";
    private final String jdbcUsuario = "postgres";
    private final String jdbcContrasena = "sa";
    
    
    private static final String SELECT_ALL_ESPECIALIDADES = "select * from especialidades";
    private static final String SELECT_BYPATTERN_ESPECIALIDADES = "select * from especialidades where tipoespecialidad like ?";
    private static final String SELECT_BYID_ESPECIALIDADES = "select * from especialidades where id = ?";
    private static final String INSERT_ESPECIALIDAD = "insert into especialidades(tipoespecialidad) values(?)";
    private static final String UPDATE_ESPECIALIDAD = "update especialidades set tipoespecialidad = ? where id = ?";
    private static final String DELETE_ESPECIALIDAD = "delete from especialidades where id = ?";
    
    public List<especialidades> selectAllEspecialidades() {
        List<especialidades> especialidades1 = new ArrayList<>();
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ESPECIALIDADES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                especialidades especialidad = new especialidades();
                
                especialidad.setId(resultSet.getInt("id"));
                especialidad.setTipoEspecialidad(resultSet.getString("tipoespecialidad"));
                
                especialidades1.add(especialidad);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return especialidades1;
    }    
    
    public List<especialidades> selectByPatternEspecialidades(String patron) {
        List<especialidades> especialidad = new ArrayList<>();
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BYPATTERN_ESPECIALIDADES)) {
            preparedStatement.setString(1,"%" + patron + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                especialidades especialidad1 = new especialidades();
                
                especialidad1.setId(resultSet.getInt("id"));
                especialidad1.setTipoEspecialidad(resultSet.getString("tipoespecialidad"));
                
                especialidad.add(especialidad1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return especialidad;
    }    
       
    public especialidades selectByIdEspecialidades(int idEspecialidad) {
        especialidades especialidad = null;
     
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BYID_ESPECIALIDADES)) {
            preparedStatement.setInt(1,idEspecialidad);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
                especialidad = new especialidades();
                
                especialidad.setId(resultSet.getInt("id"));
                especialidad.setTipoEspecialidad(resultSet.getString("tipoespecialidad"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return especialidad;
    }    
       
    public void insertEspecialidad(especialidades especialidad) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ESPECIALIDAD)) {
            preparedStatement.setString(1,especialidad.getTipoEspecialidad());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void updateEspecialidad(especialidades especialidad) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ESPECIALIDAD)) {
            preparedStatement.setString(1,especialidad.getTipoEspecialidad());
            preparedStatement.setInt(2,especialidad.getId());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public void deleteEspecialidad(especialidades especialidad) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        
        try(Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsuario,jdbcContrasena);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ESPECIALIDAD)) {
            preparedStatement.setInt(1,especialidad.getId());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
