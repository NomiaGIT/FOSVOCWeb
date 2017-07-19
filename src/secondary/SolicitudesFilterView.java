package secondary;
/*
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

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.SelectEvent;

import cliente.ClienteRest;
import beans.TourBean;
import datatypes.DataListaTourS;
import datatypes.DatosTour;
import excepciones.PersistenciaException;
import excepciones.TourException;

@SuppressWarnings("serial")
@ManagedBean(name="tourDelDiaFilterView")
@ViewScoped
public class SolicitudesFilterView implements Serializable {
     
    private List<DataListaTourS> tours;
     
    private List<DataListaTourS> filteredTours;
    private List<DataListaTourS> toursAnteriores;
    private List<DataListaTourS> toursDeUnDia;
    private List<DataListaTourS> toursPosteriores;
    private Date date;
    private int cantToursDelDia;
    private ArrayList<DatosTour> datosTourDelDia;
     
    @ManagedProperty("#{TourService}")
    private TourService service;
 
    @PostConstruct
    public void init() {
   
    	 ClienteRest cliente = ClienteRest.getInstancia();
		 try {
			 Calendar fecha = Calendar.getInstance();
			tours = cliente.listarToursDelDia(fecha);
			toursAnteriores = cliente.listarToursAnterioresA(fecha);
			toursPosteriores = cliente.listarToursPosterioresA(fecha);
		} catch (PersistenciaException e) {
			
			e.printStackTrace();
		} catch (TourException e) {
			
			e.printStackTrace();
		}
		 
     }
     
    public boolean filterByName(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
        String val = value.toString();
        return val.startsWith(filterText);
    }
   
     public List<String> getDestinos()
     {
    	 List<String> tipos = new ArrayList<String>();
    	 tipos.add("PUNTA DEL ESTE");
    	 tipos.add("MONTEVIDEO CityTour");
    	 tipos.add("MONTEVIDEO Caminatour");
    	 tipos.add("COLONIA");
    	 tipos.add("MINAS");
    	 tipos.add("BODEGA"); 		
    	 return tipos;
     }
     public List<String> getDias(){
    	 List<String> tipos = new ArrayList<String>();
    	 tipos.add("Lunes");
    	 tipos.add("Martes");
    	 tipos.add("Miercoles");
    	 tipos.add("Jueves");
    	 tipos.add("Viernes");
    	 tipos.add("Sabado");
    	 tipos.add("Domingo");
    	 
    	 return tipos;
     }
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	 
    public void setService(TourService service) {
        this.service = service;
    }

	public List<DataListaTourS> getTours() {
		try {
		ClienteRest cliente = ClienteRest.getInstancia();
		Calendar fecha = Calendar.getInstance();
		
			tours = cliente.listarToursDelDia(fecha);
		} catch (PersistenciaException e) {
			
			e.printStackTrace();
		} catch (TourException e) {
			
			e.printStackTrace();
		}
		return tours;
	}

	public void setTours(List<DataListaTourS> tours) {
		this.tours = tours;
	}

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
	}
}*/