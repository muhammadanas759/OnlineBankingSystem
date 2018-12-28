//   final project
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.File;
import javafx.scene.input.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.KeyCode;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;


/**
 * FXML Controller class
 *
 * @author Hp
 */
public class ProfitController extends HeadOffice implements Initializable {

    /**
     * Initializes the controller class.
     */
    Trie t,ac,br,pn;
    public ProfitController() throws IOException{
this.t= new Trie("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\monthlyprofit\\title.txt");
this.br= new Trie("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\monthlyprofit\\branch_code.txt");
this.ac= new Trie("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\monthlyprofit\\account_number.txt");

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
    
    private String path2=path_monsaving;
    @FXML
    private Label depositamount;
  
        public List<String> com(String input){ //list for fetching strings from trie structure
        System.out.println("======= COM ======="); 
        List<String> list=t.autocomplete(input);
        System.out.println("======= last COM =======");
            return list;
}
    
    public void enter_title(){
title.setOnKeyPressed((KeyEvent event) -> {
    if(event.getCode().equals(KeyCode.ENTER)) {
        //if(event.getText().length()==1)
        System.out.println("entered in tree i.e "+title.getText());
        t.insert(title.getText());
// com(name.getText());
URL url = null;
ResourceBundle rb = null;
initialize(url, rb);
// do something
    }
});    

}
    ///////// acount number ////////////////
    public List<String> com_ac(String input){ //list for fetching strings from trie structure
        System.out.println("======= COM ======="); 
        List<String> list=ac.autocomplete(input);
        System.out.println("======= last COM =======");
            return list;
}
    public void action_ac_number(){
    System.out.println("   IN ACTION WORDS   ");
TextFields.bindAutoCompletion(acnumber,com_ac(acnumber.getText()));
}
public void enter_ac(){
if(acnumber.getText().length()==0){
action_ac_number();
}
}
    ///////// branch code ////////////////
    public List<String> com_br_code(String input){ //list for fetching strings from trie structure
        System.out.println("======= COM ======="); 
        List<String> list=br.autocomplete(input);
        System.out.println("======= last COM =======");
            return list;
}
    public void action_br_code(){
    System.out.println("   IN ACTION WORDS   ");
TextFields.bindAutoCompletion(brcode,com_br_code(brcode.getText()));
}
public void enter_br(){
if(brcode.getText().length()==0){
action_br_code();
}
}
//acnumber.setOnKeyPressed(new EventHandler<KeyEvent>() {
// 
//    public void handle(KeyEvent event) {
//        
//        if((event.getCode().isLetterKey()) && (acnumber.toString().length()==1)) {
//            System.out.println("event");
//System.out.println("entered in tree i.e "+title.getText());      
//t.insert(title.getText());
//// com(name.getText());
//URL url = null;
//ResourceBundle rb = null;
//            initialize(url, rb);
//// do something
//        }
//    }
//});    




@Override

    public void initialize(URL url, ResourceBundle rb) {
       System.out.println("........INTIALIZE.........");
       TextFields.bindAutoCompletion(title,com(title.getText()));
       System.out.println("........ last INTIALIZE.........");
       Object ex = null;
       Logger.getLogger(New1Controller.class.getName()).log(Level.SEVERE, null, ex);
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
           
        }
        else{
        System.out.println(" else");
        File f1=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\monthlyprofit\\title.txt");
        File f2=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\monthlyprofit\\branch_code.txt");
        File f3=new File("C:\\Users\\muhammad anas\\Documents\\NetBeansProjects\\DS_project\\src\\txt_files\\monthlyprofit\\account_number.txt");
        filing(f1,title);
        filing(f2,brcode);
        filing(f3,acnumber);
        }

        try {
            readBalance(title.getText(), Double.parseDouble(acnumber.getText()), Double.parseDouble(brcode.getText()), pin.getText(), path2);
        } catch (IOException ex) {
            System.out.println("IOException");
        }
        if (bal1.equals("0")) {
            check.setText("Incorrect Information");
        } else {
            String split[] = date1.split(",");
            if (Double.parseDouble(split[0]) >= day && Double.parseDouble(split[2]) > year){
                profit = (Double.parseDouble(bal1) / 100000) * 400;
                check.setText(Double.toString(profit));
                try {
                    updateDate(title.getText(), Double.parseDouble(acnumber.getText()), Double.parseDouble(brcode.getText()), pin.getText(), path2);
                } catch (FileNotFoundException a) {
                    System.out.println("File Not Found");
                } catch (IOException ex) {
                    Logger.getLogger(ProfitController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Double.parseDouble(split[0]) >= day && Double.parseDouble(split[2]) == year && Double.parseDouble(split[1]) > month){
                profit = (Double.parseDouble(bal1) / 100000) * 400;
                check.setText(Double.toString(profit));
                try {
                    updateDate(title.getText(), Double.parseDouble(acnumber.getText()), Double.parseDouble(brcode.getText()), pin.getText(), path2);
                } catch (FileNotFoundException a) {
                    System.out.println("File Not Found");
                } catch (IOException ex) {
                    Logger.getLogger(ProfitController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {check.setText("Date doesn't exceeded");
                       depositamount.setText(bal1);
            }
        }
    }
    
    @FXML
    void back(ActionEvent event) throws IOException{
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
}