/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.Objects;

/**
 *
 * @author ihc
 */
public class Subject {

    String subID;
    String subName;
    int credit;

    public Subject(String subID, String subName, int credit) {
        this.subID = subID;
        this.subName = subName;
        this.credit = credit;
    }

    public Subject(String subID) {
        this.subID = subID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return subID.equals(((Subject) obj).subID);
    }

    @Override
    public String toString() {
        return "subID=" + subID + ", subName=" + subName + ", credit=" + credit ;
    }

    public String getSubID() {
        return subID;
    }

    public void setSubID(String subID) {
        this.subID = subID;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if (credit > 0) {
            this.credit = credit;
        }
    }

}
