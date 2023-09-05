import javax.mail._
import javax.mail.internet._

val host = "smtp.gmail.com"
val port = "587" // Port for TLS
val username = "mallem.santhosh@gmail.com"
val password = "ohippvtbzbuzfcjr"

val from = new InternetAddress(username)
val to = new InternetAddress("ramsai350mg@gmail.com")

    // Email properties
val props = new java.util.Properties()
props.put("mail.smtp.host", host)
props.put("mail.smtp.port", port)
props.put("mail.smtp.auth", "true")
props.put("mail.smtp.starttls.enable", "true")

    // Create a session with authentication
val session = Session.getInstance(props,
      new javax.mail.Authenticator() {
        override protected def getPasswordAuthentication: PasswordAuthentication = {
          new PasswordAuthentication(username, password)
        }
      })

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
