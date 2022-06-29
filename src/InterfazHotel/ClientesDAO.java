package InterfazHotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import Objetos.Usuarios;
//import Objetos.conectar;

public class ClientesDAO {
	int r;
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	conectar acceso = new conectar();
	usu pro =  new usu();
	
	public List listarUsuario() {

		String sql = "select * from usuarios";
		List<usu> listaprod = new ArrayList<>();
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				usu p = new usu();
				p.setUsuario_id(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setApellido(rs.getString(3));
				p.setTelefono(rs.getInt(4));
				p.setDireccion(rs.getString(5));
				p.setCorreo(rs.getString(6));
				p.setfecha(rs.getString(7));
				p.setRol(rs.getInt(8));
				p.setActivo(rs.getInt(9));
				p.setContraseña(rs.getString(10));
				listaprod.add(p);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return listaprod;
	}
	
	public void agregar(int usuario_id,String nombre, String apellido, int telefono, String direccion, String correo_electronico, String feha_nacimiento, int rol_id, int activo, String contraseña) {
		String sql = "insert into usuarios(usuario_id,nombre,apellido,telefono,direccion,correo_electronico,fecha_nacimiento,rol_id,activo,contraseña)values(?,?,?,?,?,?,?,?,?,?)";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, usuario_id);
			ps.setString(2,nombre);
			ps.setString(3,apellido);
			ps.setInt(4,telefono);
			ps.setString(5,direccion);
			ps.setString(6,correo_electronico);
			ps.setString(7,feha_nacimiento);
			ps.setInt(8,rol_id);
			ps.setInt(9,activo);
			ps.setString(10,contraseña);
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void modificar(int usuario_id,String nombre, String apellido, int telefono, String direccion, String correo_electronico, String feha_nacimiento, int rol_id, int activo, String contraseña) {
		String sql = "update usuarios set nombre=?,apellido=?,telefono=?,direccion=?,correo_electronico=?,fecha_nacimiento=?,rol_id=?,activo=?,contraseña=? where usuario_id=?";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1,nombre);
			ps.setString(2,apellido);
			ps.setInt(3,telefono);
			ps.setString(4,direccion);
			ps.setString(5,correo_electronico);
			ps.setString(6,feha_nacimiento);
			ps.setInt(7,rol_id);
			ps.setInt(8,activo);
			ps.setString(9,contraseña);
			ps.setInt(10, usuario_id);
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(int id) {
		String sql = "delete from usuarios where usuario_id=?";
		try {
			con = acceso.Conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e) {
			
		}
	}
}
