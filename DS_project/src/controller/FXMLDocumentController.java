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
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Hp
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private Button admin;
    
    @FXML
    private Button button;
    
    @FXML
    private Button exit;

    @FXML
    void handleAdminAction(ActionEvent event) throws IOException {
        Parent SecondFrameParent = FXMLLoader.load(getClass().getResource("/view/admin.fxml"));
         Scene SecondFrameScene = new Scene(SecondFrameParent);
        
         
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
         window.setTitle("PDF Scanner");
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
    private void handleButtonAction(ActionEvent event) throws IOException {
        Parent SecondFrameParent = FXMLLoader.load(getClass().getResource("/view/service.fxml"));
         Scene SecondFrameScene = new Scene(SecondFrameParent);
        
         
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
         window.setTitle("PDF Scanner");
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
    void exit(ActionEvent event) {
        Stage stage=(Stage) exit.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
