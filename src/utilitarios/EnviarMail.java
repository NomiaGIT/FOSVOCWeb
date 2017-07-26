package utilitarios;

import java.util.Properties;

import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarMail {

	public static boolean enviarmail(String asunto, String mensaje, String remitente, String mailremitente) {
		boolean resu = false;
		try {
			//datos de la cuenta
			FacesContext context = FacesContext.getCurrentInstance();
			String cuentaDesde = (String) context.getExternalContext().getInitParameter(
					"cuentaEmail");
			String passwordDesde = (String) context.getExternalContext().getInitParameter(
					"passwordEmail");
			String cuentaEmailDestino = (String) context.getExternalContext().getInitParameter(
					"cuentaEmailDestino");
			// Propiedades de la conexión
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.user", cuentaDesde);
			props.setProperty("mail.smtp.auth", "true");

			// Prepara la sesion
			Session session = Session.getDefaultInstance(props);

			// Construye el mensaje
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailremitente));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(cuentaEmailDestino));
			message.setSubject("Mensaje desde la web." + asunto);			
			message.setText(mensaje+"\n Firmado por "+remitente);
			// Lo enviamos.
			Transport t = session.getTransport("smtp");
			t.connect(cuentaDesde, passwordDesde);
			t.sendMessage(message, message.getAllRecipients());

			// Cierre.
			t.close();
			resu = true;
		} catch (Exception e) {
			e.printStackTrace();
			resu = false;
		}
		return resu;
	}

}