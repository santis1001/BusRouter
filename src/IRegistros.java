
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

import Clases.ClaseRegistro;
import Clases.Registros;

	public class IRegistros extends JFrame implements ActionListener {
		
		ArrayList<ClaseRegistro> listaRegistro = new ArrayList<ClaseRegistro>();
		public ArrayList<JLabel> idreg = new ArrayList<JLabel>();
		public ArrayList<JLabel> fecha = new ArrayList<JLabel>();
		public ArrayList<JButton> info = new ArrayList<JButton>();
		public static int Cont = 0, Iglob;
		public static String Fglob;
		JLabel icreg, reg, id_reg_LBB, fecha_LBB ;
		static IRegistros regi_admin;
		JPanel SCP;
		Container frame;
		JButton atras;
		
		
		
		
		
		public static void Registros() {
			regi_admin = new IRegistros();
			regi_admin.ventanaRegistros();
			regi_admin.setBounds(785,415,370,480);
			regi_admin.setTitle("Registros");
			regi_admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			
		}

		public void ventanaRegistros() {


			frame = this.getContentPane();
			frame.setLayout(null);
			setVisible(true);
			frame.setBackground(new Color(51,51,51));

					
			Icon icvue = new ImageIcon(".\\Imagenes/corte_icon.png");
			icreg = new JLabel(icvue);
			icreg.setBounds(10,10,60,60);
			
			reg = new JLabel("Registros");
			reg.setBounds(90,40,180,40);
			reg.setForeground(new Color(239, 156, 0));
			reg.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));

			id_reg_LBB = new JLabel("Id Registro");
			id_reg_LBB.setBounds(60,100,100,20);
			id_reg_LBB.setForeground(new Color(239, 156, 0));
			id_reg_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

			fecha_LBB = new JLabel("Fecha");
			fecha_LBB .setBounds(160,100,100,20);
			fecha_LBB .setForeground(new Color(239, 156, 0));
			fecha_LBB .setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			
			SCP = new JPanel();
			SCP.setLayout(null);
			SCP.setBackground(new Color(79,79,79));

			
			JScrollPane sp = new JScrollPane();
			sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			sp.setBounds(55, 135,250,250);	
			agregarSP();
			sp.setViewportView(SCP);
			sp.getViewport().setView(SCP);
			
			
			
			atras = new JButton("Atras");
			atras.addActionListener(this);
			atras.setBounds(205,400,100,25);
			atras.setBackground(new Color(239, 156, 0));
			atras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			
			
			frame.add(icreg);
			frame.add(reg);
			frame.add(id_reg_LBB);
			frame.add(fecha_LBB);
		
			frame.add(atras);
			frame.add(sp);

		}

		private void agregarSP() {
			

			
			Registros bus = new Registros(); 
			listaRegistro = bus.Registro();
			Cont = 0;
			SCP.setPreferredSize(new Dimension(200, 10+(30*listaRegistro.size())));

			for(int i  = 0; i < listaRegistro.size() ; i++)
			{
				info.add(new JButton(i+""));
				idreg.add(new JLabel(""+listaRegistro.get(i).id_reg ));
				fecha.add(new JLabel(""+listaRegistro.get(i).fecha));
			}
			
			for(int i  = 0; i < info.size(); i++)
			{
				Cont++;
				idreg.get(i).setBounds(20, 10+(30*i), 80, 25);
				idreg.get(i).setForeground(new Color(239, 156, 0));
				idreg.get(i).setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
				
				fecha.get(i).setBounds(85, 10+(30*i), 80, 25);
				fecha.get(i).setForeground(new Color(239, 156, 0));
				fecha.get(i).setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
				
				
				info.get(i).setBounds(180, 10+(30*i), 40, 25);
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
								
								Fglob = ""+fecha.get(Cont).getText();
								IMostrarRegistro.MRegistro();
								
					}
					
				});
			
				SCP.add(idreg.get(i));
				SCP.add(fecha.get(i));
				SCP.add(info.get(i));
			}		

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==atras) 
			{
				Menu_admin.MenuAdmin();
				this.dispose();
			}
		}

	}
