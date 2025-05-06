package models;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.Reader;

public class ProducModel {

	public ProducModel() {
		
	}
	
	public JSONArray get()
	{
		
		JSONParser jsonParser = new JSONParser();
		
		/*String url = primerModel.class.getResource("src/files/products.json").getPath();

        
        try (FileReader reader = new FileReader(url))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
  
            JSONArray productList = (JSONArray) obj;
            System.out.println(productList);
              
            return productList;
            //Iterate over  array
           //productList.forEach( emp -> parseTestData( (JSONObject) emp ) );
  		*/

	    try (FileReader reader = new FileReader("src/files/products.json")) {
	        Object obj = jsonParser.parse(reader);
	        JSONObject jsonObject = (JSONObject) obj;

	        JSONArray productList = (JSONArray) jsonObject.get("productos");
	        return productList;
        }
        catch (FileNotFoundException e) 
        {
        	System.out.println("Error");
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
        	System.out.println("Error");
            e.printStackTrace();
        } 
        catch (ParseException e) 
        {
        	System.out.println("Error");
            e.printStackTrace();
        }
	
        
        return null;
		
	}
	
	private static void parseTestData(JSONObject product)
    {
		
		// Obtener valores directamente del objeto producto
	    String title = (String) product.get("nombre");   
	    System.out.println("Nombre: " + title);
	      
	    String description = (String) product.get("precio");   
	    System.out.println("Precio: " + description);
	      
	    String category = (String) product.get("stock"); 
	    System.out.println("Stock: " + category); 
	    
    }
	
	public String[] getAtributos() {
	    return new String[] { "Nombre", "Precio", "Stock" };
	}

	public String[][] getProductos() {
	    JSONArray jsonProductos = get();
	    if (jsonProductos == null) return new String[0][0];

	    String[][] productos = new String[jsonProductos.size()][3];

	    for (int i = 0; i < jsonProductos.size(); i++) {
	        JSONObject obj = (JSONObject) jsonProductos.get(i);
	        productos[i][0] = (String) obj.get("nombre");
	        productos[i][1] = String.valueOf(obj.get("precio"));
	        productos[i][2] = String.valueOf(obj.get("stock"));
	    }

	    return productos;
	}
	
	
}
