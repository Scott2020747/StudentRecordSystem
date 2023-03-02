/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentrecordapp;

/**
 *
 * @author HP User
 */
public class MathsBean {
    
private int Student_ID;
private String FirstName;
private String LastName;
private int Maths;
private int MT1;
private int MT2;
private int MT3;
private int MA1;
private int MA2;
private int MA3;
private int MA4;

public MathsBean(int Student_ID, String FirstName, String LastName, int Maths,
        int MT1, int MT2, int MT3, int MA1,int MA2, int MA3, int MA4){
    
    this.Student_ID=Student_ID;
    this.FirstName=FirstName;
    this.LastName=LastName;
    this.Maths=Maths;
    this.MT1=MT1;
    this.MT2=MT2;
    this.MT3=MT3;
    this.MA1=MA1;
    this.MA2=MA2;
    this.MA3=MA3;
    this.MA4=MA4;
      
}
 public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int Student_ID) {
        this.Student_ID = Student_ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public int getMaths() {
        return Maths;
    }

    public void setMaths(int Maths) {
        this.Maths = Maths;
    }

    public int getMT1() {
        return MT1;
    }

    public void setMT1(int MT1) {
        this.MT1 = MT1;
    }

    public int getMT2() {
        return MT2;
    }

    public void setMT2(int MT2) {
        this.MT2 = MT2;
    }

    public int getMT3() {
        return MT3;
    }

    public void setMT3(int MT3) {
        this.MT3 = MT3;
    }

    public int getMA1() {
        return MA1;
    }

    public void setMA1(int MA1) {
        this.MA1 = MA1;
    }

    public int getMA2() {
        return MA2;
    }

    public void setMA2(int MA2) {
        this.MA2 = MA2;
    }

    public int getMA3() {
        return MA3;
    }

    public void setMA3(int MA3) {
        this.MA3 = MA3;
    }
    public int getMA4(){
        return MA4;
    }
    public void setMA4(int MA4){
        this.MA4=MA4;
    }

    
}
