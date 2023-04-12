package interfaces;

import java.util.ArrayList;

import modelo.Cliente;



/**
 * Interface que declara los metodos CRUD del Cliente
 * @author zamor
 */
public interface IClienteDAO {
	
	//Metodos del CRUD
	public void addCliente(Cliente cliente)throws Exception;// Metodo para crear un Cliente
	public ArrayList<Cliente> listarCliente()throws Exception;// Metodo para Listar un Cliente
	public void updateCliente(Cliente cliente)throws Exception;// Metodo para modificar un Cliente
	public void deleteCliente(Cliente cliente)throws Exception;// Metodo para borrar un Cliente
	// Se agrego este nuevo metodo para poder editar un solo registro
	public Cliente obtenerClientePorId(int rut) throws Exception;
}
