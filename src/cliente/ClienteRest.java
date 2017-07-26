package cliente;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

import datatypes.DataAportante;
import datatypes.DataContrasenia;
import datatypes.DataListarAdjudicaciones;
import datatypes.DataListarSolicitudes;
import datatypes.DataLoginIn;
import datatypes.DataMensaje;
import datatypes.DataUsuario;
import datatypes.DataUsuarioLogin;
import datatypes.response.DataAportanteResponse;
import datatypes.response.DataListarAdjudicacionesResponse;
import datatypes.response.DataListarSolicitudesResponse;
import datatypes.response.DataUsuarioLoginResponse;
import datatypes.response.DataUsuarioResponse;
import excepciones.PersistenciaException;
import utilitarios.EnviarMail;
/**
 * @description: Cliente para consumir servicios rest.
 *               Se utiliza el patrón singleton para mantener una única
 *               instancia.
 */
public class ClienteRest {

	private static ClienteRest instancia = null;

	final static Logger LOG = Logger.getLogger(ClienteRest.class);

	private String urlRestService;//URL de la raiz del servicio ;
    private LectorProperties lector;
	final static String POST = "POST";
	final static String GET = "GET";
	final static String DELETE = "DELETE";

	private ClienteRest() {
		BasicConfigurator.configure();	
			lector = new LectorProperties();
			urlRestService = lector.getUrlWS();			
	}

	/**
	 * Devuelve una instancia única de ClienteRest para acceder al servicio.
	 * (Patrón singleton)
	 * 
	 * @return la instancia única de ClienteRest
	 */
	public static ClienteRest getInstancia() {
		if (instancia == null) {
			instancia = new ClienteRest();
		}
		return instancia;
	}

	/***************************************************** MÉTODOS PRIVADOS *********************************************************/
/*
	private String getResponseText(final InputStream inStream) {
		try {
			return new Scanner(inStream, "UTF-8").useDelimiter("\\A").next();
		} catch (final Exception e) {
			return "";
		}
	}*/
	/***************************************************** MÉTODOS PRIVADOS *********************************************************/
	public DataUsuarioLogin login(final DataLoginIn input) throws PersistenciaException {

		DataUsuarioLogin resu = null;
        Gson gson = new Gson();
	            String url = urlRestService+lector.getServicioLogin();
			final String output = Servicios.ejecutarServicioLogin(url, input, POST);
		
			if(output != null && !output.isEmpty())
			{
				DataUsuarioLoginResponse dres = gson.fromJson(output, DataUsuarioLoginResponse.class);
				DataMensaje dm = dres.getDm();
				if(dm != null)
				{
					boolean ok = dm.isOk();
					if(ok)
					resu = dres.getDu();
					else
						throw new PersistenciaException(dm.getMensaje());
				}			   
			}
			else
				throw new PersistenciaException("No se encuentra información con los datos ingresados");
	
		return resu;
	}

	public DataUsuario getUsuario(int idusuario)  throws PersistenciaException {
		DataUsuario resu = null;
		DataUsuarioResponse resource = null;
        Gson gson = new Gson();
		try {
            String url = urlRestService+lector.getServicioGetUsuario();
			final String output = Servicios.ejecutarServicioGetUsuario(url+idusuario, GET);
			if(output != null && !output.isEmpty())
			{
				resource = gson.fromJson(output, DataUsuarioResponse.class);
				if(resource != null)
				{
					DataMensaje dm = resource.getDatam();
					if(dm != null)
					{
						boolean ok = dm.isOk();
						if(ok)
						{
							resu = resource.getDatau();
						}
						else
							throw new PersistenciaException(dm.getMensaje());
					}
				}			
			}
			else
				throw new PersistenciaException("No se encuentra un usuario con la información ingresada.");
		} catch (PersistenciaException e) {
						throw new PersistenciaException(e.getMensaje());
		}		
		return resu;
	}
	public DataAportante getAportante(int idaportante)  throws PersistenciaException {
		DataAportante resu = null;
		DataAportanteResponse resource = null;
        Gson gson = new Gson();
		try {
            String url = urlRestService+lector.getServicioGetAportante();
			final String output = Servicios.ejecutarServicioGetAportante(url+idaportante, GET);
			if(output != null && !output.isEmpty())
			{
				resource = gson.fromJson(output, DataAportanteResponse.class);
				if(resource != null)
				{
					DataMensaje dm = resource.getDm();
					if(dm != null)
					{
						boolean ok = dm.isOk();
						if(ok)
						{
							resu = resource.getDa();
						}
						else
							throw new PersistenciaException(dm.getMensaje());
					}
				}			
			}
			else
				throw new PersistenciaException("No se encuentra un aportante con la información ingresada.");
		} catch (PersistenciaException e) {
						throw new PersistenciaException(e.getMensaje());
		}		
		return resu;
	}

	public String modificarContrasenia(DataContrasenia input) throws PersistenciaException{
		String resu = null;
        Gson gson = new Gson();		    
        String url = urlRestService+lector.getServicioModificarContrasenia();			
		    final String output = Servicios.ejecutarServicioModificarPass(url, input, POST);		   
			if(output != null && !output.isEmpty())
			{
				DataMensaje dm = gson.fromJson(output, DataMensaje.class);
				if(dm != null)
				{
						resu = dm.getMensaje();					
				}			
			}
			else
				throw new PersistenciaException("No se pudo procesar la petición");			
		return resu;
	}	
public void enviarMail(String asunto, String mensaje, String remitente, String mailremitente)
{
	EnviarMail.enviarmail(asunto, mensaje, remitente, mailremitente);
}
public List<DataListarSolicitudes> listarSolicitudesActivasDe(int cedula) throws PersistenciaException {
	DataListarSolicitudesResponse resource=null;
	Vector<DataListarSolicitudes> listaAux = new Vector<DataListarSolicitudes>();
	List<DataListarSolicitudes> lista = new LinkedList<DataListarSolicitudes>();
	 Gson gson=new Gson();
	  	try {	  		
			String url= urlRestService+lector.getServicioSolicitudesActivasDeAportante()+cedula;				
			final String output = Servicios.ejecutarServicioListarSolicitudes(url, GET);//sigo con el mismo servicio, ya que no hay que pasar parametros
			if(output != null && !output.isEmpty())
			{
				resource = gson.fromJson(output, DataListarSolicitudesResponse.class);					
				if(resource != null)
				{
					DataMensaje dm = resource.getDm();
					if(dm != null)
					{
						boolean ok = dm.isOk();
						if(ok)
						{								
							listaAux = resource.getDatos();
							for(DataListarSolicitudes dl : listaAux)
							{									        	
					        	lista.add(dl);					
							}
						}						
					}
				}	
			}
			else
				throw new PersistenciaException("No se encuentran solicitudes activas para este aportante.");		
		} 
		catch (PersistenciaException e) {
			throw new PersistenciaException(e.getMensaje());
		} 	
		return lista;
}
public List<DataListarAdjudicaciones> listarAdjudicacionesDe(int cedula) throws PersistenciaException {
	DataListarAdjudicacionesResponse resource=null;
	Vector<DataListarAdjudicaciones> listaAux = new Vector<DataListarAdjudicaciones>();
	List<DataListarAdjudicaciones> lista = new LinkedList<DataListarAdjudicaciones>();
	 Gson gson=new Gson();
	  	try {	  		
			String url= urlRestService+lector.getServicioAdjudicacionesDeAportante()+cedula;				
			final String output = Servicios.ejecutarServicioListarAdjudicaciones(url, GET);//sigo con el mismo servicio, ya que no hay que pasar parametros
			if(output != null && !output.isEmpty())
			{
				resource = gson.fromJson(output, DataListarAdjudicacionesResponse.class);					
				if(resource != null)
				{
					DataMensaje dm = resource.getDm();
					if(dm != null)
					{
						boolean ok = dm.isOk();
						if(ok)
						{								
							listaAux = resource.getDatos();
							for(DataListarAdjudicaciones dl : listaAux)
							{									        	
					        	lista.add(dl);					
							}
						}						
					}
				}	
			}
			else
				throw new PersistenciaException("No se encuentran adjudicaciones activas para este aportante.");		
		} 
		catch (PersistenciaException e) {
			throw new PersistenciaException(e.getMensaje());
		} 	
		return lista;
}
}
