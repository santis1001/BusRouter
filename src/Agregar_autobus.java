

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
	import javax.swing.JPanel;
import javax.swing.JTextField;

import Clases.Autobuses;
import Clases.ClasesAutobus;

	public class Agregar_autobus extends JFrame implements ActionListener {
		
		ArrayList<ClasesAutobus> Listaautobus = new ArrayList<ClasesAutobus> ();
		
		
		JButton guardar, atras;
		JLabel icbus, Lbus, id_bus_LBB, ruta_bus_LBB, hora_bus_LBB, no_bus_LBB;
		JTextField id_bus_JTF, ruta_bus_JTF, hora_bus_JTF, no_bus_JTF;
		
		

		
		
		public static void AgregarAB() {
			Agregar_autobus  AgregarAB= new Agregar_autobus ();
			AgregarAB.ventanaAAB();
			AgregarAB.setBounds(785,415,560,240);
			AgregarAB.setTitle("Agregar Autobus");
			AgregarAB.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			
		}

		public void ventanaAAB() {


			Container frame = this.getContentPane();
			frame .setLayout(null);
			setVisible(true);
			frame.setBackground(new Color(51,51,51));

					
			Icon icvue = new ImageIcon(".\\Imagenes/camion.png");
			icbus = new JLabel(icvue);
			icbus.setBounds(10,10,60,60);
			
			
			Lbus = new JLabel("Agregar Autobus");
			Lbus.setBounds(90,40,350,40);
			Lbus.setForeground(new Color(239, 156, 0));
			Lbus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
			
			
			id_bus_LBB = new JLabel("Id Autobus");
			id_bus_LBB.setBounds(40,90,100,20);
			id_bus_LBB.setForeground(new Color(239, 156, 0));
			id_bus_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			
			id_bus_JTF = new JTextField(20);
			id_bus_JTF.setBounds(40,110,100,20);
			id_bus_JTF.setEditable(false);
			id_bus_JTF.setBackground(new Color(79,79,79));
			id_bus_JTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			id_bus_JTF.setForeground(new Color(239, 156, 0));
			
			ruta_bus_LBB = new JLabel("Ruta");
			ruta_bus_LBB.setBounds(160,90,100,20);
			ruta_bus_LBB.setForeground(new Color(239, 156, 0));
			ruta_bus_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			ruta_bus_JTF = new JTextField(20);
			ruta_bus_JTF.setBounds(160,110,100,20);
			ruta_bus_JTF.setBackground(new Color(79,79,79));
			ruta_bus_JTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			ruta_bus_JTF.setForeground(new Color(239, 156, 0));
			
			
			hora_bus_LBB = new JLabel("Hora");
			hora_bus_LBB.setBounds(280,90,100,20);
			hora_bus_LBB.setForeground(new Color(239, 156, 0));
			hora_bus_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));


			hora_bus_JTF = new JTextField(20);
			hora_bus_JTF.setBounds(280,110,100,20);
			hora_bus_JTF.setBackground(new Color(79,79,79));
			hora_bus_JTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			hora_bus_JTF.setForeground(new Color(239, 156, 0));

			
			no_bus_LBB = new JLabel("No. Autobus");
			no_bus_LBB.setBounds(400,90,100,20);
			no_bus_LBB.setForeground(new Color(239, 156, 0));
			no_bus_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			
			no_bus_JTF = new JTextField(20);
			no_bus_JTF.setBounds(400,110,100,20);
			no_bus_JTF.setBackground(new Color(79,79,79));
			no_bus_JTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			no_bus_JTF.setForeground(new Color(239, 156, 0));
				
			guardar = new JButton("Guardar");
			guardar.addActionListener(this);
			guardar.setBounds(400,150,100,25);
			guardar.setBackground(new Color(239, 156, 0));
			guardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			atras = new JButton("Atras");
			atras.addActionListener(this);
			atras.setBounds(280,150,100,25);
			atras.setBackground(new Color(239, 156, 0));
			atras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			
			Agregarvalores();
			
			frame .add(icbus);
			frame .add(Lbus);
			frame .add(id_bus_LBB);
			frame .add(ruta_bus_LBB);
			frame .add(hora_bus_LBB);
			frame .add(no_bus_LBB);
			frame .add(id_bus_JTF);
			frame .add(ruta_bus_JTF);
			frame .add(hora_bus_JTF);
			frame .add(no_bus_JTF);
			frame .add(guardar);
			frame .add(atras);
		
		}
		
		public void Agregarvalores(){
			
			Autobuses bus = new Autobuses(); 
			int id= bus.IDbus()+1;
			id_bus_JTF.setText(""+id);
			
			
			//IAutobuses_admin.Iglob;
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==guardar) {
				
				Autobuses bus = new Autobuses(); 
				
				int id_bus = Integer.parseInt(id_bus_JTF.getText());
				String ruta_bus = ruta_bus_JTF.getText()+"";
				String hora_bus = hora_bus_JTF.getText()+"";
				int no_bus = Integer.parseInt(no_bus_JTF.getText());
				
				//System.out.print(id_vuelo+"  "+ id_avion+"  "+nom_cap+"  "+ capa_vuelo+"  "+ origenn+"  "+destinoo+"  "+ horSal_vuelo+"  "+ horLle_vuelo);
				bus.AgregarBus(id_bus, ruta_bus, hora_bus, no_bus);
					
				IAutobuses_admin.Autobuses();
				this.dispose();
			}
			if(e.getSource()==atras) {
				IAutobuses_admin.Autobuses();
				this.dispose();
			}
		}

	}
