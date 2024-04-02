/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package simulationofanecoresort;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
/**
 * FXML Controller class
 *
 * @author RSA
 */
public class GuestBookingController implements Initializable {


    @FXML
    private TableColumn<?, ?> vgbGuestNamefxid;
    @FXML
    private TableColumn<?, ?> vgbGuestMobileNumberfxid;
    @FXML
    private TableColumn<?, ?> vgbRoomNumberfxid;
    @FXML
    private TableColumn<?, ?> vgbReservationDatefxid;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void addBookingOnClick(ActionEvent event) {
    }

    @FXML
    private void editBookingOnClick(ActionEvent event) {
    }

    @FXML
    private void cancelBookingOnClick(ActionEvent event) {
    }

    @FXML
    private void backOnClick(ActionEvent event) {
    }

}
