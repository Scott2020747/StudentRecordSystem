
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
 * @author MUC
 */
public class Term4 extends javax.swing.JFrame {

    /**
     * Creates new form Term4
     */
    public Term4() {
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
            String q="SELECT * FROM term4 WHERE YEAR(term4.created_at)=YEAR(CURDATE())";
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
       //jcmbGrade.getSelectedItem(retrieveData().get(index).getGrade());
        //String value=jcmbGrade.getSelectedItem().toString();
            //ps.setString(13, value);
        
              
        
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
        jbtnMaths = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jcmbGrade = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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
        jButton_SocialScience = new javax.swing.JButton();
        jButton_Science = new javax.swing.JButton();
        jButton_MAL = new javax.swing.JButton();
        jButton_HPE = new javax.swing.JButton();
        jButton_Arts = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtxtTranscript = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbtnTranscripts = new javax.swing.JButton();
        jbtnReset = new javax.swing.JButton();
        jbtnRefresh = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jbtnAddRecord = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jtxtSearch = new javax.swing.JTextField();
        jButton_print = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton_Grade3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), null), "Students Records Term 4", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 255, 0))); // NOI18N

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

        jbtnMaths.setText("Maths");
        jbtnMaths.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMathsActionPerformed(evt);
            }
        });

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

        jButton1.setText("English");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        jButton_SocialScience.setText("S/ Science");
        jButton_SocialScience.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SocialScienceActionPerformed(evt);
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
                        .addComponent(jLabel7)
                        .addGap(36, 36, 36)
                        .addComponent(jtxtMaths, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(30, 30, 30)
                        .addComponent(jtxtEnglish))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtHPE, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtMAL, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtSocialScience, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtScience)
                            .addComponent(jtxtArts))))
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_SocialScience, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnMaths, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Science, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_MAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_HPE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_Arts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
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
                            .addComponent(jbtnMaths))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtxtEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
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
                .addComponent(jButton2))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), null), "Results", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 255, 0))); // NOI18N

        jScrollPane3.setViewportView(jtxtTranscript);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtSearchKeyPressed(evt);
            }
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

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.Border                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnTranscripts, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
     , ‚ÛíÚ¸ #E|”Eé¼•×®ˆ+<#|´®:ªş:ø¿Ä¯fª<İÄ²‚/,ä_ù6Ví¾ZØ—_;§ºµ¼¼ƒ:àšxw¼…%|’~	  ÿÿœ›AG€{½Mb	DràäÀÁABò®L²ÄeË FœP !Ä¡Õ3Ó;ÓÚ™éqOÏ®7§å'n9.äÂ	‰EæÈâopæ{¯ª»«zzÖZÙSõê½ªWU¯^½zïuÏx:}İá2ök¶îtù‡KEKz±š¾+Š_ô7½YñZÑéïÊÔ—Õ‘ªeÙ\0¥ÑìH’dÈ@hî{M¼[VÄÿÀwÖä-·½ØÕÑÇD—ÇxÏY.›d+l	 <×x_â¡¯ó‹²ªç—lağ–+Ú5¡İW8|€7œf­H¦§/¢ÿ§“7ı$íçÂëœ¿$Şœ¦"%ºt˜âÀŞh`ãj#,F±âÔ>Ä>”ğ¼¶8¿kb€¾ŞtRÌV„²å²úV,ğ£¨°3œ÷Ä1Ró.‘ç	o 5A_Fÿ¾9ŒZB¹¼…ÏÑ¿wP85£÷<€cvô£—’cwô×t°†áÑŸobÛix<ÿæa‡\¾éµ	ß&d<RÔÀ{‹ppGá1pp§EŸgº¸‡ÄÍè n Å·í&|©°2¯5•v“î^ÇlÇM<¾˜[­g8ıÍú>{pOŞ2:âïîFÏî_}ÿğéıo]=şèPBÿ|ü!¿ù
ßs¿ù%á£75æ­{W×ñ;÷l#Ga™O‹í2û¼šòsº9æ&1SB’÷¿ú¯—],‘Èâ_Şşƒh¼óÙ§?Æâ²»pó­ü”ãWG÷óÎÿóTƒ’Ú*iÍ6_¿!OŸ{bÌLx…]è{¯â:Ãñc›6˜‡jøJ•]SM×#L¾ã°ÒÇòk8¼>Ô{ZâÀg…TïòŠW™Å@Ñ½ÛbÀ=>‰®³(9y°Áó0+W„wÏóy1ÁáÔÁÒqÅK†€[µÅ©€3Ê˜l/Å¬ÊyŞbëÔ=š€Ää©7
I«ÑÃQŠ€`S˜Î¥]Æö“ÔY8ã¦²Ÿâ2w÷LËUf÷)Ö…2¬”$î×6´p¼_ÕÉ3.ÕyÆf·íêˆ6
K´¬Å°Y@”/^Ñ ÈógöÔå±·‘cjé²‹»cÊ…yiRÜåzÅF'¿>â8Ÿö6C[š€ÄØÎ{İ(#¥×!,YDíŞ¡MğÙT1ø\“C=nRÜ†¨ûgdHŠpr¯ŒÀ(Oîã’µ¹–!bì¡/ñ™’A°Ô¥„Z€^¸&õ†¨‡¾Åá‰¨“êèeOÛş»î9T9¦SK¨‡•‘Œ¿ÿÊSGƒ·ªlºÈ/= !Ö Ô4°İ´³j”L°&Ğ"­dºz2)Ñ(P:Bvz:ÏÅ¤\2ÄPO)Ò(:`Õ“ù“#ÓÑö¨¥ğÄÜº9J÷©Ÿa%i´	Ö-<a‡´Z:ì–Å2&°´¯~¬öéaT)Z`º«~¤»M>ÍúºÚÂd±x"îèDÛ2ea‹å´¢m¤iV+\¬– ¥×tÏjµ$N†…az{Vk…x‹eêB/*½"[¡ZÇ×©ÀDÂõI¥›b‡`ÚÃ%ûpZ÷NQçèÛåy{*…@€”cS6­İ^cúİâPâÂØD‰±-·a®J‡»Ø¾ØV—º4¾ñ¡‰_iÄâäİÔQ€ÖFï¼È/–¸Š¹h–G™w¥–f¨ |ÌÉ²À"é:j»\‘mm¹­N3iIª-¹`¤˜JêwYÌèÄG«íŞR»:~Ô1‘ŸŒÓyV˜«PÁÌv“½ßS‘KGŸâ‹\• ŠÈ]'T¬F§c@7VZ×ådşğı\[Ì™Ús­×N^QBÚ,%K5À«ÁvgÄ(ëµğÇËô İH¢™Øeğ34Àøõ¶zŞ¢ÑÑCCøó‚¨à>†°÷<VSé\öÊ³½æ¡Œ®É€Æjy¼•ÅôÂƒc^ˆ	Ø_9¦:)GdØrªÃTãÅ6wD>YXK{˜hèâêÄº•×ñ÷/¤6÷G2
µ³jÖMA}D"¦È;*G
µ›òúc×Ÿ<7	W¡¸PÚc`ë¥[ÄnRœG‰ˆÅYÇÓšDI"ÒøÇÇYµáŠn(q‡¸\K|ÚRØ=õìz®óÉ|U €£d›}ÒL%EiLëríï'Éº»x6\Œ‰&C¹+ú°3õEgkì ¢H	Œ	ZwÉö±‘Í1nòı´Èğ¸Ñ¯t¬*e•ZÃôœÜ‹vw¤] É'ëmJ®FÁ;T'eÍV £6µL¥ÉZ²Ü­'J£ğeñã4¹¹7dRpÜµQ‘ËÿÌÒQÛmb‡…å $KÒªcÜª‰$}Ø7E‹e¡’zÄÜ™¨qfì{.ñìVïiô!o’NH%iz–7RÉSª‡Ëõ$RÅ\‰jy‡í[îxÉ€^æWUf‚áÕNöUûÁ~Zrï_­Â>Ôh	FtöD ó.v,Ë®ÜãáÉõ%8&Wy„×@®Üç—gÀöÆ´7`oÀííğ`œNÎ¨ÖhÕ‹TXÄõ Èaã‰-ËÒ¼Ec$6\@ß(F[îf„D5Rß IO¯¿ÈßËÏ~_]¼ÀÍò¡ éHÄ"ó->tÒÚ#V¿âÿ_G·wuı3úïÇqˆP4úíÏ)NÑ‘ÑèóŸ¹"a€IŞ“&vÎ)ÿò'´mX«)Ÿ \å±‰Q»+N¶d†>ÏiU€FGoŸ6uÑsU¡H?€<Ññ6ş$œ@Y‘ıNÌ„‘>ô 4¬lUZ7tjFŸşŠ‘$±!ƒ1E"nÁõHßßè÷½)}Í›Ò	L‡Óˆ—*®ğİ¥¾ƒ_O8øU¦˜‘]£­pÂã\8ÍšÀJ
VJ¶Éõ¬`Ü–’ Ñğ½`:[ò(Í69QË-ßD]rÂıZH!Òµ¸3W5!øs*œş gÁ“y:_Ö†(jm§Û}¶<æ-_’qFB½|JÅ¤€–®§nf$Â«ãµ\0WÙÅ—aª|V•$P’1«n(™]¼ùó*=’À3>%÷»IrlL|$…¡u®Ê¢'û³Û“0i·VT»Ú.ö¬š¥³²®3IbÂ¶j\}~±B.ùà@hµÜG4ãTæ Uu>m#A¨Fñû>¥%\<]–%éGJòW˜ûµ›&Í³Rşxpyì =R¤9_c+—\3âA/M½cÇ¸`U¨	ÉD‹šŒÊª)wØ>r¶X–›º6óœOTbWÓÊ0>ë/ıÚÅØ¯pu%]¢–¤\aÚhÒ–‡éå\ÔÕ¥¤(Ší›`—BŒc~ÆQõÊ¢	• ÛYs9Çî·ÁêäD«u¹!T%Äp=À.…º®òõXÔİ<b~mY‘M
iõºS	ôêJ¬QlâÙçSù~’c£â…¬í×N%“@ØXÁbÅ¥$ÚâPï‡GdM:–â¬<;5ò)5¯€YÊó$«>¶§Ì•‡;Eæ•nùxleğÚÊ.¶(ÔWÎ‡¢i*>ªÑ¯¹SÁeëVÓ1»íW|ÜuRÙ„ÜxşÜTiSÛƒ[®NÅ"ïxĞZ‹êf$nrvšçÓcÎß<oÊ-vp¸ó˜ÜV%‚E’+¢I?&û˜ ü.Èı&_¡xˆ+RåzéAÂ]ÒM’=tîùi¾.9ì]íª¬t»P2_gz¾ß"íª;Œİƒü‰0’İË’™LÇ¯îĞ¤2™:Cå°É¼­â¦ŒûdGÃ	;Û5iš†OvN=ÿ   ÿÿ¤\p\Õu>w÷iÿ°ÑÚ2şÁ^Hb–“5–ÁIßî{»’ a4’ˆIbgµÚ}Z©H»Êş`ä&î³´bš´¥w\mñ`Ã0™)$µweÀ¸'¸C¦¦If2S&„Æ“™ü¶q¿sßÛ§][¶•ÉŒ´ïşûî=çÜs(z(sÕºç—åË<W y©ã;WÊ=Ïp! @İ2îÉĞ<³Àyë£öÆÆwşjÀãp¹Mt‘
 pâü[çYNßhW¿ÙĞVj§P8¿ÛÎŸ€áìvöIxÆ|±àFG‘J’?6õ- 24="yeVB‚šq®2#@B­àçA˜FdØô/NòË‚e´’gÆaŸ’qY<Êâ~Ê!»Ù¶CFì
7¶Ş.ÛÌ¼¥=º¡=ÚİİÈQ(Š vÊ	@­2ŸK9Q…ãƒ-ŸÑbØÁD–ä\¢%­Tfe{”[:WÎA .Ù9—ÊÌ$'áY•Œ1ÀG}ÒæC˜I‚fI -šÏC	5kJ%×£ét©DÕ˜iÛŒ‚œÈ`sñ´ÍSˆ;x~°ljE‹æàzÔ17oséZÒ»[Â5D ó“ÅÜr¦¤ú§½0sAgZäq8‡déTszZ
É¹¢™;1Øh°qA³%èê”gŒÑÜ$›“ÃÖÊÅg£eÆ5è¦cy[Ú”~Ğ‚Û/ÙÓÖ„¶Bù³(åÆ(Ãvšø8½s;¤¹¥‚‰Lkİ{ò¦–p°|ñ2ûÙÌåps=8ÌF©Òxü‚±iÂ´¯1¦ˆ·îBÆE{k_bd×¨3ŞØ´¢½
›¬ø@a(¿@r]¿03|fŞÌ4:€E,]IxÁ‹­ìßºëşşT²úŒ¦HØ–ä­÷Şï'˜yÈWç–œ¾ø`"¹5™À5™†RW¿²÷Sn}ŸN'ã[Y¨ƒAÌ„æ"D1MÉ*xµ!p`ÄÀ
sèœYÎ™¹Ä·%¼
cc›)¶÷‚/Ø³Ä~F!Ï©k7”Jœšpx£è³A½¯º›`Z*€õÚŠ>:ˆd.Ø–®¥³æ 6 Ù–“tàÚr „Øy×FkBJİ¼òèDº„&ùÜ 	‹ìÚdyü(1¡GKR[u=JiX—©™T:“©@!õUšAÑ•&*´G’˜›ÈÀÉLŸ™F…È˜š€ş¹mk–­Àì=D©2&Š³Ó¦.›…Íø¸©9UqÔk©äÀB®4>Ê““•vf–73†?Œ@Ì›Cã5s’µ'xVdr!T$¢s‰ ¤Ën²={)ÌTeR1É3–0Ñ} ‚I&[BÚ²’4UW#Ùt–FÇrƒ2]cã'caKš•ËìîC-…÷Égeu\æ²}µ/½ØšÓ—q¹8ó®ö¥[»üjç/±œSiíò«}‘ÅæÅÚiíx‡Ã·aJšáã€B7ÑEÀ¹$Ş«,™èÑlôÃ=ííóö‰9—»M¼{Z6OlWÒ…»‡/SXZ•à€`€9&:ë¢o¦l\¢¡•™aÑ UõÄ#š­ŞÒ(§"Óài¿—‚†NB(¼-CÖæYx.DÕŠn‚'ˆPó©éôÇŠå‰ÌÄ4oaø¢xÏK`Ã€•Ó0…iI×ƒ£7oâ$à-!E¢hõÿÎsl-äIØÌ@WjŠä >/±i_y©Y| q$º¦àñ¤(i”µ‹˜æIöºQı(š8j@¤ğR[@[o™UÌaÙJ)˜KÁA´üe
t˜);§4U–Ä«‰îŠÅŠí4A} ˜È”;n€N˜‡úä1ğxÍQI0Á¦0ew|~˜Ò*HQ÷ÏcûeT_¥ÚH’Îü¤‡èúº*ÑWêÔ¿çû=Ú]xí5èå×ûS]xU¸=IÖcÑ§¡¨¤ş¼Aô¢Ï×E‡J#7&iÙuÇ‰Ftá‹©G_Z}|Ï‘Ym!ü*YÁYO ì×‰ š½*A±’şÜA´ó†A?ô'‰V'DH¥#û“4òNƒh«!®@MÓG’{nh›±H¥w¬$yj–h».«ôŞšãT{ä8Ñ—âJ•¾½ÁÇÉšiˆNtñ…Eá·u©µØÓ£#OÌjGt±D¥Ú÷“DW'zßKÑ‹åª}3ATÖE—J¿şûY9=K”ĞÅ2•öÿ"Iê™$ÑA]\…ª~x(q´ö—	íE],W)vç,½·¹_«‹h÷ç¨æqƒ( ‹•€ı`?@Ò°.V©ôĞÕ=d}¹iC\ª¬G£GîÕ‚	±Z¥·^˜¥ıŸ˜ECq±F¥“÷§Í^Œj$.®A'Ç4`Ì’åOˆka‡:Ø–”cÇÔ`Ã	|jJc^dÙÒt»˜F"—Ÿ/‰os=P·ÖîI$Q‰QÀ]ªIÑwP±cd—™qìT;:Pdú¿=SİïÂN&zíBƒR
Ş,ÔÏæÍÈ¶‰¬©^˜"!ì
àÔ&=ÙÒ	;ŞÒ;¡Ù‘A3ùB*Æè¢¦§'3…<_÷CÒ:ØÌ"Ug[G|“P6*Ã0AeD{+ ¯ğÀeDU?…‹DVxT"<C è2 åÂ9‚*î4Aû¶@ÂW½’KA›µ¿…øoÕv€ ¨Ìh&^vJ\_Ì€Lg Ô§äl5‚˜M<AœU)ÂØRŒ¶fc¿h¾u>CfØúnÒV
G«»âÅ‰±I“ÙS¸S9È	{[£wöM¾åÕÅO± ÖôŞ‚‡œÇA8mr7@}ò±7šÎÚ5b éˆ§z¼ëÙúÁ¶ Çh7Œ¤ƒ&œ„é"7Ãnâ¬_ã¨¤„ä±[>9_2órĞ÷,•™ınB4yo»c~>2UğpÅÄÇL
‚—¨*6¦`Î•Tı½î‚2Séâı’åi¹Æ)Â]›Á+/ˆgX£ájJßß}·ó‘yõ÷nMM­®ïæBs
aÖá¿'ã+7Õ‡îîMMMKı¢­å6ÜšáŠ´ÖŠä¨ré]©RÈÍê +fCŠ´?1£^3¼¿S/¾“œ’@ˆS’¨Œ['Ø÷Úüó¢NvyjÁC^«*´°cÚ‚‹«İT?N¢—‡Ã5„eçÍÜ6aƒõœô‘X*úvó×Ówˆ?^lÒ¨Şá§V"ŠÃ\ÉšMá‰—‡×¡ÈíhD¡Ğm^(‚ö·ı$xğ&Ã[?8$¬ª‡ÖjOªl&W…À	á¬ƒ-4ô¤M["f8‚@"ló±U‹˜ô Q0ªÜO4ËÂ¥d3Nqé¸‚¢úÕšâÂ`o-¢ÈË÷w£H¥ë£BDN=>sTx"ÁåQŞÈ#›‹%Ò?VĞEGäÅ§p)F¢†Vâ:Œ,¾ÃÈÎ-»pıEîüâ_"ùÃmÏâº«âÜß¡í£à3…ø»ZØHO—A#ªPP0é?ØäY,Z¦0YîŞH£„ƒÅjÈ‚ƒô-X€/²¦ºo18™ÒZ¢`¥¦º[Vè>Ø«Q(L¯}WÇŞhÈWöF—YøÖ‰ vƒ_	Dÿ`·Ÿ
wÍú-¼ß	ë58ßV§ù'áÆPXÿ*ÿMf¾É`Ç`ÿ¶4¥ıG@‚Aşµñ3Ñ¿î£·ÉœË;Åæ*ñ‡:#_zäêßE"=Ë+¬_¢Ö÷Ñ;~qîmtÒƒQœ– “KÂÓÅ	Xú™ôXÄYq–¬-A­ÍÆ*øÂß{Å0m(OqÔ°ÙKØÛ=4ƒı¼ JaâF¤ëŒ%#bıi[Ì£û÷@-øQ>À3Tb<ëqë“n'Œ,k=Ç9‡àOX‡åïPü}àQüa#ÿTÖZ…ß<@”MúO¥Ç­f0ŒÏÒÿbš^û™‡)‚[HßYˆXº‚Î
à{”ê£Ê–Æ¢ÏYÉø©Ãõ°Q\é'S½O„Õ¿¹sscÇæ=É¥Ô°Äºx8ıæ%ÜÑuñ¥×ÈXöG©2-9RÚbqèuYÏ·0ëÂº)ôqõù·?Ûxı ¨›³‡ë;Cüg,ÊKıeÔı¨õtˆWØ]É·ùç;!®Ö¿„nPŸN7şúìŞ$ö“(ÆOÃøşñbõ:ß	=˜µÖQü~4ŞˆîFµË¸³{ãW¢/#¶œc=ñ˜E¿‰c‰xè.5~&¾áà¼$¿ÎBÒ9ÜªyHè]Lî®|Ô–~½¥ƒN`£Ÿ‚2p§Ig–÷S€:ÅB­’·Ö„:£¯œöĞ»İş¦‡ÎtbLúöø¡Zğ)ïQî§¯bÇé>şíŞDÛ=´ş/-ÙGtp;Pv7İøVB÷0ÊåÊ7«½˜¦\ic+¥iVßµäQL~[BöÖ¨„O˜ëÂ¥ôNjâ,‡Æ.…ªØŒ¤?IO ƒ×Åï€¤±ˆïÍ/¶"i–‘t×‰ßI—†tÑ\$ÅY~I,…ş÷ÅRŞƒU‰¦‹Â9¬ë+üˆº7ª 5µ¡¦ı¹7ºî|Œ
71j¡[·«)<Ü|Âû¸IíˆÇ[{MûAñö‡Ê%O…ßÜwOãWß}(ùÌû
ëÔ[>4şè¶î$Ñ?ñ© >ûÑÏ%~0¼¸ùœ‹×’"`´Ö?kfT©¿³¨’¸åŠ+ øuFê½oø$R÷µ‘Z­ù¨‰Ô]óá¤Îˆ¾:ºùI‰š‘“K­‰´Øª‹øv-ú`ÒÇ8=ñ+=	©qs;·‰ˆ…î[?D\õÈŞø@S¦A¨Ë!](I°áPBŠMx€GgSqŠŒ­ÁòSb_búsçûÛÔLiõ%6LZŸ›ÑîKÌ­Áõ%v~ŠíŒ}‰¹9snÃ¨oD¢úJÍÎ4}‰¹	}s¾ÄÜ4Ç—˜Ÿó%æ$µús’Z|‰¹nó%æ&Ã—ØÚ¦/1ºéKŒX€ÃN‹·ôğÁ¯¹ÊDû·|£SRè4^&M(›€Ï¤ƒ;Œë`¬*nÎ+AÛò™Îëh“…mPh+À}ŒÍÁÉdª Ô†Œã-"uƒ÷½ÆàòÓà¶?³'q}Rİ—6â«¬ıŞèåAÇşûñÆí'¾•¤X*q=`ı6ìMáü]¶6	˜Æ/_zHu¤nÃ9m®kk“Í<zîkı¬ñä«_MRí°è4x9À¾Ù+g·ßölà[üü—OÖ´û›I²*N‹ü¯Õ«ê}«¾À}í€x˜e: Íégëûõ×ÿ¤¿ÀGâ‹—²DİÆ*Ş 7ƒ+¹d}_›ô<7sŒ¬OqX§ÏXR¢WĞ’¿Aô¼n/ÍŸÙKz¹†p©N±/×‰^Õh¨?½×¸u¡[‰¬ÑY‡Ñî›>¿¤KØË¶;²/Aû_ l€İÜá*(é®E¼1U˜˜­Ù¯M0¿€IåN(+IjËÎ+´ìüB põ›üPÇƒ^T²Îï|QıfŸm‰Ÿø   ÿÿì]MlUu¼‘­ÆIPh )QÚº© ÄÎï&…ì&©D[¢ÈQŠ´DP×‰mb)±­Ø	ŠÄa±@äÔ¤B=		.ÈGÔKOHpkP¸pEPGN¸ğÍ{›õO\
r*´²Ÿõfvvf÷½}»ë7ßÌó‰ÚÿWí—õ±ğ<Ìa <CS610,¶´x“ë‰LIwv~ßÕ,&©	ƒÖ[ÁÎŠuªµäßU¬¦8üdvn{¸—Ãÿh4àMû6İ<Ô­—pÛàT«Ûn¸÷ù¶ã…£îËäÁ×}¹vÿ[¸£Á!~ÜİÍàá¯ñ¾Ø¼•ÿm.°gì
^ës­Í•hğâÜ±ŠÇà)‡—=¿Œ¹×tær%†œxp~Ì&¡*2#qUv…1š`ÄSX|˜|k)2‡q[PDÈÚŞ7\QÈ€vH|°\„©qs
Y è2ğúç8Ê§…?şİCÄ^4¸‘[›¥ì<ècéÿï^ÙŸÙ¥òB+Œµ~Å5À>ÚAC(Ã(#(£(ÊÊ8\DåÿSİÏ,|U˜{î1óÚO}÷ù½3i}ò&Ügo@³b]÷ïÂlE±Ë”Ê¢ßh·–ÄÖ6ÏdqZeüâãS¬"|ö‹ ,Š.C®4^) Ê3ì@H"w4‚@×ó˜àû|°x@\tCp‘Ì7+„§Yª÷“o7W‚>Fgä—E]&äDIÄ‡Ó¼Fãa³ÓM eÊË)¬cWšıh„&+Ì6Wšíª4 †óU(â¡ù©}ë´º«Í<ØÕ¾ù±ÔWôXOakK9¶j…ßÒ‚;
õEÚ‚dªKêâŸ@ÑO¨ıÈ-h±@„(òšJ>ê ÄOÖ—Í†¯ÊŠ(…ù}kPmÑ–·¡Vøx†mVï¢ˆCUŸRÌª‡ègCÍ•¬Áê|¹™XÔV8ÖıfyÈfª_»x,›‚ˆÅtÑ{ rIhÇx/ê¢€k»¬5ïµ*{W±ç/,V>Ú°nÍBy™5Vp®ŠQCÚƒQêJ'½˜‘F3}¼‰|':Ê5©	}pâUõ®èÑüücš©ş Í9‡Ñà‚º/DÑ«U÷l¢“³¬”k¾Ùç\[®«qíÏ·ÑRYËuS{¯ ;]Ò²XM·ÅÕmíw°]Dô¤º¡×øq…5Q§÷oİN€ê×,‡¦;n$’~¨s£åøªñè6¼ÀÉÁ†h†¥Äµ`ÿ“½=†ÄıYÍ@¦T¥î}}û‹	 ¾ .-q¨”p¦Ô<dbqª!G˜ÍÁàì%*aµç•Ú¡œmÖÕø×ê¿Ş›ùoÕïMTµÍ=Z_~áX®°B`2×RQÔKXv¯zñäæÈEÊr|[‡„EzáTit#	XD	¬\û¡#"šCØ@>•^Åz5]_ğlÈWÀKDŒ%f˜°E{’1'\–uÅ°jağSÄmÊ*FÂ¥Ò–[f¯¥#9ÃB4¾†”=+d>G
qJ$úK¬”Ïà1.@˜"i[”× óÂ —l‘}Ì óßd°mT$§f-92û™íd•†V8t"dl¨ÎÀM‘²Ã|¡V
‘³ü2Ïó†ò£s9Ò^ih€ùõ•í„«…ôõ´0¤P­!F„	f*¤V5Œ<]<SÌ÷IA†$ñÖ&ó&«Ä ™[1Hæ-‡"ó‡&³ôƒØi„ÌçM£duÌ31Æ­ÒK`5JÏæ]ËœË¬æ7³	Æ;$¶¶‰¶Eô{ä_ò¾•ÈK24åÑ‘Šo‚<ĞÚsé8Pµ‰d«åp±f×©ñÅu¿;"äpi’•³a2Ä6ŒÄi€*jŒì5lD(²	ÂÙdÎÚg#î?ñŠ³Áı¢Á³¡¸lC˜x–³!ãW¶Á‹=7ÚbU]ãœL2YÛj:t256>¼ÓÙ°Ğı3® Š7Å°|Ü›ë/   ÿÿì];¯5I&Éƒ\^"‚"<ÅJiŸy¡°Ë¦I‘&¿ Ê½wYE
ñ“ ¹:
$()Ó]:¨èàvP„‚ŸÀß@ñ}ŸÇ™İ½)w|ìó´Ï¯w}Œ4é÷ø§5Ò£Êá+ÅÎ¿ãø8‰Ë¾¥GŠË‚×ÿ#‰ï¾³-œ‰¿¹ÿ£wJn+æ?Â¬™Ûİÿà^³:h.Ä XóÀî‰;"wpèyÛß=qkøó£ƒ¿nİäe}ámĞşn;8§â©|N‰–×Îœ<TOÎvš}OÌ§|š£… DÆü®­x¦ããƒ¾U}Öİ“†Í©ñ³{¨†L>e[¹fª !ŸÂFÙùåx!$×Oãò•P°Iå¶È°NÕ…1aU‘ğí%‰c_ÿØàP“Ş1e¦„,R€H2 <M¤‰AîòÛüÿl£›*c½¢Š/©÷pÇH*Â†En$ÌL äéøŸ}LH9Ô»™›ÅÖ¬Ø=‚Ô‹8d‹ğˆäÀË÷U Ğ …¹]Ñ¨dÇ!%Ÿ€Ãg¾¨¨/6Ë ñ 	şÌ´%Jd·ˆB¶ØÅ‰“:²‚½|"YÁ¾l {pO@l\R+[–Ù—KìKøÇc?pô+Jˆ¬ jBòò/s§Äda†¯ œn÷H<öp`ƒM³ÌôË85EK=£ á¡fƒ Šsg™à
cã|.­[¡+¶‘HéÖÌûW$æáøS´±±:˜,3/û{;Á±MüÙ¼6¸şË×løøz$ï«aø|­Ò¢L¯BéÇ¼S
1Ïñ•«Š¡K¤ f¨+²÷îcÿVMÈ ˆ ‘* {HÇÃ°éC ¨Ã¹£âU~ÊëÅ­Á<í	bÕ€‘~¯JÑ3l3ÜsXşá÷‡íìªL½ˆ;ş°¾zÎPÛ¿û×Ú_ø«ˆØ€ŞäN±›AŒÇæñEû@j [‚14nPE&ƒÇ¶Í^²ŸÈ¾æé¡\‰lp..µÃI¨»‡uB˜-Ø‡`¢¤è„=­ Â°ã'†40/q¨5.µá<Më„p\<
·µÙVê~²ñ6³;•Yv.w_AÊfx?Oˆâ÷¨OqT.‹)~pxéåFó—ñëFlæİJ!LÂ3¤3¦ÚÓ!É56ùáYRoŞ>Ñà7ıi\kı‚?ÀD†ËÒJøZ{‡ëÕš²ÓÎ{ÌDµÅöÍW5ú¾ZÇOp/TÅÚ9Ù@ïN6T»ûN]v¿#m…¨ÏØÓÎxRÑö½Ûy£½h wK’ãIE ;ıµf:‰;t4£ñT^EºŒ+s#Ç,¹òĞaÓS(ş±ÌùtåkÂ#–¯–xô¬:/@4áAÉ«—Zxõ+ãdIçôw×.zñğøËù€ƒÊµó•R¼E¼äæv~ñ¾Çâu_¥|:5&,zt©F¯s±’âw¼ê­è|õÒšöËæ|“Õ¡«j”võG—†èX¢c5‡9Ò˜UGpÒˆƒüq¥	àdõyœ$j’¾èƒˆo!ÃÁÑ<}*OŸVd;8§gNäéÉ<}&OOåéF>›§ÏåéóyúÂn’ ºu§¯b§šÉB·ñëêô5œÁ¸[¾ü/ÚİéëÌPgoûo¼‹æHákş6ğö»îó½0•)2´ß°óö-Ú±ÿâŞ\ƒ dß‹oÛ9,"<ø¿ÉMòtğÿ[ü²ıRñ}úÎ²mâªi\?ñÑİëwg÷zÉç§’n’L’/NÁdEúàE¼ÓÀ·áo÷L‚‹Ÿ»,Î³8Ç¢ÇËZí…àjÏâÑöz*	¶=uîy8qÁF]û™¡:P¦O}2q–söØá“¹€ÆóÃ­^È"Gè&Û·XlR’³íÙÉîè=W†…SÁ¾–…#‚eáÈÛË‚ê^&MÅr’UOQt¯"«à“gú¯¶˜Éy*"%—‰\OXwj²RÇìÊgHÙ$g®'Î=
aË’Œn”AªÙÔ©4=µ*Za÷1L`Uq¾Avµ*]Ÿ&0* ¦OÎ¦Î™óÏE-œ@¦/)ôìÊgB\Ÿ™¾´Æá"¤,	±]
áú’®Om¬ú[õ·êiÔêÈ$„†Ş
nŠAB5ÌÙj}O²uŠ`Õf’|@¸Õ³¡œÓœĞ0•ƒpİ€p«g#\7°D5@…>Ã.	¸¡R#,£ÍµZ	îJî2©¹á„Îá†¢*sJk†,İ2;ä‚ 3šÍhàº[Ñ·Ã-iÔÉŠÏÎlÜPlFTL.c˜“ŸQp;€ã'“eÎµÌyËŒ¨•<F;§ºØÁä,FÂÊ('è¡5Åß!kùàë›lÙb±ÃbN-ô!‰fDÀØj$¡ñÌEÈ‰¹Qş¹,‚-ˆ>½!•ğÁc‡›*($²®àJ4†Â"B75ßb—-ZFqdÏ4¡ÄÙz²}ö3š™nDbÎÏUId$…Ü
ËŒd	‡ãs°ÁˆòYu²êdF”Â¢•¯¼eVÆ"*âÈ×²hFˆEğâ•±h2¢1eXI @ÎKÁˆ@“bÑ^f.€Èc£5±hr$ŒÂĞš`-Úcî»ƒ!ûŞ©ÁH#Ò‹dı‚„X‹8"û#…ÖXDû#Lcˆñ§ˆaÜÀ¿5TYŒèô2•ÍXDÌ>Áˆ>×‹üÔV˜pò•Á–lEM*9rk0u±SÊÉûZƒ‘&~{,ÚË6¹–XŒ0ëcQ1êRÖ`%öEÖ`„XDŠ*m±hÁRX™cU0¢%ö‹E“³ÅîR¡wYÎ?« ¡E‡eÈ³œ–´|¨õ•wÛwuööjû5ã«V,RáÃ¦ZN´-ßh+OWH^^¿ÀÚå›húó=cY4×okB&%·šà^û¿21“œK3Š°vı¶&d£
™E_/1²uıöÈäwZ@­Y¾i0ş3!óO   ÿÿìlÇuÇgÈ#OGÉÒØ‘,ÉRì•dÅ–ìÈ'ÉªíÄÖòx¤(‰¤Èˆ)®Ë»åİúöv™Û;ÒÇÈ©¤
’ Î?ôG~0	â0R EÑÈQj'Í·(´ŠAƒ¢@Ğ"A?ÚíçÍU*’ê¶\(ÀãîÎÎ¼yóæ½ïÌîÎ¼‡ıÜişfûÿ!335cµÿã;NßŞlÉËP^¡Ê‹Ş­æ6q ©oJøõ¯uı›"€cNyjÉÄxÔdäÍğeI$2Mœiâƒ°ÊgFe<prXà{‡%%ßX¯1ft3M×È )ÏÄ"C~f„ƒI¦l=Êì[2Èx)„;ÇDAELş3KêšYÈw3×L•Cõš)s(w	^fšŒq’Ÿ1LŠ÷ãKƒbŒ^à×áWæWå·Ä/–
{·s}›ûÌş7ü]ıLŸxÿ*æ»_Î¾tõ©şa6Ügìù;ìù€=_°çCö¼lÏsöÜ·ç›íùØó-œw¯d ÷(åº?××rßà÷—ì¦û¯Sûo›wğ¶©›o“J•·VöÚ‰xE¾’Ácôğğæyï9<|•¯/oU¹W¶ÊBLÖCó-rãÙ{•)6°æ5’„´ÊLzx_'º]â‰Ûş‹|m¯3¼¨UºßÌˆoôX½%Vw"Î^‹¸W&2SâôÕœÆëJ@²›5íZ¤ô&3DBYçÌ\3Æ[ìÁë«Ò›ÍT¹(	[Ìd¼"…î2>Nª£ªÒ[]3âÉ÷v½ÍkAX!¾dØìÂÙİfÊKÖUê{ÌHØn°XS¿ÅLùÏğ½İL/Ô¡£;Ì<ÿï…Z³‡ír9Pz'l® 2»Ìùö_­ôn˜XòW•¾ÏŒ‡~çî’Ú¯ô^S$(ÒÑo…Ÿ{÷C¡Ùğ›J?`.X9¤z[é}f:jsc¿qgk"*ßHôsç…_œLêÍÇ2”"në·QºÑ2E¯±´`%ä>lfÛ‘ô!3ı,¡¸•>lÎ~’˜Ù6‡GÍ©v½]¡ÍoG¬e¿)Ô˜1¯‚¤sM!$:HC8È›‘X*8jÆ	îp•>F¥Õ*‘‡Ézœ¶6•~ÜL×”>³²¿”‡W]ı[¦(*£^¥Ÿ0§ñ–®Ÿ4—`.©ù)jñ–‘ë;Ì¹À‡u¥ßiØ=%Œ?mÜ™˜˜eM¥Ÿ¡'BÛ¥'Íl-À±+ı‡Í4†é|tëÒ÷ØK¥ôˆ¹ «çtÑ¥Wééf›£èÌ¤W”3ã>á ¤£N™qÖpÓ¥ÇÍd›î>-İ½ ô3Î7À®Ÿ¸ú,Í_aU9uN˜	~&ÍD3ğ«¡ôâ”¥èÃ9¬¨4í™¦¶¢UÂ ®¹zÆŒ³O‹Sú]f¯·åZPWú¼ÁMr$TfE;š¢OC*(’Òï6Sè¬ßt•‡ŞŞEƒ.ÀZ3ò[-¥ßÃiD0}Ñc´[H]Z{JÑˆïîˆÖğ1‹qÒg¦ğËì!~ìÑkŠ"eÌé¸­sŠDeÜİŠ5Î¶XJNjÂq]¹Xc¡‚¥+ŒqÊ+WâÈ‘å·£ˆª!¹9±øYé-fp¨Ø]Üm,±|Hiwëzÿc•xhE4R "w£M¼†¿{zVäd–ÜÊ,ñIéîs+4Ié{E^>"ÜI_‡	š· Ö83æE1ÌûÆZ–ö˜)BoÑ8Áš½tÎ»h}¨°ËÑx&¬]6‹7`*X¤°Clsî>sHYJï7#M¿aûí€™•8E)L=(õ±ÙDéƒf†U©eŒÊo[7E÷!DÜ½{™/¥0rÃr3^DÚ‡1Mj“8 |. ¯–jöQ3Å	äéb©xŞ§›È{C‘¨0–ãÇPß[öa3OºøÚÖGÍ\í¶÷™n¡‹.éã¶FOúşqòÙ¿†jŸ€a‚FK 
x“Ä’!ùäÚ[•9…CåÏšî¥€=1Z›óŞbğ>Aø9îpÒo&X¤Ğâ]Vi‡Şj * sŒ)4(7ÜvzôXSK¯!H?ë5‚¦èÖi Y0gÈœ±%6£uŸ<[8Y°Ì»Œ{Ê«QËVsF†Ÿ€›ÛÌœÊM#êKş»Í,IÜ»ÇLãÃX4êTÜ&¶÷œ—Hu;04ìí^šÒà¸ı
Å.wQVÚ±Ûœõpø/Ğ^@LJï1cÜwıEWï]#@ÖL'n5‘vV£sÊœ¡óœÉ¶ 6	¾éœê¸HûûÌ( Üœ‘8ª3Äê@N?f ’9SA=îHÛ3Øf«ã9S(P—e¨œÆ½¸3'*µhäún=ašÎùÍ“5ólFñœ"†1”‚›L˜kqØqæãfœ0JjNğ4®¸ÔQˆ*ì@‘Ä!a#Hœ‹>=Øe#Ãì¬Ï§³À™­Õ‰ïÒ’\[ÌhĞğœ¹ ^‹£n¼ìj†Ş^L› r&ñŠÇ[Ó|–™NRK[º­×°Â²WlGmÃ”ë4×İæ¢G‹œñ°½^ğTAÂz¨¿Åô8oÆnc¡ƒ‰Ğ¯'~àÌS‡z€éì`\©Ç¡8h0:
aQ ßvsÕó—A×&íÇQ¿Qîñº+íÉÂ¢±Â@š´û-P»Ò‘¤ûÌ²u=g4^^íÜcl_ì¢e¸ÉD`Æ¶svY†/:S:yœ©Åµ¸Ğ÷[bÒC"ÑÃ¤Kè$fK1á1¤t3©‘KVXIÂ>ŠIL!7b#“3ã·š’º$•lLu‚g½¤–rqÀÌ‡8ÇÖœYo¡ê2ü?V\ñª[õ:HázÍBçR_f‹b¢ÑS^©"í©‡ş“ˆ¸êÖ"ÊÃ”–ªgâJ5nFÒ‡R…“¦àŠŞŠî0³»:;ƒœ‰ö*ƒY"L»ôt˜µòhOfkË~E2lIPûÕj¢ôêK¹gAYI¦Ç°l´ÁC»yHÙä{¢•LGo)©ª¡Ç(šê¸F	9ÁÌBO»Şb£Rúñõ ­ìé±¦|bmXçºW†™o72—sÏÿ~¾¿p@ÜÔü…LúÏşò&×ğ›(	ƒ )+
—XV¡pGK¯«í}½³¾7k-Õ"‹õ`ûKXàªùß_ÙÄã‚*xÇóÿ2UŸà~YÂIôò7äÚKÚ^¨æµÊ?şgƒêó$Y»µ¢ú}Ìzíåw6õ¼R?@Æİ}Qs÷BfgşÏ¿İ§¾K5âtö'Jåÿş»ƒêœ¢laW®ÇùWå²[Ø„§İÈWß³Ã/Sş´´p¨?û?íÓêUIî~@Zş‚táCÛN×?Ñ§~¢CËªãB¥ğAÜN/ó[á÷¿¿Õ—ò¿3ÔıG>œëîY}9w×^CH¿(^‰Ô—(üÏfÕÓø²"Ïp„û“CÛœËûwfŠcß›øğõÏ)5šÖ»ò§¾: ş5§ò_×YJX-øÁ½´/á‡ƒªÆUüWƒêÇ“\ïA`5âg¨O!sHÿeãÇ¹nê£÷[(­«øµ{yÈ¬ğ" ªÌõp’îÉç!ÔG‘ıŠ#q&]gÁk±%¬HôdVQˆu NÄ‘ƒ®:M/ª“Æì‚>MK8ÉûdÔ"®¡JDã¬†8¨¥Å»&7Ó2¢;”¢˜]•tûf‰±Úd~Vå*±[=(^‹•Ì-ö;²â‘‰á×P°*óÅ›=¤´ ºÈäˆékG<S
é`Q¡—˜Ë;9!ìŒuü¤Ğ“¸?]çI•”ìµŞ©ğpcéû’ƒRŸ´!FZ‰$;İ½(h$6Œ	ë>ÓÙ—Ë•Ï.9»A‘6UBYƒX‰K	VJ-bÇã œ— §ÿéù>E?0%nªõl‰8©±8=N“¤òŞİ¤å²ç2h4üJ NÒ–£ô”€C<qUzÙYfÏTğÌª+öAwmğˆ°Æ’’|ò„ÉŠóD$gÈ<-ÁrÄ6”-CäS+ˆr.jm[ÊfÒ˜kœŠ†àÓSš\Äıçb²â(HiÈB·”Š¬€[§Ãz4‚dª1ÖÎ‚œ½™^ï­Y¯:ıÈ…*|ÎõúØÄ|­Xêëêµîú:tù·MŠ•~»3h;
ECÖ[.xúWW†á¯{g${¢‡ƒ˜m[G²Jn¡ÌÍí0÷ä'~>ØC0[BÀË˜gU-x]zå^3…^µO*¯ï¿ı€WßFğzáòğ*<üR×]¶ÿWìÿvâ xe­R9…,—væü`ÖbÎĞf-æüŞ‹Yæ€gõnv$Èã¨ \ı#ƒåD ÷O	¦Ê?qÈb™ó·¾)Ú?=é+×¼üÚƒ
¬3ô§{ôO÷D“Üè-ßF¦[‡®›‡^¼ª\¿õ?Áªø¨rSÅ˜ş[Xe_`ghkª\Á<	ë‡²Ş4)qîÜ¼d¹H¯Ü:<ÿ:<±&İbA.s:ñªÈgCGz§$Èañêõw$>23ÿjïÿå€UµT‹,°«Ê˜}RV2É5±Äj¼B Ş2ËĞYª†¢?•ìv	f
œ‚v·‹ã‘^dï4— mGI\ÇŸ’œ*¥ÚÛ ¥<¦X—Nxü¼TŞ)»Ï³£y0Ö‰	Ó» ´£ï€”ûZ‚zo<T²kÉc\ôÅ1XwõJ_Ÿê'Ÿg€JıEõ#®ÖÛv;”ÌÚ‚¢Å.ÓÓh…Œ¶8.Éf‰ªzÎ í-ëJzÃ-{­®he#’–Æİ±¹ÒÜt©8=?v^}´O­µ{}·î¿óÊ+(¯m[:&ÁÂ˜·v*cĞ95	•Èvzæ/R™Åçx´Åaø‹Eb´‹{3ŒÓ!/œxï®ÿv¹:¦ò¿Î˜È“f1?şip|#sEÛ«DJ&!•”lŒ;ÄşKiò­ Â‡v&ag_…Ç-/QÎäÚşä§Ÿ|ùéíı~/)çg¹'İàG¿ù“_l}&Ã ¹â5‡+"Å×Íÿ—OùÖĞ«sxúÈÍaG÷õËÿ§_[-?0‚O÷7'ÿ¯şİàèÏ>ôØ˜R{SÊå.Œşª²ıù¿áÿèkØoÇK·˜/±Ì"^Dci|æs×°v³ùæGroˆıZıü?²|ğ[/üóÍæûfâßİñşâg+7›ïÍüÿ   ÿÿÔO”uÇ,ˆ #/T*î®ÁŒft)Tò|ñù~ŸâX\	)ÈVK°nÕ¢ÀÜºÅ„B“6 ÊrK„ïÆXjK9İt£‹9]ÄF9¯ïİs?çîáà9Î³ç?x}ŞßÏïçû<Ï½ËŸ¾ĞÛÆ@$û•¾Râ¦²ÑT?|ıÊ/ºş^4H9ëoó¬6OÆÑÄ{u¾ËŸİéÌÙwÊ‡Ï:êoSBøSA^ıõÊ¬øÎü3Ñ“›×Åóğ¯¿şÅêd"i»hœÿ¿¢ş	ckPÆ4ß¯úƒyêW.`øİ`¶ÿœ½–rık’ê'ÎÙ;P™bÇ`ú¹:ûŞwGğ#Ì/I­Z¶=Càüğ‹ %s¦×Ñ‚ú":Æ¿ÈÇ÷ë,6jŞÌAZÙR¬¿G !,¶…pIAOdlGÚl>şÿ[—,ñÃ:(k § Ï}çÿÁ¼ò+¾³äëëaĞ>şâõÁ/Úÿ­8K°JÛˆŠ®XæübıßŠïÔ¦¿íø—ïWıİK »z(-ü ¯ÛóppŒ0¨ç¬¼^gŠ#Lö
 XYúJ,ªR=‡àï|cMúäËO†3Éz³|^BÜşr%³]¹`ÆI~X¼µšcP@®„-˜Ú3©%lApÚ[H>+—„7[¡¦UIÕ[Á‰ƒœñ”µ/S¾÷]œz*º· áGbÙ8èÊRcÎƒ@Ö¶4cw™ug­bâ@Ø‚Á‡vBSÃ&	[pí‡^cÆê-’°@8›nèC74ÏI"„-0]n‡²"(a¢<¶yj(KG2Øª6ÅÄc©æ¢ä´»Ô(CI"’…Ï zd¦ª×IØ‚‰—ª{õı²  ¿ òn¡å“Üø!¶çcîÍi¾ãØQüfî¦ß\ÛÃ¢,•°{vù†ÏáªŒ]Vî¨ÌÏÜÆw³lÊ{Ö&ôáæ£áoO[»ÍãKšO‡‘QS clífñ(¾¥€Ÿ9Š‚„Â…Š…ú)7½_GwµôÜ¨B°÷ñ¤b¡>=ÊÎô@ÿ~0›ÍóJå	*e/ğêüX¨„êiãˆÙJ¾»C%*¥ÀÒ%ùÌ§*"£L1èšPìÉt}jˆJ‡ÚúZóH¥g(úTèÇ¯"í¸’>ÕRÂæûêS¿ÈsüNvè8T"¡¼ö)—ŠaËSùßÔBSÈ^ßÁËSsNÜqÀ«<¥+) 
*6úT=U•xC¤s÷ÂPÀÃŒ² (€ÿ²dÙ7ğò” ”6ª©F“\•NŸšS*Îàä…¿Ñi½#/ÉYn†p— óCÉ: `¸EºR‰‚Ò•y›§\ºq›Oi÷…ªò»qŞñÍ¹iœU‹»Rö+
²Õ§\¨l>e2AyKÀÜB9 €‡ıÏ‚ }JÊ@4Â]ˆ+Ç§T¢ <ø”ınÀI}œ_So¬·´-¬Hï"Œkh(è:g¿İÃ;º[oëÛv5·²ËCådmÇt_<Èæv-ıøÕÚõRvÙ“¹Ô˜Ò@İ©‰qğ ÅÒ+‘FCu$İğz›0O|ECß¥O^fzÿayÊŠ&oş'¨K3™å€½:´ S³%;ÏÈ@"¥|M§† _›Çİ#í¦?PS¬A˜gÕX0ré Y²ìY–G9
¢™-;÷õéf¹a}„Ûºÿ   ÿÿÄmLSWÇ¯¸DÁâ:¹ê6,/Œa eâ^ì=gc
¨¸Šz)µ¥–JZ„¥)jWñmŠÂ\™R…0¢Æ¹©´¥½l‹oÙ¢®ÆÌ1Td· ÛĞ9fv¼åÕh—KÎ—¦_Úó»ÿóœçşÏíóôHÕLÿ€xì¨‹‹%±ÍËæ?"pôò|8â50¢Ì}àÙ<†ë—­~±rjµ_då|ffÕËTä¹—æÅÅ/ğŠ§'ªâ!ÄÉ¡’BºczXŸ>i¡I ²~)ıÆ§xì¨@Œkg5è.M Ò¶u?e} Y““lmg<àAÊ,}J gNÑx‰è­ºu×¿}úlÚÂ }Ìû0yIi7O|65  ã“f7½AÍ6ÿáÖgÒ¬8ÊWYbÍÉ|]§Ä\öèÓ~?P²câUÉ9› ‡,8Âa€*ëÊ&ğ|õ¦­yß¾yQû'SÜ|üTh]H¾M‘!xÕË&¢˜>¼;—6•õÎ%N‰i ¡§gÀ??úôÙ<´>Â6Ê4Ù–YvÜ­ÏÌãAÖÏkXS—«©§WÔ×·uJÖˆßIëÊÕ:õI1¨¯3KÎ¸Oèya,÷‰î2@‚0½K‹{ƒ{úİEÀò:ë$ˆï$=É•$$6aæÏ‰Qœ<èŒ¢Tï	û¹/C-•)t¦¢õ2¢âÜ\uüú$>Ar¿jŸä+«–¾]’Ê3	êT“1¨ 8[‹Rjøfì™šüAYB»VÓíU5tvÅ$Y¨¢–Ë”Q×…Lº.U©ö+Ö|B›³…$0×ŸÚ½®vfÉcÅ…3€üñ!0ù˜o•V«Z'gĞ‹†‹ßxùà3E6 Â#NE÷®-”ñ’äZ¥Ü9ø+ÈKªuğ¼’¼$IQ&ƒÕR˜îèÀ¬ÉÁeúzlÊHæ[“şÙÅã¸Íëô-Èvğ·ÿ‹g¥FìÔ'¤÷9¯¸Ëá0šaaô.µñ%Å`dıÖæÁéK¶òÌ’§Ô¬|
ìãã¹”;&»§@ş‰œ{§ıKöˆïgpÙ…2¼×Ãèlb+6Ã‡;·óÌÂ5I¸› Ü7gßgû„•O°G"p÷µ¢á ÈB
îñ¥ëì*©v¾ØdêçRr®5³Û‹`›ïûwıCŒV#`+…zXW××ÀÏ=†İõıç]š¿V‡ú'Ñ@ñû4˜ì³AéE;m,‚‡Œ&-lK„M–tLõ1«€_Û^^Œ‹@ßõ=P†|C·\MåYƒÎX§r¿àb°K¥c·å<{nU‘Z6pìø$¶bÜ==7º+2gÕVÖØZ4XÅóLpC\ÿ¶5KX—ï1xÒwXF÷àúC,Nr}¤Æ÷ıRÃOVöşşìb¦5™#/Á5ÿ,<{©w»èqS–;ï|±^çÛÅIeÌš\™=/ü·	È;ù?¿J(§‚Ë1N"ş	¿zxCQ½á]@`¦ „ÕtHµ?ûŞÎo1j\G+&²ñ#a/w¶*p$/.^¹y‚9V@wdı…Q‹´"˜ÿ6ĞZ%NŠ–å Z±3Åù:*İ%éRáÔB±ì&È]šîôY‹“Âi¼šMB6C~ctê'¹€Ú”Ëª³pR(n])ùl»¢£qOY7N±4m)ÚOrÃ¶tämŒç7×ƒ¦´ìê“¿a¤0VõQ«q#Eç• åp	ëŒÆIQŸ?¸nlf]²VŒZlZ<Pò0ö“.Œs/eÒs€S¡À™Á]gïÑ«£>ùŞ¥{ã~Ï“ËÑ‰8)*ä —M·äN|oJ€˜ı§BÍq÷³£ÿ   ÿÿÌıOSWÇo”)–	bjÖ4®¸)“_"Ğóh£Ífˆ™ÉÖAŠëBÖ¡âÕLâî„8iP
n–­F°:m"å£8¹Ã`¤Ûp‰:–©Aİ–Ø_]àê½æ4Ç¿à~ò}Î¹ç</çyª°ñµXäèİì‹a™¥„£åÉ«°Ò·ĞrÖƒ1õ2ÚK/”Î·ÙJ3×ÅıÔ¥1]*>"÷\Øó– BÚÏX­$BGÉ¹Rù¥¼IrÎ=Ä>Ã0ç­†jB½÷’²Q3Êç4²4­¾½<ÂÁ×Õ‰¥±xW7rcv\Ç‹Ìğ¾ï+nŠg,©?ï‚K=ü|!â­
èŸÉİ~MÊ[RHÀV	¯4s³…qúâÛ]I³’§¹1È—I°³‚?û¹1˜!˜·×@ğöAnÎ*èv@Iv-7]S*±^Ì‡CmªèÇ vjøù~_8‰Äpg3|ß;Ô*…=mŒøÜÓÜ}lUÁå¿=´ˆÿìdbHØ7S÷q&Ñ‰‰s‘¼ëhüğ¢Fqï\´Ø õµ4â³Nt¯“àb¸üC$wM”¨ Î)Ø	çu¬óúZ¼‚u«£±ÿƒjˆæê´tîÓ¥ZÎoÛ3p}Ìw 1÷M´X$Ğ{ ‹/B¬â`œÍÓBá¬`K´u²¦şïº(V‚‹‚¤1ÆJ¨g÷aóÒvh~1C(Ï­"Óì­Œ%éU7À ¬dLPd_û1-Ø.*)£½Æ×ØŠ?ÕçÒÂ‡MF+K³Œ_ƒÜíQğõ‘õŒ·€Ÿ|ƒ¤†$X1ñ%€ñŸar–A8÷À$-›ˆ¼lĞb3¢NÆ¡¶‚|olƒéæ¸q´ŸXãeób<ıU»PÎÑÌHó¨¨#‘„¬Ÿµ"á/ÖåeT$DLıYfwyÀØFÚ+Z
E‘ô{àÑG¬}İĞ_÷9ÕEî“Ñ¤pS#|ò¤•±¡¯«øç¶=Å2©cÛ·Œ	ŸçØ‹è
—=¯(×aË,%uLæ§ü–53>ÆÄ6‚®•dÅá¦³ŞÄ¯æ'r&÷¼Û~°çlLœÅ˜DË-ÍòNö/ÕË±@GÓ±µŒ
sã-Sı¾J!pÔB˜tÅ”Ğ×!'—NáH¸ºÍ9ÜM+¾~eœ…tÑYlv:ú"ü	İÑÂîÙÀ´&û‡/Y©ãÊa´Ô!Å‡Ó]Ëb¾Bóì®ÜõôÎúßuU7Ê3Š´/¥öûE>¹ëÔŒ¥ ›D‚u{
|˜Š§&tóBp^ó ôf/>y¼›BàwÒ×Vc¹•‚ûµ&TûØ…óC?²vmÅ¢›
Î{~¤¿°×8¸!Îø‘2¯	ÿËOãuj÷iÜÏA…g   ÿÿÄmLSWÇ¯
Ã¹A_6) hu…Š¨µ\¼÷\%jfVÍ²¨Y)¬- ¶2`LA¾À—&#7õƒÓªÅ%&ĞŞs}YÔÍDçÔ’¸èâĞ ’¸áN/ÚÛVì9>ôÛïó<÷şŸ'†ı_·€ªCßÃõ£NBøM@/‡›CLB[Ø\¡¸°˜£’Ù¨FXÆ
T­¡$839®#hÓ²Í¥æ—ÿ
}¿"APî)çê¶5ğ¯7>K‘©#…ö_qÂö—¢4‡
–ã•\Âå#•¶n¹PSTÆ5p)y´@7ru÷Û»·Wİ¶ÊŸÂ…“;¹”à~{½óªRüuÎ6®­f·{Zsw4f£©iyk2ÓWjÅ9Èà¹Ózwµ™GMqYŒíŒ·KxÔúßb^\7ÓŠòğbömS‹:Î1ü*@ä«ù¬$£æÂ?ìCM‹±_Å•D1½e àèsµºììƒç±`Ã“#N×³i”À_ŒKË1ñ–‚­pÓ›zÖ1áç@5s¬„ŞbGÓ¿NÜa×J†Ğz{ ÓğV©Óè£}b>ˆ€·3àEG$†Á³âôaÆ-2LÇ-^ÓU­Óâ<‹Ù7³¤©¹©RíŒLÈÕÊ!ê¬Ô†vÌ\QŒ'ÿ%4bĞÓ×$nÙ3ËêØ°«ŒäVCÿR½˜/[¹®ê~¦ö¸q5F¡¡m‹=v,q•añş§YÑF–,CE³èO©ºdQÜë¾-½(çÔ9tOÚ¶#êÏòSG¤ÂÏŸyX½-aÜNM€OÑ…ğ7¶!KQIcĞ7>IÄG÷^½ÁlÔ¦¡?—¥ıuˆ7'Yº—½ïÚv[KG 	{ƒ=ô%ßzN®®Èmé´3gÖŞ±ó©
 ¦K2ÿqÍ™¢ø°+6;rOn¾É”Yj2şÿéG_©u6ÊòÃƒá[l›-x<°¯OåL•ËxåòÍğÔôsı¬r†Ce€‡ú‹fB£‘Ÿ™yzm¾Ó:—rø=I=¯ğ?ë‹’“–@ÂïÚø„¿~ß@ÂŸNÂ¯«Qó——ÁNoÙ¶ïL£ô?Üyä>§à•ßT2pn¢‹ñ¾Öòƒæ&$mw©;©şÁÉzxÁ[ÎÈµ7êFè+»ŠãD0Å¯â×o½«@!r­;qŞõ¼P;7=²İ2êMéEÚU™yk¤tô{Y;##e›ı¢u¹ùcŒ­&x><¸ü’Ç“„êhiSã¢ĞÄÿ˜!
‹¯–'®.Ê£÷&I½‹[xz­Ïâ™[6«‹0Ã:¸ºbì\{Å³°”k›Òä‰Q²9¢°¬ß7ïJ§éF»‹°÷Ea/ÉÙ)±RÜ*õ¹…l²w6‘”Œi"£TªJ²ØïüıáßÏd4f™*²c=—él]¾)=#M›«wO_Òñ¹_«cÇÏ~ƒá±ÏQ ÆâSı/³ttKĞ"ÅúÆ––MmÙö53,ö²'ã¢Cº­ |ÊDtŒoh©VÉò;AEÀ! âr\vÉYŒƒHêÔ$\v{Üp.nè
HÙeÎÿ ]Û2Gì£ŸˆËvŒİUUƒTÇ·¸ìh\¶ú¡PŠÇ¬ëM×…ËÖœo —î\ì	¸l‹ÑZUe$ìH\öèà… #¸œ$æ¸ìF+Poá	bËn½n.­'aËpÙ)º{@ÓÕÍ¬;Ldãu]ªH {tXîJWÁ|<fã	ğ-¯œ^¡ËUœ³àf˜÷ğÀĞ–´”³àãß%ÀË*š@È†ÉœßgØ«'â1:˜vİnh™T…î—ÅüX\¶òÆSXeYGÂƒËnUù	1Q{»wİ£qÙ»>^[6"6vÌCE6ŞY·ifyı,np1öY%â}ìØ¥&Îüû" óÏc	š¸Róóåpô@s»y‰#@
2q$ú-Á: #Èœ<{ì’‡’t³Á¢Œ¬c¹»{rnòöœ=Nè£›ÂeÇD]í;ööZ÷   ÿÿÌ]LWW¶‡âú˜0Wip[ÄLSÑ‘Ö^‹8a²¹lc²B­Ò¶ÅI0¦™û¡&ê™F&%KØŒÄ±9ÓvmÑljtÃ¸_²‰øƒá/d?t°ï]¯íU+¤÷Ì²hiß»wïóyß{÷}ß÷îûî;BšxS>»#}¬•ËÇRÃw»Úõõ=Ïb¬ôLıês}ÃÛOb@g¦ïëK­gè¡­8W{<‡-Zá4¯^ªßôÍ	œ’q}}Ó\¯¾ÅşNë38lÑ­ÏX~N+k}•ÂcPv¥	dğZÃº•ã1¨íÜ¢oÎÿg>%ÃcĞ½°b'ßÄa ÅcP´ød°»o%İ‘Ç Wy5´úìv` Úê"ñ”ÌÊ
·Í?€Ã Á’©ıÁS§Y¢­?	ƒñyŠ`nW3È@4‚c Bvìú,´)İo@M¥±}s)N4‘Xìü–K¡¶é8Ø#4	ñ_D´»'îöÂÁ‹İr9#ÜıòyÀ.+óÄbwä…C?à`ß‹İf{&œåîÅÁ¾+»r¾2œµã,öß¶øQßwA¿Û:‰Æsÿâˆèí•}ƒúúœ8cİŸb±•ğö­8íşC,vÛ]…¡ñİ‰8íâ°E_u}°B_¶`ƒ;xúme­kÃ]9"úİ½ısC%ı-8Ø·ÅbKgsïb­¤İâ°5c†ÑŠ¸ß˜8ß³†qTGöÛğÛmæ%Êø²==8ÔÔ¯y^ë>¡Mş¸(Õp^ğĞVßïÏ©ãÅ”ÓÚ‚S®½*“¤`ÖÚël&ÆEy*ìª¯fªjÍ&ş\¼FH
-z"æ_áİ¦;v/Ş[ë£Õ“ÉÈ|_aµ9,Æ:DF1ª¸° jDËB
«JpáÍøX(9+%íãe…°R‰§êšék}ºX3ãØÜvŞß@k
î;+q{3
Fk€Ób[Å°±Pïo­Œ5aóì@mÓ]ğ2:µøÚğcšÛKiUş}‡7ö¨˜ªŠr| ‰Â tj‰ŠK“V+GşN¸¬*ˆ·T“áæjBûtûµio©MîåRøëY!uwrg€Ü¹GB.7J.Ú#îï£Ñ;„^2Ç,sMµ¥ÊŞYµ£…©Š…ë3¨6é©Q¡ªJ¾>jßqÙ?	}ªıı<GÊàÎäe5Hùn‘E:ß8¼nÒ¬Å:íAçŠˆ'½¾\ÃÀ¹"LÈ ãz¨ù8è5¿`¶0<22Â3X Šâß|ø$ºÄŞƒ/”@YxB¸òÙƒğ
‡äøcJà:.ƒe[N{Ö·@D®úØ5P$0&ƒ\}“r‚e9ƒâüÎ1Hâ öĞ^ #èR÷¡BAÜÊáƒ‹œÀä¤LTËüïTÍgõ¢ówºIiî@Ïàô"Ñß4:à>î§EôË„~±}²AòqÃWÈ=')“1¯Êµ”Ğ*Éş—èÙñÛ¡JØ]°%ˆÀÃSĞ5â7(2Më UW ¼9¯Ò"„P(¸9ÑôhÛqQ“ã… |3Õ2¸"†Á#T—Åà't\õĞ‡Ë [=\Âe€­z9ÿ'õp‘c”â°•Ğ/pÕÃo)3xäêá×”)€õğHÕCÇ`úèÖƒÍnº7a
Ò.‡–Lì2 Õ+ñå'ê¨¤&Ì‘$„jªv`{l)ÒV%%WÔ`Áøà“hÅü"’Âf¡®FGi„d «Ûâ®Â9”ªæ¹£¦DWú:Ñ”û™fG‹Ô/F»N0`¹«õÈı	8”D\0^F°?N#.~¢I7SšşU.AÇtŸ»+¨@ñ¢Ş@ñ™‹Z¥GYî)hÔÊ=Ùåş’&"òãjEºV®Íöd–û¿‡<m¶63ò/é%µ™ìó›	¿œÈögz‰yåşÒt­<í%  Áç­H5PÂK r„z÷"$ï…l‚Ğ§#ya¶WÂ&—€2ßñÙilv~äE,­o×yQ6PleóøJfHbTäåä&Øï‡ N¢áEˆı/Aù$ì³ó›§†"kÍN„Ê:É48N Åœ9F“éE[EƒÓÅX¸¬2™,vÌÁXlk˜R‡ÍÂğ0·—Ğ”µK¸’p²ÙjvÑ6«ËXã‚,¢HØ\mtq?`’ßlğåtÙìğebŒn×
 â¬·ÛáeqNp‘^.¨a•Ùºy¥H½Œ@0g^á` HÂæ`çÑ‘ß]ãò›mÖ ¤5$Ôa·YšÙ
Öš…OÔÀË‰l¶NŠtEê£`5­‹‚´Ùm³æ²¿‘J(’¯ ;™VË¢§Ój)_­fOc«°YQ$Á×Áçk¡Õ’'!ñPìpñZ#ìÿ4!	ÊñH5%‘*†k‘xøBy„Ñ¨á&\°O’u)¯5Ö˜ëÌ®†ªjåÆ  ÿÿì]OlY~o·ë”6“¦°Ê²e´Kİ]­ä4KaÅ3ãš$4NR;iÙ•ĞìÔ$n;ØNJà2Ë‰•VĞÚ®¨Ğ"ù°'BH¸â²‡EBÄN'´BH]|¿÷æyŞ8Î†r@{¨"Mæ}ï÷¾ßßùó=ãCú0ôLF	äjƒ£!1Í=ïñj¨™ÃwÙ5ÅßI²3l*—‰‹€İ¸âÿ¶[AıŒµÜfÃEæ;›øuäÏ©"?M ³yêe´ğ{ÙÍFZÄÆ©¢şbş@xóÕİf¿éİiÕÎÆãO–ö¶oÖğö˜4Ö´4~½âl]şÛ!][”7ÿkøqZ³Åf;Íe	¥·›Û~Ãéä xô€ÿm„ÊÏÈÒ¤
ık˜ÈÂ¥0z—U·ßÉMsØÅò“W%šm¤¡ê·C¢ƒ¸ {>$£î\|ò9ÍÁ¸Ş¬Ó“Ì;­ZÅwıFÕ­ÃézHëÌE½‚ürHŠd À¸‘ä»˜Ö·;^ç’Óìßİ©zwóæ-¿Ò©íùNÛ:Ó{!É/˜ƒ=m†i¾çíÖ;nµÙDÁíøß©bÀç’|Úì©Ê•Mq°^«oò“ü)SC^ñ¤2Øi5÷%i.Ésf0Îø·S—MvÙX¯Uµß95Í+X#l»u¯*ÉóI~ÎŒÁ‚Üğ“ƒÂ§n@œA!˜£$œæ_÷¶6=yôö¨¤!»@Åñ,¼|oO¼6j_9ÂƒÁ•zm6Ò¿¿E^%…Ğz¹Ô€”Hè¥Î*^×ÜØu|h,RĞ{|©S˜‹ƒ2¹œäŸ0"B2Íoãtiªÿ6;ÆîşÛ9eå³Îëë¥Œ±Ä×;,1Æ\×ë^cë±ty9ÆŒ.ãq¤D5^Á¯AvªÍÛ—*±×ñ«Râw g¢²WÉë¡İğøe¾UÃCî£¶í;-órÓ@ÕİV×%× hö&—Lë|õŸCÖµ~LsPGÇêÖaÅKÒŠ\x¦§EfQ»?ãòˆKË+(gµo¤ØŸÁ)€79%lyİôÚôä’‹à´7qMvq
oÕ=g¹ú
U	.·Ï„İ‡å|°í£l^IâÀpÉôÃ¥¥pŒ27Ü@¢|APzGPæ„1ÎÃ(F”™_½»˜óÈÚŠ ~V‡D*ŒÀì6]?ıu§ƒÀáØÍ™
éPˆº#Œÿ„±îÕ~Á¸Áï3èrv‘uc)‚SÜHñDŠ¤xò5~ì5Ş;ŞåÁ—Ÿ±±xŒÿÙğÿ,ı747ñŞö¦__gÌÄYZîâ>Ğ`Ù÷œÑûÙ¿$>*[Ç:(Ëş[ÙÎóof9õá’®‘À–ìÛÎIÜñ¥ÄÂ!# OºM]¡)FªÿïlG(}İº<•Á!Ÿ>ØÓ#ØT@şK1šP±£•ş/bF>ƒg\[^…eW~‰Ûê=¯Ns„fIxSàÖ÷b¸¥ä»^ˆ]ÃÎœ	şóçCsˆı½µÕÙÓK1ÜR,o|6Ä»øOX³x6ÄÁ®ó½ÌF"ëû<½ßrÂ­ú Ï€Ş@y{o,Æßçyë˜ÀCÈÛRBà"jùÌ±|ôX:+š1}r§ªÃ}nç»:¨8?Ìé$
şÖD¤Q‹@fô÷ç>¯É[$x•,œ¾ uÔ„Ë±QÈ"+¹nŠgşi%±èf*ñ•Á'15Â’ı9¥X²
é{,èó›ãŠ&Ÿù”Œ:T¾b)åv-·B'“Öá „3ëëî{Ô·$wbÒšÿ:n)Æ,‰Ëû´ÄQÀ;. ±iì:®³K{ÿğ \KìP¥Bı¾Š£ÄOö¶ÄÃ²~JÉË¡Qm(ù|F»òtvvv˜ÎÌ›w'u\qdfg,}¶G‘yóî]‰ÃF=©ÎÒ·Óq+´IÕá „aŒN~6¬˜¹“ùŒNb#¡)¶h–‡höí“±šVäÙŸˆáŠ=ûëã!.âòT xş˜qÄ…´†µ‘Ï<§»J£Ş}QàwF˜I·—›MÌ›Øsœå³AâÄ¤Y°KK®íŞXXš+\q¯Øss…»œ`8Àƒ‘ÁäI³âµ6š¸¹Ûé;mí«wu¾à~i­¸ÉÜ$lÅÎ_µç
,y‚İI0Ü¦îFCq÷ y?bŞ¬{•­æn§Oû13¿\\Y,¬\gËk«õ“‚ºT(ç×$3òğ½†ª×/¹¥e8–Ÿ&$™)_…£¼0Ëöui¾cç——"%“B‰³<'BÃænƒnŞÕH],±W¤)ĞàUff³}KN›N	uEw~¹XˆHã´¡ĞAÆİì•*4/}­×0;‰[rAˆ}q¡T^…¢R¹P´—„é»·…ƒm¯³9@œN˜{˜ix¾ëµÛ4î‹œRp}aqYtírÙ^[Ô2ñ¬PZ. rWâZáL3ŸN»QÛÁÔ	¶R%NHŸÒrÜüòª0A“r~»âíø}&Ì•…¹¹—™«niáŠ¼é8´)7ªş:ÖúRßy!¾:¿P0š±³Û"ó¸y¥P^)”l”^±`—×PgQÒÎFè[¤Wwô!˜-íÕµ¢ğ¢r¶®VåDİ>ü0Q)ú°©!Úàá-üe«Vâjš8ÈÅ1{ÃÖñ°„–×J«óñlRÕZ˜l5"’3fqa±àÎ/ÌÍ»ùÅ5‡|»÷Ï|'©i~ß€Á:¼6ğÒh¬%aõ®ŠeÜ`÷ş%sGˆa®£Miº	1½ÁÆÀMoŠî|­ñ ;’£PidlÎgĞ2°‹IÒ»Æœ /âàçÆ›äBv&J8èĞdSœ{Ü¸†)ÕƒhŠÙJtŸ)È÷6µ.
IÔ	0LRç«èäl’Î1=6J.EÓ4Ñê±n$°¾(çÆÃä¶b°ı}3c´±ˆ"ŒĞá{Š{ ×âV*èr
k¸‰šbOm+EöÂÔ)†èğ‰ùŒ†@àµÁÆCİ¡"ì)ØÈ1şBÉäŒÎ±ËÙbõ–¼‘R„FÑ˜µÊ2İn`*¹¡~GãClœˆU‚`ãÈïñ‹[“
hlPŒ\ÆOt46dÓã¿¨¿H
RÁj8Ü@†˜‹Ş˜#`™nÔ°æ€\ÔŒöbÃ¢äÇÔ&Åá| ¨) 1RÄøN1¦’Ö9…)*8-ÊG
	ˆ°…l*GVÅ»D-	&:”ú'Œã(YÈr|¸‚ Æ9¡‡ŸjG+0D´)U¡è{ôİÕ
%‡A9ã×F4ÃÁ|ä†
v€½Ç‹´N!ë7¦.<\¢LG{rÃšãv÷Ñß£<ŠÀ‡-¸»?ÿàŞuY¯ã3|6ÿôû˜,zâs|ƒÍ—E+ì’Õõà	†]OÛïƒBuIÁ°K6TW|”`W]¯–‰ãaGIz5*fÆèŠŠ›ñ(,ü"‡ñ   ÿÿì]{lÅÿvïÎñ95y IX„¸;?p’Âî0<
,Ğê|¶ÏÉaûÎœÏI.‚vJ›P"™ŠAº*E¸€¡–7„;,j"Tµ¢
Â£@KPQ_J£¶¿ofwï‘Rè?•*'ç™ïûæ{Ì|óÍÌÎ·gêûoüOõFZø²3dÅ_²æ¢jfJ-J°8|«

Ûø¢‡1‹÷<Ä;wOSÙêdŒ	Ğ.Ş)Ÿ(8oùqê	êØga£„CÈÄ®¿?åŸÃ'‹]–Øº¡ÊÛ,´s%¡ˆ3tzp(yıhj y£øÊÄÑ¡Á4®°Œ»]$áä‹¤)Jˆ#¤ûŒ¢†²£ƒH<ğá %üQ"¬BÍD¸YWÔ0.7th‹G^ê¦ˆOU¼€9élÜi|ª‘ÄUñE(ûÅg@@PÖ\·Q×êXùû‘|S@æÜğîNÏşÁ4İ„†Z“kòélª/ƒ‡#ş|ïİp"–¿W_›ÆW„:ä=x0Fíd®Pp_‘LçÉL,Eò“WIÖg
½kq¾º À=lé5.0YÈ%ãÕ•*q†Š65÷¸ƒ¹TŸdÒD5i¥R¡0–0˜NéÙjj!€ÀdÉ\Ä–à °Ïãe È1—0Lö2D6ë¹$x™‹«Á#©ş4šôbx“âM(dRáéMÌÕLW“Ëèd~•,‡E$™«%ûSèms¥‡½k-EÑı¸ÊÏ"eEfvy•Š1`#’©ÌòEÖÃš‘˜]óÏ‚™è&„÷¥Ä›éb9ìæÅ5@< 5ßqÚg«Bˆ•º½ì5Á5;|Áü•ıb^Îu$è%u–Ï,S.„œ¦@æÕ ©x®$ÔC?®v…Ñ|6Éí™a÷!PÉõ†:¸>„,¸¼™­C%… 2²µnx]zÌw™Z£›py$=”‰‘ù¾[n!ó÷n¹•Ì÷Ür\Äí–·Ø£æG
h*k\AÛ}Å4~Ë«´‘¹×«´ƒ^‹Ê_SJ<Ã–Z÷ûÅsñA??`ğ[ã¾ œ±OÕ@:“>7îPİÄĞé»½¢ö0ŠcH ıF¿Sxn
'–îòY›ƒŒİj„+©¤§‘6²K÷s'ò;Ó?W©‘f"’š+?82§"+“q¸_0Bæ)'Š>¿+î³¾ääÓÒB‘ŒŸáÓg8<÷\‡4Ñ‡Êwá6ó;Á3œêE¢z³W½z„¨+Ì8j¶§ÓÁéƒ™xìÚwC»İœ‡ú §>/	'T¯ê®5>jZª
NÖ*_y[§ÒñÇ¦ó;¶e|Ô‘¹{ğ1†¬òÓf iÓŠå³¨ãıïûë>|¬ |á¸È“v†­Ak\åù•	UïZ	1"(ôQ×àøŞ|n´w-ÁĞ®îEB&à6ß‡²‹S¨k£\yØÕ`$µêC×€0™—[*‚Ïkw¦ØY]€œ€Ÿ5­uéÀæ;ÜTÌ°ÃÎÀYHtuÖ ¤“Òµ«/ÍÏm7sŒ–óÂ¬Ì­£›hV¡M¯™iæ2V‡ã[”Ì¥nÌ:İrf£;±EDĞ>$˜/qŒ‘$cœ¡•í#³ôÇx:œçõ×|‘IÅ8‚R"É|²èşŒaÃ:·ª¢|D@ `CfÛ ¢'‡Ùd+¢ÌyH°E2Û=˜ E[@«ƒu€®Íƒ‰¡,¡n¶Ö“Ì°¥VÇQ´NF™åjÏ³„š®{u3v/*}¬>ÈË1ÈóåŸG^|ü¬À9ãÎ[?5p–8æróÄÃIÏçß¥fº/ÎÈW…““_~Ñø{G+û8@‰ÀyKpÇ<„B8·¸Õ2]=¢w½íàD?}æ„Èâ1³ìÅÌÌL‚v„F|¸qs•B?~%Ng25Ó1‘÷Ñ\ü4#1âAKü* è·ÆÏ
ñKu)™ó¢‡Ş#SWtŒ£0÷¿FÛ»Gè”s£«éDËT(]QŠœ8§gPj¥3ÃïŸÌ¯êô°#±°ƒˆ”‹ª„¨Pİ¥Q²õgì„É¿MpPİõğÛÅüêh÷Ø˜-R.>h¨R²\…â’)Sg¬ç÷,÷Á„nÚ"ôúæİ{ ªDÜZ²I¢B(dkĞNT¤qËÉ&‰Š8¢-C{:Ñ
)Sn9Ù$Ó
…i›?û5h¦×-Õ)n˜æøWÙö45şDY/h0–ƒ@ˆBÃ-"Sh´ÓÚRAC*œıò3eYœ£4,£ëFÜkRÏ7Ç16i·åâ•İY-ö½X7^†Ç=x¸Ğ·RÏ˜İM¹HüÔ½%¢„â] Ï¯V1°ğ{Ç=íÎw±BµU8ˆ[}³saÏW>y¹ŞÓÛ•	lJMŞ¬µK#;p!Ê»`@©–RIÛ&Şì€Çvx@²›ßÍòï¸º)I	a’)¡AÕd	° W´Ú¼´åJUlö\Jt°Š•MQl¢6Zş è§hd'U¸"ÑıêÉ–2O©Å&¾=<\'é„	¶™Ù'(©)¦„:ÊªSuÉì'uIœc–
‚q%km¬Cü¨ÒÓrÅS¦@©ŠÍšË¥DÛ¯ÔÕiÈŞÆÊÁ¦(Öº2Fî1ìó)f²üñÁƒ–O¹ÅZ×Â#P¬5v³OP.RSL	uô<¿b+AÅ¸’ÕZT/ÚıJ…IlöXJ´²¶7Á*€f‹°	º=E‡¤sGŞ‚`x=Åz!L—{¡UtWõ•¾I|CúÙk„ô#™yÿÂÍ¯[î^x“øÏ-«Ã£Ë¾>*½ñ{<tA.Ó­ßü\úâÍÃ(kåÊ¥ÂŠmY"z¼–ZĞ^ø¬&¥ª%–(5›¾w97§çÎÛxŠí¬
¿eañû#ñ¯Ÿ—ÌÑ.óØozûïE¼QmnnÑd>ÙŞ!D‘y$ßóI,¹Ö!Ì#sÉ¡]ˆ%sH¾ç’ğ}-lÑá;;üC:„ıá:MÚ…!†D‘JE­—í•ş'Ê‰ª–ıÀß[kÜ•Bı*ŸZ‡^>:øı;ƒL­±£ÿ6r®†U­÷¾è”6/b—™/ÓcÔ.­ŞVÔâÊej¡Ø¦š@jÅÍN-±y‚Z]«·˜ïN¨juñ$CQ+¤+je4²0¼]H'©Šji$…A­T’•Ú…² ß×Â’IÉé²ÃDüÇşğ$’ Õ†„Dï…á	$¬A7Ùï–Ú>>‡ã½d§ğÛâYåkÿÙ#=Ø:€­x9ÈÈVØ·˜İK¹¨Zú%¢0P¤(¦Î*v`>Á®Ş©ï3wìjŞAª4”.©m®Ÿ’Kôr£è©âIt¥¶íØÈH>ã^fƒäl5¨ş¶QHF ©ëÁ¦¨ëÁV«(†#ë$ı¦‹L D‰ÕŠá6nÀF 6Âv0»—rA@Q^5åÿ   ÿÿ¬}PT×Æï"£ù`´µ2ˆ‚¨hlå#ùÚå["°*º,Š ¬  ,¸îX5BÍNí•ÚXbÑØ´X¿V¦IÉâ{Rœ2Lf2tšd¬±©ıƒ©8Î0&¶¶Ï»gaÏ²šqfï_÷îóîùñsÏ½çìİs·4ø‹’*Q¢Ÿ-‘ç½(ÈJª‚½
'gâ$P¢
Edë‹¤%è¬¤I”½ùMÂ~
y×Jp“é6õ¡âÏ'š:ñfáøbŞ{kày‹=VÚûtk)±èÈ»=«cv¶”+,âé*¬Şÿ>lèQ^«¥{ÑÄ~1üå†æàC}]ßcĞŞ€ßğdhZÆêŠÆÓ)¸Â’ã‰½/œEQ@kÆĞå&NšÑWßM6Ãò[¬”=‹µ…”PI¦•›Æ’öÄcü[ùc“f’Is}|DötL$3)d®û°\b‹•\ïA»Y[H	%¹ÛN¹I²I6xò°ÈÙ¶¬âæ<³…lğXl)¢Á}Ğ.Ö¤„ÒD²`Z¦$k‰?$z¢¸(?²L…¬ÅËl¶aálèÅ¬°p6´Õ•,K’™ÿÚ,G/£6½dSĞÎ¨3K!3?€åßl)"sô#Ö¤„zÉ¦˜¸6	—O0í,[’M}å ˆ<ÅEù‘e+dS×Ãò[Šhê·¡;XJ²6õ!Ë‘d®U'Dì™ßúr–h<ŸH9
™k,ml)"×ès¬H	õ’%õÈY®$k9÷1ôåÍ™$ËUÈZşË=¶ ‚6œÃ?‚vvZ†êJ–'ÉJ2’Äğ•NåíÏd;ËSÈJŞ€å<[¬T
ıÖRB½d¾Ú|âÂËOÑŸ­’d†•"våG¶J!H‡¥˜-Vè{UÄÚX[H	Õ•,_’ÅL·¶ã1ïœ|9ËWÈb?ƒ¥‚-VŠ-…n`m!%4€,ˆ_¼&Áö\^&’¯sI~){MÛs7[¬´Ç}ƒµ…”Ğ °'®Êò•)ÁVK2ó›°mà^ÀlµBf>K![¬d½™µ…”Ğ ²`šY$‹»´Y”Nïšx(dq#°Lf‹•âê¡g²¶@DeJ0ûGEÏv.É/e…
˜}ò&ÑSÁ+Ù]°7°¶à‡yĞ24 ,˜Ê,’dıo›Äp:_jc£Œ"TTÿ§8›„³xŠí·Bç²¾HJ”£3PÖOvÏmî]™ŸaÍ#ÏpÇÌ †2ƒ;­UôéÊln¡&¨Ó]™pŒ¹ô—xÚåÑ_à×^cCä:,£_½S«¬©Ü]¾Û4ÖÔ9±mÛ¿r?O+Î¸ŒÅš‰Åg X7Šu7gŒ•ûQZqÆ¯§x†èÅmF<±XG}=Š]›kÀn§±<ôƒ®ÌOó—€kYÉ<"v£á[Ïw·^{ÿTë5¬_ÌGãİ­Fh£1:-ıá/Eó;—ĞÄ/ShÖaqcõèÒğy>OÓN×RZ(o%àÿ`ìØVµØ¬²º¾¦RkÜU¾s+|eÕ;ËÆ2£­“9iZ&ÜËŞÄràÇo!+…ñš™.µæû
şÓ‡®}ù»¯Óÿ›ûuº¦Ø-*¡}¹\òc ]¦Üí‹D^ü!èİ¤á5| †ex“@~^T¦6h4ü8BÕS½C0¿‰„¤eËËÊ»êâ´ÊÆ-åøÑüVß†›m†+“æh‹µªĞŞ-6U»2©Í°X[¤Í›Ô«-Ä ¼7d‘¶@ëi3,Ôbp<²@›ãÑ-Ç¾ùZó&EkóøDUh”6W;Ò2O‹Ôà8W›£µzC"µ­Øà¤ÏX"ÌÿÂÿØtÜ;H/ö4ŸM†¨?Å©¿ã”ösšñôëã¤„dĞ“›îo¼m¨Ş¦$`½,üÑ?
Äğ›`¿^e=„Êi²GóÅp3[¬ôè]Ø²¶Ğ«ÓodugÌ"9‹ò#Û Õ}Ëb¶X©®zk)¡º’Y$ÙàÊ<1šrqbÎ,
Ùà>X¾Ï+~Z‘+F³X[H	 âQ"Á"ÌÙÂ|’KòKY‰q–Ÿ±ÅJaĞï²¶ Ì-Â*ÉhfµèÑøîGfUÈh,¸W²}R%za»…”Ğ ²`šY©$³-Ø/fÄwO¬ÌR…Ìfƒe1[¬dûç>1ck)¡º’m”d¡¯;Eä.Ê/g²Ğ^Xn²ÅJ¡)ĞwY[H	 ¢™m’`k[w‰½|ÏğÛ¤€­ı–•l±ÒÚ5Ğù¬-¤„€ÓÌÊ$ÙĞíÂö·÷&Vf™B6üb“°ı…-Vúì_°¶@L3Û,É’Hû /|j»-äî6Ínæ!Ÿ©s³‚–”ØHZ7{œ””h'M°v@ÇzĞfcƒ)ŒšÒ¿a‹áoßÿØ/èåìZ¹D«}å}²ò6’4ßğ¥\!«½
Ë [œT{õ÷dÿœµƒ”PoâÇd”nHf:¦B’tàÎ¹\È”¤U(h#Yd›Å'tdmkôx¬M¯¤m‘hwÂ¿ƒıµNÊ¤)h[´;á³1yÅ'İ	ŸEƒ?aí€Õm«D»pqªv¾#Ñ|õ¹U!»p–:¶8éBôÖRB=dzÕg¥$KX JâK¾šÆ¦˜©³RAKxv¡(½Ï'%†Ïé:H‰•hx`kjÁÌbÙ$š+<^Ø+yÊMMA³)h.+<Ùã$×§qÂ^ËÚAJ¬®hÛ$ÚĞdaÿ3ÏÌú£mSĞ†:áég“†–@±v«+Z•Ds¦lÃ¶VÜKÍíëÕª4gJ™KÙã$gŠÌ5¬Ğã±4½.Ğj‰¶´kõ\o“W‚V­ -íz•zÜìqÒÒ®$ê¹ÁÚ=«+Úv‰v;æ9Š\Ê}Ö¶+h·c§Èö8évÌtŠ|™µz<VW´­ı¦›FÀ=(Ğ|}Ç…¬½¬FØâ¤ö2ØÈÚAJ¨‡L¯¾£F’õœ.ìÜMù‘Õ(dıËL¶8©ßÃÚAJ¨®dµ’,ÿT¬¸uš{,5ùzµZ-ÿ&<'Øã¤ü2è³¬¤ÄJ4zµm$5MŒîâ®Àm§‚6r öàú¿T1º5n ©ø»ŒÕ­N¢µßM·¦rêV§ µïeq+„=hjác¦vZÆêŠV/ÑÂ2…ùúYt¹ãr²w¬çjõ
\X#\nvåQØıa¾Á:‡”hÀıÈä.5â™(˜•]Â…OÉCµ\ÔD8»W%»ò(¼?[9Xç­+\ƒ„xq©p}ØŒÌñÖ³¾K¡AA(‚ç*<MÇğŞKÂÕÏú(ŞÑÃße,ĞºMšN—B£D›V±\¸b 5*hÓÎÀ3 M‹‚c}””Ø§Cû?   ÿÿ¬lTUÇÏŠ8’ÕE0VYûG@`éƒĞBÆÎ›A£h·kMSÒ–>¥OÚ"m©Li§C¡-Z
ŒRZ`Ã®µ´.]%ËÌœc·"5ê
õ±F›º²&«	ˆn÷î™a¥¸X&è?9ßwÎïœ{î¹÷Î|ç»ü½›7q^"ĞæİÃ†ÎW^‡V"¡Íí‚Ml€67
ús®Tò*Z©@+óD°¢ßóĞîkh©„V¦D²¢Ç`´²*Ø¯æÚI%ß ¢mhçÂïÀâPqİ¨m”ĞÎ¥ÃæÛr3Ú¹O5lhìmN*ùíY6ùĞí]´é:´gh¶ê»b½Àh“#`ÿ0×N*ùşZ]ÒÜ	ı##[Fø×[Èê›œq›`Åg˜fG­ ä—yµ°)À·¨bÖB¦©†	ø*ÚaŞÌµ“J®‚/HQe‚l 6i"ì£ÉÊ$²˜„Âdß-ešy\;©äT²rAvÁxã¹Ã	N…À˜•Kdªa’\§N·¡y&rL7É5¨d‚,¾%‚…}ï=fYü{0ù&³ø$èŸ¸vRÉ5¨d›™Ã2BcbêG“m–È}0y& sôı—Æ,çÚI%× ’U
²ÖÿhXÌüÛôkf¥DÖs‹ñÀd­İ0‡k'•\ƒJöœ Ky—ZoÛ9zÌ“Èì0iTçY‚ıj½æ˜g’kPÉ¶²áSëş†Ñd[$²áÙ_Pën˜`Ì†gÃ¼ƒk'•\ƒJfd¡¬¦~äMf“ÈBM4õ0Y¨	æÃ\;©äT²*Av*ë5šZÔ4š¬J";õLÖÁd§>{•¦–qí¤’kPÉ¶
²¶ZÔÙ2šl«DÖRH‹Âdm!ù´è$×N*¹•¬Z•>ØH‹ÌÍ£Éª%²ÒÃ0ÑÂd¥‡hÑc\;©äT²A6­z:µWc³Äµ×€‰lZõj¯€	È¦UßMí;¸vRÉ5¨dvA–Âô´(´uô˜Ù%²f E¿†	ÈR˜Epí¤’kPÉj›ğŒ×•ìMV+‘±	¹^×*˜€ŒMÈòºÒ¸vRÉ5¨dAZó–×şåŞÑd‰,´æm¯ı_0YhÍY¯ı{®±j\ƒJ¶M¹”Vf]Õ>›·§üØ§¡ÉÆo2-yîãÛ$<WìVp»<êÚÍ¬É\¯§’?•¼ÓÜºÆŞDër¿øÉÉNŠI ü¨™¼Í[xqÓÑ†ãu”ÈÁ+(ìç…ÒÁ× ßçz%•œÌôp´A6‚í‚ bê^\µÔból—* ĞÃ¥÷°˜w¸^I%§[ Ø!Ÿhbö]82y82šï_JlSŒ—'NÉÓß€Y”X»O¸]>M\ı×¹Tò§’wš~|G¦^PQs#³®çİ]…#³Ìp¼>€I³Q˜ÉŸ t6t1×SÉ	ã²lœG¦A\|rkOá}\!$‚‹E(Lä…Vä?†^Ãµ…JN·@Ğ‚ä·®yÂ»Ì§-<Ú¤Q±$ø¢MLJ‚ÎëNÑz	Éâ„èğ/Ë ·)$½™=²¿K€Î_â`äÆ†L¥µÔ†‘8¿ÿ@xhĞ¨X“l""Mû~h“"M®?jxÉº|$7I[SPRRGv¢Õ§Clû˜ç®óéVÎºS±è|¬%áÊÓœTçå´œô§§µh•¶_s‘mœ°›’Ow±»ø¯ª@¸ÔG&Â#c,H¼bôoùáˆ~Ö…7ÇZRPHš ŠQ¯a¯O˜O·pÒ&Å¢ŞÿÇ>ù½×= órF_îŒZ%mOq°‘œ´‹’÷mì¼«É§õÔGHå¤&Ì’ŒëØ<KãbÔ¸¸@$–:Ê¥%Åë²²£üíTt$9Ä£«aUİ>|§b1øğ1)Îx±Ÿñ Ø«íêÓ=»O­Â“mV±PÀ/©bsŞòÁ£2B¸n¡„ğI1~ü¥cãGûñw)ßm{¹›ºC•dB‡]ŠÅè@¿g àï@{û_é×?ÿ†ZtÀ}5¹y,¦yÚ},>£3<ÓDPAuÄ–dºÕÄß¨|ò4+„„<EÜº=Ì}©Çß¬XL>|Lô™;˜gòÚ×=€öÎ?«5½©‡V;°`ƒ‹íS#.,&ÛWÍÌô&Ÿèè *$¨wà–¦Oüâ±ñ£Ò8~‹"ğÃ›ÕhÂÄbô[‹Ù‡oRªNzù§	ÿªN<õE7Åıòæéé4Ûº©»ÉÁ<›_1Û¢şp¿/Q_G®õóÇi±„İ`Á>—§‰(û¬¯±†ã»qæèÄˆ¹†PÂƒëm-Ôuú(_\›©äa¦±†±›ó­±«gØRÒ*ÚÖÜ¹“i–¼Œ)äk»Õß¶æ·(Yˆ´­ùª‘i´\7SÉc|mÇ‘=¢mëåCl^ô	\o“V›x6ƒ=ş¶­¡mlŞ|”è’LÖ`µÚ}Zx˜Mãéw<Ù+ÚîÓÆìZÔjóµ½×ßv¯%KP¢K2õN†6C»¡ç@qµi¹O´u¥Œ¦šwcÌı1µûxã"$/2ëJ9MÕ¢Ôö2Íº²‰¦>Æu'ôU/ı_ ëİøwî¹ÊàpM½Ï
ş{.‰dpx-MˆBgÓÔ»¹îD8ÍU'svî=/P*Ã–3ëŸùåšo"D íóJe
;P”ÊO–1ë+\wRÉ	(·¼sïRàÒ1k1¦»T^P
>Dáz¥ º‚ëN*9%ÃˆÃ3óæ¶Ç¹‰p?P,!«İÜÀÜ¸[±íá—éıŠÅru¡šî¿ù±J7?V“!"İçÓ%İùl¦Wï|l{òèØkÆ|ßš1Ær•V˜›Q–½!-3w]!9 <,]Ú];YâÅJóÀÔZÜ2wm¿W¿Óû…>üİ¸e>´EÚ°û'ìêk©vô\Û©äO%ïT=FïïZà#3?÷Ş ƒ>ÆªØÅå58İ
’ñæ ªmúIçrü€äeÄû¶²‹1Ü¬j?„‹‘ë|ªıZ¸«¯¤ DõN=Äâ¥×²0íÑiJ¾éï^”/eÂl	7+¤—†sX˜™ë|*¹ûUïÔŞ` ˆCå÷³ÄcÈOO\¤q0~‘z%{Q‚bht/×Øà[-<~æBáÏÃç»Heæg§­ÉÍ(.Qoı2ò×åeç—6A1)çWl}g©yZL'.•X$Ú8…oåœt…QØİI'Í>ÍõKTrÂ£ÈmF]ø5©iäô±‰[ÈJÒw›)äÚ‡e•#M)ÎÅÕÃœâvMÛ„³t­£cQšL'÷×ÄéxhÈùİY—µ\ÍºøZÃ,$ß;¬ä„«É÷Êi•ïc¬*7V—ç?é™ÅÖvòàKÔòº–ïGÆ•T?õÕıÿó²Æø¯îÑ‹é÷
Ks‹ÃOÚ¹y*BÕ"Ğ¢®ä³@ş»«ù"Û•œÈ°GÖ¾AV¶˜I:a/¼n¸|ãç‘Z ¾ú{Ş_èKègïìIOÔ±³°Ø’t9§,ršdÅ5(zİ‘×ŸS¶CÉ¹WíÀõIq“¾~‰Í8uÄLtÙ±ôlFı_Ñ—Aj†òœ²¨ÿ—d?#§ìŞ…Íô¿Ôá®CívÇ:Œ“ÔäÈõq$0M?#õ–,ƒNo…6s‡4¼@šß„‘t*gmwNÙ£êvÍÌDSYw”‰g0'>9ÚdøÀ´u•qRC(Êwóİ›Ğv¯Æt>ªähÔí¡U¾¿˜U÷çÇİ÷ñÛÏ_2İtÖXÛj:uÙJ£Ô õUŸélà}ÆÓìÓˆÆÆÄÇª„Q±xıªoRää®Ë\Ÿ½ÏiŸÄŒ9†¨ùJ>nyÒô·„h4›ëQLÂP,±í7N>Š/×ñöÄR±èã$Øğ>¯¡¿½…û¤SÉŸJŞøry×øá£Êÿ   ÿÿ¬{l×ÆÇƒ½´i £Z­\ˆbH§öâ)Ù¹¶—Wx$”:,1¦°
N¨"‚
ëcTE1İ†ˆ $ÛáaØ@ Ã5ˆ¼‚yˆ
—XÈUŠœ> ô;÷ÎîÜİYlÉ˜sf~÷›;çœ™½›ó”í‹3!õh±Ï¢™­YˆU@DÁTXÕ#@¬'0ıÛ m¼Õ’rVÎTæ¨{œişj¤Y$ûjmÈ¬xl|µ>«ö7dWs%P½Ó7ZÔíÊ5Ä»ãEæ\J æ÷gjï"lƒ­ ñşö!²«¹l•åcBIt$/“:¯—^ÂxC,iİà?¡ß”Š1î®{™cu\î{î¸bÿó	í"ıŸ|h>®—ã|øên*Ûy±ùg·+ÛaO¯ş+[óÆØFLQ¼yhÎÛ¿jĞµ†AL9’A»wßÌ˜ëq¥ĞÙ5Wµş¯k}N?Ú4ÿÀ•cWhèÔÀò»YYÙòºÑ^Ÿ;Gşï6D¼#ƒ.1pºáxwĞSXh·¿wmòšm–²éisäÿŠûˆ‘ö6Ù;¹¦2”xC‰.à®„šJ¦PAíºÒ|”ù·ı¦ğµ‚7‹ggÚvKt¬ßt•İ\“ghÚËfrêN†ºÿúu·ÇùÆ‹ldJË!-şHİõî-,yÑ2®¹†6¶hrFm‚´ğª¡‰Óî£¨K›¢©;Ò®îD¼£ƒèƒÀÏÇÙÔİ¡¨[Y|•u¬ÉÅ`§âVlìÉ¸Å'›D˜Â{Gİ–èÈ]³’µñ
®iLu1w]}Jú*'fíÎ8ß(¡kxİ|çÚhÖ¹é1ÌÚ;<7£Šù“^qiÚQ]9†¨›}´ş”åÆmÎÚ;˜µñû¯ŒÅ–†9iËé‰4”õ3§)«²jx-ñÇ;Ê†­dOÌø3ñËºYhÌÎm[¸¾¦{¬Å^æ€ÓršÈËÆ‘ı'ŒçJ0ş]jhx«Ñë£ÎÙÁ!3l-ö]•è(ûÎË¬- &Õ4EÔ>·£¯Å¾+ÎçŒ¢jYÓÃl{æ;†æ×=[ßcmx™¦íÔ•ƒU±÷(İ¶„¯ÅåÌÏTŸÕU?¡Ä;:\ù¬øÇƒpœiRÕ@7ò‰¥ª«ãi8uĞ(Á;ü°çRÀK\	æ½Òì&¨DGÊ[[ÙÚÖ;€š©¨êJ.É
iò°Jıp ¦êî8Ÿ;Š¨)—ılí3mLó÷iLIibMÙÑâmÔ•cQ“µ¬(¢bKDQ@uñ#Ã&meEÎ»Ä*êKÔô´Û[XÑcäô
OËBÀ4²½<-	¶“ì™½#ê^‚JtKÙ”õKST‘]©‚$jYQk×Ş8ß!mxv]õz»ñQ×$¦5<ÙøÑªØ”±÷†r$N»’]iSäìê|60aƒµ«ïğ`™b“Ğ:)ùµ«N×3²e¦ÁNæ}°—‘ıWâ{)»ÖX¢cù#ƒs–¯»3vaºŞïw_e¹=Ùšt³¸”7%²!¨óÍ¢†§Öå®‡s÷çš¦óå×2sîŒHÁN›å º¹{5µ†ö£éÁŒêtšRfXíóœE¿ıÚÜú±åÙsµ}4€xÇã>–4f®
9g/è÷3°¢Ş>EÖ«à”'¿ÑoKzìr®¶Ô ç#ˆ+êEıUêî— ÜoGËEÛ	MË³Ğ´-—Ë%&ĞGkM»G; Ñ*ı,mÂd©ZB©áó¥îu±œä…­Ò¯çàÙ*‹a{ÉÆ#üBØ2Z°™ÑŞlwœëÑgûÔÎ–'^s7÷¶O#±idÓr¹5²¼0¶!ÎvP²Õ'³Ô¸)t;¨°ÕwùYê×¤U¯ˆˆğ—s%:Œ­º²³Ùu;‰ºÙ ›ÅÖ«º–lÙ¬èÕ‚ nÍM_êkûi8§‡¶ì|xåÃó-ûì¥d—s%ZèfF‹ùÖÇ:§ôîq×ÿb~÷¸Á(å3Ä†Hˆ/ˆù,D)Ÿ-{òíŠ#®õD.ólƒ²®×æ¦‹ú÷şriîˆ×Z
¯ğ‚~­ıó˜ç Ùå\‰6õÑ"—ØôsÅ®ßQ;b@?q „ı‚ˆĞÏBÌCì‰~\Â%d·å»qÆ—×_ÄÓ+®À%ÜÆÒ“×mÂDxÉ.çJ´€óùD´X©VÑ/´–İÇ÷,ípR9s÷€kŒå‚pPÎ‚“Ê™Ñ®'Ê“pV‰ôç»ŠñØO”!œÕc
[°¾j.W°¾j]J0î³J^ª¯ÇíhMùºŠv<"Ú)İBkÑ-´&½ëë	‰6ú›4ÖY‹ÙƒŸfÓq½š'§ô„Â6º^›Èë–>:{ë<Bv—®D63ºÇ§ô3	W´ÅÏ¼ÓéP·óu©ïÿ¡±m2İg
\Q	¼òÈë–^tö<²»t%ZÀi2ºÇ™î¤„+YVÅ2¯?)+NjíjwÍIkXÉl?‡íÈq%ë`ÿ“ìr¼Û
[Æqy>WÏ¢Oâ”6êCÉ½ĞúĞ}ÇtÊÎ%›9â:‰}\}œ5Ü.¥‡#®ª˜¹>—\Ş÷÷0mÎ¤^˜iÍM~İµ£e¡³æs‹.İû&¼^‚TóÖÁ^Bv9W¢íuºC:9"Ü3a“P¦7ó lŠDˆô$Dz³óÂ‡„Öş#16KBO\«L„"ÁêĞ°Y!ô´ïe•ÿNÅ+Ü3ßGº:%:ŒPéêHÃØÏr‹Ğ®aK$Bh$„†a·6Æ¬a«$ì<s•m&833¹»qïiœåV…°³^Âó°ókØ‡È.çJ´ĞĞŒó°u–c®°§ípR>s÷€;	òá Ÿ'å3£\O*ì	W™µÿ-]Q®Ü=ğQ'Jì®r$¼ÎÂÊU.…}‹lÜ‹åÃ–Ñ¦r"ÚŞÛÅ¬ÜY;\@9±{Àå‚pPÎZ@9-àz¢Ü9	G¹¡í„3¨\sÓ5]vuç8Ê}muğ‚r”YÚÚÈ–¹ÏŒÊ™Ñ¢Ê*s®Û¶«â>z»óvD©Ÿy4ç#!B¿ "ô³(õ3£¢¢!îñ‰hU(ÙáQeûÂ‚³*.š;«²mt)qfsVqCg]÷µö‚H6vDt!"Ñ)İ"jÑ-¢@O'‰”Z+Q›$jŸ½—9™†–ITÙÀLk³¸ÒÛuxõ'¯[zûïa%»KW¢uêM¢œÆP¶û˜c%\Òö=,IG1¢f-SßRıÌ{nL±‹
[Ò»pú)9İÒ“Z`O%»KW‚ø(Ú>Åbf»$ÙÊşPÊøßÇ@¸]ùÜøæ½QsIA+û5|®ÂÇ¿‹—UÃ¾Kv-WbqîÆç|Ü'Vo"ZQè~’]–d›ÿ‘ÕÿgdÙe…lódøÜ„È6¯í…ò_Ë•XN¯àSP#@¦”üPÑº'»"ÉøÄUÌ;	h¡š]QÈøOàó<|@ÆÂ. »–+±ÜNöëÿ   ÿÿ¬}lÇÆ×ç8±MpRl¥QCu|ô#¦Š²@¢(n}»csM"šB[œZ“À))­UZªºiÏ4›€”úpï¨m£ğé,ƒI‹]5C“¨ä‚hª\«‚	_I0.€ãĞgfövßÛ;Ë¶Öÿ½’ßgïwÏÌ¾3;3¾l”%8çë90†®vD¡eôla†xĞ´L5rDĞ2‹?!â.N´h¤Şæ›6´£
­§jëì«Wí‰S­ê×²s[Yç!¤€¬g6ÒÏ‹¸‹©"ÃEsòPI½Ö«ÀŞşëùWƒ¬—€-,GÊ~¤ lañqwq"- óÑÏú˜õÀvVó«¬€Y_AÊj¤ ÌZ…¸MÄ]ørÄJZ V:Ò­9†¶<¦È‚+7³`s£—ì!6 e9R@´·Š¸‹i™Ÿ^Ö¯È*wmbı;Ã¨Xˆ#õ¬Ÿ UÆ‘ó{äh›xå!Ä{EœäD«Ğb2E73C%õe>L;®Ğ"ñí,¾W´ĞÜà8!‹ü);‘²È.Ä¯‰8É‰”ËªAn ?Íù®"ë_÷«y|>LkËŞ%hı g)r´8ïß†ø"nãD«Ğˆi3G2môR{B‘…°õÿÌ( ;AÈÂß@N9 o@ü´ˆÛ8Ñ‘›SLÎÒÉÙè|'Ÿşöv¬
‰FÚ€-$¼’Bµ“O)]H‰màú âÃ"^Ï‰Tá‘6õaÜ)ØÌ²Æ-§å"`Á4Rv `ÁÉ[Xö€ˆ×s"- óøöê¸};­ğâ¿È²o ºk±WoŒá©Ó.ÜŒøıHèAB,†yâÿ Ö~Í‰IáçpÜd)|½%Ï(¢ºÏm±K!:Cˆê®¢ˆ-Åxİ½HnE""œ ¢÷‘e¶³–ßƒ"KˆŞ#DÖL$@<²E|1ˆˆp‚ˆŞWDú ÅvüÚjï"ım$<éÕO³Ï"NÑŠ¨æ5‹Y“ğ!±üÊõ5»f'r†êàcœ×œB|òµ6N´ªŸOLå:«Èj;â¬åV1³Ê';KÈjŸEN9rP¹jßD|»ˆÛ8Ñ‘;p¼=}@‘Eoig‘GEWÉ+,šİÈ"‹‚Ò‡ôŸˆx='R615ëÀ—UÜù‹W´S×9›k]lÚ7#£ÀÒBñz®İ‰X)°|øuX8V›~ê7ìlû×1%q6dMõsÅã„—¤ïM·áZcÓf§W ¯y¼Ó;oq?÷ŠXé9QË'8?ÓŠ^óÊv¶e«h§¿:s®VxóR¼æäµ#xÍâ.'9Ñs¢–k@¥î ^l˜Ã„ñ‚€¬¨|şÍ$ë>%üx„
ã&fX#ºPıš<ÏRxHè¾ÿŞÃº÷ÎlĞêk<ÿÕ4ë¾%‚;|¹I>‰‹ËpHHü©è!¡¹º>Ï>+èº(¾DYe¾Dü£#äºHœnéH²wÄ—]Š@œñ¼±ÒOĞ!¡AÖôÅJf]aøïhÌßÄ†QÜ\ı·ÍØ0$XM'+˜õ?da­i%·]Åéµ'jÜ=Ïà1^ªå†‘qõ#/[£‡í£blØqØ°;ã²5°ùX5º¤Ø~ë˜ÙÙ7 |Ãª‘®¿dş¸ôX<½DØî3;÷!¾<Å5'8QK6[-oU'ëeS“öÕÁ–-Æ†…I‡“.Ûü¶îM=ŞäcÅ¶çÉ£fóOÏñícÂ¶gøˆÙüdÁ·=ÃPlq‚u›ß.{Ù¼¾].Æß6øæ²M¨oWÛ”Ew°à‹‡ˆo	Sœ²éN]!lSª‘e!¾MI ş‡ˆœ¨mß¤Zş³``¤6C‰¾ê…Ë'/ÿd¼ZÆ9p0Î…Ë'Õ¬„çw¸1À)¸–/ÌbÁÏÃ{P×7šIm*Ük9QË‚Ão¡ª%yË
(ê À QÛÎIµ¬p~œûÄ—sN^pŸƒƒsœsárÎIµ„óãÜ°‚3z°ì†Šå8÷JhUª[kÃÎø9²ö!}Î¸Œøšˆœ¨mç¤Zn­ùqîS/\Î9yyÀ}ZÎ9ppÎ…Ë9'ÕÎs×œ;ö`ßEÃã"šõsFUì¾¸#×õD­v_bR-›ÕÇ¨ªä»Ü«cÆe[}÷ª@½ójSíŸ†‹ö–AÄ¶ò|ƒjI@¢U]jd™jt±Û!UÙ*hÓÂVõdb@Ğ.Usç³Œ.Yƒ¨Á¦ëRí»M	·Àè3³oˆÂ>‘ğíï/›ß~¨ı‡sR·`¯™}Yd]4ì‡âŒˆ³QNSêÈœ¿j”$œ•:o¤—LÃ4V,â(WƒY1T\JØ¬Ô€‘#	wª•º`¤1Î×¸b.Ù4©–˜ô71_7îU›ë¼€˜Ë‰,ù ¼® ¦r ¦rî·k, $½N ¾4nÀ28}ww(“ù’r}/]c¾³û.–Âé»w…2¯#Nß½/”9-â'jIh«¥…db"g›ğz/¡ªxög€ğúb„¨x!*K8¿€pÆHS€Ñ—ÀnPl‹—İŠŞõåù‘çŞ„mñ²Y¡èdÁ½ÅËîE'8Q°yÜk·{å^B¯{åÅáC÷\Â	u¯B±­í]ÊÃ¿ı,qïA{rWAØÖö.ãá'‘÷Öö>ŒßEq‚µíTË¾©eÇ0ªôÂåŒ“—G·«,ã8çÂåŒ“j	çg ¤à:¦~Ÿg—ÜJœk4ïnx:“\ÇÔ&#ÎuLıÏ>&â'jÛ9©–a~œ»Ñ—sN^p7ƒƒsœsárÎIµ„óãÜd'ê¶æ3sºş;ó¯÷}Í:™À‰z§­@œÕD{JÄªŞÙjéœ­–ÍêÇ¹*/œrÎ¾<àªŠÁÁ9Î¹_M9g«%œçnRpîh„ÉÊn"lÎX«Õ×»CÙˆsuLÍíŠµù;£—á›ÿ  ÿÿ¬PT×Ç/‰€ÄQYQü²€`v—¢èî»Üú?¢FÒ èRÛ4U>4T-»(¥™A;j¤blj‡5Ö­–±­,w‰b%£é8jÊôcì3É¤-“:Qû¿ï=v/,Xa‘™3¾sîı½sî½ï¾÷Î7`€½ˆ6nP4¤ØômRlüÛ€›ÒÀm€p•.Úx‚Öõá[¶ÎdŒÿŞ®o¼Ø.ı¸ÒÖ©çZ_I]ÖÙ:Í\î…ì·–8ÛÓ
é÷`ô¯mì¿¸”s8¾·sî¢ígc¼MàŒn¶±r­¯¤£/ÛX$._¤²ßZâpDµy¼Åè¸£çÕ/ÀLEÎHßË_êÈÎ†Ê¨àùÑÙ>ªÿ6—=L0Å4½Hû>Cm!e?èU0×ÄÔn{n ˜^ sy—Ú³ 0×¨¿ÄeL™øVšƒ	Wüáµ‰*Xó©ëtw\ÀSY›(€5'B¥* kNì »¿á²‡	¦A`Â#íş`Op1UÉ"NÑêÏáƒşd±YCm­ş* k¨…ú\ö0Á4ˆ,”%w’J¶e‰®*|V¦3Í5I@Û2ÏHW-…Ğ¶Ì3ÓU¯sÙÃ[ÍÙHñl>Ôl®É*Y‡ÅEã·…‘MÈ:Zœ4~t@ÖÑıJ.{˜`Ë”q&…0ÎâT²‡kfÒß…‘Å	d×¤Ñ ²‡kÒiO'—=L°"e MQÑ2¼I/İ AhS´Œ»è¥ËĞZÆJzéO\ö0Á6-”‘6UE;ıÍKÇ¯Éü^UK| î©ÙØÆƒ4/
*xá4¶ê‹¹|˜	¦*^Wõ´PŞ‡MSÉFYR©½šÇdş9ÀÜÓ´Q–j¯€ĞFYÒ¨ı—3ÁVEÓFÃRJ<§«hëUÑêÓğ|ï„KÚtlı±ÑêıPÁ+á³K´šq¹	¦*™à´Cİüÿ-Çó*XFI&íõÂ+Î~`Ï`%shïE¨ ,£$‹öŞær=LƒÀB˜œñ*XG¬öTòàà°?˜Ô/uÄ&ÓmĞÁ[áØÚó6—k™`«’iÁ¤f.KPÉzíå´»s'Ød	Y¯½Œvï„Èzí´û§\®ÅmŒß6ˆ,Ÿ%ªdg'ÓîR,êÄù*Ó²,TIg'ÑîÍ8$³…q´{d$ivùÜ.äÌš$•çşİRmğ$	<÷ïîĞV0'»·L]ÁÀ#Ø=:e+Vuã-,‹U5À3Cà©ZŒãëpş©ZÜHwA`÷tx’UkcnPÓUì\„x%<×uPÓ¯p<×A÷cÈàìAåio½AWeF\¤ÙíV¨$@‹A»õt••ËõL0eÊ•úé¬R)*Ø¹ÔÓ´z‚Á“}ËgŠ vîÌ{´:* ;wê&.×3Á4,„—ª‚í­j¤»ïğú¯R©ÙŞG'èîëĞÁZ°÷ôïq¹–	¶*ÙÓY¥ÒT²†ÉítÇßypú“¥	dG}tÇgĞYÃQèÿ‡ËµL°"Ág3U²+¾[Tß<£Œ§­(y1,<m¥Å=S »"Cï8ôp©¾"ß¦úË\>Ì{5«Fµ9«&]Å;/ yÇyˆ8Ï‹ID`8Å.ào{—æ„ğÎ·Á¦™Ë‡™`¯dÕhÖÊƒŸg†º^?Á-HÇ‹ŒŠûE=ÍXË=Ñ/Ÿ†—¾y†lú¢`\†Î‘>D>ÍGìåÅ”y>MtLœQÜT³zR‹îLÊª`\„w‚q–LK_ÍJ>Í,~áQœD¼rş|ø[Aİ™%øØROãóùÉ¾Â)?¡ñ[¹¼	öj>jıÚÈÆ½ÀÁ"£Æù[`+ÃØ<„ª•ï”Ï±M9R£Ö`m-æ5XíJ>sÜ¥’é:G¼âU;siÿ¨ËN÷ÛiúƒÉ¾G>!_²±lÁ§UO´	=0­ı­([)ãÅ"/hvuM*¯r§Õ13ôUİÉR“P””h+ûÊ˜ÎVÁOÒ¸üØû1˜®% ÿ­~ŸíKã&¼V)¤‚«Åcgë«‡À>y!:ÌŞshç;yËÿËIk$œ‚WhŸi­Û„=G‡+r¤µ8b?«™ºYìß'y¤šGÏ® :T•ÂPwõ"½÷Ù„……Óö(î£sŒV¸µ¡Œ_
.ò!Ÿnlê«9´$ŸXÇùÊ¶K5î7ÑèxZLü0­yÎ-ÁİÖAª„:<×O®İK„æLå4¢÷­–÷4b‹Gvã4Œ‹K{Ş_¡Õj"Äj%$Z78ÔËÔ9Æ(§Í\Ú?êŠ¦û£iz¢”)}ü™KlÛ)ïù>VdÒÕ&tÀ´æ‡qY9ÆÇ†™déğÙ’ğå	Q/ÉÊ}
)ßÈtÇã6í î¬À„Lj¸¾RVoR*XƒºÊMJn@>ÍoXÊ©bWL­(Z0ÈOš¦õ+ƒ·İ¡í¬Ülb².c0aÈúª)CRhqÎ2çA™Ã#mZ›áÜÎº#óû×¤sDÜÉq±RSu"ò±ì$m2˜ wµ:ApÆÇw.1ã4Ö…G6áAÆÛ3Ña ²fÍ«H°MlJÅí?\ÁH‹ãrd¿ÙÈk4f“l„¯HŒ!{dÃ,§èì\bÏË‘Q©ß.;~V —ğÀ.Ã¬½öç6¥Dqğ¬µè‘CvùšSÇGÈHÆ¬Mm¶Ê7V Ñ®6¡¦5¿Õfò¤‹1°ljìââc!sqJ}â–¿Æ«¿âQf­ÃaŞ!¹çj~E~rRËie˜*XËŒYÿC.—1ÁÁ…]±4¼Yk4æ’P`Ö
maå@[`È!Ã°ƒ›ë/‰l!¹œ'2j£á=YúÇ4œ3îB÷	n®Î_`¢®¶3¬ÇøÇ—äÕïÈR¬ùØÆö²Ôb€ÜÕ&tÀ´æ‡\S "ù ÁÍ&/â4”àæm>‚5ÓÑ'Ÿ¸ªc_›'áø)~¼‚åíƒìårìF\“‰Ì‚+´åî¼27¸ Ğ”•MæƒGñJÑoö3½‘o–‚¨³®ªùQQö[LŸÄ/cEÙĞ•¸¼„	vğ
ì†{¡2šÌ$ğŠĞ–Ÿ!o„ÃöŠÙ?äsÈ•§³n¦ìpl‘‰xUòl§îLçR~°GI7¹üÈÑ’`”/5mçÈ’­Ïñíhğ¯‘û¾ª ~$c»ÃbÎÕjA’mo”o-İT\¾mçÖ×Êw’…ù:éÑŠDokšìZ)]Í‘ğ5¤…º‚Ew”]kX~í¼ğfL±7ïÙKH¦÷ëÊm¶ÓÇl6ÈøK %ËÛS€!İ{–l6íƒd´HÈJÈ9ÒëÄW¶*Ìƒ=sß5Wò‚ÕÓÊK·•”à‹"e[I?F«à_­­ár·óæ¹(¹­šƒpô:Ãe×§Ìå¼êzVv}ÂœÎ…\³šM%<8ùWqlèw}¸óıé~>!m‡Åm{ş†¢g§óª:èÅ¾!\Ó”‹,è<”o¾Hè_}[‹Jå¶¿¤ûªèJâ–ı·&”ÊŞ„Ÿó¡ÔÚ±)İç£}Úß£Ö!ÇfÚ€M”ÅlÉVnT²EêM„ê¸Û#3ëdSÌz!ã6JºãNaÂRUIY„ûÇáğj~8Z"+!ßZU½D2!ÇğÿG³"
wx„æšµıåÀ*÷Ğ:ÙµÁwÕÊG¨¬+°÷¡•–zK»7y1*½-úµ6|m™øK ËF’k®‚rœ4ó`½L2×BŞZëu2!||²Êÿ  ÿÿ¬]pUÅ¾÷šŸˆ$Z
ŒÚN´ZDÁ@‚%7»7 B"‰€ ¾÷HŞK	/¼–ŸİüLZ¡‰ÚR°à_ÓÓ)Õî¾½	HKgj¥À(Œ3Å¶êàÔŠeœ¦g÷Ş÷òòG`fçÍæŞ»ç|çìsvÏŞÜõ­¯NSò@UË’ÈFÌÈ£Ö§Ğ³(º²¿öj/àò´Àr9éıµ×¦=˜‡™w—Eò¸©'¦>Êbä$v(ÒSèõ¤G¿ùŞ{±ydíÓÓ™­Ü6ÊÓœ‘«å<J¸mÁA¤(ÍÑÉ)@0õ9ö‚Ç­$ÜŞë¶Ælên‹™İÄéÎ0yH~Š‰MÙu9„ı°@lÒ”ÕõUÏuÈPæjŠ²,‰z1Ç·ŸDè&:Y.Ö–ì³0·¡ôÁı¹Z`’¡÷ÿ#5]À¤„3}œEÚ¹	¾‰‘=˜2lê®“hæÂy%NÄ-å­'ÙNÚhâ$_€·É¶œCÎgà;3Éw©¤Q¦ã9=ƒ¨Óosú!²%ŸC;å‡ùe›ëÈ”ÌÓÀœ“˜º[ó´À´õG_ÆÔÍi;§/tªAFík×ã„zÎ)˜/0Ç;tû«o~Œú@¬Í˜œAŒ@m+&"§ÙSà F~äœmmïæ \ æ ÀÆ˜íßgĞ=9ÄÙTWyl(É 6yW×µÀÈ·È£#ğa;Ş¡Ûrºï|ØÑ!øróü#³-òWÄÒNt¶Ã‘Ø€’Oß a¸PÂ¡¥íâ{“q\úw÷›UáÖ…18ÌÀÑÅÉhğ3¥Píäôfl7iŠ4ñ„õïë	_E¨t}I­'à[ë©©òUV*‹ ÂÒxf.”ŞBbF±(†=Y<»8=‚È"¨urò{ä<İô: xâˆ9WúBe~¥ 8/‹§÷4	á³°-|A÷°y·‘‹@t¦Ãc.$$‡J’Ëç¯CòB›ÿvL§X{ïÀqÍÿÂş&y
3}ŠEnÇ&Ù™9Ù¢ßÁT6iŠ4¹H¤0ÌÈDkïd'e‚ğˆƒ|¡†æD‹ŞÉÃa¦Cm
vZ4EZ\„ÅBy³´«å”0é£?ä´w6`ÒıfŠjç]¯ÈÄ, ‰¿ÅZ`…´á+œ:Ó+¸é
&ÿ³CÔ"âÌ\nĞ1aú-Ã!ìz9tıH\öÏßÛ?Îèù:{$U\dãıÄ>.âöûÉ‡Dêä¤<DÜn—xí¸]¤â%ŞvéŸÅ/¦í¸±›f‘%Oƒ¼ş®#F.bb†°íĞõÃTŞ­„í«')•bMÄ“x8ÓŸâ-'PÂ;Ÿİ—û»Oääv§¨öi;$z{’T¬î”èwpêLwàÆà¾áÌ;Ú¢Ó9 ²K7ÉQ¥6e×	äöç6U@ß3§G§J}?
ˆİñ…iR1øŞÏÑ«Í8_k}Ô¡à*Ü£9ù4x™Óœ^Bp‰‘¼ést yĞ,jäÖª`©¿R.s¢SïéÊ`Ñ’íáfÜºd$L¯eÆ?=º U–)øiè«1.,íA`Ê)ŞKÊı§c,!·ıô5Ë=CY|An›ÃuÙˆ¸^‹à3"‚g(€¥ñ‘¥“\h=Ã?VWW[h’1¿J_g+ËË$“¬2Ø¥v«å=Û½=®µ Åx!Ûªm/´\dK»öÌ©øÅ«e°Sg-²‘›i{–Úh‘Á0lÚ®÷¤#ÒÂ°‡íˆìÙB‰Æ
Mš²^n°´F«¥%Lş[QîÎ[pøãî©™ãº„Äò6äÆÏ
-à•/…©SŒ˜&0–ùÓŸµÈSa¦7tµE¦`Ó!ì*DİÏ?Ô¢'cê€™¹Ç5‰ùTƒÁv·"îçÈØéö&›í~ÒÚv?kÙsºEbĞt£1İ0ÍCØ|>¥Ó„eƒY}Ö0Ï{,SÏ7L‡¸ã€vî„Ş¸û{ Îg\iƒön7XµZ”p!a‡¾¡ôí=¢èté1#Š^©|6hNÓí‚i:nL¿ˆ´@– lz_¥/±ˆ›i—Ê~=ê4‡¡ê·.Ğ¤ª½aƒ‘õ½õ-úø¥³z†‡½›	¨!ª>¡VIÌùœ:Ã&lc>„×æİm‘	Ü$g³a‘'sXÌİ5ó€kb‹ÊxR¾@ˆu8·z„İ«^•À‚|?± ¯$æ ^QËÇŞ!Äz9r+r‹ÌÕ»s¿çäUàX³²ŠµÊ8ªÔ³z}Uµ'rn©×æ6³ó™Öı¼W0„ƒHqÃ”$Ë¢›ÉÇl¦Eë±¦l)”˜÷8Ä¿µ%÷9]àn‚_*ªát—ò`°Ö·ªÒ¯*B~Ågc˜‹ÁƒaVÃCQöÃƒa¨1†U6†ôX«b0<Å05ŠÁ~x ½;ah”h²Ïã1#5z6c±(‰÷BXtDÔj±èûy  ÏÛ©Å˜¾)†Òe1Jû`D1”G1”á„ÁßƒaEË£bXq£0 ÃÒ$FBdµ|…¬»£¹mÖ³;ç(J»ôuöÜ6 ’¥×hç2Â/DÁÛæ%)…(ø²ÁÈ/9ùzO’v}…Ê"¢áÏnĞÕ9;àR4áó˜÷¤Au¶ıÄ0“eZ`®âQh6]ÀäÃ$¹IÚ¹éUóÀıaÓL¹$ˆ0"û4ÒÄÔÌ¬ıSåx¼¼åLß´@¹3Ä\WŞ…Œœ†¹.Ô¦2r9í’Ï3+Ğ{*ÔÿÜÇŠyZátºXyî†
Í=ïeSUUC¥¯1ú	£©aúZ.ı$·>é:#é}Ÿ“wÖ,ƒş–Ó©Ø¦Ğ6ëq†Z¬ö6ÊïF6ªÖWÖVTWŠ]†ˆZVƒ6`a>Ó 'ø±T ĞºZ(@õ¨¦™Cé')ØÔgBõ8§·`*ŸlK$Lp¼°¢/K(k„œF!Ö±]vWÖhîù1‚‚”P	ƒ”PêŸA¹:9ëV®I1F6YôV{1L¬¶]hd‚f(•RĞ—´RJêF¼D¹êöBÄKŠ2rLĞ¥jVp'lÄt²óÌ;Vd€¤Uš{AŒ¤7CR‡Óâ0…ÔÎÍ¸¾ºÔÜ?¦Ó¬>g’<˜lı×2OAİõxI§­È™¼™ÊZ)/Õ:éIFëZ).tlªÖi~ıNi.6ÌKj§é:™Çô"Ã~V°J(ÆÒµ™Jp¹fêÖ#ü¬ş/áÌZ‡iPkİêªS#w¸sÇõÔå}ÆçmkAOu¥ol‚•ú}µåU¾Ú’r¥ZˆBszœÿ<AÆâ¶jb£
×âóo>ûÈ@á*R‘
9†Ä—‹'"íØd¹µ¶M9®$À_0ää×&O¹?\B%~O]0XZé[[ªØ»Õâ¢²ÎfŠxÿìk¤efV®Ãmël†EyK!àrœcz_U¾Ğš¾Ë`Ç¯fÕ&%,a_öò+Ï£#Gkğ?Ÿ[º¹·ªk­!‰Så/¿²n…àVºüÊ‹P¯…ú
¨G›T!=¹HÍë3%ÓÛk„ıQ3LwXÇÂào¨ÑÜce\˜BIeŸƒRŸš›«3}—E÷ÁnL˜™Í}ÛÚ‚Ÿq•ë½=Mz?OãHê‘*öÔøk×W{jÊƒuşR+„×F}™ºÏğÿ9ˆ•êÖ\Wé| å?Dkµ¿ouÙ»0°Åé”Øj¼—ä¸ÔÍú—§~íª İ¯ù—…‚Æ:¨ÿŠÇĞÃ6½}H/Ñ'½P<qÑMHİ– v_·(Í‰Æ¸:¿¯:¸ÖùÊÊBşµ¾R¿²A ‹•X÷”AÓòÆ_nÛÆİJşÜŸn€NA÷=
ãí	õ®Äº‹(cÜ¯{ƒ'Öıe<-êmP¶«â1}³PiHU»³&%nSŠë>]T'»È‹ášİ‡nïÇQ§¹‰é£p˜î7éØ0#º_¯.’~ƒÈ*Îòïè¢/a²„³	·wÁö	øHèqH]ÒÇØîé×E¾ÚZ_ÉxSÇ3­²Å•Á`HÙÁr”;X6jîÅCcaQ,oG±åƒa¹wXX6‰ŞHI|õ##3s
¯ÔaÒÚ¶	ìrƒ:Ê¹W”¼9¯v C•É;:z>t–‘t[·èì­Bã÷ÛÆ	o¤Vmò«Á8ƒÜÅßš¬lé¦ËßlåIÉsTÀı¡‘ùf2VàÿôÃğÁÜ'®Îu›k"¾:×ÉCq–á°ı¡d›p7À{_ d‹úÃSûªÍ´·¨0 G*ê‡çfà¹,¥¾Íğa!áf`¶Q…?…&biæRıyÜ3”`ÙÊIşØ x/É…´ZÛÉ.ÅuàSİİy?€$c¬ûó™4xÑFxòle«3néyv,UÌ2¶jî¢!‡m½+œk‚ÑCŒîF`?Ğ¼-UN1òÕùi½}Üøşƒ¶Â³•m"ğ3òƒ±Í{›æ.á-l—óİ¯Ó±¸~,Ä}fî0ê;n2}§AÃ˜ì†9¤ Ù÷”cû±& Ş¥)ñiMÆ‹ıá•¹‡}¸€‚ëÔ$û"~WªØ7Ä½oHO•ãŞ2¥RÇÿ  ÿÿ¬]	pUÕ>ïf$H°¢²Xe+Òvd	YÊÜÜ{Ş#""›`‘$ l)¨ˆrïƒ˜…]-k$›l­ÔÜ÷Î—Ç:ŠéLA‹…bÖí¤ß9çŞ÷^ $Å™ÌğsŞ=çûÏöïÿÏ}I¥n.²ûi*G[ösšßîç4ıÌTq†x‡ëã*İÜ¢ó1ÕE'©ëÆ1î}CGùôÛ‹şy(.nÈ@wÓ™ø ¹ºû!66NÉÏbvfV\]çÛkôéÛtI‚
FTØkğxÁnüVØg`_İ­3^qf¦š§Ş6Ú5Êå$¦z6)Ì/r¹ùßmwİn£2­@V*„Œ¿mc/wÓ˜ïš—
’“?¬´0>ı¶™xfæyüMsØ]¸ı«P<y½O98§„íÁ*1úOèFLÀfæUŠgrØğÏóÛ§Ä<Í9%Œ~ºeÄø1a¬…ç„h$7·ïœx{cdRg¶;/()aî¸ñı<±êİº+W½e$¢Â#Ç–… Ø2„Cv;·æQ	÷È|–‹ñ)Q<…2Æ3Ÿñ÷È¯Ãr\â}8$]R· .É†"yÔ¾ó«k"¯ûé¼„ûİ„¬jâ—ëKÈÈ šèŞˆÏ¿è&^şk†İÏ^VïF5aı­olceTÏ7g±ÚÑWVâWlø’^<
»Å·ZCša¦–u¯YÆ%Vœæ¢.dûœŸ0‰µbjÖ?šµlÅûÜæ­T³°uæ´˜£©ºz×W±Ú™ëğ‰Zï¢8~ğ
••h«,qĞ–+ø*…?7ëÚ7w¶¿ğåÏ}ü~9K1Ë¹O7‘}s;óZ9¨UËæ–r{!ìjÖ–Ü>­Ã¢oµôjä×¦¶4m€›\­{œÅfışNMÖ=æjîY×È£Uxv™¶ôn^³üºX[:…Ûµ°ƒ-b´ì1Z‡Öq­gQ×àhu±GkvrêL²V,èéY?ÑÖ*©¡ålJQí.Ea´…Ş©l»G7Ç2s?Ñ¼“â„èö“mÊ²NAº0Ñ\O½ç4œ,Ç´ºu`7D_ëiô9M+mÉÚ:WR’çvÀ­œàöq?s''÷ÔüQRkşÅ‘³upûz€;Ü®â‘Åü‘ç™ûÛ^xü9FBUÁ¬¨ˆ—eg_Ï¬s"0ë{ ¬Ùú{ƒâ™ÖæPãÄ
ù`¤2_ºÔß#Øe4ñÿëïÂ—ıº±H·iu£âÉó¥Â2o8d÷êÆp]ørP7¶è‚ãE‘ø«}ÿ¢ğ%‡//*'Zú‚Uˆ¸ÂÆÏ|UõÙÔèªs†÷Ó©qPz#‰äMûØt“ÂOà‡â,ëRŸÓ?\­aãâÄêY5›B+ÄªÀÇŸS« –YçaŸçvsªBµ½±zûOşÍÀœÛ4f/Ş
£°!JôºÍ@Db—ä(	j-N„®æYKìŒDI'Úæ~–,÷C*ÙÊ•ø…¿»DO.Ù F|[{â·º$¤æVNH7¡ï…Ï£f¯YË^ƒ}‚ÛÕ,¬E’İbMßµ³Êİ~T»=Œ¿Füı’XÓuÓÏ¤Ğ}Iñä„­,,O¬IIvœê=Å$%52SŠl?‹( Úº Ì /cPº‘¬„Ñ	ñ³3èšs“Ü¤ ,AYñ×*|oßgG4íOÖæËÊêµ»:GEÅDõv2Ãí*¾á¡ªP—Yà+.ğ™™øñnĞúGoÌ†Æ&‚öëÙÆì_Á~vì x[ÑåR‡«Q£]šKW2©·«ŞâI÷[Ûê;Eõü¡¹YÛ8¿ ¶S>†ªœk0í­³&›3?i„-‰‘ÿnGÿ¦$Z}~M‘mf;»é¸š«ÛU†T
-ã;¥~¨HÑ¡x&ªê†¤Wx

Ù§'„^9•3¿@†¹Iäé¼ÜùIdæÓe¢Ş=qÂìP<¹ç8Ë´‘Ë|ømlHáú–^­_è~õt@µ,lnŸ±$`â,Ô¦^—pè"²{Ï.œ÷Ìü<²P}ÍMÔü.—ÎNÅ3#„Å•k®Í \ÍRšùÔ©÷¦Z>õNé|ñÀ@j®›Æ“¢í†#»0¸“•ø1Ë†Ñåß^¥òˆon¾C“;ª¿¹‹ï¨›ˆ1ß§ĞåGyÍz6æ{´’üZ©ea-bGÙ-bGu(ë´G²èJémzöÀG°¬k ‹rE6l°¹‡{vñq¥4AÏåµjÙ•ÒD=ÛÃíjØÁÖÜÌÌÕ¹,
;´è0ááÈ4!<*áˆuò÷vççÌ‚ÁÖÅq WbYò™Ç:ù÷â™‹xÑVşHnŸeÑVX]ìŸü‹97=‘kÇ:{Îõ<ÚÊ˜@ó/¦Ò³_íÂVG¸·¿Xx°7ÌƒmÿOó÷ã™9»Ù¶¥x~`=;gÛ–û"Ê¿ÚÅ=Ø_ÚmíãA½ß:N3íõºOñÌ[¯^¿Y(b]¯f:G_=õ¸®‘š*ée}›ë®¿œié†e*t¾ñ$¨}Àu]/¥ÒÜ;û‚’j0 	ÊïËã:Å¬\g(½b¢FE™ƒ]Å3\*²È­]×KCÑR,¯ZÖõÒpØı`—À"`˜Ğ¾$º‘œèF¹ZÒÜŸ@ ¹wï‰)r-&şŸ»\Ö‡õÑk›:j6ßjMöµÆwù [Æ>ê3ª’*Y¡!6*,Ÿ±‹s‚Q¡Â’¤`Y{©_m
¨–¥V¡î²€±Ysš±Gº½ÄšDª\f&Æ}‹¤B#ÄBâ‰”j,/$RìâX‘bl™HÁĞÜ*\¹ñ¬Íã=M¦Q€Y#1ı—6¹Â¬‘˜vñõ˜œì]CÄ{•\`±V"öpa7“@°—µÑ.n±ÍTQj†0@¬ã³ë3>¢¦3¹uŠ'/4¹æ5¿9@ìŸkš9@î®Ğüju@ÅÔ^ >k7ŸZ»ÎìPR/û|èäøÑçiê7øİuõ²Óv9:MG~‰rŠmƒ›$—çò©¡™m»×R¸¥%¯ŠCî(58‚ùUÅ“Ök°F¹è5X£\öÚgUSã¤&³ú5’‚Y4I0·O¾âs`Ó¨rR"‡Ïì?‘¶Ø~ja‹q—,õT_°zô>í4uk^cô)5ŠŸ+9!Ÿì¸6LDªXgà‘a'i.À£å2I#š¹58şÔ3;à:¢xléÏ|ÎBüòe¾CBğÇø‰ğÇ§^ Æ9¿ˆ¹àN}Ä;öMÚQîñ)˜m;“¬xTñ<ÕÒbÇâ;~£[@µ¸3æ?”’İD÷MZ9¦@Œ$Æ7Íº×M¬X…€'E«;†}Ã»\æïS4yK w­hc×„Ÿœš ×`Ãèî&dx®Á†³ËÛ‚ØÚ±“9!Gèê¸…s<‚:î@Éò¶ ú·êŸEó<5?±'ñ„â™6‰ ü`—k¦ÃêÇÔû=ÃZ_Q³aeÂ¡ä5ŞQ%~ğªí4nİ.Ğš4k.Õn¦ù×”ñ‘Zƒ)j.à5kÙà ìznW³°¡vís4•ò„–?vÒâŠâù¹(òİ—È[Öy‹òpİH^‡oãâ m®•Õécÿ>Œû'¤Í¿h!m^çÒÆ\äB×+f â¸Œ‡AÒjkAÜµ²*4•=SË®•5ÀÆÍ.(„€¶€Ô6éjEîózuóŒT73.Ku“uS;1fíñ˜ÂL[İ´Ía™‰è˜/³¤”B¢ÅOrúõßR£Âa–“Šg^Ø*ÀüÇ‰­Ü]3ãäVöYW¨qqêõ©ÿ¦H,qæµ[¹5¢{Sø3î>·™h¬à	Å7ÏÇÍuWCB™¿ş/e~B*ı†”k+K5ØšÖI­ü®—{káƒZàn«äpw·WbûôÓ	Z#$vÅ|Mæßp÷(|öçrUÔºÆ]œûliTÀ31ñë67ĞööáÉo‘ï¾¾±Er|İÓø|>'«Øºc°r{%«×Áä¸`Úç¡<­ Û¹ƒ»Yà Ú(´PÈsDZr[yT4ï•Ğz‘ÈFL;_iiÄ”É‰ñÉ«£İÉGk±óvd³ÃP–> FƒåWkÜì@HZJ"ıEO$ö9\Iä¼QˆÙdLL?0§$úÎŸ¥æŸİ1?ğ–¸x™±Æg÷«¥Öé˜}yœF˜"æ¯ù£tç7ÔınZ©˜¿øõ¬Åü57àó?ãó¥¬ùŸ°]n÷»'JXX½Væïb#^n üX¢QD}Få½Ä¨ĞËç\(³P&zyı¦>Rûİ È/$‘B6-œ–hË¡G+´Óm9µ¬Júc ¥Ù´·€†µi¬Üî-Àam¢Ğ²üxI2ŞÛO]H}çƒİ{[â¡ĞBáÑ?ùŠğŞvES!¾*UG	±wÅ;€Ä®–·º+:6…Î›éäŒÍ?ıå/ ´ˆ#ug$f°øjÍBÖrgx
Bk¦Íø.=8¨M¯iÚNJŞ÷‡:Ù$ƒå-;)Òy®æOjB˜‘Öipë'•w(iä=	š|t+¢J_ô=	,·A…l‹âïÊğ@64¹Aÿ  ÿÿ¬]TUUŞ÷^E*Çy•ÁøÊrÍ!Á¦–çÇÆVfM¬"¦)Â4Z¹($Æ1ÅÈœt”[:ã¸Z­’sî9[™å+³|„=}ô ‡iY1ßŞçœË.‚.Àí¾ìÿû÷¿÷ş÷ÿÿûß[€½eƒÍú¤`ÚÁŞ²ÁÂõÀlÕv±P{l¨İ÷TÊ»Ÿˆ€ÚcC…ë(g ÿ?a:#8‘ì¨w{|ÂÆU–ôÒö,¥vÊ*üoš«q+½­-Vºå ˜×xÓ”Çöz[&´!hˆŒ°Cñ‹Ïãß\elÚ,½ÔÌÊ7"¤ƒæåÍË--%û€£(	FÑ+¾júæ‘°dìØöÑ˜¼£(“îcF‘82Æ÷_ì­Šgy7&‘ÓråUBúæ°®^0yâÅôÍ8an]nD À$yÛ$ŠîáQm9öwqNT{’c]Ğ&1|®ìgö†¦áBp§ÜT‹%W±ßXèˆPi!j†X@á\•§ˆ‚ 	L¯ß «ACkyZÖ´B8{†K&Xk\¤™qÀË2UŠİ›6ûmbğ æv
Òkl}ºMì8qŞÌoßíÇG³÷;{2i2³?+ƒ¼DìÂ¸•F_•ë–[õ6±§ÔËê«6bœÔ=bZo³ì¥Àƒ Dp;;îorÕÃ±˜9ì¸(mZŒm8í§™¹ŸØ½¹Ÿ½³F®º—µl4²ÿ*õ¬¼Éˆ sß¡s_aæ¾sÚ?aäDfªpk?Ù±öí#wÀXö`z¿Lãø^Ñ¿A,ò J³å°M™Q>Ğğ´­¹ª]NŠ&‰H{;Ë¶GØ•V,¤‚üœ’óç””’CÀLÈ„N—é‰Ù	€?dÃO—ÕßØ.?±Gx{gë
ÿ.w 7It˜Û|×X1õ4ç€àœúuƒR'˜HzJxâÇd 'p‘`VyÇ¹|‡ÉÜw)øzˆª˜Îie†; Whˆ‡$7q{zeÙÀó®V‡èËFÓÕÌ­8ì,èj²Î‚}ãB4ÙOËÇ‰~®Ñï*htQˆ.4è"­fíƒW_¬q=…1˜%ë)ğÅ–! «XŞY²†:«øcCGSş²Ûww»]Ø”Ÿ8õ2B×Êôu¹¾–[ñG9ªÔ×íiÜ7s3ÍF0ÙXÈ	lv±ÙXU²ÚÜ/XöŠÖû6VL·»XïÛX5²º½_°2\Ã¶ÅÆZ'Ó}.V‹Wğ@¬“Õ}=cõìx§…èãlBªÏCã#öœÂfäqoà¯í3RMÖqœ``ãQ“ı(Iå#DAĞ´õ²{°°m4ézÑ¡L¹Øyù¡—+hêYSox@©_ÏÌÑcfÈŸ55TZ­/²™ÉÔ,ºI´ÍìI¥!†¶ lÎ¼9e‹s˜C3§ ”|dƒ7ülê)e.øG68*5TöøxÒüc/!X‘¹¦Şò´Â¶?¸g+2×Ä®pè\©¯ıÆéFgèOlè™¦®ıÃ…şÄ†ij¨ë/èÌ.½şĞpÜª/·ôÆç”5û~Öğ)À1à¨ÕPk¶î7ØQC_{=¯sÏOØğÅëL½zïú61xÂFG¥†JŞw{»ëËtÃOgğ“6xÊ KoO·“68*5Trğ¾Õ÷ghÁO9–é§kÍª[«µ	q–8ió)àìMúy|RƒOˆf¤Fy+7-ãŸq’00Úİ§ñN°“Xiÿ•S4óşœ™%¹y³sÊ
æ”•,Î))**$§;ˆË×Zé×>©òÊ=öT8~˜‡ë~ĞºKîÅdèÑ IƒÛÙÎ‚« >³¹¨[>Ê"³;.>³¹Ğ_\d¦#£Ä„ËÅçàbÚàKRÎ˜u´¢XÉG&ø9xÀÙª[İú`q=¨ƒå™…ƒ/À7ÌË´Ò—”ƒw4¾ l4ÜZşøÆ]GãKp9¼v£•¾k1fèp[_‚ÈÁ­nîÈa²g²ã˜{;İìp®“ğ;mİ¥÷”!±g<i$s	¶Æ*«só29	a.Ame.Á2È²ŸBËãyh	—`/+3*p	¶¢lS„KàPÌ ì Ü-&w—Aöw
Ç,}UšÎù§’Š¯¼‡ÜÍQèÆ×®3ˆ†oâ1ˆ0AÚxÓ‰(*×Üf‘ob›Cä•ë-åÔ£(§Jôèr®Ğ/ÄtCwM0Ì/(.)ÈË-ƒÇPV‚pt	^àüš	mpBİÄë­İEuêk¯àÁd	×÷ëH}PlÅc,}OR?Š»‹ß û*5TZ-£l…t?3œ{2½˜ß*^öÜ©¶e´¥-ªTÚZSÙ}³o½‡#Ÿ“à{ûÚ7;îµtí¬|!oŠ"¢N"$…œùb´µñ,èS›¿5ÚÚT‹ò‰Ôf’dÊ­©…Íös§F¸©}ì¹Ó¹‹gå–äçà9Îä„õšx¥U·¸cËTF†<y`Âõ\gô´ôBgdEÑßØ/C-=¥NYó²­½¿0`†Z*ÍÖ]ı¢º3'D?x&‚ó±Ö¬—W@ëÕ},0¸´ş§ŸTÖuQ¸8. ²ö³êNbÿP·:LœĞYn}¿©ÍÌ(<|…æI³ùV³yl"Y/âœĞãıôÑgæYñ½W”’¯ÁŸ!×â»ß±Š‡_ŸsF QñcÌ\”3XùE#‚˜d0R¸—Ü~‰öf"x**=ÚG›â¨7‰½¦°c¬A­ Ñ³lzlÛl\Òtó5wH¯ÀÏñ¯@“¢Æ«“fÜ{<+åµ•f&”-˜ŸŸ_4¿€üÀUßŒ4XI…JSS}?xtV}Âƒ8ªªPB™«¾7n°ÈØ™˜o„Èg#­ÊØIÈ0‰€i(D}KtÕ7ÒY[9á' ¢©¾óœ7õ.S;D•6µëÎ{K\æ$Ï/Ô]Æ,Ï.ïË†Ö=²K"„}EAHÌı“î[é“©®By©A@€Që
£†íR»ğV:{AYÎLÄDËròÙmÔ™¶Â3	Ùİ™IØ.~ôÔvU…("âÎ—Ÿ…’ış­!ÛÒ·üWQKÚŒi–>u»B?–(§l‘¢)§—è£ğóh(‡uÓO\DÂ¯-}ö3JÓ(¬üäPWB`¤&D«ğŠNkDZ%–Ÿğ‚Ör¥¥_]¯¨²¡5±ôÏbzšC%8Š‹%à™,tÔ”]÷+ÛÚdWuóŠæ—•Í³ÍÍŸ™«K‡Êí·~öÊ#xjĞèp„8Ó'áH"«—IüˆYı¥¬:úœHßN˜Û˜ˆtµJV‹$'—¦Í¨èÈÎ~âvÂ7!Ÿ”ÕmNşÓ
YIö‰7§Ò7~ÈŸ|SSÕ²¦>Ësn#’/°´#;§\éœ²¥£©¥²&lá©=šºPÖ´jäé¡®#írµÇGÌ²Ä#åòò¿¤À¸b‘Ú¶¶%"áfÙ0êñ]øê{â´<xZ6‰WTÈË2*›ŒŠ’1À¡³,¯»Ëï—?`§eD^~aâ¢ñ2ı·Ñ”$a~ÇøGH+&Ä²´ñVGŒHqı„¼6	©*j‹¨«É2Åû4c%›@0Ib	Â§õ¥îë¢XyL¢ïMd¬/°<`˜ÁøyÂ†|K¢GzD¤ŸKôƒ^#QŞ>8°Wˆqñu‰Şl6]Áã|ÊDN{„uRİ)éêí&»q¿%É¤×K”S^Ñ+Ìx†©CÛ{Ğx_à‰PtĞÁõš’E7§3LÖÍ»¤C —˜—„1ïs0/ñìs‹9+ŒyŸÙKÌ†IkÛe›àTE@:}ÔÑÇ°lq[É‘íjÈÇ–-§ĞKÌD95D‹Ì¦±l<}˜QD«®éj±I“$ş¼L¡I'K”SíÕxd˜ª€Ø!´á }êĞhÕOÚ0Ğj4Ä›6“%‡D/QqÔqà¨kYWùOE ¢«øbØüÅ Á/¨+Cuµ¤ÎĞùK:ÏJªM"¸}íê*…ôğeeZÇ<’8+§L}QÒ4×€ªHòj"XYˆ°>ß
KDºÈÙ
÷|ejK«M]jhS?0õâ•
½ÅPm*Á¹sÜºn…á}9ÌOqIQY^7.›]“—A’/´U¢«’ì¬Œ`"‰á¬@…Ä0V°¶KtW!P_Ë¸
áí£ª®Wï/µµøÎCòŞÇ‡C3-~ù´ß;Z<™^Ê´xR÷çm;kÑ2µl4vşj©¼7~¨l2"(B‹;¡Å#¯m¬twmcˆÍ×2å!yäŸ+dãkXêHÉŞ]2èøZf=(Lg-e¨”²ò&#‚"øú   ÿÿ¬]lTÇõ3ÅIh M„XÀä˜õ0	…ç·o0$1ÄTQÙ°Ô`
¿’äÍ†!	šR>6lL `llL T¥ò¼ÏZˆ–ÆID¥*¥¨jª
$ÓŸ’ª*=ó>ëewÍ§²´ë]æ±÷ÜwçÎÌ{ïÜçRLâ«Q¹¯;¾’l_¸¿QÕùM‰Ã–î!Iöa‹‹FF;ws”æoçºÂ€O¥ó‚'‡`‘ ÕHØ<]Pï¥áMKUdzÀÕÿs€aïow“ì$7øõım]p#ÒÁ%F5`ºôü0İQQ§m—¤Ğ½;kË«À`g¼"Š,ëZ¥Êd“5á	*ÓÚ´×M—BÓ.¨rz@êr9ĞÕ^@Í.¥í=:P
íM ıÔ`_ Ÿ*ì Erd¢Z¤³c&[¦²’ ¶ÎÔß7½wGHî÷Q¥J}X
íKÀ4ˆ@`r…q“ıXv?Ğ?ÔTÜ©Gãou=¬¯ªl§ê ’Bµ	¨¸S¼œ;ıT Ê2ç_BÃ6Ø¸ò7ª.PÙë&³i¤EMÚB°ùoWuÿËÕÔG%q*ß8ÚÒ(jNu—æ<~;ÍÉÍŸH.Ÿ–‘ÍÖ`m­ãb´rykĞÂ)U+HTÑ!ÏŞ%Ğ !ş~\eGLf`ÖøØqU;b¦¹ë»
1æŞ~•k+só
$1è¼Ç‡Eâ-İ5šßA‡‹Ô}.»ĞüZüB “A];«²wUO‚Ã€„H:µwÕt"¼ë~nÃpÿuñº8ÎpG´"`×3@# ŞêØz74ÂB+GëÍwäeˆİõ=e
[‹ÇÔ¯‹±¼‰3½ƒQá+›eßf!ºøµcøU£y±ÖÌ …3Eu‘”3G•>	‹wtÙÎF)æÍPuí“ 3¡Œ”B&Ë`íöÔi(Ìr'”è)üÿº †d$ù7ª¬‰	Å%’vFI²³çO~3Óİ,¨Ç¤P4x«ÁğÊÆ_…mU‹†²OÅ*`5±hJ•A¸KÃNJ^*Rg²' L2Z«ªrìˆ ­?áô49íÔˆÍn'';ïnS#
f˜b“½Hkëœqÿ$@0Ã›Ú‹ÔS&ÕççJEé.Ç1€!2êEf1²Ñ´3†~ùq¸§l84r4Şïö‰ãrí¤à²ûÎ¿Éâ;¶Â+¶G,¸£¤P½×yŠ¯ÿõU;B¶ã÷…ñö+Ê¹jêv‹Ì¬¡D;n²Î"—Ş¦„l4	$ÚáS|pë'ùRëvÆ½	d´B¯{Ã‡…W¼EÃ>ÏÑƒ,áÓ¸ò
®„O›á]ø¾N|?e&üâÏA7»:=7=XQ/şÛ1][OÛYŒ‘B…,˜]°t “†aûPØlE7ŸœÅ³îéåë©vÂä;îé—Ş °@x¹C¥é¸)¢®!_ĞGï‹»
*ˆ2êÍÑ>¤¾OqyyiÅ«+;'ƒ»¢k"Üê8	k3Z¥Ñ¤´Jµ£È|Öe’ñøä-ÒyÜ”é|ÆxR@Z¤ViÉ'ç3j3
H>ë2òI.>[¤< ĞKÆ’ºŒó’ƒÏVi,CúÕfÈÈ!£I-.Œ!£H­Qøû­¥mï˜Ø åH¡„,œ£óìsƒ]4Ø$üUØo•È$æÉ<?|‡+¨vÈä_¾@Èâ“»TšŞ9f/Iºz„Âó¢T…Ãd¬ÍI ^Æè{®Wr¬:äq}yãc}¿Y!gôzıEåf)ø®ûïòÇşğÏĞÊÉæ7üáØØâ]ø~¿I@€!-í†«Ô:]‹V.¨X¾ˆ„ôåïÄô³Ä!PN7håh½³DˆÂt¶T²ÑŸ;~\J.F®-í'–m¥m¥¢k®:ìÉDõ±½†xeâ¯Âö*‘LÑ;rÅ-ØÎP9ßbñ~§ğ}¾Ê]:M¥jújª«*ªQ|´ºj9ÉòèÅıÛ-ıÈ	ºï¤‰ê¢ğÀÑ<HDö•ù¸¼İâÑT×Nš¾¶œ l«éıàMç‹Pé3]zÂ`w„8y	¤Z$?VÆk¯çÛ‚Ø14¦_ŞJÛ„šæK¡»¡}dêZ‹ÉvÚGA|Fv
QøÇÇôè”}bj÷ÄôÎŸRm#†¯C¦©‘nÎJÕˆ®9«Àf„7[záNÚ¶_0R …t1ÂvØ«o¶Á¶)¬],‚²Ì/Ÿçu;…`8?léóÀÇ“»TšöwÃÇ­æÎqèŒy}³¾±öns±ˆ.ö6CW¬ñy­vlÑ¶v“”uË5«k†òò pn!ŒõØ´á0`sÅx)t4áŞ3í
¬5:Ê¯â©)’±S\©²ß™Ú]Æóc“2›‚(ÀœygóÄÒ*<á²êÕjRˆÛ†-Öëó©—Î÷¡d¹p|¹å—˜D6€Ê
…=v‹ó€½æà—â—f¯9+ÔKßÌŠp¸á°Ïº	Â÷+}zu&¼ã€¡>^şoKç¯SÇ.›(…yÒ	b|l3um«(›¬mâ[pC©Â³úÆôò¥ö²Â¿°ô~5T[ezdšw¥dÚßTŠäi³sfÉÚVo¢G–B	˜Ñ‘à'ÛÒ®Tu<ŸjC"SZFµPÂ¿Xzçnª-3¹K§¹şÖ ÏP™ËªŞñm« ÏH¡¦ĞÆZfL«7øÕ/gÒõ
÷›–®m
ŠôëaT/‡j“qHÔ¡Ó\c†ğTÑøÒiŸ¹{4±ìÊ—TV¢¶rõ«/!/pô 6¡¿L/­§µ½6	ê¹­­w67ß>-‰ÁÉ©Zß|q¯™÷ ©’ËMÖ¯´,õ›òƒÓ|Ç¾D¼ ¢ùùåC*/o²¸–‰»?¬r$ĞGqÃ¯æåî7&•Mœ<A œÃe~«­D$ƒN–BÍØ±\1˜Oh»¢0j­‰	PË²M¶PÉã€Én˜ì3Å!ĞT¢ˆE`vR¡›Ô%`¢¾Õ«VãùkÕ+ªÉôş0îãşô’% sS¤PKöæc!ş*¬@a%Kã-u”woçò€˜¾#Jµaí™k #gÚSqñÍ0Ğ³â>Swq–6‰ñåû½ÔY
H`c¾Áğ*Å_…ÍWX©R”Å£Cb¼¥–òsà#: ÆQÊ
FB×C"±Kq'±2:…•ªå‹–•uM’v˜×e¯ÈfObñšÍôÆ¹!"3¥H
µ&°ç¬Üçt,Ûl·áE2Ü>³->p#å¡íœ²xçÊÈB×@(Î^’qõx
{+e‹‘J³ºb-qşI›3m€Å—¿OodÚ93Š:™ÀYÁğ‚à6)l“)UgO x€òßCXÚ·°8Hùh;w	]!ÁYê Û:Œ<ãåèÁ«6#j~”ÀHÄ`ÕÓQXµ(N#zp(º=Ø‰,G–D)¿*q]!—‘¤şë–Õf¤FÿÇÔñEªRèTÚ>S—™ZÄà|oPç#2‘óa‡©vÊä‹ûÄô?m¦Z³¨CÈvJÚ*ÔQ·².¨áÚk?SCoøm‘P)tº‹vÒ`Ë6Ø	…UX¶PêØxY› Ôè›hØâß¢ú»KçèÈ\²¨QûÊÍÃkDŠÒˆı©x¨‘«-!LtÂ%VyŸŞ…IÅnèf9áóÚ;›‘òWT°9–}}tcn¤=“l‹gAyl,Y¶ j©ÈÈZ2µH²¹b…çÖwq3ÕãÆmw¹QÁM÷¼¸ÆlÂiëhçòìí³Ç4WW¸yš‹ìµß²›üx+äü8òt[;åG,.¿ModÛ:1]
}Ü¥î6æ½ô¾AH6Ş{Bâ­(HgÑr¬Õ­[(ù5rÚ.÷¶ÈgÛ(Yïo' G@d‹ü6O7ÊïL7
¼™¤Ø‘IxÕÏ¬ğsèF×]Zì%~¡³Ùq—ş_Ú‘¬ÈŒså&*9[!FqT`†Dvä+W®°Â9'ÁÎ1—;¼=Ç{ú8/†™ÙMúj“-]ûÖ6:ÊL°‚ä»É0	>¤Vg³)ã= –‰İ‹åYO,ËQˆÅë¥gÁ‹=„İ='–€s.'­XsØ	÷JÓœÀÎs;ñ=ÈÎ„î¥ó¼ËÎÜVøtK;Ï»ìxzçtOZé”Hd*Á£WÜz[gÖU‰:Ó5ÚÅv¦C¦!ì†„¿?JrwÃ/k²ßğwåLÕ™“yNú _$ÁW,Í/«¨.[µhñ’•°¹ga¼#¢tİÒeƒÖ•¨â4è,ˆ	
}İâh‹Õ„Td÷Ú[:{ÈP2’ò¾sOL’µeİå}Ûs?8˜íà}…dyx³¼¯,®Y´‡ñ^pğ® /æá½àà]^¬§ñJ¼«§éá•:xW!OÓÃs‹dv#QwIµ%j?æåŠue++VÆ×R¶rIå¢eğ°O°"İ@ü¯¥ËÈi)}ã¼•ŞàCuúy‚Âµ/(\«ÂZ•H&.ï‡qÚLù´a¨n†9xŠê…´»t®crØÆ@’Îåv£syx¤gUÕÂ²•Ë+Vãà«·ÌÌ…˜°è‡¿|i£‡úéùª}$i.d…	,~¡¦PUSçÓÅ—¤ƒ®Ä°nü  ÿÿ¼]pTÕ¾ë%(Ê˜8µT1Á l’E­¯ts;h)F|@0°Y“,‰.IÈæ¨åÜ52h"
TŒ´EFLµ£3jÉ}ìbPµ:`«™©CÑªCÑ±–éë;»¹›MB´A'Á3çäï;ÿ9ç?çüçñ/ÚF‘¸ÄXä‡û°0|ªT§î£-™ìÛ¤³#ÌKJÑO=lºlDÂ²™ÃõW&›E”ÍB‰'-ò™şä5\.‹À}²8i"2™Bñ}¡­I£ŒÓ0”¤1À¢Œ±@ÜØ’€L‹9	¢BÇR²XÌX Ò$Çô1”…˜ŸeÒ¸ƒÒ¸]2ÉuIËü8Åãğ€e±&b‡&ò­Zjápm£œAÛğCŸ§x”ƒÚ†mãs<Øz—)˜Ì–q%WÙ#t—L),8†
ØGSØK8¶ì£ì ˜z¦®=%ºp<3Dg]JWSÆ‘y‹©lªÙ–ÊÁW<šM³ñ£š×˜fëÇÊøuİ<–Íö4[¯n-:w?Ïæ³Üìı6_şŠ×y#pH”¡ØBSl×@±}åQ%!Š)6‘€.<FŠ­HLAiYšb…©ã¨	±X-Ş³ªÄ––$¥OOxˆUbnÂØ+±°K¬ûÒC,ì	cG¬è
ŞÁ†‘Øx.±;±Hó™Ç“VçQ½[¥û4wÊÁWİ¦¦úÌÜIæóÆ­6™¤Y<Ú~×/LšĞMr…fVLLšoD¸Ts3zAÕï§Y+*yß±cÇŒÜª”ƒ¯ ZfŸc¡&AòÎ‡™Á¹¿NTÖéÆobšVÇÚ›E&§²7W±õEÂØ¯w—ÒRVÉÁß¹x°@n²¶‘oÓ{;”x>ëPÿB‡rP0]ƒîC‡êÑ-²X3X.]¥5–¦¯<ÏË˜ T³’šÑ„Ø-lëÕrpŸ‹ùv:I°¢îTbEÍé„m{;³­“É	«c/+«Èfˆ²f{íÍ4¶`ÖM>ÓÌN˜ıÍØ5gÈÁnŠkø|šÏ˜k_[F©mÜ¨_—´•*&™’°úc³ÿ[uêØ[äñÙÂö‰šáên¦ØşòlóË#Â¥`e´¶AZJ¸!Ü2QIß?g¤|ºß¾LÆ$1å…¥eşÜ’¾‘Ÿn-ókJú&ÌÔĞÚåx¾[Ô—ü`ŸnîÖb+®¨Pæ¯)vàÉÄ…:.«A[é#¯)YˆÂø¿zYjú9‡Œ8£»7Ê_à ÅŒ‹ÍQGõ_%1¿Ë‘ÆÚêºª(–õ¡eõÍ"£V‡ 8ìj9‡ 8ìJ|7î¢V¨¶yå°Níº‹sX¡f!ŠsX§
9ğÓ˜İãšäpêÁÌ% mS¥/’îæUĞèr}7‡ît¹(şi;-ämÕ&­{Úv«ÏD\âx¹Sùe¹ë oµG«¼!W—w;”Ó^'CÊ©oÿéW#]jsìI{µÊ2¾ßñ|·<£Á§»r·ZD›¯§ŠlT¬Š'İ'é^K½th¿ç§"âÇ¬ÛÈµè%[R ¹ŠEN)¤G±¿Hg©"ƒ®“
İk	f\š¡è†lıE!ºÿ)5pa¸%‰ãúö†4a¸!,Çõè(‘8ÂÜ£#¾Ë†Ç£ã Ş¿¨´ş/ĞìÀQÿ+Dı_ e!nPı‹ş¿ñ¶v?úşÿcŞü3ú¡Ñˆ¾g\§ÅÏÁa¥1ãÎÍ?ÕOƒeP£Å§
1Î F7õ;bĞDäkñ‚Ag¯›ñ1h–±û¾ıª€v°j†Îwß[şq¯ÊåçÍt÷}‚BGFáì´ÎNñSÀınßûí F¿|ŞÙ¾¹´Ñğs'Gì¾‹±û®zçºY9×sßİ}g‡ëZdI‚_›Hdº‰lU¨£'(çH‡N£E¬ë×ŠƒSBM]·x ™B=_ÍÛgšz.”Z]ü5ÀÊÅouñyìiÄ_Éñı/ÅÕm[·+6ŞÉBùWr|kŸFüU?¹Võ¿4MQ9ş*/b…ÇÁc”WşC“J³ÿãÈ9Óƒä¿šjk8ç4.ÄVËÁıÊÚÀ&ë+6õAŞSb¼¢PMŸ(³ğD½	ga¾x&½"Æs`·µægèêÌIé=µ\5ğ0Ú:DÜ#_@bˆ(V­ÀŒ„‘PÈjl#~?aÇÎ4ı¾ëÈ0#ÄF7Bòâ^L“óL¸Æ¶
zõît‚~¯ìàdÌ¶é†c¶×è½\Ò4{t“`‚Nşƒ	ú„—jn>]´À0Öã!®ŠÂhü Ñ›Vş<D×4I÷¡uĞ¤/avöé&ó™åø>9@oÍ›aÊõ}{Ó1àÎ!ïÂn{8ùs)bÇr€ü aÎ>’‚\# yì( Å¡ŞSO•QJÂª›|™°HŸ¨n"ßğTw/[¡º{c‡§Õè$Íãï¢ŠQİæ_fÎ„Qİ"Ÿª;óˆ³(Ãû¯îhu¤I2 X5¶­š”ïÅ”mîVß$mœŠ_ÔÓ7şŸ/”â.ìe€=0 waEü(`G_…Òı¬
LCêGh´Çİ/{İ*ÀÂ”lppÔË!šm’*‚*«3· iÎ~¢¿J3+²’fG?Â¥š)òêÒ´¡çŒ™•@…c
 gĞ­áÆ*©ÒX˜ev^ÈNé&ûœ³Öah*R$iÎrgw„ÂNl¾xaÒºàitãP$‚îsÜÏ¬´ÏÂ˜@unsªX¸Š‰s+Zn¨zeC´š’bÒL@9I«oÔ;ØÏz@p„%4Îè,°‰6=£3_‰ŸÅTÒ÷’æGOA 8%Ù?1iÍyF'óSdÓUï-›)Ú²)|wu¨§¥µ`â3Vi\ØÖÊÁƒ.T³!¼è[m‹ìT™á­Mè^ul=OşíX‹b6‘Í6„4Í:`æY¦?i4èİ'l~<äB¢ğ¶QÄ
_ E¢ğW&­‚å:¹Ø1s`Qz¯Q'ÏÛ"“®öĞEÏ\Jx_W€gøÔ‚šŸe•ÖSjf`jÒ2ŸĞ»÷ĞŠY/ïáö‰m@sÜjŸ(†&uNOZ³·éämÇìŸ”´JŸÒq8ÆÍ¥kÏ0õ’yÕKNzR±Ì™š±O\|}P¾éa‚ñ?Ç,ãwO	Æï@€šĞŒù“b.×¨1k–*²åİ×è#˜Ì~Øö+%ôBd¡¾R§ü×>B’Şhl “Ùî¾~ØÖ©„Úé—¿q>lÛ¥„Ş¤áçNåˆÉ¬È“Yïİ×mÃß1İHyáVÄÑ'4ìïpùSUîXxïªëe¥}#Vz·g±Wa"û‘~M¯v"ãŸÔüÒp¥9ŠøWiì»g^æÄõäôk¨Fgi”øãoĞpÿš´f‰càÈà’•	92ş‹áyšü®Ào£î„æÂwÙL|PëD‚øx?/9„÷Ğpn:…ÕoÊçağY˜5!ğ¿ßŒúå s¦J¥ñ°¬dåÌ’åY­ Ñ„ßfü¶P:!_Áß _çHÂ£á¨#æù€Í™l~&Ù­p–qÍWã»£pıq3}3gAµË’b—Ã‰v‡ƒ«38…Û+íB¹æ•"á H»#5Ğ0şOv¤F¸¼rizåpíÊ^ë‹5…kñ*p‡Œ5Ïg¯.Ö6¯BÃk ·ÒÂìVÚEFmºç¿+>y½¶¹Œ~×¾'‘ÃV~Îñäé„Ù­4İ³»H‘×÷Dò#”PÖÙ‡~ø8œ‹^¦IäY.G˜<–ú¦šˆ”wfi’´Ë94á[ğWÒ³ç‹’Ÿ.h¸¹®²†q©´Iˆ>Gò('°)E`R&#…€ÀF„·Ò0D.CXÚ5A5’F ±¶²Zz”ãGZ~©m;|é ş£.~äv¤lE
ğ#[œOÅäx¾úğX†‰vìÎUÒcœÿÀ%ºdú’”smXİı˜ËÀÿ*R¤9H™¢øßG˜Ğ¿ÊW<_èÊ¯Ã*½Ë”i£–Î 3êšúæXµ[›9|dËyú¶Éõ 9¾ÄÆ!‘İ›]øÈZ¤”Ñ”vd'Â‡ëğWŸÛ/t{Ø,ó†…gâßÂÑı_äé‘àÅÈ·‚~‹‹îÿRÖÒ”rÅ/OÓ#ãÿ  ÿÿ¬pEÇ{3›‡BñN°D^RŞ•095€d3;³I ,Dy)d@’€è¡Ì&<
AÑ`† „ 	ğA2›™ƒ­{X¦.”uÇ½ªÎº;¹OÏì²UIí¿æ›ß7İ_÷LÏt÷P=Wp¥ˆsò1Å=y'ó73¾ÙúKC-•ÿ›¾ÙóW˜­‹‚[‡½ê¨®Ñ])âésKŠ0,û¥—;¹ÿÍ_×ßà{,ÂÿŠ°ûƒ¿–ÿ¼‚zêô½ØK©ÖÍuĞ,øW:¹ZÄ¾›oe9Ã«?õ5øİ¯_<šÃr¯fÜkğ[`R=Š½Q]¥»R ŸÜIìÅTŞÉÕr@áK}áĞ{X¯÷4]p·jã~“/¬­Û,õQNëüb&›‘-:_
ı	9-u¾xjŞ¾}±&îÙ­Ï»úÂOyè}œÿivş[lªkaPs¡Ó©nÑ])â8Sü×8`åã›ÿ2ÌåeQ~…Ã7ÃRøærè•T·è®qø1­›ïÀVæ¼´oØ¬X
6²Øêx ¯†e,ÊF]–¡÷P½í4KÇƒş×Vÿk’ü2¶:¢W˜ÿZÛ¾¶šË°Ğè»ú[ª}ÑqØ1‡meüGÍoê–w½t-;í4_ËvXĞìó¥Ğ¨Ş©»RÄA¸îi;y^	8½…aÉ;À¦¡A¥«´Ø¸ª„aJ…N@Ï¤zîA §@“Š8è˜·ÀqkGü6°ñ³9Š9Š¹Š{óó÷*îS,RÜ¯X¬x@ñ â!ÅÅÃŠ¥ŠG*S,S<îğPñ„âIÅSŠ§‘âÅ
ÅJÅ³Šç««(Š\ÅóŠk/*^R¼¬X«xE±N±^ñªâ5ÅÅFÅ&ÅfÅÅëŠ7o*ŞR¼­ØªØ¦ÈSä+
Û;ï(ŞU¼§Ø©x_ñâCÅ.ÅGŠ»Ÿ(>U|¦ø\±Gñ…âKÅ^Å>ÅWŠ¯ß(¾UìW|§8 8¨8¤8¬ø^qDñƒâGÅQÅ1ÅOŠŸÇ'¿(N*N)N+Î(~UœUü¦ø]ñ‡âOÅ9Å_Š¿ÿ(Î+.(.ªDRÑ§ñ5R£4Zc4…5E4E5Å4Å5%4š’šRšÒš2š²šršòš
šŠšJšÊš*šªšjšêššššZšË4µ5u4—k®p,GSOS_s¥¦¦¡¦‘¦±¦‰¦©¦™æ*MsÍÕšš–šVšÖš6šk4×j®Ó´Õ´Ó´×tĞdjbš,M\ÓQÓIh:kºhºjºiºkzh®×ôÔôÒÜ é­é£é«é§¹QÓ_3@3P3Hs“f°fˆf¨Æj†i†kFhFjFiFkÆhBÍXM¶fœæfÍxÍÍ-š‰šIšÉš[5·in×LÑÜ¡¹Ss—fªfšfºf†f¦ænÍ,ÍlMff®æÍ<Í|ÍÍBÍ½šû4‹4÷kkĞ<¨yH³Dó°f©æÍ£šÇ4Ë4k–kĞ<©yJó´&Ò<£Y¡Y©yVóœf•fµMB“«y^ó‚fæEÍKš—5k5¯hÖiÖk^Õ¼¦Ù Ù¨Ù¤Ù¬Ù¢y]ó†æMÍ[š·5[5Û4yš|Mf»f‡æÍ»š÷4;5ïk>Ğ|¨Ù¥ùHó±f·æÍ§šÏ4Ÿköh¾Ğ|©Ù«Ù§ùJóµæÍ·šıšï445‡4‡5ßkh~Ğü¨9ª9¦ùIó³æ¸æ„æÍIÍ)ÍiÍÍ¯š³šß4¿kşĞü©9§ùKó·æÍyÍÍEHê1ağ¾A”AŒ¡°¡ˆ¡¨¡˜¡¸¡„!ÃPÒPÊPÚPÆPÖPÎPŞPÁPÑPÉPÙPÅPÕPÍPİPÃPÓPËp™¡¶¡árÃ†º†z†ú†+MMÍWš®6´0´4´2´6´1\c¸Öp¡­¡¡½¡ƒ!Ó3dâ††N†ÀĞÙĞÅĞÕĞÍĞİĞÃp½¡§¡—áCoCC_C?Ã†ş†††A†›ƒCCÖ0Ì0Ü0Â0Ò0Ê0Ú0ÆÆ²ã7Æ&n1L4L2L6Üj¸Íp»aŠáÃ†»SÓÓ33wffrss÷ææî5ÜgXd¸ß°Øğ€áAÃC†%†‡K5<fXfxÜ°ÜiÙ†'O6D†g++Ï3¬2¬6`HrÏ^0¬1¼hxÉğ²a­áÃ:ÃzÃ«†×››[¯Ş0¼ixËğ¶a«a›!Ïo(0l7ì0¼cx×ğa§á}Ã†»>6ì6|bøÔğ™ásÃÃ†/{û_¾6|cøÖ°ßğá€á áá°á{ÃÃ†GÇ?~67œ0üb8i8e8m8cøÕpÖğ›áwÃ†?çş6üc8o¸`¸hHGß“£’¼Àd ˜ pP$(Š%‚Œ dP*(”	Êå‚òA… bP)¨T	ªÕ‚êA fP+¸,¨Ô	.®êõ‚úÁ•Aƒ aĞ(h4	šÍ‚«‚æÁÕA‹ eĞ*h´	®	®®Úí‚öA‡ 3ˆYA<èt
‚ sĞ%ètº=‚ëƒA¯à† wĞ'èônú‚Á à¦`p0$Ø`X0<ŒF£ƒ1AŒ²ƒqÁÍÁø`BpK01˜Lnnn¦wwwSƒiÁô`F03¸;˜ÌNù ´ÂzÖ·Ò*«­±…m[Ô³Åm	›aKÚR¶´-cËÚr¶¼­`+ÚJ¶²­b«Új¶º­akÚZö2[ÛÖ±—Û+l][ÏÖ·WÚ¶¡mdÛ&¶©mf¯²ÍíÕ¶…mi[ÙÖ¶½Æ^k¯³mm;ÛŞv°™6f³lÜv´l`;Û.¶«íf»ÛözÛÓö²7ØŞ¶íkûÙm;À´ƒìMv°b‡Zk‡Ùáv„iGÙÑvŒíX›mÇÙ›íx;ÁŞb'ÚIv²½ÕŞfo·SìöN{—j§Ùév†iï¶³ìl›cçØ¹ö;ÏÎ·ìB{¯½Ï.²÷ÛÅöû }È.±Û¥öû¨}Ì.³Ûåö	û¤}Ê>m#ûŒ]aWÚgísv•]m±	›kŸ·/Ø5öEû’}Ù®µ¯Øuv½}Õ¾f7Øv“İl·Ø×íöMû–}ÛnµÛlÍ·v»İaß±ïÚ÷ìNû¾ıÀ~hwÙìÇv·ıÄ~j?³ŸÛ=öû¥İk÷Ù¯ì×öû­İo¿³ìA{È¶ßÛ#öû£=jÙŸìÏö¸=a±'í){Ú±¿Ú³ö7û»ıÃşiÏÙ¿ìßö{Ş^°‡%‡ŠHˆÈ‘/")"%"-"#¢Â"*"¢¢"*&¢â"*!¢•Q)•Q•Q9•QUQ%UQUQ5UQÕQ-]&¢Ú"ª#¢ËEt…ˆêŠ¨ˆê‹èJ5QC5Qc5QS5ÑU"j.¢«EÔBD-EÔJD­EÔFD×ˆèZ]'¢¶"j'¢ö"ê ¢L§êˆ(KDquQ'"ê,¢."ê*¢n"ê.¢"º^D=EÔKD7ˆ¨·ˆúˆ¨¯ˆú‰èFõÑ Ñ İ$¢Á""¢¡"²"&¢á"!¢‘"%¢Ñÿ  ÿÿìwtTU÷÷sÚ>$ *EÅƒ¢Š 00APPQAQª“d’&™LÁ¢(
"¨€|@Á†*e A@DP°€±RlX°’ßMx|×O}ŞµŞŞ5çÜ³ÏŞûì½Ï÷î}ï]kš"¦ÈW(
qÅPÅ5Š"E±¢D‘P”*†)ÊåŠ¤¢BQ©®¡¨RŒT\«¸Nq½âÅ(ÅhEJ1F1Vq£bœâ&ÅÍŠñŠ[·*&(nSÜ®˜¨˜¤¸C1Yq§bŠbªâ.ÅİŠ{ÓÓ3÷*f*PÌRÌVÜ§¸_1G1Wñ€âAÅCŠ‡(æ)U<¦x\ñ„âIÅ|ÅSŠ§Ï(U<§x^±Hñ‚âEÅKŠÅŠ%Š¥ŠeŠ´b¹b…b¥âeÅ*ÅjÅ+Š5ŠµŠuŠWë¯)6(^WlTlR¼¡xS±Y±Eñ–âmÅ;Šw[Ûï)ŞW| øP±]ñ‘b‡âcÅ'ŠOŸ)>W|¡Ø©Ø¥Ø­Ø£øRñ•âkÅ7Šo{ß)¾Wü øQ±Oñ“âgÅ/Š_¿)~WìW³ªÕ ÒhÑXÓˆÆkêh25Yšºšzšƒ4õ5kÑªi i¨i¤i¬9Ls¸æMÍ‘š£4GkÑ4Õ4Ó„4Í5ÇjÓ¯9As¢¦…æ$ÍÉšS4§jZjNÓ´Òœ®9Cs¦¦µ¦¦­æ,ÍÙšvšs4í54çj:j:i:kÂš.š®šˆ&[ÓMs¦»¦‡æ|Íšš^š5i.ÖôÖ\¢¹Ts™¦¦¯ærÍš~š+5Wiúkhjik†h®ÖD59š\M&¦É×h
5qÍPÍ5š"M±¦D“Ğ”j†iÊ4åš¤¦BS©®¡©ÒŒÔ\«¹Ns½æÍ(ÍhMJ3F3Vs£fœæ&ÍÍšñš[4·j&hnÓÜ®™¨™¤¹C3Ys§fŠfªæ.Íİš{4Ó4Ó534÷jfjĞÌÒÌÖÜ§¹_3G3Wó€æAÍCš‡5hæiÕ<¦y\ó„æIÍ|ÍSš§545ÏhÕ<§y^³Hó‚æEÍKšÅš%š¥šeš´f¹f…f¥æeÍ*ÍjÍ+š5šµšušW5ë5¯i6h^×lÔlÒ¼¡yS³Y³Eó–æmÍ;šw5[5Û4ïiŞ×| ùP³]ó‘f‡æcÍ'šO5Ÿi>×|¡Ù©Ù¥Ù­Ù£ùRó•ækÍ7šo5{5ßi¾×ü ùQ³Oó“ægÍ/š_5¿i~×ì×³ªõ ƒ2hƒ1Xƒ3ˆÁê2Y†º†z†ƒõ1jh`hhhdhl8Ìp¸áCÃ‘†£G14543„ÍÇ3o8Áp¢¡…á$ÃÉ†S§ZN3´2œn8Ãp¦¡µ¡¡­á,ÃÙ†v†síç:::Â†.†®†ˆ!ÛĞÍp¡»¡‡á|Ã††^†.6ô6\b¸Ôp™¡¡¯árÃ†~†+Wú†®6D9†\C!fÈ7
qÃPÃ5†"C±¡Ä0”†Êå†¤¡ÂPina¨2Œ4\k¸Îp½áÃ(ÃhCÊ0Æ0Öp£aœá&ÃÍ†ñ†[·&n3Ün˜h˜d¸Ã0Ùp§aŠaªá.Ãİ†{ÓÓ3÷f0Ì2Ì6Üg¸ß0Ç0×ğ€áAÃC†‡æ5<fxÜğ„áIÃ|ÃS†§Ï5<gxŞ°Èğ‚áEÃK†Å†%†¥†e†´a¹a…a¥áeÃ*ÃjÃ+†5†µ†u†Wë¯6^7l4l2¼axÓ°Ù°Åğ–ámÃ;†w[ÛïŞ7|`øĞ°İğ‘a‡ácÃ'†OŸ>7|aØiØeØmØcøÒğ•ákÃ7†o{ß¾7ü`øÑ°Ïğ“ágÃ/†_¿~7ì7³ªÍ ‹²h‹±X‹³ˆÅ[êX2-Y–º–z–ƒ,õ-[±ji`ihidil9Ìr¸åKË‘–£,G[±4µ4³„,Í-ÇZ³o9Ár¢¥…å$ËÉ–S,§ZZZN³´²œn9Ãr¦¥µ¥¥­å,ËÙ–v–s,í-,çZ:Z:Y:[Â–.–®–ˆ%ÛÒÍr¥»¥‡å|Ë––^–-Y.¶ô¶\b¹Ôr™¥¥¯årË–~–+-WYú[XZY[†X®¶D-9–\K%fÉ·X
-qËPË5–"K±¥Ä’°”Z†YÊ,å–¤¥ÂRina©²Œ´\k¹Îr½åË(ËhKÊ2Æ2Ör£eœå&ËÍ–ñ–[,·Z&Xn³Ün™h™d¹Ã2Ùr§eŠeªå.Ëİ–{,Ó,Ó-3,÷ZfZ°Ì²Ì¶Üg¹ß2Ç2×ò€åAËC–‡-XæYµ<fyÜò„åIË|ËS–§-,-ÏXµ<gyŞ²Èò‚åEËK–Å–%–¥–e–´e¹e…e¥åeË*ËjË+–5–µ–u–W-ë-¯Y6X^·l´l²¼ayÓ²Ù²Åò–åmË;–w-[-Û,ïYŞ·|`ùĞ²İò‘e‡åcË'–O-ŸY>·|aÙiÙeÙmÙcùÒò•åkË7–o-{-ßY¾·ü`ùÑ²Ïò“ågË/–_-¿Y~·ì·³ªí ‡rh‡qX‡sˆÃ;ê82Yºzƒõ;qêhàhèhähì8Ìq¸ãGÇ‘£G;q4u4s„ÍÇ:sï8Áq¢£…ã$ÇÉS§:Z:Ns´rœî8Ãq¦£µ££­ã,ÇÙvsíç::::9:;Â.®ˆ#ÛÑÍq£»£‡ã|Ç^9.vôv\â¸Ôq™££¯ãrÇ~+W9ú;8:9;†8®vD9\G#æÈw8
qÇPÇ5"G±£Ä‘p”:†9Êå¤£ÂQéîá¨rŒt\ë¸Îq½ãÇ(ÇhGÊ1Æ1Öq£cœã&ÇÍñ[·:&8nsÜî˜è˜ä¸Ã1Ùq§cŠcªã.Çİ{ÓÓ3÷:f:pÌrÌvÜç¸ß1Ç1×ñ€ãAÇC‡8æ9u<æxÜñ„ãIÇ|ÇS§Ï8u<çxŞ±Èñ‚ãEÇKÅ%¥e´c¹c…c¥ãeÇ*ÇjÇ+5µuWë¯968^wltlr¼áxÓ±Ù±Åñ–ãmÇ;w[Ûï9Şw|àøĞ±İñ‘c‡ãcÇ'OŸ9>w|áØéØåØíØãøÒñ•ãkÇ7o{ß9¾wüàøÑ±Ïñ“ãgÇ/_¿9~wìw³ªİ A	Z0‚œ ‚ê™B–PW¨'$Ô…FBcá0ápá¡‰p¤p”p´pŒĞTh&„„æÂ±ÂqÂñÂ	Â‰Bá$ádááT¡¥pšĞJ8]8C8Sh-´Ú
g	gí„s„öBá\¡£ĞIè,„….BW!"dİ„ó„îBá|á¡§ĞK¸P¸H¸Xè-\"\*\&ôú
—Wı„+…«„şÂ a 0H,®¢B+ä	1!_(
…¸0T¸F(Š…!!”
Ã„2¡\H
B¥0\!T	#…k…ë„ë…„QÂh!%ŒÆ
7
ã„›„›…ñÂ-Â­Âá6áva¢0I¸C˜,Ü)L¦
w	w÷Ó„éÂá^a¦€0K˜-Ü'Ü/Ìæ

	ó„G…Ç„Ç…'„'…ùÂSÂÓÂa¡ğŒğ¬ğœğ¼°HxAxQxIX,,–
Ë„´°\X!¬^V	«…W„5ÂZağª°^xMØ ¼.l6	oo
›…-Â[ÂÛÂ;Â»ÂVa›ğğ¾ğğ¡°]øHØ!|,|"|*|&|.|!ìv	»…=Â—ÂWÂ×Â7Â·Â^á;á{ááGaŸğ“ğ³ğ‹ğ«ğ›ğ»°_fUË òhñXóˆÇ{êx2=Yºzƒ<õ={ñêiàièiäiì9Ìs¸çOÏ‘£<G{ñ4õ4ó„<Í=Çzóï9Ás¢§…ç$ÏÉS<§zZzNó´òœî9Ãs¦§µ§§­ç,ÏÙvs<í=<çz:z:y:{Â.®ˆ'ÛÓÍs§»§‡ç|Ï^=y.öôö\â¹Ôs™§§¯çrÏ~+=Wyú{xzy{†x®öD=9\O'æÉ÷x
=qÏPÏ5"O±§Ä“ğ”z†yÊ<å¤§ÂSéîá©òŒô\ë¹Îs½çÏ(ÏhOÊ3Æ3Ös£gœç&ÏÍñ[<·z&xnóÜî™è™ä¹Ã3Ùs§gŠgªç.Ïİ{<Ó<Ó=3<÷zfzğÌòÌöÜç¹ß3Ç3×ó€çAÏC‡=xæyõ<æyÜó„çIÏ|ÏS§=<=Ïxõ<çyŞ³Èó‚çEÏKÅ%¥e´g¹g…g¥çeÏ*ÏjÏ+5µuW=ë=¯y6x^÷lôlò¼áyÓ³Ù³Åó–çmÏ;w=[=Û<ïyŞ÷|àùĞ³İó‘g‡çcÏ'O=Ÿy>÷|áÙéÙåÙíÙãùÒó•çkÏ7o={=ßy¾÷üàùÑ³Ïó“çgÏ/_=¿y~÷ì÷T×¾0ªzTÆÿı¿B``ÆòÑWtoÉÊÌK”$óãEÉXYDEœ••%Ê":D‹c%‰d<¿*b"u|N¢(¯†±Á¤¼"'OÅ".˜$râÉŠhYUD"õê%
k±!‰’¢ªˆ¹‰’òDÑ¿u"FäˆdÊ%y‘¬€ªYP©—«,¨ˆGêE¼”–%jø‘ƒ"zEE¼~ Ì-ŠÇJ’‘ƒ²<VV|HYUŒG".-ŠVÅÊ†Ç¢¥‘Áªh¼aÄšhI¼8Ò¨Æ`aUy<·<Ò8å8,­(Í‹•å$¢eyå‘ÃFi´,°\[/MFˆˆ­%³“:Ò¶»Š4Kå5Im?# DGB‘†©:¡Ô¸vÁÌ¤¼Š´Nç>Ÿ™Ş¶!3`ØTi˜^²<3ınÃ¥.V‘zéÌÕ™é¹ïgáJj€Š4J/‹g¥Û¤">Uª"íÒJ²Ò‹Æe6ê¤©±1¹*+İtrVw“Z\ca`*+ıú´¬È¡éœÑYéñ÷f¥†‘º£MÍ±m‡ô–g3Ó“6eÖ;·e¦ß[œ™>k{fzUaVz÷Ø¬Ú1>şÀ¸dJV8;àªJT”…Ê‡UDóBÃãE±P²0ŠÆËB•àå¡hY,”S‹æÆòZeõÎËMÆ+cå¡ËKÃyÑdsp»Aº„úD+cyÿÖe'ŠK‹bµ—EKKcEå²DEAa0°®1Š(ŒV”'kı…â%µÒâx^^Qìùû«»ÆïoTÖ?×Öyá±d(™¨õsaÿÿêã¯.Âµ{êSQV ª(IÆk¶ÆŠâ¹‰Ò šÔÊYùßïşÅ?c©IÅÚ şmçï×n×ô¿ şg 
2ZÿiÃEÑŠ’ÜÂPP˜É²DQ¨,‘(ş['¶ğÏ`şwIïŒHˆ¤¦ÛHfj¯îÙ²{(ÕÌôìJõ7=;„NM3=+Â¤êÛ§„Mµ·=›„K°=›„¤F |jîyLÀ©“zE×(§w}gÒsªMz_o›?À¦ó‚ornaÓ;†»ôŒ±.İ=GÒû‹%=q¤»o–ôì}’îg|jéîTå¾tß*]o«J×ŸkÒ«Ÿ4áÁ­³£¥Éh†—”ÅscBƒÛe'J«‚óM¶ÊÜºOŸ‚d«P²xAAy°_,TÒ)V*—T$ÃAeÅòÿ“n,^P˜< ı7Êá[n”^YEII¼¤E(Q‘LFCÉxq¬Uè€Ï`Zğ_‚
!÷‰—µª9šlQ„W»¾$êWM™Y[áU¡òhU {ú_;n×·0VÕ¢2*OFË‚dEC9E‰D^U7Aºç%†—4õ^SUşËCAMEı+¹ÂÉà
R+PŒ—;-/®+åÍC½b±ÒPtÀıKØAÔö*‡G‹0ÿ?Ğé”×J­ZÕXûó.ZÕ¸‰æ¡õ¿îrp»‹ôš‡jÿ³½qDŸÁ®®şÏCpSùjÁÍæ?Hÿåàşù·ju#uÓ“¾”ˆ¤Û/©>œóÂÌì‡.–Œ>#ãÃíÓ³› ‡}25»Aâ ?-{Néú÷«¦d{€>=Õ&’î;¿ÆNƒ¬6Ò¥û~İ¢™ÙÕÕÕ½ªËUz}#~mı…22FvËÈİmHëü—§·SóWÌ+Ã«Ïî”:1Ò©kCŸñO:³;néî:fGGiôÏJ3¦ÒiÆô&2‚ÿ±cÓ³5‘ÀYöÎêg|3eï¼)j„ó6ŸÖ­Ë¸Æ>ÕØÏlì—ªóÇ•ªKF³J¯ççŸŞsé¢Î5=#c{—šşÑÈ©kzDe½xö×‡/>³NËìÎ‡·i³0<pÒœpya*x¬í’º+QzÒ„VÙa}İŞ‘Ù]õW[×öê,>eÇã›ïZW£––™mÖ…×~Z	gw‘/n^¾¾¸Gû*¢ê¨–ühn¼(¬’È©›ËV%‡”WˆÊdêÊãÿÜ–öí¨“1zô„Hµé–š¸§Ç9ú¿LlÚ9”Z`‚9&µĞŒ[`Î-µ>ãÌ¶¡‚²XIğ4$'xË)%£E‘ÆÁO2§¶¶edT_QÚØÑá.&U]İUÉşêQá‹**/¨aüó,é£­ Õ˜óìšy0ÉZÔt\p"G×`Õ#|»¥ÖgíáÏÿ  ÿÿZÌÓÕ	vKƒ}µHŸ³½Ši¦q»¦	ôÿ90QqM½}=C-Ã È BD¥×û€[¯7+PÄ¾àJ}0(¹8306ì cM¥                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                !      3Ù5       Voâ 	ú launchfacility_b                                                                                                                                                                                                                                                525 nightly Wed Oct 03 2007 06:03:10PM                                                                                          british                                                                                                                                                                                                                                                         levelshots / autosave / autosave_launchfacility_b4              AUTOSAVE_AUTOSAVE                                                                                                                                                                                                                                               profiles/RUXZ/save\autosave/launchfacility_b-4.svg              d          5   3            t      Ã      €    xs`   ‚ A&  x|Y[wÛ¸F»Ûİnn¶ã[œ8·³—öÍ–-;Ù'¤ı	}íHB#’à‚ eõ%ùiùiıf@R¤$ïÉ‰4 sıfú÷±|š˜™nr¿4º²åÓY®ë¹J)ubÓöcfÜÅÕåµ*¦?Ä6÷Ó›Ç3§Sì“´ñ»Z/Ÿ4u¥ê,7elÜ÷z1ığcdœñ^ÿ­˜\N¦ßÕÍwØó}z}?çv¯t'ua¦½É(]—Åº<)¦|e»Ï)gf¹¹?eâú¼“íÂßã\¯
ëÌ_ã©«%ÄX1!†ªıËÉN9!Zõ„è$ı„ q
ò÷:
ÁZ
=%+*DPÛ¡,şb;v‘Âà7YˆMe«4Vv«-Ä–â*DÒ\²êBò¾bä×#ÛBUYeÔô~rõQÆëüpH•¿ß©‘vÎäÊëR¹¦ö£­×WaçÈâ¨P¾q‘iYŞNÏ™c{çêçgá‹Î«ª¦ˆ’U¥sÂ4–LNï¯nnÂGY|¼^˜ŞßN;ò¾(Œâ“³¼±s]¦‡=Ev$eK<WQS.ŒS‰µNåfæa†1Ñ‘ØÚG*¾Šó#ßïï&8Ô.«kÛäe±¿eñs¹aêT×AqV2° -ÜZ›¸q™_©˜Â^³Ò²s<Â\³øE¯c¯b¢šd GäŒ^(xW*ğgVSX 7X­V”@
;[§!¥M‰”‚Ïƒâ-=ÊÃ‘¨Ì ø‹­õFD±*²<óÚ­¼‘¥¾•)»
şx;Ş0^_fÎü$â9{êråÚäğıXnöÑ&)¨Œêï®”ô¦ö•öŞ¸²såÕ8`Ë›Ë}1Œàròáö,Ø'×²öYëÚ¨Èd)şféS1vÚ›+¨>…˜2×•·•ºR¶2å¹8ªŠS©L#„h‡mïDåìg{À$mÙŞñ³ˆl‚h°E•Kã"PÕµZZ›äºLTl4{ı5Sø{NFŒÔ —ú[be+¡öä÷ÉDE¹Ï{·:áÎF<n?şİ@¬Vª¦.b5³.6ªĞnñ¨ãˆRpØ}ş©ZBYª	²U8ı*æF'Æ¤ë¹Í¡ô"Óz¡Ø_£ÉGãŸ·&ú.Kà,]fğ[q}¥ìîLŞnœ5y¾tºR|I²>Ô1¿ˆ¹Üô3$+G×™í“³õm½ˆÜr³ß¶ä«ò¬¬Ù¦6¾ë¹µ15v6o‹Ï·v%(§lI¹R³Çk¨@?ë¾´…útı½4y©º© Ÿ¿_×I8`àvı¢¿k@-maîÛãıÑéZ…Áx®“ûã>¦PMÃgiK… 
_ğ¥õ} [åmhÖÃ„Iõÿ^vzS™º¦ô
‚umÅ:—&¨=yVõD²ŠAØï“Í$“ú=lL€DLx$¼N•EÉÊ'Œ)ŸQŒ|æ¾š¿~›İŸvyÙÔjÔş¼fáæâÛN’bšJ‡<Yw\*4½`]3ôSw$ˆ»Ì,Q2Ü©kÙƒ
 @F¨™t :Qü|Íòo”*•H ¬³+“ìóz[(ªÌÄÈøC)WcR‚ÜÔ@R‚%òf<U6úŒê@	· Oà¦!·+gµWZ%H½ö¡¶^È¼Gôç(@!GÂÖ?áoò’İ-Ÿ-ÚŞ¹Yó
[ÿ„WÄ¼>ıCRšR@õ‚ X³Rsİ¦nØ
ÌR5¨IjaV‘Õ.Qö[ôùøt…ÿ£µ/É±ëßÅ§÷ÒÜW¹­3[Öú^¤)Ìäçª§Ÿ	«‹¹ºé•ª½Ñ

É,I´Ük¹µÕ!–h%ìşô)LBû·ˆRÑş·»öóŠr(W¶8EVÇin—!‹Š?VYşÕÉ
ÿE®›2û&2Š¾¿lYÈ¬	]÷2pë—d8Â
u?7îbfSDDª4#ZO
Ç"¤Jr.—uÒÃ„õÜ.aÁ%L¥ríRÄ/KİÒëÊéÕA¸º#‘5©ŠJÍìF1(mV›ã^Š5M5É›p<´Cl‚¶–ñ
uØYQéØ×mÚäèæÄ1!¦G¢F¨æ†:‰úBF©br;&3v<ÚÌTÂ±Áf‰;™0;*m/ŸÒåè¹É«A›XNÑUdå¢¥vĞSÖÆ½%@«ên´
˜	}E×ÂG¨s‹÷¢kflg……+VU“×(Àìpo±/teí.´Ì´m¯½+X©p8"¨,-3¡ƒDaÇÚE[·›cí¤º®¡ b¡ã±&#%¸Y(á x*ps—œşn’oÚ:$=».ˆÏ‚Ë;•0§Ö ™Ã†JLóoì_Ù·˜Š•êüíp•kAøó>¤¸‡çD4IÁÇÄ%Z\w0ŞH©9ºšwöÌiö›öß J4köß1”¼èÙÕÄP,í<óêË$ŸÉ«k*˜‡ÄÕdğy:ø|5ø|Ó}~"&—^ÿĞVÛ/å3sñéPšÂ«™.ƒ;Uk˜AD 5f FOàçMQ½`ºÉM¬<"¬FWZé€&÷ç¼4:R4/%+òIË0«©¯ 7.Ú§S(µs[ÁƒŒñÏˆ&36ô“õwô†Ïù›Fıibõ>7'’‰} e"cªš¹3S.* ŸñNûÆ™:6¥Gx6E›TV&è_]¦søİºƒñÓ2l±Çœ ˆFüİI0A`Ã’½$U#0fe# öÎ¸(X3ĞŸ´È‰ş«ÌÊ/éĞKÿŸNÙKè[¶VÄ;Ô3­0z–{"5HPˆ	Ãùµ¸.g:ÆÈ‰Y:¢)	¿Gİ¸3O×’ÌùGU¥†©ß·GÃIÉGÓ3Æ¾.Iá¼è¶:à˜È°|û|­_Ë K`ÈËÄ/¶ÕÊ£ø^”˜5^nópM®tnœß—kiQ×¡:òƒb[Æxi2gÂ5j‚î½½BÍ t `ñÂ€Aász †;#
¦RÂ_¸mo}p¬2şœøÊkåçxJğĞ
±âİŠÊÖ&9…éKåĞkt½Úä—‘F¯ïV04gXà¥	kFÙîˆôŠ*&4¹¥a°HCm¯Ê*~èÒ›7$ì‘Ö@×ÎaóÏ$å1OÃë]©y7ûC¸¤(M°¯w6?²”aJñÁ¾O‹+:ÛTûc'é	kºœ¯¶oÿáÔdR`ÜëÂ¸kA®.vØ7“‡\3p¥k"Ìs{RhpsëÓ¦D-ª“Ş{TEæ ª Š@®¶ˆªı
)Ù-Œİ}50l¸,øq›,Ùnì¨kØiÛQMš¯:4ä•g‰Vº>âŒı£Ñx$®Z,¢Ü¼îÕ) ×Ä¨Õ½V·­¶2C1T÷ö¡xÂ‰Şémæ‘Zßò|Or¶•x¡S&ºúEˆ<ë(ıb‹¼ëº•—a%+©n(¼>A~•:€'ÓOÖñØ]Àöy=:„WW¤AV¦kK#õ0?PY²ŠúÍ*nÕÜÔòÃáú.=%¹è¢‡%[©zIü™´¹‘%ÚÁUÒKîÍ¢OO·#;u©š\®ÈQt}dK]ÄXW¬-Å¿;ìv‘,Õ‡İ+¥úøĞ†Ş¶ER‘´˜3Œjm¿–Œ‹ğ
›a¼á<»Ü™g’1° £±bC/r”è|eë9¦½zlàö’6N²5•<ÒŠúph³63¶ıvD¸V,êI „@-¨JÎlQlCùÈ¯7ÍØ±^/H{1göG8z¯;G.²<G§H3Ô“ÍÈ"e¡º#-Sì—Îœo6O„©õ^“Ÿ('º\P¡¿C³ºÓ©¤ÖcµoUHâë¶dÊQÒ²3z6ñÛ¶8®‘9İŒwÏU†‰ŞŞ$¿îÚ˜+î#Æji"½
E@Æóè	î(WR›•¶ÜÁ„ú‹Ïê¸"FûÄ.Ë§BöM³ñâ™ 7~?§ š7¿´PÉÇŒüÜ§£Øì‰ŒG,:ËÖ(d[Â£8Tnü&ˆpB±°ê¸¦ÊP9øâ/†ø÷ˆ—
PDßx¸ÊiÌŞwxÃBÇèT‡æcÒÒ¦¶âQ!1Às8vC·ÄË
#LïÖ‹a‚b9tÌõ%ÜUïºW6»;Ì.S©¥“Ğz[X‚n7}±;6¼ùZ¡H"ş7%Á)ó@£ˆŸ#æ~°†vú‰
#…:Ñ®«³û³]‚ šgÙºÊMõÙdf7¸­k±i‰úDƒË$¿àš—K»Vli~ËÁİ
 ù1wGg@Ù@‘JÿÏE—ü›‘jÑ«~GâIX£~¨ßÖ¯‘È)ü†¢yC,ÎMÌ€&ê£0´Á3ô¤’(bôCãÛ±f‹¥uJğÌ?]ÓOïZ%v¤áAç…­=½2í
ÚhÌğm£DŞÑùÁ&ôƒÔÖ´tÄÃ@‹ÿ  ÿÿZKO1Ş8´RKA}\
J·-=6!´p2^ï$kÉ»¼N(ÒP Q!B<„8ÑŸÖŸÖñ:›&¤ph¤HÉÌgçeïŒ×ÕèG7—Wt1êJuº«qm-_8¸£ëypJ›+º‰Ù•¯hc¹Îûc£ÌdYOI5¼Ù¨Fµµw¨	t:>8©ÍqÇƒ~ÿçİLvçJÇ“`w‘n¨OäO‘!ùh9˜"\Ğ~JVO#%)¡N©êp¸·%hÌİsfÿÌÑ‚òrl!¸%­ÈØt`^Ro•Ú™·®”9£cÏE&u†–Ï{q÷—y?pë¢†ÃkVXnl{Ü@ª»,cŠâİ\¤¶C±TÑz¼«l¢µ)&0&tnVFëìU…ƒBğÔ'ÿô¸Õf)hó°­F¡{`Ş° Fv,¶ä<L€ÛôÃCjÑ•BWÉê3\æM³«Õ`øÑQ:‘y{J¡Æ“¯Ìò™ÄÜP^øÇŠßQÜ¶´ÉP¤´($óX](½—éO·O‹©˜´û£t† e rtËÄúêPƒ@¬´u9×#¨MB=b^`ói”mMÔ§ƒR²¹`€º…6•Æî¯Lëæ×C†ÈÉg) h~™g“C™ó¨%€X³ÿu×%wğ„Ä òXK!@±Z™H§ë,.°­1¦¸Z+3|+)¬T
¥ˆ3”Y‡ÿ6dS^ñ+OIIËš¤ıC»–VäTì)~Am~?ÜEI9Ãû*¬yKÅc
+Ÿ3/=ã]‚çÔ$hQæÜ[—uÿ÷=v×>Ï†Ô½Á¹-j8º®›D»†…ãä§ÛÛ‹yp#¬míl77¢òSÛş¾Ù¨~¯o5›ÑFÄ<g½ñm§b=èõ’ğ¡à°F7®áø¹wTÂZ=Š‚èæt“Ğ  xíVÉk#ÙÖb[ò.ywÛ=Ò³2¢$K^Nİ~ZZW,§'	„â©êIUíR½šZ$Ûd»3$„ÀrJN}L&äÛäàé	Ã<9Ì9‡@r9Ì1à|¯´Xv&€-$LÕûmßïû}¿w¡ı1òÑÁ»¡‘à¯JÁìÜ(õLE«PE7t÷Xş°|úYşÂŠ.NS…Ïñıùéc29Au™Õ™éætÇ}ê™%»¤/œ’ÒkdjÒ–‹»[zUsó¦ºOUİsH8”\_!q§&;Â€ª¼‘…f“ş>i	¼t=ÛfnIáû1çµmİ$ÁóÌÔdo¸ÖÈ›¬vŒxI)•&ñ˜æ©rMw›ªL…‘46ªTe×¦
³ºêjx–êIØ"A“9	½N¦G†q¾Â¹ë¸Ìrp:é‡¥ŠâÁÉ±(´¤Pƒ‰7±ñ:ÓŠz@í*ÒÕO\,KCƒ.kºÊ¶©…cÒÈp«Ø¼IË-Ã¹ÙŞJJÈÕT˜ê£|Rk€ *Wl™ªq¼CkL„>ÉŒ$I$qêò‰É¨İò®hÔ2t3«1êŠ'³3¶\ÑÚAƒÑÃs(à¤.PøR"…¶Ù²ªW*Ã²Üàv·Ñ‘ª,Zñáu¦ós¼ÎlÅì<ºÍUf| »Ú¦©WÒD¾o´Šƒ”ô`v*(y–e`¤àÒªqv¦\•Ë¼¼QCö®§²’KMU7«dxHJHÒê’ÿKÌ+¼fQÇÙ-¿`Š«×Y¹è¯ï
-“l¹jğ†Lü2Uv[·\¹Âm *»•¦ŸãüÜmÇ Z‘	: ©÷W%2:":_Ga¬˜Dü=
j†C™d
]Á…{¦çË)Ÿ5×çlşbO”Ö*ıfÿm¶mé.CàTf…¼õĞÒ¹jÓ:¦/«Q³Ê> ‡Ì³®Ç(%‘™iUÑ1è¯Rğ¥3&¦¥EÛnğ/’Ÿ3E™Ïu1,(D3_© ^Ayl²#w»5NÃÉ‰Ve¹‰™r\¸K&Òä$éQÉĞëUi|ŒÖj<+Àavd,ƒ3p¼Õ™uÏ0™-29ĞkLŒõ*È>3Xï < D1ÇLñjßdò@?€©ğ:Z±’ŒÚ2÷\•s10ÉÑ´]vÃéòÍfªî'z1=…º@æ,ƒÔD‚Bwæf{ ,P•=3w=÷ îa/%’äÑ÷n¨„b£AyµÊ²­YÄêö÷…"ÃDÔuÖØÔ•Ã}¯ù>Ò$2€œÅˆ²‡‡4(jÓFñ9ñ 2P…Ô2èµ.‘±Ñ?à4Îdâ±.zLtê œåTÏóo˜şóà¹4;S…–šOmf¢¤­Ñ*+Y­i´ev ‹TŸ3MW]1<C¬¤Ğ×® õè+üŞLÍ‹uĞ´•U^úˆş‹@½Ó÷‚n3bpå0ö•L,¤!²ïFÊwôÙ#;¨ŸÅÍ¢nºN–ç’%÷¸%¾q«Å;Çs\Ìï¨‰ˆÒÜ¬-b*|İ,yfQ¡7Ü$ƒÑ÷—3K©u±†‡0
ZGõª‰Æ”mİÕ’-ºR¥Î6uw!š"Ü..´[×•/t#ç¢ÁU!¢hôÜ¡u¶k–\j»­µ‘Œw;V‚<_»1†9j @24(%„^®e–’P…Fîñ³wÍ.—ñZLM{1ûÛšz½¼2¿^<Ô/“«¬["ºO¡WàÌØ¨(İÑxîÚˆÇ„tv6|©3iş8w‡i²øÚ®!³ïanË(’kdz
yñj‘‘Ò>£ê®iˆå¿’LgpÙhGC_VÂ&Şë±/Œ}—!³3í«>·=ÃÕ±s h4"%–WÄç5#\”ı>®MÄAÈnæZË„Ò¯¯Œµ¼MZ=í/cQ_å+ÜĞÅì0v ÙÜ«j"}hgËóª/]İŠ¤D&‘Ö×°ÿ2nKÉë’äİwê½w»Ô„p×…r`Ú´w»Q¦Êá3Ûí÷j
sÌMÙ=¶X<f-%Ôaâ¶±”›Şyû;î‹©F˜»^ŒÚâÑŞ{bí`øU2p¿zcÔ˜ÁXîv‹DÿÓäíGß™Å«ø×Ÿ™iŸ* ¢íßK»È¶öôÔ¤¿ZË~K–n¶h<_î.¤=jç¥®¢uÙšõ˜cÙÙob5Àì6ÖB˜S¸£öìPl<fûOáªÜU±-¦?Ô£#É:2 ÀZ†<\lwÓö¯Òo ìK^á/:[È½üŠü¬İ}RÄ“«½À?O_äŠá—#äe3ú1®îdòoüïß~9Pøêl/H~ßŒü$°Æ‘ßàÈ#ÿ¥8ôàã¾†ÎşlFo‰âÈÕT ğ÷|ûÌÀ$øÿ…Ëœ|lÏšÑĞ×——›I˜É|èòêróêdîÉïö†#Û¿İ¾:ùw @ŞºxõÙèÙ_Bd ØöjãåÑk¹ù&!2|“(¾W?}|Û¹ñÁÓÇÂø¿Qa|öÃajÙ¾w§­ºÙ±µmÿ5âÛZ³Â6Ü²ıÓçwÅİÚíØÆÛ¶—1ßö“Â¶¯Øşj#{q—iºÔ1h›şyÊ7}5.Lû›ıÍÀıç{î¸G ƒ@4puÕlŠ/VF¨ß|!Á‡ï}²û×/¿ÿ2øÏ¯¿èıÿŸDß|š‹ü…Á¼J x¬™lUÇï9ç½·?·u5€	6\IÔ0ÒD$¢İÛu2`ül›1¥İJh°î
°¡İe°`ück]5„v×·Îk	1†cŒ1Š'ÿ Ìëó|Îİ=åNÿ‚Œ=<?¿ÏsŞóûî–\ÚP¬TÒ%%‰¸¼rN	:DœÑ!âgÕ¥UI´.T‘°ÊE?8b#
~ÎKffÆ™²üM#h£@æÕ8Ä&!T?€·Î]aÒÖ'+•®?}Ó†Ş¨Š¼„ÁiSª
+~Íj@‡‚ÕCp¡#d‹"„Xb]:ğæk^Jct‘£\pøApÁ@GpD` >DÂê§zü¨ÆN¹è TeeÌå½&“x8âíJeöÆŸ›°’÷ÙJ¥4´Ç¤8€H8t ²`%báB]øa  äèÂPpÁŠ"~XÑ]@1 CÌkÛ?[`S|1ÂBpHG/Ä£=/3*ıpÊ–÷½oÓ&f/~XMÌ¶¤9°	‚F˜V8BÇe«ƒÕúfÚ\x¨ñ"Bò@ÔíãC65šøÜÇåiQÍ_şiS<cÃ@h­³l²a=ñhVÿÙ£U„¡›¶TéÏµå¶vI/æÙ¥ÎëL0´³8:c8èBUê‚óÿ2°!TGD“¤)k»’|VË¡8æ.@:¢ÒğXRşãk.ôÇJC¸FB»ÏMÂHÑƒÃºÁ¡£¸H°ÖÕòH¥©“òü“ŠÄŸXLV\D6:œ±B#(ˆ‘ #ƒƒcÀ P'‘:%,tX!8CˆÄÍíu³j¾¿-)_qyuš`A@ TDj#ˆÄÔ‹k….D0"ÂˆÀ€H‡8†.ºà<Ç&"}–èšÌ§ºÁgnÛ’/Ø“OqÇNIÄÀa ¬,Ó¢Ú6Æ+T‰". DkXA†àR×]ÌA"xD Ä‚¼Jı#Æo5ş‘ÄoOü£Iñ±$mRµ7¾dıqëÛ_âü¸ów'~}RÜ”¤jß”øm¸ˆcq}’¶¨ecâ÷/vQï²U”õ‰¿XŠ[\Ê"5ªëÎÿ†ñoÒøYãß1Å\8E¸[0e&Ï,h€Úi¬¡yÅü–õ—%ş*[üºk‰Â.Ò®‹DØ-ï¶~C¢_äBÍş!çw8íœÌÙè³Ï}˜O[•ÙÕ.Œn¤]§
A³ï¶BH¼5IàªTÆÿQHiØ{…|Ú¦LùÃ*óK	c—Rı0(tq5×xƒMşC‡	Ì}™pÜ1—ĞzŞ9›¿}/^d¢uiß´h¤km!Ä’
5D14¡íDÅ1‡M2n<(•P6Z³NõAç3~Œuf‘ıïŒouş§«ÍV¨¹Èn­ğ©i`0áXGĞ©“¡§¬-+ç<šbâˆ„Eg²a@Ä«€úàpF„08HDÁÃ8âüûÆÿÇø&ëWZßcı*[4Õ'‡´B”.KI†Ï¹€æi`¸âJykPìpá Ç02t@Âa%ƒ§'è°2 É
")q ÃŠ$&g½ %~u)1Ä08q†äèÈaıÑ‘‚H<b!œRp (D¤Œ„xíü±¬«>†¥ÅIxñ'şôÑ›OéÔxR~n«œÂºzÀP[^/İ¿ëÂC*€l`1 bˆ8s/šººú&' }È¥©9öõ&áW@z˜=õl8K?W(¿şp!m‘§œ¾šçæ[úàùòğ+rò(Qà†:†ş¯Âİ“ÉRÚüìïGáF… *Š$/çMêl¥R¹~4] ‚ßnô}´×x9Øå­Şj:ÿÉã]ÎüâÆ$mÕy}‰»¼
Ä]Ş€gù7TçÂÇÕæ\âJÀ4Ù«ÔN¡¼VŸ1şÆÿÚøß¿ßúÎÄ_šø—]ñ¹Gkêšım\öÙ`÷¯8ñ-^’¤l5ıìß3şoÆÿİøó¬?ßú¶Ä°>³ş„õ¿°şMë'œŸtÅ£.ü<f½)˜Áò°Âa`€,Gt‰VêÇiB³p¬
~Dbá°ê— ÿ‚õ?qÅ×\¸s`/Ö9ÈİBÖMæ_[Y½‰?Æ…bîŠlár²ÃéåDÖ…¨œŠè&NÔF	Ÿá|[â¤óGòù8Ëb[n$uc Œ›F)"{t —X5.aHú˜Àá<" À¡£ D"°‚G^ ĞQb´b€ £ÂĞA0À‘ƒ”L tDP ‹µA(ÖRĞc¨­!åÅµ›f¸»âİIºHì3Ÿ7¥/´Ë/N94J×ŞaÊï<%_D˜}ë|a–,T3‡èî
—“zãÔgFR=3xÀÚÔkîÖ“Xâ:,[‹¬^
å‚Ë¾«gNñâä´‘ktØ¬ÒÑ†DO›sjUÆ©°GƒƒĞ:apˆ,VN—åÎÅù+œoJü•Îßâü­Î¿èŠ«¯²°K ¬8@@(	?¬ä#"ÎLˆ „qÖÅ0ü°BpA\ì}ÂáŒˆ_äˆ 8H´’xT…!ºÄX²áG6\àKd¤f÷»‡ÃŠ ;–IâÜ¨¯à¥{Rî¼µã+¬Ø4²cä7”¼g¨‡(
€€	:@˜:jÄ\P  DàŒ_]”Œ‘”p¤€˜gr@bDÕ[‡—U¿y€À*D‚7 ÑÍ“9ûgÎ¼ß>óî“7ä¥Ix÷ùK¿,)v$á·Õÿ9¾å%xöñı¦|°ª=h)¯9}ñ¼hıëÖÿÔ_­~*¢óØjäb¸P<pÁáÓfaS g@€@ˆâ9€Ù [æÀ |ÊÖPôÌˆÄ³p„B¢èèÈ3:ıì÷ä;Ãµ	6ÆAKé7LÊ·®óª¿+ihzDZE„c[EÛ‚0Òšr"‡!¬†€¥1fGVàë8üpabˆ€×Ù½õh˜YU¼óùpµ& Äøş¢KBûTÀÉ‰®Š1o4àÌü€¢>ttNÍè @Q+ç9(\àbõø!V@Sä!¸Ğµ ƒ° ?\Ğé÷‡òÿšûL2<ø$“ß_©èã€š}îëTŞ®áD•7±¼TÃ¹¾ĞÈ¹Jsåz)§¶™¢—$
H{Ap¤Å@<ôÍú±8B8&
%pzœ=Â‡µQ¾­…k÷¶¼|KÂ×·â£òóCËdáI@RÖXªÁª7¤¥§Sı7
ş¯q”ƒ™Ú‰c}Ğ!âÊĞ ™@ì[Ïñ±ıù.³²%µ©+}<Ñ^ŞÜqèú™_|´'wêHoÖkòŸûZ×T{ãw»ŸØÚXZ`†ü¿=gÑ97-HÍJãG÷#+ä¿í;Ó%¶ãĞM3'oïÉ¼œuê^€Fv
_íÎ¬àõv¯2½¦Ût-¼É¬hM–¼]sÍ²ô®Ñ»Fs«sÇ>²£¹krO4¬œ72¼îÁÁûrù{–_¶¼3—š[òÍ“§û³—ÆoïÉåúoÏüT·oèèÌ†M—éJî0~Û…_<=½ô€zd“§û²—ö(ß'|-2Ëå¦ºs¹ùÛÙŸ­0]¶k^jR)ª§ãØše£9ıs·–pÑæïÜ·qäşµ÷Ü{×àpndãÈàÚÍî½÷şußÌm¾pİ=¹ÔJY«·L¼¾¾,ËZ5¸uzèõÈV~ozhRù>ák‘ÙgZ–“²ÆNÎËö>»¦¾,Ë;9?Û;¦ÙØÉÖlï”ï¾yVYîÓL+‘²VOÜeWİQ_VËZ=qc–}I=²Õ«³ì:åû„¯EUÖ§ZÄ¼”Õ²ôºéş[W×—%É™½Õ²ô†éş«Õc kYzÍtÿzåû„¯E~¶e¤¬%Ùìéko®/«§µä!—=}åÍ=ÿ  ÿÿ¬Ù}LUuğS™ÀM…@EÅ—PPò&
tî97&M‡ör8:VËò¥EÎÕbÊX–³Ö"ÊÚôb”İ[Ù›YİÇ4g´¶¢ÛZ¤›™c¥¶^Œ¾ÏØÎïwÎo8çş÷ıãûlÏsïå>WM³(¿á"j¹…Û&²=©°|-1¬šüT
}»ÆÍJ¬šü4
â†E5ù)ú‰³‰lO*,_KLëBJ¬Rëç±ã"U°.¤ì©ÔsÃ¢)TjÚàÓ’&“ËJkßÁ[ãÁ^ş$r°ÒkßÁuñà×Ü°hßÁµñàoœMd{RaùZb ¬Ş?âµ;Öº—¬Ş¿âµÜ°¨·ã÷xí³œMd{RaùZâ(°J##Ã¹¼ÇÓ%X¥‘‹Ã¹OqÃ¢ÒH œûgÙL.+¬ºm%ñ‚Vş$r°Ò«n[Y¼`;7,ªÛ¶ ^ğ
gÙTX¾–8¬#%ß†),1&ÿM-XGJ¾	~7"ZSŒ”|d£İE¶'–¯%ëØÇé]yånÖÁ:¶±h€ulI³ŞUÌ9JÒdrY—µky™®eV¸Y—	Ö®å¥º6°v-/×µœ£$M*,_KV q:\°kÑK+XÄ©pA'`gÂ_p’4©°|-qXıëÕOwc-NÖ8Áêï{D?ı`õ÷¡}’s”¤Éä²ÆƒÛÑÏµ8Yã+¶ÛĞÏ¿‡X±İ×êç¿ã%iRaùZbXtn‰ŞUSå~me»Fï2Ğ ‹ÎUè]·q’4©°|-1¬3…{õ–»ğïw>­LÁ:Óù†Ş²°Ît¢½•s”¤Éä².+ñäÃz[^ÄNÖå‚•È@c`%2¶ëmõœ£$M*,_KÌ«7²L§´eî%f	Vo¤J§?xq1ê\¯ÓD´ñq*M*,_KÌ+·ûm½9¿ÒÍÊ¬ÜUhd §•»ê½9È9JÒdrYÀJ½ú1½%ëZ7k‚`¥îß©·ŒD¬ÔıhÏâ%iRaùZâD°ªÃÇô†¯æƒ%ı©Ö7N¬êøzÃ'Ü°¨:öqÎ&I“–î¼©™}qÛÀ@ã ßŠšõ¯ÅIÀ…Ê²Ğ©™nÜ$ı™e„¾ç†E¡ûÑş“³IÒäP¸ç†Ë.¶é£¾g—#p±"4º¸ûuä_8ãÂŞ„<8©à¤…ò“Ûæ7¸ÆS'ô¶æb7n²À5®Gc7,j\Ro{Š³IÒ¤‚“Ş›Œkõ€›Üê1“Œà³Ü¸)·úË‰F°…­®F{/g“¤É¡ppS;Z9Ò¸ı‰¹nÜT;zrÃ¢£ ¿ÈÙ$iRÁ¹ÖŠ½‡û†Èî@b„šºĞË¸O£1†È¾ÔÍãl’4©à\kmş"¸î»Ä"~’<ë.Fc67,ê~y)g“¤É¡p/{ÀM®ª}‚˜Ë/qnšÀUİ†F7,ª:\ÎÙ$iRÁIkşïaÓÁ:üZŠüšWä`M¬ÃĞ nXtøgä^Î&I“
ËµĞW<<³|àzŒùÆùÓ¼"._àzF ñ7,êyùoÎ&I“Cá:=àf ·ò¾C;Î+ràfÜÊÅh|Å‹V¾‡ÜÏÙ$iRÁùZèL°j_®47ä¸ß¡3«vK¸aQmòZÎ&I“
ËµĞ'şş;tp›+î4ÚïçÆÍ²q›Ñ¸‰mnB¾³IÒäP8/Ÿm³ëÛ¼ÊH˜YnÜl7¯/ˆÆ2nXÔ÷òÎ&I“
NZ(ÿÉ:äáÉ]Ü–ÃĞFLvã®¸-åhœåUZ´åCäLn›$M*8×Z÷€+ nGæFƒ¦Œwã
nÇ7Í‹vÔ ]ÄÙ$ir(\“‡÷éœ/M»î&£kl¶Û6gĞö`S^Q*
,Ò¶#çq6I»ypP¡¹–ú©‡ç6ÏílÏj£ı¹<·mî ÿäìn4vrÃ¢³Sn4Ú;9›$M*8×Rß÷€+.pïVãö}üw|¾
\`/qÃ¢À»È‡8›$M…ûÀÃR‹€kÜ³Ş¨•_ì\‘À5®Gãnàëå)ä÷9ãëåäÁIçZëIOnpé±›¶ÓÜk'pé÷ QÉ‹ÒE®ãl’4©à\k=â7¸ú&£v¿ÄOn¾ÀÕ7£arÃ¢úÏ8›$M…ûÈÃZ‹kİºÉhYÃŸ[\±Àµ^ƒF57,j=€|g“¤IçZ«åw%pâŞ”~øÓ7^)pö¥ŠÚ¾Tñsƒ4©à¤µÿÜ°Ä¥é`-,ûFË¾QÁ’&“Ë
‚%®S+(Xöu
Vìu\¤|‚%M*,i•ÃZW%®Kë*Á²ïR°ì»,iRaùZâB°Ä]é`-,û"Ë¾HÁ’&“Ë*K\”V‰`Ù·(Xö-
–4©°¤%òW¢¥Ş‹€¥·Hàì[8ûNšTp¾V¹,qK:X‹Ë¾BÁ²¯P°¤Éä²JÁW¤ƒU*Xöı	–}‚%M*,i•Ã?–%®H«L°ìû,ûşKšTX¾–X–¸¬rÁ²/O°ìË,iò¿Yÿ  ÿÿ¬Û]lSeğÁI” 1“+µÉŒò¡nÉ6X‚”½gP¾
Œ¯¶°-Œ•ÁfpÔ]ØìH$Å…!„ºøAÀåM0jğNQñÂaˆ$DI¼òÿï
Ïó¼œvI{ÎİÎû„ß÷íiOóo%é•y`ñ“£ÅšÇ,zæ‹9Á–¯MƒÅYÁÒé0³(ëe}ÀKÛßá–¶æƒÅY‹5ŸY”õ‹²>`‰Î`YÀâ¬ÅZÀ,Êú€EY°D§‡åk‚ÅY‹µY”õ‹²>`‰NË×+qXœõ±X‹˜EY°(ë–è–Õg},V3³(ëe}À–¯MT`qÖÇb)fQÖ,Êú€%:=,_›è‚Å‰‹å2‹²>`QÖ,Ñ,«,ÎúX¬fQÖ,Êú€%:=,_›¸,ÎúX¬ÅÌ¢¬X”õKtzX¾6q	Xœõ±XK˜EY°(ë–è–‹³>+Â,Êú€EY°D§‡åk—‚ÅYñ(«ÓK™EY„)ëãÄDÖ'îaùÚÄe`qbÇb-ce}À¢¬X¢3XÖr°8±c±–3‹²>`QÖ,ÑéaùÚÄ`qbÇb­`e}À¢¬X¢ÓÃòµ‰+ÁâÄÅZÉ¬?îg}À¢¬X¢3XV,NìX¬(³(ëe}À–¯M\'v,Ö*fQÖ,Êú€%:=,_›¸,NìX¬ÕÌ¢¬X”õKtËj‹;«•Y”õ‹²>`‰NË×&¶Å‰‹ÕÆ,Êú€EY°D§‡åk×€Å‰‹µ†Y”õ‹²>`‰ÎñXæ’ß*ø‚d-pœÛ±pkG‰à(ñœèôà|me;XÕë.¹nÿç:ÎÙ„Î76§Û	TS=×¾ÃµìY]ı*ê©w]'{F‹}¢±‡“Jı¸!dı$ììîêÙálíìëK¦·ìéJ;Íë hxô37Ô5_ÒŸë?³ÇTz3n]rCqŒ†°0cê3Z4¹úW4ùs¬‡#Zó¾=>ıÈTf ëI2+zòˆ}Ë\ÎèèI,=gê~-Ú°C•ã4v˜©<ÄS1Gçƒ
Î©ÊæHµ¡˜jH¨r¬Êæ´ã”T½[j#T¡¿şQ¡ö¹Ö¬6²*´—[ÌåŒíûW…’¦î×¢m<Õ•
T›¤JÌjS1ÕPåX5ş¬¾¨@3ª›?ª†kó­YÅ„*‰Ë_™ËJş¤~75fuÿ^h+5«ò¿Œ‰K˜R¼˜S"¦tßSzJå{ğDë/©«OÕ#iÏ'<ÁèÈEuu
.;8á#Xú¢©qÂëQÚJÍÇ¼îğ;â×ËÍWm–*‡ï›‹©p7dL…»A=j£rö§:v·üØÆ¨f÷ü¢RWÌ‹Éz#ÙB°ÚÙ·¯«Ô'fEBÏ¾Õ?˜:¦E'`ş–¯¬¦ÓŸ*ı’¹Z¬f5ÍÄŠ§ÍŠ„nšyAé°©cZtÇ2;ùq3ëÿrë±´“q43<–ÒÌğX*:ÇÃ•ì·‚Å9XÙÔ—xû°Q¥·²‹†.ÑZp¡o;q…7A_¤¶ÁU5aDÚo’epñÏE·1«j0¯NíÄ
°ª±úMSçµè,°œ‡•ai¿¬í`¥¦İPñ—qKŒk;»RGFU¼KàJÁòC¦ÎkÑªÇ~/Ô¸’pÕ½7×=7½àâq%™U×Ç±¬ºïQnê¼–—øğPşéJu¾~†öl%Æ•b×ù;Óİp–Àu¾ËŸ7u^‹Ö‚KŒË—k\Ã›ŸsC5k³†ŸÁŠV¬ kø8ê^Sçµè,°‚×N°"]a÷Ú¶–×NvEfbÉ,+rõ+¦ÎkÑZp5®.¸Ü>7~}
\ü.ÔE¦Y“pù[s9£Ş@}ËÔıZ´ÁtPáUØñÀgÒòÕ.éŸvó	O=¥?;˜;üßÜá»¡Šôºá]æO·Ş~º	ViÅŠMfEBGŞFıš©cZtê±[ƒ8T¾î¤i°ŸrG'šÔ¤ÅJ3ëğ¬¸ó8¶7¡_Fı„YÓ¢3XÖn°Î¹„ÄÊgj7™fÍáòcærFıu©ûµhƒ) 3Õ#=âLõó	O=¥ÏTùg|<áƒn|`2ÍgR§Z³»)½‡PµáËXÓmÖdtxâ7~ÈÔıZôŞÒXs¼	o¾î{%ìŞ ¶·lHÀr£i…™Wáä
^…½àµeßqÃß˜Ã\8WÄëe^[Ö\4k2ºíêŸMİ¯Eo°së“°çÖ·pÂÿ   ÿÿ¬tÕÆïäÍ;"ÚÂÑºb¢IÈƒE™™½;A¥©
ì&&Y@7’ğJ€Lğ$Q#	‚Úğ!ìdöRk…*¡ŠÛ£ ¦*mêá é7»³; ZV8Ùğî½ÿùîoîkîî^¼ÇÆVø[nûyn-pËƒ=uy$+\ví-5•Ê9¢{!¸·Õ‘g`SëeÉ+qN¡êBèÕĞ|*õ+ŠMœ‘¸ç½¶V>Œï¥ÒéãGÂiHç-™ô™¹™s3òmöôY¶ì¬Ì™sq6G~'K¹,åßÊÒ?K¹~–rï˜¥¹°ÔfdÑNà)Ñüİ]+:æú¼l{ii¼™¶%@?í„6ÊXiC­6†ó½(Çsg	éÄg§<Úi·*Ç›?Â–>7v,ÉZã˜©`bóì^qŞäP'É”I'¬-cé$BçIÜÙb§¢$9ªK•‹ÊBš•º'…†Â…´ÀßñĞä»X¹z÷ÛLß‹ïÃŸ„[‚‰#A8BÆRá{JšKÎÚÃ7Še‘Ò¡ŒşF7úbîÜ¼ú1+şnÅùà¥.ÂÚ?ÃUd×|ƒ—Z‰´ãHãÍTÍ†ş;´Ú(¯‘]óZ ^ò¦œ9®óZ ¼şÙ½HÙb.TÀHwöúRÚÍ«Çšh–™‡ÄLßpfõ:/„#0/¯[q!x5?×5ıÒh_^Ív¤E!7Óf	:Ú	m”	ˆWBl×¼
ÀkR?¦Ä|©ó*‚u^8H¨L).Sâ›•KÙÂ7‹
|¬ÈŒ{i<ïn[5Ö»ÙØ÷àTk[E
¬²éí7-ŸQ±¨ÔM›Öë‚*Üâ(4P©»‘Š4Í©úh'´Q¨Â-˜o«+&ÄujP5HL‰¼ £Z$…øPÉùŠ²z¾"7+N9GP®;„!ÍîfE“ÙÈU_»QÉ­¬h5œj¨Š T ¨¼FÅÅ@5fÏ`Ö}ÔiF­Åª1­H‹Co¦c6C[ ĞF ºıQ+!¡kTK€j×`¦˜Oë¨–H¡:*‘Kú~