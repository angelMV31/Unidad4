package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import controllers.primerController;
import models.User;


public class UserView {

	ImageIcon i;
	Image image;
	Font titulo = new Font("Arial", Font.BOLD, 31);
	Font etiquetas = new Font("Arial", Font.BOLD,17);
	Font et = new Font("Arial", Font.BOLD,13);
	
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
	    
	    int y = 10;
	    
	    for(Iterator iterator = users.iterator(); iterator.hasNext();) {
	    	User user = (User) iterator.next();
	    	
	    	JLabel userLabel = new JLabel(user.name, SwingConstants.CENTER);
	    	userLabel.setFont(etiquetas);
	    	userLabel.setBounds(10, y, 200, 30);
	    	tarjeta1.add(userLabel);
	    	
	    	y+=40;
	    }
		
		JButton add = new JButton("Volver");
		add.setBounds(700, 550, 200, 30);
		add.setFont(etiquetas);
		add.setBackground(Color.BLUE);
		add.setForeground(Color.white);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
				primerController view = new primerController();
				view.login();
			}
			
		});
		fondo.add(add);
		 
	}
	
}
