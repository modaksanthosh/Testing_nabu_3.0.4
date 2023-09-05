
# Nabu executable Code in pyspark
import smtplib
import ssl
def Email_Notification_Using_PySpark(smtp_server,port,receiver_email,sender_email,password,message):
    context = ssl.create_default_context()
    with smtplib.SMTP(smtp_server, port) as server:
        server.ehlo() 
        server.starttls(context=context)
        server.ehlo() 
        server.login(sender_email, password)
        server.sendmail(sender_email, receiver_email, message)


# Calling Email_Notification
port = 587  # For starttls
smtp_server = "smtp.gmail.com"
sender_email = "mallem.santhosh@gmail.com"
receiver_email = ["ramsai350mg@gmail.com","mallem.santhosh@gmail.com","santhosh.mallem@modak.com"]
password = "ohippvtbzbuzfcjr"
message = """\
Subject: Hi there
Im sending an email through python code Data Bricks"""
Email_Notification_Using_PySpark(smtp_server,port,receiver_email,sender_email,password,message)
