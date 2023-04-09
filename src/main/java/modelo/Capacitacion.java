package modelo;

import java.util.List;
import java.util.ArrayList;
import interfaces.ICapacitacionDao;

public class Capacitacion{

	private int id;
	private String nombreCapacitacion;
	private long rut;
	private String dia;
	private String hora;
	private String lugar;
	private String duracion;
	private int cantidadAsistentes;


	/** metodo constructor vacio*/
	public Capacitacion() {
	}

	/** metodo constructor con los atributos como parametros */
	public Capacitacion(int id, String nombreCapacitacion,long rut, String dia, String hora, String lugar, String duracion, int cantidadAsistentes ) {

		this.id = id;
		this.nombreCapacitacion = nombreCapacitacion;
		this.rut = rut;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.duracion = duracion;
		this.cantidadAsistentes = cantidadAsistentes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCapacitacion() {
		return nombreCapacitacion;
	}

	public void setNombreCapacitacion(String nombreCapacitacion) {
		this.nombreCapacitacion = nombreCapacitacion;
	}

	public long getRut() {
		return rut;
	}

	public void setRut(long rut) {
		this.rut = rut;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public int getCantidadAsistentes() {
		return cantidadAsistentes;
	}

	public void setCantidadAsistentes(int cantidadAsistentes) {
		this.cantidadAsistentes = cantidadAsistentes;
	}
	
	

	@Override
	public String toString() {
		return "Capacitacion id:" + id + ", Nombre:" + nombreCapacitacion + ", Rut:" + rut + ", Dia:" + dia
				+ ", Hora:" + hora + ", Lugar:" + lugar + ", Duracion:" + duracion + ", Cantidad de Asistentes:"
				+ cantidadAsistentes;
	}

}