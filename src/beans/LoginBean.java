package beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cliente.ClienteRest;
import datatypes.DataUsuarioLogin;
import datatypes.DataLoginIn;
import excepciones.PersistenciaException;
import utilitarios.Utilidades;

public class LoginBean {

	private String usuario; 
	private String contrasena; 
	private String msg;

	private  HttpServletRequest httpServletRequest;
	private  FacesContext faceContext;
	private FacesMessage facesMessage;

	public LoginBean() {

		faceContext=FacesContext.getCurrentInstance();
		httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
	}

	public String getUsuario() {

		return usuario;

	}

	public void setUsuario(String usuario) {

		this.usuario = usuario;

	}

	public String getContrasena() {

		return contrasena;

	}

	public void setContrasena(String contrasena) {

		this.contrasena = contrasena;

	}

	public String validacion() 
	{ 
		String mensaje = "login";  
		try {
			faceContext=FacesContext.getCurrentInstance();
			httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();   
		    ClienteRest cliente = ClienteRest.getInstancia();
		    String pass = Utilidades.Encriptar(contrasena);
		    DataLoginIn loginin = new DataLoginIn(usuario, pass);
		    DataUsuarioLogin output = cliente.login(loginin);		   
				if(output != null)
				{
					String nombreUsuario = output.getNombres()+" "+output.getApellidos();
					String usuario = output.getUsuario();
					int idusuario = output.getDocumento();
					String tipo = output.getNombreRol();
					httpServletRequest.getSession().setAttribute("sessionUsuario", nombreUsuario);
					httpServletRequest.getSession().setAttribute("idUsuario", idusuario);
					httpServletRequest.getSession().setAttribute("tipoUsuario", tipo);	
					httpServletRequest.getSession().setAttribute("nickUsuario", usuario);	
					mensaje = "Inicio";
				}
				else 
				{
					msg = " No se encuentra un usuario con la información ingresada";
					facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
					faceContext.addMessage(null, facesMessage);					
					mensaje = "login";
				}
				
		} catch (PersistenciaException e) {
			msg = e.getMensaje()+"";
			facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
			faceContext.addMessage(null, facesMessage);
			mensaje = "login";
		}        
		faceContext.getExternalContext().getFlash().setKeepMessages(true);
		return mensaje;
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
	

	
}

