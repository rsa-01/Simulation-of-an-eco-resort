/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Admin_Arpon;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RSA
 */
public class ViewGuestBookingController implements Initializable {

    @FXML
    private TableColumn<addBookingBin, String> vgbGuestNamefxid;
    @FXML
    private TableColumn<addBookingBin, String> vgbGuestMobileNumberfxid;
    @FXML
    private TableColumn<addBookingBin, String> vgbRoomNumberfxid;
    @FXML
    private TableColumn<addBookingBin, String> vgbReservationDatefxid;
    @FXML
    private TableView<addBookingBin> vgbTableViewfxml;
    
    ArrayList<addBookingBin> addbookingList;
    ObservableList<addBookingBin> tempList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addbookingList = new ArrayList <addBookingBin>();
        
        vgbGuestNamefxid.setCellValueFactory(new PropertyValueFactory<addBookingBin,String>("customerName"));
        vgbGuestMobileNumberfxid.setCellValueFactory(new PropertyValueFactory<addBookingBin,String>("customerNumber"));
        vgbReservationDatefxid.setCellValueFactory(new PropertyValueFactory<addBookingBin,String>("reservationDate"));
        vgbRoomNumberfxid.setCellValueFactory(new PropertyValueFactory<addBookingBin,String>("roomNmuber"));
        
       
        
    }
        private void loadaddBookingtFile() throws IOException {
        ObjectInputStream ois = null;
         {
            addBookingBin i;
            ois = new ObjectInputStream(new FileInputStream("addBooking.bin"));
            while(true){
                try {
                    addBookingBin ms = (addBookingBin) ois.readObject();
                    tempList.add(ms);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Class not Found");
                }
            }
            for(addBookingBin y : tempList){
                 vgbTableViewfxml.getItems().add(y);
             }
        }
        
  }

    

    @FXML
    private void addBookingOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("addBooking.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show(); 
    }


    @FXML
    private void cancelBookingOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("cancelBooking.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void backOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("mainAdmin.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
        
    }

    @FXML
    private void showOnClick(ActionEvent event) {
                ObjectInputStream ois = null;
        try{
            addBookingBin i;
            ois = new ObjectInputStream(new FileInputStream("addBooking.bin"));
            while(true){
                i = (addBookingBin) ois.readObject();
                vgbTableViewfxml.getItems().add(i);
            }
        }
        catch(Exception e){
            try{
                if(ois != null)
                    ois.close();
            }
            catch(IOException x){
                x.printStackTrace();
            }
            e.printStackTrace();
        }
    }
 }
    

