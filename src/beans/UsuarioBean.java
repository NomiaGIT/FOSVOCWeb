package beans;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cliente.ClienteRest;
import datatypes.DataContrasenia;
import datatypes.DataUsuario;
import excepciones.PersistenciaException;
import utilitarios.Utilidades;


public class UsuarioBean{

	private  HttpServletRequest httpServletRequest;
	private  FacesContext faceContext;
	private FacesMessage facesMessage;
	private String usuario =""; 
	private String nombre ="";
	private String apellido ="";
	private String pass ="";
	private String tipo ="";
	private String email ="";
	private String antiguapass="";
	private String nuevapass="";
	private String msgmodificar="";
	private String msgmodificarpass="";
	private String msg;
	private int id;
	
	public UsuarioBean() {

		faceContext=FacesContext.getCurrentInstance();
		httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();	
		//obtenerUsuario();
	}
	
	@PostConstruct
	public void obtenerUsuario() {
		try {
			ClienteRest cliente = ClienteRest.getInstancia();
			if (httpServletRequest.getSession() != null) {
				int idusuario = 0;
				if( httpServletRequest.getSession().getAttribute("idUsuario") != null){
				idusuario = (Integer) httpServletRequest.getSession().getAttribute("idUsuario");
				if (idusuario != 0) {
					DataUsuario data = null;
					data = cliente.getUsuario(idusuario); System.out.println(data);
					if (data != null) {
						this.usuario = data.getUsuario();
						this.nombre = data.getNombres();
						this.apellido = data.getApellidos();
						this.tipo = data.getNombreRol();
						this.email = data.getMail();
						this.pass = new String(data.getContrasenia());
					}
				} else {
					logout();
				}
			} else {
				logout();
			}
			} else {
				logout();
			}
		} catch (PersistenciaException e) {
			System.out.println(e.getMensaje());
			logout();
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
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
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

	public int getId() {
		faceContext=FacesContext.getCurrentInstance();
		httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();   	
		if( httpServletRequest.getSession().getAttribute("idUsuario") != null)
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
	public String logout()
	{
		// invalidate session		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();		
		HttpSession session = (HttpSession) ec.getSession(false);		
		session.invalidate();
		msg = "Hasta luego";
		return "login";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String modificarPassword()
	{
		String resultado = "Inicio";		
		try {
		faceContext=FacesContext.getCurrentInstance();
		httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();   
	    ClienteRest cliente = ClienteRest.getInstancia();
	    DataUsuario du = cliente.getUsuario((Integer) httpServletRequest.getSession().getAttribute("idUsuario"));		  
	    String antiguaPassEncriptada = Utilidades.Encriptar(antiguapass);
		if(du.getContrasenia().equals(antiguaPassEncriptada))
	    {						
	    	String nuevaPassEncriptada = Utilidades.Encriptar(nuevapass);
			DataContrasenia input  = new DataContrasenia(usuario, antiguaPassEncriptada, nuevaPassEncriptada);
    		String output = cliente.modificarContrasenia(input);		      
				if(output.equals("OK"))
				{				
					msgmodificarpass = "Se modificó la contraseña.";
					facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje:", msgmodificarpass);					
					faceContext.addMessage(null, facesMessage);
					resultado = "Inicio";//					
				}
				else 
				{
					msgmodificarpass = "No fue posible modificar la información del usuario.";
					facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje:", msgmodificarpass);
					faceContext.addMessage(null, facesMessage);					
					resultado = "Modificar";
				}
	    }
	    else
	    {
	    	msgmodificarpass = "No coincide la contraseña actual con la ingresada.";
	    	facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje:", msgmodificarpass);
			faceContext.addMessage(null, facesMessage);
			resultado = "Modificar";
	    } 
			
	} catch (PersistenciaException e) {
		msgmodificarpass = e.getMensaje();
		facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, msgmodificarpass, null);
		faceContext.addMessage(null, facesMessage);
		resultado = "Modificar";
	} 
		faceContext.getExternalContext().getFlash().setKeepMessages(true);
		return resultado;
	}
	public String cancelarModificarPassword()
	{
		return "Inicio";
	}
	public String modificar()
	{
		String resultado = "Inicio";
		/*try {
		faceContext=FacesContext.getCurrentInstance();
		httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();   
	    ClienteRest cliente = ClienteRest.getInstancia();	
	    DataUsuario du = cliente.getUsuario((Integer) httpServletRequest.getSession().getAttribute("idUsuario"));	  	
	    DataUsuario input  = new DataUsuario(usuario, nombre, apellido, du.getNumtelefono(), du.getTipotelefono(),
	    		du.getDocumento(), du.getPassword(), email, tipo, du.getDataagente(), du.getDataguia(), du.getDataadmin());
	    
	    DataUsuario output = cliente.modificarUsuario(input);
	    
			if(output != null)
			{				
				httpServletRequest.getSession().setAttribute("sessionUsuario", output.getNombre());
				msgmodificar = "Se modificó la información del usuario.";
				facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje:", msgmodificar);
				faceContext.addMessage(null, facesMessage);
				resultado = "Inicio";
			}
			else 
			{
				msgmodificar = "No fue posible modificar la información del usuario.";
				facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje:", msgmodificar);
				resultado = "Modificar";
			}
			
	} catch (PersistenciaException e) {
		msgmodificar = e.getMensaje();
		facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje:", msgmodificar);
		faceContext.addMessage(null, facesMessage);
		resultado = "Modificar";
	} catch (UsuarioException e) {
		msgmodificar = e.getMensaje();
		facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje:", msgmodificar);
		faceContext.addMessage(null, facesMessage);
		resultado = "Modificar";
	}*/
		faceContext.getExternalContext().getFlash().setKeepMessages(true);
		return resultado;
	}
}

