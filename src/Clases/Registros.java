package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Registros {
	
	public static String AgregarREG() {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String text="";
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM autobuses.registros;");
			while (rs.next()) {
				text= text + rs.getString(1) +"      "+rs.getString(2)+"   "+rs.getInt(3)+"      "+rs.getString(4)+"      "+rs.getString(5)+"      "+rs.getString(6)+"         "+rs.getInt(7)+"                "+rs.getString(8)+"\n";					
			}
		}catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return text;

		
	}
	public static int cantidadreg() {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		int cant = 0;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM autobuses.registros;");
			while (rs.next()) {
				cant++;

			}
		}catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cant;
	}
	
	public static void VaciarRegistro() {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			stm.execute("DELETE FROM autobuses.registros");

			}

		 catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
			
	}
	
	ArrayList<ClaseRegistro> listaRegistro = new ArrayList<ClaseRegistro>();

	public  ArrayList<ClaseRegistro> Registro() {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		int cant = 0;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM autobuses.cortes_reg;");
			while (rs.next()) {
				
				int id_reg = rs.getInt(1);
				String fecha= rs.getString(2);
				
				ClaseRegistro regis = new ClaseRegistro(id_reg, fecha); 
				listaRegistro.add(regis);
				}
		}catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaRegistro;
	}
	
	public static void SubirRegistro(String fecha) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		int id_reg = 0;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT max(id_corte) FROM autobuses.cortes_reg;");
			while (rs.next()) {
				id_reg= rs.getInt(1);
				id_reg++;
			}
		}catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			stm.executeUpdate("INSERT INTO `autobuses`.`cortes_reg` (`id_corte`, `registro_corte`) VALUES ('"+id_reg+"', '"+fecha+"');");
		}
		catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
