package modelo;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.IClienteDAO;
import conexion.ConexionSingleton;


//clase llamada "DaoClienteImp" que implementa la interfaz "IClienteDAO". 
public class DaoClienteImp  implements IClienteDAO {
	
	private Connection conn;
	
	public DaoClienteImp() {
		conn = ConexionSingleton.conectar();
	}
	
//método para crear o agregar un nuevo cliente a una base de datos.
	@Override
	public void addCliente(Cliente cliente) throws Exception {
		try {
			 PreparedStatement st = conn.prepareStatement("INSERT INTO Clientes (rutCliente, clinombres, cliapellidos, "
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

  
	// Metodo updateCliente para actualizar clientes
	@Override
	public void updateCliente(Cliente cliente) throws Exception {
		try {
			 PreparedStatement st = conn.prepareStatement("UPDATE cliente SET clinombres = ? WHERE rutcliente = ? ");
			 st.setString(1, cliente.getNombres());
			 st.setInt(2, cliente.getRunUsuario());
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
	// Metodo para eliminar cliente
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
	// Método se encarga de obtener una lista de objetos Cliente a partir de una consulta a la base de datos.
	@Override
	public ArrayList<Cliente> listarCliente() throws Exception {
		String sql = "SELECT nombre, fechaNac,tipo, c.* FROM usuarios u INNER JOIN  cliente ";
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
		        client.setNombres(rs.getString("clinombres"));
		        client.setApellidos(rs.getString("cliapellidos"));
		        client.setTelefono(rs.getString("clitelefono"));
		        client.setAfp(rs.getString("cliafp"));
		        client.setSistemaSalud(rs.getInt("clisistemasalud"));
		        client.setDireccion(rs.getString("direccion"));
		        client.setComuna(rs.getString("comuna"));
		        client.setEdad(rs.getInt("cliedad"));
		        
		        lista.add(client);
		        System.out.println(client.toString());
		    }
		    rs.close();
		   


		}catch(Exception e) {
		    throw e;
		}finally {
		    // Mover el cierre de la conexión aquí
		    if (conn != null) {
		    	
		//"try-catch" en Java se utiliza para manejar excepciones, que son errores que pueden ocurrir en tiempo de ejecución y que interrumpen el flujo normal del programa.
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

