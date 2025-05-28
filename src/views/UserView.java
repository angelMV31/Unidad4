package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.ProductController;
import controllers.UserController;
import controllers.primerController;
import models.ProducModel;
import models.User;
import models.UserModel;


public class UserView {
 
	ImageIcon i;
	Image image;
	Font titulo = new Font("Arial", Font.BOLD, 31);
	Font etiquetas = new Font("Arial", Font.BOLD,17);
	Font et = new Font("Arial", Font.BOLD,13);
	
	UserModel um = new UserModel();
	
	public UserView() {
		
	}
	
	public void mostrarUsuarios(ArrayList<User> users) {
		JFrame ventana = new JFrame();
		ventana.setTitle("Users");
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

		JLabel lblNewLabel = new JLabel("Usuarios");
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(titulo);
		lblNewLabel.setBounds(400,15,190,30);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		fondo.add(lblNewLabel);
		
		JPanel tarjeta1 = new JPanel();
	    tarjeta1.setBounds(100, 200, 800, 300);
	    tarjeta1.setOpaque(true);
	    tarjeta1.setLayout(null);
	    fondo.add(tarjeta1);
	    
	    /*String [] atributos = {"ID", "Nombre", "Email", "Rol", "Teléfono", "Create_at", "Update_at"};
	    
	    
	    JTable tablaProducts = new JTable(productos, atributos);
	    JScrollPane scrollPane = new JScrollPane(tablaProducts);
	    scrollPane.setBounds(0, 0, 800, 300);
	    scrollPane.setOpaque(false);
	    tablaProducts.setOpaque(false);
	    tarjeta1.add(scrollPane);*/
	    
	    int y = 10;
	    
	    for(Iterator iterator = users.iterator(); iterator.hasNext();) {
	    	User user = (User) iterator.next();
	    	
	    	JLabel userLabel = new JLabel(user.name, SwingConstants.CENTER);
	    	userLabel.setFont(etiquetas);
	    	userLabel.setBounds(10, y, 200, 30);
	    	tarjeta1.add(userLabel);
	    	
	    	JButton actualiza = new JButton("Editar");
	    	actualiza.setBounds(550,y,80,30);
	    	actualiza.setFont(et);
	    	actualiza.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ventana.dispose();
					UserController uc = new UserController();
					uc.update(user);
				}
	    		
	    	});
	    	tarjeta1.add(actualiza);
	    	
	    	JButton delete = new JButton("Eliminar");
	    	delete.setBounds(680,y,100,30);
	    	delete.setFont(et);
	    	delete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int opc;
					
					opc = JOptionPane.showConfirmDialog(ventana, "Desea eliinar el registro?", "Confirmar", JOptionPane.YES_NO_OPTION);
					
					if(opc == 0) {
						ventana.dispose();
						UserController uc = new UserController();
						uc.delete(user.id);
						um = new UserModel();
						um.delete(user.id);
						uc.usuarios();
					}
				}
	    		
	    	});
	    	tarjeta1.add(delete);
	    	
	    	y+=40;
	    }
	    
	    JButton add = new JButton("Añadir usuario");
	    add.setBounds(100, 550, 200, 30);
	    add.setFont(etiquetas);
	    add.setBackground(Color.green);
	    add.setForeground(Color.white);
	    add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				registro();
			}
			
		});
		fondo.add(add);
		
		JButton back = new JButton("Volver");
		back.setBounds(700, 550, 200, 30);
		back.setFont(etiquetas);
		back.setBackground(Color.BLUE);
		back.setForeground(Color.white);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				primerController view = new primerController();
				view.login();
			}
			
		});
		fondo.add(back);
		 
	}
	
	public void registro() {
		JFrame frame = new JFrame();
		frame.setTitle("Registro");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setVisible(true);
		frame.setBounds(0, 0, 1000, 700);
		frame.setLocationRelativeTo(null);
		
		JPanel regis = new JPanel();
		regis.setLayout(null);
		regis.setOpaque(false);
		regis.setBounds(0, 0, 1000, 700);
		frame.add(regis);
		
		image = new ImageIcon("src/images/fondo.png").getImage().getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
		i = new ImageIcon(image);
		JLabel fondo = new JLabel(i);
		fondo.setBounds(0,0,1000, 700);	
		frame.setContentPane(fondo);
		fondo.add(regis);
		
		JLabel etiqueta1 = new JLabel("Registro");
		etiqueta1.setSize(180,40);
		etiqueta1.setLocation(407, 15);
		etiqueta1.setOpaque(false);
		etiqueta1.setFont(titulo);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setForeground(Color.black); 
		regis.add(etiqueta1);

		JLabel nombre = new JLabel("Nombre");
		nombre.setBounds(197, 100, 90, 30);
		nombre.setOpaque(false);
		nombre.setFont(etiquetas);
		nombre.setHorizontalAlignment(JLabel.LEFT);
		regis.add(nombre);
		
		JTextField nom = new JTextField();
		nom.setBounds(177, 140, 265, 30);
		nom.setBackground(Color.WHITE);
		nom.setOpaque(true);
		nom.setFont(etiquetas);
		regis.add(nom);
		nom.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
		            e.consume();
		    }
		}});
		
		JLabel etiqueta2 = new JLabel("Correo");
		etiqueta2.setBounds(197, 180, 90, 30);
		etiqueta2.setOpaque(false);
		etiqueta2.setFont(etiquetas);
		etiqueta2.setHorizontalAlignment(JLabel.LEFT);
		regis.add(etiqueta2);
		
		JTextField correo = new JTextField();
		correo.setBounds(177, 220, 265, 30);
		correo.setBackground(Color.WHITE);
		correo.setOpaque(true);
		correo.setFont(etiquetas);
		regis.add(correo);
		correo.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (Character.isWhitespace(c)) {
		            e.consume();
		        }
		    }
		});
		
		JLabel ambito = new JLabel("Rol");
		ambito.setBounds(197, 260, 100, 30);
		ambito.setOpaque(false);
		ambito.setFont(etiquetas);
		ambito.setHorizontalAlignment(JLabel.LEFT);
		regis.add(ambito);
		
		String[] ambitos = {".............................", "Gerente", "Finanzas", "Recursos Humanos", "Marketing", "Sistemas", "Otro"};
		
		JComboBox amb = new JComboBox(ambitos);
		amb.setBounds(177, 300, 265, 30);
		regis.add(amb);
		
		JLabel usuario = new JLabel("Teléfono");
		usuario.setBounds(197, 340, 180, 30);
		usuario.setOpaque(false);
		usuario.setFont(etiquetas);
		usuario.setHorizontalAlignment(JLabel.LEFT);
		regis.add(usuario);
		
		JTextField tel = new JTextField();
		tel.setBounds(177, 380, 265, 30);
		tel.setBackground(Color.WHITE);
		tel.setOpaque(true);
		tel.setFont(etiquetas);
		regis.add(tel);
		tel.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c) && !Character.isDigit(c)) {
		            e.consume();
		    }
		}});
		
		ButtonGroup terminos = new ButtonGroup();
		
		JRadioButton term1 = new JRadioButton("Acepto los términos");
		term1.setBounds(332, 460, 150, 20);
		term1.setOpaque(false);
		regis.add(term1);
		
		JRadioButton term2 = new JRadioButton("No acepto los términos");
		term2.setBounds(492, 460, 160, 20);
		term2.setOpaque(false);
		regis.add(term2);
		
		terminos.add(term1);
		terminos.add(term2);
		
		JButton acceso = new JButton("Crear cuenta");
		acceso.setBounds(415, 510, 150, 30); 
		acceso.setBackground(Color.decode("#2435b1"));
		acceso.setOpaque(true);
		acceso.setFont(etiquetas);
		acceso.setHorizontalAlignment(JButton.CENTER);
		acceso.setForeground(Color.white);
		acceso.addActionListener(new ActionListener() {

		boolean bandera1 = false;
		boolean bandera2 = false;
		boolean bandera3 = false;
		boolean bandera4 = false;
		boolean bandera5 = false;
		boolean usuario2 = false;
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hola");
				
				if(nom.getText().equals("")) {//1
					nom.setBorder(BorderFactory.createLineBorder(Color.red));
				}
				else
					nom.setBorder(BorderFactory.createLineBorder(Color.green));
					bandera1 = true;
					
				if(correo.getText().equals("")) {//6
					correo.setBorder(BorderFactory.createLineBorder(Color.red));
				}
				else
					correo.setBorder(BorderFactory.createLineBorder(Color.green));
					bandera2 = true;
				
				if (amb.getSelectedIndex() == 0) { 
				    amb.setBorder(BorderFactory.createLineBorder(Color.red));
				} else {
				    amb.setBorder(BorderFactory.createLineBorder(Color.green));
				    bandera3 = true;
				}
				
				if(tel.getText().equals("")) {//5
					tel.setBorder(BorderFactory.createLineBorder(Color.red));	
				}
				else
					tel.setBorder(BorderFactory.createLineBorder(Color.green));
					bandera4 = true;
				if(!term1.isSelected()) {
					term1.setForeground(Color.red);
					term2.setForeground(Color.red);	
					JOptionPane.showMessageDialog(null, "No se aceptaron terminos y condiciones", "Terminos", JOptionPane.WARNING_MESSAGE);
				}
				else {
					term1.setForeground(Color.green);
					bandera5 = true;
				}
				
				if(bandera1 && bandera2 && bandera3 && bandera4 && bandera5) {
					String a = nom.getText();
					String f = correo.getText();
					String c = amb.getSelectedItem().toString();
					String t = tel.getText();
															
					usuario2 = um.add(a,f,c,t);
					
					System.out.println("Alta: "+ usuario2);
					
					if(usuario2) {
						JOptionPane.showMessageDialog(null, "Usuario dado de alta correctamente", "Alta Exitosa", JOptionPane.INFORMATION_MESSAGE);
						UserController uc = new UserController();
						frame.dispose();
						uc.usuarios();
					}
				}
					
			}
			
		});
		regis.add(acceso);
		
		JButton irLogin = new JButton("Volver");
		irLogin.setBounds(388, 550, 200,30);
		irLogin.setFont(et);
		irLogin.setVisible(true);
		irLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
			
		});
		
		regis.add(irLogin);
		
		frame.repaint();

		regis.repaint();
		
	}
	
	public void actualizar(User user) {
		JFrame frame = new JFrame();
		frame.setTitle("Actualizar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setVisible(true);
		frame.setBounds(0, 0, 1000, 700);
		frame.setLocationRelativeTo(null);
		
		JPanel regis = new JPanel();
		regis.setLayout(null);
		regis.setOpaque(false);
		regis.setBounds(0, 0, 1000, 700);
		frame.add(regis);
		
		image = new ImageIcon("src/images/fondo.png").getImage().getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
		i = new ImageIcon(image);
		JLabel fondo = new JLabel(i);
		fondo.setBounds(0,0,1000, 700);	
		frame.setContentPane(fondo);
		fondo.add(regis);
		
		JLabel etiqueta1 = new JLabel("Registro");
		etiqueta1.setSize(180,40);
		etiqueta1.setLocation(407, 15);
		etiqueta1.setOpaque(false);
		etiqueta1.setFont(titulo);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setForeground(Color.black); 
		regis.add(etiqueta1);

		JLabel nombre = new JLabel("Nombre");
		nombre.setBounds(197, 100, 90, 30);
		nombre.setOpaque(false);
		nombre.setFont(etiquetas);
		nombre.setHorizontalAlignment(JLabel.LEFT);
		regis.add(nombre);
		
		JTextField nom = new JTextField("");
		nom.setBounds(177, 140, 265, 30);
		nom.setBackground(Color.WHITE);
		nom.setOpaque(true);
		nom.setText(user.name);
		nom.setFont(etiquetas);
		regis.add(nom);
		nom.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
		            e.consume();
		    }
		}});
		
		JLabel etiqueta2 = new JLabel("Correo");
		etiqueta2.setBounds(197, 180, 90, 30);
		etiqueta2.setOpaque(false);
		etiqueta2.setFont(etiquetas);
		etiqueta2.setHorizontalAlignment(JLabel.LEFT);
		regis.add(etiqueta2);
		
		JTextField correo = new JTextField();
		correo.setBounds(177, 220, 265, 30);
		correo.setBackground(Color.WHITE);
		correo.setOpaque(true);
		correo.setText(user.email);
		correo.setFont(etiquetas);
		regis.add(correo);
		correo.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (Character.isWhitespace(c)) {
		            e.consume();
		        }
		    }
		});
		
		JLabel ambito = new JLabel("Rol");
		ambito.setBounds(197, 260, 100, 30);
		ambito.setOpaque(false);
		ambito.setFont(etiquetas);
		ambito.setHorizontalAlignment(JLabel.LEFT);
		regis.add(ambito);
		
		String[] ambitos = {".............................", "Gerente", "Finanzas", "Recursos Humanos", "Marketing", "Sistemas", "Otro"};
		
		JComboBox amb = new JComboBox(ambitos);
		amb.setBounds(177, 300, 265, 30);
		regis.add(amb);
		
		JLabel usuario = new JLabel("Teléfono");
		usuario.setBounds(197, 340, 180, 30);
		usuario.setOpaque(false);
		usuario.setFont(etiquetas);
		usuario.setHorizontalAlignment(JLabel.LEFT);
		regis.add(usuario);
		
		JTextField tel = new JTextField();
		tel.setBounds(177, 380, 265, 30);
		tel.setBackground(Color.WHITE);
		tel.setOpaque(true);
		tel.setText(user.cel);
		tel.setFont(etiquetas);
		regis.add(tel);
		tel.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c) && !Character.isDigit(c)) {
		            e.consume();
		    }
		}});
		
		JButton acceso = new JButton("Actualizar datos");
		acceso.setBounds(415, 510, 180, 30); 
		acceso.setBackground(Color.decode("#2435b1"));
		acceso.setOpaque(true);
		acceso.setFont(etiquetas);
		acceso.setHorizontalAlignment(JButton.CENTER);
		acceso.setForeground(Color.white);
		acceso.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String a = nom.getText();
				String f = correo.getText();
				String c = amb.getSelectedItem().toString();
				String t = tel.getText();
				
				UserController uc = new UserController();
				User updatedUser = new User(user.id, a, f, c, t, user.create, user.update);
				um = new UserModel();
				if(um.update(updatedUser)) {
					JOptionPane.showMessageDialog(null, "Usuario modificado correctamente", "Alta Exitosa", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					uc.usuarios();
				}
				
			};
		});
		regis.add(acceso);
		
		JButton irLogin = new JButton("Volver");
		irLogin.setBounds(388, 550, 200,30);
		irLogin.setFont(et);
		irLogin.setVisible(true);
		irLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				UserController uc = new UserController();
				frame.dispose();
				uc.usuarios();
			}
		
		});
		regis.add(irLogin);
		
		frame.repaint();

		regis.repaint();
		
	}

	public void eliminar(int id) {
		
	}
}
