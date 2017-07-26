package beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import cliente.ClienteRest;
import datatypes.DataUsuario;
import excepciones.PersistenciaException;
import utilitarios.EnviarMail;

public class EmailBean {
	private  HttpServletRequest httpServletRequest;
	private  FacesContext faceContext;
	private FacesMessage facesMessage;
	private String remitente;
	private String emailremitente;
	private String asunto;
	private String textomensaje;
	private String msgMail;
	
	public EmailBean()
	{
		faceContext=FacesContext.getCurrentInstance();
		httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
	}
	
	public String enviar()
	{
		String mensaje = "login";  
		try {
			faceContext=FacesContext.getCurrentInstance();
			httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();   
		    ClienteRest cliente = ClienteRest.getInstancia();
		    int idusuario = (Integer) httpServletRequest.getSession().getAttribute("idUsuario");
		    DataUsuario du = cliente.getUsuario(idusuario);
				if(du != null)
				{
					emailremitente = du.getMail();
					remitente = du.getNombres()+" "+du.getApellidos();
					boolean ok = EnviarMail.enviarmail(asunto, textomensaje, remitente, emailremitente);
					if(ok)
					{
						String enviar = "Se envió el correo a Fosvoc.";
						facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje:", enviar);					
						faceContext.addMessage(null, facesMessage);						
					}else
					{
						String enviar = "No fue posible enviar el correo a Fosvoc.";
						facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje:", enviar);					
						faceContext.addMessage(null, facesMessage);
					}
					mensaje = "Inicio";
				}
				else 
				{
					mensaje = "No es posible atender la solicitud en este momento.";
					facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, null);
					faceContext.addMessage(null, facesMessage);					
					mensaje = "Inicio";
				}
				
		} catch (PersistenciaException e) {
			msgMail = e.getMensaje()+"";
			facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, msgMail, null);
			faceContext.addMessage(null, facesMessage);
			mensaje = "Sendmail";
		}        
		faceContext.getExternalContext().getFlash().setKeepMessages(true);
		return mensaje;	
	}

	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	public FacesContext getFaceContext() {
		return faceContext;
	}

	public void setFaceContext(FacesContext faceContext) {
		this.faceContext = faceContext;
	}

	public FacesMessage getFacesMessage() {
		return facesMessage;
	}

	public void setFacesMessage(FacesMessage facesMessage) {
		this.facesMessage = facesMessage;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getEmailremitente() {
		return emailremitente;
	}

	public void setEmailremitente(String emailremitente) {
		this.emailremitente = emailremitente;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getTextomensaje() {
		return textomensaje;
	}

	public void setTextomensaje(String textomensaje) {
		this.textomensaje = textomensaje;
	}

	public String getMsgMail() {
		return msgMail;
	}

	public void setMsgMail(String msgMail) {
		this.msgMail = msgMail;
	}
   
}
