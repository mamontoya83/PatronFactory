package factoryServices;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import factoryApp.Alumno;

public class ServicioFormatoTXT implements Formato {

	@Override
	public boolean formatear(ArrayList<Alumno> db) {
		
		String path = System.getProperty("user.dir")+"/files/txt/Alumnos.txt";
		char separador = ((char) 9);
		
		File file = new File(path);
		
		if(file.exists()){
			file.delete();
		}
			
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(file,true);
			bw = new BufferedWriter(fw);
			
			for(Alumno alumno : db){
				bw.append(
						alumno.getNoDeControl()+ "" + separador
						+ alumno.getNombre() + separador
						+ alumno.getApellidoPaterno() + separador
						+ alumno.getApellidoMaterno() + separador
						+ alumno.getEdad() + "" + separador
						+ alumno.getSexo() + separador
						+ alumno.getCarrera() + separador
						+ alumno.getSemestre() + "\n"
					);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.flush();
				bw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		
		if(file.exists())
			return true;
		else
			return false;
	}

}
