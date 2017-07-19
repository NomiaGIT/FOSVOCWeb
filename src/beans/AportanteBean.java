package beans;


import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;

import cliente.ClienteRest;

import datatypes.DataAportante;

public class AportanteBean{

	private  HttpServletRequest httpServletRequest;
	private  FacesContext faceContext;

	private String usuario =""; 
	private String nombre ="";
	private String apellido ="";
	private String pass ="";
	private String tipo ="";
	private String email ="";
	private String domicilio;
	private String telefono;
	private String fechaNacimiento;
	private String nacionalidad;
	private String antiguapass="";
	private String nuevapass="";
	private String msgmodificar="";
	private String msgmodificarpass="";
	private int id;
	
	public AportanteBean() {

		faceContext=FacesContext.getCurrentInstance();
		httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();	
	}
	
	@PostConstruct
    public void obtenerAportante()
    {
    	ClienteRest cliente = ClienteRest.getInstancia();
		int idusuario =  (Integer) httpServletRequest.getSession().getAttribute("idUsuario");//es la cedula del usuario logueado
		
		DataAportante data = null;
		try {
			data = cliente.getAportante(idusuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(data != null)
		{
			this.usuario = data.getNick();
			this.nombre = data.getNombre();
			this.apellido = data.getApellidos();
			this.tipo = data.getRol();
			this.email = data.getEmail();
			this.pass = data.getPass();
			if(data.getCalleDomicilio() == null || data.getNumeroDomicilio() == null)
				this.domicilio = "sin datos";
			else
			this.domicilio = data.getCalleDomicilio()+" "+data.getNumeroDomicilio();
			if(data.getTelefonoDomicilio() == null)
				this.telefono = "sin datos";
			else
			this.telefono = data.getTelefonoDomicilio();
			this.fechaNacimiento = data.getFechaNacimiento();
			this.nacionalidad = data.getNacionalidad();
		}
    }
	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		if(apellido == null)
			apellido = "sin datos";
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTipo() {
		//obtenerUsuario();
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		if(email == null)
			email = "sin datos";
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void apellidoChanged(ValueChangeEvent e){
		apellido = e.getNewValue().toString();
	}

	public String getAntiguapass() {
		return antiguapass;
	}

	public void setAntiguapass(String antiguapass) {
		this.antiguapass = antiguapass;
	}

	public String getNuevapass() {
		return nuevapass;
	}

	public void setNuevapass(String nuevapass) {
		this.nuevapass = nuevapass;
	}
	
	public String getMsgmodificar() {
		return msgmodificar;
	}

	public void setMsgmodificar(String msgmodificar) {
		this.msgmodificar = msgmodificar;
	}

	public String getMsgmodificarpass() {
		return msgmodificarpass;
	}

	public void setMsgmodificarpass(String msgmodificarpass) {
		this.msgmodificarpass = msgmodificarpass;
	}

	public FacesContext getFaceContext() {
		return faceContext;
	}

	public void setFaceContext(FacesContext faceContext) {
		this.faceContext = faceContext;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public int getId() {
		faceContext=FacesContext.getCurrentInstance();
		httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();   	  
	    id = (Integer)httpServletRequest.getSession().getAttribute("idUsuario");
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void keepSessionAlive()
	{
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
		request.getSession();
	}

}

