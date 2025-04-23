package util;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;
import javax.mail.internet.MimeUtility;

public class EmailReport {

    public static void sendReportEmail(int passed, int failed, int skipped) {
        final String senderEmail = "qateamstratapps@gmail.com"; 
        final String senderPassword = "uuus patl eysl ysne"; 
        final String recipientEmail = "nooruddin@stratapps.com,banoj@stratapps.com,bgrace@stratapps.com,vjasmitha@stratapps.com";

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

            
            String subject = "📢Hurray! animalBiome Automation Test Execution Report is Ready to View 📊";
            message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));

            // Email Body
            String bodyText = "<html><body style='font-family:Arial, sans-serif;'>"
                    + "<h2 style='color:#2E86C1;'>🚀 AnimalBiome Automation Test Report</h2>"
                    + "<p>The latest automated test execution has completed. Please find the summary below, along with the detailed HTML report for further insights.</p>"

                    + "<table style='border-collapse:collapse; width: 60%;'>"
                    + "  <tr>"
                    + "    <th style='background-color:#f2f2f2; padding:10px; text-align:left;'>📋 Summary</th>"
                    + "    <th style='background-color:#f2f2f2; padding:10px; text-align:left;'></th>"
                    + "  </tr>"
                    + "  <tr>"
                    + "    <td style='padding:8px;'><b>Environment:</b></td>"
                    + "    <td style='padding:8px;'>Release</td>"
                    + "  </tr>"
                    + "  <tr>"
                    + "    <td style='padding:8px;'><b>Test Suite:</b></td>"
                    + "    <td style='padding:8px;'>Regression</td>"
                    + "  </tr>"
                    + "  <tr>"
                    + "    <td style='padding:8px;'><b>Triggered By:</b></td>"
                    + "    <td style='padding:8px;'>Manual Execution</td>"
                    + "  </tr>"
                    + "  <tr>"
                    + "    <td style='padding:8px; color:green;'><b>✅ Passed:</b></td>"
                    + "    <td style='padding:8px; color:green;'>" + passed + "</td>"
                    + "  </tr>"
                    + "  <tr>"
                    + "    <td style='padding:8px; color:red;'><b>❌ Failed:</b></td>"
                    + "    <td style='padding:8px; color:red;'>" + failed + "</td>"
                    + "  </tr>"
                    + "  <tr>"
                    + "    <td style='padding:8px; color:#f39c12;'><b>⏩ Skipped:</b></td>"
                    + "    <td style='padding:8px; color:#f39c12;'>" + skipped + "</td>"
                    + "  </tr>"
                    + "</table><br>"

                    + "<p style='margin-top: 30px;'>Please feel free to contact us if you have any questions or concerns.</p>"
                    + "<p>Thanks & Regards,<br>"
                    + "<b>QA Team - StratApps</b><br>"
                    + "📧 automation@stratapps.com</p>"
                    + "</body></html>";

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(bodyText, "text/html; charset=utf-8");

            MimeBodyPart attachmentPart = new MimeBodyPart();
            String reportFilePath = findLatestExtentReport("test-output/");
            if (reportFilePath != null) {
                File file = new File(reportFilePath);
                attachmentPart.attachFile(file);
            } else {
                System.out.println("Report file not found!");
                return;
            }

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart); 
            message.setContent(multipart);

            // Send email
            Transport.send(message);
            System.out.println("Test Report Email Sent Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Sending Email: " + e.getMessage());
        }
    }

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
