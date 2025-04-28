package models;

import java.io.FileReader;
import java.io.BufferedReader;

public class primerModel {

	public primerModel() {
		
	}
	
	public boolean access(String u, String c){
		 
		 try{
			 
		 	BufferedReader lector = new BufferedReader(new FileReader("src/files/usuarios.txt"));
		 	String usuario;
		 	
		 	while((usuario = lector.readLine()) != null) {
		 		String [] datos = usuario.split(",");
		 		
		 		if(datos.length == 4) {
		 			String correo = datos[1].trim();
		 			String contra = datos[2].trim();
		 			
		 			if(u.equals(correo) && c.equals(contra)) {
		 				return true;
		 			}
		 		}
		 	}
		 	
		 }
		 
		 catch (Exception e) {
				
				e.printStackTrace();
				System.out.println("Error"); 
		 }
		 return false;
		 
	}
	
	public boolean alta(String u, String c) {
		 try{
			 
			 	BufferedReader escritor = new BufferedReader(new FileReader("src/files/usuarios.txt"));
			 	String usuario;
			 	
			 	while((usuario = escritor.readLine()) != null) {
			 		String [] datos = usuario.split(",");
			 		
			 		if(datos.length == 4) {
			 			String correo = datos[1].trim();
			 			String contra = datos[2].trim();
			 			
			 			if(u.equals(correo) && c.equals(contra)) {
			 				return true;
			 			}
			 		}
			 	}
			 	
			 }
			 
			 catch (Exception e) {
					
					e.printStackTrace();
					System.out.println("Error"); 
			 }
			 return false;
	}
	
}
