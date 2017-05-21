package factoryApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import factoryServices.Formato;

public class Principal {
	
	private ArrayList<Alumno> baseDeDatos;
	
	public Principal(){
		baseDeDatos = leerBaseDeDatos();
	}
	
	public ArrayList<Alumno> getBaseDeDatos(){
		return baseDeDatos;
	}
	
	public static void main(String[] args) {
		Principal principal = new Principal();
		do {
			int o = preguntarFormato();
			switch (o) {
			case 0:
				usarFormato("CSV", principal.getBaseDeDatos());
				break;
			case 1:
				usarFormato("JSON", principal.baseDeDatos);
				break;
			case 2:
				usarFormato("TXT", principal.baseDeDatos);
				break;
			case 3:
				usarFormato("XML", principal.baseDeDatos);
				break;
			case 4:
				System.out.println("Sistema Terminado");
				System.exit(0);
				break;
			default:
				System.out.println("Indico una opción no válida");
				break;
			}
		} while (0 != 4);
	}
	
	public static boolean usarFormato(String tipo, ArrayList<Alumno> db){
		Formato formato = new FormatoFactoryConcreto().createFormato(tipo);
		
		boolean bandera = true;
		if(formato.formatear(db)){
			System.out.println("El archivo se guardo satisfactoriamente.");
		}else{
			System.out.println("Ocurrio un problema al intentar guardar el archivo.");
			bandera=false;
		}
		return bandera;
	}
	
	public static int preguntarFormato(){
		Scanner s = new Scanner(System.in);
		System.out.println(
				"MENU DE OPCIONES\n"
				+ "0. Importar la informacion en formato CSV\n"
				+ "1. Importar la informacion en formato JSON\n"
				+ "2. Importar la informacion en formato TXT\n"
				+ "3. Importar la informacion en formato XML\n"
				+ "4. Salir"
				);
		return Integer.parseInt(s.nextLine());
	}
	
	public static ArrayList<Alumno> leerBaseDeDatos(){
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		
		FileReader fr;
		BufferedReader br;

		try {
			//String ruta = "/Users/MacBook/Documents/Proyectos/Maestria/Tecnicas de Programacion/AmigosDeMisAmigos.txt";
			String ruta = searchFile();
			if(ruta!=""){
				fr = new FileReader(ruta);
				br = new BufferedReader(fr);
				String renglon;

				try {
					while((renglon = br.readLine())!=null){
						Alumno alumno = new Alumno();
						String[] dato = renglon.split(",");
						
						alumno.setNoDeControl(Integer.parseInt(dato[0].trim()));
						alumno.setNombre(dato[1].trim());
						alumno.setApellidoPaterno(dato[2].trim());
						alumno.setApellidoMaterno(dato[3].trim());
						alumno.setEdad(Integer.parseInt(dato[4].trim()));
						alumno.setSexo(dato[5].trim());
						alumno.setCarrera(dato[6].trim());
						alumno.setSemestre(Integer.parseInt(dato[7].trim()));
						
						listaAlumnos.add(alumno);						
					}
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					try {
						fr.close();
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}else{
				System.out.println("No selecciono ningun archivo");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaAlumnos;
	}

	public static String searchFile(){
		String ruta="";
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")+"/dataBase"));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			ruta=selectedFile.getAbsolutePath();
		}
		return ruta;
	}
}