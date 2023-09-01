import java.util.{Calendar, Properties}
import javax.mail.{Message, Session}
import javax.mail.internet.{InternetAddress, MimeBodyPart, MimeMessage, MimeMultipart}


 var Email_host:String = "smtp.gmail.com"
  var Email_port :String= "25"
  var Email_username :String= "mallem.santhosh@gmail.com"
  var Email_password :String= "ohippvtbzbuzfcjr"
  var Email_recipient:String="ramsai350mg@gmail.com,mallem.santhosh@gmail.com,santhosh.mallem@modak.com"
  var Subject:String ="Testing the Message Functionality"
  var Message_Body:String ="Hello Hai This is Testing Related Message"

// props.put("mail.smtp.auth", "true");
//     props.put("mail.smtp.starttls.enable", "true"); 587
//     props.put("mail.smtp.host", "smtp.gmail.com");
//     props.put("mail.smtp.port", "465");
//     props.put("mail.smtp.ssl.protocols", "TLSv1.2");


val properties = new Properties()
    properties.put("mail.smtp.port", Email_port)
    properties.put("mail.smtp.auth", "true")
    properties.put("mail.smtp.host", "smtp.gmail.com")
    properties.put("mail.smtp.ssl.enable", "false")
    properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
      properties.put("mail.smtp.starttls.enable", "true")
      // properties.put("mail.smtp.ssl.trust", Email_host)
      

 val session = Session.getDefaultInstance(properties)
 val message = new MimeMessage(session)
 val recipientList:List[String] = Email_recipient.split(",").toList
    recipientList.foreach { recipient =>
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient))
    }

message.setSubject(Subject)

val msg =Message_Body

val MessagePart = new MimeMultipart()
      val BodyPartText = new MimeBodyPart()
            BodyPartText.setText(msg,"utf-8","html")
      MessagePart.addBodyPart(BodyPartText)
      message.setContent(MessagePart)

val transport = session.getTransport("smtp")
transport.connect(Email_host, Email_username, Email_password)
transport.sendMessage(message, message.getAllRecipients)



