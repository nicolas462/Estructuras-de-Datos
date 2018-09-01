/**
 * 
 */

/**
 * @author BOG-A408-E-018
 *
 */
public class Pacientes{
	
	private String nombre, direccion, telefono;
	private int edad;
	private char sexo;
	private boolean seguro;
	
	
	
	public Pacientes(String nombre, int edad, char sexo, String direccion, String telefono, boolean seguro) 
	{
		this.nombre = nombre;
		this.sexo = sexo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.edad = edad;
		this.seguro = seguro;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isSeguro() {
		return seguro;
	}
	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}
}
