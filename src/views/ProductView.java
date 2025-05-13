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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

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
	    
		JButton eliminar = new JButton("Eliminar producto");
		eliminar.setBounds(100, 550, 200, 30);
		eliminar.setFont(etiquetas);
		eliminar.setBackground(Color.red);
		eliminar.setForeground(Color.white);
		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int eliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Eliminar producto", "Ingrese el ID del producto", JOptionPane.QUESTION_MESSAGE));
				p = new ProducModel();
				p.deleteProduct(eliminar);
				ventana.dispose();
				prod = new ProductController();
				prod.products();
			}
			
		});
		fondo.add(eliminar);
		
		JButton add = new JButton("Añadir producto");
		add.setBounds(700, 550, 200, 30);
		add.setFont(etiquetas);
		add.setBackground(Color.green);
		add.setForeground(Color.white);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ventana.dispose();
				prod = new ProductController();
				prod.addProduct();
				
			}
			
		});
		fondo.add(add);
		 
	}
	
	public void addProducts() {
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

		JLabel lblNewLabel = new JLabel("Añadir");
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(titulo);
		lblNewLabel.setBounds(400,15,190,30);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		fondo.add(lblNewLabel);
		
		JLabel etiqueta2 = new JLabel("ID");
		etiqueta2.setBounds(390, 120, 90, 30);
		etiqueta2.setOpaque(false);
		etiqueta2.setFont(etiquetas);
		etiqueta2.setHorizontalAlignment(JLabel.LEFT);
		fondo.add(etiqueta2);
		
		JTextField id = new JTextField();
		id.setBounds(372, 170, 247, 30);
		id.setBackground(Color.WHITE);
		id.setOpaque(true);
		id.setFont(etiquetas);
		fondo.add(id);

		JLabel etiqueta3 = new JLabel("Nombre");
		etiqueta3.setBounds(390, 220, 95, 30);
		etiqueta3.setOpaque(false);
		etiqueta3.setFont(etiquetas);
		etiqueta3.setHorizontalAlignment(JLabel.LEFT);
		fondo.add(etiqueta3);
		
		JTextField nom = new JTextField();
		nom.setBounds(372, 270, 247, 30);
		nom.setBackground(Color.WHITE);
		nom.setFont(etiquetas);
		fondo.add(nom);
		
		JLabel etiqueta22 = new JLabel("Precio");
		etiqueta22.setBounds(390, 320, 90, 30);
		etiqueta22.setOpaque(false);
		etiqueta22.setFont(etiquetas);
		etiqueta22.setHorizontalAlignment(JLabel.LEFT);
		fondo.add(etiqueta22);
		
		JTextField precio = new JTextField();
		precio.setBounds(372, 370, 247, 30);
		precio.setBackground(Color.WHITE);
		precio.setOpaque(true);
		precio.setFont(etiquetas);
		fondo.add(precio);

		JLabel etiqueta32 = new JLabel("Stock");
		etiqueta32.setBounds(390, 420, 95, 30);
		etiqueta32.setOpaque(false);
		etiqueta32.setFont(etiquetas);
		etiqueta32.setHorizontalAlignment(JLabel.LEFT);
		fondo.add(etiqueta32);
		
		JTextField stock = new JTextField();
		stock.setBounds(372, 470, 247, 30);
		stock.setBackground(Color.WHITE);
		stock.setFont(etiquetas);
		fondo.add(stock);
		
		JButton add = new JButton("Añadir producto");
		add.setBounds(700, 550, 200, 30);
		add.setFont(etiquetas);
		add.setBackground(Color.green);
		add.setForeground(Color.white);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int identi = Integer.parseInt(id.getText());
				String nombre = nom.getText();
				double price = Double.parseDouble(precio.getText());
				int disp = Integer.parseInt(stock.getText());
				
				p = new ProducModel();
				p.addProducto(identi, nombre, price, disp);
				ventana.dispose();
				prod = new ProductController();
				prod.products();
				
			}
			
		});
		fondo.add(add);
		 
	}
	
	private static void parseTestData(JSONObject product)
    {
		// Obtener valores directamente del objeto producto
		int identi = (int) product.get("ID");
		String nombre = (String) product.get("nombre");
        double precio = (double) product.get("precio");
        int stock = (int) product.get("stock");

        System.out.println("ID: " + identi + "Nombre: " + nombre + ", Precio: $" + precio + ", Stock: " + stock);
	    
    }
}
