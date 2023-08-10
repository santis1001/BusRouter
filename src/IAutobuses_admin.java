import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Clases.Autobuses;
import Clases.ClasesAutobus;

public class IAutobuses_admin extends JFrame implements ActionListener {
	
	ArrayList<ClasesAutobus> Listaautobus = new ArrayList<ClasesAutobus> ();
	public ArrayList<JButton> info = new ArrayList<JButton>();
	public ArrayList<JLabel> idbus = new ArrayList<JLabel>();
	public ArrayList<JLabel> ruta = new ArrayList<JLabel>();
	public ArrayList<JLabel> hora = new ArrayList<JLabel>();
	public ArrayList<JLabel> nom = new ArrayList<JLabel>();
	
	JButton agregar,  atras;
	JLabel icbus, Lbus, id_bus_LBB, ruta_bus_LBB, hora_bus_LBB, no_bus_LBB;
	JPanel SCP;
	
	public static int Cont = 0, Iglob;
	static IAutobuses_admin auto_admin;
	Container frame;
	
	
	public static void Autobuses() {
		auto_admin = new IAutobuses_admin();
		auto_admin.ventanaAutobuses();
		auto_admin.setBounds(785,415,560,400);
		auto_admin.setTitle("Autobuses");
		auto_admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
	}

	public void ventanaAutobuses() {


		frame = this.getContentPane();
		frame.setLayout(null);
		setVisible(true);
		frame.setBackground(new Color(51,51,51));

				
		Icon icvue = new ImageIcon(".\\Imagenes/camion.png");
		icbus = new JLabel(icvue);
		icbus.setBounds(10,10,60,60);
		
		Lbus = new JLabel("Autobuses");
		Lbus.setBounds(90,40,180,40);
		Lbus.setForeground(new Color(239, 156, 0));
		Lbus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));

		id_bus_LBB = new JLabel("Id Autobus");
		id_bus_LBB.setBounds(80,100,100,20);
		id_bus_LBB.setForeground(new Color(239, 156, 0));
		id_bus_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

		ruta_bus_LBB = new JLabel("Ruta");
		ruta_bus_LBB.setBounds(180,100,100,20);
		ruta_bus_LBB.setForeground(new Color(239, 156, 0));
		ruta_bus_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		hora_bus_LBB = new JLabel("Hora");
		hora_bus_LBB.setBounds(250,100,100,20);
		hora_bus_LBB.setForeground(new Color(239, 156, 0));
		hora_bus_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		no_bus_LBB = new JLabel("No. Autobus");
		no_bus_LBB.setBounds(320,100,100,20);
		no_bus_LBB.setForeground(new Color(239, 156, 0));
		no_bus_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		SCP = new JPanel();
		SCP.setLayout(null);
		SCP.setBackground(new Color(79,79,79));

		
		JScrollPane sp = new JScrollPane();
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setBounds(55, 135,460,170);	
		agregarSP();
		sp.setViewportView(SCP);
		sp.getViewport().setView(SCP);
		
		agregar = new JButton("+");
		agregar.addActionListener(this);
		agregar.setBounds(430,100,45,25);
		agregar.setBackground(new Color(239, 156, 0));
		agregar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		
		
		atras = new JButton("Atras");
		atras.addActionListener(this);
		atras.setBounds(400,320,100,25);
		atras.setBackground(new Color(239, 156, 0));
		atras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		
		
		frame.add(icbus);
		frame.add(Lbus);
		frame.add(id_bus_LBB);
		frame.add(ruta_bus_LBB);
		frame.add(hora_bus_LBB);
		frame.add(no_bus_LBB);
		frame.add(agregar);
		frame.add(atras);
		frame.add(sp);

	}

	private void agregarSP() {
		

		
		Autobuses bus = new Autobuses(); 
		Listaautobus = bus.AutoBus();
		Cont = 0;
		SCP.setPreferredSize(new Dimension(410, 10+(30*Listaautobus.size())));

		for(int i  = 0; i < Listaautobus.size() ; i++)
		{
			info.add(new JButton(i+""));
			idbus.add(new JLabel(""+Listaautobus.get(i).id_bus ));
			ruta.add(new JLabel(""+Listaautobus.get(i).ruta_bus));
			hora.add(new JLabel(""+Listaautobus.get(i).horario));
			nom.add(new JLabel(""+Listaautobus.get(i).no_bus));
		}
		
		for(int i  = 0; i < info.size(); i++)
		{
			Cont++;
			idbus.get(i).setBounds(50, 10+(30*i), 80, 25);
			idbus.get(i).setForeground(new Color(239, 156, 0));
			idbus.get(i).setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			ruta.get(i).setBounds(125, 10+(30*i), 80, 25);
			ruta.get(i).setForeground(new Color(239, 156, 0));
			ruta.get(i).setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			hora.get(i).setBounds(190, 10+(30*i), 80, 25);
			hora.get(i).setForeground(new Color(239, 156, 0));
			hora.get(i).setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			nom.get(i).setBounds(300, 10+(30*i), 80, 25);
			nom.get(i).setForeground(new Color(239, 156, 0));
			nom.get(i).setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			info.get(i).setBounds(380,10+(30 *i),30,25);
			info.get(i).setBackground(new Color(239, 156, 0));
			info.get(i).setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			info.get(i).addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					String src = e.getSource() + "";

					//String index = src.charAt(435)+"   "+src.charAt(436)+"  ";
					
							
							int x = src.lastIndexOf(',') - src.indexOf('=', 433)-1;
							int en = src.indexOf('=', 433); 
						   
							String num ="";
							
							for(int i=0; i<x; i++)
							{
								num = num + src.charAt(src.indexOf('=', 433)+1+i)+"";
								
							}
							int Cont = Integer.parseInt(num);
							
							Iglob = Integer.parseInt(num);
							
							IEditar_autobus.EditarAB();				
							auto_admin.dispose();
					 
				}
				
			});
			SCP.add(idbus.get(i));
			SCP.add(ruta.get(i));
			SCP.add(hora.get(i));
			SCP.add(nom.get(i));
			SCP.add(info.get(i));
		}		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==agregar) {
			Agregar_autobus.AgregarAB();
			this.dispose();
		}
		if(e.getSource()==atras) {
			Menu_admin.MenuAdmin();
			this.dispose();
		}
	}

}
