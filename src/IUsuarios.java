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

import Clases.ClaseUsuarios;
import Clases.Usuarios;


public class IUsuarios extends JFrame implements ActionListener {
	
	ArrayList<ClaseUsuarios> Listausuarios = new ArrayList<ClaseUsuarios> ();
	public ArrayList<JButton> info = new ArrayList<JButton>();
	public ArrayList<JLabel> idus = new ArrayList<JLabel>();
	public ArrayList<JLabel> nom = new ArrayList<JLabel>();
	public ArrayList<JLabel> niv = new ArrayList<JLabel>();

	
	JButton agregar,  atras;
	JLabel icbus, Lbus, id_usu_LBB, Nom_usu_LBB, NAC_usu_LBB;
	JPanel SCP;
	
	public static int Cont = 0, Iglob;
	static IUsuarios Usu_admin;
	Container frame;
	
	public static void Usuarios() {
		Usu_admin = new IUsuarios();
		Usu_admin.ventanaUsuarios();
		Usu_admin.setBounds(785,415,475,400);
		Usu_admin.setTitle("Usuarios");
		Usu_admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
	}

	public void ventanaUsuarios() {


		frame = this.getContentPane();
		frame.setLayout(null);
		setVisible(true);
		frame.setBackground(new Color(51,51,51));

				
		Icon icvue = new ImageIcon(".\\Imagenes/user_icon.png");
		icbus = new JLabel(icvue);
		icbus.setBounds(10,10,60,60);
		
		Lbus = new JLabel("Usuarios");
		Lbus.setBounds(90,40,180,40);
		Lbus.setForeground(new Color(239, 156, 0));
		Lbus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));

		id_usu_LBB = new JLabel("Id Usuario");
		id_usu_LBB.setBounds(70,100,100,20);
		id_usu_LBB.setForeground(new Color(239, 156, 0));
		id_usu_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

		Nom_usu_LBB = new JLabel("Nombre");
		Nom_usu_LBB.setBounds(160,100,100,20);
		Nom_usu_LBB.setForeground(new Color(239, 156, 0));
		Nom_usu_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		NAC_usu_LBB = new JLabel("N. Acceso");
		NAC_usu_LBB.setBounds(240,100,100,20);
		NAC_usu_LBB.setForeground(new Color(239, 156, 0));
		NAC_usu_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		SCP = new JPanel();
		SCP.setLayout(null);
		SCP.setBackground(new Color(79,79,79));

		
		JScrollPane sp = new JScrollPane();
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setBounds(55, 135,350,170);	
		agregarSP();
		sp.setViewportView(SCP);
		sp.getViewport().setView(SCP);
		
		agregar = new JButton("+");
		agregar.addActionListener(this);
		agregar.setBounds(330,100,45,25);
		agregar.setBackground(new Color(239, 156, 0));
		agregar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		
		
		atras = new JButton("Atras");
		atras.addActionListener(this);
		atras.setBounds(305,320,100,25);
		atras.setBackground(new Color(239, 156, 0));
		atras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		
		
		frame.add(icbus);
		frame.add(Lbus);
		frame.add(id_usu_LBB);
		frame.add(Nom_usu_LBB);
		frame.add(NAC_usu_LBB);
		frame.add(agregar);
		frame.add(atras);
		frame.add(sp);

	}

	private void agregarSP() {
		

		
		Usuarios user = new Usuarios(); 
		Listausuarios = user.getUsuarios();
		Cont = 0;
		SCP.setPreferredSize(new Dimension(300, 10+(30*Listausuarios.size())));

		for(int i  = 0; i < Listausuarios.size() ; i++)
		{
			info.add(new JButton(i+""));
			idus.add(new JLabel(""+Listausuarios.get(i).id_usu ));
			nom.add(new JLabel(""+Listausuarios.get(i).Nombre));
			niv.add(new JLabel(""+Listausuarios.get(i).nivel));

		}
		
		for(int i  = 0; i < info.size(); i++)
		{
			Cont++;
			idus.get(i).setBounds(30, 10+(30*i), 80, 25);
			idus.get(i).setForeground(new Color(239, 156, 0));
			idus.get(i).setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			nom.get(i).setBounds(115, 10+(30*i), 80, 25);
			nom.get(i).setForeground(new Color(239, 156, 0));
			nom.get(i).setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			niv.get(i).setBounds(210, 10+(30*i), 80, 25);
			niv.get(i).setForeground(new Color(239, 156, 0));
			niv.get(i).setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			
			info.get(i).setBounds(285,10+(30 *i),30,25);
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
							
							
							Iglob = Cont;
							
							IEditarUsuario.EditarUS();
							Usu_admin.dispose();
					 
				}
				
			});
			SCP.add(idus.get(i));
			SCP.add(nom.get(i));
			SCP.add(niv.get(i));
			SCP.add(info.get(i));
		}		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==agregar) {
			IAgregarUsuario.AgregarUS();
			this.dispose();
		}
		if(e.getSource()==atras) {
			Menu_admin.MenuAdmin();
			this.dispose();
		}
	}

}
