

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

import Clases.ClaseUsuarios;
import Clases.Usuarios;


public class IAgregarUsuario  extends JFrame implements ActionListener {
		
		ArrayList<ClaseUsuarios> Listausuarios = new ArrayList<ClaseUsuarios> ();
		
		
		JButton guardar, atras, borrar, editar;
		JLabel icbus, Lus, id_us_LBB, nom_us_LBB, contr_us_LBB, nivel_us_LBB;
		JTextField id_us_JTF, nombre_us_JTF, contr_us_JTF, nivel_us_JTF;
		
		Container frame;
		static IAgregarUsuario  agregarusu;
		
		public static void AgregarUS() {
			agregarusu= new IAgregarUsuario ();
			agregarusu.ventanaAgregarUS();
			agregarusu.setBounds(785,415,560,240);
			agregarusu.setTitle("Informacion Usuario");
			agregarusu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			
		}

		public void ventanaAgregarUS() {


			frame = this.getContentPane();
			frame .setLayout(null);
			setVisible(true);
			frame.setBackground(new Color(51,51,51));

					
			Icon icvue = new ImageIcon(".\\\\Imagenes/user_icon.png");
			icbus = new JLabel(icvue);
			icbus.setBounds(10,10,60,60);
			
			
			Lus = new JLabel("Agregar Usuario");
			Lus.setBounds(90,40,300,40);
			Lus.setForeground(new Color(239, 156, 0));
			Lus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
			
			id_us_LBB = new JLabel("Id Usuario");
			id_us_LBB.setBounds(40,90,100,20);
			id_us_LBB.setForeground(new Color(239, 156, 0));
			id_us_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			id_us_JTF = new JTextField(20);
			id_us_JTF.setBounds(40,110,100,20);
			id_us_JTF.setEditable(false);
			id_us_JTF.setBackground(new Color(79,79,79));
			id_us_JTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			id_us_JTF.setForeground(new Color(239, 156, 0));
			
			nom_us_LBB = new JLabel("Nombre");
			nom_us_LBB.setBounds(160,90,100,20);
			nom_us_LBB.setForeground(new Color(239, 156, 0));
			nom_us_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			nombre_us_JTF = new JTextField(20);
			nombre_us_JTF.setBounds(160,110,100,20);
			nombre_us_JTF.setEditable(true);
			nombre_us_JTF.setBackground(new Color(79,79,79));
			nombre_us_JTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			nombre_us_JTF.setForeground(new Color(239, 156, 0));
			
			contr_us_LBB = new JLabel("Contraseña");
			contr_us_LBB.setBounds(280,90,100,20);
			contr_us_LBB.setForeground(new Color(239, 156, 0));
			contr_us_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

			contr_us_JTF = new JTextField(20);
			contr_us_JTF.setBounds(280,110,100,20);
			contr_us_JTF.setEditable(true);
			contr_us_JTF.setBackground(new Color(79,79,79));
			contr_us_JTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			contr_us_JTF.setForeground(new Color(239, 156, 0));

			nivel_us_LBB = new JLabel("N. Acceso");
			nivel_us_LBB.setBounds(400,90,100,20);
			nivel_us_LBB.setForeground(new Color(239, 156, 0));
			nivel_us_LBB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			nivel_us_JTF = new JTextField(20);
			nivel_us_JTF.setBounds(400,110,100,20);
			nivel_us_JTF.setEditable(true);
			nivel_us_JTF.setBackground(new Color(79,79,79));
			nivel_us_JTF.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			nivel_us_JTF.setForeground(new Color(239, 156, 0));
			
			guardar = new JButton("Guardar");
			guardar.addActionListener(this);
			guardar.setBounds(400,150,100,25);
			guardar.setBackground(new Color(239, 156, 0));
			guardar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			
			atras = new JButton("Cancelar");
			atras.addActionListener(this);
			atras.setBounds(280,150,100,25);
			atras.setBackground(new Color(239, 156, 0));
			atras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			
			Agregarvalores();
			
			frame .add(icbus);
			frame .add(Lus);
			frame .add(id_us_LBB);
			frame .add(id_us_JTF);
			frame .add(nom_us_LBB);
			frame .add(nombre_us_JTF);
			frame .add(contr_us_LBB);
			frame .add(contr_us_JTF);
			frame .add(nivel_us_LBB);
			frame .add(nivel_us_JTF);
			frame .add(guardar);
			frame .add(atras);
		
		}
		
		public void Agregarvalores(){
			
			Usuarios user = new Usuarios(); 
			int id= user.IDusuario();			
			
			id_us_JTF.setText((id+1)+"");

			//IAutobuses_admin.Iglob;
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==guardar) {
				
				Usuarios user = new Usuarios(); 
				
				int id_us = Integer.parseInt(id_us_JTF.getText());
				String nom_us = nombre_us_JTF.getText()+"";
				String contr_us = contr_us_JTF.getText()+"";
				int nivel = Integer.parseInt(nivel_us_JTF.getText());
				
				user.AgregarUsu(id_us, nom_us, contr_us, nivel);
				
				IUsuarios.Usuarios();
				this.dispose();
			}
			
			
			if(e.getSource() == atras) {
				
				IUsuarios.Usuarios();
				this.dispose();
			}
		}
	}

