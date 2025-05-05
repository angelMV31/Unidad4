package models;

import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class primerModel {


	public primerModel() {
		
	}
	
	public boolean access(String u, String c){
		 
		 try{
			 
		 	BufferedReader lector = new BufferedReader(new FileReader("src/files/usuarios.txt"));
		 	String usuario;
		 	
		 	while((usuario = lector.readLine()) != null) {
		 		String [] datos = usuario.split("\\|");
		 		
		 		if(datos.length == 7) {
		 			String correo = datos[5].trim();
		 			String contra = datos[6].trim();
		 			
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
	
	public static boolean alta(String nombre, String empresa, String ambito, String rol, String usuario, String correo, String contra) {
		 try{
			 	BufferedWriter escritor = new BufferedWriter(new FileWriter("src/files/usuarios.txt",true));
			 	
			 	String user = nombre+"|"+empresa+"|"+ambito+"|"+rol+"|"+usuario+"|"+correo+"|"+contra;
	        
			 	escritor.newLine();
			 	escritor.write(user);
		        escritor.close();
			 	
		        return true;
			 }
			 
			 catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error"); 
			 }
			 return false;
	}
	
}
