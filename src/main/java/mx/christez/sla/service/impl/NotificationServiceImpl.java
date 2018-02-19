package mx.christez.sla.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.christez.sla.configuration.EmailConfiguration;
import mx.christez.sla.entity.AppUser;
import mx.christez.sla.entity.ExceptionRecords;
import mx.christez.sla.exception.InvalidUserException;
import mx.christez.sla.repository.ExceptionRecordsRepository;
import mx.christez.sla.repository.UserRepository;
import mx.christez.sla.security.Encrypter;
import mx.christez.sla.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
	@Autowired
	private ExceptionRecordsRepository exceptionRecordsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Encrypter encrypter;
	
	@Autowired
	private EmailConfiguration emailConfiguration;
	
	@Override
	public void notifyActivation(AppUser user) {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", emailConfiguration.getNotificationHost());
			props.put("mail.smtp.port", emailConfiguration.getNotificationPort());
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(emailConfiguration.getNotificationUsername(), emailConfiguration.getNotificationPassword());
				}
			});
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailConfiguration.getNotificationFrom()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
			message.setSubject("Activación de cuenta");
			message.setContent("<div style=\"height: 310px; width: 100%; background-color: #f9f9f9; color: #5bc0de; padding-top: 10px; margin-top: 10px;\"><center><img src=\"https://i.imgur.com/dXJu29l.png\"><h3>Para activar tu cuenta haz click</h3><h1><a href=\"" + emailConfiguration.getActivateUrl() + "?code=" + URLEncoder.encode(encrypter.encrypt(user.getUsername() + ":" + user.getEmail()), "UTF-8") + "\">AQU&Iacute;</a></h1><h5>Gracias por utilizar nuestra aplicaci&oacute;n</h5></center></div>", "text/html; charset=utf-8");

			Transport.send(message);
		}catch(AddressException ae) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + user.getEmail(), "AddressException: " + ae.getMessage(), "activateAccountAdvice"));
		}catch(MessagingException me) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + user.getEmail(), "MessagingException: " + me.getMessage(), "activateAccountAdvice"));
		}catch (InvalidKeyException ike) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + user.getEmail(), "InvalidKeyException: " + ike.getMessage(), "activateAccountAdvice"));
		}catch (UnsupportedEncodingException uee) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + user.getEmail(), "UnsupportedEncodingException: " + uee.getMessage(), "activateAccountAdvice"));
		}catch (NoSuchAlgorithmException nsae) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + user.getEmail(), "NoSuchAlgorithmException: " + nsae.getMessage(), "activateAccountAdvice"));
		}catch (NoSuchPaddingException nspe) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + user.getEmail(), "NoSuchPaddingException: " + nspe.getMessage(), "activateAccountAdvice"));
		}catch (InvalidAlgorithmParameterException iape) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + user.getEmail(), "InvalidAlgorithmParameterException: " + iape.getMessage(), "activateAccountAdvice"));
		}catch (IllegalBlockSizeException ibse) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + user.getEmail(), "IllegalBlockSizeException: " + ibse.getMessage(), "activateAccountAdvice"));
		}catch (BadPaddingException bpe) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + user.getEmail(), "BadPaddingException: " + bpe.getMessage(), "activateAccountAdvice"));
		}
	}

	@Override
	public void recoverPassword(AppUser appUser) throws InvalidUserException {
		AppUser originalAppUser = userRepository.findByUsername(appUser.getUsername());
		
		if(originalAppUser == null)
			throw new InvalidUserException();
		
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", emailConfiguration.getNotificationHost());
			props.put("mail.smtp.port", emailConfiguration.getNotificationPort());
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(emailConfiguration.getNotificationUsername(), emailConfiguration.getNotificationPassword());
				}
			});
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailConfiguration.getNotificationFrom()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(originalAppUser.getEmail()));
			message.setSubject("Restablecer contraseña");
			message.setContent("<div style=\"height: 310px; width: 100%; background-color: #f9f9f9; color: #5bc0de; padding-top: 10px; margin-top: 10px;\"><center><img src=\"https://i.imgur.com/dXJu29l.png\"><h3>Para restablecer tu contrase&ntilde;a haz click</h3><h1><a href=\"" + emailConfiguration.getRestoreUrl() + "?code=" + URLEncoder.encode(encrypter.encrypt(originalAppUser.getUsername() + ":" + System.currentTimeMillis()), "UTF-8") + "\">AQU&Iacute;</a></h1><h5>Gracias por utilizar nuestra aplicaci&oacute;n</h5></center></div>", "text/html; charset=utf-8");

			Transport.send(message);
		}catch(AddressException ae) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + originalAppUser.getEmail(), "AddressException: " + ae.getMessage(), "activateAccountAdvice"));
		}catch(MessagingException me) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + originalAppUser.getEmail(), "MessagingException: " + me.getMessage(), "activateAccountAdvice"));
		}catch (InvalidKeyException ike) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + originalAppUser.getEmail(), "InvalidKeyException: " + ike.getMessage(), "activateAccountAdvice"));
		}catch (UnsupportedEncodingException uee) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + originalAppUser.getEmail(), "UnsupportedEncodingException: " + uee.getMessage(), "activateAccountAdvice"));
		}catch (NoSuchAlgorithmException nsae) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + originalAppUser.getEmail(), "NoSuchAlgorithmException: " + nsae.getMessage(), "activateAccountAdvice"));
		}catch (NoSuchPaddingException nspe) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + originalAppUser.getEmail(), "NoSuchPaddingException: " + nspe.getMessage(), "activateAccountAdvice"));
		}catch (InvalidAlgorithmParameterException iape) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + originalAppUser.getEmail(), "InvalidAlgorithmParameterException: " + iape.getMessage(), "activateAccountAdvice"));
		}catch (IllegalBlockSizeException ibse) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + originalAppUser.getEmail(), "IllegalBlockSizeException: " + ibse.getMessage(), "activateAccountAdvice"));
		}catch (BadPaddingException bpe) {
			exceptionRecordsRepository.save(new ExceptionRecords("Cuenta de correo: " + originalAppUser.getEmail(), "BadPaddingException: " + bpe.getMessage(), "activateAccountAdvice"));
		}
	}
	
}
