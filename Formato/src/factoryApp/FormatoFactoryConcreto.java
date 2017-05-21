package factoryApp;

import factoryServices.Formato;
import factoryServices.FormatoFactory;
import factoryServices.ServicioFormatoCSV;
import factoryServices.ServicioFormatoJSON;
import factoryServices.ServicioFormatoTXT;
import factoryServices.ServicioFormatoXML;

public class FormatoFactoryConcreto extends FormatoFactory{
	@Override
	public Formato createFormato(String tipo) {
		
		Formato formato = null;
		
		switch(tipo ){
			case "CSV":
				formato = new ServicioFormatoCSV();
			break;
			case "JSON":
				formato = new ServicioFormatoJSON();
				break;
			case "XML":
				formato = new ServicioFormatoXML();
				break;
			case "TXT":
				formato = new ServicioFormatoTXT();
				break;
		}
		
		return formato;
	}
}
