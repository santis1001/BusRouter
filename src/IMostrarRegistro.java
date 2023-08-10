import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Clases.Autobuses;

public class IMostrarRegistro extends JFrame implements ActionListener {

	JLabel icon, reg ;
	JButton salir, guardar;
	Container frame;
	
	
	public static void MRegistro()
	{
		IMostrarRegistro mostrar = new IMostrarRegistro();	
		mostrar.ventanaMRegistro();
		mostrar.setBounds(785,415,565,450);
		mostrar.setVisible(true);
		mostrar.setTitle("Registro");
		mostrar.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	public void ventanaMRegistro()
	{
		frame = this.getContentPane();
		frame.setLayout(null);
		setVisible(true);
		frame.setBackground(new Color(51,51,51));

		Icon icvue = new ImageIcon(".\\Imagenes/corte_icon.png");
		icon = new JLabel(icvue);
		icon.setBounds(10,0,70,70);
		
		reg = new JLabel("Registro de : "+IRegistros.Fglob);
		reg.setBounds(90,40,320,25);
		reg.setForeground(new Color(239, 156, 0));
		reg.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		
	
		salir = new JButton("Salir");
		salir.addActionListener(this);
		salir.setBounds(390, 360, 100, 25);
		salir.setBackground(new Color(239, 156, 0));
		salir.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		 
		
		 
		 JTextArea JTA = new JTextArea(texto());
		 JTA.setSize(getMaximumSize());
		 
		 JScrollPane SCL = new JScrollPane(JTA);
		 SCL.setBounds(60,90,445,250);	
		 SCL.setViewportView(JTA);
		 SCL.getViewport().setView(JTA);
		 JTA.setBackground(new Color(79,79,79));
		 JTA.setForeground(new Color(239, 156, 0));
			
		
		frame.add(icon);
		frame.add(reg);
		frame.add(salir);
		frame.add(SCL);
		
		/*frame.add(TotalReservado);
		frame.add(JTotalReservado);
		frame.add(TotalRecaudadi);
		frame.add(JTotalRecaudadi);*/
	}
	private String texto() {
		
	 	String text = ""; 
	 	 
		try  
		{  
		//constructor of file class having file as argument  
		File file=new File(".\\Resumenes\\Resumen_"+IRegistros.Fglob+".txt");   
		FileInputStream fis=new FileInputStream(file);     //opens a connection to an actual file  
		int r=0;  
		while((r=fis.read())!=-1)  
		{  
			text = ""+text +(char)r;      //prints the content of the file  
		}  
		}  
		catch(Exception e)  
		{  
		e.printStackTrace();  
		}  		
		
		return text;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==salir) 
		{
			this.dispose();
		}
	}
}
