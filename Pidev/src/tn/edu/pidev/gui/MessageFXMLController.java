/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.pidev.gui;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tn.edu.pidev.entities.MessageAPI;
import tn.edu.pidev.services.IServiceMail;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class MessageFXMLController implements Initializable {
    @FXML
    private TextArea message;

    @FXML
    private TextField to;
    
    
    
    @FXML
    private TextField recipientTextField;

    @FXML
    private TextField subjectTextField;

    @FXML
    private TextField bodyTextField;

    @FXML
    private Button sendButton;
    
    IServiceMail is = new IServiceMail();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    
    sendButton.setOnAction(e -> {
        send(recipientTextField.getText(), subjectTextField.getText(), bodyTextField.getText());
        System.out.println("Email sent successfully.");
});
    
    }    
    


    @FXML
    void envoyerMessage(ActionEvent event) throws ProtocolException, IOException {

    }

    private void send(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
