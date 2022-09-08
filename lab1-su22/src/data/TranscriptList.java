/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author ihc
 */
public class TranscriptList extends ArrayList<Transcript>{

    public TranscriptList() {
        super();
    }
    public boolean containsSubject(String subID){
        for (Transcript t:this){
            if (t.sub.subID.equals(subID))return true;
        }
        return false;
        
    }
    public boolean containsStudent(String stID){
        for (Transcript t:this){
            if (t.st.stID.equals(stID)) return true;
        }
        return false;
    }
    
}
