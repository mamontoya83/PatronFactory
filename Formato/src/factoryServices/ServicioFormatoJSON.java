package factoryServices;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import factoryApp.Alumno;

public class ServicioFormatoJSON implements Formato {

	@SuppressWarnings("unchecked")
	@Override
	public boolean formatear(ArrayList<Alumno> db) {
		String path = System.getProperty("user.dir")+"/files/json/Alumnos.json";
		
		File file = new File(path);
		
		if(file.exists()){
			file.delete();
		}
		
		JSONObject json = new JSONObject();
		JSONArray myArray = new JSONArray();
		
		for(Alumno alumno : db){
			JSONObject item = new JSONObject();
			item.put("Numero de Control", alumno.getNoDeControl());
			item.put("Nombre", alumno.getNombre());
			item.put("Apellido Paterno", alumno.getApellidoPaterno());
			item.put("Apellido Materno", alumno.getApellidoMaterno());
			item.put("Edad", alumno.getEdad());
			item.put("Sexo", alumno.getSexo());
			item.put("Carrera", alumno.getCarrera());
			item.put("Semestre", alumno.getSemestre());
			myArray.add(item);
		}
		json.put("Lista", myArray);

        try (FileWriter fw = new FileWriter(path)) {
            fw.write(json.toJSONString());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if(file.exists())
			return true;
		else
			return false;
	}

}
