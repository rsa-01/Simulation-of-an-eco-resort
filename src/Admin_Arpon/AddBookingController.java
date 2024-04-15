/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Admin_Arpon;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RSA
 */
public class AddBookingController implements Initializable {

    @FXML
    private TextField customerNamefxid;
    @FXML
    private TextField customerNumberfxid;
    @FXML
    private TextField reservationDatefxid;
    @FXML
    private ComboBox<String> roomNmuberfxid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        roomNmuberfxid.getItems().addAll("1001", "1002", "1003", "1004",
                "1005","2001", "2002", "2003","2004","2005",
                "3001", "3002", "3003", "3004","3005");
        
    }    

    @FXML
    private void doneBookingOnClick(ActionEvent event) {
    File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            f = new File("addBooking.bin");
            if(f.exists()){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            addBookingBin d = new addBookingBin(customerNamefxid.getText(), 
                    customerNumberfxid.getText(),reservationDatefxid.getText(), 
                    roomNmuberfxid.getValue());

            oos.writeObject(d);

            customerNamefxid.clear();customerNumberfxid.clear(); 
            reservationDatefxid.clear();roomNmuberfxid.getSelectionModel().clearSelection();
            
            
            fos.close();
            oos.close();
            
        }
        catch(IOException e){
            Logger.getLogger(AddBookingController.class.getName()).log(Level.SEVERE, null, e);
    
        }
        finally{
            try{
                if(oos != null) oos.close();
            }
            catch(IOException e){
                Logger.getLogger(AddBookingController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    
    }    
        
    

    @FXML
    private void backOnClick(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("viewGuestBooking.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
    
}
