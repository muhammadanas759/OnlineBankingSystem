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
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class ServiceController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label label;

    @FXML
    private Button wd_button;

    @FXML
    private Button dep_button;

    @FXML
    private Button newac_button;

    @FXML
    private Button mpro_button;

    @FXML
    private Button other_button;
    
    @FXML
    private Button exit;

    @FXML
    void cashdeposit(ActionEvent event) throws IOException {
       Parent SecondFrameParent = FXMLLoader.load(getClass().getResource("/view/cwcd1.fxml"));
         Scene SecondFrameScene = new Scene(SecondFrameParent);
        
         
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
         window.setTitle("Online Banking System");
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
    void monthlyprofit(ActionEvent event) throws IOException {
        Parent SecondFrameParent = FXMLLoader.load(getClass().getResource("/view/Profit.fxml"));
         Scene SecondFrameScene = new Scene(SecondFrameParent);
        
         
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
         window.setTitle("Online Banking System");
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
    void newaccount(ActionEvent event) throws IOException {
        Parent SecondFrameParent = FXMLLoader.load(getClass().getResource("/view/new1.fxml"));
         Scene SecondFrameScene = new Scene(SecondFrameParent);
        
         
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
         window.setTitle("Online Banking System");
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
    void others(ActionEvent event) throws IOException {
       // Stage stage=(Stage) other_button.getScene().getWindow();
       Parent SecondFrameParent = FXMLLoader.load(getClass().getResource("/view/Others.fxml"));
         Scene SecondFrameScene = new Scene(SecondFrameParent);
        
         
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
         window.setTitle("Online Banking System");
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
    void withdrawl(ActionEvent event) throws IOException {
        Parent SecondFrameParent = FXMLLoader.load(getClass().getResource("/view/cwcd.fxml"));
         Scene SecondFrameScene = new Scene(SecondFrameParent);
        
         
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
         window.setTitle("Online Banking System");
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
       Parent SecondFrameParent = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
         Scene SecondFrameScene = new Scene(SecondFrameParent);
         
         
         
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
          window.setTitle("PDF Scanner & Reader");
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
