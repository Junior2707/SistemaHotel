package InterfazHotel;

public class usu {
	private int usuario_id;
	private String nombre;
	private String apellido;
	private int telefono;
	private String direccion;
	private String correo_electronico;
	private String fecha;
	private int rol_id;
	private int activo;
	private String contraseña;
	private int fila;
	
	
	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	//
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	//
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	//
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	//
	public String getCorreo() {
		return correo_electronico;
	}
	public void setCorreo(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	//
	public String getfecha() {
		return fecha;
	}
	public void setfecha(String fecha) {
		this.fecha = fecha;
	}
	//
	public int getRol() {
		return rol_id;
	}
	public void setRol(int rol_id) {
		this.rol_id = rol_id;
	}
	//
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	//
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	//
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila= fila;
	}
}
