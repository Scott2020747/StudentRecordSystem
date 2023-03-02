/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentrecordapp;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 *
 * @author HP User
 */
public class Grade8internal extends javax.swing.JFrame {

    /**
     * Creates new form Grade8internal
     */
    public Grade8internal() {
        initComponents();
        fillTable();
        
    }
    
     public Connection MySqlConnection(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/studentrecord",
                    "root", "sTud397r3*d");
            //JOptionPane.showMessageDialog(null, "MySQL Connection successful");
            return conn;
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "MySQL Connection failed");
        return null;
    }
    }
    
    
     //Show or Add the data to the jTable
    public ArrayList<StudentBean2> retrieveData(){
        ArrayList<StudentBean2> al=null;
        al=new ArrayList<StudentBean2>();
        try{
            Connection conn=MySqlConnection();
            String q="SELECT * FROM g8internal WHERE YEAR(g8internal.created_at)=YEAR(CURDATE())";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(q);
            StudentBean2 student;
            while (rs.next()){
            student=new StudentBean2(rs.getInt(1), rs.getString("FirstName"),
                rs.getString("LastName"), rs.getInt(13), rs.getInt(4)
                , rs.getInt(22), rs.getInt(31), rs.getInt(40), rs.getInt(49)
                , rs.getInt(58), rs.getInt(67), rs.getInt(69), rs.getInt(70)
                , rs.getString("Grade"));
                al.add(student);
                
                
            }
                
            }catch (Exception e){
                System.out.println("Error in retrieveData method: "+e);
            }
        return al;
    }
     //show all data to jTable ( fill the table)
   public void fillTable(){
        ArrayList<StudentBean2> al=retrieveData();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0); //Empty ( clear the table)
        
        Object[] row=new Object[140];
        for (int i = 0; i < al.size(); i++){
            row[0]=al.get(i).getStudent_ID();
            row[1]=al.get(i).getFirstName();
            row[2]=al.get(i).getLastName();
            row[3]=al.get(i).getMaths();
            row[4]=al.get(i).getEnglish();
            row[5]=al.get(i).getScience();
            row[6]=al.get(i).getSocial_Science();
            row[7]=al.get(i).getMAL();
            row[8]=al.get(i).getHealth_PE();
            row[9]=al.get(i).getArts();
            row[10]=al.get(i).getTotal_Score();
            row[11]=al.get(i).getAverage();
            //row[12]=al.get(i).getGPA();
            //row[13]=al.get(i).getGrade();
            model.addRow(row);
    }
    }
    
      
    //show item/data to fields
    public void ShowItemToFields(int index){
        jtxtStudent.setText(Integer.toString(retrieveData().get(index).getStudent_ID()));
        jtxtFirstname.setText(retrieveData().get(index).getFirstName());
        jtxtSurname.setText(retrieveData().get(index).getLastName());
        jtxtMaths.setText(Integer.toString(retrieveData().get(index).getMaths()));
        jtxtEnglish.setText(Integer.toString(retrieveData().get(index).getEnglish()));
        jtxtScience.setText(Integer.toString(retrieveData().get(index).getScience()));
        jtxtSocialScience.setText(Integer.toString(retrieveData().get(index).getSocial_Science()));
        jtxtMAL.setText(Integer.toString(retrieveData().get(index).getMAL()));
        jtxtHPE.setText(Integer.toString(retrieveData().get(index).getHealth_PE()));
        jtxtArts.setText(Integer.toString(retrieveData().get(index).getArts()));
        jtxtTotalScore.setText(Integer.toString(retrieveData().get(index).getTotal_Score()));
        jtxtAverage.setText(Integer.toString(retrieveData().get(index).getAverage()));
        
              
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jtxtFirstname = new javax.swing.JTextField();
        jtxtStudent = new javax.swing.JTextField();
        jtxtMaths = new javax.swing.JTextField();
        jtxtEnglish = new javax.swing.JTextField();
        jtxtScience = new javax.swing.JTextField();
        jtxtSocialScience = new javax.swing.JTextField();
        jtxtMAL = new javax.swing.JTextField();
        jtxtHPE = new javax.swing.JTextField();
        jtxtArts = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jcmbGrade = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jButton_Maths = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtTotalScore = new javax.swing.JTextField();
        jtxtAverage = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxtSurname = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton_Science = new javax.swing.JButton();
        jButton_SocialScience = new javax.swing.JButton();
        jButton_MAL = new javax.swing.JButton();
        jButton_HPE = new javax.swing.JButton();
        jButton_Arts = new javax.swing.JButton();
        jButton_English = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtxtTranscript = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton_update = new javax.swing.JButton();
        jbtnTranscripts = new javax.swing.JButton();
        jbtnReset = new javax.swing.JButton();
        jbtnRefresh = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jbtnAddRecord = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jtxtSearch = new javax.swing.JTextField();
        jButton_print = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();
        jbtn8Internal = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), null), "Grade 8 Internal Assessments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 255, 0))); // NOI18N

        jtxtFirstname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtxtStudent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtStudentActionPerformed(evt);
            }
        });

        jtxtMaths.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtMaths.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtMathsKeyTyped(evt);
            }
        });

        jtxtEnglish.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtEnglish.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtEnglishKeyTyped(evt);
            }
        });

        jtxtScience.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtScience.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtScienceKeyTyped(evt);
            }
        });

        jtxtSocialScience.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtSocialScience.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtSocialScienceKeyTyped(evt);
            }
        });

        jtxtMAL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtMAL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtMALKeyTyped(evt);
            }
        });

        jtxtHPE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtHPE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtHPEKeyTyped(evt);
            }
        });

        jtxtArts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtArts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtArtsKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("S/Science:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("MAL:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Class Grade");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Health/PE:");

        jcmbGrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grade3", "Grade4", "Grade5", "Grade6", "Grade7", "Grade8" }));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Arts:");

        jButton_Maths.setText("Maths:");
        jButton_Maths.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MathsActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Total Score:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Average:");

        jtxtTotalScore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtxtAverage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtAverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtAverageActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Student ID:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Firstname:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Surname:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Maths:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("English:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Science:");

        jtxtSurname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton_Science.setText("Science");
        jButton_Science.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ScienceActionPerformed(evt);
            }
        });

        jButton_SocialScience.setText("S/Science");
        jButton_SocialScience.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SocialScienceActionPerformed(evt);
            }
        });

        jButton_MAL.setText("MAL");
        jButton_MAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MALActionPerformed(evt);
            }
        });

        jButton_HPE.setText("Health/PE");
        jButton_HPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HPEActionPerformed(evt);
            }
        });

        jButton_Arts.setText("Arts");
        jButton_Arts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ArtsActionPerformed(evt);
            }
        });

        jButton_English.setText("English");
        jButton_English.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EnglishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcmbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtxtTotalScore)
                                .addComponent(jtxtAverage)
                                .addComponent(jtxtFirstname)
                                .addComponent(jtxtSurname)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jtxtStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtHPE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(jtxtMAL, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtSocialScience, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtScience)
                            .addComponent(jtxtArts)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtEnglish)
                            .addComponent(jtxtMaths))))
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton_Science, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Maths, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_SocialScience, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_HPE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_MAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Arts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton_English, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtxtStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtxtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtxtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jcmbGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtxtTotalScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtxtAverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtxtMaths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Maths))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtxtEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_English))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jtxtScience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Science))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jtxtSocialScience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_SocialScience))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jtxtMAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_MAL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jtxtHPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_HPE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jtxtArts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Arts))))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(0, 67, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), null), "Results", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 255, 0))); // NOI18N

        jScrollPane3.setViewportView(jtxtTranscript);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "StudentID", "FirstName", "LastName", "Maths", "English", "Science ", "Social Science", "Making A Living", "Health PE", "Arts", "Total Score", "Average", "GPA", "Grade"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton_update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_update.setText("Update");
        jButton_update.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jbtnTranscripts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnTranscripts.setText("Transcripts");
        jbtnTranscripts.setPreferredSize(new java.awt.Dimension(67, 23));
        jbtnTranscripts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTranscriptsActionPerformed(evt);
            }
        });

        jbtnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnReset.setText("Reset");
        jbtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnResetActionPerformed(evt);
            }
        });

        jbtnRefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnRefresh.setText("Refresh");
        jbtnRefresh.setPreferredSize(new java.awt.Dimension(67, 23));
        jbtnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRefreshActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(0, 102, 102));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("SEARCH:");

        jbtnAddRecord.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnAddRecord.setText("Add Record");
        jbtnAddRecord.setPreferredSize(new java.awt.Dimension(67, 23));
        jbtnAddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddRecordActionPerformed(evt);
            }
        });

        jButton_delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_delete.setText("DELETE");
        jButton_delete.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });

        jtxtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtSearchActionPerformed(evt);
            }
        });
        jtxtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtSearchKeyTyped(evt);
            }
        });

        jButton_print.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_print.setText("Print");
        jButton_print.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_printActionPerformed(evt);
            }
        });

        jbtnExit.setBackground(new java.awt.Color(255, 255, 255));
        jbtnExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnExit.setText("Exit");
        jbtnExit.setPreferredSize(new java.awt.Dimension(67, 23));
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });

        jbtn8Internal.setText("Gr 8 internals");
        jbtn8Internal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn8InternalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn8Internal)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jbtnTranscripts, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jbtnAddRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_print, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnTranscripts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnReset)
                    .addComponent(jbtnAddRecord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_print, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jbtn8Internal)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtStudentActionPerformed

    private void jtxtMathsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtMathsKeyTyped
        // code to prevent user from entering any other data type other than int
        char iNumber = evt.getKeyChar();
        if(!(Character.isDigit(iNumber))
            ||(iNumber == KeyEvent.VK_BACK_SPACE)
            ||(iNumber == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_jtxtMathsKeyTyped

    private void jtxtEnglishKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtEnglishKeyTyped
        // code to prevent user from entering any other data type other than int
        char iNumber = evt.getKeyChar();
        if(!(Character.isDigit(iNumber))
            ||(iNumber == KeyEvent.VK_BACK_SPACE)
            ||(iNumber == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_jtxtEnglishKeyTyped

    private void jtxtScienceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtScienceKeyTyped
        // code to prevent user from entering any other data type other than int
        char iNumber = evt.getKeyChar();
        if(!(Character.isDigit(iNumber))
            ||(iNumber == KeyEvent.VK_BACK_SPACE)
            ||(iNumber == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_jtxtScienceKeyTyped

    private void jtxtSocialScienceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSocialScienceKeyTyped
        // code to prevent user from entering any other data type other than int
        char iNumber = evt.getKeyChar();
        if(!(Character.isDigit(iNumber))
            ||(iNumber == KeyEvent.VK_BACK_SPACE)
            ||(iNumber == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_jtxtSocialScienceKeyTyped

    private void jtxtMALKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtMALKeyTyped
        // code to prevent user from entering any other data type other than int
        char iNumber = evt.getKeyChar();
        if(!(Character.isDigit(iNumber))
            ||(iNumber == KeyEvent.VK_BACK_SPACE)
            ||(iNumber == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_jtxtMALKeyTyped

    private void jtxtHPEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtHPEKeyTyped
        // code to prevent user from entering any other data type other than int
        char iNumber = evt.getKeyChar();
        if(!(Character.isDigit(iNumber))
            ||(iNumber == KeyEvent.VK_BACK_SPACE)
            ||(iNumber == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_jtxtHPEKeyTyped

    private void jtxtArtsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtArtsKeyTyped
        // code to prevent user from entering any other data type other than int
        char iNumber = evt.getKeyChar();
        if(!(Character.isDigit(iNumber))
            ||(iNumber == KeyEvent.VK_BACK_SPACE)
            ||(iNumber == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_jtxtArtsKeyTyped

    private void jButton_MathsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MathsActionPerformed
        // brings window to add Maths scores
        try {
            new MathJFrame().setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton_MathsActionPerformed

    private void jtxtAverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtAverageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtAverageActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // add all marks to give total score
        double[] R = new double[14];
        R[0] = Double.parseDouble(jtxtMaths.getText());
        R[1] = Double.parseDouble(jtxtEnglish.getText());
        R[2] = Double.parseDouble(jtxtScience.getText());
        R[3] = Double.parseDouble(jtxtSocialScience.getText());
        R[4] = Double.parseDouble(jtxtMAL.getText());
        R[5] = Double.parseDouble(jtxtHPE.getText());
        R[6] = Double.parseDouble(jtxtArts.getText());

        R[8] = (R[0] + R[1] + R[2] + R[3] + R[4] + R[5] + R[6]) / 7;
        R[9] = (R[0] + R[1] + R[2] + R[3] + R[4] + R[5] + R[6]);

        String Average = String.format("%.0f", R[8]);
        jtxtAverage.setText(Average);

        String TotalScore = String.format("%.0f", R[9]);
        jtxtTotalScore.setText(TotalScore);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton_ScienceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ScienceActionPerformed
        // brings window to add Science scores
        try {
            new ScienceJFrame().setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton_ScienceActionPerformed

    private void jButton_SocialScienceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SocialScienceActionPerformed
        // code to bring the menu for social science
        try{
            new SocialScienceJFrame().setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton_SocialScienceActionPerformed

    private void jButton_MALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MALActionPerformed
        // brings up the MAL menu to enter marks
        try{
            new MALJFrame().setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton_MALActionPerformed

    private void jButton_HPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HPEActionPerformed
        // brings up HPE GUI to add marks
        try{
            new HPEJFrame().setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_jButton_HPEActionPerformed

    private void jButton_ArtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ArtsActionPerformed
        // Brings up Arts menu to enter scores
        try{
            new ArtsJFrame().setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton_ArtsActionPerformed

    private void jButton_EnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EnglishActionPerformed
        // brings up English menu for entering marks
        try{
            new EnglishJFrame2().setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton_EnglishActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // Shows selected table row onto Panel area
        int ind=jTable1.getSelectedRow();
        ShowItemToFields(ind);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // Shows selected table row onto Panel area
        int ind=jTable1.getSelectedRow();
        ShowItemToFields(ind);
    }//GEN-LAST:event_jTable1MousePressed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // Shows selected table row onto Panel area
        int ind=jTable1.getSelectedRow();
        ShowItemToFields(ind);
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        String qry=null;
        PreparedStatement ps,ps2,ps3=null;
        Connection conn=MySqlConnection();

        if(jtxtStudent!=null && jtxtFirstname!=null && jtxtSurname!=null
            && jtxtMaths!=null || jtxtEnglish!=null || jtxtScience!=null
            || jtxtSocialScience!=null|| jtxtMAL!=null|| jtxtHPE!=null){

            try{

                //delete  record in overall table
          /*      ps2=null;
                ps2 = conn.prepareStatement("update overall o inner join\n" +
                    "(\n" +
                    "SELECT op.StudentID, \n" +
                    "       sum(ot.Total_Score) as Total_Score_ot,\n" +
                    "       sum(ot.English) as English_ot,\n" +
                    "       sum(ot.Maths) as Maths_ot,\n" +
                    "       sum(ot.Science) as Science_ot,\n" +
                    "       sum(ot.Social_Science) as Social_Science_ot,\n" +
                    "       sum(ot.MAL) as MAL_ot,\n" +
                    "       sum(ot.HPE) as HPE_ot,\n" +
                    "       sum(ot.Arts) as Arts_ot,\n" +
                    "       sum(op.Total_Score) as Total_Score_op,\n" +
                    "       sum(op.English) as English_op,\n" +
                    "       sum(op.Maths) as Maths_op,\n" +
                    "       sum(op.Science) as Science_op,\n" +
                    "       sum(op.Social_Science) as Social_Science_op,\n" +
                    "       sum(op.MAL) as MAL_op,\n" +
                    "       sum(op.HPE) as HPE_op,\n" +
                    "       sum(op.Arts) as Arts_op\n" +
                    "FROM g8internal ot inner join overall op on op.StudentID = ot.StudentID \n" +
                    "GROUP BY op.StudentID\n" +
                    ") as o1 on o.StudentID = o1.StudentID\n" +
                    "SET Total_Score=Total_Score_op - Total_Score_ot,\n" +
                    " English=English_op - English_ot,\n" +
                    " Maths=Maths_op - Maths_ot,\n" +
                    " Science=Science_op - Science_ot,\n" +
                    " Social_Science=Social_Science_op - Social_Science_ot,\n" +
                    " MAL=MAL_op - MAL_ot,\n" +
                    " HPE=HPE_op - HPE_ot,\n" +
                    " Arts=Arts_op - Arts_ot\n" +
                    "    \n" +
                    "   \n" +
                    "    ");

                int res2=ps2.executeUpdate();  */

                //execute update on updated value in db
                qry="update g8internal set FirstName=?, LastName=?, Maths=? "
                + ", English=?, Science=?, Social_Science=?,"
                + "MAL=?, HPE=?, Arts=?,"
                + "Total_Score=?, Average=?"
                + " where StudentID=?";
                ps=conn.prepareStatement(qry);
                ps.setString(1, jtxtFirstname.getText());
                ps.setString(2, jtxtSurname.getText());
                ps.setInt(3, Integer.parseInt(jtxtMaths.getText()));
                ps.setInt(4, Integer.parseInt(jtxtEnglish.getText()));
                ps.setInt(5, Integer.parseInt(jtxtScience.getText()));
                ps.setInt(6, Integer.parseInt(jtxtSocialScience.getText()));
                ps.setInt(7, Integer.parseInt(jtxtMAL.getText()));
                ps.setInt(8, Integer.parseInt(jtxtHPE.getText()));
                ps.setInt(9, Integer.parseInt(jtxtArts.getText()));
                ps.setInt(10, Integer.parseInt(jtxtTotalScore.getText()));
                ps.setInt(11, Integer.parseInt(jtxtAverage.getText()));
                //ps.setString(12, jtxtRanking.getText());
                ps.setInt(12, Integer.parseInt(jtxtStudent.getText()));

                int res=ps.executeUpdate();
                if(res>=1){
                    JOptionPane.showMessageDialog(null, res+" Number of students"
                        +" updated successfully...");
                }else
                JOptionPane.showMessageDialog(null, " Student updation fail...");

                //update record to overall table
            /*    ps3=null;
                ps3 = conn.prepareStatement("update overall o inner join\n" +
                    "(\n" +
                    "SELECT op.StudentID, \n" +
                    "       sum(ot.Total_Score) as Total_Score_ot,\n" +
                    "       sum(ot.English) as English_ot,\n" +
                    "       sum(ot.Maths) as Maths_ot,\n" +
                    "       sum(ot.Science) as Science_ot,\n" +
                    "       sum(ot.Social_Science) as Social_Science_ot,\n" +
                    "       sum(ot.MAL) as MAL_ot,\n" +
                    "       sum(ot.HPE) as HPE_ot,\n" +
                    "       sum(ot.Arts) as Arts_ot,\n" +
                    "       sum(op.Total_Score) as Total_Score_op,\n" +
                    "       sum(op.English) as English_op,\n" +
                    "       sum(op.Maths) as Maths_op,\n" +
                    "       sum(op.Science) as Science_op,\n" +
                    "       sum(op.Social_Science) as Social_Science_op,\n" +
                    "       sum(op.MAL) as MAL_op,\n" +
                    "       sum(op.HPE) as HPE_op,\n" +
                    "       sum(op.Arts) as Arts_op\n" +
                    "FROM g8internal ot inner join overall op on op.StudentID = ot.StudentID \n" +
                    "GROUP BY op.StudentID\n" +
                    ") as o1 on o.StudentID = o1.StudentID\n" +
                    "SET Total_Score=Total_Score_op+Total_Score_ot,\n" +
                    " English=English_op+English_ot,\n" +
                    " Maths=Maths_op+Maths_ot,\n" +
                    " Science=Science_op+Science_ot,\n" +
                    " Social_Science=Social_Science_op+Social_Science_ot,\n" +
                    " MAL=MAL_op+MAL_ot,\n" +
                    " HPE=HPE_op+HPE_ot,\n" +
                    " Arts=Arts_op+Arts_ot\n" +
                    "    \n" +
                    "   \n" +
                    "    ");

                int res3=ps3.executeUpdate();
                if (res3>=1){
                    JOptionPane.showMessageDialog(null, res+" Number of student updated in Grade internal assessment"
                        + " in database");
                }else
                JOptionPane.showMessageDialog(null, "Student updation failed");   */

            }catch(Exception e){
                JOptionPane.showMessageDialog(null," Fill out all boxes for student name, ID & marks!\n"+e);
            }
            jtxtFirstname.setText("");
            jtxtSurname.setText("");
            jtxtMaths.setText("");
            jtxtEnglish.setText("");
            jtxtScience.setText("");
            jtxtSocialScience.setText("");
            jtxtMAL.setText("");
            jtxtHPE.setText("");
            jtxtArts.setText("");
            jtxtTotalScore.setText("");
            jtxtAverage.setText("");
            //jtxtRanking.setText("");
            jtxtStudent.setText("");
        }else{

            JOptionPane.showMessageDialog(null, "Student Update failed...");

        }
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jbtnTranscriptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTranscriptsActionPerformed
        jtxtTranscript.setText(null);

        // Code to display transcripts

        double[] arr=new double[14];
        arr[0] = Double.parseDouble(jtxtMaths.getText());
        arr[1] = Double.parseDouble(jtxtEnglish.getText());
        arr[2] = Double.parseDouble(jtxtScience.getText());
        arr[3] = Double.parseDouble(jtxtSocialScience.getText());
        arr[4] = Double.parseDouble(jtxtMAL.getText());
        arr[5] = Double.parseDouble(jtxtHPE.getText());
        arr[6] = Double.parseDouble(jtxtArts.getText());
        String mathsGrade=null;
        String engGrade=null;
        String sciGrade=null;
        String socsGrade=null;
        String malGrade=null;
        String hpeGrade=null;
        String artsGrade=null;

        //Calculate Grade for maths
        if(arr[0]>=570)
        {
            mathsGrade = "A+";
        }
        else if (arr[0] >= 540)
        {
            mathsGrade = "A" ;
        }
        else if (arr[0] >= 510)
        {
            mathsGrade= "B+";
        }
        else if (arr[0] >= 480)
        {
            mathsGrade="B";
        }
        else if (arr[0] >= 450)
        {
            mathsGrade= "C+";
        }
        else if (arr[0] >= 420)
        {
            mathsGrade= "C";
        }
        else if (arr[0] >= 390)
        {
            mathsGrade= "D+";
        }
        else if(arr[0]>= 360)
        {
            mathsGrade= "D";
        }
        else if(arr[0]>= 330)
        {
            mathsGrade= "E+";
        }
        else if(arr[0]>=300)
        {
            mathsGrade= "E";
        }
        else if(arr[0]< 300)
        {
            mathsGrade= "F";
        }
        //Calculate grade for English
        if(arr[1]>=570)
        {
            engGrade = "A+";
        }
        else if (arr[1] >= 540)
        {
            engGrade = "A" ;
        }
        else if (arr[1] >= 510)
        {
            engGrade= "B+";
        }
        else if (arr[1] >= 480)
        {
            engGrade="B";
        }
        else if (arr[1] >= 450)
        {
            engGrade= "C+";
        }
        else if (arr[1] >= 420)
        {
            engGrade= "C";
        }
        else if (arr[1] >= 390)
        {
            engGrade= "D+";
        }
        else if(arr[1]>= 360)
        {
            engGrade= "D";
        }
        else if(arr[1]>= 330)
        {
            engGrade= "E+";
        }
        else if(arr[1]>=300)
        {
            engGrade= "E";
        }
        else if(arr[1]<300)
        {
            engGrade= "F";
        }
        //Calculate grade for science
        if(arr[2]>=570)
        {
            sciGrade = "A+";
        }
        else if (arr[2] >= 540)
        {
            sciGrade = "A" ;
        }
        else if (arr[2] >= 510)
        {
            sciGrade= "B+";
        }
        else if (arr[2] >= 480)
        {
            sciGrade="B";
        }
        else if (arr[2] >= 450)
        {
            sciGrade= "C+";
        }
        else if (arr[2] >= 420)
        {
            sciGrade= "C";
        }
        else if (arr[2] >= 390)
        {
            sciGrade= "D+";
        }
        else if(arr[2]>= 360)
        {
            sciGrade= "D";
        }
        else if(arr[2]>= 330)
        {
            sciGrade= "E+";
        }
        else if(arr[2]>=300)
        {
            sciGrade= "E";
        }
        else if(arr[2]< 300)
        {
            sciGrade= "F";
        }
        //calculate grade for science
        if(arr[3]>=570)
        {
            socsGrade = "A+";
        }
        else if (arr[3] >= 540)
        {
            socsGrade = "A" ;
        }
        else if (arr[3] >= 510)
        {
            socsGrade= "B+";
        }
        else if (arr[3] >= 480)
        {
            socsGrade="B";
        }
        else if (arr[3] >= 450)
        {
            socsGrade= "C+";
        }
        else if (arr[3] >= 420)
        {
            socsGrade= "C";
        }
        else if (arr[3] >= 390)
        {
            socsGrade= "D+";
        }
        else if(arr[3]>= 360)
        {
            socsGrade= "D";
        }
        else if(arr[3]>= 330)
        {
            socsGrade= "E+";
        }
        else if(arr[3]>=300)
        {
            socsGrade= "E";
        }
        else if(arr[3]< 300)
        {
            socsGrade= "F";
        }
        //calculate grad for MAL
        if(arr[4]>=570)
        {
            malGrade = "A+";
        }
        else if (arr[4] >= 540)
        {
            malGrade = "A" ;
        }
        else if (arr[4] >= 510)
        {
            malGrade= "B+";
        }
        else if (arr[4] >= 480)
        {
            malGrade="B";
        }
        else if (arr[4] >= 450)
        {
            malGrade= "C+";
        }
        else if (arr[4] >= 420)
        {
            malGrade= "C";
        }
        else if (arr[4] >= 390)
        {
            malGrade= "D+";
        }
        else if(arr[4]>= 360)
        {
            malGrade= "D";
        }
        else if(arr[4]>= 330)
        {
            malGrade= "E+";
        }
        else if(arr[4]>=300)
        {
            malGrade= "E";
        }
        else if(arr[4]< 300)
        {
            malGrade= "F";
        }
        //calculate grade for HPE
        if(arr[5]>=570)
        {
            hpeGrade = "A+";
        }
        else if (arr[5] >= 540)
        {
            hpeGrade = "A" ;
        }
        else if (arr[5] >= 510)
        {
            hpeGrade= "B+";
        }
        else if (arr[5] >= 480)
        {
            hpeGrade="B";
        }
        else if (arr[5] >= 450)
        {
            hpeGrade= "C+";
        }
        else if (arr[5] >= 420)
        {
            hpeGrade= "C";
        }
        else if (arr[5] >= 390)
        {
            hpeGrade= "D+";
        }
        else if(arr[5]>= 360)
        {
            hpeGrade= "D";
        }
        else if(arr[5]>= 330)
        {
            hpeGrade= "E+";
        }
        else if(arr[5]>=300)
        {
            hpeGrade= "E";
        }
        else if(arr[5]< 300)
        {
            hpeGrade= "F";
        }
        //calculate grade for arts
        if(arr[6]>=570)
        {
            artsGrade = "A+";
        }
        else if (arr[6] >= 540)
        {
            artsGrade = "A" ;
        }
        else if (arr[6] >= 510)
        {
            artsGrade= "B+";
        }
        else if (arr[6] >= 480)
        {
            artsGrade="B";
        }
        else if (arr[6] >= 450)
        {
            artsGrade= "C+";
        }
        else if (arr[6] >= 420)
        {
            artsGrade= "C";
        }
        else if (arr[6] >= 390)
        {
            artsGrade= "D+";
        }
        else if(arr[6]>= 360)
        {
            artsGrade= "D";
        }
        else if(arr[6]>= 330)
        {
            artsGrade= "E+";
        }
        else if(arr[6]>=300)
        {
            artsGrade= "E";
        }
        else if(arr[6]< 300)
        {
            artsGrade= "F";
        }
        //Code to insert image onto jTextPne
        JFileChooser jfc=new JFileChooser();
        StyledDocument doc=(StyledDocument) jtxtTranscript.getDocument();
        //select file and display
        jfc.setCurrentDirectory(new File(System.getProperty("user.home")));{
            int result=jfc.showOpenDialog(this);
            if (result==JFileChooser.APPROVE_OPTION)
            {
                File selectedFile=jfc.getSelectedFile();
                jtxtTranscript.insertIcon(new ImageIcon(selectedFile.getAbsolutePath()));

                Style style= doc.addStyle("StyleName", null);
                //StyleConstants.setIcon(style, new ImageIcon(selectedFile.getAbsolutePath()));

                try {
                    doc.insertString(doc.getLength(), "\n\t\t Student Result Recording System : Grade 8 Internal Assessment\n"
                        +"_________________________________________________________________________________________________\n"
                        + "\nStudent_ID:\t\t" + jtxtStudent.getText()
                        + "\nFirstname:\t\t" + jtxtFirstname.getText()
                        + "\nSurname:\t\t" + jtxtSurname.getText()
                        +"\n"
                        + "\nMaths:\t\t" + jtxtMaths.getText() +"\t"+mathsGrade
                        + "\nEnglish:\t\t" + jtxtEnglish.getText() +"\t"+engGrade
                        + "\nScience:\t\t" + jtxtScience.getText() +"\t"+sciGrade
                        + "\nSocScience:\t\t" + jtxtSocialScience.getText() +"\t"+socsGrade
                        + "\nMAL:\t\t" + jtxtMAL.getText() +"\t"+malGrade
                        + "\nHPE:\t\t" + jtxtHPE.getText() +"\t"+hpeGrade
                        + "\nArts:\t\t" + jtxtArts.getText() +"\t"+artsGrade
                        //+ "\nBusiness:\t\t" + jtxtBusiness.getText()
                        + "\nTotal Score:\t\t" + jtxtTotalScore.getText()
                        + "\nAverage:\t\t" + jtxtAverage.getText()
                        +"\n\nTeacher's Comments: "

                        , style);
                } catch (BadLocationException ex) {
                    Logger.getLogger(Term2.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }//GEN-LAST:event_jbtnTranscriptsActionPerformed

    private void jbtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetActionPerformed
        // Code to clear/reset all text boxes on form
        JTextField temp=null;
        for(Component c:jPanel1.getComponents()){
            if(c.getClass().toString().contains("javax.swing.JTextField")){
                temp=(JTextField)c;
                temp.setText(null);
            }
        }
    }//GEN-LAST:event_jbtnResetActionPerformed

    private void jbtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRefreshActionPerformed
        try{
            fillTable();
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jbtnRefreshActionPerformed

    private void jbtnAddRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddRecordActionPerformed
        if((jtxtStudent.getText()!=null || jtxtFirstname.getText()!=null||
            jtxtSurname.getText()!=null || jtxtTotalScore.getText()!=null ||
            jtxtAverage.getText()!=null || jtxtScience.getText()!=null ||
            jtxtMaths.getText()!=null   || jtxtEnglish.getText()!=null ||
            jtxtSocialScience.getText()!=null|| jtxtMAL.getText()!=null ||
            jtxtHPE.getText()!=null) && jtxtArts.getText()!=null){

        try{
            Class<?> forName = Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/studentrecord", "root", "sTud397r3*d");
            // String qry="insert into marks values(Student_ID, Course_Code, Firstname, Surname, Maths, English"
            //         + "Biology, Computing, Chemistry, Physics, Add_Maths, Business)";
            PreparedStatement ps,ps2,ps4;
            ps = conn.prepareStatement("insert into g8internal(StudentID,"
                + "Firstname, LastName, Total_Score, Science,"
                + "Average, Maths, Social_Science, MAL, HPE,"
                + "Arts, English,Grade)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, Integer.parseInt(jtxtStudent.getText()));
            ps.setString(2, jtxtFirstname.getText());
            ps.setString(3, jtxtSurname.getText());
            ps.setInt(4, Integer.parseInt(jtxtTotalScore.getText()));
            ps.setInt(5, Integer.parseInt(jtxtScience.getText()));
            ps.setInt(6, Integer.parseInt(jtxtAverage.getText()));
            ps.setInt(7, Integer.parseInt(jtxtMaths.getText()));
            ps.setInt(8, Integer.parseInt(jtxtSocialScience.getText()));
            ps.setInt(9, Integer.parseInt(jtxtMAL.getText()));
            ps.setInt(10, Integer.parseInt(jtxtHPE.getText()));
            ps.setInt(11, Integer.parseInt(jtxtArts.getText()));
            ps.setInt(12, Integer.parseInt(jtxtEnglish.getText()));

            String value=jcmbGrade.getSelectedItem().toString();
            ps.setString(13, value);

            int res=ps.executeUpdate();
            if (res>=1){
                JOptionPane.showMessageDialog(null, res+" Number of student inserted"
                    + " into database");
            }else
            JOptionPane.showMessageDialog(null, "Student insertion failed");

            //add record to assessment period 2
           /* ps2 = conn.prepareStatement("insert into g8internal(StudentID,"
                + "FirstName, LastName, Total_Score, Science,"
                + "Average, Maths, Social_Science, MAL, HPE,"
                + "Arts, English,Grade)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps2.setInt(1, Integer.parseInt(jtxtStudent.getText()));
            ps2.setString(2, jtxtFirstname.getText());
            ps2.setString(3, jtxtSurname.getText());
            ps2.setInt(4, Integer.parseInt(jtxtTotalScore.getText()));
            ps2.setInt(5, Integer.parseInt(jtxtScience.getText()));
            ps2.setInt(6, Integer.parseInt(jtxtAverage.getText()));
            ps2.setInt(7, Integer.parseInt(jtxtMaths.getText()));
            ps2.setInt(8, Integer.parseInt(jtxtSocialScience.getText()));
            ps2.setInt(9, Integer.parseInt(jtxtMAL.getText()));
            ps2.setInt(10, Integer.parseInt(jtxtHPE.getText()));
            ps2.setInt(11, Integer.parseInt(jtxtArts.getText()));
            ps2.setInt(12, Integer.parseInt(jtxtEnglish.getText()));

            String value2=jcmbGrade.getSelectedItem().toString();
            ps2.setString(13, value);

            int res2=ps2.executeUpdate();
            if (res2>=1){
                JOptionPane.showMessageDialog(null, res+" Number of student inserted to Grade Internal Assessment");
            }else
            JOptionPane.showMessageDialog(null, "Student insertion failed");*/

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }   
        }   
    }//GEN-LAST:event_jbtnAddRecordActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        String qry=null;
        PreparedStatement ps,ps2,ps3=null;
        Connection conn=MySqlConnection();

        if (jtxtStudent.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter the Student ID...");
        } else{
            if(jtxtStudent!=null || jtxtFirstname!=null || jtxtSurname!=null
                || jtxtMaths!=null || jtxtEnglish!=null || jtxtScience!=null
                || jtxtSocialScience!=null|| jtxtMAL!=null|| jtxtHPE!=null){
                try{

                    //delete  record in overall table
                    ps2 = conn.prepareStatement("update g8internal o inner join\n" +
                        "(\n" +
                        "SELECT op.StudentID, \n" +
                        "       sum(ot.Total_Score) as Total_Score_ot,\n" +
                        "       sum(ot.English) as English_ot,\n" +
                        "       sum(ot.Maths) as Maths_ot,\n" +
                        "       sum(ot.Science) as Science_ot,\n" +
                        "       sum(ot.Social_Science) as Social_Science_ot,\n" +
                        "       sum(ot.MAL) as MAL_ot,\n" +
                        "       sum(ot.HPE) as HPE_ot,\n" +
                        "       sum(ot.Arts) as Arts_ot,\n" +
                        "       sum(op.Total_Score) as Total_Score_op,\n" +
                        "       sum(op.English) as English_op,\n" +
                        "       sum(op.Maths) as Maths_op,\n" +
                        "       sum(op.Science) as Science_op,\n" +
                        "       sum(op.Social_Science) as Social_Science_op,\n" +
                        "       sum(op.MAL) as MAL_op,\n" +
                        "       sum(op.HPE) as HPE_op,\n" +
                        "       sum(op.Arts) as Arts_op\n" +
                        "FROM g8internal ot inner join overall op on op.StudentID = ot.StudentID \n" +
                        "GROUP BY op.StudentID\n" +
                        ") as o1 on o.StudentID = o1.StudentID\n" +
                        "SET Total_Score=Total_Score_op - Total_Score_ot,\n" +
                        " English=English_op - English_ot,\n" +
                        " Maths=Maths_op - Maths_ot,\n" +
                        " Science=Science_op - Science_ot,\n" +
                        " Social_Science=Social_Science_op - Social_Science_ot,\n" +
                        " MAL=MAL_op - MAL_ot,\n" +
                        " HPE=HPE_op - HPE_ot,\n" +
                        " Arts=Arts_op - Arts_ot\n" +
                        "    \n" +
                        "   \n" +
                        "    ");

                    int res2=ps2.executeUpdate();

                    //delete record in term1
                    qry="delete from g8internal where StudentID=?";
                    conn=MySqlConnection();
                    ps=conn.prepareStatement(qry);
                    ps.setInt(1, Integer.parseInt(jtxtStudent.getText().toString()));
                    int res=ps.executeUpdate();
                    if(res>=1) {
                        JOptionPane.showMessageDialog(null, "Student deleted successfully...");
                    }else
                    JOptionPane.showMessageDialog(null, "Student deletion failure...");

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }

        }
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jtxtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtSearchActionPerformed

    private void jtxtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSearchKeyReleased
        ArrayList<StudentBean2> al=null;
        al=new ArrayList<StudentBean2>();
        String val=jtxtSearch.getText().toString();
        try{
            Connection conn=MySqlConnection();
            String qry="select * from g8internal where FirstName like '%"+val+"%'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            StudentBean2 student;
            while (rs.next()){
                student =new StudentBean2(rs.getInt(1), rs.getString("FirstName"),
                    rs.getString("LastName"), rs.getInt(13), rs.getInt(4)
                    , rs.getInt(22), rs.getInt(31), rs.getInt(40), rs.getInt(49)
                    , rs.getInt(58), rs.getInt(67), rs.getInt(68), rs.getInt(70),
                    rs.getString("Grade"));
                al.add(student);
            }
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0); //Empty ( clear the table)

            Object[] row=new Object[140];
            for (int i = 0; i < al.size(); i++){
                row[0]=al.get(i).getStudent_ID();
                row[1]=al.get(i).getFirstName();
                row[2]=al.get(i).getLastName();
                row[3]=al.get(i).getMaths();
                row[4]=al.get(i).getEnglish();
                row[5]=al.get(i).getScience();
                row[6]=al.get(i).getSocial_Science();
                row[7]=al.get(i).getMAL();
                row[8]=al.get(i).getHealth_PE();
                row[9]=al.get(i).getArts();
                //row[10]=al.get(i).getTotal_Score();
                row[10]=al.get(i).getTotal_Score();
                row[11]=al.get(i).getAverage();
                row[12]=al.get(i).getGPA();
                model.addRow(row);

                //show record onto field
                int ind=jTable1.getSelectedRow();
                ShowItemToFields(ind);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jtxtSearchKeyReleased

    private void jtxtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSearchKeyTyped
        ArrayList<StudentBean2> al=null;
        al=new ArrayList<StudentBean2>();
        String val=jtxtSearch.getText().toString();
        try{
            Connection conn=MySqlConnection();
            String qry="select * from g8internal where FirstName like '%"+val+"%'";
            //Statement st=conn.createStatement();
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            StudentBean2 student;
            while (rs.next()){
                student =new StudentBean2(rs.getInt(1), rs.getString("FirstName"),
                    rs.getString("LastName"), rs.getInt(4), rs.getInt(5)
                    , rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)
                    , rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(70),
                    rs.getString("Grade"));
                al.add(student);
            }
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0); //Empty ( clear the table)

            Object[] row=new Object[14];
            for (int i = 0; i < al.size(); i++){
                row[0]=al.get(i).getStudent_ID();
                row[1]=al.get(i).getFirstName();
                row[2]=al.get(i).getLastName();
                row[3]=al.get(i).getMaths();
                row[4]=al.get(i).getEnglish();
                row[5]=al.get(i).getScience();
                row[6]=al.get(i).getSocial_Science();
                row[7]=al.get(i).getMAL();
                row[8]=al.get(i).getHealth_PE();
                row[9]=al.get(i).getArts();
                row[10]=al.get(i).getTotal_Score();
                row[11]=al.get(i).getAverage();
                row[12]=al.get(i).getGPA();
                model.addRow(row);
            }

            //show record onto field
            int ind=jTable1.getSelectedRow();
            ShowItemToFields(ind);
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jtxtSearchKeyTyped

    private void jButton_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_printActionPerformed
        MessageFormat header=new MessageFormat("Student Report");

        MessageFormat footer=new MessageFormat("Page{0,number,integer}");

        try{
            jtxtTranscript.print(header, footer);

        }catch(java.awt.print.PrinterException e){
            System.err.format("Cannot print %s%n", e.getMessage());

        }
    }//GEN-LAST:event_jButton_printActionPerformed

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        // Code to exit from the App

        try{
            dispose();
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void jbtn8InternalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn8InternalActionPerformed
    
        jtxtTranscript.setText(null);
        jtxtTranscript.setText("Grade 8 internal Marks \n"
            + "________________________________________________________________________________________________________________\n"
            + "Overall Score \t Maths \t Name\t Surname \n\n");
        
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT StudentID, FirstName, LastName, SUM(Total_Score) AS Total_Score, SUM(Maths) AS Maths\n" +
"FROM\n" +
"(\n" +
"    SELECT StudentID, FirstName, LastName, Total_Score, Maths FROM g734\n" +
"    UNION ALL\n" +
"    SELECT StudentID, FirstName, LastName, Total_Score, Maths FROM g8internal\n" +
") t\n" +
"GROUP BY StudentID, FirstName, LastName";
            ResultSet rs=stmt.executeQuery(sql);
            int[] scores;
            while(rs.next()){
                String firstname=rs.getString("FirstName");
                String surname=rs.getString("LastName");
                int score=rs.getInt("Total_Score");
                int maths=rs.getInt("Maths");

                int i=0;
                int[] arr=new int[300];
                int [] arr2=new int[300];
                String[] names = new String[300];
                names[i]=firstname;
                int rank=1;
                arr[i]=score;
                arr2[i]=maths;
                ArrayList<Integer> setOfInteger =new ArrayList<>(arr[i]);
                ArrayList<Integer> setOfInteger2 =new ArrayList<>(arr2[i]);
                List<String> namelist=new ArrayList<String>();
                namelist.add(names[i]);

                setOfInteger.add(arr[i]);
                setOfInteger2.add(arr2[i]);
                //System.out.println(setOfInteger.get(i));
                
                StyledDocument doc=(StyledDocument) jtxtTranscript.getDocument();
                
                 Style style= doc.addStyle("StyleName", null);
                //StyleConstants.setIcon(style, new ImageIcon(selectedFile.getAbsolutePath()));
                doc.insertString(doc.getLength(), ""+Integer.toString(setOfInteger.get(i))
                        +"\t\t"+maths+"\t"+firstname+"\t"+surname+"\n"
                        
                        , style);
            i++;

            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jbtn8InternalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Grade8internal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grade8internal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grade8internal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grade8internal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grade8internal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_Arts;
    private javax.swing.JButton jButton_English;
    private javax.swing.JButton jButton_HPE;
    private javax.swing.JButton jButton_MAL;
    private javax.swing.JButton jButton_Maths;
    private javax.swing.JButton jButton_Science;
    private javax.swing.JButton jButton_SocialScience;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_print;
    private javax.swing.JButton jButton_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtn8Internal;
    private javax.swing.JButton jbtnAddRecord;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnRefresh;
    private javax.swing.JButton jbtnReset;
    private javax.swing.JButton jbtnTranscripts;
    private javax.swing.JComboBox<String> jcmbGrade;
    private javax.swing.JTextField jtxtArts;
    private javax.swing.JTextField jtxtAverage;
    private javax.swing.JTextField jtxtEnglish;
    private javax.swing.JTextField jtxtFirstname;
    private javax.swing.JTextField jtxtHPE;
    private javax.swing.JTextField jtxtMAL;
    private javax.swing.JTextField jtxtMaths;
    private javax.swing.JTextField jtxtScience;
    private javax.swing.JTextField jtxtSearch;
    private javax.swing.JTextField jtxtSocialScience;
    private javax.swing.JTextField jtxtStudent;
    private javax.swing.JTextField jtxtSurname;
    private javax.swing.JTextField jtxtTotalScore;
    private javax.swing.JTextPane jtxtTranscript;
    // End of variables declaration//GEN-END:variables
}
