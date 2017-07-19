package utilitarios;

import java.io.Serializable;

public class Telefono  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String numero;
	private String tipo;
	/**
	 * @param id
	 * @param numero
	 * @param tipo
	 */
	public Telefono(int id, String numero, String tipo) {
		this.id = id;
		this.numero = numero;
		this.tipo = tipo;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
