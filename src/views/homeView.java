package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controllers.ProductController;
import controllers.homeControl;
import models.homeModel;
import models.primerModel;

public class homeView extends JFrame{
	
	public homeControl hm;
	public ProductController prod;
	public LocalDateTime tiempo;
	
	ImageIcon i;
	Image image;
	ImageIcon ic2;
	Image icon2;
	Image icono2;
	Image i2;
	Font titulo = new Font("Arial", Font.BOLD, 31);
	Font etiquetas = new Font("Arial", Font.BOLD,17);
	Font et = new Font("Arial", Font.BOLD,14);
	private JFrame frame = new JFrame();;

	public homeView(String title) {
		
		setTitle(title);
		home();
	}
	
	
	public void home() {
		frame.setTitle("Home");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(0, 0, 1000, 700);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);

	    image = new ImageIcon("src/images/fondo.png").getImage().getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
	    i = new ImageIcon(image);
	    JLabel fondo = new JLabel(i);
	    fondo.setBounds(0, 0, 1000, 700);
	    fondo.setLayout(null);
	    frame.setContentPane(fondo);

	    ImageIcon capiIcon = new ImageIcon("src/images/capi.png");
	    frame.setIconImage(capiIcon.getImage());

	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    panel.setOpaque(false);
	    panel.setBounds(0, 0, 1000, 700);
	    fondo.add(panel);

	    JLabel barra = new JLabel();
	    barra.setOpaque(true);
	    barra.setBackground(new Color(0, 51, 102));
	    barra.setBounds(0, 0, 1000, 60);
	    panel.add(barra);

	    JLabel etiqueta1 = new JLabel("Home");
		etiqueta1.setSize(190,40);
		etiqueta1.setLocation(400, 15);
		etiqueta1.setOpaque(false);
		etiqueta1.setForeground(Color.decode("#ffffff"));
		etiqueta1.setFont(titulo);
		etiqueta1.setHorizontalAlignment(JLabel.CENTER);
		barra.add(etiqueta1);

	    JPanel panelBotones = new JPanel();
	    panelBotones.setBounds(0, 60, 200, 640);
	    panelBotones.setBackground(new Color(0, 51, 102));
	    panelBotones.setLayout(null);
	    panel.add(panelBotones);

	    image = new ImageIcon("src/images/inicio.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    i = new ImageIcon(image);
	    JLabel i1 = new JLabel(i);
	    i1.setBounds(5, 30, 20, 20);
	    panelBotones.add(i1);
	    JButton btnInicio = new JButton("Inicio");
	    btnInicio.setBounds(30, 20, 160, 35);
	    btnInicio.setFont(etiquetas);
	    btnInicio.setForeground(Color.WHITE);
	    btnInicio.setBackground(new Color(0, 102, 204));
	    panelBotones.add(btnInicio);

	    image = new ImageIcon("src/images/usuario.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    i = new ImageIcon(image);
	    JLabel u2 = new JLabel(i);
	    u2.setBounds(5, 80, 20, 20);
	    panelBotones.add(u2);
	    JButton btnUsuarios = new JButton("Usuarios");
	    btnUsuarios.setBounds(30, 70, 160, 35);
	    btnUsuarios.setFont(etiquetas);
	    btnUsuarios.setForeground(Color.WHITE);
	    btnUsuarios.setBackground(new Color(0, 102, 204));
	    panelBotones.add(btnUsuarios);

	    image = new ImageIcon("src/images/registro.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    i = new ImageIcon(image);
	    JLabel r1 = new JLabel(i);
	    r1.setBounds(5, 130, 20, 20);
	    panelBotones.add(r1);
	    JButton btnRegistros = new JButton("Registros");
	    btnRegistros.setBounds(30, 120, 160, 35);
	    btnRegistros.setFont(etiquetas);
	    btnRegistros.setForeground(Color.WHITE);
	    btnRegistros.setBackground(new Color(0, 102, 204));
	    panelBotones.add(btnRegistros);

	    image = new ImageIcon("src/images/catalogo.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
	    i = new ImageIcon(image);
	    JLabel c1 = new JLabel(i);
	    c1.setBounds(5, 180, 20, 20);
	    panelBotones.add(c1);
	    JButton btnCatalogo = new JButton("Catálogo");
	    btnCatalogo.setBounds(30, 170, 160, 35);
	    btnCatalogo.setFont(etiquetas);
	    btnCatalogo.setForeground(Color.WHITE);
	    btnCatalogo.setBackground(new Color(0, 102, 204));
	    btnCatalogo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				prod = new ProductController();
			}	
	    });
	    panelBotones.add(btnCatalogo);

	    image = new ImageIcon("src/images/not.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    i = new ImageIcon(image);
	    JLabel n1 = new JLabel(i);
	    n1.setBounds(5, 230, 20, 20);
	    panelBotones.add(n1);
	    JButton btnNotificaciones = new JButton("Notificaciones");
	    btnNotificaciones.setBounds(30, 220, 160, 35);
	    btnNotificaciones.setFont(etiquetas);
	    btnNotificaciones.setForeground(Color.WHITE);
	    btnNotificaciones.setBackground(new Color(0, 102, 204));
	    panelBotones.add(btnNotificaciones);

	    image = new ImageIcon("src/images/ajustes.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    i = new ImageIcon(image);
	    JLabel cc1 = new JLabel(i);
	    cc1.setBounds(5, 280, 20, 20);
	    panelBotones.add(cc1);
	    JButton btnConfiguracion = new JButton("Configuración");
	    btnConfiguracion.setBounds(30, 270, 160, 35);
	    btnConfiguracion.setFont(etiquetas);
	    btnConfiguracion.setForeground(Color.WHITE);
	    btnConfiguracion.setBackground(new Color(0, 102, 204));
	    panelBotones.add(btnConfiguracion);

	    image = new ImageIcon("src/images/ayuda.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    i = new ImageIcon(image);
	    JLabel a = new JLabel(i);
	    a.setBounds(5, 330, 20, 20);
	    panelBotones.add(a);
	    JButton btnAyuda = new JButton("Ayuda");
	    btnAyuda.setBounds(30, 320, 160, 35);
	    btnAyuda.setFont(etiquetas);
	    btnAyuda.setForeground(Color.WHITE);
	    btnAyuda.setBackground(new Color(0, 102, 204));
	    panelBotones.add(btnAyuda);

	    image = new ImageIcon("src/images/cerrarces.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    i = new ImageIcon(image);
	    JLabel cs = new JLabel(i);
	    cs.setBounds(5, 380, 20, 20);
	    panelBotones.add(cs);
	    JButton btnCerrarSesion = new JButton("Cerrar sesión");
	    btnCerrarSesion.setBounds(30, 370, 160, 35);
	    btnCerrarSesion.setFont(etiquetas);
	    btnCerrarSesion.setForeground(Color.WHITE);
	    btnCerrarSesion.setBackground(new Color(204, 0, 0));
	    panelBotones.add(btnCerrarSesion);
	    
	    image = new ImageIcon("src/images/capi.png").getImage().getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
	    i = new ImageIcon(image);
	    JLabel logo = new JLabel(i);
	    logo.setBounds(20, 430, 160, 160);
	    panelBotones.add(logo);

	    JPanel tarjeta1 = new JPanel();
	    tarjeta1.setBounds(250, 100, 220, 160);
	    tarjeta1.setBackground(new Color(255, 255, 255));
	    tarjeta1.setLayout(null);
	    panel.add(tarjeta1);

	    image = new ImageIcon("src/images/g22.png").getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
	    i = new ImageIcon(image);
	    JLabel icono1 = new JLabel(i);
	    icono1.setBounds(10, 10, 64, 64);
	    tarjeta1.add(icono1);

	    JLabel label1 = new JLabel("Ventas");
	    label1.setFont(etiquetas);
	    label1.setBounds(10, 90, 200, 30);
	    tarjeta1.add(label1);

	    JLabel valor1 = new JLabel("$1,500");
	    valor1.setFont(et);
	    valor1.setBounds(10, 120, 200, 20);
	    tarjeta1.add(valor1);

	    JPanel tarjeta2 = new JPanel();
	    tarjeta2.setBounds(500, 100, 220, 160);
	    tarjeta2.setBackground(new Color(255, 255, 255));
	    tarjeta2.setLayout(null);
	    panel.add(tarjeta2);

	    image = new ImageIcon("src/images/r2.png").getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
	    i = new ImageIcon(image);
	    JLabel icono2 = new JLabel(i);
	    icono2.setBounds(10, 10, 64, 64);
	    tarjeta2.add(icono2);

	    JLabel label2 = new JLabel("Hora");
	    label2.setFont(etiquetas);
	    label2.setBounds(10, 90, 200, 30);
	    tarjeta2.add(label2);

	    // Crear el JLabel
	    JLabel valor2 = new JLabel();
	    valor2.setFont(et); // Usa tu fuente personalizada
	    valor2.setBounds(10, 120, 200, 30);
	    tarjeta2.add(valor2); // tarjeta2 es tu panel o contenedor

	    // Formato de la hora
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	    // Timer para actualizar cada segundo
	    Timer timer = new Timer(1000, e -> {
	        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Mazatlan"));
	        valor2.setText(now.format(formatter) + " La Paz BCS");
	    });
	    timer.start();

	    JPanel tarjeta3 = new JPanel();
	    tarjeta3.setBounds(250, 300, 220, 160);
	    tarjeta3.setBackground(new Color(255, 255, 255));
	    tarjeta3.setLayout(null);
	    panel.add(tarjeta3);

	    image = new ImageIcon("src/images/productos.png").getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
	    i = new ImageIcon(image);
	    JLabel icono3 = new JLabel(i);
	    icono3.setBounds(10, 10, 64, 64);
	    tarjeta3.add(icono3);

	    JLabel label3 = new JLabel("Productos activos");
	    label3.setFont(etiquetas);
	    label3.setBounds(10, 90, 200, 30);
	    tarjeta3.add(label3);

	    JLabel valor3 = new JLabel("142");
	    valor3.setFont(et);
	    valor3.setBounds(10, 120, 200, 20);
	    tarjeta3.add(valor3);

	    JPanel tarjeta4 = new JPanel();
	    tarjeta4.setBounds(500, 300, 220, 160);
	    tarjeta4.setBackground(new Color(255, 255, 255));
	    tarjeta4.setLayout(null);
	    panel.add(tarjeta4);

	    image = new ImageIcon("src/images/noti.png").getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
	    i = new ImageIcon(image);
	    JLabel icono4 = new JLabel(i);
	    icono4.setBounds(10, 10, 64, 64);
	    tarjeta4.add(icono4);

	    JLabel label4 = new JLabel("Notificaciones");
	    label4.setFont(etiquetas);
	    label4.setBounds(10, 90, 200, 30);
	    tarjeta4.add(label4);

	    JLabel valor4 = new JLabel("5 nuevas");
	    valor4.setFont(et);
	    valor4.setBounds(10, 120, 200, 20);
	    tarjeta4.add(valor4);

	    frame.repaint();
	    panel.repaint();
	}
}

