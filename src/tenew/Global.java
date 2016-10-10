/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenew;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Smitticus
 */
public class Global {

    static String projectpath;
    static int bal = 0, ans = 0, temp = 0;
    static boolean update = true;
    static InputStream input = null;
    Connection con = null;
    ResultSet rs;
    PreparedStatement pstmt;
    Statement stmt;
    String customer_no, type, type_no, validity;
    String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    Date MD;

    public static void CreateDirectory() {
        try {
            projectpath = new File(".").getCanonicalPath();
            File backup = new File(projectpath + "\\TEBackup");
            if (!backup.exists()) {
                backup.mkdir();
            }
        } catch (IOException ex) {
            Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean isValidNumber(Class c, String numString) {
        try {
            if (c == double.class || c == Double.class) {
                Double.parseDouble(numString);
            } else if (c == int.class || c == Integer.class) {
                Integer.parseInt(numString);
            } else if (c == float.class || c == Float.class) {
                Float.parseFloat(numString);
            } else if (c == long.class || c == Long.class) {
                Long.parseLong(numString);
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public void CheckMembershipExpiry() {
        try {
            int i = 0;
            String query = "select a.customer_no,a.type_no,a.membership_date,b.type,b.validity from mst_customer a join mst_type b on a.type_no = b.type_no where b.type = 'PRIVILEGE' and a.flag != 'D' and b.flag != 'D'";
            con = new DBConnection().connect();
            con.setAutoCommit(false);            
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                customer_no = rs.getString(1);
                type_no = rs.getString(2);
                MD = rs.getDate(3);
                type = rs.getString(4);
                validity = rs.getString(5);
                Calendar cal = Calendar.getInstance();
                cal.setTime(MD);
                cal.add(Calendar.MONTH, Integer.parseInt(validity));
                //System.out.println(cal.getTime());
                Calendar cal2 = Calendar.getInstance();
               // System.out.println(cal2.getTime());
                if (cal2.getTime().compareTo(cal.getTime()) > 0) {
                    query = "update mst_customer set type_no = (select type_no from mst_type where type = 'CASUAL' and flag!='D') where customer_no = ?";
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, customer_no);
                    i = i + pstmt.executeUpdate();
                }
            }
            if (i > 0) {
                con.commit();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendmail() {
        try {
            // Recipient's email ID needs to be mentioned.
            Properties emailprop = new Properties();
            input = new FileInputStream(projectpath + "/Properties/Email.properties");
            emailprop.load(input);

            String to = emailprop.getProperty("to");
            // Sender's email ID needs to be mentioned
            String from = emailprop.getProperty("from");
            // Assuming you are sending email from localhost
            String host = "localhost";
            final String username = emailprop.getProperty("username");
            final String password = emailprop.getProperty("password");
            // Get system properties
            Properties properties = System.getProperties();
            // Setup mail server
            //        properties.setProperty("mail.smtp.host", host);
            //        properties.put("mail.smtp.auth", "true");
            //        properties.put("mail.smtp.starttls.enable", "true");
            //        properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.socketFactory.port", "465");
            properties.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.port", "465");
            // Get the default Session object.
            Session session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            try {
                // Create a default MimeMessage object.
                MimeMessage message = new MimeMessage(session);

                // Set From: header field of the header.
                message.setFrom(new InternetAddress(from));

                // Set To: header field of the header.
                message.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(to));

                // Set Subject: header field
                message.setSubject("Backup - " + new Date());

                // Create the message part 
                BodyPart messageBodyPart = new MimeBodyPart();

                // Fill the message
                messageBodyPart.setText("Backup - " + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

                // Create a multipar message
                Multipart multipart = new MimeMultipart();

                // Set text message part
                multipart.addBodyPart(messageBodyPart);

                // Part two is attachment

                messageBodyPart = new MimeBodyPart();
                String ProjectPath = new File("").getAbsolutePath();
                String filename = ProjectPath + "\\TEBackup\\" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".sql";
                DataSource source = new FileDataSource(filename);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(filename);
                multipart.addBodyPart(messageBodyPart);

                // Send the complete message parts
                message.setContent(multipart);

                // Send message
                Transport.send(message);
                System.out.println("Sent message successfully....");
            } catch (MessagingException mex) {
                mex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(Global.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
