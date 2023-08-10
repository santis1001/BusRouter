package Clases;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JRadioButton;



public class datos {
	
	public ArrayList <String>Ruta = new ArrayList<>();	
	
	public ArrayList<String> ruta()
	{
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT DISTINCT  ruta_bus FROM autobuses.autobuses;");
			while (rs.next()) {
				
				String ruta = rs.getString(1);
				
				
				Ruta.add(ruta);
				
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
		return Ruta;
	}
	
	
	public ArrayList<String> horarios = new ArrayList<>();	

	public ArrayList<String> horario(String ruta) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT horario_bus FROM autobuses.autobuses Where ruta_bus = '"+ruta+"';");
			while (rs.next()) {
				
				
				String hora = rs.getString(1);
				
				horarios.add(hora);
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
		return horarios;
	}
	ArrayList<Integer> autobus = new ArrayList<Integer>();
	public ArrayList<Integer> autobus(String ruta, String hora) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT no_bus FROM autobuses.autobuses Where ruta_bus = '"+ruta+"' and horario_bus = '"+hora+"';");
			while (rs.next()) {
				
				int nobus = rs.getInt(1);
				
				
				autobus.add(nobus);
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
	
	ArrayList<ClaseAsiento> Lugar = new ArrayList<ClaseAsiento>();


	public ArrayList<ClaseAsiento> Columna(String ruta, String hora) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM autobuses.asientos where ruta_bus = '"+ruta+"' and hora_bus = '"+hora+"' ;");
			while (rs.next()) {
				
				
				int id_asiento = rs.getInt(1);
				int col_asiento = rs.getInt(2);
				int row_asiento = rs.getInt(3);
				String ruta_bus = rs.getString(4); 
				String hora_bus = rs.getString(5);
				
				ClaseAsiento asiento = new ClaseAsiento(id_asiento, col_asiento, row_asiento, ruta_bus, hora_bus);
				
				Lugar.add(asiento);
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Lugar;
	}

	public static void Agregar( int col, int row, String item, String hitemint ) {

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
				 id_asi++;
				
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
			stm.executeUpdate("INSERT INTO `autobuses`.`asientos` (`id_asientos`, `col_asientos`, `row_asientos`, `ruta_bus`, `hora_bus`) VALUES ('"+id_asi+"', '"+col+"', '"+row+"', '"+item+"', '"+hitemint+"');");
			
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

	
	public static void AgregarREG( String Nom, int Mat, String Fac, String Ruta, String Horario, int NBus, String Asiento) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		int id_reg = 0;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT max(id_reg) FROM autobuses.registros;");
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
			stm.executeUpdate("INSERT INTO `autobuses`.`registros` (`id_reg`, `nom_reg`, `mat_reg`, `fac_reg`, `ruta_reg`, `horario_reg`, `autobus_reg`, `asiento_reg`) "
					+ "VALUES ('"+id_reg+"', '"+Nom+"', '"+Mat+"', '"+Fac+"', '"+Ruta+"', '"+Horario+"', '"+NBus+"', '"+Asiento+"');");
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
