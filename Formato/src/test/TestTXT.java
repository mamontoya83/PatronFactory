package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import factoryApp.Alumno;
import factoryApp.Principal;

public class TestTXT {

	@Test
	public void test() {
		Principal principal = new Principal();
		ArrayList<Alumno> baseDeDatos = principal.getBaseDeDatos();
		assertEquals(Principal.usarFormato("TXT", baseDeDatos),true);
	}

}
