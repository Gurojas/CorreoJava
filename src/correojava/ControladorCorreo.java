/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correojava;

import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Usuario
 */
public class ControladorCorreo {
    
    
    
    public ControladorCorreo(){
        
    }
    
    public boolean envioCorreo(Correo correo){
        try{
            Properties p = new Properties();
            p.put("mail.smtp.host","smtp.gmail.com");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.port", "587");
            p.put("mail.smtp.user", correo.getUsuarioCorreo());
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            
            Session session = Session.getDefaultInstance(p,null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(correo.getMensaje());
            
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);
            
            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(correo.getUsuarioCorreo()));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correo.getDestino()));
            mensaje.setSubject(correo.getAsunto());
            mensaje.setContent(m);
            
            Transport t = session.getTransport("smtp");
            t.connect(correo.getUsuarioCorreo(), correo.getPassword());
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }
    
}
