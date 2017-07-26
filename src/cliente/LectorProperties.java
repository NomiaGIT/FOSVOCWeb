package cliente;

import javax.faces.context.FacesContext;

public class LectorProperties {
	private String url;
	private String urlWS;
	private String servicioLogin;
	private String servicioGetUsuario;
	private String servicioGetAportante;
	private String servicioModificarContrasenia;
	private String servicioSolicitudesActivasDeAportante;
	private String servicioSolicitudesDeAportante;
	private String servicioListarSolicitudes;
	private String servicioGetSolicitud;
	private String servicioAdjudicacionesDeAportante;
	private String servicioListarAdjudicaciones;
	private String servicioGetAdjudicacion;

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
		servicioSolicitudesActivasDeAportante = (String) context.getExternalContext().getInitParameter("servicioSolicitudesActivasDeAportante");
		servicioSolicitudesDeAportante = (String) context.getExternalContext().getInitParameter("servicioSolicitudesDeAportante");
		servicioListarSolicitudes = (String) context.getExternalContext().getInitParameter("servicioListarSolicitudes");
		servicioGetSolicitud = (String) context.getExternalContext().getInitParameter("servicioGetSolicitud");
		servicioGetAdjudicacion = (String) context.getExternalContext().getInitParameter("servicioGetAdjudicacion");
		servicioListarAdjudicaciones = (String) context.getExternalContext().getInitParameter("servicioListarAdjudicaciones");
		servicioAdjudicacionesDeAportante = (String) context.getExternalContext().getInitParameter("servicioAdjudicacionesDeAportante");
		
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

	public String getServicioGetUsuario() {
		return servicioGetUsuario;
	}

	public String getServicioGetAportante() {
		return servicioGetAportante;
	}

	public String getServicioModificarContrasenia() {
		return servicioModificarContrasenia;
	}

	public String getServicioSolicitudesActivasDeAportante() {
		return servicioSolicitudesActivasDeAportante;
	}

	public String getServicioSolicitudesDeAportante() {
		return servicioSolicitudesDeAportante;
	}

	public String getServicioListarSolicitudes() {
		return servicioListarSolicitudes;
	}

	public void setServicioListarSolicitudes(String servicioListarSolicitudes) {
		this.servicioListarSolicitudes = servicioListarSolicitudes;
	}

	public String getServicioGetSolicitud() {
		return servicioGetSolicitud;
	}

	public String getServicioAdjudicacionesDeAportante() {
		return servicioAdjudicacionesDeAportante;
	}

	public String getServicioListarAdjudicaciones() {
		return servicioListarAdjudicaciones;
	}

	public String getServicioGetAdjudicacion() {
		return servicioGetAdjudicacion;
	}



}
