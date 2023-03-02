
package Students_Result;

/**
 *
 * @author Scott B Amira
 */
public class StudentBean {
private int StudentID;
private String FirstName;
private String LastName;
private int Maths;
private int English;
private int Science;
private int Social_Science;
private int MAL;
private int Health_PE;
private int Arts;
private int Total_Score;
private int Average;
private int GPA;
private String Grade;

public StudentBean(int Student_ID, String FirstName, String LastName, int Maths,
        int English, int Science, int Social_Science, int MAL, int Health_PE,
        int Arts, int Total_Score, int Average, int GPA, String Grade){
    
    this.StudentID=Student_ID;
    this.FirstName=FirstName;
    this.LastName=LastName;
    this.Maths=Maths;
    this.English=English;
    this.Science=Science;
    this.Social_Science=Social_Science;
    this.MAL=MAL;
    this.Health_PE=Health_PE;
    this.Arts=Arts;
    this.Total_Score=Total_Score;
    this.Average=Average;
    this.GPA=GPA;
    this.Grade=Grade;
 }

    public int getStudent_ID() {
        return StudentID;
    }

    public void setStudent_ID(int Student_ID) {
        this.StudentID = Student_ID;
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

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int English) {
        this.English = English;
    }

    public int getScience() {
        return Science;
    }

    public void setScience(int Science) {
        this.Science = Science;
    }

    public int getSocial_Science() {
        return Social_Science;
    }

    public void setSocial_Science(int Social_Science) {
        this.Social_Science = Social_Science;
    }

    public int getMAL() {
        return MAL;
    }

    public void setMAL(int MAL) {
        this.MAL = MAL;
    }

    public int getHealth_PE() {
        return Health_PE;
    }

    public void setHealth_PE(int Health_PE) {
        this.Health_PE = Health_PE;
    }

    public int getArts() {
        return Arts;
    }

    public void setArts(int Arts) {
        this.Arts = Arts;
    }

    public int getTotal_Score() {
        return Total_Score;
    }

    public void setTotal_Score(int Total_Score) {
        this.Total_Score = Total_Score;
    }

   public int getAverage() {
        return Average;
    }

    public void setAverage(int Average) {
        this.Average = Average;
    }
    
     public int getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }
    
     public String getGrade() {
        return Grade;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

}
