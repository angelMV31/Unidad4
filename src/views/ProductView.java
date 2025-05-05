package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.ProductController;

public class ProductView {

	ImageIcon i;
	Image image;
	JFrame ventana;
	JSONArray data;
	public ProductController prod;
	
	public ProductView() {
		products(data);
	}
	
	public void products(JSONArray data) {
		
		ventana = new JFrame();
		ventana.setTitle("Productos");
		ventana.setBounds(0, 0, 1000, 700);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		ventana.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		image = new ImageIcon("src/images/fondo.png").getImage().getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
		i = new ImageIcon(image);
		JLabel fondo = new JLabel(i);
		fondo.setBounds(0, 0, 1000, 700);
		fondo.setLayout(null);
		ventana.setContentPane(fondo);
		fondo.add(panel);
		
		JLabel lblNewLabel = new JLabel("PRODUCTOS");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);
		
		int x = 70;
		
		for (Object product1 : data) {
			
			JSONObject product = (JSONObject) product1;
			System.out.println(product.get("title"));
			
			JLabel lblNewLabel2 = new JLabel((String) product.get("title"));
			lblNewLabel2.setForeground(new Color(0, 0, 0));
			//lblNewLabel2.setFont(new Font("Kefa", Font.PLAIN, 24));
			lblNewLabel2.setBounds(107, x, 210, 26);
			lblNewLabel2.setHorizontalAlignment(JLabel.CENTER);
			panel.add(lblNewLabel2);
			
			x+=35;
			
		}
		
		//data.forEach( emp -> parseTestData( (JSONObject) emp ) );
		 
	}
	
	private static void parseTestData(JSONObject product)
    {
		
		// Obtener valores directamente del objeto producto
	    String title = (String) product.get("title");   
	    System.out.println("Title: " + title);
	      
	    String description = (String) product.get("description");   
	    System.out.println("Description: " + description);
	      
	    String category = (String) product.get("category"); 
	    System.out.println("Category: " + category); 
	    
    }
}
