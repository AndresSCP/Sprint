package interfaces;

import java.util.List;
import java.util.ArrayList;
import modelo.Administrativo;

public interface IAdministrativoDao {

	public void registrarAdministrativo(Administrativo administrativo);
	public void actualizarAdministrativo(Administrativo administrativo);	
//	public Administrativo obtenerAdministrativoPorId(int id);
	public void eliminarAdministrativo(int id);
	public ArrayList<Administrativo> listaAdministrativos()throws Exception;// Metodo para Listar un Usuario
//	public List<Administrativo> obtenerAdministrativos();

}
