/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ihc
 */
public class Student {

    String stID;
    String fName;
    String lName;
    boolean gender;
    Date bDate;
    String email;
    String phone;

    public Student(String stID) {
        this.stID = stID;
    }

    public Student(String stID, String fName, String lName, boolean gender, Date bDate, String email, String phone) {
        this.stID = stID;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.bDate = bDate;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj) {

        return stID.equals(((Student) obj).stID);
    }

    public String getStID() {
        return stID;
    }

    public void setStID(String stID) {
        this.stID = stID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "------------------------------------------------------------\n" + "ID=" + stID + ",FirstName=" + fName + ",LastName=" + lName + ",Gender=" + (gender == true ? "male " : "female ") + "\nDateOfBirth=" + (bDate.getDate()) + "/" + (bDate.getMonth() + 1) + "/" + (bDate.getYear() + 1900) + ",Email=" + email + ", Phone=" + phone + "\n------------------------------------------------------------";
    }

    public Student() {
    }

}
