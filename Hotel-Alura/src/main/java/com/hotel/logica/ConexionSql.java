
package com.hotel.logica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexionSql {
	public Connection sqlConnec;
	protected List<Reserva> listaR;
	protected List<Huespedes> listaH;

	public ConexionSql() {
		try {
			this.sqlConnec = DriverManager.getConnection(
					"jdbc:mysql://localhost:8080/hotel-alura?userTimeZone=true&serverTimeZone=UTC", "root", "12345");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Conexión a SQl");

	}
	public boolean validarCredencialesUsuario(Connection conexion, String usuario, String password) throws SQLException {
		try (PreparedStatement consulta = conexion.prepareStatement(
				"SELECT COUNT(*) AS count FROM usuarios WHERE NombreUsuario = ? AND Password = ?")) {
			consulta.setString(1, usuario);
			consulta.setString(2, password);
	
			try (ResultSet respuesta = consulta.executeQuery()) {
				if (respuesta.next()) {
					return respuesta.getInt("count") == 1;
				}
			}
		} catch (SQLException e) {
			throw new SQLException("Error al validar credenciales de usuario", e);
		}
		
		return false;
	}
	

	public void huespedSql(String fecha1, String fecha2, String valor, String nationality, String phone, int IdResevastion) {
		try {
			PreparedStatement consulta;
			consulta = this.sqlConnec.prepareStatement(
					"INSERT INTO huespedes(Nombre,Apellido,FechaDeNacimiento,Nacionalidad,Telefono,IdReserva) VALUES(?,?,?,?,?,?)");
			consulta.setString(1, fecha1);
			consulta.setString(2, fecha2);
			consulta.setString(3, valor);
			consulta.setString(4, nationality);
			consulta.setString(5, phone);
			consulta.setInt(6, IdResevastion);
			consulta.executeUpdate();
			this.sqlConnec.close();
			System.out.println("Close a SQl");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.sqlConnec.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void reservacionSql(String fecha1, String fecha2, Float valor, String FormaPago)  {
		try {
			PreparedStatement consulta;
			consulta = this.sqlConnec.prepareStatement("INSERT INTO reservas(FechaEntrada,FechaSalida,Valor,FormaPago) VALUES(?,?,?,?)");
			consulta.setString(1, fecha1);
			consulta.setString(2, fecha2);
			consulta.setFloat(3, valor);
			consulta.setString(4, FormaPago);
			consulta.executeUpdate();
			this.sqlConnec.close();
			System.out.println("Close a SQl");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.sqlConnec.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void datosRseservasSql(String buscar) {
		try {
			Statement stmt = this.sqlConnec.createStatement();
			ResultSet rs;
			if(buscar == null) {
				rs = stmt.executeQuery("SELECT * FROM reservas");
			}else{
				rs = stmt.executeQuery("SELECT * FROM reservas WHERE Id LIKE '"+buscar+"%' OR FechaEntrada LIKE '"+buscar+"%' OR FechaSalida LIKE '"+buscar+"%' OR Valor LIKE '"+buscar+"%' OR FormaPago LIKE '"+buscar+"%'");
			}

			this.listaR = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("Id");
				Date entrada = rs.getDate("FechaEntrada");
				Date salida = rs.getDate("FechaSalida");
				float valor = rs.getFloat("Valor");
				String pago = rs.getString("FormaPago");
				Reserva reserva = new Reserva(id, entrada, salida, valor, pago);
				getListaR().add(reserva);
			}
			this.sqlConnec.close();
			System.out.println("Close a SQl");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void datosHuespedesSql(String buscar) {
		try {
			Statement stmt = this.sqlConnec.createStatement();
			ResultSet rs;

			if(buscar==null){
				rs = stmt.executeQuery("SELECT * FROM huespedes");
			}else{
				rs = stmt.executeQuery(" SELECT * FROM huespedes WHERE Id LIKE '"+buscar+"%' OR Apellido LIKE '"+buscar+"%' OR Nombre LIKE '"+buscar+"%' OR FechaDeNacimiento LIKE '"+buscar+"%' OR Nacionalidad LIKE '"+buscar+"%' OR Telefono LIKE '"+buscar+"%' OR IdReserva LIKE '"+buscar+"%'");
			}

			this.listaH = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("Id");
				String nombre = rs.getString("Nombre");
				String apellido = rs.getString("Apellido");
				Date fecha = rs.getDate("FechaDeNacimiento");
				String nacionalidad = rs.getString("Nacionalidad");
				String telefono = rs.getString("Telefono");
				int idReserva = rs.getInt("IdReserva");
				Huespedes huespedes = new Huespedes(id, nombre, apellido, fecha, nacionalidad, telefono, idReserva);
				getListaH().add(huespedes);
			}
			this.sqlConnec.close();
			System.out.println("Close a SQl");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminaDatosSql(boolean table, int id){
		try {
			PreparedStatement consulta;
			if(table){
				consulta = this.sqlConnec.prepareStatement("DELETE FROM huespedes WHERE Id="+id);
			}else{
				consulta = this.sqlConnec.prepareStatement("DELETE FROM reservas WHERE Id="+id);
			}
			consulta.executeUpdate();
			this.sqlConnec.close();
			System.out.println("Close a SQl");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.sqlConnec.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateSql(boolean table,ArrayList<String[]> matriz){
		try {
			PreparedStatement consulta;
			if(table){
				for(int i=0;i<matriz.size();i++){
					String[] array = matriz.get(i);
					consulta = this.sqlConnec.prepareStatement("UPDATE huespedes SET "+array[2]+"='"+array[1]+"' WHERE Id="+array[0]);
					consulta.executeUpdate();
					System.out.println("->"+i);
				}
			}else{
				for(int i=0;i<matriz.size();i++){

					String[] array = matriz.get(i);
					consulta = this.sqlConnec.prepareStatement("UPDATE reservas SET "+array[2]+"='"+array[1]+"' WHERE Id="+array[0]);
					consulta.executeUpdate();
					System.out.println("-X"+i);
				}
			}	
			this.sqlConnec.close();
			System.out.println("Close a SQl");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.sqlConnec.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Reserva> getListaR() {
		return listaR;
	}
	public List<Huespedes> getListaH() {
		return listaH;
	}

	// public static void main(String[] args) throws SQLException {
	// 	ConexionSql n = new ConexionSql();
	// 	System.out.println(
	// 		n.validarCredencialesUsuario(n.sqlConnec, "Cristian", "12345")
	// 	);
	// }
}
