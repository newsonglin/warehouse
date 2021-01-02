package com.lin.mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Base64;
import java.util.Properties;

public class MailService {

    private static void sendMail() throws Exception {
        // 1. Create Properties for SMTP
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "ns3.exigengroup.com");
        props.setProperty("mail.smtp.auth", "false");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.smtp.sendpartial","true");

        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("songlin.li@eisgroup.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("songlin.li@eisgroup.com,abc@xx.com"));
        message.setSubject("Test Mail With Attachment");

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("<html>Mail Body</html>");

        byte[] attachment1Bytes = Base64.getDecoder().decode(FileService.encodeFileToBase64(new File("D:\\project_management\\xxx\\OMS\\委外列印批次流程.png")));
        MimeBodyPart attachmentPart = new MimeBodyPart(new ByteArrayInputStream(attachment1Bytes));

/*        File tempFile = File.createTempFile("HotEmailAttachment", ".tmp");
        tempFile.deleteOnExit();
        FileOutputStream fos = new FileOutputStream(tempFile);
        fos.write(attachment1Bytes);
        fos.close();

        attachmentPart.attachFile(tempFile);*/
        attachmentPart.setFileName(MimeUtility.encodeText("我最愛的中文字符+繁體中文.png", "UTF-8", null));


//        attachmentPart2.attachFile(new File("D:\\project_management\\xxx\\OMS\\DogGen套印與列印派送_列印管理系統介接_20200416.xlsx"));
        byte[] attachment2Bytes = Base64.getDecoder().decode(FileService.encodeFileToBase64(new File("D:\\project_management\\xxx\\OMS\\DogGen套印與列印派送_列印管理系統介接_20200416.xlsx")));
        MimeBodyPart attachmentPart2 = new MimeBodyPart(new ByteArrayInputStream(attachment2Bytes));
        attachmentPart2.setFileName("我喜欢的中文.xlsx");



        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachmentPart);
        multipart.addBodyPart(attachmentPart2);

        message.setContent(multipart);

        Transport.send(message);
    }

    public static void main(String[] args) throws Exception {
        sendMail();
    }
}
