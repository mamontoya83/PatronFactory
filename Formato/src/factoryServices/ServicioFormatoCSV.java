package factoryServices;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import au.com.bytecode.opencsv.CSVWriter;
import factoryApp.Alumno;

public class ServicioFormatoCSV implements Formato {

	@Override
	public boolean formatear(ArrayList<Alumno> db) {
		String path = System.getProperty("user.dir")+"/files/csv/Alumnos.csv";
		
		File file = new File(path);
		
		if(file.exists()){
			file.delete();
		}
		
		try{
			CSVWriter writer = new CSVWriter(new FileWriter(path));
			
			for(Alumno alumno : db){
				//Create record
				String [] record = {
						alumno.getNoDeControl()+"",
						alumno.getApellidoPaterno(),
						alumno.getApellidoMaterno(),
						alumno.getEdad()+"",
						alumno.getSexo(),
						alumno.getCarrera(),
						alumno.getSemestre()+""
				};
				//Write the record to file
				writer.writeNext(record);
			}
			
			//close the writer
			writer.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(file.exists())
			return true;
		else
			return false;
	}

}
