import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText

def Email_notification(from_email,to_email,subject,message_body,password):
    
    # Create the MIME object
    msg = MIMEMultipart()
    msg['From'] = from_email
    msg['To'] = to_email
    msg['Subject'] = subject
    msg.attach(MIMEText(message_body, 'plain'))

    # Connect to the SMTP server
    smtp_server = "smtp.gmail.com"  # For Gmail
    smtp_port = 587  # For TLS
    server = smtplib.SMTP(smtp_server, smtp_port)
    server.starttls()

    # Log in to your email account
    server.login(from_email, password)

    # Send the email
    server.sendmail(from_email, to_email, msg.as_string())

    # Close the server connection
    server.quit()

    print("Email sent successfully!")


# Email configuration
from_email = "mallem.santhosh@gmail.com"
password = "ohippvtbzbuzfcjr"
to_email = "ramsai350mg@gmail.com"
subject = "Test Email"
message_body = "This is a test email sent from Python."
Email_notification(from_email,to_email,subject,message_body,password)
