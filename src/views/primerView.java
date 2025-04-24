package views;

import java.awt.Color;
import java.awt.Font;
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
		
		menu3.add(lg);
		menu3.add(rg);
		
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(0, 0, 1000, 700);
		this.add(panel);
		ImageIcon i = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage().getScaledInstance(1000, 700, java.awt.Image.SCALE_SMOOTH));
		JLabel fondo = new JLabel(i);
		fondo.setBounds(0,0,1000,700);	
		this.setContentPane(fondo);
		
		ImageIcon capiIcon = new ImageIcon("images/capi.png");
		this.setIconImage(capiIcon.getImage());
		
		JLabel etiqueta1 = new JLabel("Bienvenidos");
		etiqueta1.setSize(190,40);
		etiqueta1.setLocation(400, 30);
		//etiqueta1.setBackground(Color.decode("#fc86eb"));
		etiqueta1.setOpaque(false);
		etiqueta1.setForeground(Color.decode("#FFFFFF"));
		etiqueta1.setFont(titulo);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(etiqueta1);
		
		ImageIcon ic = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/capi.png")).getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		JLabel capi = new JLabel(ic);
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
		
		ImageIcon icono = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/usuario.png")).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		JLabel usuario = new JLabel(icono);
		usuario.setBounds(350, 200, 30, 30);
		panel.add(usuario);
		
		JTextField correo = new JTextField();
		correo.setBounds(372, 250, 247, 30);
		correo.setBackground(Color.WHITE);
		correo.setOpaque(true);
		correo.setFont(etiquetas);
		panel.add(correo);
		
		ImageIcon icon = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/lok.png")).getImage().getScaledInstance(38, 38, java.awt.Image.SCALE_SMOOTH));
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
		
		ImageIcon icon2 = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/see.png")).getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH));
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
		
		return panel;
		

	}
	
	public JPanel registro() {
		JPanel regis = new JPanel();
		regis.setLayout(null);
		regis.setOpaque(false);
		regis.setBounds(0, 0, 1000, 700);
		this.add(regis);
		ImageIcon i = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage().getScaledInstance(1000, 700, java.awt.Image.SCALE_SMOOTH));
		JLabel fondo = new JLabel(i);
		fondo.setBounds(0,0,1000, 700);	
		this.setContentPane(fondo);
		
		JLabel etiqueta1 = new JLabel("Registro");
		etiqueta1.setSize(180,40);
		etiqueta1.setLocation(407, 15);
		etiqueta1.setOpaque(false);
		etiqueta1.setFont(titulo);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		etiqueta1.setForeground(Color.white); 
		regis.add(etiqueta1);
		
		JLabel etiqueta2 = new JLabel("Usuario");
		etiqueta2.setBounds(367, 60, 90, 30);
		//etiqueta2.setSize(80,30);
		//etiqueta2.setLocation(55, 50);
		//etiqueta2.setBackground(new Color(0, 0, 0, 0));
		etiqueta2.setOpaque(false);
		etiqueta2.setFont(etiquetas);
		etiqueta2.setHorizontalAlignment(JLabel.LEFT);
		regis.add(etiqueta2);
		
		JTextField correo = new JTextField();
		correo.setBounds(357, 100, 265, 30);
		correo.setBackground(Color.WHITE);
		correo.setOpaque(true);
		correo.setFont(etiquetas);
		regis.add(correo);

		JLabel etiqueta3 = new JLabel("Biografía");
		etiqueta3.setBounds(367, 140, 90, 30);
		//etiqueta3.setBackground(new Color(0, 0, 0, 0));
		etiqueta3.setOpaque(false);
		etiqueta3.setFont(etiquetas);
		etiqueta3.setHorizontalAlignment(JLabel.LEFT);
		regis.add(etiqueta3);
		
		JTextField bio = new JTextField();
		bio.setBounds(357, 170, 265, 50);
		bio.setBackground(Color.WHITE);
		bio.setOpaque(true);
		bio.setFont(etiquetas);
		regis.add(bio);
		
		ButtonGroup opc = new ButtonGroup();
		
		JLabel etiqueta4 = new JLabel("Preferiencias");
		etiqueta4.setBounds(427, 225, 110, 50);
		//etiqueta4.setBackground(new Color(0, 0, 0, 0));
		etiqueta4.setOpaque(false);
		etiqueta4.setFont(etiquetas);
		etiqueta4.setHorizontalAlignment(JLabel.LEFT);
		regis.add(etiqueta4);
		
		JRadioButton check = new JRadioButton("Dulce");
		check.setBounds(354, 280, 75, 15);
		check.setOpaque(false);
		check.setFont(etiquetas);
		check.setHorizontalAlignment(JButton.CENTER);
		regis.add(check);
		
		JRadioButton check2 = new JRadioButton("Salado");
		check2.setBounds(432, 280, 80, 15);
		check2.setOpaque(false);
		check2.setFont(etiquetas);
		check2.setHorizontalAlignment(JButton.CENTER);
		regis.add(check2);
		
		JRadioButton check3 = new JRadioButton("Saludable");
		check3.setBounds(522, 280, 110, 15);
		check3.setOpaque(false);
		check3.setFont(etiquetas);
		check3.setHorizontalAlignment(JButton.CENTER);
		regis.add(check3);
		
		opc.add(check);
		opc.add(check2);
		opc.add(check3);
		
		String[] colonias = {"Centro", "Villas del Encanto", "Miramar", "Camino Real", "Indeco"};
		
		JComboBox col = new JComboBox(colonias);
		col.setBounds(407, 320, 150, 30);
		regis.add(col);
		
		ButtonGroup terminos = new ButtonGroup();
		
		JRadioButton term1 = new JRadioButton("Acepto los términos");
		term1.setBounds(332, 370, 150, 20);
		term1.setOpaque(false);
		regis.add(term1);
		
		JRadioButton term2 = new JRadioButton("No acepto los términos");
		term2.setBounds(492, 370, 160, 20);
		term2.setOpaque(false);
		regis.add(term2);
		
		terminos.add(term1);
		terminos.add(term2);
		
		JButton acceso = new JButton("Crear cuenta");
		acceso.setBounds(407, 435, 150, 30); 
		acceso.setBackground(Color.decode("#2435b1"));
		acceso.setOpaque(true);
		acceso.setFont(etiquetas);
		acceso.setHorizontalAlignment(JButton.CENTER);
		acceso.setForeground(Color.white);
		acceso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hola");
				
				if(correo.getText().equals("")) {
					correo.setBorder(BorderFactory.createLineBorder(Color.red));
				}
				else
					correo.setBorder(BorderFactory.createLineBorder(Color.green));
				
				if(bio.getText().equals("")) {
					bio.setBorder(BorderFactory.createLineBorder(Color.red));	
				}
				else
					bio.setBorder(BorderFactory.createLineBorder(Color.green));
				
				if(!term1.isSelected() && !term2.isSelected()) {
					term1.setForeground(Color.red);
					term2.setForeground(Color.red);				}
				else {
					term1.setForeground(Color.green);
					term2.setForeground(Color.green);
				}
					
			}
			
		});
		regis.add(acceso);
		
		JButton irLogin = new JButton("Volver al inicio");
		irLogin.setBounds(388, 510, 200,30);
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
	
	public void manager(String target) {
		
		this.getContentPane().removeAll();
		
		if(target.equals("registro")) {
			this.add(registro());			
		}
		if(target.equals("login")) {
			this.add(login());			
		}
		
		this.repaint();
		this.revalidate();
		
		System.out.println("Hola");
	}
	
}
