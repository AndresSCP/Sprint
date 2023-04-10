package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import conexion.ConexionSingleton;
import interfaces.IAdministrativoDao;
import modelo.Administrativo;

public class AdministrativoDaoImpl implements IAdministrativoDao {

	private Connection conexion = ConexionSingleton.conectar();

	public void registrarAdministrativo(Administrativo administrativo) {
		try {
			String sqlUsuarios = "INSERT INTO usuarios (run, nombre, fechaNac, tipo) VALUES (?, ?, ?, ?)";
			String sqlAdministrativos = "INSERT INTO administrativos ( area, exPrevia, email) VALUES (?, ?, ?, ?)";
			PreparedStatement statementUsuarios = conexion.prepareStatement(sqlUsuarios);
			statementUsuarios.setInt(1, administrativo.getRunUsuario());
			statementUsuarios.setString(2, administrativo.getNombreUsuario());
			statementUsuarios.setString(3, administrativo.getFechaNacimientoUsuario());
			statementUsuarios.setInt(4, administrativo.getTipoUsuario());
			statementUsuarios.executeUpdate();

			PreparedStatement statementAdministrativos = conexion.prepareStatement(sqlAdministrativos);
			statementAdministrativos.setString(1, administrativo.getArea());
			statementAdministrativos.setString(2, administrativo.getExpPrevia());
			statementAdministrativos.setString(3, administrativo.getEmail());
			statementAdministrativos.executeUpdate();

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

	@Override
	public void actualizarAdministrativo(Administrativo administrativo) {
		try {
			String sqlUsuarios = "UPDATE usuarios SET nombre=?, fechaNac=?, tipo=? WHERE run=?";
			String sqlAdministrativos = "UPDATE administrativos SET area=?, exprevia=?, email=? WHERE run=?";

			conexion.setAutoCommit(false);

			PreparedStatement statementUsuarios = conexion.prepareStatement(sqlUsuarios);
			statementUsuarios.setInt(1, administrativo.getRunUsuario());
			statementUsuarios.setString(2, administrativo.getNombreUsuario());
			statementUsuarios.setString(3, administrativo.getFechaNacimientoUsuario());
			statementUsuarios.setInt(4, administrativo.getTipoUsuario());
			statementUsuarios.executeUpdate();

			PreparedStatement statementAdministrativos = conexion.prepareStatement(sqlAdministrativos);

			statementAdministrativos.setString(1, administrativo.getArea());
			statementAdministrativos.setString(2, administrativo.getExpPrevia());
			statementAdministrativos.setString(3, administrativo.getEmail());
			statementAdministrativos.executeUpdate();

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

	@Override
	public void eliminarAdministrativo(int run) {
		try {
			String sql = "DELETE FROM administrativos WHERE run=?; DELETE FROM usuarios WHERE run=?";
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setInt(1, run);
			statement.setInt(2, run);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Administrativo> obtenerAdministrativos() {

	    String query = "SELECT a.*, u.nombre,u.fechaNac,u.tipo FROM administrativos a";
	    query += " JOIN usuarios u";
	    query += " ON a.run = u.run";

	    List<Administrativo> listaAdministrativos = new ArrayList<>();

	    try (Statement statement = conexion.createStatement()) {
	        ResultSet resultSet = statement.executeQuery(query);
	        while (resultSet.next()) {
	        	Administrativo administrativo = new Administrativo (
	            		
	                resultSet.getInt("run"),
	                resultSet.getString("nombre"),
	                resultSet.getString("fechaNac"),
	                resultSet.getInt("tipo"),
	                resultSet.getString("area"),
	                resultSet.getString("exPrevia"),
	                resultSet.getString("email")                       
	            );
	            listaAdministrativos.add(administrativo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listaAdministrativos;
	}

//	@Override
//	public Administrativo obtenerAdministrativoPorId(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
