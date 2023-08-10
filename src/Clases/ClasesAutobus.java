package Clases;

import java.util.ArrayList;

public class ClasesAutobus {
	
	ArrayList<ClasesAutobus> formato = new ArrayList<ClasesAutobus>();
	public int id_bus;
	public String ruta_bus;
	public String horario;
	public int no_bus;

	
	public ClasesAutobus(int id_bus, String ruta_bus, String horario, int no_bus) {
		
		this.id_bus = id_bus;
		this.ruta_bus = ruta_bus;
		this.horario = horario;
		this.no_bus = no_bus;
	}
}


