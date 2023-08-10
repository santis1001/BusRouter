import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Clases.Usuarios;



public class IInicio extends JFrame implements ActionListener {
	
	JLabel bus;
	JButton  reservar, salir, admin;
	JLabel adm, usu, con;
	JButton  AceptarInicio, cancelar;
	JTextField Us ;
	JPasswordField cont;
	Container frame;
	public static int c = 1;
	public static int contV = 0, contA= 0, contC= 0, contD= 0, contP= 0;
	public static int acceso;
	static IInicio Inicio;
	
	
	public static void main(String[]args)
	{		
		
		Inicio();
		
	}
	
	public static void Inicio() {
		Inicio = new IInicio();
		Inicio.ventanaInicio();
		Inicio.setBounds(785,415,300,200);
		Inicio.setTitle("Selecciona Opcion");
		Inicio.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	public void ventanaInicio()
	{
		frame = this.getContentPane();
		frame.setLayout(null);
		setVisible(true);
		frame.setBackground(new Color(51,51,51));
		
		bus = new JLabel("Reservacion de Autobus");
		bus.setBounds(10,10,200,20);
		bus.setForeground(new Color(239, 156, 0));
		bus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		reservar = new JButton("Reservar");
		reservar.addActionListener(this);
		reservar.setBounds(35,60,215,40);
		reservar.setBackground(new Color(239, 156, 0));
		reservar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		salir = new JButton("Salir");
		salir.addActionListener(this);
		salir.setBounds(35,120,100,25);
		salir.setBackground(new Color(239, 156, 0));
		salir.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		admin = new JButton("Admin");
		admin.addActionListener(this);
		admin.setBounds(150,120,100,25);
		admin.setBackground(new Color(239, 156, 0));
		admin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		usu = new JLabel("Usuario");
		usu.setBounds(30,50,100,20);
		usu.setForeground(new Color(239, 156, 0));
		usu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

		con = new JLabel("Contraseña");
		con.setBounds(30,75,100,20);
		con.setForeground(new Color(239, 156, 0));
		con.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		Us = new JTextField(20);
		Us.setBounds(125,50,125,20);
		Us.setBackground(new Color(79,79,79));
		Us.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		Us.setForeground(new Color(239, 156, 0));
		
		cont = new JPasswordField(20);
		cont.setBounds(125,75,125,20);
		cont.setBackground(new Color(79,79,79));
		cont.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		cont.setForeground(new Color(239, 156, 0));
		
		
		AceptarInicio = new JButton("Aceptar");
		AceptarInicio.addActionListener(this);
		AceptarInicio.setBounds(150,120,100,25);
		AceptarInicio.setBackground(new Color(239, 156, 0));
		AceptarInicio.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		cancelar.setBounds(35,120,100,25);
		cancelar.setBackground(new Color(239, 156, 0));
		cancelar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

		frame.add(bus);
		frame.add(reservar);
		frame.add(salir);
		frame.add(admin);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		if(e.getSource() == reservar)
		{
			IReservar.Reservacion();
			this.dispose();
		}
		if(e.getSource() == salir)
		{
			this.dispose();
		}
		if(e.getSource() == admin)
		{
			Inicio.setTitle("Modo Administrador");
			frame.remove(reservar);
			frame.remove(salir);
			frame.remove(admin);
			bus.setText("Administador");
			frame.add(usu);
			frame.add(Us);
			frame.add(con);
			frame.add(cont);
			frame.add(AceptarInicio);
			frame.add(cancelar);
			frame.repaint();
		}
		if(e.getSource() == AceptarInicio)
		{

			String user = Us.getText();
			char[] pasw = cont.getPassword();
			String contr = new String(pasw);
			
			Usuarios US = new Usuarios();
			acceso = US.acceso(user, contr);
			
			
			if(acceso != 0)
			{
				  //JOptionPane.showMessageDialog(null, "Iniciando sesion \ncomo administrador");
				  Menu_admin.MenuAdmin();
				  this.dispose();
				  	
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Credenciales Incorrectas","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		if(e.getSource() == cancelar)
		{
			Inicio.setTitle("Modo Administrador");
			frame.add(reservar);
			frame.add(salir);
			frame.add(admin);
			bus.setText("Reservacion de Autobus");
			frame.remove(usu);
			frame.remove(Us);
			frame.remove(con);
			frame.remove(cont);
			frame.remove(AceptarInicio);
			frame.remove(cancelar);
			frame.repaint();

		}
				
	}
	
}
	

