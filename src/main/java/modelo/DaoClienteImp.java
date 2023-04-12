package modelo;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.IClienteDAO;
import conexion.ConexionSingleton;



public class DaoClienteImp  implements IClienteDAO {
	
	private Connection conn;
	
	

	public DaoClienteImp() {
		conn = ConexionSingleton.conectar();
	}

	@Override
	public void addCliente(Cliente cliente) throws Exception {
		try {
			 PreparedStatement st = conn.prepareStatement("INSERT INTO cliente (rutCliente, clinombres, cliapellidos, "
			 		+ "clitelefono,cliafp,clisistemasalud,clidireccion,clicomuna, cliedad) VALUES (?,?,?,?,?,?,?,?,?);");
			 
			 st.setInt(1, cliente.getRunUsuario());
			 st.setString(2, cliente.getNombres());
			 st.setString(3, cliente.getApellidos());
			 st.setString(4, cliente.getTelefono());
			 st.setString(5, cliente.getAfp());
			 st.setInt(6, cliente.getSistemaSalud());
			 st.setString(7, cliente.getDireccion());
			 st.setString(8, cliente.getComuna());
			 st.setInt(9, cliente.getEdad());
			 
			 System.out.println(""+st);
			 
			 st.executeUpdate();
	         
	 
		}catch(Exception e) {
			throw e;
		}finally {
			if (conn != null) {
		        try {
		            conn.close();
		        } catch (SQLException er) {
		        	 er.printStackTrace();
		        }
		    }
		}
		
	}

  
	
	@Override
	public void updateCliente(Cliente cliente) throws Exception {
		try {
			String sql = "UPDATE cliente c " 
				        + "INNER JOIN usuarios u ON c.rutcliente =u.run "
					    + "SET c.rutcliente = ?,"
						+ "c.clinombres = ?," 
						+ "c.cliapellidos = ,"
						+ "c.clitelefono = ?,"
						+ "c.cliafp = ?," 
						+ "c.clisistemasalud =?," 
						+ "c.clidireccion = ?," 
						+ "c.clicomuna =?,"
						+ "c.cliedad = ?,"
					    + "u.run = ?,"
					    + "u.nombre = ?,"
					    + "u.fechaNac=?"     
					    + " WHERE c.rutcliente = ?";
			System.out.println(sql);
			 PreparedStatement st = conn.prepareStatement( sql);
			 System.out.println(sql);
			 st.setInt(1, cliente.getRunUsuario());
			 st.setString(2, cliente.getNombres());
			 st.setString(3, cliente.getApellidos());
			 st.setString(4, cliente.getTelefono());
			 st.setString(5, cliente.getAfp());
			 //st.setInt(6, cliente.getSistemaSalud());
			 st.setInt(6, 1);
			 st.setString(1, cliente.getDireccion());
			 st.setString(7, cliente.getComuna());
			 st.setInt(8, cliente.getEdad());
			 st.setInt(9, cliente.getRunUsuario());
			 st.setString(10, cliente.getNombreUsuario());
			 st.setString(11, cliente.getFechaNacimientoUsuario());
			 st.executeUpdate();
			
		}catch(Exception e) {
			throw e;
		}finally {
			if (conn != null) {
		        try {
		            conn.close();
		        } catch (SQLException er) {
		        	 er.getMessage();
		        }
		    }
		}
		
	}

	@Override
	public void deleteCliente(Cliente cliente) throws Exception {
		try {
			 PreparedStatement st = conn.prepareStatement("DELETE FROM cliente WHERE rutcliente = ?");
			 st.setInt(1, cliente.getRunUsuario());
			 st.executeUpdate();
		 
		}catch(Exception e) {
			throw e;
		}finally {
			if (conn != null) {
		        try {
		            conn.close();
		        } catch (SQLException er) {
		        	 er.getMessage();
		        }
		    }
		}
		
	}

	@Override
	public ArrayList<Cliente> listarCliente() throws Exception {
		String sql = "SELECT nombre, fechaNac,tipo,run, c.* FROM usuarios u INNER JOIN  cliente c ";
		       sql += "WHERE u.run = c.rutcliente;";
		ArrayList<Cliente> lista = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		        Cliente client = new Cliente();

		        
		        client.setNombreUsuario(rs.getString("nombre"));
		        client.setFechaNacimientoUsuario(rs.getString("fechaNac"));
		        client.setTipoUsuario(rs.getInt("tipo")); 
		        client.setRunUsuario(rs.getInt("run"));
		        client.setNombres(rs.getString("clinombres"));
		        client.setApellidos(rs.getString("cliapellidos"));
		        client.setTelefono(rs.getString("clitelefono"));
		        client.setAfp(rs.getString("cliafp"));
		        client.setSistemaSalud(rs.getInt("clisistemasalud"));
		        client.setDireccion(rs.getString("clidireccion"));
		        client.setComuna(rs.getString("clicomuna"));
		        client.setEdad(rs.getInt("cliedad"));
		        
		        lista.add(client);
		        //System.out.println(client.toString());
		    }
		    rs.close();
		   


		}catch(Exception e) {
		    throw e;
		}finally {
		    // Mover el cierre de la conexión aquí
		    if (conn != null) {
		        try {
		            conn.close();
		        } catch (SQLException er) {
		            er.getMessage();
		        }
		    }
		}
		return lista;
		}
	 /**
	 *Metodo que me permitira obtener todos los datos dado un rut selecciona en una lista de Clientes
	 */
	public Cliente obtenerClientePorId(int rut) throws Exception {
		String sql = "SELECT nombre, fechaNac,tipo,run, c.* FROM usuarios u INNER JOIN  cliente c ";
		       sql += "WHERE u.run = c.rutcliente AND u.run = ? ;";
		
		try {
			    
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rut);
			ResultSet rs = ps.executeQuery();	
			List<Cliente> listaClientes = new ArrayList<>();
			while (rs.next()) {
			    Cliente client = new Cliente();
			    client.setNombreUsuario(rs.getString("nombre"));
			    client.setFechaNacimientoUsuario(rs.getString("fechaNac"));
			    client.setTipoUsuario(rs.getInt("tipo")); 
			    client.setRunUsuario(rs.getInt("run"));
			    client.setNombres(rs.getString("clinombres"));
			    client.setApellidos(rs.getString("cliapellidos"));
			    client.setTelefono(rs.getString("clitelefono"));
			    client.setAfp(rs.getString("cliafp"));
			    client.setSistemaSalud(rs.getInt("clisistemasalud"));
			    client.setDireccion(rs.getString("clidireccion"));
			    client.setComuna(rs.getString("clicomuna"));
			    client.setEdad(rs.getInt("cliedad"));
			    listaClientes.add(client);
			}

			rs.close();

			if (listaClientes.isEmpty()) {
			    return null;
			} else if (listaClientes.size() > 1) {
			    throw new Exception("Se encontraron múltiples resultados para el ID de cliente proporcionado.");
			} else {
			    return listaClientes.get(0);
			}


		 
		}catch(Exception e) {
		    throw e;
		}finally {
		    // Mover el cierre de la conexión aquí
		    if (conn != null) {
		        try {
		            conn.close();
		        } catch (SQLException er) {
		            er.getMessage();
		        }
		    }
		}

		return lista;
		}

	

	
	}

