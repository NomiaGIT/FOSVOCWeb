package cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import datatypes.DataContrasenia;
import datatypes.DataLoginIn;
import excepciones.PersistenciaException;



public class Servicios {

	final static Logger LOG = Logger.getLogger(ClienteRest.class);

	/***************************************************** MÉTODOS PRIVADOS *********************************************************/

	private static String getResponseText(final InputStream inStream) {
		try {
			return new Scanner(inStream, "UTF-8").useDelimiter("\\A").next();
		} catch (final Exception e) {
			return "";
		}
	}

	/**
	 * Ejecuta una consulta a un servicio rest y devuelve la respuesta.
	 * 
	 * @param strUrl
	 *            la url a consultar mediante servicio rest.
	 * @return un string con la respuesta obtenida de la consulta rest.
	 * @throws IOException
	 *             si la url es incorrecta u otro error de entrada/salida.
	 * @throws Exception
	 *             en caso que la url sea incorrecta, no esté disponible el
	 *             servicio u otro error en tiempo de ejecución.
	 */
	public static String ejecutarServicioLogin(final String strUrl,
			final DataLoginIn param, final String metodo)
			throws PersistenciaException {
		HttpURLConnection conn = null;
		try {
			URL url;
			url = new URL(strUrl);
			final ObjectMapper mapper = new ObjectMapper();
			String output = null;
			conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod(metodo);
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			Gson gson = new Gson();
			if (param != null) {
				String parametro = gson.toJson(param);
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setDoOutput(true);
				final DataOutputStream wr = new DataOutputStream(
						conn.getOutputStream());
				mapper.writeValue(wr, parametro);
				
				wr.flush();
				wr.close();
				output = getResponseText(conn.getInputStream());// ESTO OBTIENE
																// EL OBJETO
																// DATALOGIN DE
																// RESPUESTA A
																// LA CONSULTA
																// AL WS

			}

			if (conn.getResponseCode() != 200) {
				if (conn.getResponseCode() == 204) {
					final PersistenciaException ex = new PersistenciaException(
							"ERROR "
									+ conn.getResponseCode()
									+ "");
					throw ex;
				} else {
					final PersistenciaException ex = new PersistenciaException(
							"ERROR : HTTP código de error : "
									+ conn.getResponseCode());
					// final String jsonError =
					// getResponseText(conn.getErrorStream());
					throw ex;
				}
			}
			return output;
		} catch (final IOException ex) {
			LOG.error(ex);
			throw new PersistenciaException(
					"Failed : IOException al consumir el WS");
		}
	}

	public static String ejecutarServicioGetUsuario(final String strUrl,
			final String metodo) throws PersistenciaException {
		HttpURLConnection conn = null;
		try {
			URL url;
			url = new URL(strUrl);
			String output = null;
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(metodo);
			conn.setRequestProperty("Content-Type", "application/json");
			output = getResponseText(conn.getInputStream());// ESTO OBTIENE EL
															// OBJETO
															// DATAUSUARIO DE
															// RESPUESTA A LA
															// CONSULTA AL WS

			if (conn.getResponseCode() != 200) {
				final PersistenciaException ex = new PersistenciaException(
						"ERROR : HTTP código de error : "
								+ conn.getResponseCode());
				// final String jsonError =
				// getResponseText(conn.getErrorStream());
				throw ex;
			}

			return output;
		} catch (final IOException ex) {
			LOG.error(ex);
			throw new PersistenciaException(
					"Failed : IOException al consumir el WS " + ex.getMessage());
		}
	}

	public static String ejecutarServicioGetAportante(final String strUrl,
			final String metodo) throws PersistenciaException {
		HttpURLConnection conn = null;
		try {
			URL url;
			url = new URL(strUrl);
			String output = null;
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(metodo);
			conn.setRequestProperty("Content-Type", "application/json");
			output = getResponseText(conn.getInputStream());// ESTO OBTIENE EL
															// OBJETO
															// DATAUSUARIO DE
															// RESPUESTA A LA
															// CONSULTA AL WS

			if (conn.getResponseCode() != 200) {
				final PersistenciaException ex = new PersistenciaException(
						"ERROR : HTTP código de error : "
								+ conn.getResponseCode());
				throw ex;
			}
			return output;
		} catch (final IOException ex) {
			LOG.error(ex);
			throw new PersistenciaException(
					"Failed : IOException al consumir el WS " + ex.getMessage());
		}
	}

	public static String ejecutarServicioModificarPass(final String strUrl,
			final DataContrasenia param, final String metodo)
			throws PersistenciaException {
		HttpURLConnection conn = null;
		try {
			URL url;
			url = new URL(strUrl);
			final ObjectMapper mapper = new ObjectMapper();
			String output = null;
			conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod(metodo);
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			Gson gson = new Gson();

			if (param != null) {
				String parametro = gson.toJson(param);

				conn.setRequestProperty("Content-Type", "application/json");
				conn.setDoOutput(true);
				final DataOutputStream wr = new DataOutputStream(
						conn.getOutputStream());

				mapper.writeValue(wr, parametro);
				wr.flush();
				wr.close();
				output = getResponseText(conn.getInputStream());
			}

			if (conn.getResponseCode() != 200) {
				final PersistenciaException ex = new PersistenciaException(
						"ERROR : HTTP código de error : "
								+ conn.getResponseCode());
				// final String jsonError =
				// getResponseText(conn.getErrorStream());
				throw ex;
			}
			return output;
		} catch (final IOException ex) {
			System.out.println(ex.getMessage());
			LOG.error(ex);
			throw new PersistenciaException(
					"Failed : IOException al consumir el WS");
		}
	}
	public static String ejecutarServicioListarSolicitudes(final String strUrl,
			final String metodo) throws PersistenciaException {
		HttpURLConnection conn = null;
		try {
			URL url;
			url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(metodo);
			conn.setRequestProperty("Content-Type", "application/json");
			if (conn.getResponseCode() != 200) {
				final Exception ex = new Exception(
						"Failed : HTTP error code : " + conn.getResponseCode());
				throw new PersistenciaException(ex.getMessage());
			}

			final String output = getResponseText(conn.getInputStream());// ESTO OBTIENE EL OBJETO
																			// LIST DE RESPUESTA A LA
																			// CONSULTA AL WS
			return output;
		} catch (final IOException ex) {System.out.println(ex.getMessage());
			LOG.error(ex);
			throw new PersistenciaException(
					"Failed : IOException al consumir el WS");
		}
	}
	public static String ejecutarServicioListarAdjudicaciones(final String strUrl,
			final String metodo) throws PersistenciaException {
		HttpURLConnection conn = null;
		try {
			URL url;
			url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(metodo);
			conn.setRequestProperty("Content-Type", "application/json");
			if (conn.getResponseCode() != 200) {
				final Exception ex = new Exception(
						"Failed : HTTP error code : " + conn.getResponseCode());
				throw new PersistenciaException(ex.getMessage());
			}

			final String output = getResponseText(conn.getInputStream());// ESTO OBTIENE EL OBJETO
																			// LIST DE RESPUESTA A LA
																			// CONSULTA AL WS
			return output;
		} catch (final IOException ex) {System.out.println(ex.getMessage());
			LOG.error(ex);
			throw new PersistenciaException(
					"Failed : IOException al consumir el WS");
		}
	}
	
}
