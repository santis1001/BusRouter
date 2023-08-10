package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

	
	public static void main(String[]args) {
		
		Connection CON = null;
		String URL = "jdbc:mysql://localhost:3306/autobuses_2";
		String USUARIO = "root";
		String CLAVE = "";


		
		
		try {
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			CON = DriverManager.getConnection(URL, USUARIO, CLAVE);
			PreparedStatement pstm = null;
			ResultSet rs = null;
			String quary = "SELECT * FROM autobuses";
			
			pstm = CON.prepareStatement(quary);
			rs = pstm.executeQuery();
			 
			 System.out.println("Conexión OK");
			 
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR no se pudo conectar a la base de datos");
			e.printStackTrace();
			System.out.println("Conexión NO OK");

		}
	}

	public static Connection conectar() {
		
			Connection CON = null;
			String URL = "jdbc:mysql://localhost:3306/autobuses_2";
			String USUARIO = "root";
			String CLAVE = "";
			
			try {
				
				CON = DriverManager.getConnection(URL, USUARIO, CLAVE);
			//	System.out.println("Conexión OK");
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "ERROR no se pudo conectar a la base de datos");
				e.printStackTrace();
				System.out.println("Conexión NO OK");

			}
		
		return CON;
	}


	
}


