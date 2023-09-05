import smtplib
import ssl
print("Hello World")

port = 587  # For starttls
smtp_server = "smtp.gmail.com"
sender_email = "mallem.santhosh@gmail.com"
receiver_email = "ramsai350mg@gmail.com,santhosh.mallem@modak.com"
password = "ohippvtbzbuzfcjr"
message = """\
Subject: Hi there
Im sending an email through python code and from Modak Nabu."""
context = ssl.create_default_context()
with smtplib.SMTP(smtp_server, port) as server:
    server.ehlo() 
    server.starttls(context=context)
    server.ehlo() 
    server.login(sender_email, password)
    server.sendmail(sender_email, receiver_email, message)
print("SuccessFully Send Message 1000")
