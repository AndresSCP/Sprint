package interfaces;
import modelo.Profesional; 

import java.util.List;


public interface IProfesionalDao {
  
    public void actualizarProfesional(Profesional profesional);
    public void eliminarProfesional(int run);    
    public List<modelo.Profesional> obtenerTodosLosProfesionales();
	void insertarProfesional(Profesional profesional);
}