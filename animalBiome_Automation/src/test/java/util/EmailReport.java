package util;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.internet.MimeUtility;

public class EmailReport {

	public static void sendReportEmail(int passed, int failed, int skipped, String accountType) {
        final String senderEmail = "qateamstratapps@gmail.com";
        final String senderPassword = "uuus patl eysl ysne";
        final String recipientEmail = "nooruddin@stratapps.com,banoj@stratapps.com,vjasmitha@stratapps.com,bgrace@stratapps.com,klakshmansai@stratapps.com";

        int total = passed + failed + skipped;
        double successRate = total > 0 ? ((double) passed / total) * 100 : 0;
        String formattedSuccessRate = String.format("%.1f", successRate);
        String executionTime = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss").format(new Date());

        String environment = "Release";
        String testSuite = "Regression";
        String triggeredBy = "Jenkins CI/CD";

        List<String> recommendations = Arrays.asList(
            "Investigate " + failed + " failed test case(s) - prioritize critical path scenarios",
            "Review " + skipped + " skipped test(s) - determine if they should be enabled or removed",
            "Maintain excellent " + formattedSuccessRate + "% pass rate - aim for 95%+ target",
            "Schedule analysis of failures with development team",
            "Add edge case coverage to improve reliability"
        );

        StringBuilder recommendationHtml = new StringBuilder();
        for (String rec : recommendations) {
            recommendationHtml.append("<li>🚀 ").append(rec).append("</li>");
        }

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
            message.setFrom(new InternetAddress(senderEmail,"TeamQA StratApps"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(MimeUtility.encodeText("🎯 AnimalBiome Quality Check Complete - Ready for Review", "UTF-8", "B"));

          String bodyText = new String(Files.readAllBytes(Paths.get("src/test/java/util/email_template_base.html")), StandardCharsets.UTF_8);

            bodyText = bodyText.replace("{{PASSED}}", String.valueOf(passed))
                               .replace("{{FAILED}}", String.valueOf(failed))
                               .replace("{{SKIPPED}}", String.valueOf(skipped))
                               .replace("{{TOTAL}}", String.valueOf(total))
                               .replace("{{SUCCESS_RATE}}", formattedSuccessRate)
                               .replace("{{EXECUTION_TIME}}", executionTime)
                               .replace("{{ENVIRONMENT}}", environment)
                               .replace("{{TEST_SUITE}}", testSuite)
                               .replace("{{TRIGGERED_BY}}", triggeredBy)
                               .replace("{{ACCOUNT_TYPE}}", accountType)
                               .replace("{{RECOMMENDATIONS}}", recommendationHtml.toString());

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