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
public class Transcript {

    Subject sub;
    Student st;
    Double labMark;
    Double testMark;
    Double finalMark;

    public Transcript(Subject sub, Student st, Double labMark, Double testMark, Double finalMark) {
        this.sub = sub;
        this.st = st;
        this.labMark = labMark;
        this.testMark = testMark;
        this.finalMark = finalMark;
    }

    public Transcript() {
    }

    public Transcript(Subject sub) {
        this.sub = sub;
    }

    public Transcript(Double labMark) {
        this.labMark = labMark;
    }

    public Transcript(Student st) {
        this.st = st;
    }
    public double average() {
        return 0.3 * labMark + 0.3 * testMark + 0.4 * finalMark;
    }
    public String truefalse(){
        String a;
        if ( this.average()>4) {
            a="Pass";
        } else {
            a="Not Pass";
        }
       return a;
    }

    public Transcript(Subject sub, Student st) {
        this.sub = sub;
        this.st = st;
    }

    public Subject getSub() {
        return sub;
    }

    public void setSub(Subject sub) {
        this.sub = sub;
    }

    public Student getSt() {
        return st;
    }

    public void setSt(Student st) {
        this.st = st;
    }

    public Double getLabMark() {
        return labMark;
    }

    public void setLabMark(Double labMark) {
        this.labMark = labMark;
    }

    public Double getTestMark() {
        return testMark;
    }

    public void setTestMark(Double testMark) {
        this.testMark = testMark;
    }

    public Double getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(Double finalMark) {
        this.finalMark = finalMark;
    }


 

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        Transcript t = (Transcript) obj;
        return this.st == t.st && this.sub == t.sub;
    }

    @Override
    public String toString() {
        return st + "\n" + sub + "\n" +"labMark"+ labMark + ", testMark=" + testMark + ", finalMark=" + finalMark;
    }

}
