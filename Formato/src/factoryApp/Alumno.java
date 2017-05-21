package factoryApp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alumno {
	private int noDeControl;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private int edad;
	private String sexo;
	private String carrera;
	private int semestre;
	
	public Alumno(){
	}
	
	public int getNoDeControl() {
		return noDeControl;
	}

	@XmlElement
	public void setNoDeControl(int noDeControl) {
		this.noDeControl = noDeControl;
	}

	public String getNombre() {
		return nombre;
	}

	@XmlElement
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	@XmlElement
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	@XmlElement
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public int getEdad() {
		return edad;
	}

	@XmlElement
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	@XmlElement
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCarrera() {
		return carrera;
	}

	@XmlElement
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public int getSemestre() {
		return semestre;
	}

	@XmlElement
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
	@Override
	public String toString() {
		String salida = ""
				+ "No de Control:	" + noDeControl + "\n"
				+ "Nombre:		" + nombre + "\n"
				+ "Ap Paterno:	" + apellidoPaterno + "\n"
				+ "Ap Materno:	" + apellidoMaterno + "\n"
				+ "Edad:		" + edad + "\n"
				+ "Sexo:		" + sexo + "\n"
				+ "Carrera:	" + carrera + "\n"
				+ "Semestre:	" + semestre + "\n";
		
		return salida;
	}
}
