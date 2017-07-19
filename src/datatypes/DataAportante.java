package datatypes;

import java.io.Serializable;
import com.google.gson.Gson;


@SuppressWarnings("serial")
public class DataAportante implements Serializable {
	private String nick;
	private String pass;
	private boolean conectado;
	private int cedula;
	private String nombre;
	private String apellidos;
	private String rol;
	private boolean activo;
	private String sexo;	
	private String email;
	public String categoria;
	private String fechaNacimiento;
	private String nacionalidad;
	private String estadoCivil;
	
	//datos conyuge
	private int cedulaCon;
	private String nombresCon;
	private String apellidosCon;
	private String fechaNacimientoCon;
	private String nacionalidadCon;
	private String estadoCivilCon;
	private String sexoCon;
	//datos familia
	private int cantMayoresFamilia;
	private int cantMenoresFamilia;
	private int cantDiscapacitadosFamilia;
	// datos trabajo
	private String categoriaTrabajo;
	private String inicioEnEmpresa;
	private String inicioEnIndustria;
	private double ingresoMensualTrabajo;
	private double otrosIngresosTrabajo;
	private String nombreEmpresaTrabajo;
	private String direccionEmpresaTrabajo;
	private String telefonoEmpresaTrabajo;
	private long rUTEmpresaTrabajo;
	//datos domicilio
	private String calleDomicilio;
	private String numeroDomicilio;
	private String barrioDomicilio;
	private String ciudadDomicilio;
	private String departamentoDomicilio;
	private String telefonoDomicilio;
	public DataAportante(String nick, String pass, boolean conectado, int cedula, String nombre, String apellidos, String rol, boolean activo, String sexo, String email,
			String categoria, String fechaNacimiento, String nacionalidad, String estadoCivil, int cedulaCon, String nombresCon, String apellidosCon, String fechaNacimientoCon,
			String nacionalidadCon, String estadoCivilCon, String sexoCon, int cantMayoresFamilia, int cantMenoresFamilia, int cantDiscapacitadosFamilia, String categoriaTrabajo,
			String inicioEnEmpresa, String inicioEnIndustria, double ingresoMensualTrabajo, double otrosIngresosTrabajo, String nombreEmpresaTrabajo,
			String direccionEmpresaTrabajo, String telefonoEmpresaTrabajo, long rUTEmpresaTrabajo, String calleDomicilio, String numeroDomicilio, String barrioDomicilio,
			String ciudadDomicilio, String departamentoDomicilio, String telefonoDomicilio) {
		super();
		this.nick = nick;
		this.pass = pass;
		this.conectado = conectado;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.rol = rol;
		this.activo = activo;
		this.sexo = sexo;
		this.email = email;
		this.categoria = categoria;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.estadoCivil = estadoCivil;
		this.cedulaCon = cedulaCon;
		this.nombresCon = nombresCon;
		this.apellidosCon = apellidosCon;
		this.fechaNacimientoCon = fechaNacimientoCon;
		this.nacionalidadCon = nacionalidadCon;
		this.estadoCivilCon = estadoCivilCon;
		this.sexoCon = sexoCon;
		this.cantMayoresFamilia = cantMayoresFamilia;
		this.cantMenoresFamilia = cantMenoresFamilia;
		this.cantDiscapacitadosFamilia = cantDiscapacitadosFamilia;
		this.categoriaTrabajo = categoriaTrabajo;
		this.inicioEnEmpresa = inicioEnEmpresa;
		this.inicioEnIndustria = inicioEnIndustria;
		this.ingresoMensualTrabajo = ingresoMensualTrabajo;
		this.otrosIngresosTrabajo = otrosIngresosTrabajo;
		this.nombreEmpresaTrabajo = nombreEmpresaTrabajo;
		this.direccionEmpresaTrabajo = direccionEmpresaTrabajo;
		this.telefonoEmpresaTrabajo = telefonoEmpresaTrabajo;
		this.rUTEmpresaTrabajo = rUTEmpresaTrabajo;
		this.calleDomicilio = calleDomicilio;
		this.numeroDomicilio = numeroDomicilio;
		this.barrioDomicilio = barrioDomicilio;
		this.ciudadDomicilio = ciudadDomicilio;
		this.departamentoDomicilio = departamentoDomicilio;
		this.telefonoDomicilio = telefonoDomicilio;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isConectado() {
		return conectado;
	}
	public void setConectado(boolean conectado) {
		this.conectado = conectado;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public int getCedulaCon() {
		return cedulaCon;
	}
	public void setCedulaCon(int cedulaCon) {
		this.cedulaCon = cedulaCon;
	}
	public String getNombresCon() {
		return nombresCon;
	}
	public void setNombresCon(String nombresCon) {
		this.nombresCon = nombresCon;
	}
	public String getApellidosCon() {
		return apellidosCon;
	}
	public void setApellidosCon(String apellidosCon) {
		this.apellidosCon = apellidosCon;
	}
	public String getFechaNacimientoCon() {
		return fechaNacimientoCon;
	}
	public void setFechaNacimientoCon(String fechaNacimientoCon) {
		this.fechaNacimientoCon = fechaNacimientoCon;
	}
	public String getNacionalidadCon() {
		return nacionalidadCon;
	}
	public void setNacionalidadCon(String nacionalidadCon) {
		this.nacionalidadCon = nacionalidadCon;
	}
	public String getEstadoCivilCon() {
		return estadoCivilCon;
	}
	public void setEstadoCivilCon(String estadoCivilCon) {
		this.estadoCivilCon = estadoCivilCon;
	}
	public String getSexoCon() {
		return sexoCon;
	}
	public void setSexoCon(String sexoCon) {
		this.sexoCon = sexoCon;
	}
	public int getCantMayoresFamilia() {
		return cantMayoresFamilia;
	}
	public void setCantMayoresFamilia(int cantMayoresFamilia) {
		this.cantMayoresFamilia = cantMayoresFamilia;
	}
	public int getCantMenoresFamilia() {
		return cantMenoresFamilia;
	}
	public void setCantMenoresFamilia(int cantMenoresFamilia) {
		this.cantMenoresFamilia = cantMenoresFamilia;
	}
	public int getCantDiscapacitadosFamilia() {
		return cantDiscapacitadosFamilia;
	}
	public void setCantDiscapacitadosFamilia(int cantDiscapacitadosFamilia) {
		this.cantDiscapacitadosFamilia = cantDiscapacitadosFamilia;
	}
	public String getCategoriaTrabajo() {
		return categoriaTrabajo;
	}
	public void setCategoriaTrabajo(String categoriaTrabajo) {
		this.categoriaTrabajo = categoriaTrabajo;
	}
	public String getInicioEnEmpresa() {
		return inicioEnEmpresa;
	}
	public void setInicioEnEmpresa(String inicioEnEmpresa) {
		this.inicioEnEmpresa = inicioEnEmpresa;
	}
	public String getInicioEnIndustria() {
		return inicioEnIndustria;
	}
	public void setInicioEnIndustria(String inicioEnIndustria) {
		this.inicioEnIndustria = inicioEnIndustria;
	}
	public double getIngresoMensualTrabajo() {
		return ingresoMensualTrabajo;
	}
	public void setIngresoMensualTrabajo(double ingresoMensualTrabajo) {
		this.ingresoMensualTrabajo = ingresoMensualTrabajo;
	}
	public double getOtrosIngresosTrabajo() {
		return otrosIngresosTrabajo;
	}
	public void setOtrosIngresosTrabajo(double otrosIngresosTrabajo) {
		this.otrosIngresosTrabajo = otrosIngresosTrabajo;
	}
	public String getNombreEmpresaTrabajo() {
		return nombreEmpresaTrabajo;
	}
	public void setNombreEmpresaTrabajo(String nombreEmpresaTrabajo) {
		this.nombreEmpresaTrabajo = nombreEmpresaTrabajo;
	}
	public String getDireccionEmpresaTrabajo() {
		return this.direccionEmpresaTrabajo;
	}
	public void setDireccionEmpresaTrabajo(String direccionEmpresaTrabajo) {
		this.direccionEmpresaTrabajo = direccionEmpresaTrabajo;
	}
	public String getTelefonoEmpresaTrabajo() {
		return telefonoEmpresaTrabajo;
	}
	public void setTelefonoEmpresaTrabajo(String telefonoEmpresaTrabajo) {
		this.telefonoEmpresaTrabajo = telefonoEmpresaTrabajo;
	}
	public long getRUTEmpresaTrabajo() {
		return rUTEmpresaTrabajo;
	}
	public void setRUTEmpresaTrabajo(long rUTEmpresaTrabajo) {
		this.rUTEmpresaTrabajo = rUTEmpresaTrabajo;
	}
	public String getCalleDomicilio() {
		return calleDomicilio;
	}
	public void setCalleDomicilio(String calleDomicilio) {
		this.calleDomicilio = calleDomicilio;
	}
	public String getNumeroDomicilio() {
		return numeroDomicilio;
	}
	public void setNumeroDomicilio(String numeroDomicilio) {
		this.numeroDomicilio = numeroDomicilio;
	}
	public String getBarrioDomicilio() {
		return barrioDomicilio;
	}
	public void setBarrioDomicilio(String barrioDomicilio) {
		this.barrioDomicilio = barrioDomicilio;
	}
	public String getCiudadDomicilio() {
		return ciudadDomicilio;
	}
	public void setCiudadDomicilio(String ciudadDomicilio) {
		this.ciudadDomicilio = ciudadDomicilio;
	}
	public String getDepartamentoDomicilio() {
		return departamentoDomicilio;
	}
	public void setDepartamentoDomicilio(String departamentoDomicilio) {
		this.departamentoDomicilio = departamentoDomicilio;
	}
	public String getTelefonoDomicilio() {
		return telefonoDomicilio;
	}
	public void setTelefonoDomicilio(String telefonoDomicilio) {
		this.telefonoDomicilio = telefonoDomicilio;
	}
	public DataAportante (String json)
	{
		Gson gson = new Gson();
		DataAportante d = gson.fromJson(json, DataAportante.class);	
		this.nick = d.getNick();
		this.pass = d.getPass();
		this.conectado = d.isConectado();
		this.cedula = d.getCedula();
		this.nombre = d.getNombre();
		this.apellidos = d.getApellidos();
		this.rol = d.getRol();
		this.activo = d.isActivo();
		this.sexo = d.getSexo();
		this.email = d.getEmail();
		this.categoria = d.getCategoria();
		this.fechaNacimiento = d.getFechaNacimiento();
		this.nacionalidad = d.getNacionalidad();
		this.estadoCivil = d.getEstadoCivil();
		this.cedulaCon = d.getCedulaCon();
		this.nombresCon = d.getNombresCon();
		this.apellidosCon = d.getApellidosCon();
		this.fechaNacimientoCon = d.getFechaNacimientoCon();
		this.nacionalidadCon = d.getNacionalidadCon();
		this.estadoCivilCon = d.getEstadoCivilCon();
		this.sexoCon = d.getSexoCon();
		this.cantMayoresFamilia = d.getCantMayoresFamilia();
		this.cantMenoresFamilia = d.getCantMenoresFamilia();
		this.cantDiscapacitadosFamilia = d.getCantDiscapacitadosFamilia();
		this.categoriaTrabajo = d.getCategoriaTrabajo();
		this.inicioEnEmpresa = d.getInicioEnEmpresa();
		this.inicioEnIndustria = d.getInicioEnIndustria();
		this.ingresoMensualTrabajo = d.getIngresoMensualTrabajo();
		this.otrosIngresosTrabajo = d.getOtrosIngresosTrabajo();
		this.nombreEmpresaTrabajo = d.getNombreEmpresaTrabajo();
		this.direccionEmpresaTrabajo = d.getDireccionEmpresaTrabajo();
		this.telefonoEmpresaTrabajo = d.getTelefonoEmpresaTrabajo();
		this.rUTEmpresaTrabajo = d.getRUTEmpresaTrabajo();
		this.calleDomicilio = d.getCalleDomicilio();
		this.numeroDomicilio = d.getNumeroDomicilio();
		this.barrioDomicilio = d.getBarrioDomicilio();
		this.ciudadDomicilio = d.getCiudadDomicilio();
		this.departamentoDomicilio = d.getDepartamentoDomicilio();
		this.telefonoDomicilio = d.getTelefonoDomicilio();
		
	}
	

}
