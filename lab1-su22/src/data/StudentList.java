/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author ihc
 */
public class StudentList extends ArrayList<Student>{

    public StudentList() {
    }

    @Override
    public String toString() {
       String s="";
        for(Student sub: this)s+=sub.toString()+"\n";
        return s;
    }



  
}
