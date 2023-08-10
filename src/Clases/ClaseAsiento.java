package Clases;
import java.util.ArrayList;

public class ClaseAsiento {
	
	ArrayList<ClaseAsiento> formato = new ArrayList<ClaseAsiento>();
	public int id_asiento;
	public int col_asiento;
	public int row_asiento;
	public String ruta_bus; 
	public String hora_bus;
	
	public ClaseAsiento(int id_asiento, int col_asiento, int row_asiento, String ruta_bus, String hora_bus) {
		
		this.id_asiento = id_asiento;
		this.col_asiento = col_asiento;
		this.row_asiento =row_asiento ;
		this.ruta_bus =ruta_bus  ; 
		this.hora_bus = hora_bus ;
		
		
	}
}
