/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class ChpasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
         @FXML
    private PasswordField prev_pass;

    @FXML
    private PasswordField newpassword;
    
    @FXML
    private PasswordField renewpassword;
    
    @FXML
    private Label pass_correct;
    
    @FXML
    private Label pass_correct1;
    
    @FXML
    private Button back;
    
    HeadOffice hf = new HeadOffice();
    private int check;

    @FXML
    void makenewpassword(ActionEvent event) {
        try {
            check = hf.checkpassward(prev_pass);
        } catch (IOException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (check == 1) {
            pass_correct.setText("Correct ");
            if (newpassword.getText().equals(renewpassword.getText())) {
                pass_correct1.setText("Match ");
                try {
                    hf.changePassward(newpassword);
                } catch (IOException ex) {
                    Logger.getLogger(ChpasswordController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                pass_correct1.setText("Not Match ");
            }
        } else {
            pass_correct.setText("Incorrect ");
        }   
    }
    
    @FXML
    void back(ActionEvent event) throws IOException{
        Parent SecondFrameParent = FXMLLoader.load(getClass().getResource("/view/admin2.fxml"));
         Scene SecondFrameScene = new Scene(SecondFrameParent);
         
         
         
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
          window.setTitle("ONLINE BANKING SYSTEM");
         Screen screen = Screen.getPrimary();
         Rectangle2D bounds = screen.getVisualBounds();

         window.setX(bounds.getMinX());
         window.setY(bounds.getMinY());
         window.setWidth(bounds.getWidth());
         window.setHeight(bounds.getHeight());       
         
         window.setScene(SecondFrameScene);
         
         window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
