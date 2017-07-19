package utilitarios;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * Ejemplo de envio de correo simple con JavaMail
 * 
 * @author Chuidiang
 * 
 */
public class EnviarMail {
	/**
	 * main de prueba
	 * 
	 * @param args
	 *            Se ignoran.
	 */

	public static void enviarmail(String asunto, String mensaje, String remitente, String mailremitente) {
		try {
			// Propiedades de la conexión
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587");
			//props.setProperty("mail.smtp.user", "info@fosvoc.org");
			props.setProperty("mail.smtp.user", "soledad@nomia.com.uy");
			props.setProperty("mail.smtp.auth", "true");

			// Preparamos la sesion
			Session session = Session.getDefaultInstance(props);

			// Construimos el mensaje
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailremitente));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("soledad@nomia.com.uy"));
			message.setSubject("Mensaje desde la web." + asunto);			
			message.setText(mensaje+"\n Firmado por "+remitente);
			// Lo enviamos.
			Transport t = session.getTransport("smtp");
			t.connect("soledad@i3.com.uy", "sole.fosvoc");
			t.sendMessage(message, message.getAllRecipients());

			// Cierre.
			t.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}