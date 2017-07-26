package secondary;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.CellEditEvent;

import cliente.ClienteRest;
import datatypes.DataListarAdjudicaciones;
import datatypes.DataListarSolicitudes;
import excepciones.PersistenciaException;

@SuppressWarnings("serial")
@ManagedBean(name = "solicitudesFilterView")
@ViewScoped
public class SolicitudesFilterView implements Serializable {
	private List<DataListarSolicitudes> solicitudes;
	private List<DataListarSolicitudes> solicitudesActivasDeAportante;
	private List<DataListarSolicitudes> filteredSolicitudes;
	private int cantSolicitudesActivasDe;
	private int cantAdjudicacionesDe;
	private List<DataListarAdjudicaciones> adjudicaciones;
	private List<DataListarAdjudicaciones> adjudicacionesActivasDeAportante;
	private List<DataListarAdjudicaciones> filteredAdjudicaciones;

	@ManagedProperty("#{SolicitudService}")
	private SolicitudService service;

	@PostConstruct
	public void init() {
		ClienteRest cliente = ClienteRest.getInstancia();
		try {
			int cedula = (Integer) ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession().getAttribute("idUsuario");
			solicitudesActivasDeAportante = cliente.listarSolicitudesActivasDe(cedula);
			cantSolicitudesActivasDe = solicitudesActivasDeAportante.size();
						
			adjudicacionesActivasDeAportante = cliente.listarAdjudicacionesDe(cedula);
			cantAdjudicacionesDe = adjudicacionesActivasDeAportante.size();
			
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}
	}

	public boolean filterByName(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim();
		if (filterText == null || filterText.equals("")) {
			return true;
		}

		if (value == null) {
			return false;
		}
		String val = value.toString();
		return val.startsWith(filterText);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void setService(SolicitudService service) {
		this.service = service;
	}

	public List<DataListarSolicitudes> getSolicitudesActivasDeAportante() {
		/*try {
			ClienteRest cliente = ClienteRest.getInstancia();
			faceContext = FacesContext.getCurrentInstance();
			httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
			int cedula = (Integer) httpServletRequest.getSession().getAttribute("idUsuario");
			solicitudesActivasDeAportante = cliente.listarSolicitudesActivasDe(cedula);
			cantSolicitudesActivasDe = solicitudesActivasDeAportante.size();
		} catch (PersistenciaException e) {

			e.printStackTrace();
		}*/
		return solicitudesActivasDeAportante;
	}

	public void setSolicitudesActivasDeAportante(List<DataListarSolicitudes> sol) {
		this.solicitudesActivasDeAportante = sol;
	}
/*
	public List<DataListaTourS> getFilteredTours() {
		return filteredTours;
	}

	public void setFilteredTours(List<DataListaTourS> filteredTours) {
		this.filteredTours = filteredTours;
	}

	public List<DataListaTourS> getToursAnteriores() {
		return toursAnteriores;
	}

	public void setToursAnteriores(List<DataListaTourS> toursAnteriores) {
		this.toursAnteriores = toursAnteriores;
	}

	public List<DataListaTourS> getToursDeUnDia() {
		try
		{
		TourBean tb = new TourBean();
		Calendar fecha = tb.getFecha();
		 ClienteRest cliente = ClienteRest.getInstancia();
		if(fecha != null)
			toursDeUnDia = cliente.listarToursDeUnDia(fecha);
		} catch(PersistenciaException e)
		{
			
		}
		catch(TourException e)
		{
			
		}
		return toursDeUnDia;
	}

	public void setToursDeUnDia(List<DataListaTourS> toursDeUnDia) {
		this.toursDeUnDia = toursDeUnDia;
	}

	public List<DataListaTourS> getToursPosteriores() {
		try {
			ClienteRest cliente = ClienteRest.getInstancia();
			Calendar fecha = Calendar.getInstance();			
				toursPosteriores = cliente.listarToursPosterioresA(fecha);
			} catch (PersistenciaException e) {
				
				e.printStackTrace();
			} catch (TourException e) {
				
				e.printStackTrace();
			}
		return toursPosteriores;
	}

	public void setToursPosteriores(List<DataListaTourS> toursPosteriores) {
		this.toursPosteriores = toursPosteriores;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	//filterByDate
	 public boolean filterByDate(Object value, Object filter, Locale locale) {
		   String filterText = (filter == null) ? null : filter.toString().trim();
	        if(filterText == null||filterText.equals("")) {
	            return true;
	        }
	         
	        if(value == null) {
	            return false;
	        }
	         
	        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
	    }
	 public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	    }

	public int getCantToursDelDia() {
		cantToursDelDia = tours.size();
		return cantToursDelDia;
	}

	public void setCantToursDelDia(int cantToursDelDia) {
		this.cantToursDelDia = cantToursDelDia;
	}

	public ArrayList<DatosTour> getDatosTourDelDia() {
		datosTourDelDia = new ArrayList<DatosTour>();
		int cantPdelE = 0, cantCity = 0, cantColonia = 0, cantBodega = 0, cantMinas = 0, cantCamina = 0;
		for(DataListaTourS d : tours)
		{
			String destino = d.getDestino();
			if(destino.equals("PUNTA DEL ESTE"))
					cantPdelE++;
			else if(destino.equals("MONTEVIDEO CityTour"))
				cantCity++;
			else if(destino.equals("COLONIA"))
				cantColonia++;
			else if(destino.equals("BODEGA"))
				cantBodega++;
			else if(destino.equals("MINAS"))
				cantMinas++;
			else if(destino.equals("MONTEVIDEO Caminatour"))
				cantCamina++;			 
		}
		//if(cantPdelE>0)
			datosTourDelDia.add(new DatosTour("PUNTA DEL ESTE", cantPdelE));
		//else if(cantCity>0)
			datosTourDelDia.add(new DatosTour("MONTEVIDEO CityTour", cantCity));
		//else if(cantCamina>0)
			datosTourDelDia.add(new DatosTour("MONTEVIDEO Caminatour", cantCamina));
		//else if(cantColonia>0)
			datosTourDelDia.add(new DatosTour("COLONIA", cantColonia));
		//else if(cantBodega>0)
			datosTourDelDia.add(new DatosTour("BODEGA", cantBodega));
		//else if(cantMinas>0)
			datosTourDelDia.add(new DatosTour("MINAS", cantMinas));
		return datosTourDelDia;
	}

	public void setDatosTourDelDia(ArrayList<DatosTour> datosTourDelDia) {
		this.datosTourDelDia = datosTourDelDia;
	}*/

	public List<DataListarSolicitudes> getFilteredSolicitudes() {
		return filteredSolicitudes;
	}

	public void setFilteredSolicitudes(List<DataListarSolicitudes> filteredSolicitudes) {
		this.filteredSolicitudes = filteredSolicitudes;
	}

	public int getCantSolicitudesActivasDe() {
		return cantSolicitudesActivasDe;
	}

	public void setCantSolicitudesActivasDe(int cantSolicitudesActivasDe) {
		this.cantSolicitudesActivasDe = cantSolicitudesActivasDe;
	}

	public List<DataListarSolicitudes> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<DataListarSolicitudes> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public int getCantAdjudicacionesDe() {
		return cantAdjudicacionesDe;
	}

	public void setCantAdjudicacionesDe(int cantAdjudicacionesDe) {
		this.cantAdjudicacionesDe = cantAdjudicacionesDe;
	}

	public List<DataListarAdjudicaciones> getAdjudicaciones() {
		return adjudicaciones;
	}

	public void setAdjudicaciones(List<DataListarAdjudicaciones> adjudicaciones) {
		this.adjudicaciones = adjudicaciones;
	}

	public List<DataListarAdjudicaciones> getAdjudicacionesActivasDeAportante() {
		return adjudicacionesActivasDeAportante;
	}

	public void setAdjudicacionesActivasDeAportante(List<DataListarAdjudicaciones> adjudicacionesActivasDeAportante) {
		this.adjudicacionesActivasDeAportante = adjudicacionesActivasDeAportante;
	}

	public List<DataListarAdjudicaciones> getFilteredAdjudicaciones() {
		return filteredAdjudicaciones;
	}

	public void setFilteredAdjudicaciones(List<DataListarAdjudicaciones> filteredAdjudicaciones) {
		this.filteredAdjudicaciones = filteredAdjudicaciones;
	}
}