import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Clases.Autobuses;
import Clases.Registros;



public class ITotal extends JFrame implements ActionListener{

	JLabel icon, Lres, title, fecha, TotalReservado, TotalRecaudadi;
	JButton salir, guardar;
	Container frame;
	String RES;
	String texto;
	
	
	
	public static void Total()
	{
		ITotal total = new ITotal();	
		total.ventanaTotal();
		total.setBounds(785,415,565,450);
		total.setVisible(true);
		total.setTitle("Resumen");
		total.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	public void ventanaTotal()
	{
		frame = this.getContentPane();
		frame.setLayout(null);
		setVisible(true);
		frame.setBackground(new Color(51,51,51));

		Icon icvue = new ImageIcon(".\\Imagenes/regist_icon.png");
		icon = new JLabel(icvue);
		icon.setBounds(10,0,70,70);
		
		Lres = new JLabel("Resumen de Reservaciones");
		Lres.setBounds(90,40,320,25);
		Lres.setForeground(new Color(239, 156, 0));
		Lres.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		
		guardar = new JButton("Aceptar");
		guardar.addActionListener(this);
		guardar.setBounds(390, 360, 100, 25);
		guardar.setBackground(new Color(239, 156, 0));
		guardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		salir = new JButton("Cancelar");
		salir.addActionListener(this);
		salir.setBounds(265, 360, 100, 25);
		salir.setBackground(new Color(239, 156, 0));
		salir.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		 
			
		fecha = new JLabel("Fecha: ");
		fecha.setBounds(410,10,70,25);
		fecha.setForeground(new Color(239, 156, 0));
		fecha.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
		 
		 JLabel Dfecha = new JLabel(fecha_actual());
		 Dfecha.setBounds(460,10,100,25);
		 Dfecha.setForeground(new Color(239, 156, 0));
		 Dfecha.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
		 
		 TotalReservado = new JLabel("Total de Reservaciones:...");
		 TotalReservado.setBounds(150,110,200,25);
		 TotalRecaudadi = new JLabel("Total Recaudado:...");
		 TotalRecaudadi.setBounds(150,150,150,25);
		
		 Autobuses can = new Autobuses();
		 String Cant_res = can.Cantidad_reservaciones()+"";
		 
		 int Rec_res = (can.Cantidad_reservaciones()*3);
	
		  RES = "Total de Reservaciones: "+Cant_res+"\n"
			   +"Total Recaudado: "+Rec_res+"$";
		 texto();
		 
		 JTextArea JTA = new JTextArea(texto);
		 JTA.setSize(getMaximumSize());
		 JScrollPane SCL = new JScrollPane(JTA);
		 SCL.setBounds(60,90,445,250);	
		 SCL.setViewportView(JTA);
		 SCL.getViewport().setView(JTA);
		 JTA.setBackground(new Color(79,79,79));
		 JTA.setForeground(new Color(239, 156, 0));
			
		
		  
		
		frame.add(icon);
		frame.add(Lres);
		frame.add(guardar);
		frame.add(salir);
		frame.add(fecha);
		frame.add(Dfecha);
		frame.add(SCL);
		
		/*frame.add(TotalReservado);
		frame.add(JTotalReservado);
		frame.add(TotalRecaudadi);
		frame.add(JTotalRecaudadi);*/
	}
	
	

	public static String fechaguardar() {
	       SimpleDateFormat formDate = new SimpleDateFormat("yyyy-MM-dd");

	       String fecha = formDate.format(new Date()); 
	       return fecha;
	  } 
	
	public static String fecha_actual() {
	       SimpleDateFormat formDate = new SimpleDateFormat("dd-MM-yyyy");

	       String fecha = formDate.format(new Date()); 
	       return fecha;
	  } 
	
	public void Guardarregistro(){
	       SimpleDateFormat formDate = new SimpleDateFormat("yyyy-MM-dd");
	       String fechaSQL = formDate.format(new Date()); 
	       
	       Registros.SubirRegistro(fechaSQL);
	
	  } 
	
	
	public void texto() {
		
		
		texto ="-------------------------------------------------------------------\n        TOTAL \n-------------------------------------------------------------------\n"+ RES +"\n-------------------------------------------------------------------"+"\n        Registros \n-------------------------------------------------------------------\n"+"Id    Nombre   Matricula   Facultad     Ruta      Horario      No.autobus      Asiento\r\n" + 
				""+Registros.AgregarREG();

		}
	
	
	public void text() {
		try {
		File myObj = new File(".\\Resumenes/Resumen_"+fechaguardar()+".txt");
	      if (myObj.createNewFile()) {
	    	  
	        //System.out.println("File created: " + myObj.getName());
			  JOptionPane.showMessageDialog(null, "El Resumen de cuenta se ha creado con exito!!");
			  
			  FileWriter myWriter = new FileWriter(".\\Resumenes/Resumen_"+fechaguardar()+".txt");
		      myWriter.write(texto);
		      myWriter.close();
		      Registros.VaciarRegistro();
		      Guardarregistro();
		      
	      } else {
	        //System.out.println("File already exists.");
				JOptionPane.showMessageDialog(null, "El Resumen de cuenta ya existe","ERROR",JOptionPane.ERROR_MESSAGE);

	      }
	      
	     
	      
	    } catch (IOException e) {
	      //System.out.println("An error occurred.");
			JOptionPane.showMessageDialog(null, "Ha habido un error","ERROR",JOptionPane.ERROR_MESSAGE);

	      e.printStackTrace();
	    }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource() == guardar)
		{
			
		Autobuses can = new Autobuses();
			can.Basientos();
			
			text();
		}
		if(e.getSource() == salir)
		{
			Menu_admin.MenuAdmin();
			this.dispose();
		}
		
		
	}
	
}
