package interfaces;

import java.util.List;

import modelo.Administrativo;

public interface IAdministrativoDao {

	public void registrarAdministrativo(Administrativo administrativo);
	public void actualizarAdministrativo(Administrativo administrativo);	
//	public Administrativo obtenerAdministrativoPorId(int id);
	public void eliminarAdministrativo(int id);
	public List<Administrativo> obtenerAdministrativos();

}
