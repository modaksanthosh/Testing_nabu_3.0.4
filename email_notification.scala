println("Hello World")
import java.util.{Properties}
import javax.mail.{Message, Session, Authenticator}
import javax.mail.internet.{InternetAddress,MimeMessage}


var from="mallem.santhosh@gmail.com";
var password="ohippvtbzbuzfcjr";
var sub="scala smtp mail sending";
var msg = "Database Name : ";
var mail_Body= "Test Message";

var props = new Properties();
    props.put("mail.smtp.host", "mailhost.modak.com");
    props.put("mail.smtp.socketFactory.port", "587");
    props.put("mail.smtp.socketFactory.class",
            "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.ssl.protocols","TLSv1.2");
val authenticator = new Authenticator() {
          override def getPasswordAuthentication = new
              PasswordAuthentication(from,password)
        }
val session = Session.getDefaultInstance(props, authenticator)
Try{
    var message = new MimeMessage(session);
        message.addRecipient(Message.RecipientType.TO,new InternetAddress("santhosh.mallem@modak.com"));
        message.setSubject(sub);
        message.setText(mail_Body);
        Transport.send(message);
        println("message sent successfully");
}
match{
    case Success(s) => {
        println("mail sent")
  }
    case Failure(f) => {
        println(f)
  }
}
