 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin_Arpon;

import java.io.Serializable;

/**
 *
 * @author RSA
 */
public class addBookingBin implements Serializable{
    private String customerName;
    private String customerNumber;
    private String reservationDate;
    private String roomNmuber;

    public addBookingBin(String customerName, String customerNumber, String reservationDate, String roomNmuber) {
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.reservationDate = reservationDate;
        this.roomNmuber = roomNmuber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getRoomNmuber() {
        return roomNmuber;
    }

    public void setRoomNmuber(String roomNmuber) {
        this.roomNmuber = roomNmuber;
    }

   
}
