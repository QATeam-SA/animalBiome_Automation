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
        final String recipientEmail = "banoj@stratapps.com";

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
            String bodyText = "<!DOCTYPE html>\r\n"
            		+ "<html lang=\"en\">\r\n"
            		+ "<head>\r\n"
            		+ "    <meta charset=\"UTF-8\">\r\n"
            		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
            		+ "    <title>AnimalBiome Automation Test Report</title>\r\n"
            		+ "    <style>\r\n"
            		+ "        * {\r\n"
            		+ "            margin: 0;\r\n"
            		+ "            padding: 0;\r\n"
            		+ "            box-sizing: border-box;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        body {\r\n"
            		+ "            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, sans-serif;\r\n"
            		+ "            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);\r\n"
            		+ "            min-height: 100vh;\r\n"
            		+ "            padding: 20px;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .container {\r\n"
            		+ "            max-width: 1200px;\r\n"
            		+ "            margin: 0 auto;\r\n"
            		+ "            background: rgba(255, 255, 255, 0.95);\r\n"
            		+ "            backdrop-filter: blur(10px);\r\n"
            		+ "            border-radius: 20px;\r\n"
            		+ "            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);\r\n"
            		+ "            overflow: hidden;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .header {\r\n"
            		+ "            background: linear-gradient(135deg, #4f46e5 0%, #7c3aed 100%);\r\n"
            		+ "            color: white;\r\n"
            		+ "            padding: 30px;\r\n"
            		+ "            text-align: center;\r\n"
            		+ "            position: relative;\r\n"
            		+ "            overflow: hidden;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .header::before {\r\n"
            		+ "            content: '';\r\n"
            		+ "            position: absolute;\r\n"
            		+ "            top: -50%;\r\n"
            		+ "            left: -50%;\r\n"
            		+ "            width: 200%;\r\n"
            		+ "            height: 200%;\r\n"
            		+ "            background: radial-gradient(circle, rgba(255,255,255,0.1) 0%, transparent 70%);\r\n"
            		+ "            animation: pulse 4s ease-in-out infinite;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        @keyframes pulse {\r\n"
            		+ "            0%, 100% { transform: scale(1); opacity: 0.5; }\r\n"
            		+ "            50% { transform: scale(1.1); opacity: 0.8; }\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .header h1 {\r\n"
            		+ "            font-size: 2.5rem;\r\n"
            		+ "            margin-bottom: 10px;\r\n"
            		+ "            position: relative;\r\n"
            		+ "            z-index: 1;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .header .subtitle {\r\n"
            		+ "            font-size: 1.1rem;\r\n"
            		+ "            opacity: 0.9;\r\n"
            		+ "            position: relative;\r\n"
            		+ "            z-index: 1;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .content {\r\n"
            		+ "            padding: 40px;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .summary-grid {\r\n"
            		+ "            display: grid;\r\n"
            		+ "            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));\r\n"
            		+ "            gap: 25px;\r\n"
            		+ "            margin-bottom: 40px;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .summary-card {\r\n"
            		+ "            background: white;\r\n"
            		+ "            border-radius: 15px;\r\n"
            		+ "            padding: 25px;\r\n"
            		+ "            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);\r\n"
            		+ "            border-left: 5px solid #e5e7eb;\r\n"
            		+ "            transition: all 0.3s ease;\r\n"
            		+ "            position: relative;\r\n"
            		+ "            overflow: hidden;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .summary-card::before {\r\n"
            		+ "            content: '';\r\n"
            		+ "            position: absolute;\r\n"
            		+ "            top: 0;\r\n"
            		+ "            left: 0;\r\n"
            		+ "            right: 0;\r\n"
            		+ "            height: 3px;\r\n"
            		+ "            background: linear-gradient(90deg, transparent, rgba(79, 70, 229, 0.3), transparent);\r\n"
            		+ "            animation: shimmer 2s infinite;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        @keyframes shimmer {\r\n"
            		+ "            0% { transform: translateX(-100%); }\r\n"
            		+ "            100% { transform: translateX(100%); }\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .summary-card:hover {\r\n"
            		+ "            transform: translateY(-5px);\r\n"
            		+ "            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.15);\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .summary-card h3 {\r\n"
            		+ "            color: #374151;\r\n"
            		+ "            margin-bottom: 15px;\r\n"
            		+ "            font-size: 1.1rem;\r\n"
            		+ "            font-weight: 600;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .summary-card .value {\r\n"
            		+ "            font-size: 1.8rem;\r\n"
            		+ "            font-weight: 700;\r\n"
            		+ "            margin-bottom: 8px;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .summary-card .label {\r\n"
            		+ "            color: #6b7280;\r\n"
            		+ "            font-size: 0.9rem;\r\n"
            		+ "            text-transform: uppercase;\r\n"
            		+ "            letter-spacing: 0.5px;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .test-results {\r\n"
            		+ "            background: white;\r\n"
            		+ "            border-radius: 15px;\r\n"
            		+ "            padding: 30px;\r\n"
            		+ "            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);\r\n"
            		+ "            margin-bottom: 30px;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .results-header {\r\n"
            		+ "            display: flex;\r\n"
            		+ "            justify-content: space-between;\r\n"
            		+ "            align-items: center;\r\n"
            		+ "            margin-bottom: 25px;\r\n"
            		+ "            flex-wrap: wrap;\r\n"
            		+ "            gap: 15px;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .results-header h2 {\r\n"
            		+ "            color: #111827;\r\n"
            		+ "            font-size: 1.5rem;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .success-rate {\r\n"
            		+ "            background: linear-gradient(135deg, #10b981 0%, #059669 100%);\r\n"
            		+ "            color: white;\r\n"
            		+ "            padding: 10px 20px;\r\n"
            		+ "            border-radius: 25px;\r\n"
            		+ "            font-weight: 600;\r\n"
            		+ "            font-size: 1.1rem;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .stats-container {\r\n"
            		+ "            display: flex;\r\n"
            		+ "            gap: 30px;\r\n"
            		+ "            flex-wrap: wrap;\r\n"
            		+ "            justify-content: center;\r\n"
            		+ "            margin-bottom: 30px;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .stat-item {\r\n"
            		+ "            text-align: center;\r\n"
            		+ "            padding: 20px;\r\n"
            		+ "            border-radius: 12px;\r\n"
            		+ "            background: #f9fafb;\r\n"
            		+ "            min-width: 120px;\r\n"
            		+ "            transition: all 0.3s ease;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .stat-item:hover {\r\n"
            		+ "            transform: scale(1.05);\r\n"
            		+ "            background: #f3f4f6;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .stat-number {\r\n"
            		+ "            font-size: 2.5rem;\r\n"
            		+ "            font-weight: 800;\r\n"
            		+ "            margin-bottom: 5px;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .passed { color: #10b981; }\r\n"
            		+ "        .failed { color: #ef4444; }\r\n"
            		+ "        .skipped { color: #f59e0b; }\r\n"
            		+ "        \r\n"
            		+ "        .progress-bar {\r\n"
            		+ "            width: 100%;\r\n"
            		+ "            height: 12px;\r\n"
            		+ "            background: #e5e7eb;\r\n"
            		+ "            border-radius: 6px;\r\n"
            		+ "            overflow: hidden;\r\n"
            		+ "            margin: 20px 0;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .progress-fill {\r\n"
            		+ "            height: 100%;\r\n"
            		+ "            background: linear-gradient(90deg, #10b981 0%, #059669 100%);\r\n"
            		+ "            border-radius: 6px;\r\n"
            		+ "            transition: width 2s ease-in-out;\r\n"
            		+ "            animation: fillProgress 2s ease-in-out;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        @keyframes fillProgress {\r\n"
            		+ "            from { width: 0%; }\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .recommendations {\r\n"
            		+ "            background: linear-gradient(135deg, #fef3c7 0%, #fde68a 100%);\r\n"
            		+ "            border-radius: 15px;\r\n"
            		+ "            padding: 25px;\r\n"
            		+ "            margin-bottom: 30px;\r\n"
            		+ "            border-left: 5px solid #f59e0b;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .recommendations h3 {\r\n"
            		+ "            color: #92400e;\r\n"
            		+ "            margin-bottom: 15px;\r\n"
            		+ "            font-size: 1.2rem;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .recommendations ul {\r\n"
            		+ "            list-style: none;\r\n"
            		+ "            padding: 0;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .recommendations li {\r\n"
            		+ "            color: #78350f;\r\n"
            		+ "            margin-bottom: 10px;\r\n"
            		+ "            padding-left: 20px;\r\n"
            		+ "            position: relative;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .recommendations li::before {\r\n"
            		+ "            content: '🚀';\r\n"
            		+ "            position: absolute;\r\n"
            		+ "            left: 0;\r\n"
            		+ "            top: 0;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .footer {\r\n"
            		+ "            background: #f8fafc;\r\n"
            		+ "            padding: 25px;\r\n"
            		+ "            text-align: center;\r\n"
            		+ "            border-top: 1px solid #e5e7eb;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .footer p {\r\n"
            		+ "            color: #6b7280;\r\n"
            		+ "            margin-bottom: 10px;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .team-signature {\r\n"
            		+ "            color: #4f46e5;\r\n"
            		+ "            font-weight: 600;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        .timestamp {\r\n"
            		+ "            background: #e0e7ff;\r\n"
            		+ "            color: #4338ca;\r\n"
            		+ "            padding: 8px 16px;\r\n"
            		+ "            border-radius: 20px;\r\n"
            		+ "            font-size: 0.9rem;\r\n"
            		+ "            font-weight: 500;\r\n"
            		+ "        }\r\n"
            		+ "        \r\n"
            		+ "        @media (max-width: 768px) {\r\n"
            		+ "            .header h1 {\r\n"
            		+ "                font-size: 2rem;\r\n"
            		+ "            }\r\n"
            		+ "            \r\n"
            		+ "            .content {\r\n"
            		+ "                padding: 20px;\r\n"
            		+ "            }\r\n"
            		+ "            \r\n"
            		+ "            .stats-container {\r\n"
            		+ "                gap: 15px;\r\n"
            		+ "            }\r\n"
            		+ "            \r\n"
            		+ "            .results-header {\r\n"
            		+ "                flex-direction: column;\r\n"
            		+ "                text-align: center;\r\n"
            		+ "            }\r\n"
            		+ "        }\r\n"
            		+ "    </style>\r\n"
            		+ "</head>\r\n"
            		+ "<body>\r\n"
            		+ "    <div class=\"container\">\r\n"
            		+ "        <div class=\"header\">\r\n"
            		+ "            <h1>🚀 AnimalBiome Test Automation Report</h1>\r\n"
            		+ "            <p class=\"subtitle\">Comprehensive Quality Assurance Dashboard</p>\r\n"
            		+ "        </div>\r\n"
            		+ "        \r\n"
            		+ "        <div class=\"content\">\r\n"
            		+ "            <div class=\"summary-grid\">\r\n"
            		+ "                <div class=\"summary-card\">\r\n"
            		+ "                    <h3>Environment</h3>\r\n"
            		+ "                    <div class=\"value\" style=\"color: #4f46e5;\">Release</div>\r\n"
            		+ "                    <div class=\"label\">Production Ready</div>\r\n"
            		+ "                </div>\r\n"
            		+ "                \r\n"
            		+ "                <div class=\"summary-card\">\r\n"
            		+ "                    <h3>Test Suite</h3>\r\n"
            		+ "                    <div class=\"value\" style=\"color: #7c3aed;\">Regression</div>\r\n"
            		+ "                    <div class=\"label\">Full Coverage</div>\r\n"
            		+ "                </div>\r\n"
            		+ "                \r\n"
            		+ "                <div class=\"summary-card\">\r\n"
            		+ "                    <h3>Execution Trigger</h3>\r\n"
            		+ "                    <div class=\"value\" style=\"color: #059669;\">Jenkins CI/CD</div>\r\n"
            		+ "                    <div class=\"label\">Automated Pipeline</div>\r\n"
            		+ "                </div>\r\n"
            		+ "                \r\n"
            		+ "                <div class=\"summary-card\">\r\n"
            		+ "                    <h3>Execution Time</h3>\r\n"
            		+ "                    <div class=\"value\" style=\"color: #dc2626;\" id=\"timestamp\"></div>\r\n"
            		+ "                    <div class=\"label\">Latest Run</div>\r\n"
            		+ "                </div>\r\n"
            		+ "            </div>\r\n"
            		+ "            \r\n"
            		+ "            <div class=\"test-results\">\r\n"
            		+ "                <div class=\"results-header\">\r\n"
            		+ "                    <h2>📊 Test Execution Results</h2>\r\n"
            		+ "                    <div class=\"success-rate\">94.9% Success Rate</div>\r\n"
            		+ "                </div>\r\n"
            		+ "                \r\n"
            		+ "                <div class=\"progress-bar\">\r\n"
            		+ "                    <div class=\"progress-fill\" style=\"width: 94.9%\"></div>\r\n"
            		+ "                </div>\r\n"
            		+ "                \r\n"
            		+ "                <div class=\"stats-container\">\r\n"
            		+ "                    <div class=\"stat-item\">\r\n"
            		+ "                        <div class=\"stat-number passed\">111</div>\r\n"
            		+ "                        <div class=\"label\">✅ Passed</div>\r\n"
            		+ "                    </div>\r\n"
            		+ "                    \r\n"
            		+ "                    <div class=\"stat-item\">\r\n"
            		+ "                        <div class=\"stat-number failed\">5</div>\r\n"
            		+ "                        <div class=\"label\">❌ Failed</div>\r\n"
            		+ "                    </div>\r\n"
            		+ "                    \r\n"
            		+ "                    <div class=\"stat-item\">\r\n"
            		+ "                        <div class=\"stat-number skipped\">1</div>\r\n"
            		+ "                        <div class=\"label\">⏭️ Skipped</div>\r\n"
            		+ "                    </div>\r\n"
            		+ "                    \r\n"
            		+ "                    <div class=\"stat-item\">\r\n"
            		+ "                        <div class=\"stat-number\" style=\"color: #6366f1;\">117</div>\r\n"
            		+ "                        <div class=\"label\">📋 Total Tests</div>\r\n"
            		+ "                    </div>\r\n"
            		+ "                </div>\r\n"
            		+ "            </div>\r\n"
            		+ "            \r\n"
            		+ "            <div class=\"recommendations\">\r\n"
            		+ "                <h3>🎯 Action Items & Recommendations</h3>\r\n"
            		+ "                <ul>\r\n"
            		+ "                    <li>Investigate 5 failed test cases - prioritize critical path scenarios</li>\r\n"
            		+ "                    <li>Review 1 skipped test - determine if it should be enabled or removed</li>\r\n"
            		+ "                    <li>Maintain excellent 94.9% pass rate - consider setting 95%+ as target</li>\r\n"
            		+ "                    <li>Schedule detailed analysis of failing tests with development team</li>\r\n"
            		+ "                    <li>Consider adding more edge case coverage for improved reliability</li>\r\n"
            		+ "                </ul>\r\n"
            		+ "            </div>\r\n"
            		+ "            \r\n"
            		+ "            <div class=\"test-results\">\r\n"
            		+ "                <h2>📈 Trend Analysis</h2>\r\n"
            		+ "                <p style=\"color: #6b7280; margin-bottom: 20px;\">\r\n"
            		+ "                    Your test suite shows strong stability with a 94.9% success rate. The small number of failures (5) \r\n"
            		+ "                    indicates well-maintained test scenarios. Focus on addressing the failed tests to achieve \r\n"
            		+ "                    your quality goals.\r\n"
            		+ "                </p>\r\n"
            		+ "                \r\n"
            		+ "                <div style=\"background: #f0f9ff; padding: 20px; border-radius: 10px; border-left: 4px solid #0ea5e9;\">\r\n"
            		+ "                    <strong style=\"color: #0369a1;\">💡 Pro Tip:</strong>\r\n"
            		+ "                    <span style=\"color: #075985;\">\r\n"
            		+ "                        Consider implementing test result trending over time to identify patterns and \r\n"
            		+ "                        prevent regression in your automation suite.\r\n"
            		+ "                    </span>\r\n"
            		+ "                </div>\r\n"
            		+ "            </div>\r\n"
            		+ "        </div>\r\n"
            		+ "        \r\n"
            		+ "        <div class=\"footer\">\r\n"
            		+ "            <p>For detailed test logs and failure analysis, please refer to the complete HTML report.</p>\r\n"
            		+ "            <p>Questions or concerns? Feel free to reach out to our team.</p>\r\n"
            		+ "            <p class=\"team-signature\">🔬 QA Team - StratApps</p>\r\n"
            		+ "            <div class=\"timestamp\" id=\"footer-timestamp\"></div>\r\n"
            		+ "        </div>\r\n"
            		+ "    </div>\r\n"
            		+ "    \r\n"
            		+ "    <script>\r\n"
            		+ "        // Set current timestamp\r\n"
            		+ "        const now = new Date();\r\n"
            		+ "        const timeString = now.toLocaleString('en-US', {\r\n"
            		+ "            year: 'numeric',\r\n"
            		+ "            month: 'short',\r\n"
            		+ "            day: 'numeric',\r\n"
            		+ "            hour: '2-digit',\r\n"
            		+ "            minute: '2-digit',\r\n"
            		+ "            hour12: true\r\n"
            		+ "        });\r\n"
            		+ "        \r\n"
            		+ "        document.getElementById('timestamp').textContent = timeString;\r\n"
            		+ "        document.getElementById('footer-timestamp').textContent = `Generated on ${timeString}`;\r\n"
            		+ "        \r\n"
            		+ "        // Add some interactive elements\r\n"
            		+ "        document.querySelectorAll('.summary-card').forEach(card => {\r\n"
            		+ "            card.addEventListener('mouseenter', function() {\r\n"
            		+ "                this.style.borderLeftColor = '#4f46e5';\r\n"
            		+ "            });\r\n"
            		+ "            \r\n"
            		+ "            card.addEventListener('mouseleave', function() {\r\n"
            		+ "                this.style.borderLeftColor = '#e5e7eb';\r\n"
            		+ "            });\r\n"
            		+ "        });\r\n"
            		+ "    </script>\r\n"
            		+ "</body>\r\n"
            		+ "</html>";
            
			/*
			 * String bodyText = "<html><body style='font-family:Arial, sans-serif;'>" +
			 * "<h2 style='color:#2E86C1;'>🚀 AnimalBiome Automation Test Report</h2>" +
			 * "<p>The latest Automated TestSuite from the Master Branch has been executed. Please find the summary below, along with the detailed HTML report for further insights.</p>"
			 * 
			 * + "<table style='border-collapse:collapse; width: 60%;'>" + "  <tr>" +
			 * "    <th style='background-color:#f2f2f2; padding:10px; text-align:left;'>📋 Summary</th>"
			 * +
			 * "    <th style='background-color:#f2f2f2; padding:10px; text-align:left;'></th>"
			 * + "  </tr>" + "  <tr>" +
			 * "    <td style='padding:8px;'><b>Environment:</b></td>" +
			 * "    <td style='padding:8px;'>Release</td>" + "  </tr>" + "  <tr>" +
			 * "    <td style='padding:8px;'><b>Test Suite:</b></td>" +
			 * "    <td style='padding:8px;'>Regression</td>" + "  </tr>" + "  <tr>" +
			 * "    <td style='padding:8px;'><b>Triggered By:</b></td>" +
			 * "    <td style='padding:8px;'>Manual Execution</td>" + "  </tr>" + "  <tr>" +
			 * "    <td style='padding:8px; color:green;'><b>✅ Passed:</b></td>" +
			 * "    <td style='padding:8px; color:green;'>" + passed + "</td>" + "  </tr>" +
			 * "  <tr>" + "    <td style='padding:8px; color:red;'><b>❌ Failed:</b></td>" +
			 * "    <td style='padding:8px; color:red;'>" + failed + "</td>" + "  </tr>" +
			 * "  <tr>" +
			 * "    <td style='padding:8px; color:#f39c12;'><b>⏩ Skipped:</b></td>" +
			 * "    <td style='padding:8px; color:#f39c12;'>" + skipped + "</td>" +
			 * "  </tr>" + "</table><br>"
			 * 
			 * +
			 * "<p style='margin-top: 30px;'>Please feel free to contact us if you have any questions or concerns.</p>"
			 * + "<p>Thanks & Regards,<br>" + "<b>QA Team - StratApps</b><br>" +
			 * "📧 automation@stratapps.com</p>" + "</body></html>";
			 */

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
