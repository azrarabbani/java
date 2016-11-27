package prog;

import java.util.Properties;

/**
 * Created by arabbani on 11/23/16.
 */
public class JavaMail {



    /**
     * @param fromAddress
     * @param toRecipients
     * @param ccRecipients
     * @param bccRecipients
     * @param subject
     * @param body
     */
    public static void sendEmail(
            String fromAddress
            , String[] toRecipients
            , String[] ccRecipients
            , String[] bccRecipients
            , String subject
            , String body) {
        Properties properties = System.getProperties();
//        Session session = Session.getDefaultInstance(properties);
//        MimeMessage message = new MimeMessage(session);
//        try {
//            message.setFrom(new InternetAddress(fromAddress));
//            message.setSubject(subject);
//            message.setText(body, "utf-8", "html");
//            if(toRecipients != null) {
//                for(String email : toRecipients) {
//                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
//                }
//            }
//            if(ccRecipients != null) {
//                for(String email : ccRecipients) {
//                    message.addRecipient(Message.RecipientType.CC, new InternetAddress(email));
//                }
//            }
//            if(bccRecipients != null) {
//                for(String email : bccRecipients) {
//                    message.addRecipient(Message.RecipientType.BCC, new InternetAddress(email));
//                }
//            }
//            Transport.send(message);
//        } catch (MessagingException exception) {
//            throw new HydraException(
//                    "Failed to create message:"
//                            + "\n fromAddress: " + fromAddress
//                            + "\n toRecipients: " + Arrays.asList(toRecipients)
//                            + "\n ccRecipients: " + Arrays.asList(ccRecipients)
//                            + "\n bccRecipients: " + Arrays.asList(bccRecipients)
//                            + "\n subject: " + subject
//                            + "\n body: " + body
//                    , exception);
//        }
    }

}
