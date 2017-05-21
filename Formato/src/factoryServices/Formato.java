package factoryServices;

import java.util.ArrayList;

import factoryApp.Alumno;

public interface Formato {
	/*En esta interface se incorporan los metodos que deben ser implementados por las 
	 * productos concretos*/
	public boolean formatear(ArrayList<Alumno> db);
}
