
package studentrecordapp;

/**
 *
 * @author HP User
 */
public class EnglishBean {
private int Student_ID;
private String FirstName;
private String LastName;
private int English;
private int ET1;
private int ET2;
private int ET3;
private int EA1;
private int EA2;
private int EA3;
private int EA4;

    
public EnglishBean(int Student_ID, String FirstName, String LastName, int English,
        int ET1, int ET2, int ET3, int EA1,int EA2, int EA3, int EA4){
    
    this.Student_ID=Student_ID;
    this.FirstName=FirstName;
    this.LastName=LastName;
    this.English=English;
    this.ET1=ET1;
    this.ET2=ET2;
    this.ET3=ET3;
    this.EA1=EA1;
    this.EA2=EA2;
    this.EA3=EA3;
    this.EA4=EA4;
      
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

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int English) {
        this.English = English;
    }

    public int getET1() {
        return ET1;
    }

    public void setET1(int ET1) {
        this.ET1 = ET1;
    }

    public int getET2() {
        return ET2;
    }

    public void setET2(int ET2) {
        this.ET2 = ET2;
    }

    public int getET3() {
        return ET3;
    }

    public void setET3(int ET3) {
        this.ET3 = ET3;
    }

    public int getEA1() {
        return EA1;
    }

    public void setEA1(int EA1) {
        this.EA1 = EA1;
    }

    public int getEA2() {
        return EA2;
    }

    public void setEA2(int EA2) {
        this.EA2 = EA2;
    }

    public int getEA3() {
        return EA3;
    }

    public void setEA3(int EA3) {
        this.EA3 = EA3;
    }
    public int getEA4(){
        return EA4;
    }
    public void setEA4(int EA4){
        this.EA4=EA4;
    }

       
}
