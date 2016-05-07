/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetos.gerencia.apresentacao.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import projetos.gerencia.Principal;

/**
 *
 * @author Sostenes
 */
public class FXMLDocumentController implements Initializable {
   
    @FXML
    private Label lbl1;
    
    @FXML
    private Label lbl2;
   
    @FXML
    private TextField txtLogin;
    
    @FXML
    private PasswordField txtSenha;
  
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        if (this.txtLogin.getText().isEmpty()) {
           lbl1.setTextFill(Color.RED);
            System.err.println("Senha Vazia.");
        } else {
            String senha = String.valueOf(this.txtSenha.getText());
            Principal.getInstancia().fazerLogin(this.txtLogin.getText(), senha);
        }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
