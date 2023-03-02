
package studentrecordapp;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import static java.nio.channels.AsynchronousFileChannel.open;
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
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.text.*;


/**
 *
 * @author MUC
 */
public class Term3 extends javax.swing.JFrame {

    /**
     * Creates new form Term3
     */
    public Term3() {
        initComponents();
           jtxtFirstname.setText("");
            jtxtSurname.setText("");
            jtxtMaths.setText("0");
            jtxtEnglish.setText("0");
            jtxtScience.setText("0");
            jtxtSocialScience.setText("0");
            jtxtMAL.setText("0");
            jtxtHPE.setText("0");
            jtxtArts.setText("0");
            jtxtTotalScore.setText("0");
            jtxtAverage.setText("0");
            //jtxtRanking.setText("");
            jtxtStudent.setText("0");
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
            String q="SELECT * FROM term3 WHERE YEAR(term3.created_at)=YEAR(CURDATE())";
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
            row[13]=al.get(i).getGrade();
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
        jPanel1 = new javax.swing.JPanel();
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
        jbtnEnglish = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jcmbCourseCode = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jbtnMaths = new javax.swing.JButton();
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
        jButton_MAL = new javax.swing.JButton();
        jButton_HPE = new javax.swing.JButton();
        jButton_Arts = new javax.swing.JButton();
        jButton_SocialScience = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtTranscript = new javax.swing.JTextPane();
        jbtnExit = new javax.swing.JButton();
        jbtnTranscripts = new javax.swing.JButton();
        jbtnReset = new javax.swing.JButton();
        jbtnRefresh = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jbtnAddRecord = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jtxtSearch = new javax.swing.JTextField();
        jButton_print = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButton_Grade4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), null), "Students Records Term 3", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 255, 0))); // NOI18N

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

        jbtnEnglish.setText("Maths");
        jbtnEnglish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEnglishActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("MAL:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Class Grade");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Heahtl/PE:");

        jcmbCourseCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grade3", "Grade4", "Grade5", "Grade6", "Grade7", "Grade8" }));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Arts:");

        jbtnMaths.setText("English");
        jbtnMaths.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMathsActionPerformed(evt);
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

        jButton_MAL.setText("MAL");
        jButton_MAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MALActionPerformed(evt);
            }
        });

        jButton_HPE.setText("H/PE");
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

        jButton_SocialScience.setText("S/ Science");
        jButton_SocialScience.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SocialScienceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcmbCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtTotalScore)
                            .addComponent(jtxtAverage)
                            .addComponent(jtxtFirstname)
                            .addComponent(jtxtSurname)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtxtStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtHPE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jtxtMAL, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtSocialScience, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtScience)
                            .addComponent(jtxtArts)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtEnglish)
                            .addComponent(jtxtMaths))))
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_SocialScience, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Science, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_MAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_HPE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Arts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnMaths, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnEnglish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtxtStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtxtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtxtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jcmbCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtxtTotalScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtxtAverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtxtMaths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnEnglish))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtxtEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnMaths))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jtxtScience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jtxtSocialScience, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jtxtMAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jtxtHPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jtxtArts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_Science)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_SocialScience)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_MAL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_HPE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Arts)))))
                .addGap(18, 18, 18)
                .addComponent(jButton2))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), null), "Results", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 255, 0))); // NOI18N

        jScrollPane2.setViewportView(jtxtTranscript);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jbtnExit.setBackground(new java.awt.Color(255, 255, 255));
        jbtnExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnExit.setText("Exit");
        jbtnExit.setPreferredSize(new java.awt.Dimension(67, 23));
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
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

        jButton_update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_update.setText("Update");
        jButton_update.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

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

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 102, 102), null), "Rankings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 255, 0))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(0, 102, 102));

        jButton_Grade4.setText("GRADE 3");
        jButton_Grade4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Grade4ActionPerformed(evt);
            }
        });

        jButton9.setText("GRADE 4");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("GRADE 5");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("GRADE 6");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("GRADE 7");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("GRADE 8");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jButton_Grade4)
                .addGap(42, 42, 42)
                .addComponent(jButton9)
                .addGap(54, 54, 54)
                .addComponent(jButton10)
                .addGap(61, 61, 61)
                .addComponent(jButton11)
                .addGap(65, 65, 65)
                .addComponent(jButton12)
                .addGap(64, 64, 64)
                .addComponent(jButton13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Grade4)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnTranscripts, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jbtnAddRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_print, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(557, 914, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnTranscripts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnReset)
                    .addComponent(jbtnAddRecord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_print, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jbtnEnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEnglishActionPerformed
        try {
            new MathJFrame().setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jbtnEnglishActionPerformed

    private void jbtnMathsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMathsActionPerformed
        // brings window to add English scores
        try {
            new EnglishJFrame2().setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jbtnMathsActionPerformed

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

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        // Code to exit from the App

        try{
            //new  Student_Result().setVisible(true);
            // int close = MathsJFrame.EXIT_ON_CLOSE;
            dispose();
        }catch(Exception e){
            System.out.println(e);
        }

       /* try {
            new MainJFrame().setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }*/
    }//GEN-LAST:event_jbtnExitActionPerformed

    private void jbtnTranscriptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTranscriptsActionPerformed
        // Code to display transcripts
        jtxtTranscript.setText(null);
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
        if(arr[0]>=95)
        {
            mathsGrade = "A+";
        }
        else if (arr[0] >= 90)
        {
            mathsGrade = "A" ;
        }
        else if (arr[0] >= 85)
        {
            mathsGrade= "B+";
        }
        else if (arr[0] >= 80)
        {
            mathsGrade="B";
        }
        else if (arr[0] >= 75)
        {
            mathsGrade= "C+";
        }
        else if (arr[0] >= 70)
        {
            mathsGrade= "C";
        }
        else if (arr[0] >= 65)
        {
            mathsGrade= "D+";
        }
        else if(arr[0]>= 60)
        {
            mathsGrade= "D";
       }
        else if(arr[0]>= 55)
        {
            mathsGrade= "E+";
        }
        else if(arr[0]>=50)
        {
            mathsGrade= "E";
        }
        else if(arr[0]< 50)
        {
            mathsGrade= "F";
        }
        //Calculate grade for English
         if(arr[1]>=95)
        {
            engGrade = "A+";
        }
         else if (arr[1] >= 90)
        {
            engGrade = "A" ;
        }
        else if (arr[1] >= 85)
        {
            engGrade= "B+";
        }
        else if (arr[1] >= 80)
        {
            engGrade="B";
        }
        else if (arr[1] >= 75)
        {
            engGrade= "C+";
        }
        else if (arr[1] >= 70)
        {
            engGrade= "C";
        }
        else if (arr[1] >= 65)
        {
            engGrade= "D+";
        }
        else if(arr[1]>= 60)
        {
            engGrade= "D";
       }
        else if(arr[1]>= 55)
        {
            engGrade= "E+";
        }
        else if(arr[1]>=50)
        {
            engGrade= "E";
        }
        else if(arr[1]< 50)
        {
            engGrade= "F";
        }
        //Calculate grade for science
         if(arr[2]>=95)
        {
            sciGrade = "A+";
        }
         else if (arr[2] >= 90)
        {
            sciGrade = "A" ;
        }
        else if (arr[2] >= 85)
        {
            sciGrade= "B+";
        }
        else if (arr[2] >= 80)
        {
            sciGrade="B";
        }
        else if (arr[2] >= 75)
        {
            sciGrade= "C+";
        }
        else if (arr[2] >= 70)
        {
            sciGrade= "C";
        }
        else if (arr[2] >= 65)
        {
            sciGrade= "D+";
        }
        else if(arr[2]>= 60)
        {
            sciGrade= "D";
       }
        else if(arr[2]>= 55)
        {
            sciGrade= "E+";
        }
        else if(arr[2]>=50)
        {
            sciGrade= "E";
        }
        else if(arr[2]< 50)
        {
            sciGrade= "F";
        }
        //calculate grade for science
         if(arr[3]>=95)
        {
            socsGrade = "A+";
        }
         else if (arr[3] >= 90)
        {
            socsGrade = "A" ;
        }
        else if (arr[3] >= 85)
        {
            socsGrade= "B+";
        }
        else if (arr[3] >= 80)
        {
            socsGrade="B";
        }
        else if (arr[3] >= 75)
        {
            socsGrade= "C+";
        }
        else if (arr[3] >= 70)
        {
            socsGrade= "C";
        }
        else if (arr[3] >= 65)
        {
            socsGrade= "D+";
        }
        else if(arr[3]>= 60)
        {
            socsGrade= "D";
       }
        else if(arr[3]>= 55)
        {
            socsGrade= "E+";
        }
        else if(arr[3]>=50)
        {
            socsGrade= "E";
        }
        else if(arr[3]< 50)
        {
            socsGrade= "F";
        }
        //calculate grad for MAL
         if(arr[4]>=95)
        {
            malGrade = "A+";
        }
         else if (arr[4] >= 90)
        {
            malGrade = "A" ;
        }
        else if (arr[4] >= 85)
        {
            malGrade= "B+";
        }
        else if (arr[4] >= 80)
        {
            malGrade="B";
        }
        else if (arr[4] >= 75)
        {
            malGrade= "C+";
        }
        else if (arr[4] >= 70)
        {
            malGrade= "C";
        }
        else if (arr[4] >= 65)
        {
            malGrade= "D+";
        }
        else if(arr[4]>= 60)
        {
            malGrade= "D";
       }
        else if(arr[4]>= 55)
        {
            malGrade= "E+";
        }
        else if(arr[4]>=50)
        {
            malGrade= "E";
        }
        else if(arr[4]< 50)
        {
            malGrade= "F";
        }
        //calculate grade for HPE
         if(arr[5]>=95)
        {
            hpeGrade = "A+";
        }
         else if (arr[5] >= 90)
        {
            hpeGrade = "A" ;
        }
        else if (arr[5] >= 85)
        {
            hpeGrade= "B+";
        }
        else if (arr[5] >= 80)
        {
            hpeGrade="B";
        }
        else if (arr[5] >= 75)
        {
            hpeGrade= "C+";
        }
        else if (arr[5] >= 70)
        {
            hpeGrade= "C";
        }
        else if (arr[5] >= 65)
        {
            hpeGrade= "D+";
        }
        else if(arr[5]>= 60)
        {
            hpeGrade= "D";
       }
        else if(arr[5]>= 55)
        {
            hpeGrade= "E+";
        }
        else if(arr[5]>=50)
        {
            hpeGrade= "E";
        }
        else if(arr[5]< 50)
        {
            hpeGrade= "F";
        }
        //calculate grade for arts
         if(arr[6]>=95)
        {
            artsGrade = "A+";
        }
         else if (arr[6] >= 90)
        {
            artsGrade = "A" ;
        }
        else if (arr[6] >= 85)
        {
            artsGrade= "B+";
        }
        else if (arr[6] >= 80)
        {
            artsGrade="B";
        }
        else if (arr[6] >= 75)
        {
           artsGrade= "C+";
        }
        else if (arr[6] >= 70)
        {
            artsGrade= "C";
        }
        else if (arr[6] >= 65)
        {
            artsGrade= "D+";
        }
        else if(arr[6]>= 60)
        {
            artsGrade= "D";
       }
        else if(arr[6]>= 55)
        {
            artsGrade= "E+";
        }
        else if(arr[6]>=50)
        {
            artsGrade= "E";
        }
        else if(arr[6]< 50)
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
             +"\n\nTeacher's Comments: "
            +"\n\nClass Teacher: "

                    
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
        for(Component c:jPanel1.getComponents()){
            if(c.getClass().toString().contains("javax.swing.JTextField")){
                temp=(JTextField)c;
                temp.setText("0");
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
            PreparedStatement ps;
            PreparedStatement ps2;
            ps = conn.prepareStatement("insert into term3 (StudentID,"
                + "FirstName, LastName, Total_Score, Science,"
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
            
            String value=jcmbCourseCode.getSelectedItem().toString();
            ps.setString(13, value);

            int res=ps.executeUpdate();
            if (res>=1){
                JOptionPane.showMessageDialog(null, res+" Number of student inserted"
                    + " into database");
            }else
            JOptionPane.showMessageDialog(null, "Student insertion failed");
            
            //add record to over all table
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
"FROM term3 ot inner join overall op on op.StudentID = ot.StudentID \n" +
"GROUP BY op.StudentID\n" +
") as o1 on o.StudentID = o1.StudentID\n" +
"SET Total_Score=Total_Score_ot+Total_Score_op,\n" +
" English=English_ot+English_op,\n" +
" Maths=Maths_ot+Maths_op,\n" +
" Science=Science_ot+Science_op,\n" +
" Social_Science=Social_Science_ot+Social_Science_op,\n" +
" MAL=MAL_ot+MAL_op,\n" +
" HPE=HPE_ot+HPE_op,\n" +
" Arts=Arts_ot+Arts_op\n" +
"    \n" +
"   \n" +
"   ");


            int res2=ps2.executeUpdate();
            if (res>=1){
                JOptionPane.showMessageDialog(null, res+" Number of student inserted to overall records"
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
"FROM term3 ot inner join overall op on op.StudentID = ot.StudentID \n" +
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

                //delete record from term3 db
                 qry="delete from term3 where StudentID=?";
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
            String qry="select * from term3 where FirstName like '%"+val+"%'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            StudentBean2 student;
            while (rs.next()){
                student =new StudentBean2(rs.getInt(1), rs.getString("FirstName"),
                    rs.getString("LastName"), rs.getInt(4), rs.getInt(13)
                    , rs.getInt(22), rs.getInt(31), rs.getInt(40), rs.getInt(49)
                    , rs.getInt(58), rs.getInt(67), rs.getInt(69), rs.getInt(70),
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
                row[13]=al.get(i).getGrade();
                model.addRow(row);
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
            String qry="select * from term3 where Firstname like '%"+val+"%'";
            //Statement st=conn.createStatement();
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            StudentBean2 student;
            while (rs.next()){
                student =new StudentBean2(rs.getInt(1), rs.getString("FirstName"),
                    rs.getString("LastName"), rs.getInt(4), rs.getInt(5)
                    , rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)
                    , rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13),
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
                row[11]=al.get(i).getGrade();
                row[12]=al.get(i).getGPA();
                model.addRow(row);
            }
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

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
       String qry=null;
        PreparedStatement ps,ps2,ps3,ps4,ps5=null;
        Connection conn=MySqlConnection();

        if(jtxtStudent!=null && jtxtFirstname!=null && jtxtSurname!=null
            && jtxtMaths!=null || jtxtEnglish!=null || jtxtScience!=null
            || jtxtSocialScience!=null|| jtxtMAL!=null|| jtxtHPE!=null){
            
            try{
                
                //delete  record in overall table
                ps2=null;
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
"FROM term3 ot inner join overall op on op.StudentID = ot.StudentID \n" +
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
            
                    //delete records in  Grade 8 Internal Assessment for the new updates
                   PreparedStatement ps10=null;
             ps10 = conn.prepareStatement("update g8internal o inner join\n" +
"       (select ot.StudentID, sum(ot.Total_Score) as Total_Score_ot,\n"
                     + "sum(ot.Maths) as Maths_ot,\n"
                     + "sum(ot.English) as English_ot,\n"
                     + "sum(ot.Science) as Science_ot,\n"
                     + "sum(ot.Social_Science) as Social_Science_ot,\n"
                     + "sum(ot.MAL) as MAL_ot,\n"
                     + "sum(ot.HPE) as HPE_ot,\n"
                     + "sum(ot.Arts) as Arts_ot\n"+
"        from term3 ot\n"
  //                   + "WHERE ot.FirstName = o.FirstName AND ot.LastName = o.LastName\n" +
+"        where ot.Grade = 'Grade8'\n" +
"        group by ot.StudentId\n" +
"       ) ot\n" +
"       using (StudentID)\n" +
"    set Total_Score = o.Total_Score - Total_Score_ot,\n"
                     + "Maths = o.Maths - Maths_ot,\n"
                     + "English = o.English - English_ot,\n"
                     + "Science = o.Science - Science_ot,\n"
                     + "Social_Science = o.Social_Science - Social_Science_ot,\n"
                     + "MAL = o.MAL - MAL_ot,\n"
                     + "HPE = o.HPE - HPE_ot,\n"
                     + "Arts = o.Arts - Arts_ot\n");
             
                int res10=ps10.executeUpdate();
                if (res10>=1){
                    JOptionPane.showMessageDialog(null, res10+" Number of student deleted to Gr 8 internal"
                        + " in database");
                }else
                JOptionPane.showMessageDialog(null, "Student updation to Gr 8 internal failed");
                
                //delete records in  Grade 734 database
                   PreparedStatement ps18=null;
             ps18 = conn.prepareStatement("update g734 o inner join\n" +
                            "       (select ot.StudentID, sum(ot.Total_Score) as Total_Score_ot,\n"
                            + "sum(ot.English) as English_ot,\n"
                     + "sum(ot.Maths) as Maths_ot,\n"
                     + "sum(ot.Science) as Science_ot,\n"
                     + "sum(ot.Social_Science) as Social_Science_ot,\n"
                     + "sum(ot.MAL) as MAL_ot,\n"
                     + "sum(ot.HPE) as HPE_ot,\n"
                     + "sum(ot.Arts) as Arts_ot\n"
                            +
                            "        from term3 ot\n" +
                            "        where ot.Grade = 'Grade7'\n" +
                            "        group by ot.StudentId\n" +
                            "       ) ot\n" +
                            "       using (StudentID)\n" +
                            "    set o.Total_Score = o.Total_Score - Total_Score_ot,\n"
                            + "o.English = o.English - English_ot,\n"
                     + "o.Maths = o.Maths - Maths_ot,\n"
                     + "o.MAL = o.MAL - MAL_ot,\n"
                     + "o.HPE = o.HPE - HPE_ot,\n"
                     + "o.Arts = o.Arts - Arts_ot,\n"
                     + "o.Science = o.Science - Science_ot,\n"
                     + "o.Social_Science = o.Social_Science - Social_Science_ot\n");
             
                int res18=ps18.executeUpdate();
                
                //delete records in  Grade 8 Internal Assessment for the new grade 7 marks updates
    /*               PreparedStatement ps11=null;
             ps11 = conn.prepareStatement("update g8internal o inner join\n" +
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
//"FROM term3 ot inner join g8internal op on op.StudentID = ot.StudentID \n"
                      "FROM term3 ot inner join g8internal op" +
"WHERE op.FirstName = ot.FirstName AND op.LastName = ot.LastName\n" +
"GROUP BY op.StudentID\n" +
") as o1 on o.StudentID = o1.StudentID\n" +
"SET Total_Score=Total_Score_op - Total_Score_ot,\n" +
" o.English=English_op - English_ot,\n" +
" o.Maths=Maths_op - Maths_ot,\n" +
" o.Science=Science_op - Science_ot,\n" +
" o.Social_Science=Social_Science_op - Social_Science_ot,\n" +
" o.MAL=MAL_op - MAL_ot,\n" +
" o.HPE=HPE_op - HPE_ot,\n" +
" o.Arts=Arts_op - Arts_ot");
             
                int res11=ps11.executeUpdate(); */
                
                 //delete records in  assessment period 2 for the new updates
                
                ps4=null;
                ps4 = conn.prepareStatement("UPDATE assp2 AS c\n" +
                "LEFT JOIN (\n" +
                "SELECT StudentID, SUM(Total_Score) AS TotalScoret1\n,"
                + "SUM(Maths) AS Mathst1\n,"
                + "SUM(English) AS Englisht1\n,"
                + "SUM(Science) AS Sciencet1\n,"
                + "SUM(Social_Science) AS SocSciencet1\n,"
                + "SUM(MAL) AS MALt1\n,"
                + "SUM(HPE) AS HPEt1\n,"
                + "SUM(Arts) AS Artst1\n"
                +"FROM term3\n" +
                "GROUP BY StudentID\n" +
                ") AS p ON c.StudentID = p.StudentID\n" +
                "LEFT JOIN (\n" +
                "SELECT StudentID, SUM(Total_Score) AS TotalScoret2,\n" 
                + "SUM(Maths) AS Mathst2\n,"
                + "SUM(English) AS Englisht2\n,"
                + "SUM(Science) AS Sciencet2\n,"
                + "SUM(Social_Science) AS SocSciencet2\n,"
                + "SUM(MAL) AS MALt2\n,"
                + "SUM(HPE) AS HPEt2\n,"
                + "SUM(Arts) AS Artst2\n"
                +"FROM term4\n" +
                "GROUP BY StudentID\n" +
                ") AS l ON c.StudentID = l.StudentID\n" +
                "SET c.Total_Score = c.Total_Score - c.Total_Score,"
                        + "c.Maths = c.Maths - c.Maths,"
                        + "c.English = c.English - c.English,"
                        + "c.Science = c.Science - c.Science,"
                        + "c.Social_Science = c.Social_Science - c.Social_Science,"
                        + "c.Arts = c.Arts - c.Arts,"
                        + "c.MAL = c.MAL - c.MAL,"
                        + "c.HPE = c.HPE - c.HPE");

                int res4=ps4.executeUpdate();
                                                                
              //execute update on updated value in db
                qry="update term3 set FirstName=?, LastName=?, Maths=? "
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
                ps3=null;
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
"FROM term3 ot inner join overall op on op.StudentID = ot.StudentID \n" +
"GROUP BY op.StudentID\n" +
") as o1 on o.StudentID = o1.StudentID\n" +
"SET o.Total_Score=Total_Score_op+Total_Score_ot,\n" +
" o.English=English_op+English_ot,\n" +
" o.Maths=Maths_op+Maths_ot,\n" +
" o.Science=Science_op+Science_ot,\n" +
" o.Social_Science=Social_Science_op+Social_Science_ot,\n" +
" o.MAL=MAL_op+MAL_ot,\n" +
" o.HPE=HPE_op+HPE_ot,\n" +
" o.Arts=Arts_op+Arts_ot\n" +
"    \n" +
"   \n" +
"    ");
             
            int res3=ps3.executeUpdate();
            if (res3>=1){
                JOptionPane.showMessageDialog(null, res+" Number of student updated in overall records"
                    + " in database");
            }else
            JOptionPane.showMessageDialog(null, "Student updation failed");
            
           

                //update record to assessment period 2
                ps5=null;
                ps5 = conn.prepareStatement("UPDATE assp2 AS c\n" +
                "LEFT JOIN (\n" +
                "SELECT StudentID, SUM(Total_Score) AS TotalScoret1\n,"
                + "SUM(Maths) AS Mathst1\n,"
                + "SUM(English) AS Englisht1\n,"
                + "SUM(Science) AS Sciencet1\n,"
                + "SUM(Social_Science) AS SocSciencet1\n,"
                + "SUM(MAL) AS MALt1\n,"
                + "SUM(HPE) AS HPEt1\n,"
                + "SUM(Arts) AS Artst1\n"
                +"FROM term3\n" +
                "GROUP BY StudentID\n" +
                ") AS p ON c.StudentID = p.StudentID\n" +
                "LEFT JOIN (\n" +
                "SELECT StudentID, SUM(Total_Score) AS TotalScoret2,\n" 
                + "SUM(Maths) AS Mathst2\n,"
                + "SUM(English) AS Englisht2\n,"
                + "SUM(Science) AS Sciencet2\n,"
                + "SUM(Social_Science) AS SocSciencet2\n,"
                + "SUM(MAL) AS MALt2\n,"
                + "SUM(HPE) AS HPEt2\n,"
                + "SUM(Arts) AS Artst2\n"
                +"FROM term4\n" +
                "GROUP BY StudentID\n" +
                ") AS l ON c.StudentID = l.StudentID\n" +
                "SET c.Total_Score = COALESCE(p.TotalScoret1, 0) + COALESCE(l.TotalScoret2, 0),\n"
                        + "c.Maths = COALESCE(p.Mathst1, 0) + COALESCE(l.Mathst2, 0),\n"
                        + "c.English = COALESCE(p.Englisht1, 0) + COALESCE(l.Englisht2, 0),\n"
                        + "c.Science = COALESCE(p.Sciencet1, 0) + COALESCE(l.Sciencet2, 0),\n"
                        + "c.Social_Science = COALESCE(p.SocSciencet1, 0) + COALESCE(l.SocSciencet2, 0),\n"
                        + "c.Arts = COALESCE(p.Artst1, 0) + COALESCE(l.Artst2, 0),\n"
                        + "c.MAL = COALESCE(p.MALt1, 0) + COALESCE(l.MALt2, 0),\n"
                        + "c.HPE = COALESCE(p.HPEt1, 0) + COALESCE(l.HPEt2, 0)");

                int res5=ps5.executeUpdate();
                
                    //****************************************************************************************
        
                
                
           //update Grade 8 internal records
                PreparedStatement ps14=null;
             ps14 = conn.prepareStatement("update g8internal o inner join\n" +
"       (select ot.StudentID, sum(ot.Total_Score) as Total_Score_ot,\n"
                     + "sum(ot.Maths) as Maths_ot,\n"
                     + "sum(ot.English) as English_ot,\n"
                     + "sum(ot.Science) as Science_ot,\n"
                     + "sum(ot.Social_Science) as Social_Science_ot,\n"
                     + "sum(ot.MAL) as MAL_ot,\n"
                     + "sum(ot.HPE) as HPE_ot,\n"
                     + "sum(ot.Arts) as Arts_ot\n"+
"        from term3 ot\n"
//                     + "WHERE ot.FirstName = o.FirstName AND ot.LastName = o.LastName\n" +
+"        where ot.Grade = 'Grade8'\n" +
                    
"        group by ot.StudentId\n" +
"       ) ot\n" +
"       using (StudentID)\n" +
"    set Total_Score =o.Total_Score + Total_Score_ot,\n"
                     + "Maths = o.Maths + Maths_ot,\n"
                     + "English = o.English + English_ot,\n"
                     + "Science = o.Science + Science_ot,\n"
                     + "Social_Science = o.Social_Science + Social_Science_ot,\n"
                     + "MAL = o.MAL + MAL_ot,\n"
                     + "HPE = o.HPE + HPE_ot,\n"
                     + "Arts = o.Arts + Arts_ot\n");
             
                int res14=ps14.executeUpdate();
                if (res14>=1){
                    JOptionPane.showMessageDialog(null, res14+" Number of student updated to Gr 8 internal"
                        + " in database");
                }else
                JOptionPane.showMessageDialog(null, "Student updation to Gr 8 internal failed");  
                
                //update records in  Grade 734 database
                   PreparedStatement ps19=null;
             ps19 = conn.prepareStatement("update g734 o inner join\n" +
                            "       (select ot.StudentID, sum(ot.Total_Score) as Total_Score_ot,\n"
                            + "sum(ot.English) as English_ot,\n"
                     + "sum(ot.Maths) as Maths_ot,\n"
                     + "sum(ot.Science) as Science_ot,\n"
                     + "sum(ot.Social_Science) as Social_Science_ot,\n"
                     + "sum(ot.MAL) as MAL_ot,\n"
                     + "sum(ot.HPE) as HPE_ot,\n"
                     + "sum(ot.Arts) as Arts_ot\n"
                            +
                            "        from term3 ot\n" +
                            "        where ot.Grade = 'Grade7'\n" +
                            "        group by ot.StudentId\n" +
                            "       ) ot\n" +
                            "       using (StudentID)\n" +
                            "    set o.Total_Score = o.Total_Score + Total_Score_ot,\n"
                            + "o.English = o.English + English_ot,\n"
                     + "o.Maths = o.Maths + Maths_ot,\n"
                     + "o.MAL = o.MAL + MAL_ot,\n"
                     + "o.HPE = o.HPE + HPE_ot,\n"
                     + "o.Arts = o.Arts + Arts_ot,\n"
                     + "o.Science = o.Science + Science_ot,\n"
                     + "o.Social_Science = o.Social_Science + Social_Science_ot\n");
             
                int res19=ps19.executeUpdate();
                
                //update records in  Grade 8 Internal Assessment with  grade 7 term 3 and marks updates
    /*             PreparedStatement ps15=null;
             ps15 = conn.prepareStatement("update g8internal o inner join\n" +
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
"FROM g734 ot inner join g8internal op \n"
                     + "WHERE  ot.FirstName = op.FirstName AND ot.LastName = op.LastName\n" +
"GROUP BY op.StudentID\n" +
") as o1 on o.StudentID = o1.StudentID\n" +
"SET Total_Score=Total_Score_op - Total_Score_ot,\n" +
" English=English_op - English_ot,\n" +
" Maths=Maths_op - Maths_ot,\n" +
" Science=Science_op - Science_ot,\n" +
" Social_Science=Social_Science_op - Social_Science_ot,\n" +
" MAL=MAL_op - MAL_ot,\n" +
" HPE=HPE_op - HPE_ot,\n" +
" Arts=Arts_op - Arts_ot");
             
                int res15=ps15.executeUpdate();   */
                                   
        
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null," Fill out all boxes for student name, ID & marks!\n"+e);
            }
            jtxtFirstname.setText("");
            jtxtSurname.setText("");
            jtxtMaths.setText("0");
            jtxtEnglish.setText("0");
            jtxtScience.setText("0");
            jtxtSocialScience.setText("0");
            jtxtMAL.setText("0");
            jtxtHPE.setText("0");
            jtxtArts.setText("0");
            jtxtTotalScore.setText("0");
            jtxtAverage.setText("0");
            //jtxtRanking.setText("");
            jtxtStudent.setText("0");
        }else{

            JOptionPane.showMessageDialog(null, "Student Update failed...");

        }
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // Shows selected table row onto Panel area
        int ind=jTable1.getSelectedRow();
        ShowItemToFields(ind);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton_ScienceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ScienceActionPerformed
        // Brings up the Science menu to enter scores
        try{
            new ScienceJFrame().setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton_ScienceActionPerformed

    private void jButton_MALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MALActionPerformed
        // brings up the MAL menu to enter marks
        try{
            new MALJFrame().setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton_MALActionPerformed

    private void jButton_HPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HPEActionPerformed
        // brings up Health and PE menu to enter scores
        try{
            new HPEJFrame().setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton_HPEActionPerformed

    private void jButton_ArtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ArtsActionPerformed
        // Brings up Arts menu to enter scores
        try{
            new ArtsJFrame().setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton_ArtsActionPerformed

    private void jButton_SocialScienceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SocialScienceActionPerformed
        // Brings up Social Science menu to enter scores
        try{
            new SocialScienceJFrame().setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton_SocialScienceActionPerformed

    private void jButton_Grade4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Grade4ActionPerformed
        // code to calculate ranking for all grade 3
        jtxtTranscript.setText(null);
        jtxtTranscript.setText("Students over all ranking for Grade 3: Term 3\n"
            + "________________________________________________________________________________________________________________\n"
            + "Place \t Name\t Surname \n\n");
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT    term3.FirstName,    term3.Total_Score,  term3.LastName , @prev := @curr,    @curr := Total_Score,\n" +
            " @rank := IF(@prev = @curr,@rank, @rank +1) AS Overall_Ranking    FROM\n" +
            " term3,(SELECT @curr := null, @prev := null, @rank :=0) tmp_tbl\n" +
            " WHERE term3.Grade='Grade3' && YEAR(term3.created_at)=YEAR(CURDATE()) ORDER BY term3.Total_Score DESC";
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
       
    }//GEN-LAST:event_jButton_Grade4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // code to calculate ranking for all grade 4
        jtxtTranscript.setText(null);
        jtxtTranscript.setText("Students over all ranking for Grade 4: Term 3\n"
            + "________________________________________________________________________________________________________________\n"
            + "Place \t Name\t Surname \n\n");
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT    term3.FirstName,    term3.Total_Score,  term3.LastName , @prev := @curr,    @curr := Total_Score,\n" +
            " @rank := IF(@prev = @curr,@rank, @rank +1) AS Overall_Ranking    FROM\n" +
            " term3,(SELECT @curr := null, @prev := null, @rank :=0) tmp_tbl\n" +
            " WHERE term3.Grade='Grade4' && YEAR(term3.created_at)=YEAR(CURDATE()) ORDER BY term3.Total_Score DESC";
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
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // code to calculate ranking for all grade 3
        jtxtTranscript.setText(null);
        jtxtTranscript.setText("Students over all ranking for Grade 5: Term 3\n"
            + "________________________________________________________________________________________________________________\n"
            + "Place \t Name\t Surname \n\n");
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT    term3.FirstName,    term3.Total_Score,  term3.LastName , @prev := @curr,    @curr := Total_Score,\n" +
            " @rank := IF(@prev = @curr,@rank, @rank +1) AS Overall_Ranking    FROM\n" +
            " term3,(SELECT @curr := null, @prev := null, @rank :=0) tmp_tbl\n" +
            " WHERE term3.Grade='Grade5' && YEAR(term3.created_at)=YEAR(CURDATE()) ORDER BY term3.Total_Score DESC";
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
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // code to calculate ranking for all grade 3
        jtxtTranscript.setText(null);
        jtxtTranscript.setText("Students over all ranking for Grade 6: Term 3\n"
            + "________________________________________________________________________________________________________________\n"
            + "Place \t Name\t Surname \n\n");
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT    term3.FirstName,    term3.Total_Score,  term3.LastName , @prev := @curr,    @curr := Total_Score,\n" +
            " @rank := IF(@prev = @curr,@rank, @rank +1) AS Overall_Ranking    FROM\n" +
            " term3,(SELECT @curr := null, @prev := null, @rank :=0) tmp_tbl\n" +
            " WHERE term3.Grade='Grade6' && YEAR(term3.created_at)=YEAR(CURDATE()) ORDER BY term3.Total_Score DESC";
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
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // code to calculate ranking for all grade 3
        jtxtTranscript.setText(null);
        jtxtTranscript.setText("Students over all ranking for Grade 7: Term 3\n"
            + "________________________________________________________________________________________________________________\n"
            + "Place \t Name\t Surname \n\n");
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT    term3.FirstName,    term3.Total_Score,  term3.LastName , @prev := @curr,    @curr := Total_Score,\n" +
            " @rank := IF(@prev = @curr,@rank, @rank +1) AS Overall_Ranking    FROM\n" +
            " term3,(SELECT @curr := null, @prev := null, @rank :=0) tmp_tbl\n" +
            " WHERE term3.Grade='Grade7' && YEAR(term3.created_at)=YEAR(CURDATE()) ORDER BY term3.Total_Score DESC";
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
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // code to calculate ranking for all grade 8
        jtxtTranscript.setText(null);
        jtxtTranscript.setText("Students over all ranking for Grade 8: Term 3\n"
            + "________________________________________________________________________________________________________________\n"
            + "Place \t Name\t Surname \n\n");
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT    term3.FirstName,    term3.Total_Score,  term3.LastName , @prev := @curr,    @curr := Total_Score,\n" +
            " @rank := IF(@prev = @curr,@rank, @rank +1) AS Overall_Ranking    FROM\n" +
            " term3,(SELECT @curr := null, @prev := null, @rank :=0) tmp_tbl\n" +
            " WHERE term3.Grade='Grade8' && YEAR(term3.created_at)=YEAR(CURDATE()) ORDER BY term3.Total_Score DESC";
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
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

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
            java.util.logging.Logger.getLogger(Term3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Term3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Term3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Term3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Term3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton_Arts;
    private javax.swing.JButton jButton_Grade4;
    private javax.swing.JButton jButton_HPE;
    private javax.swing.JButton jButton_MAL;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnAddRecord;
    private javax.swing.JButton jbtnEnglish;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnMaths;
    private javax.swing.JButton jbtnRefresh;
    private javax.swing.JButton jbtnReset;
    private javax.swing.JButton jbtnTranscripts;
    private javax.swing.JComboBox<String> jcmbCourseCode;
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
