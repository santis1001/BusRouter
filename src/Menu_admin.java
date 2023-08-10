import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;


public class Menu_admin extends JFrame implements ActionListener  {
	public Menu_admin() {
	}

	JButton autobuses_menu, Terminar_menu,agregar_menu, registros_menu;
	Container frame;
	static Menu_admin Inicio_admin;
	JLabel menu;
	
	
	
	public static void MenuAdmin() {
		Inicio_admin = new Menu_admin();
		Inicio_admin.ventanaMenu();
		Inicio_admin.setTitle("Menu");
		Inicio_admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
	}

	public void ventanaMenu() {
	
		frame = this.getContentPane();
		frame.setLayout(null);
		setVisible(true);
		frame.setBackground(new Color(51,51,51));

		menu = new JLabel("Menu");
		menu.setBounds(90,20,200,20);
		menu.setForeground(new Color(239, 156, 0));
		menu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		
		Icon icvue = new ImageIcon(".\\Imagenes/back_icon.png");
		JLabel salir = new JLabel(icvue);
		salir.addMouseListener(new MouseAdapter() 
		{
	          @Override
	          public void mouseClicked(MouseEvent e) 
	          {
	        	  IInicio.Inicio();
	        	  Inicio_admin.dispose();
	          }
	    });	      
		salir.setBounds(10,260,100,180);

		autobuses_menu = new JButton("Autobuses");
		autobuses_menu.addActionListener(this);
		autobuses_menu.setBounds(20,60,200,40);
		autobuses_menu.setBackground(new Color(239, 156, 0));
		autobuses_menu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		Terminar_menu = new JButton("Corte");
		Terminar_menu.addActionListener(this);
		Terminar_menu.setBounds(20,130,200,40);
		Terminar_menu.setBackground(new Color(239, 156, 0));
		Terminar_menu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		
		registros_menu = new JButton("Registros");
		registros_menu.addActionListener(this);
		registros_menu.setBounds(20,200,200,40);
		registros_menu.setBackground(new Color(239, 156, 0));
		registros_menu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		agregar_menu= new JButton("Usuarios");
		agregar_menu.addActionListener(this);
		agregar_menu.setBounds(20,270,200,40);
		agregar_menu.setBackground(new Color(239, 156, 0));
		agregar_menu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
	
		frame.add(menu);
		
		
		if(IInicio.acceso >= 2)
		{
			frame.add(agregar_menu);
			Inicio_admin.setBounds(835,300,250,455);
			salir.setBounds(10,330,100,100);

		}else {
			Inicio_admin.setBounds(835,300,250,385);

		}
		
		
		frame.add(salir);
		frame.add(autobuses_menu);
		frame.add(Terminar_menu);
		frame.add(registros_menu);
		
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == autobuses_menu) 
		{
			IAutobuses_admin.Autobuses();
			this.dispose();
		}
	
		if(e.getSource() == Terminar_menu)
		{
			ITotal.Total();
			this.dispose();
		}
		if(e.getSource() == registros_menu)
		{
			IRegistros.Registros();
			this.dispose();
		}
		if(e.getSource() == agregar_menu)
		{
			IUsuarios.Usuarios();
			this.dispose();
		}
		
	}
}
