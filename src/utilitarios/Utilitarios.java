package utilitarios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilitarios {

	public static String getDiaDeLaSemana(String dia) {
		String d = "";
		if(dia.equals("L"))
			d = "Lunes";
		else if(dia.equals("M"))
			d = "Martes";
		else if(dia.equals("Mi"))
			d = "Miercoles";
		else if(dia.equals("J"))
			d = "Jueves";
		else if(dia.equals("V"))
			d = "Viernes";
		else if(dia.equals("S"))
			d = "Sabado";
		else if(dia.equals("D"))
			d = "Domingo";
		
		return d;
	}
	public static String setDiaDeLaSemana(String dia) {
		String d = "";
		if(dia.equals("Lunes"))
			d = "L";
		else if(dia.equals("Martes"))
			d = "M";
		else if(dia.equals("Miercoles"))
			d = "Mi";
		else if(dia.equals("Jueves"))
			d = "J";
		else if(dia.equals("Viernes"))
			d = "V";
		else if(dia.equals("Sabado"))
			d = "S";
		else if(dia.equals("Domingo"))
			d = "D";
		
		return d;
	}
	public static String getDestino(String destino) {
		String resu = "";
		if(destino.equals("PUNTA_DEL_ESTE"))
			resu = "PUNTA DEL ESTE";
		else if(destino.equals("MONTEVIDEO_CityTour"))
			resu = "MONTEVIDEO CityTour";
		else if(destino.equals("MONTEVIDEO_Caminatour"))
			resu = "MONTEVIDEO Caminatour";
		else if(destino.equals("COLONIA"))
			resu = "COLONIA";
		else if(destino.equals("MINAS"))
			resu = "MINAS";
		else if(destino.equals("BODEGA"))
			resu = "BODEGA";
		return resu;
	}
	
	public static String getIdioma(String idioma) {
		String resu = "";
		if(idioma.equals("INGLES"))
			resu = "Inglés";
		else if(idioma.equals("ESPANOL"))
			resu = "Español";
		else if(idioma.equals("FRANCES"))
			resu = "Francés";
		else if(idioma.equals("CHINO"))
			resu = "Chino";
		else if(idioma.equals("COREANO"))
			resu = "Coreano";
		else if(idioma.equals("PORTUGUES"))
			resu = "Portugués";
		return resu;
	}

	public static String getHora(int horanumero) {
		String resu = "";
	String hora = "";
	String ampm = "";
	String h = "";
	String m = "";
	hora = horanumero+"";
	if(horanumero < 1000)
	{
		h = " "+hora.substring(0,1);
		m = hora.substring(1,3);
		ampm = "AM";
	}
	else if(horanumero >= 1000)
	{
		h = hora.substring(0,2);
		m = hora.substring(2,4);
		if(horanumero<1200)
			ampm = "AM";
		else if(horanumero>=12)
			ampm = "PM";
	}
	resu = h+":"+m+" "+ampm;
	
		return resu;
	}
	public static int getHoras(int horanumero) {
		int resu = 0;
	String hora = "";	
	String h = "";
	String m = "";
	hora = horanumero+"";
	if(horanumero < 1000)
	{
		h = hora.substring(0,1);
		m = hora.substring(1,3);		
	}
	else if(horanumero >= 1000)
	{
		h = hora.substring(0,2);
		m = hora.substring(2,4);		
	}
	resu = Integer.parseInt(h);	
		return resu;
	}
	public static int getMinutos(int horanumero) {
		int resu = 0;
	String hora = "";	
	String h = "";
	String m = "";
	hora = horanumero+"";
	if(horanumero < 1000)
	{
		h = hora.substring(0,1);
		m = hora.substring(1,3);		
	}
	else if(horanumero >= 1000)
	{
		h = hora.substring(0,2);
		m = hora.substring(2,4);		
	}
	resu = Integer.parseInt(m);	
		return resu;
	}

	public static String setDestino(String destino) {
		String resu = "";
		if(destino.equals("PUNTA DEL ESTE"))
			resu = "PUNTA_DEL_ESTE";
		else if(destino.equals("MONTEVIDEO CityTour"))
			resu = "MONTEVIDEO_CityTour";
		else if(destino.equals("MONTEVIDEO Caminatour"))
			resu = "MONTEVIDEO_Caminatour";
		else if(destino.equals("COLONIA"))
			resu = "COLONIA";
		else if(destino.equals("MINAS"))
			resu = "MINAS";
		else if(destino.equals("BODEGA"))
			resu = "BODEGA";
		return resu;
	}
	public static String getFechaString(Calendar fecha)
	{
		String resu = "";
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		String m = "", d;
		if(mes == 0)
			m = "ENERO";
		else if( mes == 1)
			m = "FEBRE";		
		else if( mes == 2)
			m = "MARZO";
		else if( mes == 3)
			m = "ABRIL";
		else if( mes == 4)
			m = "MAYO.";
		else if( mes == 5)
			m = "JUNIO";
		else if( mes == 6)
			m = "JULIO";
		else if( mes == 7)
			m = "AGOST";
		else if( mes == 8)
			m = "SETIE";
		else if( mes == 9)
			m = "OCTUB";
		else if( mes == 10)
			m = "NOVIE";
		else if( mes == 11)
			m = "DICIE";
		if(dia < 10)
			d = "0"+dia;
		else
			d = dia+"";
		resu = d+"-"+m+"-"+anio;
		return resu;
	}
	public static Date getDate(String fechaS){ //formato "dd-MM-yyyy"
		Date resu = new Date();
	 String[]valores = fechaS.split("-");
	    int dia, mes, anio;
	    dia = Integer.parseInt(valores[0]);
	    mes = Integer.parseInt(valores[1]);
	    anio = Integer.parseInt(valores[2]);
	    resu.setYear(anio);
	    resu.setMonth(mes);
	    resu.setDate(dia);
	return resu;
	}
	public static String convertirFecha(String fecha) {// convierte de "12-ENERO-2014" a "dd-MM-yyyy" en numeros
		String resu = null;
		Calendar fe = getCalendar(fecha);
		resu = getStringParaHTML(fe);
		return resu;
	}
	private static Calendar getCalendar(String fe) {
		Calendar resu = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMMM-yyyy ");
		String[] partes = fe.split("-");
		String dia, mes, anio;
		dia = partes[0];
		mes = partes[1];
		anio = partes[2];
		int d = Integer.valueOf(dia);
		int m = 0;
		if (mes.equalsIgnoreCase("ENERO"))
			m = 0;
		else if (mes.equalsIgnoreCase("FEBRE"))
			m = 1;
		else if (mes.equalsIgnoreCase("MARZO"))
			m = 2;
		else if (mes.equalsIgnoreCase("ABRIL"))
			m = 3;
		else if (mes.equalsIgnoreCase("MAYO."))
			m = 4;
		else if (mes.equalsIgnoreCase("JUNIO"))
			m = 5;
		else if (mes.equalsIgnoreCase("JULIO"))
			m = 6;
		else if (mes.equalsIgnoreCase("AGOST"))
			m = 7;
		else if (mes.equalsIgnoreCase("SETIE"))
			m = 8;
		else if (mes.equalsIgnoreCase("OCTUB"))
			m = 9;
		else if (mes.equalsIgnoreCase("NOVIE"))
			m = 10;
		else if (mes.equalsIgnoreCase("DICIE"))
			m = 11;
		int a = Integer.valueOf(anio);
		resu.set(a, m, d);
		return resu;
	}

	private static String getFecha(Calendar fecha) {
		String resu = "";
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		String m = "", d;
		if (mes == 0)
			m = "ENERO";
		else if (mes == 1)
			m = "FEBRE";
		else if (mes == 2)
			m = "MARZO";
		else if (mes == 3)
			m = "ABRIL";
		else if (mes == 4)
			m = "MAYO.";
		else if (mes == 5)
			m = "JUNIO";
		else if (mes == 6)
			m = "JULIO";
		else if (mes == 7)
			m = "AGOST";
		else if (mes == 8)
			m = "SETIE";
		else if (mes == 9)
			m = "OCTUB";
		else if (mes == 10)
			m = "NOVIE";
		else if (mes == 11)
			m = "DICIE";
		if (dia < 10)
			d = "0" + dia;
		else
			d = dia + "";
		resu = d + "-" + m + "-" + anio;
		return resu;
	}
	private static String getStringParaHTML(Calendar fecha) {
		String resu = "";
		int anio = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH)+1;
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		String m = "", d;
	
		if (dia < 10)
			d = "0" + dia;
		else
			d = dia + "";
		if(mes < 10)
			m = "0"+mes;
		else
			m = mes + "";
		resu = d + "-" + m + "-" + anio;
		return resu;
	}

	public static String getFecha(java.util.Date fecha) {
		String resu = "";
		int anio = fecha.getYear();
		int mes = fecha.getMonth();
		int dia = fecha.getDate();
		String m = "", d;
		if (mes == 0)
			m = "ENERO";
		else if (mes == 1)
			m = "FEBRE";
		else if (mes == 2)
			m = "MARZO";
		else if (mes == 3)
			m = "ABRIL";
		else if (mes == 4)
			m = "MAYO.";
		else if (mes == 5)
			m = "JUNIO";
		else if (mes == 6)
			m = "JULIO";
		else if (mes == 7)
			m = "AGOST";
		else if (mes == 8)
			m = "SETIE";
		else if (mes == 9)
			m = "OCTUB";
		else if (mes == 10)
			m = "NOVIE";
		else if (mes == 11)
			m = "DICIE";
		if (dia < 10)
			d = "0" + dia;
		else
			d = dia + "";
		resu = d + "-" + m + "-" + (anio + 1900);
		return resu;
	}
}
