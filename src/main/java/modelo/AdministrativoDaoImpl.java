package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import conexion.ConexionSingleton;
import modelo.Administrativo;
import interfaces.IAdministrativoDao;


// clase llamada AdministrativoDaoImpl que implementa la interfaz IAdministrativoDao.
public class AdministrativoDaoImpl implements IAdministrativoDao {

	private Connection conexion = ConexionSingleton.conectar();
	private Connection conn;

	public AdministrativoDaoImpl() {
		conn = ConexionSingleton.conectar();
	}

	
	
 //método recibe como parámetro un objeto "Administrativo" y realiza la operación de registrar un nuevo administrativo en la base de datos.

	@Override
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
 
	//método recibe como parámetro un objeto "Administrativo" y actualiza los datos de ese administrativo en la base de datos.
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
	
	// método recibe como parámetro un entero "run" que representa el RUN del administrativo que se desea eliminar de la base de datos.

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
//método es obtener una lista de todos los administrativos registrados en la base de datos.

	@Override	
	public ArrayList<Administrativo> listaAdministrativos()throws Exception {
		String sql = "SELECT u.run,u.nombre,u.fechaNac,u.tipo,a.area,a.expPrevia,a.email FROM administrativos a";
		sql += " JOIN usuarios u";
		sql += " ON a.run = u.run";
		ArrayList<Administrativo> listaAdm = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		    	Administrativo administrativo = new Administrativo();
		    		            
	            administrativo.setRunUsuario(rs.getInt("run"));
	            administrativo.setNombreUsuario(rs.getString("nombre"));
	            administrativo.setFechaNacimientoUsuario(rs.getString("fechaNac"));
	            administrativo.setTipoUsuario(rs.getInt("tipo")); 
	            administrativo.setArea(rs.getString("area"));
	            administrativo.setExpPrevia(rs.getString("expPrevia"));
	            administrativo.setEmail(rs.getString("email"));
	            listaAdm.add(administrativo);
	            System.out.println(administrativo);
	            
	        }
	        rs.close();
	    } catch(Exception e) {
	        throw e;
	    }
	    return listaAdm;
	}



	@Override
	public Administrativo obtenerAdministrativoPorId(int id) {
		String sql = "SELECT u.run,u.nombre,u.fechaNac,u.tipo,a.area,a.expPrevia,a.email FROM administrativos a JOIN usuarios u ON a.run = u.run WHERE u.run =?;"; 
        
		Administrativo administrativo = new Administrativo();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				administrativo.setRunUsuario(rs.getInt("run"));
				administrativo.setNombreUsuario(rs.getString("nombre"));
				administrativo.setFechaNacimientoUsuario(rs.getString("fechaNac"));
				administrativo.setTipoUsuario(rs.getInt("tipo"));
				administrativo.setArea(rs.getString("area"));
	            administrativo.setExpPrevia(rs.getString("expPrevia"));
	            administrativo.setEmail(rs.getString("email"));        
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return administrativo;
		
	}
		
}




