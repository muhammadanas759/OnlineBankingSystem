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
import javafx.scene.control.RadioButton;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class OthersController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private RadioButton fd;

    @FXML
    private RadioButton uinfo;

    @FXML
    private RadioButton chkbal;
    
    @FXML
    private Button exit;

    @FXML
    void FixedDeposit(ActionEvent event) throws IOException {
               Parent SecondFrameParent = FXMLLoader.load(getClass().getResource("/view/fixdep.fxml"));
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

    @FXML
    void checkbalance(ActionEvent event) throws IOException {
                Parent SecondFrameParent = FXMLLoader.load(getClass().getResource("/view/chbalance.fxml"));
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

    @FXML
    void updateinformation(ActionEvent event) throws IOException {
                Parent SecondFrameParent = FXMLLoader.load(getClass().getResource("/view/Profinfo.fxml"));
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
    
    @FXML
    void exit(ActionEvent event) throws IOException {
                Parent SecondFrameParent = FXMLLoader.load(getClass().getResource("/view/service.fxml"));
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
