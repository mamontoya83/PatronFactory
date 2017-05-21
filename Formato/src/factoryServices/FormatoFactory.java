package factoryServices;

import java.util.ArrayList;
import factoryApp.Alumno;

public abstract class FormatoFactory {
	
	public boolean formatear(ArrayList<Alumno> db, String tipo){
		Formato formato = createFormato(tipo);
		return formato.formatear(db);
	}
	
	public abstract Formato createFormato(String tipo);
}
