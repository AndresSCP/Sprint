package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionSingleton;
import interfaces.ICapacitacionDao;

// clase CapacitacionDaoImpl que implementa la interfaz ICapacitacionDao. 
public class CapacitacionDaoImpl implements ICapacitacionDao{

	private Connection conexion = ConexionSingleton.conectar();
	List<Capacitacion> capacitacion;

	//hacer la conexion , ejecutar la query, obtener los objetos del resultset

	
 //Este método implementa el método de la interfaz ICapacitacionDao para registrar una capacitación en la base de datos.
	@Override
	public boolean registrar(Capacitacion capacitacion) {
	    String sql = "INSERT INTO capacitacion (capfecha,caphora,caplugar,capduracion,Cliente_rutcliente,capNombre,capAsistentes) VALUES (?,?,?,?,?,?,?)";
	    try {
	        PreparedStatement ps = conexion.prepareStatement(sql);
	        ps.setString(1, capacitacion.getDia());
	        ps.setString(2, capacitacion.getHora());
	        ps.setString(3, capacitacion.getLugar());
	        ps.setString(4, capacitacion.getDuracion());
	        ps.setLong(5, capacitacion.getRut());
	        ps.setString(6, capacitacion.getNombreCapacitacion());
	        ps.setInt(7, capacitacion.getCantidadAsistentes());
	        System.out.println(capacitacion);
	        ps.executeUpdate();
	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	//método que implementa la interfaz ICapacitacionDao para obtener todas las capacitaciones registradas en la base de datos.
	@Override
	public List<Capacitacion> obtener() {
		String sql = "SELECT * FROM capacitacion";
		List<Capacitacion> lista = new ArrayList<>();
		try {
			PreparedStatement ps = conexion.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Capacitacion capacitacion = new Capacitacion();
				capacitacion.setId(rs.getInt("idcapacitacion"));
				capacitacion.setRut(rs.getLong("Cliente_rutcliente"));
				capacitacion.setDia(rs.getString("capfecha"));
				capacitacion.setHora(rs.getString("caphora"));
				capacitacion.setLugar(rs.getString("caplugar"));
				capacitacion.setDuracion(rs.getString("capduracion"));
				capacitacion.setNombreCapacitacion(rs.getString("capNombre"));
				capacitacion.setCantidadAsistentes(rs.getInt("capAsistentes"));
				lista.add(capacitacion);
                System.out.println(capacitacion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	//método actualizar de una implementación de la interfaz ICapacitacionDao. Su función es actualizar una capacitación existente en una base de datos.
	@Override
	public boolean actualizar(Capacitacion capacitacion) {
//		String sql = "UPDATE capacitaciones SET rut=?,dia=?,hora=?,lugar=?,duracion=?,cantidad_asistentes=? WHERE id=?";

		try {
			String sql = "UPDATE capacitacion SET rut=?,dia=?,hora=?,lugar=?,duracion=?,cantidad_asistentes=? WHERE id=?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setLong(1, capacitacion.getRut());
			ps.setString(2, capacitacion.getDia());
			ps.setString(3, capacitacion.getHora());
			ps.setString(4, capacitacion.getLugar());
			ps.setString(5, capacitacion.getDuracion());
			ps.setInt(6, capacitacion.getCantidadAsistentes());
			ps.setInt(7, capacitacion.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
//método "eliminar" de la interfaz "ICapacitacionDao"
	@Override
	public boolean eliminar(Capacitacion capacitacion) {
		String sql = "DELETE FROM capacitacion WHERE id=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, capacitacion.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}