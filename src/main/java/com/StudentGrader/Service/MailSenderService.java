package com.StudentGrader.Service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class MailSenderService {

    private static final Logger log =
            LoggerFactory.getLogger(MailSenderService.class);

    private final SendGrid sendGrid;

    @Value("${sendgrid.from.email}")
    private String fromEmail;

    public MailSenderService(SendGrid sendGrid) {
        this.sendGrid = sendGrid;
    }

    // Welcome Email
    public void sendWelcomeEmail(String toEmail, String studentName)
            throws IOException {

        String subject = "Welcome to StudentGrader!";
        String body = buildWelcomeEmailHtml(studentName);

        sendHtmlEmail(toEmail, subject, body);
    }

    // Quiz Completion Email
    public void sendQuizCompletionEmail(String toEmail,
                                        String studentName,
                                        int finalScore)
            throws IOException {

        String subject = "Quiz Completed!";
        String body = buildQuizCompletionEmailHtml(studentName, finalScore);

        sendHtmlEmail(toEmail, subject, body);
    }

    // Common SendGrid HTML Sender
    private void sendHtmlEmail(String toEmail,
                               String subject,
                               String htmlBody)
            throws IOException {

        log.info("Sending email to: {} with subject: {}",
                toEmail, subject);

        Email from = new Email(fromEmail);
        Email to = new Email(toEmail);

        Content content = new Content("text/html", htmlBody);

        Mail mail = new Mail(from, subject, to, content);

        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        Response response = sendGrid.api(request);

        log.info("Email sent successfully to: {}", toEmail);

        log.info("SendGrid Status Code: {}",
                response.getStatusCode());
    }

    // Welcome HTML
    private String buildWelcomeEmailHtml(String studentName) {

        return "<html>" +
                "<body style=\"font-family: 'Segoe UI', sans-serif; background:#f4f6f8; padding:20px;\">" +
                "<div style=\"max-width:600px; background:#fff; margin:auto; padding:30px; border-radius:12px;\">" +
                "<h2 style=\"color:#2E86C1;\">Welcome to StudentGrader, "
                + studentName + "!</h2>" +

                "<p>Thank you for signing up at <strong>StudentGrader</strong>.</p>" +

                "<p>Get ready to improve your skills!</p>" +

                "<hr>" +

                "<p style=\"font-size:12px;color:#666;\">" +
                "Developed by bhiseamarwagholi@gmail.com" +
                "</p>" +

                "</div>" +
                "</body>" +
                "</html>";
    }

    // Quiz Completion HTML
    private String buildQuizCompletionEmailHtml(String studentName,
                                                int finalScore) {

        return "<html>" +
                "<body style=\"font-family: 'Segoe UI', sans-serif; background:#f4f6f8; padding:20px;\">" +

                "<div style=\"max-width:600px; background:#fff; margin:auto; padding:30px; border-radius:12px;\">" +

                "<h2 style=\"color:#27AE60;\">Congratulations, "
                + studentName + "!</h2>" +

                "<p>You completed the quiz successfully.</p>" +

                "<p style=\"font-size:24px; color:#E67E22;\">" +
                "Final Score: " + finalScore + " / 50" +
                "</p>" +

                "<p>Keep learning and improving!</p>" +

                "<hr>" +

                "<p style=\"font-size:12px;color:#666;\">" +
                "Developed by bhiseamarwagholi@gmail.com" +
                "</p>" +

                "</div>" +
                "</body>" +
                "</html>";
    }
}