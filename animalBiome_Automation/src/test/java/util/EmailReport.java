package util;



import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

public class EmailReport {

    public static void sendReportEmail() {
        final String senderEmail = "noorabvet@gmail.com"; 
        final String senderPassword = "kthb yala esaw yvrf"; 
        final String recipientEmail = "nooruddin@stratapps.com";

        // SMTP Configuration
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Selenium Test Report");

            // Email Body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Hello,\n\nPlease find the attached Selenium test report.\n\nBest Regards,\nQA Team");

            // Attach the Latest Report
            MimeBodyPart attachmentPart = new MimeBodyPart();
            String reportFilePath = findLatestExtentReport("test-output/");
            if (reportFilePath != null) {
                File file = new File(reportFilePath);
                attachmentPart.attachFile(file);
            } else {
                System.out.println("Report file not found!");
                return;
            }

            // Combine Message and Attachment
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);

            // Send Email
            Transport.send(message);
            System.out.println("Test Report Email Sent Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Sending Email: " + e.getMessage());
        }
    }

    // Find the Latest Extent Report File
    private static String findLatestExtentReport(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".html"));
        
        if (files == null || files.length == 0) {
            return null;
        }

        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }
        return latestFile.getAbsolutePath();
    }
}

