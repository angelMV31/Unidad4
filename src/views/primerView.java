package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import models.primerModel;

public class primerView extends JFrame{
	
	public primerModel functions;

	Font titulo = new Font("Arial", Font.BOLD, 31);
	Font etiquetas = new Font("Arial", Font.BOLD,17);
	Font et = new Font("Arial", Font.BOLD,13);
	
	ImageIcon i;
	Image image;
	ImageIcon ic2;
	Image icon2;
	Image icono2;
	Image i2;
	
	public primerView(String title) {
		
		functions = new primerModel();
		
		this.setTitle(title);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(1000, 700);

		this.setLocationRelativeTo(null);
		
		this.setResizable(true);
		
		this.add(this.login());
		
		//this.setMinimumSize(new Dimension(200,430));
		//this.setMaximumSize(new Dimension(600,830));
		JMenuBar barra = new JMenuBar(); //barra de munus
		
		JMenu menu3 = new JMenu("Cuenta");
		JMenuItem lg = new JMenuItem("Login");
		JMenuItem rg = new JMenuItem("Registro");
		JMenuItem hm = new JMenuItem("Home");
		
		menu3.add(lg);
		menu3.add(rg);
		menu3.add(hm);
		
		lg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				manager("login");
			}
			
		});
		rg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				manager("registro");
			}
			
		});
		
		hm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				manager("home");
			}
			
		});
		
		barra.add(menu3);
		
		this.setVisible(true);
		this.setJMenuBar(barra);
		this.validate();
		this.revalidate();
		this.repaint();
		
	}
	
	public JPanel login() {
		JPanel login = new JPanel();
		login.setLocation(0, 0);
		login.setSize(1000, 700);
		login.setOpaque(true);
		login.setBackground(Color.black);
		login.setVisible(true);
		login.setLayout(null);
		login.setBackground(Color.blue);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(0, 0, 1000, 700);
		this.add(panel);
		
		image = new ImageIcon("src/images/fondo.png").getImage().getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
		i = new ImageIcon(image);
		JLabel fondo = new JLabel(i);
		fondo.setBounds(0,0,1000,700);	
		this.setContentPane(fondo);
		
		ImageIcon capiIcon = new ImageIcon("src/images/capi.png");
		this.setIconImage(capiIcon.getImage());
		
		JLabel etiqueta1 = new JLabel("Bienvenidos");
		etiqueta1.setSize(190,40);
		etiqueta1.setLocation(400, 30);
		//etiqueta1.setBackground(Color.decode("#fc86eb"));
		etiqueta1.setOpaque(false);
		etiqueta1.setForeground(Color.decode("#000000"));
		etiqueta1.setFont(titulo);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(etiqueta1);
		
		
		Image ic = new ImageIcon("src/images/capi.png").getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		ic2 = new ImageIcon(ic);
		JLabel capi = new JLabel(ic2);
		capi.setBounds(445, 88, 100, 100);
		panel.add(capi);
		
		JLabel etiqueta2 = new JLabel("Usuario");
		etiqueta2.setBounds(390, 200, 90, 30);
		//etiqueta2.setSize(80,30);
		//etiqueta2.setLocation(55, 50);
		//etiqueta2.setBackground(Color.decode("#fc86eb"));
		etiqueta2.setOpaque(false);
		etiqueta2.setFont(etiquetas);
		etiqueta2.setHorizontalAlignment(JLabel.LEFT);
		panel.add(etiqueta2);
		
		icono2 = new ImageIcon("src/images/usuario.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icono = new ImageIcon(icono2);
		JLabel usuario = new JLabel(icono);
		usuario.setBounds(350, 200, 30, 30);
		panel.add(usuario);
		
		JTextField correo = new JTextField();
		correo.setBounds(372, 250, 247, 30);
		correo.setBackground(Color.WHITE);
		correo.setOpaque(true);
		correo.setFont(etiquetas);
		panel.add(correo);
		
		icon2 = new ImageIcon("src/images/lok.png").getImage().getScaledInstance(38, 38, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(icon2);
		JLabel lock = new JLabel(icon);
		lock.setBounds(350, 300, 38, 38);
		panel.add(lock);

		JLabel etiqueta3 = new JLabel("Contraseña");
		etiqueta3.setBounds(390, 305, 95, 30);
		//etiqueta3.setBackground(Color.decode("#fc86eb"));
		etiqueta3.setOpaque(false);
		etiqueta3.setFont(etiquetas);
		etiqueta3.setHorizontalAlignment(JLabel.LEFT);
		panel.add(etiqueta3);
		
		JPasswordField pase = new JPasswordField();
		pase.setBounds(372, 350, 247, 30);
		pase.setBackground(Color.WHITE);
		pase.setFont(etiquetas);
		panel.add(pase);
		
		Image i2 = new ImageIcon("src/images/see.png").getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(i2);
		JLabel see = new JLabel(icon2);
		see.setBounds(627, 352, 25, 25);
		see.setVisible(true);
		panel.add(see);
		
		JCheckBox check = new JCheckBox();
		check.setBounds(340, 400, 15, 15);
		check.setBackground(Color.WHITE);
		check.setOpaque(true);
		check.setFont(etiquetas);
		check.setHorizontalAlignment(JButton.CENTER);
		panel.add(check);
		
		JLabel etiqueta4 = new JLabel("Recuerdarme");
		etiqueta4.setBounds(362, 392, 90, 30);
		//etiqueta4.setBackground(Color.decode("#fc86eb"));
		etiqueta4.setOpaque(false);
		etiqueta4.setFont(et);
		etiqueta4.setHorizontalAlignment(JLabel.CENTER);
		panel.add(etiqueta4);
		
		JButton forgot = new JButton("¿Olvidaste tu contraseña?");
		forgot.setBounds(465, 400, 195, 15);
		forgot.setContentAreaFilled(false); // Quita el fondo del botón
		forgot.setForeground(Color.RED);
		forgot.setOpaque(false);
		forgot.setFont(et);
		forgot.setHorizontalAlignment(JLabel.RIGHT);
		forgot.setBorderPainted(false);
		panel.add(forgot);

		JButton acceso = new JButton("Ingresar");
		acceso.setBounds(418, 465, 150, 30); 
		acceso.setBackground(Color.decode("#2435b1"));
		acceso.setOpaque(true);
		acceso.setForeground(Color.WHITE);
		acceso.setFont(etiquetas);
		acceso.setHorizontalAlignment(JButton.CENTER);
		acceso.addActionListener(new ActionListener() {

		boolean band1=false;
		boolean band2=false;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Datos");
				System.out.println(correo.getText());
				System.out.println(pase.getText());
				
				String message = "Datos Correctos, Bienvenido";
				String message2 = "Datos Incorrectos";
				
				String passText = new String(pase.getPassword()); // Obtener el texto de la contraseña
				String user = correo.getText();               // Obtener el texto del correo

				if (passText.equals("")) {
					pase.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				} else {
					pase.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
					band1 = true;
				}

				if (user.equals("")) {
					correo.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
				} else {
					correo.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
					band2 = true;
				}

				if (band1 && band2) {
					
					boolean usuario = functions.access(user, passText);

					if (usuario) {
						JOptionPane.showMessageDialog(null, message, "Estatus", JOptionPane.INFORMATION_MESSAGE);
						
						manager("home");
					} else {
						JOptionPane.showMessageDialog(null, message2, "Estatus", JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, message2, "Estatus", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		});
		
		panel.add(acceso);

		JButton irRegistro = new JButton("Aun no tienes una cuenta");
		irRegistro.setBounds(388, 525, 200,30);
		irRegistro.setFont(et);
		irRegistro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				manager("registro");
			}
			
		});
		 
		panel.add(irRegistro);
		
		panel.revalidate();
		
		panel.repaint();
		
		return panel;
		

	}
	
	public JPanel registro() {
		JPanel regis = new JPanel();
		regis.setLayout(null);
		regis.setOpaque(false);
		regis.setBounds(0, 0, 1000, 700);
		this.add(regis);
		
		image = new ImageIcon("src/images/fondo.png").getImage().getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
		i = new ImageIcon(image);
		JLabel fondo = new JLabel(i);
		fondo.setBounds(0,0,1000, 700);	
		this.setContentPane(fondo);
		
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
		
		JLabel empresa = new JLabel("Empresa");
		empresa.setBounds(197, 180, 90, 30);
		empresa.setOpaque(false);
		empresa.setFont(etiquetas);
		empresa.setHorizontalAlignment(JLabel.LEFT);
		regis.add(empresa);
		
		JTextField empresa2 = new JTextField();
		empresa2.setBounds(177, 220, 265, 30);
		empresa2.setBackground(Color.WHITE);
		empresa2.setOpaque(true);
		empresa2.setFont(etiquetas);
		regis.add(empresa2);
		
		JLabel ambito = new JLabel("Ambito");
		ambito.setBounds(197, 260, 100, 30);
		ambito.setOpaque(false);
		ambito.setFont(etiquetas);
		ambito.setHorizontalAlignment(JLabel.LEFT);
		regis.add(ambito);
		
		String[] ambitos = {".............................", "Tecnologia", "Ciencia", "Salud", "Educacion", "Comercio", "Otro"};
		
		JComboBox amb = new JComboBox(ambitos);
		amb.setBounds(177, 300, 265, 30);
		regis.add(amb);

		JLabel roll = new JLabel("Rol");
		roll.setBounds(197, 340, 90, 30);
		roll.setOpaque(false);
		roll.setFont(etiquetas);
		roll.setHorizontalAlignment(JLabel.LEFT);
		regis.add(roll);
		
		JTextField rol = new JTextField();
		rol.setBounds(177, 380, 265, 30);
		rol.setBackground(Color.WHITE);
		rol.setOpaque(true);
		rol.setFont(etiquetas);
		regis.add(rol);
		
		JLabel usuario = new JLabel("Nombre de Usuario");
		usuario.setBounds(577, 100, 180, 30);
		usuario.setOpaque(false);
		usuario.setFont(etiquetas);
		usuario.setHorizontalAlignment(JLabel.LEFT);
		regis.add(usuario);
		
		JTextField usu = new JTextField();
		usu.setBounds(557, 140, 265, 30);
		usu.setBackground(Color.WHITE);
		usu.setOpaque(true);
		usu.setFont(etiquetas);
		regis.add(usu);
		
		JLabel etiqueta2 = new JLabel("Correo");
		etiqueta2.setBounds(577, 180, 90, 30);
		etiqueta2.setOpaque(false);
		etiqueta2.setFont(etiquetas);
		etiqueta2.setHorizontalAlignment(JLabel.LEFT);
		regis.add(etiqueta2);
		
		JTextField correo = new JTextField();
		correo.setBounds(557, 220, 265, 30);
		correo.setBackground(Color.WHITE);
		correo.setOpaque(true);
		correo.setFont(etiquetas);
		regis.add(correo);
		
		JLabel contras = new JLabel("Contraseña");
		contras.setBounds(577, 260, 100, 30);
		contras.setOpaque(false);
		contras.setFont(etiquetas);
		contras.setHorizontalAlignment(JLabel.LEFT);
		regis.add(contras);
		
		JTextField contra = new JTextField();
		contra.setBounds(557, 300, 265, 30);
		contra.setBackground(Color.WHITE);
		contra.setOpaque(true);
		contra.setFont(etiquetas);
		regis.add(contra);
		
		JLabel RepContras = new JLabel("Confirmar contraseña");
		RepContras.setBounds(577, 340, 200, 30);
		RepContras.setOpaque(false);
		RepContras.setFont(etiquetas);
		RepContras.setHorizontalAlignment(JLabel.LEFT);
		regis.add(RepContras);
		
		JTextField RepContras2 = new JTextField();
		RepContras2.setBounds(557, 380, 265, 30);
		RepContras2.setBackground(Color.WHITE);
		RepContras2.setOpaque(true);
		RepContras2.setFont(etiquetas);
		regis.add(RepContras2);
		
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

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hola");
				
				if(nom.getText().equals("")) {//1
					nom.setBorder(BorderFactory.createLineBorder(Color.red));
				}
				else
					nom.setBorder(BorderFactory.createLineBorder(Color.green));
				if(empresa2.getText().equals("")) {//2
					empresa2.setBorder(BorderFactory.createLineBorder(Color.red));
				}
				else
					empresa2.setBorder(BorderFactory.createLineBorder(Color.green));
				if(rol.getText().equals("")) {//4
					rol.setBorder(BorderFactory.createLineBorder(Color.red));	
				}
				else
					rol.setBorder(BorderFactory.createLineBorder(Color.green));
				if(usu.getText().equals("")) {//5
					usu.setBorder(BorderFactory.createLineBorder(Color.red));	
				}
				else
					usu.setBorder(BorderFactory.createLineBorder(Color.green));
				if(correo.getText().equals("")) {//6
					correo.setBorder(BorderFactory.createLineBorder(Color.red));
				}
				else
					correo.setBorder(BorderFactory.createLineBorder(Color.green));
				if(contra.getText().equals("")) {//7
					contra.setBorder(BorderFactory.createLineBorder(Color.red));	
				}
				else
					contra.setBorder(BorderFactory.createLineBorder(Color.green));
				if(RepContras2.getText().equals("")) {//8
					RepContras2.setBorder(BorderFactory.createLineBorder(Color.red));	
				}
				else
					RepContras2.setBorder(BorderFactory.createLineBorder(Color.green));
				if(!term1.isSelected() && !term2.isSelected()) {
					term1.setForeground(Color.red);
					term2.setForeground(Color.red);				}
				else {
					term1.setForeground(Color.green);
					term2.setForeground(Color.green);
				}
				if (amb.getSelectedIndex() == 0) { 
				    amb.setBorder(BorderFactory.createLineBorder(Color.red));
				} else {
				    amb.setBorder(BorderFactory.createLineBorder(Color.green));
				}
					
					
			}
			
		});
		regis.add(acceso);
		
		JButton irLogin = new JButton("Volver al inicio");
		irLogin.setBounds(388, 550, 200,30);
		irLogin.setFont(et);
		irLogin.setVisible(true);
		irLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				manager("login");
			}
			
		});
		
		this.add(irLogin);
		
		return regis;
	}
	
	public JPanel home() {
		
		JPanel login = new JPanel();
		login.setLocation(0, 0);
		login.setSize(1000, 700);
		login.setOpaque(true);
		login.setBackground(Color.black);
		login.setVisible(true);
		login.setLayout(null);
		login.setBackground(Color.blue);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(0, 0, 1000, 700);
		this.add(panel);
		
		image = new ImageIcon("src/images/fondo.png").getImage().getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
		i = new ImageIcon(image);
		JLabel fondo = new JLabel(i);
		fondo.setBounds(0,0,1000,700);	
		this.setContentPane(fondo);
		
		JLabel etiqueta1 = new JLabel("Home");
		etiqueta1.setSize(190,40);
		etiqueta1.setLocation(400, 30);
		etiqueta1.setOpaque(false);
		etiqueta1.setForeground(Color.decode("#000000"));
		etiqueta1.setFont(titulo);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(etiqueta1);
		
		Image ic = new ImageIcon("src/images/capi.png").getImage().getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH);
		ic2 = new ImageIcon(ic);
		JLabel capi = new JLabel(ic2);
		capi.setBounds(100, 188, 350, 350);
		panel.add(capi);
		
		JLabel etiqueta2 = new JLabel("Servicios");
		etiqueta2.setBounds(650, 250, 150, 40);
		etiqueta2.setOpaque(false);
		etiqueta2.setForeground(Color.white);
		etiqueta2.setFont(titulo);
		etiqueta2.setHorizontalAlignment(JLabel.LEFT);
		panel.add(etiqueta2);
		
		panel.revalidate();
		
		panel.repaint();
		
		return panel;
		
	}
	
	public void manager(String target) {
		
		this.getContentPane().removeAll();
		
		if(target.equals("registro")) {
			this.add(registro());			
		}
		if(target.equals("login")) {
			this.add(login());			
		}
		if(target.equals("home")) {
			this.add(home());			
		}
		
		this.repaint();
		this.revalidate();
		
		System.out.println("Hola");
	}
	
}
