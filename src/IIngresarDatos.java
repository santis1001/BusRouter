import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Clases.ClaseAsiento;
import Clases.datos;

public class IIngresarDatos extends JFrame implements ActionListener{

	
	JLabel icon, Ltop, Druta, Dhorario, Dautobus, Dasiento;
	JLabel nom, mat, fac, aviso, aviso1;
	JTextField nom_JTF, mat_JTF, fac_JTF;
	JLabel Itu, Idis, Iocu;
	JRadioButton[] horarios;
	JButton aceptar, cancelar ;
	JPanel JLB, AB;
	Container frame ;
	JScrollPane SCRB;
	public static String Dnom = "", Dfacu = "";
	public static int Dmat, NoR;
	
	
	
	
	public static void IngresaDatos()
	{
		IIngresarDatos IDatos = new IIngresarDatos();	
		IDatos.ventanadatos();
		IDatos.setBounds(500,300,500,380);
		IDatos.setVisible(true);
		IDatos.setTitle("Guarda tu Reservacion");
		IDatos.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	public void ventanadatos()
	{
		frame = this.getContentPane();
		frame.setLayout(null);
		setVisible(true);
		frame.setBackground(new Color(51,51,51));
		
		Icon icvue = new ImageIcon(".\\Imagenes/camion2.png");
		icon = new JLabel(icvue);
		icon.setBounds(0,-10,130,130);
		
		Ltop = new JLabel("Ingresa tus Datos");
		Ltop.setBounds(130,40,200,40);
		Ltop.setForeground(new Color(239, 156, 0));
		Ltop.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		
		
		
		JLB = new JPanel();
		JLB.setLayout(null);
		
		
		
		JScrollPane SCL = new JScrollPane(JLB);
		SCL.setBounds(60,110,130,130);	
		agregarSP();
		SCL.setViewportView(JLB);
		SCL.getViewport().setView(JLB);
		JLB.setBackground(new Color(79,79,79));
		nom = new JLabel("Nombre: ");
		nom.setBounds(220,110,100,25);
		nom.setForeground(new Color(239, 156, 0));
		nom.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		nom_JTF = new JTextField(20);
		nom_JTF.setBounds(290,110,150,25);
		nom_JTF.setBackground(new Color(79,79,79));
		nom_JTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		nom_JTF.setForeground(new Color(239, 156, 0));
		
		mat = new JLabel("Matricula: ");
		mat.setBounds(220,150,100,25);
		mat.setForeground(new Color(239, 156, 0));
		mat.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		mat_JTF = new JTextField(20);
		mat_JTF.setBounds(290,150,150,25);
		mat_JTF.setBackground(new Color(79,79,79));
		mat_JTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		mat_JTF.setForeground(new Color(239, 156, 0));
		
		fac = new JLabel("Facultad:");
		fac.setBounds(220,190,100,25);
		fac.setForeground(new Color(239, 156, 0));
		fac.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		fac_JTF = new JTextField(20);
		fac_JTF.setBounds(290,190,150,25);
		fac_JTF.setBackground(new Color(79,79,79));
		fac_JTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		fac_JTF.setForeground(new Color(239, 156, 0));


		aviso = new JLabel("*NOTA: el reservar asiento tiene un cobro de 3 pesos*");
		aviso.setBounds(200,320,400,25);
		aviso.setForeground(new Color(239, 156, 0));
		aviso.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
		 
		 
		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(this);
		aceptar.setBounds(340, 260, 100, 30);
		aceptar.setBackground(new Color(239, 156, 0));
		aceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		cancelar.setBounds(220, 260, 100, 30);
		cancelar.setBackground(new Color(239, 156, 0));
		cancelar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

	
		
		frame.add(icon);
		frame.add(Ltop);
		frame.add(SCL);
		frame.add(nom);
		frame.add(nom_JTF);
		frame.add(mat);
		frame.add(mat_JTF);
		frame.add(fac);
		frame.add(fac_JTF);
		frame.add(aviso);
		frame.add(aceptar);
		frame.add(cancelar);
		

	}
	
private void agregarSP() {
		
		Druta = new JLabel("Ruta: "+IReservar.item);
		Druta.setBounds(10,10,100,20);
		Druta.setForeground(new Color(239, 156, 0));
		Druta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		Dhorario = new JLabel("Horario: "+IReservar.Hitem);
		Dhorario.setBounds(10,40,150,20);
		Dhorario.setForeground(new Color(239, 156, 0));
		Dhorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		Dautobus = new JLabel("Autobus: "+IReservar.Aitem);
		Dautobus.setBounds(10,70,100,20);
		Dautobus.setForeground(new Color(239, 156, 0));
		Dautobus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		Dasiento = new JLabel("Asiento: "+IReservar.Sitem);
		Dasiento.setBounds(10,100,100,20);
		Dasiento.setForeground(new Color(239, 156, 0));
		Dasiento.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

		JLB.add(Druta);
		JLB.add(Dhorario);
		JLB.add(Dautobus);
		JLB.add(Dasiento);
		
	}



public void Guardar() {
	try
	{
		datos valor = new datos();
		ArrayList<ClaseAsiento> listaasientos = new ArrayList<ClaseAsiento>();
		listaasientos  =  valor.Columna(IReservar.item,IReservar.Hitem);
		
		Dnom = nom_JTF.getText(); 
		Dmat = Integer.parseInt(mat_JTF.getText());
		Dfacu = fac_JTF.getText();
		NoR = ((listaasientos.size()+2));
		
		//System.out.println(NoR);
		if(Dnom != "" && Dfacu != "")
		{
			
		//	System.out.println(listaasientos.get(0).id_bus+"");
			
			
			datos.AgregarREG(Dnom,Dmat,Dfacu, IReservar.item, IReservar.Hitem, Integer.parseInt(IReservar.Aitem), IReservar.Sitem);
			
			datos.Agregar( Integer.parseInt(IReservar.Col+""), Integer.parseInt(IReservar.Row+""), IReservar.item, IReservar.Hitem);
			IQR.GuardaQR();
			this.dispose();
		}
		else {
			  JOptionPane.showMessageDialog(null, "Campo Invalido");
		}
		
	}
	catch(NumberFormatException e)
	{
		e.getCause();
		mat_JTF.setText("Campo Invalido");
		//System.out.println(e.getCause()+"");
	}
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == cancelar)
	{
		IInicio.Inicio();
		this.dispose();
	}
	if(e.getSource() == aceptar)
	{
		Guardar();

	}
	
}


	
}
