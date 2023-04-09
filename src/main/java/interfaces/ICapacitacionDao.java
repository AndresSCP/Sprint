package interfaces;

import java.util.List;

import modelo.Capacitacion;


public interface ICapacitacionDao {

	public boolean registrar(Capacitacion capacitacion);
	public List<Capacitacion> obtener();
	public boolean actualizar(Capacitacion capacitacion);
	public boolean eliminar (Capacitacion capacitacion);

}
