package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class Usuarios {

	int id_usu;
	String nom_usu, pas_usu;
	int niv_usu, num_ventas,num_compras;  
	
	public int acceso(String usuario, String contraseña) {
		
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		int acceso = 0;

		try {
			cn = Conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM autobuses.usuarios");

			while (rs.next()) {
				String nombre_usuario = rs.getString(2);
				String password = rs.getString(3);
				if (usuario.equals(nombre_usuario) && contraseña.equals(password)) {
					acceso = rs.getInt(4);
				}
			}

		} catch (SQLException e) {
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
		return acceso;
	}
	
	
	ArrayList<ClaseUsuarios> Usuarios = new ArrayList<ClaseUsuarios>();

	public ArrayList<ClaseUsuarios> getUsuarios() {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM autobuses.usuarios;");
			while (rs.next()) {
				
				int id_us = rs.getInt(1);
				String nom_us= rs.getString(2);
				String contr_us = rs.getString(3);;
				int niv_us= rs.getInt(4);
				
				ClaseUsuarios usuario = new ClaseUsuarios(id_us, nom_us, contr_us, niv_us); 
				Usuarios.add(usuario);
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
		return Usuarios;
	}

	public void EditarUsu(int id_us, String nom_us, String contr_us, int nivel) {

			Conexion conexion = new Conexion();
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			
	
			try {
				cn = conexion.conectar();
				stm = cn.createStatement();
				stm.execute("UPDATE autobuses.usuarios SET  `nombre_usu` = '"+nom_us+"', `con_usu` = '"+contr_us+"', `acceso_usu` = "+nivel+"  WHERE `id_usu` = '"+id_us+"';");

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


	public void Borrar(int id_us) {
		
		
			Conexion conexion = new Conexion();
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			
			
			
			try {
				cn = conexion.conectar();
				stm = cn.createStatement();
				stm.executeUpdate("delete FROM autobuses.usuarios where id_usu = "+id_us+";");

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

	
	public int IDusuario() {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		int id_us = 0 ;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT max(id_usu) FROM autobuses.usuarios;");
			while (rs.next()) {
				
				id_us = rs.getInt(1);
				
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
		return id_us;
	}
	
	public void AgregarUsu(int id_us, String nom_us, String contr_us, int nivel) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			stm.executeUpdate("INSERT INTO `autobuses`.`usuarios` (`id_usu`, `nombre_usu`, `con_usu`, `acceso_usu`) VALUES ('"+id_us+"', '"+nom_us+"', '"+contr_us+"', '"+nivel+"');");

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
