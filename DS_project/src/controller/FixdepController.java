/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class FixdepController extends HeadOffice implements Initializable {

    /**
     * Initializes the controller class.
     */
    Trie t,ac,br;
    public FixdepController() throws IOException{
this.t= new Trie("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\fixed deposit\\title.txt");
this.br= new Trie("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\fixed deposit\\branch_code.txt");
this.ac= new Trie("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\fixed deposit\\account_number.txt");

   }
    @FXML
    private TextField brcode;

    @FXML
    private TextField acnumber;

    @FXML
    private TextField title;
    
    @FXML
    private PasswordField pin;

    @FXML
    private Label check;
    
    @FXML
    private Button back;
    
    private String path2=path_fixdep;
    
    private double date2;
    @FXML
    private Label depositamount;
    
   public List<String> com_common(String input,Trie tr){   
         List<String> list=tr.autocomplete(input);
         return list;}
    public void action_common(TextField tf,Trie tr){
TextFields.bindAutoCompletion(tf,com_common(tf.getText(),tr));
    }
public void enter_title(){
if(title.getText().length()==0){
    action_common(title,t);
}
}
public void enter_account(){
if(acnumber.getText().length()==0){
    action_common(acnumber,ac);
}
}
public void enter_br(){
if(brcode.getText().length()==0){
    action_common(brcode,br);
}
}
public void filing(File f,TextField tf) throws IOException{
    
    System.out.println("       filing          ");
        FileWriter fstream = new FileWriter(f, true);
        BufferedWriter out = new BufferedWriter(fstream);
        out.newLine();   
        out.write(tf.getText());
        out.close(); 
        }

    
    @FXML
    void submit(ActionEvent event) throws IOException {
        if(title.getText().isEmpty() || acnumber.getText().isEmpty() || brcode.getText().isEmpty() ){
            System.out.println(" not write in files ");
           // check1.setText("CHECK ALL FIELDS AGAIN");
        }
        else{
            System.out.println(" else");
        File f1=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\fixed deposit\\title.txt");
        File f2=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\fixed deposit\\branch_code.txt");
        File f3=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\fixed deposit\\account_number.txt");
        filing(f1,title);
        filing(f2,brcode);
        filing(f3,acnumber);
        }
 
        
        
        
        
        
        
        try {
            readBalance(title.getText(), Double.parseDouble(acnumber.getText()), Double.parseDouble(brcode.getText()), pin.getText(), path2);
        } catch (IOException ex) {
            Logger.getLogger(ChbalanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (bal1.equals("0")) {
            check.setText("Incorrect Information");
        } else {
            date2 = year + period1;
            String split[] = date1.split(",");
            if (Double.parseDouble(split[2]) > date2){
                check.setText(Double.toString(amount));
            } else if ((Double.parseDouble(split[2]) == date2) && (Double.parseDouble(split[1]) > month)){
                check.setText(Double.toString(amount));
            } else if ((Double.parseDouble(split[2]) == date2) && (Double.parseDouble(split[1]) == month) && (Double.parseDouble(split[0]) >= day)){
                check.setText(Double.toString(amount));
            } else {check.setText("Date doesn't exceeded");
                    depositamount.setText(Double.toString(Double.parseDouble(bal1)));
            }
        }
    }
    
    @FXML
    void back(ActionEvent event) throws IOException {
        Parent SecondFrameParent = FXMLLoader.load(getClass().getResource("/view/Others.fxml"));
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    
    
}
