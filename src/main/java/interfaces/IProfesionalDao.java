package interfaces;
import modelo.Profesional; 

import java.util.List;


public interface IProfesionalDao {
  
    public void actualizarProfesional(Profesional profesional);
    public void eliminarProfesional(int run);    
    public List obtenerTodosLosProfesionales() throws Exception;
    public List DatosProfesional(int run)throws Exception;
	void insertarProfesional(Profesional profesional);
}