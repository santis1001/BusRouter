


	import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

	public class IQR  extends JFrame implements ActionListener{

		
		JLabel icon, Ltop,gua, Druta, Dhorario, Dautobus, Dasiento, nom, mat, fac, QRLabel;
		JLabel ruta, horario, autobus, asiento, nomL, matL, facL, Dfecha,fecha;
		JButton Terminar;
		JPanel JLB;
		Container frame ;
		JScrollPane SCRB;
	    private static final String QR_CODE_IMAGE_PATH = ".\\Imagenes/QR.png";
	    String QRtext;
	    
	   
		public static void GuardaQR()
		{
			IQR IDatos = new IQR();	
			IDatos.ventanaGuardaQR();
			IDatos.setBounds(500,300,650,380);
			IDatos.setVisible(true);
			IDatos.setTitle("Reservacion");
			IDatos.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
		public void ventanaGuardaQR()
		{
			frame = this.getContentPane();
			frame.setLayout(null);
			setVisible(true);
			frame.setBackground(new Color(51,51,51));
			
			Icon icvue = new ImageIcon(".\\Imagenes/camion2.png");
			icon = new JLabel(icvue);
			icon.setBounds(0,-10,130,130);
			
			Ltop = new JLabel("Reservacion");
			Ltop.setBounds(120,40,200,20);
			Ltop.setForeground(new Color(239, 156, 0));
			Ltop.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
			
			gua = new JLabel("Guarda tu reservacion!!");
			gua.setBounds(350,40,250,20);
			gua.setForeground(new Color(239, 156, 0));
			gua.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
			
			nom = new JLabel("Nombre: ");
			nom.setBounds(110,90,100,20);
			nom.setForeground(new Color(239, 156, 0));
			nom.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			nomL = new JLabel(IIngresarDatos.Dnom+"");
			nomL.setBounds(180,90,100,20);
			nomL.setForeground(new Color(239, 156, 0));
			nomL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			mat = new JLabel("Matricula: ");
			mat.setBounds(110,120,100,20);
			mat.setForeground(new Color(239, 156, 0));
			mat.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

			matL = new JLabel(IIngresarDatos.Dmat+"");
			matL.setBounds(180,120,100,20);
			matL.setForeground(new Color(239, 156, 0));
			matL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			fac = new JLabel("Facultad: ");
			fac.setBounds(110,150,100,20);
			fac.setForeground(new Color(239, 156, 0));
			fac.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			facL = new JLabel(IIngresarDatos.Dfacu+"");
			facL.setBounds(180,150,100,20);
			facL.setForeground(new Color(239, 156, 0));
			facL.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

			Druta = new JLabel("Ruta: ");
			Druta.setBounds(110,180,100,20);
			Druta.setForeground(new Color(239, 156, 0));
			Druta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			ruta = new JLabel(IReservar.item+"");
			ruta.setBounds(180,180,100,20);
			ruta.setForeground(new Color(239, 156, 0));
			ruta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

			Dhorario = new JLabel("Horario: ");
			Dhorario.setBounds(110,210,100,20);
			Dhorario.setForeground(new Color(239, 156, 0));
			Dhorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

			horario = new JLabel(IReservar.Hitem+"");
			horario.setBounds(180,210,100,20);
			horario.setForeground(new Color(239, 156, 0));
			horario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			Dautobus = new JLabel("Autobus: ");
			Dautobus.setBounds(110,240,100,20);
			Dautobus.setForeground(new Color(239, 156, 0));
			Dautobus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			autobus = new JLabel(IReservar.Aitem+"");
			autobus.setBounds(180,240,100,20);
			autobus.setForeground(new Color(239, 156, 0));
			autobus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			Dasiento = new JLabel("Asiento: ");
			Dasiento.setBounds(110,270,100,20);
			Dasiento.setForeground(new Color(239, 156, 0));
			Dasiento.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			asiento = new JLabel(IReservar.Sitem+"");
			asiento.setBounds(180,270,100,20);
			asiento.setForeground(new Color(239, 156, 0));
			asiento.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
			fecha = new JLabel("Fecha: " );
			fecha.setBounds(110,300,100,20);	
			fecha.setForeground(new Color(239, 156, 0));
			fecha.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));			
		
			Dfecha = new JLabel(""+ fecha_actual());
			Dfecha.setBounds(180,300,100,20);
			Dfecha.setForeground(new Color(239, 156, 0));
			Dfecha.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
			
			Terminar = new JButton("Terminar");
			Terminar.addActionListener(this);
			Terminar.setBounds(415, 280, 100, 25);
			Terminar.setBackground(new Color(239, 156, 0));
			Terminar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			QRgen1();
			
			Icon icqr= new ImageIcon(".\\Imagenes/QR.png");
			
			JLabel qr = new JLabel(icqr);
			qr.setBounds(365,70,200,200);

			frame.add(icon);
			frame.add(Ltop);
			frame.add(gua);
			frame.add(nom);
			frame.add(mat);
			frame.add(fac);
			frame.add(Druta);
			frame.add(Dhorario);
			frame.add(Dautobus);
			frame.add(Dasiento);
			frame.add(nomL);
			frame.add(matL);
			frame.add(facL);
			frame.add(ruta);
			frame.add(horario);
			frame.add(autobus);
			frame.add(asiento);
			frame.add(qr);
			frame.add(fecha);
			frame.add(Dfecha);
			frame.add(Terminar);
			
		}
		
	private void QRgen(String text, int width, int height, String filePath)
	            throws WriterException, IOException {
	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

	        Path path = FileSystems.getDefault().getPath(filePath);
	        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	    }
	
	private void QRgen1() {
		String qrtext = "Nombre: "+IIngresarDatos.Dnom+
				"\nMatricula: "+IIngresarDatos.Dmat+
				"\nFacultad: "+IIngresarDatos.Dfacu+
				"\nRuta: "+IReservar.item+
				"\nHorario: "+IReservar.Hitem+
				"\nAutobus: "+IReservar.Aitem+
				"\nAsiento: "+IReservar.Sitem+
				"\nFecha: " + fecha_actual()
				;
		try {
			QRgen(qrtext, 200, 200, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
		
	}
	
	public static String fecha_actual() {
	       SimpleDateFormat formDate = new SimpleDateFormat("dd-MM-yyyy");

	       String fecha = formDate.format(new Date()); 
	       return fecha;
	  } 
			
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == Terminar)
		{
			IIngresarDatos.Dnom = "";
			IIngresarDatos.Dmat = 0;
			IIngresarDatos.Dfacu= "";
			IReservar.item = "";
			IReservar.Hitem = "";
			IReservar.Aitem="";
			IReservar.Sitem="";
			IReservar.Col = ""; 
			IReservar.Row = "";
			
			IInicio.Inicio();
			this.dispose();
		}
		
	}


		
	}

