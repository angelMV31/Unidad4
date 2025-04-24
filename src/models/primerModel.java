package models;

public class primerModel {

	public primerModel() {
		
	}
	
	public boolean access(String u, String c){
		
		if(u.equals("fabycamacho@gmail.com") ) {
			
			if(c.equals("100224")) {
				
				return true; 
				
			}
			
			else {
				return false;
				
			}
		}
		
		else {
			return false; 
		}
		 
	}
	
	
}
