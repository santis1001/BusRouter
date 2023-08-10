
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ScrollPaneConstants;

import Clases.ClaseAsiento;
import Clases.datos;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane; 

public class IReservar extends JFrame implements ActionListener {

	
	
	JLabel icon, Ltop, ruta,tuRE, horario, autobus, asiento, Druta, Dhorario, Dautobus, Dasiento, dis, ocu, tu, A, B, C, D;
	JLabel Itu, Idis, Iocu;
	
	public int col = -1, row = -1, chkRC[][];
	JComboBox rutaCBB;
	JRadioButton[] horarios;
	JButton aceptar, cancelar ;
	JPanel JLB, AB;
	Container frame ;
	ButtonGroup horGroup;
	JScrollPane SCRB;
	JScrollPane SCAB;
	
	public ArrayList<String> listaruta= new ArrayList<>();
	public ArrayList<String> listahorario =  new ArrayList<>();
	public ArrayList<JLabel> numero = new ArrayList<JLabel>();

	public static String item = "", Hitem = "", Aitem="", Sitem="", Col = "" , Row = "";
	

	public static void Reservacion()
	{
		IReservar reservar = new IReservar();	
		reservar.ventanareserva();
		reservar.setBounds(500,300,585,480);
		reservar.setVisible(true);
		reservar.setTitle("Reservacion");
		reservar.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	public void ventanareserva()
	{
		frame = this.getContentPane();
		frame.setLayout(null);
		setVisible(true);
		frame.setBackground(new Color(51,51,51));
		
		Icon icvue = new ImageIcon(".\\Imagenes/camion2.png");
		icon = new JLabel(icvue);
		icon.setBounds(0,-10,130,130);
		
		Ltop = new JLabel("Reservacion");
		Ltop.setBounds(130,40,200,40);
		Ltop.setForeground(new Color(239, 156, 0));
		Ltop.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
		
		ruta= new JLabel("Rutas");
		ruta.setBounds(235,105,100,20);
		ruta.setForeground(new Color(239, 156, 0));
		ruta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
		
		
		tuRE= new JLabel("Tu Reservacion");
		tuRE.setBounds(60,105,130,20);
		tuRE.setForeground(new Color(239, 156, 0));
		tuRE.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
		JLB = new JPanel();
		JLB.setLayout(null);
		
		JScrollPane SCL = new JScrollPane(JLB);
		SCL.setBounds(60,130,130,130);	
		agregarSP();
		SCL.setViewportView(JLB);
		SCL.getViewport().setView(JLB);
		JLB.setBackground(new Color(79,79,79));
		SCRB = new JScrollPane();
		
		rutadatos();
		rutaCBB.setBounds(230,130,130,20);
		rutaCBB.setBackground(new Color(239, 156, 0));
		
		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(this);
		aceptar.setBounds(60, 270, 130, 40);
		aceptar.setBackground(new Color(239, 156, 0));
		aceptar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		cancelar.setBounds(75, 330, 100, 25);
		cancelar.setBackground(new Color(239, 156, 0));
		cancelar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		

		tu = new JLabel("Tu asiento:");
		tu.setBounds(90,380,100,20);
		tu.setForeground(new Color(239, 156, 0));
		tu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
		Icon IcTu= new ImageIcon(".\\Imagenes/tu_asiento.png");
		Itu= new JLabel(IcTu);
		Itu.setBounds(180,375,30,30);
		
		dis = new JLabel("Disponible:");
		dis.setBounds(220,380,100,20);
		dis.setForeground(new Color(239, 156, 0));
		dis.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
		Icon icdis= new ImageIcon(".\\Imagenes/disponible_asiento.png");
		Idis= new JLabel(icdis);
		Idis.setBounds(310,375,30,30);
		
		ocu = new JLabel("Ocupado:");
		ocu.setBounds(350,380,100,20);
		ocu.setForeground(new Color(239, 156, 0));
		ocu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
		Icon Icocu= new ImageIcon(".\\Imagenes/ocupado.png");
		Iocu= new JLabel(Icocu);
		Iocu.setBounds(430,375,30,30);
		
		horario = new JLabel("Horario");
		horario.setBounds(400,105,100,20);
		horario.setForeground(new Color(239, 156, 0));
		horario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
		
		autobus = new JLabel("Asientos");
		autobus.setBounds(570,35,100,20);
		autobus.setForeground(new Color(239, 156, 0));
		autobus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
		SCAB = new JScrollPane();
		
		frame.add(icon);
		frame.add(Ltop);
		frame.add(ruta);
		frame.add(rutaCBB);
		frame.add(tuRE);
		
		frame.add(aceptar);
		frame.add(cancelar);
		
		frame.add(SCL);
		
		frame.add(horario);
		frame.add(SCRB);
		
		frame.add(autobus);
		frame.add(SCAB);
	}

	
	private void  agregarAB(){
		
		
		datos Data = new datos() ;
		ArrayList<Integer> listaautobus = new ArrayList<>();
		listaautobus = Data.autobus(item, Hitem);
		
		
		
		String[] auto= new String [listaautobus.size()];
		
		
		for( int i = 0; i < listaautobus.size() ; i++)
		{
			
			auto[i]=listaautobus.get(i)+"";
		//	System.out.println(auto[i]+"\t"+i);
		}
		
		Dautobus.setText("Autobus: "+auto[0]);
		Aitem=auto[0]+"";
		
		
		JLabel no = new JLabel();
		
		JPanel AB = new JPanel();
		AB.setLayout(null);
		
		JLabel nobus = new JLabel("Autobus: "+auto[0]);
		nobus.setBounds(60, 10, 200, 25);
		nobus.setForeground(new Color(239, 156, 0));
		nobus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		AB.add(nobus);
		
		A = new JLabel("A");
		A.setBounds(40, 40, 200, 25);
		A.setForeground(new Color(239, 156, 0));
		A.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		AB.add(A);
		
		B = new JLabel("B");
		B.setBounds(70, 40, 200, 25);
		B.setForeground(new Color(239, 156, 0));
		B.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		AB.add(B);

		C = new JLabel("C");
		C.setBounds(130, 40, 200, 25);
		C.setForeground(new Color(239, 156, 0));
		C.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		AB.add(C);

		D = new JLabel("D");
		D.setBounds(160, 40, 200, 25);
		D.setForeground(new Color(239, 156, 0));
		D.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		AB.add(D);
		
		Icon IcTu= new ImageIcon(".\\Imagenes/tu_asiento.png");
		Icon Icocu= new ImageIcon(".\\Imagenes/ocupado.png");
		Icon icdis= new ImageIcon(".\\Imagenes/disponible_asiento.png");

		for(int i = 0 ; i <10; i++)
		{
			numero.add(new JLabel(""+(i+1))); 
			numero.get(i).setBounds(5, 60+(28*i), 40, 25);
			numero.get(i).setForeground(new Color(239, 156, 0));
			numero.get(i).setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			AB.add(numero.get(i));
		}
		
		JLabel[][] as = new JLabel[10][4];
		
		datos valor = new datos();
		ArrayList<ClaseAsiento> listaasientos = new ArrayList<ClaseAsiento>();
		listaasientos  =  valor.Columna(item, Hitem);
		
		
		for(int i = 0 ; i <10; i++)
		{
			for (int e = 0 ; e <4; e++)
			{
					
						as[i][e] =new JLabel(icdis);

						if(e < 2) 
						{
							as[i][e].setBounds(28+(e*30), 60+(28*i), 30, 30);
						}
						else 
						{
							as[i][e].setBounds(57+(e*30), 60+(28*i), 30, 30);
						}
						
						as[i][e].addMouseListener(new MouseAdapter() {
							
					          @Override
					          public void mouseClicked(MouseEvent e) {
					              String src1 =e.getSource()+"";
					              
					              for(int i = 0;i <10; i++) 
					              {
				            		 for (int i2 = 0 ; i2 <4; i2++)
				         			{
					            	   
					            	  if (as[i][i2].toString().equals( e.getSource()+"" )  ) {
					            		  
					            		  if(col !=-1 && row != -1)
					            		  {
					            			  as[col][row].setIcon(icdis);
					            		  }
					            		  as[i][i2].setIcon(IcTu);
					            		  
					            		  col = i;
					            		  row = i2;
					            		  
					            		  if(i2 == 0) {
						            		  Sitem = ("A"+(i+1));
						            	  }
						            	  if(i2 == 1) {
						            		  Sitem = ("B"+(i+1));
						            	  }
						            	  if(i2 == 2) {
						            		  Sitem = ("C"+(i+1));
						            	  }
						            	  if(i2 == 3) {
						            		  Sitem = ("D"+(i+1));
						            	  }
						            	  
						            	  Col=(i+1)+"";
						            	  Row=(i2+1)+"";
						            	  
					            		  Dasiento.setText("Asiento: "+Sitem);
					            	  }	
					            	  
				         			}
				            	 } 
					          }
					      	});
						
						AB.add(as[i][e]);
					
			}
		}
for(int i = 0 ; i <10; i++)
	{
	for (int e = 0 ; e <4; e++)
		{
		for(int x = 0; x<listaasientos.size() ;x++)
			{
			if(  e == (listaasientos.get(x).row_asiento-1) && i == (listaasientos.get(x).col_asiento -1) )
				{

			AB.remove(as[i][e]);
			as[i][e] =new JLabel(Icocu);
			if(e < 2) 
			{
				as[i][e].setBounds(28+(e*30), 60+(28*i), 30, 30);
			}
			else 
			{
				as[i][e].setBounds(57+(e*30), 60+(28*i), 30, 30);
			}
			AB.add(as[i][e]);

				}
			}
		}	
	}
		
		SCAB.setBounds(570,60,200,350);	
		this.setBounds(500,300,830,480);
		SCAB.setViewportView(AB);
		SCAB.getViewport().setView(AB);
		frame.add(tu);
		frame.add(Itu);
		frame.add(dis);		
		frame.add(Idis);
		frame.add(ocu);
		frame.add(Iocu);
		AB.setBackground(new Color(79,79,79));
}
	
	
	
	private void agregarHRR() {
		
		JPanel HRR = new JPanel();
		HRR.setLayout(null);
		HRR.removeAll();

		datos Data = new datos() ;
		listahorario = new ArrayList<>();
		listahorario = Data.horario(item);
        
		//System.out.println(item);

		HRR.setPreferredSize(new Dimension(10, 10+(20*listahorario.size())));

		
		String[] hora= new String [listahorario.size()];
		
		for( int i = 0; i < listahorario.size() ; i++)
		{
			
			hora[i]=listahorario.get(i)+"";
			//System.out.println(hora[i]+"");

		}
		
		JRadioButton[] botonhorario = new JRadioButton[hora.length];
		horGroup = new ButtonGroup();
		
		for(int i = 0; i < botonhorario.length; i++) 
		{
			botonhorario[i] = new JRadioButton();
			botonhorario[i].setText(hora[i]);
			botonhorario[i].setBackground(new Color(79,79,79));
			botonhorario[i].setForeground(new Color(239, 156, 0));
			//System.out.println(item);
			//System.out.println(hora[i]+"");
			
			botonhorario[i].setBounds(5, 5+(30*i), 80, 25);
			botonhorario[i].addActionListener(this);
			horGroup.add(botonhorario[i]);
			HRR.add(botonhorario[i]);
//			System.out.println(item + "   "+botonhorario[i].getText()+" ");
		}
		
		

			HRR.revalidate();
			HRR.repaint();
		
		 	
			SCRB.setBounds(400,130,130,200);	
			SCRB.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			SCRB.setViewportView(HRR);
			SCRB.getViewport().setView(HRR);
			HRR.setBackground(new Color(79,79,79));

			
	}
	
	static private String selectedString(ItemSelectable is) {
	    Object selected[] = is.getSelectedObjects();
	    return ((selected.length == 0) ? "null" : (String) selected[0]);
	  }
	
	
	private void rutadatos() {
		
		datos Data = new datos() ;
		listaruta = Data.ruta();
		
		String[] ruta= new String [listaruta.size()];
		
		for( int i = 0; i < listaruta.size() ; i++)
		{
			
			ruta[i]=listaruta.get(i)+"";
			
		}
			
		rutaCBB = new JComboBox(ruta);

		ItemListener itemListener = new ItemListener() {
		      
			public void itemStateChanged(ItemEvent itemEvent) {
			int state = itemEvent.getStateChange();
	        
				//System.out.println("Item: " + itemEvent.getItem());
		        ItemSelectable is = itemEvent.getItemSelectable();
		        //System.out.println("" + selectedString(is));
		        item = "" + selectedString(is);
		        //System.out.println(item);
		        agregarHRR();
		        
		        Druta.setText("Ruta: "+item);
		      }
			
		    };
		    
		 if(item == "")
		 {
			 item = ""+rutaCBB.getSelectedItem();
		 }
		   agregarHRR();
	       
		   Druta.setText("Ruta: "+item);

		rutaCBB.addItemListener(itemListener);

	}
	
	
	private void agregarSP() {
		
		Druta = new JLabel("Ruta:");
		Druta.setBounds(5,10,100,20);
		Druta.setForeground(new Color(239, 156, 0));
		Druta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		Dhorario = new JLabel("Horario:");
		Dhorario.setBounds(5,40,130,20);
		Dhorario.setForeground(new Color(239, 156, 0));
		Dhorario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		Dautobus = new JLabel("Autobus:");
		Dautobus.setBounds(5,70,100,20);
		Dautobus.setForeground(new Color(239, 156, 0));
		Dautobus.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		Dasiento = new JLabel("Asiento:");
		Dasiento.setBounds(5,100,100,20);
		Dasiento.setForeground(new Color(239, 156, 0));
		Dasiento.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

		JLB.add(Druta);
		JLB.add(Dhorario);
		JLB.add(Dautobus);
		JLB.add(Dasiento);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == cancelar)
		{
			IInicio.Inicio();
			this.dispose();
		}
		if(e.getSource() instanceof JRadioButton ) {
			
		Dhorario.setText("Horario: "+(((JRadioButton)e.getSource()).getText()+""));
		Hitem = ((JRadioButton)e.getSource()).getText()+"";
		Sitem="";
		agregarAB();
		}
		
		if(e.getSource()== aceptar && Sitem !="") {
			IIngresarDatos.IngresaDatos();
			this.dispose();
		}
	}
}
