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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.ProductController;
import models.ProducModel;

public class ProductView {

	ProducModel p = new ProducModel();
	ImageIcon i;
	Image image;
	Font titulo = new Font("Arial", Font.BOLD, 31);
	Font etiquetas = new Font("Arial", Font.BOLD,17);
	Font et = new Font("Arial", Font.BOLD,13);
	
	String [] atributos = p.getAtributos();
	
	String [][] productos = p.getProductos();
	
	public ProductController prod;
	
	public ProductView() {
		
	}
	
	public void products(JSONArray data) {
		JFrame ventana = new JFrame();
		ventana.setTitle("Productos");
		ventana.setBounds(0, 0, 1000, 700);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setVisible(true);
		
		ImageIcon capiIcon = new ImageIcon("src/images/capi.png");
		ventana.setIconImage(capiIcon.getImage());
		
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

		JLabel lblNewLabel = new JLabel("Productos");
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(titulo);
		lblNewLabel.setBounds(400,15,190,30);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		fondo.add(lblNewLabel);
		
		JPanel tarjeta1 = new JPanel();
	    tarjeta1.setBounds(100, 200, 800, 300);
	    tarjeta1.setOpaque(false);
	    tarjeta1.setLayout(null);
	    fondo.add(tarjeta1);
	    
	    JTable tablaProducts = new JTable(productos, atributos);
	    JScrollPane scrollPane = new JScrollPane(tablaProducts);
	    scrollPane.setBounds(0, 0, 800, 300);
	    scrollPane.setOpaque(false);
	    tablaProducts.setOpaque(false);
	    tarjeta1.add(scrollPane);
	    
		int x = 70;
		
		for (Object product1 : data) {
			
			JSONObject product = (JSONObject) product1;
			System.out.println(product.get("nombre"));
			
			JLabel lblNewLabel2 = new JLabel((String) product.get("nombre"));
			lblNewLabel2.setForeground(new Color(0, 0, 0));
			lblNewLabel2.setFont(new Font("Kefa", Font.PLAIN, 24));
			lblNewLabel2.setBounds(107, x, 210, 26);
			lblNewLabel2.setHorizontalAlignment(JLabel.CENTER);
			parseTestData(product);
			panel.add(lblNewLabel2);
			
			x+=35;
			
		}
		
		//data.forEach( emp -> parseTestData( (JSONObject) emp ) );
		 
	}
	
	private static void parseTestData(JSONObject product)
    {
		// Obtener valores directamente del objeto producto
		String nombre = (String) product.get("nombre");
        double precio = (double) product.get("precio");
        long stock = (long) product.get("stock");

        System.out.println("Nombre: " + nombre + ", Precio: $" + precio + ", Stock: " + stock);
	    
    }
}
