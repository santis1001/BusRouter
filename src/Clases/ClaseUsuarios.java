package Clases;

import java.util.ArrayList;

public class ClaseUsuarios {
	
	ArrayList<ClaseUsuarios> formato = new ArrayList<ClaseUsuarios>();
	public int id_usu;
	public String Nombre;
	public String contra;
	public int nivel;

	
	public ClaseUsuarios(int id_usu, String Nombre ,String contra, int nivel) {
		
		this.id_usu = id_usu;
		this.Nombre = Nombre;
		this.contra = contra;
		this.nivel = nivel;
	}
}


