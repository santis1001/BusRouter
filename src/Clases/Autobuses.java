package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Autobuses {

	ArrayList<ClasesAutobus> autobus = new ArrayList<ClasesAutobus> ();
	public ArrayList<ClasesAutobus> AutoBus() {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM autobuses.autobuses ;");
			while (rs.next()) {
				
				int id_bus = rs.getInt(1);
				String ruta_bus= rs.getString(2);
				String hora_bus= rs.getString(3);
				int no_bus= rs.getInt(4);
				
				ClasesAutobus auto = new ClasesAutobus(id_bus, ruta_bus, hora_bus, no_bus); 
				autobus.add(auto);
				}
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
		return autobus;
	}
	
	public int IDbus() {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		int id_bus = 0 ;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT max(id_bus) FROM autobuses.autobuses;");
			while (rs.next()) {
				
				id_bus = rs.getInt(1);
				
				}
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
		return id_bus;
	}

	public void AgregarBus(int id_bus, String ruta_bus, String hora_bus, int no_bus) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			stm.executeUpdate("INSERT INTO autobuses.autobuses VALUES ("+id_bus+",'"+ ruta_bus+"', '"+hora_bus+"',"+no_bus+");");

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

	public void EditarBus(int id_bus, String ruta_bus, String hora_bus, int no_bus) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			stm.executeUpdate("UPDATE `autobuses`.`autobuses` SET `ruta_bus` = '"+ruta_bus+"', `horario_bus` = '"+hora_bus+"', `no_bus` = '"+no_bus+"' WHERE (`id_bus` = '"+id_bus+"');");

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
	
	public int Cantidad_reservaciones() {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		int id_asi = 0;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT max(id_asientos) FROM autobuses.asientos;");

			while (rs.next()) {
				 id_asi= rs.getInt(1);
				
			}
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
		return id_asi;
	
	}

	public void Borrar(int id_bus) {


		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			stm.execute("delete FROM autobuses.autobuses where id_bus = "+id_bus+";");

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

	public void Basientos() {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			stm.execute("DELETE FROM autobuses.asientos");

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
}