package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import interfaces.*;
import modelo.*;
import conexion.ConexionSingleton;
import modelo.Profesional;


public class ProfesionalDAOImpl implements IProfesionalDao {

	private Connection conexion = ConexionSingleton.conectar();
	
 
    public void insertarProfesional(Profesional profesional) {
        try {
            String sqlUsuarios = "INSERT INTO usuarios (run, nombre, fechaNac, tipo) VALUES (?, ?, ?, ?)";
            String sqlProfesionales = "INSERT INTO profesionales (run, tituloProfesional, fechaIngreso, proyecto) VALUES (?, ?, ?, ?)";
            
            conexion.setAutoCommit(false);
            
            PreparedStatement statementUsuarios = conexion.prepareStatement(sqlUsuarios);
            statementUsuarios.setInt(1, profesional.getRunUsuario());
            statementUsuarios.setString(2, profesional.getNombreUsuario());
            statementUsuarios.setString(3,  profesional.getFechaNacimientoUsuario());
            statementUsuarios.setInt(4, profesional.getTipoUsuario());
            statementUsuarios.executeUpdate();
            
            PreparedStatement statementProfesionales = conexion.prepareStatement(sqlProfesionales);
            statementProfesionales.setInt(1, profesional.getRunUsuario());
            statementProfesionales.setString(2, profesional.getTituloProfesional());
            statementProfesionales.setString(3,  profesional.getFechaIngreso());
            statementProfesionales.setString(4, profesional.getProyecto());
            statementProfesionales.executeUpdate();
            
            conexion.commit();
            conexion.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                conexion.rollback();
                conexion.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }


    public void actualizarProfesional(Profesional profesional) {
        try {
            String sqlProfesionales = "UPDATE profesionales SET tituloProfesional=?, fechaIngreso=?, proyecto=? WHERE run=?";
            String sqlUsuarios = "UPDATE usuarios SET nombre=?, fechaNac=?, tipo=? WHERE run=?";
            
            conexion.setAutoCommit(false);
            
            PreparedStatement statementProfesionales = conexion.prepareStatement(sqlProfesionales);
            statementProfesionales.setString(1, profesional.getTituloProfesional());
            statementProfesionales.setString(2,  profesional.getFechaIngreso());
            statementProfesionales.setString(3, profesional.getProyecto());
            statementProfesionales.setInt(4, profesional.getRunUsuario());
            statementProfesionales.executeUpdate();
            
            PreparedStatement statementUsuarios = conexion.prepareStatement(sqlUsuarios);
            statementUsuarios.setString(1, profesional.getNombreUsuario());
            statementUsuarios.setString(2, profesional.getFechaNacimientoUsuario());
            statementUsuarios.setInt(3, profesional.getTipoUsuario());
            statementUsuarios.setInt(4, profesional.getRunUsuario());
            statementUsuarios.executeUpdate();
            
            conexion.commit();
            conexion.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                conexion.rollback();
                conexion.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }


    public void eliminarProfesional(int run) {
        try {
            String sql = "DELETE FROM profesionales WHERE run=?; DELETE FROM usuarios WHERE run=?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, run);
            statement.setInt(2, run);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Profesional> obtenerTodosLosProfesionales() {
    	
    	String query = "SELECT p.*, u.nombre,u.fechaNac,u.tipo FROM profesionales ";
    	query += " JOIN usuarios ";
    	query += " ON p.run = u.run";
    	
        List<Profesional> listaProfesionales = new ArrayList<>();
        try (Statement statement = conexion.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Profesional profesional = new Profesional(
                		
                        resultSet.getInt("run"),
                        resultSet.getString("tituloProfesional"),
                        resultSet.getString("fechaIngreso"),
                        resultSet.getString("proyecto"),
                        resultSet.getString("nombre"),
                        resultSet.getString("fechaNac"),
                        resultSet.getInt("tipo")
                       
                );
               
                listaProfesionales.add(profesional);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProfesionales;
    }





}