/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentrecordapp;

/**
 *
 * @author MUC
 */
import Students_Result.StudentBean;
import java_student_result.MathsJFrame;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.text.*;
import java.awt.print.PrinterException;
import java.awt.print.*;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Integer;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;
import javax.swing.*;

public class Student_Result extends javax.swing.JFrame {

    /**
     * Creates new form Student_Result
     */
    public Student_Result() {
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
            String q="SELECT * FROM overall WHERE YEAR(overall.created_at)=YEAR(CURDATE())";
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
            row[12]=al.get(i).getGPA();
            row[12]=al.get(i).getGrade();
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

        jPanel5 = new javax.swing.JPanel();
        jbtnRefresh = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jtxtSearch = new javax.swing.JTextField();
        jbtnExit = new javax.swing.JButton();
        jButton_print = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jbtnTranscripts = new javax.swing.JButton();
        jbtnReset = new javax.swing.JButton();
        jbtnAddRecord = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton_Grade3 = new javax.swing.JButton();
        jButton_Gr4 = new javax.swing.JButton();
        jButton_Gr5 = new javax.swing.JButton();
        jButton_gr6 = new javax.swing.JButton();
        jButton_gr7 = new javax.swing.JButton();
        jButton_gr8 = new javax.swing.JButton();
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtxtTranscript = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setTitle("Student Result System");
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

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

        jbtnExit.setBackground(new java.awt.Color(255, 255, 255));
        jbtnExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnExit.setText("Exit");
        jbtnExit.setPreferredSize(new java.awt.Dimension(67, 23));
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
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

        jButton_delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_delete.setText("DELETE");
        jButton_delete.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
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

        jbtnAddRecord.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnAddRecord.setText("Add Record");
        jbtnAddRecord.setPreferredSize(new java.awt.Dimension(67, 23));
        jbtnAddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddRecordActionPerformed(evt);
            }
        });

        jButton_update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_update.setText("Update");
        jButton_update.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), null), "Rankings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(102, 102, 102));

        jButton_Grade3.setText("GRADE 3");
        jButton_Grade3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Grade3ActionPerformed(evt);
            }
        });

        jButton_Gr4.setText("GRADE 4");
        jButton_Gr4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Gr4ActionPerformed(evt);
            }
        });

        jButton_Gr5.setText("GRADE 5");
        jButton_Gr5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Gr5ActionPerformed(evt);
            }
        });

        jButton_gr6.setText("GRADE 6");
        jButton_gr6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gr6ActionPerformed(evt);
            }
        });

        jButton_gr7.setText("GRADE 7");
        jButton_gr7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gr7ActionPerformed(evt);
            }
        });

        jButton_gr8.setText("GRADE 8");
        jButton_gr8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gr8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jButton_Grade3)
                .addGap(67, 67, 67)
                .addComponent(jButton_Gr4)
                .addGap(87, 87, 87)
                .addComponent(jButton_Gr5)
                .addGap(91, 91, 91)
                .addComponent(jButton_gr6)
                .addGap(100, 100, 100)
                .addComponent(jButton_gr7)
                .addGap(76, 76, 76)
                .addComponent(jButton_gr8)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Grade3)
                    .addComponent(jButton_Gr4)
                    .addComponent(jButton_Gr5)
                    .addComponent(jButton_gr6)
                    .addComponent(jButton_gr7)
                    .addComponent(jButton_gr8))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), null), "Students Records: overall", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 255, 0))); // NOI18N

        jtxtFirstname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtxtStudent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
        jLabel12.setText("Heahtl/PE:");

        jcmbGrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grade3", "Grade4", "Grade5", "Grade6", "Grade7", "Grade8" }));
        jcmbGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbGradeActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Arts:");

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
        jLabel7.setText("English:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Maths:");

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
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtMaths, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(jtxtEnglish)
                    .addComponent(jtxtHPE, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtMAL, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtSocialScience, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtScience)
                    .addComponent(jtxtArts))
                .addGap(178, 178, 178))
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
                            .addComponent(jtxtMaths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtxtEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jtxtScience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jtxtSocialScience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jtxtMAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jtxtHPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jtxtArts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jButton2))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), null), "Results", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 255, 0))); // NOI18N

        jScrollPane3.setViewportView(jtxtTranscript);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

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
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnTranscripts, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(jbtnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jbtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnAddRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_print, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2323, 2323, 2323))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnTranscripts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_print, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnAddRecord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnReset))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        String qry=null;
        PreparedStatement ps=null;
        Connection conn=MySqlConnection();

        if(jtxtStudent!=null || jtxtFirstname!=null || jtxtSurname!=null
            || jtxtMaths!=null || jtxtEnglish!=null || jtxtScience!=null
            || jtxtSocialScience!=null|| jtxtMAL!=null|| jtxtHPE!=null){
            // String qry=null;
            //PreparedStatement ps=null;
            //Connection conn=MySqlConnection();
            try{
                qry="update overall set FirstName=?, LastName=?, Maths=? "
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
                ps.setInt(12, Integer.parseInt(jtxtStudent.getText()));

                int res=ps.executeUpdate();
                if(res>=1){
                    JOptionPane.showMessageDialog(null, res+" Number of students"
                        +" updated successfully...");
                }else
                JOptionPane.showMessageDialog(null, " Student updation fail...");
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
            jtxtStudent.setText("");
        }else{

            JOptionPane.showMessageDialog(null, "Student Update failed...");

        }

    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jbtnTranscriptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTranscriptsActionPerformed
        // Code to display transcripts
       jtxtTranscript.setText(null);
        
        
            //get selected file name [ i.e., complete file path ]
           //java.io.File f = jfc.getSelectedFile();
           
            //jLab.setBounds(200, 10, 400, 200);
            //jLab.setIcon(new ImageIcon(f.getAbsolutePath()));
            //jtxtTranscript.add(jLab);

            //validate();
            //if(isImage(f))
           // jtxtTranscript=new JTextPane(layout);
            //jtxtTranscript.setLayout(new GridLayout(2,1));
            //jtxtTranscript.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            
            //jtxtTranscript.insertIcon(new ImageIcon(f.getAbsolutePath()));
       
            //setBounds(230,270,100,100);            
            
                   
          
       
        
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
        if(arr[0]>=380)
        {
            mathsGrade = "A+";
        }
        else if (arr[0] >= 360)
        {
            mathsGrade = "A" ;
        }
        else if (arr[0] >= 340)
        {
            mathsGrade= "B+";
        }
        else if (arr[0] >= 320)
        {
            mathsGrade="B";
        }
        else if (arr[0] >= 300)
        {
            mathsGrade= "C+";
        }
        else if (arr[0] >= 280)
        {
            mathsGrade= "C";
        }
        else if (arr[0] >= 260)
        {
            mathsGrade= "D+";
        }
        else if(arr[0]>= 240)
        {
            mathsGrade= "D";
       }
        else if(arr[0]>= 220)
        {
            mathsGrade= "E+";
        }
        else if(arr[0]>=200)
        {
            mathsGrade= "E";
        }
        else if(arr[0]< 200)
        {
            mathsGrade= "F";
        }
        //Calculate grade for English
         if(arr[1]>=380)
        {
            engGrade = "A+";
        }
         else if (arr[1] >= 360)
        {
            engGrade = "A" ;
        }
        else if (arr[1] >= 340)
        {
            engGrade= "B+";
        }
        else if (arr[1] >= 320)
        {
            engGrade="B";
        }
        else if (arr[1] >= 300)
        {
            engGrade= "C+";
        }
        else if (arr[1] >= 280)
        {
            engGrade= "C";
        }
        else if (arr[1] >= 260)
        {
            engGrade= "D+";
        }
        else if(arr[1]>= 240)
        {
            engGrade= "D";
       }
        else if(arr[1]>= 220)
        {
            engGrade= "E+";
        }
        else if(arr[1]>=200)
        {
            engGrade= "E";
        }
        else if(arr[1]< 200)
        {
            engGrade= "F";
        }
        //Calculate grade for science
         if(arr[2]>=380)
        {
            sciGrade = "A+";
        }
         else if (arr[2] >= 360)
        {
            sciGrade = "A" ;
        }
        else if (arr[2] >= 340)
        {
            sciGrade= "B+";
        }
        else if (arr[2] >= 320)
        {
            sciGrade="B";
        }
        else if (arr[2] >= 300)
        {
            sciGrade= "C+";
        }
        else if (arr[2] >= 280)
        {
            sciGrade= "C";
        }
        else if (arr[2] >= 260)
        {
            sciGrade= "D+";
        }
        else if(arr[2]>= 240)
        {
            sciGrade= "D";
       }
        else if(arr[2]>= 220)
        {
            sciGrade= "E+";
        }
        else if(arr[2]>=200)
        {
            sciGrade= "E";
        }
        else if(arr[2]< 200)
        {
            sciGrade= "F";
        }
        //calculate grade for science
         if(arr[3]>=380)
        {
            socsGrade = "A+";
        }
         else if (arr[3] >= 360)
        {
            socsGrade = "A" ;
        }
        else if (arr[3] >= 340)
        {
            socsGrade= "B+";
        }
        else if (arr[3] >= 320)
        {
            socsGrade="B";
        }
        else if (arr[3] >= 300)
        {
            socsGrade= "C+";
        }
        else if (arr[3] >= 280)
        {
            socsGrade= "C";
        }
        else if (arr[3] >= 260)
        {
            socsGrade= "D+";
        }
        else if(arr[3]>= 240)
        {
            socsGrade= "D";
       }
        else if(arr[3]>= 220)
        {
            socsGrade= "E+";
        }
        else if(arr[3]>=200)
        {
            socsGrade= "E";
        }
        else if(arr[3]< 200)
        {
            socsGrade= "F";
        }
        //calculate grad for MAL
         if(arr[4]>=380)
        {
            malGrade = "A+";
        }
         else if (arr[4] >= 360)
        {
            malGrade = "A" ;
        }
        else if (arr[4] >= 340)
        {
            malGrade= "B+";
        }
        else if (arr[4] >=320)
        {
            malGrade="B";
        }
        else if (arr[4] >= 300)
        {
            malGrade= "C+";
        }
        else if (arr[4] >= 280)
        {
            malGrade= "C";
        }
        else if (arr[4] >= 260)
        {
            malGrade= "D+";
        }
        else if(arr[4]>= 240)
        {
            malGrade= "D";
       }
        else if(arr[4]>= 220)
        {
            malGrade= "E+";
        }
        else if(arr[4]>=200)
        {
            malGrade= "E";
        }
        else if(arr[4]< 200)
        {
            malGrade= "F";
        }
        //calculate grade for HPE
         if(arr[5]>=380)
        {
            hpeGrade = "A+";
        }
         else if (arr[5] >= 360)
        {
            hpeGrade = "A" ;
        }
        else if (arr[5] >= 340)
        {
            hpeGrade= "B+";
        }
        else if (arr[5] >= 320)
        {
            hpeGrade="B";
        }
        else if (arr[5] >= 300)
        {
            hpeGrade= "C+";
        }
        else if (arr[5] >= 280)
        {
            hpeGrade= "C";
        }
        else if (arr[5] >= 260)
        {
            hpeGrade= "D+";
        }
        else if(arr[5]>= 240)
        {
            hpeGrade= "D";
       }
        else if(arr[5]>= 220)
        {
            hpeGrade= "E+";
        }
        else if(arr[5]>=200)
        {
            hpeGrade= "E";
        }
        else if(arr[5]< 200)
        {
            hpeGrade= "F";
        }
        //calculate grade for arts
         if(arr[6]>=380)
        {
            artsGrade = "A+";
        }
         else if (arr[6] >= 360)
        {
            artsGrade = "A" ;
        }
        else if (arr[6] >= 340)
        {
            artsGrade= "B+";
        }
        else if (arr[6] >= 320)
        {
            artsGrade="B";
        }
        else if (arr[6] >= 300)
        {
           artsGrade= "C+";
        }
        else if (arr[6] >= 280)
        {
            artsGrade= "C";
        }
        else if (arr[6] >= 260)
        {
            artsGrade= "D+";
        }
        else if(arr[6]>= 240)
        {
            artsGrade= "D";
       }
        else if(arr[6]>= 220)
        {
            artsGrade= "E+";
        }
        else if(arr[6]>=200)
        {
            artsGrade= "E";
        }
        else if(arr[6]< 200)
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
                    doc.insertString(doc.getLength(), "\n\t\t Student Result Recording System : Term 1\n"
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

                    
            , style);
                } catch (BadLocationException ex) {
                Logger.getLogger(Term2.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
            


       /* jtxtTranscript.setText("\n\t\tStudent Result Recording System : Term 1\n"
            + "_________________________________________________________________________________________________\n"
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

        );*/
    }

    }//GEN-LAST:event_jbtnTranscriptsActionPerformed

    private void jbtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetActionPerformed
        // Code to clear/reset all text boxes on form
        JTextField temp=null;
        for(Component c:jPanel2.getComponents()){
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
            jtxtSurname.getText()!=null || jcmbGrade.getModel()!=null||
            jtxtTotalScore.getText()!=null || jtxtAverage.getText()!=null||
            jtxtMaths.getText()!=null||
            jtxtEnglish.getText()!=null || jtxtScience.getText()!=null||
            jtxtSocialScience.getText()!=null || jtxtMAL.getText()!=null||
            jtxtHPE.getText()!=null) && jtxtArts.getText()!=null){

        try{
            Class<?> forName = Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/studentrecord", "root", "sTud397r3*d");
            // String qry="insert into marks values(Student_ID, Course_Code, Firstname, Surname, Maths, English"
            //         + "Biology, Computing, Chemistry, Physics, Add_Maths, Business)";
            PreparedStatement ps;
            ps = conn.prepareStatement("insert into overall (StudentID,"
                + "FirstName, LastName, Total_Score, Science,"
                + "Average, Maths, Social_Science, MAL, HPE,"
                + "Arts, English,Grade)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, Integer.parseInt(jtxtStudent.getText()));
            ps.setString(2, jtxtFirstname.getText());
            ps.setString(3,jtxtSurname.getText());
            ps.setInt(4, Integer.parseInt(jtxtTotalScore.getText()));
            ps.setInt(5, Integer.parseInt(jtxtScience.getText()));
            ps.setInt(6, Integer.parseInt(jtxtAverage.getText()));
            ps.setInt(7, Integer.parseInt(jtxtMaths.getText()));
            ps.setInt(8, Integer.parseInt(jtxtMAL.getText()));
            ps.setInt(9, Integer.parseInt(jtxtSocialScience.getText()));
            //ps.setInt(10, Integer.parseInt(jtxtMAL.getText()));
            ps.setInt(10, Integer.parseInt(jtxtHPE.getText()));
            ps.setInt(11, Integer.parseInt(jtxtArts.getText()));
           ps.setInt(12, Integer.parseInt(jtxtEnglish.getText()));
           
           String value2=jcmbGrade.getSelectedItem().toString();
            ps.setString(13, value2);


            int res=ps.executeUpdate();
            if (res>=1){
                JOptionPane.showMessageDialog(null, res+" Number of student inserted"
                    + " into database");
            }else
            JOptionPane.showMessageDialog(null, "Student insertion failed");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        }
    }//GEN-LAST:event_jbtnAddRecordActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        String qry=null;
        PreparedStatement ps,ps2,ps3,ps4,ps5=null;
        Connection conn=MySqlConnection();
        
        if (jtxtStudent.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter the Student ID...");
            
        } else{
            if(jtxtStudent!=null || jtxtFirstname!=null || jtxtSurname!=null
            || jtxtMaths!=null || jtxtEnglish!=null || jtxtScience!=null
            || jtxtSocialScience!=null|| jtxtMAL!=null|| jtxtHPE!=null){
            try{
               
                //delete record in overall
                qry="delete from overall where StudentID=?";
                conn=MySqlConnection();
                ps=conn.prepareStatement(qry);
                ps.setInt(1, Integer.parseInt(jtxtStudent.getText().toString()));
                int res=ps.executeUpdate();
                if(res>=1) {
                    JOptionPane.showMessageDialog(null, "Student deleted successfully...");
                }else
                JOptionPane.showMessageDialog(null, "Student deletion failure...");
                
                 //delete record from term1 db
                  ps=null;
                 qry="delete from term1 where StudentID=?";
                conn=MySqlConnection();
                 ps=conn.prepareStatement(qry);
                ps.setInt(1, Integer.parseInt(jtxtStudent.getText().toString()));
                
                int res1=ps.executeUpdate();
             
                 //delete record from term2 db
                 ps2=null;
                 String qry2="delete from term2 where StudentID=?";
                conn=MySqlConnection();
                 ps2=conn.prepareStatement(qry2);
                ps2.setInt(1, Integer.parseInt(jtxtStudent.getText().toString()));
                
                int res2=ps2.executeUpdate();
                
                //delete record from term3 db
                 ps3=null;
                 String qry3="delete from term3 where StudentID=?";
                conn=MySqlConnection();
                 ps3=conn.prepareStatement(qry3);
                ps3.setInt(1, Integer.parseInt(jtxtStudent.getText().toString()));
                
                int res3=ps3.executeUpdate();
                
                //delete record from term4 db
                 ps4=null;
                 String qry4="delete from term4 where StudentID=?";
                conn=MySqlConnection();
                 ps4=conn.prepareStatement(qry4);
                ps4.setInt(1, Integer.parseInt(jtxtStudent.getText().toString()));
                
                int res4=ps4.executeUpdate();   
                
                //delete record from g734 table
                 ps4=null;
                 String qry5="delete from term4 where StudentID=?";
                conn=MySqlConnection();
                 ps4=conn.prepareStatement(qry5);
                ps4.setInt(1, Integer.parseInt(jtxtStudent.getText().toString()));
                
                int res5=ps4.executeUpdate();   


            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            }
        }
    }//GEN-LAST:event_jButton_deleteActionPerformed

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
          //new  Student_Result().setVisible(true); 
           // int close = MathsJFrame.EXIT_ON_CLOSE;
           dispose();
        }catch(Exception e){
            System.out.println(e);
        }
      
        /*try {
            new MainJFrame().setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }*/
        
        
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void jtxtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtSearchActionPerformed

    private void jtxtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSearchKeyReleased
        ArrayList<StudentBean> al=null;
        al=new ArrayList<StudentBean>();
        String val=jtxtSearch.getText().toString();
        try{
            Connection conn=MySqlConnection();
            String qry="select * from overall where FirstName like '%"+val+"%'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            StudentBean student;
            while (rs.next()){
                student =new StudentBean(rs.getInt(1), rs.getString("FirstName"),
                    rs.getString("LastName"), rs.getInt(4), rs.getInt(5)
                    , rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)
                    , rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13),
                    rs.getString("Overall_Ranking"));
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
                row[11]=al.get(i).getTotal_Score();
                row[12]=al.get(i).getAverage();
                model.addRow(row);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jtxtSearchKeyReleased

    private void jtxtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSearchKeyTyped
        ArrayList<StudentBean> al=null;
        al=new ArrayList<StudentBean>();
        String val=jtxtSearch.getText().toString();
        try{
            Connection conn=MySqlConnection();
            String qry="select * from overall where FirstName like '%"+val+"%'";
            //Statement st=conn.createStatement();
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            StudentBean student;
            while (rs.next()){
                student =new StudentBean(rs.getInt(1), rs.getString("FirstName"),
                    rs.getString("FirstName"), rs.getInt(4), rs.getInt(5)
                    , rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)
                    , rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13),
                    rs.getString("Overall_Ranking"));
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
                row[11]=al.get(i).getTotal_Score();
                row[12]=al.get(i).getAverage();
                model.addRow(row);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jtxtSearchKeyTyped

    private void jButton_Grade3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Grade3ActionPerformed
        // code to calculate ranking for all grade 3
    /*    jtxtTranscript.setText(null);
        jtxtTranscript.setText("Students over all ranking for Grade 4: Term 3\n"
            + "________________________________________________________________________________________________________________\n"
            + "Place \t Name\t Surname \n\n");
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT    term3.FirstName,    term3.Total_Score,  term3.LastName , @prev := @curr,    @curr := Total_Score,\n" +
            " @rank := IF(@prev = @curr,@rank, @rank +1) AS Overall_Ranking    FROM\n" +
            " term3,(SELECT @curr := null, @prev := null, @rank :=0) tmp_tbl\n" +
            " WHERE term3.Grade='Grade3' ORDER BY term3.Total_Score DESC";
            ResultSet rs=stmt.executeQuery(sql);
            int[] scores;
            while(rs.next()){
                String firstname=rs.getString("FirstName");
                String surname=rs.getString("LastName");
                int score=rs.getInt("Overall_Ranking");

                int i=0;
                int[] arr=new int[300];
                String[] names = new String[300];
                names[i]=firstname;
                int rank=1;
                arr[i]=score;
                ArrayList<Integer> setOfInteger =new ArrayList<>(arr[i]);
                List<String> namelist=new ArrayList<String>();
                namelist.add(names[i]);

                setOfInteger.add(arr[i]);
                //System.out.println(setOfInteger.get(i));
                jtxtTranscript.append("\t");
                jtxtTranscript.append("\n"+Integer.toString(setOfInteger.get(i))
                    +"\t"+firstname+"\t"+surname);
                i++;

            }

        }catch (Exception e){
            System.out.println(e);
        }  */
    
      // code to calculate ranking for all grade 3
         jtxtTranscript.setText(null);
        jtxtTranscript.setText("Students over all ranking for Grade 3: End of Year\n"
            + "________________________________________________________________________________________________________________\n"
            + "Place \t Name\t Surname \n\n");
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT    overall.FirstName,    overall.Total_Score,  overall.LastName , @prev := @curr,    @curr := Total_Score,\n" +
            " @rank := IF(@prev = @curr,@rank, @rank +1) AS Overall_Ranking    FROM\n" +
            " overall,(SELECT @curr := null, @prev := null, @rank :=0) tmp_tbl\n" +
            " WHERE overall.Grade='Grade3'&& YEAR(overall.created_at)=YEAR(CURDATE()) ORDER BY overall.Total_Score DESC";
            ResultSet rs=stmt.executeQuery(sql);
            int[] scores;
            while(rs.next()){
                String firstname=rs.getString("FirstName");
                String surname=rs.getString("LastName");
                int score=rs.getInt("Overall_Ranking");

                int i=0;
                int[] arr=new int[300];
                String[] names = new String[300];
                names[i]=firstname;
                int rank=1;
                arr[i]=score;
                ArrayList<Integer> setOfInteger =new ArrayList<>(arr[i]);
                List<String> namelist=new ArrayList<String>();
                namelist.add(names[i]);

                setOfInteger.add(arr[i]);
                //System.out.println(setOfInteger.get(i));
                 StyledDocument doc=(StyledDocument) jtxtTranscript.getDocument();
                
                 Style style= doc.addStyle("StyleName", null);
                //StyleConstants.setIcon(style, new ImageIcon(selectedFile.getAbsolutePath()));

                try {
                    doc.insertString(doc.getLength(), "\t\n"+Integer.toString(setOfInteger.get(i))
                    +"\t"+firstname+"\t"+surname
                  
            , style);
                } catch (BadLocationException ex) {
                Logger.getLogger(Term2.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;

            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    
    }//GEN-LAST:event_jButton_Grade3ActionPerformed

    private void jButton_Gr4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Gr4ActionPerformed
        // code to calculate ranking for all grade 4
        jtxtTranscript.setText(null);
        jtxtTranscript.setText("Students over all ranking for Grade 4: End of Year\n"
            + "________________________________________________________________________________________________________________\n"
            + "Place \t Name\t Surname \n\n");
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT    overall.FirstName,    overall.Total_Score,  overall.LastName , @prev := @curr,    @curr := Total_Score,\n" +
            " @rank := IF(@prev = @curr,@rank, @rank +1) AS Overall_Ranking    FROM\n" +
            " overall,(SELECT @curr := null, @prev := null, @rank :=0) tmp_tbl\n" +
            " WHERE overall.Grade='Grade4'&& YEAR(overall.created_at)=YEAR(CURDATE()) ORDER BY overall.Total_Score DESC";
            ResultSet rs=stmt.executeQuery(sql);
            int[] scores;
            while(rs.next()){
                String firstname=rs.getString("FirstName");
                String surname=rs.getString("LastName");
                int score=rs.getInt("Overall_Ranking");

                int i=0;
                int[] arr=new int[300];
                String[] names = new String[300];
                names[i]=firstname;
                int rank=1;
                arr[i]=score;
                ArrayList<Integer> setOfInteger =new ArrayList<>(arr[i]);
                List<String> namelist=new ArrayList<String>();
                namelist.add(names[i]);

                setOfInteger.add(arr[i]);
                //System.out.println(setOfInteger.get(i));
                 StyledDocument doc=(StyledDocument) jtxtTranscript.getDocument();
                
                 Style style= doc.addStyle("StyleName", null);
                //StyleConstants.setIcon(style, new ImageIcon(selectedFile.getAbsolutePath()));

                try {
                    doc.insertString(doc.getLength(), "\t\n"+Integer.toString(setOfInteger.get(i))
                    +"\t"+firstname+"\t"+surname
                  
            , style);
                } catch (BadLocationException ex) {
                Logger.getLogger(Term2.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;

            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton_Gr4ActionPerformed

    private void jButton_Gr5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Gr5ActionPerformed
        // code to calculate ranking for all grade 3
       // code to calculate ranking for all grade 3
         jtxtTranscript.setText(null);
        jtxtTranscript.setText("Students over all ranking for Grade 5: End of Year\n"
            + "________________________________________________________________________________________________________________\n"
            + "Place \t Name\t Surname \n\n");
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT    overall.FirstName,    overall.Total_Score,  overall.LastName , @prev := @curr,    @curr := Total_Score,\n" +
            " @rank := IF(@prev = @curr,@rank, @rank +1) AS Overall_Ranking    FROM\n" +
            " overall,(SELECT @curr := null, @prev := null, @rank :=0) tmp_tbl\n" +
            " WHERE overall.Grade='Grade5'&& YEAR(overall.created_at)=YEAR(CURDATE()) ORDER BY overall.Total_Score DESC";
            ResultSet rs=stmt.executeQuery(sql);
            int[] scores;
            while(rs.next()){
                String firstname=rs.getString("FirstName");
                String surname=rs.getString("LastName");
                int score=rs.getInt("Overall_Ranking");

                int i=0;
                int[] arr=new int[300];
                String[] names = new String[300];
                names[i]=firstname;
                int rank=1;
                arr[i]=score;
                ArrayList<Integer> setOfInteger =new ArrayList<>(arr[i]);
                List<String> namelist=new ArrayList<String>();
                namelist.add(names[i]);

                setOfInteger.add(arr[i]);
                //System.out.println(setOfInteger.get(i));
                 StyledDocument doc=(StyledDocument) jtxtTranscript.getDocument();
                
                 Style style= doc.addStyle("StyleName", null);
                //StyleConstants.setIcon(style, new ImageIcon(selectedFile.getAbsolutePath()));

                try {
                    doc.insertString(doc.getLength(), "\t\n"+Integer.toString(setOfInteger.get(i))
                    +"\t"+firstname+"\t"+surname
                  
            , style);
                } catch (BadLocationException ex) {
                Logger.getLogger(Term2.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;

            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton_Gr5ActionPerformed

    private void jButton_gr6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gr6ActionPerformed
        // code to calculate ranking for all grade 3
        // code to calculate ranking for all grade 3
         jtxtTranscript.setText(null);
        jtxtTranscript.setText("Students over all ranking for Grade 6: End of Year\n"
            + "________________________________________________________________________________________________________________\n"
            + "Place \t Name\t Surname \n\n");
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT    overall.FirstName,    overall.Total_Score,  overall.LastName , @prev := @curr,    @curr := Total_Score,\n" +
            " @rank := IF(@prev = @curr,@rank, @rank +1) AS Overall_Ranking    FROM\n" +
            " overall,(SELECT @curr := null, @prev := null, @rank :=0) tmp_tbl\n" +
            " WHERE overall.Grade='Grade6'&& YEAR(overall.created_at)=YEAR(CURDATE()) ORDER BY overall.Total_Score DESC";
            ResultSet rs=stmt.executeQuery(sql);
            int[] scores;
            while(rs.next()){
                String firstname=rs.getString("FirstName");
                String surname=rs.getString("LastName");
                int score=rs.getInt("Overall_Ranking");

                int i=0;
                int[] arr=new int[300];
                String[] names = new String[300];
                names[i]=firstname;
                int rank=1;
                arr[i]=score;
                ArrayList<Integer> setOfInteger =new ArrayList<>(arr[i]);
                List<String> namelist=new ArrayList<String>();
                namelist.add(names[i]);

                setOfInteger.add(arr[i]);
                //System.out.println(setOfInteger.get(i));
                 StyledDocument doc=(StyledDocument) jtxtTranscript.getDocument();
                
                 Style style= doc.addStyle("StyleName", null);
                //StyleConstants.setIcon(style, new ImageIcon(selectedFile.getAbsolutePath()));

                try {
                    doc.insertString(doc.getLength(), "\t\n"+Integer.toString(setOfInteger.get(i))
                    +"\t"+firstname+"\t"+surname
                  
            , style);
                } catch (BadLocationException ex) {
                Logger.getLogger(Term2.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;

            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton_gr6ActionPerformed

    private void jButton_gr7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gr7ActionPerformed
        // code to calculate ranking for all grade 3
        jtxtTranscript.setText(null);
        jtxtTranscript.setText("Students over all ranking for Grade 7: End of Year\n"
            + "________________________________________________________________________________________________________________\n"
            + "Place \t Name\t Surname \n\n");
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT    overall.FirstName,    overall.Total_Score,  overall.LastName , @prev := @curr,    @curr := Total_Score,\n" +
            " @rank := IF(@prev = @curr,@rank, @rank +1) AS Overall_Ranking    FROM\n" +
            " overall,(SELECT @curr := null, @prev := null, @rank :=0) tmp_tbl\n" +
            " WHERE overall.Grade='Grade7'&& YEAR(overall.created_at)=YEAR(CURDATE()) ORDER BY overall.Total_Score DESC";
            ResultSet rs=stmt.executeQuery(sql);
            int[] scores;
            while(rs.next()){
                String firstname=rs.getString("FirstName");
                String surname=rs.getString("LastName");
                int score=rs.getInt("Overall_Ranking");

                int i=0;
                int[] arr=new int[300];
                String[] names = new String[300];
                names[i]=firstname;
                int rank=1;
                arr[i]=score;
                ArrayList<Integer> setOfInteger =new ArrayList<>(arr[i]);
                List<String> namelist=new ArrayList<String>();
                namelist.add(names[i]);

                setOfInteger.add(arr[i]);
                //System.out.println(setOfInteger.get(i));
                 StyledDocument doc=(StyledDocument) jtxtTranscript.getDocument();
                
                 Style style= doc.addStyle("StyleName", null);
                //StyleConstants.setIcon(style, new ImageIcon(selectedFile.getAbsolutePath()));

                try {
                    doc.insertString(doc.getLength(), "\t\n"+Integer.toString(setOfInteger.get(i))
                    +"\t"+firstname+"\t"+surname
                  
            , style);
                } catch (BadLocationException ex) {
                Logger.getLogger(Term2.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;

            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton_gr7ActionPerformed

    private void jButton_gr8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gr8ActionPerformed
        // code to calculate ranking for all grade 3
        jtxtTranscript.setText(null);
        jtxtTranscript.setText("Students over all ranking for Grade 8: End of Year\n"
            + "________________________________________________________________________________________________________________\n"
            + "Place \t Name\t Surname \n\n");
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT    overall.FirstName,    overall.Total_Score,  overall.LastName , @prev := @curr,    @curr := Total_Score,\n" +
            " @rank := IF(@prev = @curr,@rank, @rank +1) AS Overall_Ranking    FROM\n" +
            " overall,(SELECT @curr := null, @prev := null, @rank :=0) tmp_tbl\n" +
            " WHERE overall.Grade='Grade8'&& YEAR(overall.created_at)=YEAR(CURDATE()) ORDER BY overall.Total_Score DESC";
            ResultSet rs=stmt.executeQuery(sql);
            int[] scores;
            while(rs.next()){
                String firstname=rs.getString("FirstName");
                String surname=rs.getString("LastName");
                int score=rs.getInt("Overall_Ranking");

                int i=0;
                int[] arr=new int[300];
                String[] names = new String[300];
                names[i]=firstname;
                int rank=1;
                arr[i]=score;
                ArrayList<Integer> setOfInteger =new ArrayList<>(arr[i]);
                List<String> namelist=new ArrayList<String>();
                namelist.add(names[i]);

                setOfInteger.add(arr[i]);
                //System.out.println(setOfInteger.get(i));
                 StyledDocument doc=(StyledDocument) jtxtTranscript.getDocument();
                
                 Style style= doc.addStyle("StyleName", null);
                //StyleConstants.setIcon(style, new ImageIcon(selectedFile.getAbsolutePath()));

                try {
                    doc.insertString(doc.getLength(), "\t\n"+Integer.toString(setOfInteger.get(i))
                    +"\t"+firstname+"\t"+surname
                  
            , style);
                } catch (BadLocationException ex) {
                Logger.getLogger(Term2.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;

            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton_gr8ActionPerformed

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

    private void jcmbGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbGradeActionPerformed
        // TODO add your handling code here:
        jcmbGrade.getActionListeners();
    }//GEN-LAST:event_jcmbGradeActionPerformed

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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // Shows selected table row onto Panel area
        int ind=jTable1.getSelectedRow();
        ShowItemToFields(ind);
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Student_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Result().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_Gr4;
    private javax.swing.JButton jButton_Gr5;
    private javax.swing.JButton jButton_Grade3;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_gr6;
    private javax.swing.JButton jButton_gr7;
    private javax.swing.JButton jButton_gr8;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
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
