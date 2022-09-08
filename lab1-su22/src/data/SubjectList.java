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
public class SubjectList extends ArrayList<Subject>{
    public SubjectList() {
        super();
    }

    @Override
    public String toString() {
        String s="";
        for(Subject sub: this)s+=sub.toString()+"\n";
        return s;
    }

    
    
}
