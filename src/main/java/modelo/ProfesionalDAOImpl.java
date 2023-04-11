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

// Clase que implementa la interfaz IProfesionalDao
public class ProfesionalDAOImpl implements IProfesionalDao {

// código que está inicializando la variable de instancia conexion con una conexión a la base de datos utilizando el patrón Singleton.
	private Connection conexion = ConexionSingleton.conectar();
	
 
//método insertarProfesional se utiliza para insertar un objeto Profesional en dos tablas diferentes de una base de datos y maneja la transacción de forma segura para evitar errores.
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

// método actualizarProfesional de una clase ProfesionalDAOImpl. Este método actualiza la información de un profesional en la base de datos.
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

//Este código corresponde al método eliminarProfesional de una clase ProfesionalDAOImpl. Este método elimina un profesional de la base de datos, dado su número de RUN.
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
    
   //  método obtenerTodosLosProfesionales(), que recupera todos los registros de la tabla profesionales y la tabla usuarios relacionada por la columna run.
    public  List obtenerTodosLosProfesionales() throws Exception {
    	
    	String query = "SELECT p.*, u.nombre,u.fechaNac,u.tipo FROM profesionales p ";
    	query += " JOIN usuarios u ";
    	query += " ON p.run = u.run";
    // Array objetos Profesional llamada listaProfesionales.
        List listaProfesionales = new ArrayList<>();
        try (Statement statement = conexion.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            
    //Dentro del ciclo while, se recuperan los valores de cada columna de la fila actual del ResultSet, se utilizan para crear una instancia de un objeto Profesional, que se agrega a la lista listaProfesionales.
            while (resultSet.next()) {
                Object[] profesional = new Object[]{
                    resultSet.getInt("run"),
                    resultSet.getString("tituloProfesional"),
                    resultSet.getString("fechaIngreso"),
                    resultSet.getString("proyecto"),
                    resultSet.getString("nombre"),
                    resultSet.getString("fechaNac"),
                    resultSet.getInt("tipo")
                };

                listaProfesionales.add(profesional);
            }
            resultSet.close();
           
        } catch(Exception e) {
	        throw e;
	    }
        return listaProfesionales;
    }
    public  List DatosProfesional(int run) throws Exception {
    	
    	String query = "SELECT p.*, u.nombre,u.fechaNac,u.tipo FROM profesionales p WHERE run=?";
    	query += " JOIN usuarios u ";
    	query += " ON p.run = u.run";
    // Array objetos Profesional llamada listaProfesionales.
        List datosProfesional = new ArrayList<>();
        try (Statement statement = conexion.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            
    //Dentro del ciclo while, se recuperan los valores de cada columna de la fila actual del ResultSet, se utilizan para crear una instancia de un objeto Profesional, que se agrega a la lista listaProfesionales.
            while (resultSet.next()) {
                Object[] profesional = new Object[]{
                    resultSet.getInt("run"),
                    resultSet.getString("tituloProfesional"),
                    resultSet.getString("fechaIngreso"),
                    resultSet.getString("proyecto"),
                    resultSet.getString("nombre"),
                    resultSet.getString("fechaNac"),
                    resultSet.getInt("tipo")
                };

                datosProfesional.add(profesional);
            }
            resultSet.close();
           
        } catch(Exception e) {
	        throw e;
	    }
        return datosProfesional;
    }



}