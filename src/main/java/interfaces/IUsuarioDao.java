package interfaces;

import java.util.ArrayList;

import modelo.Usuario;



public interface IUsuarioDao {

	//Metodos del CRUD
	public void addUsuario(Usuario usuario)throws Exception;// Metodo para crear un Usuario
	public ArrayList<Usuario> listarUsuario()throws Exception;// Metodo para Listar un Usuario
	public void updateUsuario(Usuario usuario)throws Exception;// Metodo para modificar un Usuario
	public void deleteUsuario(Usuario usuario)throws Exception;// Metodo para borrar un Usuario

}
