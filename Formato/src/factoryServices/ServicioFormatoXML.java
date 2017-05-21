package factoryServices;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import factoryApp.Alumno;
import factoryApp.Lists;

public class ServicioFormatoXML implements Formato {
	@Override
	public boolean formatear(ArrayList<Alumno> db) {
		String path = System.getProperty("user.dir")+"/files/xml/Alumnos.xml";
		File file = new File(path);
		try {
			JAXBContext jc = JAXBContext.newInstance(Lists.class, Alumno.class);

	        Lists<Alumno> lists = new Lists<Alumno>();
	        
	        for(Alumno alumno : db){
	        	lists.getValues().add(alumno);
	        }

	        Marshaller marshaller = jc.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        marshaller.marshal(lists, file);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(file.exists())
			return true;
		else
			return false;
	}
}
