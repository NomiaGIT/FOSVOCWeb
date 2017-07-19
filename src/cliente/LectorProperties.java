package cliente;

import javax.faces.context.FacesContext;

public class LectorProperties {
	private String url;
	private String urlWS;
	private String servicioLogin;
	private String servicioGetUsuario;
	private String servicioGetAportante;
	private String servicioModificarContrasenia;

	public LectorProperties() {
		FacesContext context = FacesContext.getCurrentInstance();

		url = (String) context.getExternalContext().getInitParameter("url");
		urlWS = (String) context.getExternalContext().getInitParameter("urlWS");
		servicioLogin = (String) context.getExternalContext().getInitParameter(
				"servicioLogin");
		servicioGetUsuario = (String) context.getExternalContext().getInitParameter(
				"servicioGetUsuario");
		servicioGetAportante = (String) context.getExternalContext().getInitParameter(
				"servicioGetAportante");
		servicioModificarContrasenia = (String) context.getExternalContext().getInitParameter(
				"servicioModificarContrasenia");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlWS() {
		return urlWS;
	}

	public void setUrlWS(String urlWS) {
		this.urlWS = urlWS;
	}

	public String getServicioLogin() {
		return servicioLogin;
	}

	public void setServicioLogin(String servicioLogin) {
		this.servicioLogin = servicioLogin;
	}

	public String getServicioGetUsuario() {
		return servicioGetUsuario;
	}

	public String getServicioGetAportante() {
		return servicioGetAportante;
	}

	public String getServicioModificarContrasenia() {
		return servicioModificarContrasenia;
	}


}
