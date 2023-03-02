
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
     ,����ڸ #E|�E鼕���+<#|��:��:��įf�<�Ĳ�/,�_�6V�Zؗ_;������:��xw��%|�~	  ����A�G�{�Mb	Dr�����AB�L��e� F�P !ġ�3�;�ڙ�qOϮ7��'n9.��	�E�ȝ�op�{����zz�Z�S�꽪WU�^�z�u�x:}��2�k��t��KEK�z���+�_�7�Y��Z����ԗ���e�\0���H�d�@h�{M�[V���w��-������D��xϐY.�d+l	�<�x_⡯󋲪�la�+�5��W8|�7�f�H��/����7�$���뜿$ޜ�"%�t����h`�j#,F���>�>���8�kb���tR�V����V�,����3���1R�.��	o 5A_�F��9�ZB����ѝ�wP85��<�cv����cw��t���џo�b�ix<����a�\���	�&d<�R��{�pp�G�1pp�E�g������ n ŷ�&|���2�5�v��^�l�M<��[�g8���>{pO�2:���F��_}����o]=��PB�|�!��
�s���%�75�{W��;�l#Ga�O��2����s�9�&1SB�������],���_���h��٧?��ⲻp�����WG�����T���*i�6_�!O�{b�Lx�]�{��:��c�6��j�J�]SM�#L�����k8��>�{Z��g�T��W��@ѽ�b�=>���(9y���0+W�w��y1�����q�K��[�ũ�3��l/Ŭ�y�b��=����7
I���Q��`S�Υ]����Y8㦲��2w�L�Uf�)օ2��$��6�p�_��3.�y�f���6
K��ŰY@�/^с���g��屷�cj���cʅyiR��z�F'�>�8��6C[�����{�(#��!,YD�ޡM��T1�\�C=n�R܆��gdH�pr���(O�������!b�/�A��ԥ�Z��^�&������ቨ���eO����9T9�SK��������SG�����l��/=� !� �4�ݴ�j�L�&�"�d�z2)�(P:Bv�z:�Ť\�2�PO)�(:`�Փ��#ӎ���������9J���a%i��	�-<a��Z:��2&���~���aT)Z`��~��M>�����d�x"��D�2ea�崢m�iV+\������t�j�$N��az{Vk�x�e�B/*�"[�Z�ש�D��I��b�`��%�pZ�NQ����y�{*�@��cS6�ݐ^c���P���D��-�a�J��ؾ�V��4��_i�����Q�֝F��/����h�G�w��f� |�ɲ�"�:�j�\�mm��N3iI�-�`��J�wY̎���G���R�:~�1�����yV��P��v���S�KG��\����]'T�F�c@7VZ��d���\[̙�s��N^QB�,%K5���vg�(���˞���H���e�34����zޢ��CC���>���<VS�\�ʳ�桁��ɀ�jy������c^�	�_9�:)Gd�r��T��6wD>�YXK{�h���������/�6�G2
��j�MA}D"���;*G
����cן<7	W��P�c`��[�nR�G���Y�ӚDI"����Y��n(q��\K|�R؎=��z���|U���d�}�L%EiL�r��'ɺ�x6\��&C�+��3�E�gk� ��H	�	Zw�����1n������ѯt�*e�Z���܋vw�] �'�mJ�F�;T'e�V���6�L��Z�ܭ'J��e��4��7dRpܵQ�����Q�mb��� $KҪcܪ�$}�7E�e��z�ܙ�qf�{.��V�i�!o�NH%iz�7R�S����$R�\�jy��[�xɀ^�WUf���N�U��~Zr�_���>�h	Ft�D �.v,ˮ�����%8&Wy��@����g��ƴ7`o����`�NΨ�h՝�TX����a�-�ҼEc$6\@�(F[�f�D5R� IO������~_]���� �H�"�->t��#V���_G�wu�3���q�P4���)Nё���"a�I�ޓ&v�)��'�mX�)� \屉Q�+N�d��>�iU�FGo�6u�sU�H?�<��6��$�@Y��N̄�>� 4�l�UZ7tjF����$�!�1E"n��H�����)}͛�	L�����*��ݥ��_O8��U���]��p��\8͚�J
VJ����`ܖ� ��`:[�(�69Q�-�D]r��ZH!ҵ�3W5!�s*���g���y:_��(jm���}�<�-��_�qFB�|JŤ������nf$«�\0�W�ŗa�|V�$P�1�n(�]���*=��3>%��Ir�lL|$��u��ʢ'����0i�VT��.�������3Ib¶j\}~�B.��@h��G4�T�Uu>m#A�F���>�%\<]�%�GJ�W����&ͳR�xpy�=R�9_c+�\3�A/M�cǸ�`U�	��D����ʪ)w�>r�X���6�OTbW��0>�/���دpu%]���\a�hҖ���\�ե�(���`�B�c~�Q���	� �Ys9�����D�u�!�T%�p=�.�����X��<b~mY�M
i��S	��J�Ql���S�~�c�Ⅼ��N%�@�X�bť�$��P��GdM:��<;5�)5��Y��$�>��̕�;E�n�xle���.�(�W���i*>�ѯ�S�e�V�1��W|�uRل�x��TiSۃ[�N�"�x�Z��f$nrv���c��<o�-vp����V%�E�+�I?&�� �.���&_�x�+R�z�A�]�M�=t��i�.9�]�t�P�2_gz��"�;�݃��0�����Lǯ�Ф2�:C�ɼ�⦌�dG�	;�5i��OvN=�   ���\p\�u>w�i����2��^Hb��5��I���{�� a4��Ibg��}Z�H���`�&��b���w\�m�`�0�)$��we��'�C��If2S&�Ɠ����q�s�ۧ][��Ɍ������=��s(z(sպ����<W y��;W�=�p! @�2���<��y����w�j��p�Mt�
 p��[�YN�hW���Vj�P8��Ο����v�Ix�|��FG�J�?6�-�24=�"yeVB��q�2#�@B���A�Fd��/�N���e��g�a��qY<��~�!�ٶCF�
7��.�̼�=��=����Q(��v�	@�2�K9Q��-��b؍�D��\�%�Tfe{�[:W�A .�9���$'�Y���1�G}��C�I�fI -��C	5kJ%�ף�t�D��iی���`s��S��;x�~�ljE���z�17os�Zһ[�5D ���r�����0sAg�Z�q8�d�TszZ
ɹ���;1�h�qA�%��g���$������g�e�5�cy[ڔ~Ђ�/��ք��B��(��(�v��8�s;�����Lk�{��p�|�2����ps=8�F��x���i´�1����B�E{k_bd�ר3�ش��
���@a(�@r]�03|f��4:�E,]Ix����ߝ����T����Hؖ����'�y�W疜��`"�5��5��RW���Sn}�N'�[Y���Ā�"D1M�*x�!p`��
s�YΙ�ķ%�
cc�)���/���~F!��k7�J��px��A����`Z*��ڊ>:�d.ؖ���� 6�ٖ��t��r ��y׎FkBJݼ��D��&�ܠ	���dy�(1�GKR[u=JiX���T:��@!��U�A��&*�G������L��F�Ș����mk����=D�2&����.�������9Uq�k���B�4>ʓ��vf�73�?�@̛C�5s��'xVdr!�T$�s� ��n�={)�TeR1�3�0�} �I�&[B���4UW#�t�F�r�2]c�'caK�����C-���geu\�}�/�ؚӗq�8���[��j�/��Si��}�����i�x���aJ����B7�E��$ޫ,���l��=�����9��M�{Z6OlW҅��/SXZ���`�9&:�o�l\����aѠU��#��ޝ�(�"���i����NB(�-C��Yx.D��n�'�P���Ǌ���4oa��x�K`À��0�iI���7o�$��-!E�h��Νsl-�I��@Wj�� >/�i_y�Y| q$����(i�����I���Q�(�8j@���R[@[o�U�a�J)�K�A��e
t�);�4U�ī�Ŋ�4A} �Ȕ;n�N����1�x�QI0��0ew|~��*HQ��c�e�T_��H��������*�W�Կ��=�]x�5��א�S]xU�=I�cѧ�����A����E�J#7&i�uǉFtዩG_Z}|ϑYm�!�*Y�YO��׏� ��*A����A��A?�'�V'DH�#��4�N�h�!�@M�G�{�nh��H�w�$yj�h�.��ޚ�T{�8ї�J�����ɚi�Nt�E�u����Ӎ�#O�jGt�D����DW'z�Kы��}3AT�E�J���Y9=K���2���"I�$�A]\��~x(q���	�E],W)v�,���_��h���q�(�����`?@Ұ.V����=d}�iC\���G��G�Ղ	�Z��^�����ECq�F�����^�j$.�A'�4`̒�O�ka�:ؖ�c��`�	|jJc^d��t��F"��/�os=�P���I$Q�Q�]�I�wP�cd��q�T;:Pd��=S���N&z�B�R
�,����ȶ���^�"!�
��&=��	;��;�ّA3��B*�袦�'3�<_�C�:��"Ug[G|�P6*�0AeD{+����eDU?��DVxT"<C��2���9�*�4A��@�W��KA������o�v� ��h&^vJ\_̀Lg ԧ�l5��M<A�U)��R��fc�h�u>Cf��n�V
G���ŉ�I��S�S9�	{[�w�M����O���������A8mr�7@}�7���5b�鈧z������� �h7���&���"7�n�_����[>9_2�r��,���nB4yo�c~>2U�p���L
���*6�`��T���2S�����i��)�]��+/�gX��jJ��}��y��nMM�����Bs
a��'�+7����MMMK����6ܚኴ֊�r�]�R���+fC��?1�^3��S/�����@�S���['�����Nvyj�C^�*��cڂ���T?N����5�e���6a�����X*�v���w�?^lҨ���V"��\ɚM቗�ס��hD��m^(����$x�&�[?8$����jO�l�&W��	ᬃ-4��M["f8�@"l�U��� Q0��O4�¥d3Nq鸂��՚��`o-����w�H�띣BDN=>sTx"��Q��#��%�?V�EG���p)F��V�:�,�����-�p�E���_"��m�⺫��ߡ��3����Z�HO�A#�PP0�?��Y,Z�0Y��H����jȂ��-X�/���o18��Z�`���[V�>ثQ(L�}W��h�W�F�Y�։ v�_	D�`��
w��-��	�58�V��'��PX�*�Mf��`�`��4��G@��A���3���ɜ�;��*�:#_z���E"��=�+�_�����ѝ;~q�mt҃Q�� �K���	X���X��Yq��-A���*���{�0m(Oq԰�K��=4��� Ja�F��%#b�i[̣��@-�Q>�3Tb<�q��n'�,k=�9��OX���P�}�Q�a#�T�Z��<@�M�O���f��0����b�^����)�[HߏY�X���
�{��ʖƢ�Y������Q�\�'S�O�տ�ssc��=ɥ����ĺx8��%��u���X�G�2-9R�bq��uYϷ0�º)�q���?�x� �����;C�g,�K�e����t���W�]ɷ��;!�ֿ�nP�N7����$��(��O����b�:�	=���Q�~4���F�˸�{�W�/#��c=��E��c�x�.5~�&���$��B�9ܪyH�]L�|ԍ�~���N`���2p�Ig��S�:�B���ք:����л������tbL����Z�)�Q�b��>���D�=��/-�Gtp;Pv7��VB�0���7����\ic+�iVߵ��QL~[B�֨�O��¥�Nj�,��.�����?�IO �������/�"i��t׉�I���t�\$�Y~I,����RރU����9��+����7� 5������7��|�
71j�[��)<�|���I��[{M�A����%O���wO�W�}(����
��[>4���$�?�>���%~0�����ג"`��?k�fT��������+ ��uF�o�$R���Z�����]��Έ�:��I����K����ت��v-�`��8=�+=	�qs;������[?D\����@S�A��!]�(�I��P��B�Mx�GgSq�������Sb_b�s����Li�%6LZ����K̭��%v~���}��9snèo�D���J��4}��	}s���4Ǘ���%�$��s�Z|��n�%�&×�ڦ/1��K�X��N��������D��|�SR�4^&M(��Ϥ�;��`�*n�+A����h����m�Ph+�}����d� Ԇ��-"u��������?�'q}Rݗ6⫬����A������'���X*q=`�6�M��]�6	��/_zHu�n�9m�kk��<z�k����_MR��4x9���+g���l�[���O����I�*N���ի�}���}�x�e:���g��������G⋗�D��*� 7�+�d}�_��<7s��OqX��XR�WВ�A��n/͟�Kz��p�N�/׉^�h��?�׸u�[���Y����>��K�˶;�/A�_�l����*(�E��1U�����M0��I�N(+Ij��+���B�p���Pǁ�^T���|Q�f�m���   ���]MlU�u����IPh�)Qں� ���&��&�D[��Q��DP׉mb)���	��a�@�ԤB=		.�G�KOHpk�P�pEPGN���{��O\
r�*����fvvf��}��7�����W����<�a <CS610,��x��LIwv~��,&�	��[�Ίu����U���8�dvn{����h4�M�6�<ԭ�p��T��n����㎅������}�v�[���!~������ؼ��m.�g�
^�s�͕h��ܱ���)��=����t�r%��xp~�&�*2#qUv�1�`�SX|�|k)2��q[PD���7�\QȀvH|�\��qs
Y �2���8ʏ��?��C�^4��[���<��c���^ٟ٥�B+��~�5�>�AC(�(#(�(��8\D��S��,|U�{�1��O}���3�i}�&�go@�b]���lE���ʢ�h����6�dqZe���S�"|�� ,�.C�4^) �3�@H"w4�@����|�x@\tCp��7+���Y���o7W��>Fg�E]&�DI��ӼF�a��M e��)�cW��h�&+�6W��4 ��U(���}봺��<�վ���W�XOakK9�j��҂;
�Eڂd��K��@�O���-h�@�(�J>� �O֗͆�ʊ(��}kPmі��V�x�mVCU�R̪��gC͕���|��X�V8��fy�f�_�x,�����t�{ rIh�x/ꢀk��5�*{W��/,V>��n�By�5Vp��QCڃQ�J'���F3}��|':�5�	}p�U������c�����9�����/DѫU��l�����k���\[��q�Ϸ�RY�uS{� ;]ҲXM���m�w�]D�������q�5Q��o�N���,��;n$�~�s������6�����h��ĵ`���=����Y��@�T���}}��	�� .�-q��p��<dbq�!G�����%*a����ڡ�m�����ޛ�o��MT��=Z_~�X��B`2�RQ�KXv�z����E�r�|[���Ez�Tit#	XD	�\��#"�C�@>�^�z5]_�l�W�KD�%f��E{�1'\�uŰja�S�m�*F¥Җ[f���#9�B4���=+d>G
qJ$��K����1.@�"i[�� ����l�}�� ��d�mT$�f-92���d��V8t"dl���M���|�V
���2����s�9Ҏ^ih����턫����0�P�!F�	f*�V5�<]<S��IA�$��&�&�� �[1H�-�"��&����i���M�d�u��31ƭҞK`5J��]˜ˬ�7�	�;$����E�{�_��K24�ё�o�<��s�8P��d��p�f�����u�;"�p�i���a2�6��i�*j��5lD(�	��d��g#�?��������lC�x��!�W���=7�bU]�L2Y�j�:t256>��ٰ���3� �7Ű|ܛ�/   ���];�5�I&�Ƀ\^"�"<�Ji�y��˦I�&� ʽwYE
� �:
$()�]:���vP�����@�}�Ǟ�ݝ��)�w|����w}�4�����5ң��+�ο��8����G�˂��#�ﾳ-�������wJn+�?¬�����^�:h.� X���;"wp�y��=qk�󣃿n��e}�m��n;8���|N������<TO�v�}O̧|����D����x���ヾU}�ݓ�ͩ��{��L>e[�f� !��F���x!$�O��P��I�ȰNՅ1a�U���%��c_���P��1e��,R�H2 <M��A�����l��*c���/��p�H*��En$��L�����}LH9Ի���֬�=�ԋ8�d�����ˎ�U � ��]Ѩd�!%���g���/6���� 	�̴%Jd��B��ŉ�:���|"Y��l {pO@l\R+[�ٗK�K��c?p�+J���jB��/s��da�� �n�H<�p`�M�����85EK=� �f� �sg��
c�|.�[�+��H����W$���S���:�,3/�{;��M�ټ6����l��z$�a�|�ҢL�B�ǼS
�1�񕫊�K� �f��+���c�VM� � �* {H�ð�C �ù��U~��ŭ�<�	bՀ�~��J�3l3�sX�������L���;���z�Pۿ����_���؀��N��A����E�@j [�14nPE&�Ƕ�^��Ⱦ���\�lp..��I���uB�-؇`���=� ��'�40/q�5.��<M�p\<
���V�~��6�;�Yv.w_A�fx?O����OqT.�)~px��F���Fl��J!L�3�3���!���56��YRo�>��7�i\k��?�D���J�Z{��՚���{�D����W5��Z�Op/T��9�@�N6T��N]v�#m������xR����y��h�wK��IE�;��f:�;t4��T^�E��+s#�,���a�S(����t�k�#���x��:/@4�Aɫ�Zx�+�dI��w�.z�������ʵ�R�E���v~���u_�|:5&,zt�F�s���w���|�Қ�˝�|�՝��j�v�G���X�c5�9ҘUGp҈��q�	�d�y�$j��胈o!���<}*O�V�d;8��gN���<}&OO��F�>������y��n� �u��b���B�����5����[��/�����Pgo�o���H�k�6�����0�)2�߰���-ڱ���\��dߋo�9,"<���M�t��[���R�}���m�i\?����wg�z�秒n�L�/N�dE���E�����o�L����,γ8Ǣ��Z�����j����z*	�=u�y8q�F]���:P�O}2q�s��ᓹ���í^�"G�&۷XlR��������=W��S����#�e���˂�^&M�r�UOQt�"���g������y*"%��\OXwj�R���gH��$g�'�=
a˒�n�A��ԩ4=�*�Za�1L`Uq�Av�*]�&0*� �OΦΙ��E-�@�/)���gB\������"�,	�]
����Om��[���i���$���
n�AB5��j}O�u�`�f�|@�ճ���Ӝ�0��p݀p�g#\7��D5@�>�.	��R#,����Z	�J�2����ᆢ*sJk�,ݐ2;� 3��h���[ѷ�-i�Ɋ���l�PlFTL.c���Qp;���'�eε�yˌ���<F�;�������,F��('�5��!�k���l�b��bN-�!�fD���j$���Eȉ�Q��,�-�>�!���c���*($����J4��"B75�b�-ZFqdώ4���z�}�3��nDb��UId$��
ˌd	��s����Yu��dF�¢���eV�"*��ײhF�E�╱h2�1eXI�@�K��@�b�^f.��c�5�hr$��К`-�c!����H#��d����X�8"�#���XD�#Lc����a���5TY���2��XD�>��>����V�p���l�EM*9rk0�u�S���Z��&~{,��6��X�0�cQ1�R��`%��E��`�XD�*m�h�RX�cU0�%��E����R�wY�?���E�eȳ���|���w۞wu��j�5�V,R�æZN�-�h+OWH^^�����h��=cY4�okB&%���^��21��K3��v��&d��
�E_/1�u����wZ@�Y�i0�3!�O   ���l�u�g�#OG��ؑ,�R�dŖ��'ɪ����x�(��Ȉ)�˻����v��;��ȩ�
� Ώ?�G~0	�0R E��Qj'��(��A��@�"A�?����U*��\(����μy�����μ���i�f���!335c���;N��l���P^�ʋޭ�6q �oJ���u��"�cNyj��x�d���eI$2M�i⃰�gFe<prX�{�%%�X�1ft3M�� )��"C~f��I�l=��[2�x)�;�DAEL�3K�Y�w3�L�C��)s(w	^f��q��1L���K�b�^���W�W��/�
{�s}����7�]�L�x�*�_ξt���a6�g��;���=_��C��l�s�ܷ�����-�w�d��(�?��r�������S�o�w𶩛o�J��V�ډxE���c����y�9<|��/oU�W��BL�C�-r��{�)6��5�����Lzx_'�]����|m�3��U��̈o�X��%Vw"�^��W&2S��՜��J@��5�Z��&3DBY��\3�[���қ�T�(	[�d�"��2>N����[]3���v��kAX!�d������f�K�U�{�H�n�XS��L����L/ԡ�;�<��Z���r9Pz'l� 2����_��n�X�W��ό�~���ځ��^S$(��o��{�C���J?`.X9�z[�}f:jsc�qgk"�*�H�s�_�L���2�"n��Q�ѐ2E���`%�>lfۑ�!3�,���>l�~�����6�Gͩv�]��oG�e�)Ԏ�1���sM!$:HC8ț�X*8j�	�p�>F��*���z��6�~�Lה>������W]�[�(*��^��0�񖮟4�`.��)j��;̹��u��i�=%�?mܙ��eM���'Bۥ'�l-��+���4��|t����K�� ��tѥW��f���̤W�3�>� ��N�q�p����d��>-ݽ��3�7�����,�_aU9uN�	~&�D3������9��4홦��U� ��zƌ�O��S�]f���ZPW���Mr$TfE;��O�C*(���6S��t�����E�.�Z3�[-���iD0}�c�[H]Z{J������1�q�g����!�~��k�"e���s�De�݊5ζXJNj�q]�Xc���+�q�+W��������!�9��Y�-f�p��]�m,�|Hiw�z�c�xhE4R "w�M���{zV�d����,�I��s+4I�{E^>"�I_�	�� �8�3�E1���Z���)Bo�8���tλh}����x&�]6�7`*X��Cls�>s�HYJ�7#M�a�퀙�8E)L=(���D�f�U�e��o[7E�!D��{�/�0r�r3^Dڇ1Mj�8�|.���j�Q3�	��b�xާ��{C��0���P�[�a3O����G�\�����n��.��FO��q�ٿ�j��a�FK 
x��Ē!���[�9�C�Ϛ=1Z���b�>A�9�p�o&X���]Vi��j *�s�)4(7�vz�XSK�!H?�5����i�Y0gȜ�%6�u�<[8Y�̻�{ʫQ�VsF�����̜�M#�K���,Iܻ�L��X4�T�&����Hu;04��^����
�.wQVڱۜ�p�/�^@LJ�1c�w�EW�]#@�L'n5��vV�sʜ��ɶ�6	���H���(����8�3ď�@N?f �9SA=�H�3�f��9S(P��e��ƽ�3'�*�h��n=a����͓5�lF�"�1���L��kq�q��f�0JjN�4���Q�*�@��!a#H��>=�e#��ϧ����Չ�Ғ\[�h�𜹠^��n��j��^L� r&��[�|��NRK[��װ²Wl�GmÔ�4���G���^�T�A�z����8o�nc����Я'~��S�z���`\�ǡ8h�0:
aQ �vs��Aם&��Q�Q��+��¢��@���-P�ґ����u=g4^^��cl_����e��D`ƶsvY�/�:S:y��ŵ���[b�C"���K�$fK1�1�t3��KVXI�>�IL!7b#�3㷚��$�lLu�g���rq�̇8��֜Yo��2�?�V\�[�:H�z�B�R��_f�b��S^�"�������"�Ô��g�J5nF��R�����ފ�0��:;����*�Y"L���t���hOfk�~E2��l�IP��j���K��gAYI�ǰl��C��yH��{��LGo)����(���F	9��BO��b�R������鱦|bmX�W��o72�s��~��p@����L�����&���(	��)+
�XV�pGK���}���7k-�"��`�KX���_���*x���2�U��~Y�I��7��K�^���?�g���$Y����}�z��w6��R?@��}Qs�Bfg�Ͽݧ�K5�t�'J�����ꜢlaW���W�[؄���W߳�/S���p�?��?���UI�~@Z��t�C�N�?ѧ~�C˪�B��A�N/�[����՗�3��G>���Y}9w�^CH�(^�ԗ(���f����"�p���Cۜ��w�f�cߛ����)5�ֻ�:��5��_�Y�JX-����/ᇃ��U�W��Ǔ\�A`5�g�O!sH��e�ǹn���[(����{yȬ�" ���p�����!�G���#q&]g�k�%�H�dVQ�u N����:M/����>MK8��d�"��JD���8����&7�2�;���]�t�f���d~V�*�[=(^���-�;�⑉��P�*�ś=�� ����kG<S
�`Q����;9!�u�����?�]�I���ީ�pc����R��!FZ��$;ݽ(h$6�	�>�ٗ˕�.9�A�6UBY�X�K	VJ-b�� �� ����>E?0%n��l�8��8=N����ݤ��2h4�J N������C<qUz�Yf�T���+��Awm𝈰ƒ�|�Ɋ�D$g�<-�r�6�-C�S+�r.jm[�fҘk�����S�\���b��(Hi�B�����[��z4�d�1�΂���^�Y�:�ȅ*|�����|�X�����:t��M��~�3h;
EC�[.x�WW��{g${����m[G�Jn����0���'~>�C0[B���gU-x]z�^3�^�O*�￐���W�F�z���*<�R�]��W��v� xe�R9�,�v��`�b��f-��ދY怞g�nv$�㨠\�#��D��O	��?q�b��)�?=�+���ڃ
�3��{�O�D���-�F�[�����^��\��?����rSŘ�[Xe_`ghk�\�<	뇲�4)q���d�H��:<�:<�&�bA.s:��gCGz�$�a���w$>23�j���U�T��,��ʘ�}RV2�5��j�B��2��Y���?��v	f
���v���^d�4� �mGI\����*��� �<�X�Nx��T�)�ϳ�y0։	ӻ����Z�zo<T�k�c\��1Xw�J_��'�g�J�E�#���v;�����Ł.��h���8.�f��zΠ�-�Jz�-{��he#���ݱ���t�8=?v^}�O��{}����+(�m[:&��v*c�95�	��vz�/R���x��a��Eb��{3��!/�x���v�:���Θȓf1?�ip|#sE۫DJ&!��l�;��Ki� v&ag_��-/Q����䧟|����~/)�g�'��G���_l}&� ��5�+"�����O��Ыsx���aG�����_[-?0�O�7'�������>�ؘR{S��.����������k�o�K��/��"^Dci|�s��v���Gro��Z���?�|�[/�����f������g+7�����   ��ԝ�O�u�,� #/T*���ft)T�|��~��X\	)�VK�n���ܺŏ�B��6��rK���XjK9�t��9]�F9���s?�����9γ�?x}������<Ͻ˟����@$���R����T?|��/��^4H9�o�6O���{u�˟����wʇ�:�oSB�SA^�������3ѓ����������d"i�h������	ckP�4߯��y�W.`��`�����r�k��'��;P�b�`��:���wG�#��/�I�Z�=�C�����%s��т�":ƿ����,6j��AZ�R��G !,��pIAOdlG�l>��[�,��:(k ���}�����+�����a�>����/���8K�Jۈ���X��b�ߊ���������W��K �z(-� ���pp�0����^g�#L�
�XY�J,�R=����|cM���O�3�z�|^B��r%�]��`�I~X���cP@��-��3�%lAp�[H>+��7[��UI�[�������/S��]�z*�����Gb�8��Rc΃@ֶ4cw�ug�b�@؂��vBS�&	[p�^c��-��@8�n�C74�I"�-0]n��"(a�<�yj(KG2ت6��c��䴻�(CI"��� zd���I؂�����{���  ���n����!��c��i����Q�f��\�â,��{v��ϐ᪌]V�����w�l�{�&�����oO[���K�O��QS�cl�f�(����9������)7�_Gw��ܨB���b�>=�ΐ�@�~0���J�	*e/���X���i���J���C%*���%�̧*"�L1��P��t}j�J���Z�H�g(�T�ǯ"�>�R���S��s��Nv�8T"���)��a�S���BS�^���SsN�q��<�+) 
*6�T=U�xC�s���P�Ì� (���d�7�� �6��F�\�N��S*������i�#�/�Yn�p� �C�: `�E�R��ҕy��\�q�Oi�����q��͹i�U��R�+
�է\�l>e2AyK��B9����ς�}J�@4�]�+ǧT��<���n�I}�_So���-�H��"��kh(�:g���;�[o��v5��ˁC�dm�t_<��v-�����Rv�ٓ�Ԙ�@ݩ�q� ��+�FCu$��z�0O|ECߥO^fz�ayʊ�&o�'�K3�倽:��S�%;��@"�|M���_���#�?PS�A�g՝X0r� Y��Y�G9
��-;���f�a}�ۺ�   ��ĝmLSWǯ�D��:��6,�/�a e�^�=gc
���z)����JZ��)jW�m��\�R�0�Ɛ�����l�o٢���1Td����9fv���h�KΗ�_����������H�L��x���%����?"p��|8�5�0�̝}��<�뗭~�rj�_d�|ff��T乗���/���'��!�ɡ�B�czX�>i�I��~)�ƞ�x�@�kg5�.M�Ҷu?e} Y��lmg<�A�,}J �gN�x���u׿}�l�� }��0yIi7O|65 ��f7��A�6���gҬ8�WYb��|�]��\���~?P�c�U�9����,8�a��*��&�|����y߾yQ�'S�|�Th]H�M�!x՞��&��>�;�6���%N�i ��g�??���<�>�6�4ٖYvܭ���A��k�XS����W�׷uJֈ�I���:�I1��3KθO�ya,���2@�0�K�{�{��E��:�$��$=��$$6�a�ωQ�<���T�	��/C-�)t���2���\u��$>Ar�j��+���]��3	�T�1� 8[�Rj�f왚�AYB�V��U5tv�$�Y���˔QׅL�.U��+�|B���$0�����vf�cŅ3���!0���o�V�Z'gЋ���x��3E6 �#NE��-����Z��9�+�K�u𼒼$IQ&��R�������e��zl�H�[��������-��v����g�F��'���9����0�aa�.���%�`d�����K��̒�Ԭ|
�����;&��@���{��K���gpم2�����lb+6Ç;����5I�� �7g�g���O�G"p���� �B
����*�v��d��Rr�5��ۋ`����w�C��V#`+�zXW����=�����]��V��'�@��4��A�E;m,����&-l�K�M�tL�1��_�^^��@��=P�|C�\M�Y��X�r��b�K�c���<{nU�Z6�p��$�b�=�=7�+2g�V��Z�4X��LpC\��5KX��1x�wXF���C,�Nr}����R�OV����b�5�#/�5�,<{�w��qS�;�|�^���Ie̚\�=/��	�;�?�J(���1N"�	�zxCQ��]@`� ��tH�?���o1j\G+&��#a/w�*p$�/.^�y�9V@wd��Q��"��6�Z%N���Z�3��:*�%�R��B��&�]���Y���i��MB6C~ct�'��ڔ˪�pR(n])�l���qO�Y7N�4m)�Or��t�m��7׃���꓿a�0V�Q��q#E畍��p	��IQ�?�nlf]�V�ZlZ<P�0���.�s/e�s�S����]g�ѫ�>�ޥ{�~ϓ��щ8)*� �M��N|�oJ����B�q����   ��̝�OSW�o�)�	bj�4��)�_"��h��f����A��B�֡��L��8iP
n��F�:m"垣8��`��p�:��Aݖ�_]���4ǿ�~�}ι�</�y����X����a�����ɫ�ҷ�r��1�2�K/��η�J3���ԥ1]�*>"�\����B��X�$BGɹR���Ir�=�>�0筆jB����Q3��4�4����<��Չ��xW7rcv\ǋ���+n�g,�?�K=�|�!�
���~M�[RH�V	�4s��q���]I����1ȗI���?��1�!����@��An�*��v@Iv-7]S*�^̇Cm��Ǡvj��~_8��pg3|�;�*�=m�����}lU��=����dbH�7S�q&щ�s���h���Fq�\�� ��4�Nt����b��C$w�M�� �)�	�u���Z��u�����j����t�ӥZ�o�3p}�w 1�M�X$�{ �/B��`���Bឬ`K�u�����(V����1�J�g��a��vh~�1C(ϭ"�쭌%�U7���dLPd_�1-�.*)����؊?����MF+K��_���Q��������|���$X1�%��ar�A8��$-����lНb3�Nơ��|ol���q��X�e�b<�U�P���H�#�����"�/֞�eT�$DL�Yfwy��F�+Z
�E��{��G�}��_�9�E�ѤpS#|򤕱������=�2�c۷�	��؋�
�=�(�a�,%uL�����53>��6���d�ᝦ��į�'r&���~��lL�ŘD�-��N�/�˱@Gӱ��
s�-S��J!p�B�tŔ��!'�N�H���9�M+�~e��t�Ylv:�"���	�������&��/Y���a��!���]�b�B��������uU7�3��/���E>��ԏ����D�u{
|���&t�Bp^��f/>y��B�w��Vc�����&T�؅�C�?�vmŢ��
�{~����8�!���2�	��O�uj�i��A�g   ��ĝmLSWǯ
ùA_6) hu����\��\%jfVͲ�Y)�- �2`LA���&#7��Ӫ�%&��s}Y��D�Ԓ���Р���N/�ێV�9>�������<����'��_���C����NB�M@�/��CLB[�\���������FX��
T��$839�#hӲͥ��
}�"AP�)��5�7>K��#��_q����4�
��\��#��n�PST�5p)y�@�7ru�ۻ�Wݶʟ�;���~{��R�u�6��f��{�Zsw4f��iyk2�Wjŏ9���zw���GMqY���Kx���b^\7����b�mS�:�1�*@䫎��$���?�CM���_ŕD1�e���s�������`Ó#N׳i��_�K�1񖂭pӛz�1��@5s���bGӿN�a�J��z{ ��V��裎}b>����3�EG$�����a�-2L�-^�U���<��7�����R�L���!���v��\Q�'�%4b���$n�3��ذ���VC�R��/[���~���q5F��m�=v,q�a���YюF�,CE��O��dQ���-�(��9tOڶ#���SG��ϟy�X�-a�NM�Oх�7�!KQIc�7>I�G�^��lԦ�?����u�7'Y�����v[KG 	{��=�%�zN���m�3g�ޱ�
��K2�q͙������+6;rOn�ɔYj2���G_�u6���Ã�[l�-x<��O�L��x������s��r�Ce�����fB����yzm��:�r�=I=��?����@������~�@N¯�Q���Noٶ�L���?�y�>����T2pn���֝���&$mw�;����zx�[΍ȵ7�F�+���D0ů��o��@!r�;q���P;7=��2�M�E�U�yk�t�{Y;##e���u��c��&x><���Ǔ��hiS�����!
���'�.ʣ�&I��[xz����[6��0�:��b�\{ų��k��䁍�Q�9����7�J��F����Ea/�َ)�R��*����l�w6���i"�T�J��������d4f��*�c=��l]�)=#M��wO_��_�c��~�ᱏ�Q ��S�/�ttK�"��Ɩ�Mm��53,��'�C���|�Dt�oh�V��;AE�!� �r\v�Y��H��$\v{�p.n�
H�e���]�2G����v��UU�TǷ��h\���P�Ǭ�M���֜o ��\�	�l��ZUe$�H\���� #��$���F+Po�	b��n��n.�'a�p�)�{@����;Ld�u]�H {tX�JW�|<f�	�-��^��U���f����Ж������%��*�@Ȇɜ�gث'�1:�v�nh�T��ō�X\���SXeYG���nU�	1Q{�wݣqٻ>^[6"6v�CE6�Y�ify�,np1�Y%�}�إ&���" ��c	��R���p�@s�y�#@
�2q$�-�:� #��<{쒇�t�����c��{rn���=N裛�e�D]�;��Z�   ���]LWW������0Wip[�LSё�^�8�a��lc�B����I0�����&��F&%K،ı9�vm�ljtø_�����/d?t��]��U+��̲hi߻w��y�{�}�����;B�xS>�#}����RÎw����=�b��L��s}��Ob@g���K�g��8W{<�-Z�4�^����	��q}}�\����N�38lѭ�X~N+k}��cPv�	d�Zú��1��ܢo��g>%�cн�b'��a �cP��d��o%�ݑ�� Wy5���v` ��"����
��?�� ������S�Y��?	��y�`nW3�@4�c Bv��,�)�o@M��}s)N4�X���K���8�#4	�_D��'�������r9#���y�.+��bw�C?�`���f{&������+�r�2���,����Q�wA��:��s�����}�����8cݟb������8��C,v�]���݉8��E_u}�B_�`�;x�me�k�]9"�ݽ�sC%�-8ط�bKgs�b����5c�ъ�ߘ8���qTG����m�%���==8���y^�>�M��(�p^��V��ϩ�Ŕ�ڂS���*��`���l&�Ey*쪯f�j�&�\��FH
-z"�_���;�v/�[�Փ��|_a�9,�:DF1����j�D�B
�Jp���X(9+%��e��R����k}�X3���v��@k
�;+q{3
Fk��b[Ű�P�o��5a��@m�]�2:������c��KiU�}��7�������r|��� tj���K�V+G�N��*��T���jB�t��io�M��R��Y!uwrg�ܹGB.7J.�#����;��^2�,sM����Y�������3�6�Q��J�>j�q�?�	}���<G�����e5H�n�E:�8��nҬ�:�A犈'���\���"��L� �z��8�5�`�0<22�3X����|�$����/�@YxB��ك�
���cJ�:.�e[N{ַ@D���5P$0&�\}�r�e9����1H� ��^ #�R��BA��������䝤LT���T�g����w�Ii�@���"��4:�>�E�˄~�}�A�q�W�=')�1�ʵ��*ɞ�������J�]�%����S�5�7(2M�UW �9��"�P(�9��h�qQ��� |3��2�"��#T���'t\�Ї� [=\�e��z9�'�p�c�Ⱅ�/p��o)3x���ה)���H�C�`��փ�n�7a
�.��L�2 �+��'��ꨤ&��$�j�v`{l)�V%%W�`����h��"��f��FGi�d�����9��湣�DW��:є��fG��/F�N0`�����	�8��D\0^F�?N#.~�I�7S��U.A�t��+�@��@�Z�GY�)h��=����&"��jE�V���d����<m�63�/��%����	����gz�y����t�<��%� ��H5P�K�r�z�"$�l�Ч#ya�W�&��2���ilv~��E,�o�yQ6Ple��JfHbT���&�N��E��/A�$����"�k�N��:�48N Ŝ9F��E[E���X��2�,v��Xlk�R����0��Д�K��p��jv�6��X�,�H�\mtq?`��l��t���eb�n�
�⬷��eqNp�^.�a�ٺy�H��@0g^�`��H��`�ёߐ]��m� �5$�a�Y���
֚�O��ˉl�N�tE�`5�������m�沿��J(�� ;�Vˢ��j)_�fOc��YQ$����k���'!�P�p�Z#��4!	��H5%�*�k�x�By�Ѩ�&\�O�u)�5֘�̮��j��  ���]OlY~o��6���ʲe��K�]��4Ka��3�$4NR;iٕ��Ԟ$n;�NJ�2ˉ�V�ڮ���"��'�BH�ⲇEB�N'�BH]�|���y�8Άr@{�"M�}�������=�C�0�LF	�j���!1�=��j���w�5��I�3l*����ݸ����[A����f�E�;��u�ϩ��"?M��y�e��{��FZ�Ʃ���b�@x���f���i����O���o����4ִ�4~���l]��!][�7�k�q�Z��f;�e	����~��� x��m������
�k��¥0z�U���Ms���W%�m���C��� {>$��\|�9���ެӓ�;�Z�w�Fխ��zH��E���rH�d����付ַ;^����ݩzw��-�ҩ��N�:�{!�/��=m�i����;n��D���ߩb��|����Mq�^�o���)SC^�2�i5�%i.�sf0���S�Mv���X�U��95�+X#l�u�*��I~Ό����§n@�A!��$��_��6=y����!�@���,�|oO�6j_9��zm6ҿ�E^%��z�Ԁ�H���*^���u|h,R�{|�S���2���0"B2�o�ti��6;����9e����륌���;,1�\��^c�ty9ƌ.�q�D5^��Av����*���R��w g��W�����e�U�C����;-�r�@��V�%׍�h�&�L�|��Cֵ~LsPG���a�KҊ\x��EfQ�?��K�+(g�o�؟�)�79%ly����䒋�7qMvq
o�=g��
U	.�τ݇�|��l^I��p��å�p�27�@�|APzGP�1��(F��_�����ڊ�~V�D*���6]?�u�����͙
�P��#������~����3��rv�uc)�S�H�D���x�5~�5�;�������x�����,�7�47����__g��YZ��>�`�����ٿ$>*[�:(��[���of9�ᒮ������I����!# O�M]�)F���lG(}��<��!�>��#�T@�K1�P����/bF>�g\[^�eW~���=�Ns�fIx�S���b���^�]�Μ	���Cs��������K1�R,o|6���OX�x6������F"��<��r­� π�@y{o,���y��C���RB�"j�̱|�X:+�1}r���}n�:�8?��$
��D�Q�@f���>��[$x�,����uԁ�˱Q�"+�n��g�i�%��f*���'15��9�X�
�{,���&����:T�b)�v-�B'��� �3���{Է$wbҚ�:n)�,������Q�;. �i�:��K{��\K�P�B������O���ò~J�ˡQm(�|F��tvvv��̛w'u\qdfg,}�G�y��]��F=���ҷ�q+�I�� �a�N~6������Nb#�)�h��h�퓱�V�ٟ���=���!.��T�x��qą�����<��J��}Q�wF�I���M̛�s��A�ĤY�KK���XX�+\q��ss���`8������I��6�����;m�wu��~i����$l��_��
,y��I0ܦ�FCq� y?bެ{���n�O�13�\\Y,�\g�k�����T(��$3�𽆪�/��e8��&$�)_����0��ui�c痗"%�B��<'B��n�n��H],�W�)��Uff�}KN�N	uEw~�X�H㴡�A����*�4/}��0;�[rA�}q�T^��R�P���������m��9@��N�{�ix���4�Rp}aqYt�r�^[�2�PZ. rW�Z�L3�N�Q���	�R%NH��r���0A�r~����}&̕�������ni���8�)7��:��R�y!�:�P0���ێ"�y�P^)�l�^�`��PgQ��F�[�Ww�!��-�յ���r��V�D�>�0Q)���!���-�e�V��j�8��1{��񰄖�J���lR�Z�l5"�3fqa���/�ͻ��5�|���|'�i~߀�:�6��h�%a���e�`��%sG�a��Mi�	1����Mo��|��;��P�idl�g�2��I���� /������Bv&J8��dS�{ܸ�)��h��Jt�)��6�.
I�	0LR���l��1=6J.E�4��n$��(��Á䶐b��}3c���"���{�{���V*�r
k���bOm+E���)�������@���Cݡ"�)��1�B��α��b�����R�Fј��2�n`*��~�G�Cl��U�`������[��
�hlP�\�Ot46d����H
R��j8�@���ޘ#�`�n԰�\Ԍ�bâ���&���| �) �1R��N1���9��)*8-�G
	���l*GVŻD-	&:��'��(Y�r|����9���jG+0D�)U���{���
%�A�9��F4��|�
v��ǋ�N!�7�.<\�LG{rÚ�v��ߣ<���-��?���uY��3|6����,z�s|�͗E+����	�]O��BuI��K6TW|�`W]����aGIz5*f�芏���(,�"��   ���]{l��v���95y IX��;?p���0�<
,��|���a�Μ�I.�vJ�P"��A�*E����7�;,j�"T��
£@KPQ_J���ofw�R�?�*'����{�|���ηg��o�O�FZ��3dŝ_��jfJ-J�8|�

ۍ���1��<�;wOS��d�	�.�)�(8o�q�	��ga��C�Į�?��'�]�غ���,�s%��3tzp(y�hj y����ѡ��4����]$�䋤)J�#���������H<�� %��Q"�B�D�YW�0.7th�G^�ꦈOU��9��l�i|���U�E(��g@@P�\�Q��X���|S@����N���4݄�Z�k��l�/��#�|��p"��W_��W�:�=x0F�d�Pp_�L��L,E�WI�g
�kq����=l�5.0Y�%�Օ*q��65����T�d�D5i�R�0�0�N��jj!��d�\Ė�����e �1�0L�2D6�$x����#��4��bx��M(dR��M���LW���d~��,�E$���%�S�ms���k-E�����"eEfv�y��1`#����E�Ú��]�ς��&������b9���5@< 5�q�g�B�����5�5;|����b^�u$�%u��,S.���@�� �x�$�C?�v���|6��a�!P���:�>�,����C%� 2��n�x]z��w�Z��py$=�����[n!��n�����r\�햷أ��G
h*k\A�}�4~˫���׫��^��_SJ<ÖZ���s�A??`�[㾠��O��@:��>7�P���黽��0�cH �F�Sxn
'����Y�����j�+����6�K�s'�;�?W��f"��+?82�"+�q�_0B�)'�>�+����B�����g8<�\�4ч��w�6�;�3��E�z�W�z��+�8j����郙x��wC�ݜ�� ��>/	'T��5>jZ�
N�*_y[���Ǧ�;�e|ԑ�{�1����f iӊ��������>|� |�ȓv���Ak\���	U�Z	1"(�Q����|n�w-�Ю�EB&�6߇��S�k�\�y��`$����C׀0��[*��kw��Y]����5�u���;�T̰���YHtu� ��Ҟ��/��m7s���¬̭��hV�M��i�2V��[�̥n�:�rf�;�EDЏ>$�/q��$c����#���x:����|�I�8�R"�|����a�:���|D@�`Cf� �'��d+��yH�E2�=� E[@��u��̓��,��n���̰�V�Q�NF��jϳ���{u3v/*}�>��1���G^|���9��[?5p�8��r���I��ߥf�/��W���_~��{G+�8@��yKp�<�B8���2]=�w���D?}���1�����L�v��F|�qs�B?~%Ng�25�1���\�4#1�A�K�* ����
�Ku)�����#SWt��0��Fۻ�G�s���D�T(]Q��8��gPj�3��̯����#���������PݥQ��g�ɿMpP�������h���-R.>h�R�\���)Sg���,���n�"����{���D�Z�I�B�(dkОNT�q��&��8��-C{:�
)Sn9�$�
�i��?�5h��-�)�n���W��45�DY/h0��@�B�-"Sh���R�AC*���3eY��4,��F�kR�7�16i����Y-��X7^��=x����R���M�H�Խ%���] ϯV1��{�=��w�B�U8�[}�s�a�W>y���ە	lJMެ�K#;p!ʻ`@���R�I��&���vx@��߁��︺)I	a�)�A�d	� W�ڼ���JUl�\Jt���MQl�6Z���hd'U�"���ɖ2O��&�=<\'�	���'(�)��:ʪSu��'uI�c��
�q%km�C����r�S�@��͚˥Dۯ��i�Ȟ�����(ֺ2F�1��)f������O��Z��#P�5v�OP.RSL	u�<�b+AŸ��ZT/��J�Il�XJ���7�*�f��	�=E��sGނ`x=�z!L�{�UtW���I|C��k��#�y��ͯ[�^x���-�ã˾>*��{<tA.ӭ��\����(k�ʥmY"z��Z�^��&��%�(5��w97����x��
�ea��#�����.��oz��E�Qmnn�d>��!D�y$��I,��!�#s��]�%sH���}-l��;;�C:���:Mڅ!�D�J�E�����'ʉ�����[kܕB�*�Z�^>:��;��L����6r��U����6/b��/�c�.��V���ej�ئ�@j��N-��y�Z]����N�ju�$CQ+��+je�4�0�]H'��ji$�A�T��څ� ��I�����D����$� Ն�D���	$��A7���>>��d�����Y�k��#=�:��x9��Vط��K��Z�%�0P�(��*v`>��ީ�3w�j�A�4�.�m���K�r���It�����H>��^f��l5����QHF ���������V�(�#�$���L�D�����6n�F�6�v0��rA@Q^5��   ����}PT���"���`��2���hl�#����["�*�,���� ,��X5B�N���Xb�شX�V�I��{R�2L�f2t�d������8�0&��ϻgaϲ�qf�_������sϽ���s�4����*Q��-��(�J���
'g�$P�
Ed다%謤I���M�~
y�Jp��6����'�:�f��b�{k�y�=V��tk)��Ȼ=�cv��+,��*���>l�Q^��{��~1�叆��C}]�c�ހ��dhZ����)�㏉�/�EQ@k���&N��W��M6��[��=����PI���ƒ�ĝc�[�c�f�Is}|D�tL$3)d���\b��\�A�Y[H	%��N�I�I6x��ُ����<���l�Xl)��}�.����D�`Z�$k�?$z��(?�L����l�a�l�Ŭ�p6�Օ,K����,G/�6�dS�Ψ3K!3?���l)"s�#���zɦ��6	�O0�,[�M}堈<�E��e+dS���[�h귡;X�J�6�!ˑd�U'D���r�h<�H�9
�k,ml)"��s�H	��%��Y�$k9�1��͙$�U�Z��=����6��?�vvZ��J�'�J2���N���d;�S�Jހ�<[�T
��RB�d��|���Oџ��d��"v�G�J!H���-V�{U��X[H	Օ,_�ŞL���1��|�9�W�b?���-V�-�n`m!%4�,�_�&��\^&��sI~){M�s7[���}����� �'���)�VK2���m�^��l�Bf>K![�d������� �`�Y�$���Y�N�x(dq#�Lf����g���@DeJ0�GE�v.�/e�
�}�&�S�+�]�7����y�24 ,��,�d�o��p:_jc��"TT��8���x��B精HJ��3P�Ov�m�]��a�#�p�� �2�;�U���ln�&��]�p����x���_��^cC�:,�_�S����]��4��9�m��r?O+θ�Ś��g�X7�u7g���QZqƯ�x��ŎmF<�XG}=�]�k�n��<��O�kY�<"v��[�w�^{�T�5�_�G�ݭFh�1:-��/E�;���/Sh�aqc����y>O�N�RZ(o%��`��V�ج����Rk�U�s+|e�;��2���9iZ&����r��o�!+��.���
�Ӈ��}�������u���-*�}�\�c ]���D^�!�ݤ�5|��ex�@~^T�6h4�8B�S�C0�����e��������-����V߆�m�+��h����ސ-6U�2�ͰX[�͛��-Ġ�7d��@�i3,�bp<�@���ѐ-Ǿ��Z��&Ek��DUh�6W;�2O�Ԏ�8W���zC"������X�"�����t�;H/�4�M��?ũ���s����㤄dГ��o�m�ަ$`�,��?
���`�^e=��i�G��p3[���]؏���Ы�o�dug�"9���#۠��}�b�X��zk)���Y$���<1�rqb�,
��>X��+~Z�+F�X[H	 �Q"�"���|�K�KY�q����Ja�ﲶ� �-�*�hf�����GfU�h,�W�}R%z�a���� �`�Y�$�-�/f�wO��R��f�e1[�d��>1ck)���m�d��;E�.�/g��^Xn��J�)�wY[H	 ��m�`k[w��|��ۤ�����l���5���-������$�������&Vf�B6�b����-V��_���@L3�,ɒH� /|j�-��6�n�!��s�����HZ7{���h'M�v@��z�fc�)��ҿa��o���/���Z�D�}�}��6�4��\!��
� [�T{��d�����Po��d�nHf:�B��t�ι\Ȕ�U(h#Yd��'�td�mk�x�M��m�hw¿���Nʤ)h[�;�1y�'�	�E�?a���m�D�pq�v�#�|��U!�p�:�8�B��RB=dz�g�$KX J�K��Ʀ���RAKxv�(��'%���:H��hx`kj��b�$�+<^�+y�MMA�)h.+<��$קq�^��AJ��h�$�Ўda�3����mSІ:��g����@�v��+Z�Ds�löV�K���ժ4gJ�K��$g���5���4�.�j���k�\o�W��V��-�z�z��q�Ү$���=�+�v�v;�9�\�}�ֶ+h�c����8�v�t�|��z<VW�����F�=(�|}������F���2���AJ��L���F���.��M���(d��L�8����AJ��d��,�T��u�{,�5�z�Z-�&<'���2賬��J4�z��m$5M����m��6r �����T1��5n�������N���M��r�V����eq+�=hj�c��vZ��V/��2���Yt���r��w��j���
\X#\nv�Q��a��:��h����.5�(��]O�C�\�D8��W%��(�?[9X��+\��xq�p}،��ֳ�K�AA(��*<M����K����(����e,кM�N�B�D�V�\�b�5*h���3�M���c}��اC�?   ����lTU���8��E0VY��G@`��B�ΛA�h�kMSҖ>��O�"m�Li�C�-Z
�RZ`î��.]%�̜c�"5�
��F���&�	�n��a��X&�?9�w��{���|����7q^"���Æ�W^�V"���Ml�67
�s��T�*Z�@+�D������kh��V�D���`��*د��I%ߠ�mh�����Pqݨm��Υ���r3ڹO5lh�mN*��Y�6���]��:�gh��b��h�#`�0�N*��Z]��	�##[F�מ[�ꛜq�`�g�fG� �y��)���b�B���	�*�a�̵�J��/HQe�l 6�i"���$�����d�-e�y\;��T�rAv�x��	N����Kd�a�\�N��y&rL7�5�d�,�%��}�=fY�{0�&��$蟸vR�5�d���2Bcb�G�m��}0y& s����,��I%נ�U
���hX����k�f�D�s���d��0�k'�\�J�� Ky�Zo�9z̞���0iT�Y��j��g�kPɶ��S����d[$���_P�n�`̆gü�k'�\�Jfd����~�Mf��BM4�0Y�	��\;��T�*Av*�5�Z�4��J";�L��d�>{���q�kPɶ
���Z��2�l�D�RH���dm!���$�N*���Z��>�H��ͣɪ%���0��d��h�c\;��T�A6�z:�Wc�ĵ׀�lZ�j��	ȦU�M�;�vR�5�dvA����(�u���%�f�E��	�R��Ep�kP�j���ו�MV+��	�^�*���M��ҸvR�5�dAZ������d�,��m��_0Yh�Y��{��j\�J�M���Vf]Ս>����؍����o2-y���$<W�Vp�<��ͬ�\���?���ܺ��D�r����N�I�������[xq�ц�u���+(�煏��נ��z%����p�A6�킠b�^\��b�l�*�������w�^I%�[ �!�hb�]82y82��_JlS��'N����Y�X�O�]>M\�׹T�w�~|G�^PQs#����]�#��p�>�I�Q����t6t1׏S�	�l�G�A\|rkO�}\!$��E(L�V�?�^õ�JN�@������y»̧-<ڤQ�$��MLJ���N�z	�����/� �)$��=��K���_�`�ƆL��Ԇ�8��@xhШX�l""M�~h�"M��?jxɺ|$7I[SPRR�Gv�էCl�����VκS��|�%��ӜT�崜����h��_s��m����Ow�����@���G&�#c,H�b�o���~օ7�ZRPH� �Q�a��O�O�p�&Ţ����>����=��rF_�Z%mOq�������m��ɧ��GH�&̒���<K�b����@$�:��%�벲���Tt$9ģ�aU�>|�b1��1)�x��� ث���=�O�mV�P�/�bs����2B�n���I1~��c�G��w)�m{����C�dB��]���@�g���@{�_��?��Zt�}�5�y,�y�},>�3<�DPAuĖd���ߨ|�4+��<Eܺ=�}�Ǐ߬XL>|L��;�g���=���?��5���V;�`���S#.,&�W���&��� *$��w���O����8~�"�Û�h��b�[�هoR�Nz��	��N<�E7������4ۺ����<�_1۞��p�/Q_G�����i�����`�>����(������q��Ĉ��P�m-�u�(_\���a���������g�R�*��ܹ�i���)�k��߶�(Y������i�\7S�c|mǑ=�m��Cl^�	\o�V�x6�=����ml�|��L�`��}Zx�M��w<�+�����Z�j���v�%KP�K2�N�6C���@�q��i�O��u����wc��1��x�"$/2�J9Mբ��2ͺ���>�u'�U/�_����w���pM��
��{.�dpx-M��B�g�Ի��D8�U'sv�=/P*Ö3���o"D���Je
;P��O�1�+\wR�	(��s��R��1k1��T^�P
>D�z� ���N*9%È�3��Ǎ��p?P,!����ܸ[�������ru�����J7?V�!"���%��l�W�|l{���k�|ߚ1�r�V��Q��!-3w]!9 <,]�];Y��J���Z�2wm�W����>���e>�E���'��k�v�\۩�O%�T=F��Z�#�3?�ޠ�>�����58�
��株m�I�r���e�����1ܬ�j?����|��Z���� D�N=��ײ0��iJ���^�/e�l	7+���sX���|*��U���` �C����c��OO\�q0~�z%{Q�bht/���[-<~�B����He�g����(.Qo�2���e痐6A1)�Wl}g�yZL'.�X$�8�o�t�Q��I'́>��KTr£�mF]�5��i����[�J�w�)�ڇe�#M)�Ş�Ü�vMۄ�t��cQ�L'����xh����Y���\ͺ�Z�,$�;�䄫���i��c�*7V��?���v���K�����GƝ�T?�՞�������ы��
Ks��O��y*B�"Т��@�����"ە���G־AV��I:a/�n�|��Z���{�_�K�g��IOԱ��ؒt9�,r���d�5(z��ןS�CɹW���Iq��~��8u�Ltٱ�lF�_��Aj�򜲨��d?���#��ޅ�����C�v�:������q$0�M?#��,�No�6s�4�@�߄�t*gmwN٣�v�́DSYw���g0'>9�d���u�qRC(�w�ݛ�v��t>��h��U����U���������_2�t�X�j:uَJ�� �U���l�}���ӈ���Ǫ�Q�x��oR���\����i�Č9����J>ny����h4���QL�P,��7N>�/׎���R���$؍�>�������SɟJ��ry�����   ����{l������i ��Z�\�bH���)ٝ���Wx$�:,1���
N�"�
�cTE1�݆� $��a�@ �5���y�
�X�U��>��;���ܝݍYl��sf~��;眙�����3!�h�Ϣ��Y�U@D�TX�#@�'0�� m�ՒrV�T�{�i�j�Y$�jmȬxl|�>��7dWs%P��7Z���5Ļ�E�\�J ��gj�"l�� ���!���l��cBIt$/��:��^�xC,i��?�ߔ�1�{�cu\�{�b��	�"��|h>����|��n*�y��g�+ۍaO��+[���FLQ��yh�ۿjе�AL9�A�w�̘�q���5W���k}N?�4���cWh�����YY���^�;G��6D�#�.1p��xw�SXh���wm�m���is�������6�;��2�xC�.஄��J�PA���|������7�gg�vKt��t��\�gh��fr�N����u���ƋldJ�!-�H���-,y�2���6�hrFm�����K���;Ү�D����������ݡ�[Y|�u���`��V�l�ɸ�'�D��{Gݝ���]����
�iLu1w]}J�*'f��8�(�kx�|��hֹ�1��;<7����^qi�Q]9���}�����m��;������Ŗ�9i��4��3�)��jx-��;ʆ�dO��3�˺Yh��m[���{��^��r���Ƒ�'��J0�]jhx������!3l-�]��(��ˬ- &�4E�>���ž+�猢jY��l{�;���=[�cmx���ԕ�U��(����Ş�̐�T��U?��;:\���ǃp�iR�@7򉥪��i8u�(�;���R�K\	�ҍ�&�DG�[[���;�����J.�
i�J�p ���8�;��)��l�3mL��iLIibM���mԕcQ���(�bKDQ@u�#�&meEλ�*�K����[X�c��
O�B�4��<-	��왽#�^�JtKٔ�KST�]��$jYQk��8�!mxv]�z��Q�$�5<����ؔ���r$N���]iS���|60a������`�b��:)���N�3��e���N�}����W�{)��X�c�#�s����3va���w_e�=��t���7%�!��������宇s�獚����2s�H�N�� ��{5��������t�RfX��E���������s�}4�xǍ�>�4f��
9g/��3���>E����'��oKz��r��Ԡ�#�+�E�U�� �oG�E�	M˳д-��%&�GkM�G; �*�,m�d�ZB����u����������*�a{��#�B�2Z����lw���g��Ζ'^s7��O#�id�r�5��0�!�vP��'�Ը)t;���w�Y�פU������s%:������u;��٠��֫��l���Ղ�n�M_�k�i8����|x���-��d�s%Z�fF����:���q��b~����(�3ĆH��/��,D)�-{��#��D.�l����榋���ri��Z
���~���� ��\�6��"���sŮ�Q;b@?q �������B�C�~\�%d��qƗ�_��+��%��Ҟ��m�Dx�.�J����D�X�V�/�����,�pR9s��k��pP΂�ʙ��'��pV��绊��O�!��c
[��j.W��j]J0�J�^����hM���v<"�)�Bk�-�&���	�6��4�Y�ك�f�q��'���6�^���>:{�<Bv��D63�ǧ�3	W��ϼ��P��u�����m2�g
\Q	����^t�<��t%Z�i2�Ǚ+YV�2�?)+Nj�jw�IkX�l?���q%�`���r��
[�qy>WϢO�6��Cɽ���}�t��%�9�:�}\�}�5��.��#����>�\���0mΏ�^�i�M~ݵ�e���s�.��&�^�T���^Bv9W���u�C:9"�3a��P�7� l�D��$Dz�������#16KBO\�L�"��аY!���e��N�+�3�G�:%:�P��H���r��ЮaK$Bh$��a�6Ƭa�$�<s��m&833��q�i��V���^���k؇�.�J��Ќ�u�c����pR>s��;	�� �'�3�\O*�	W����-]Q��=�Q'J��r$����U.�}�l܋�ÖѦr"���Ŭ�Y;\@9�{����pP�Z@9-�z��9	G���3�\s�5]vu�8�}mu��r�Y��Ȗ�όʙѢ�*s������>z��vD��y4�#!B� "��(�3���!���hU(��Qe��*.�;��mt)qfsVqCg]�����H6vDt!"�)�"j�-�@O'��Z+Q�$j���9����IT��Lk����ux�'�[z��a%�KW�u�M���P���c%\��=,IG1�f-S�R��{nL��
[һp�)9�ғZ`O%�KW��(�>�bf�$���P����@�]����QsIA+�5|��ǿ��UþKv-Wbq����|�'Vo"ZQ�~�]�d�����gd�e�l�d�܄�6�����_˕XN��SP#@���PѺ'�"���U�;	h��]Q��O��<|@��. ��+��N����   ����}l����8�MpRl�QCu|�#���@�(n}�csM"�B[�Z��))�UZ��i�4����p�m���,�I�]5C���h�\���	_I0.���gf�v��;˶�����g�w�̾3;3��l�%8��90��vD�e�la�xЎ�L5rD�2�?!�.N�h���6��
��j��W�S��׎���s[Y�!���g6�ϋ���"��Es�PI���֫�����W����-,G�~� la�qwq"- �������vV����Y_A�j� �Z��M�]�r�JZ V:ҭ9��<�Ȃ+7�`s���!6 e9R@�����i��^֯�*wmb�;èX�#����UƑ�{�h�x�!�{E��D��b2E73C%�e>L;��"��,�W����8!��);���.į�8ɉ�˪An ?���"�_��y|>Lk��%h�� g)r�8�߆�"n�D�Јi3G2m�R{B�������( ;A���@N9 o@����8����SL�Ҟ���|'���v�
�Fڀ-$��B��O)]H�m�� ��"^ωT�6�a�)�̲�-�偝"`�4Rv `��[X����s"- ����};��⏿Ȳo��k�Wo���.܌��H�AB,�y�� �~͉�I��pܞd)|�%�(���m�K!:C�ꮢ�-�xݽHnE""� ���e���߃"K��#D�L$@<�E|1��p���WD���v��j�"�m$<���O��"N����5�Y��!�����5�f'r���c�לB|�6N���OL�:��j;��V1��';K�j�EN9rP�j�D|���8���;p�=}@�Eoig�GEW�+,���"���������x='R615���U���W�S�9�k]l�7#���B�z�݉X)�|�uX8V�~�7�l��1%q6dM�s�㄁���M���Zc�f�W �y��;oq?��X�9Q�'8?ӊ^��v�e�h���:s��Vx�R���#x��.'9�s��k@�� ^l�Ä񂀬�|��$�>%�x�
�&fX#�P��<�RxH���ú��l��k<��4�%�;|�I>��ˏpHH���!���>�>+��(�DYe�D���#��H�n�H��wė]�@�����O�!�A���Jf]a��h��ĆQ�\����0$XM'+��?da��i%�]��'j�=��1^�冑�q�#/[���bl؝qذ;�5��X5���~���7�|ê���d���X<�D��3;�!�<�5'8QK6[-oU'�eS�����-Ɔ�I��.����M=��cŶ�ɣf�O���c¶g����d��=�Plq�u��.{ټ�].��6��M�oW۔Ew�����o	S���N]!lS��e!�MI �����mߤZ��``�6C����'/��d�Z�9p0΅�'�����w�1�)��/�b���{P�7�Im*��k9Q˂�o��%y�
(�� Q��I��p~����sN^p���s�s�r�I����ܰ�3z�솊�8�JhU�[k���9��!}θ������m�Zn��q�S/\�9yy�}Z�9pp΅�9'�Ώs��;�`�EÐ�"���sFU쾸#��D�v_bR-��Ǩ��ܫc�e[}��@��jSퟆ���A���|�jI@�U]jd�jt��!U�*h��V�db@�.Us糌.Y�����R�M	���3�o���>����/��~���sR�`��}Yd]4�⌈�QNS�Ȝ��j�$��:o��L�4V,�(W�Y1T�\JجԀ�#	w���`�1�׸b.�4����71�_7�U�뼀�ˉ�,� �� �r �r�k, $�N �4n�28}ww(���r}/]c���.���w�2�#N߽/�9-�'jIh���db"g���z/��x�g���b��x!*�K8��p�HS�ї�nPl������������m�Y��d�����E'8Q�y�k�{�^B�{���C�\�	u�B���]�ÿ�,q�A{rWA���.��'����>��Eq���T˾�e�0���匓�G��,�8��匓j	�g����:�~�g��J�k4�nx�:�\��&�#�uL��>&�'j�9���a~����sN^p7��s�s�r�I�����d'ꁶ�3�s��;��}�:���z��@��D{JĪ��j霭���ǹ*/�rξ<ઊ��9ι_M9g�%��nRp�h���n"l�X��׻C��suL�튏��;����  ����PT��/���QYQ���`v������?�FҠ�R�4U>4T-��(��A;j�blj�5֭����,w�b%��8j��c�3ɤ-�:Q���=v/,Xa���3�s���s���Ξ7`����6nP4���mRl�ۀ���m�p�.�x�����[��d��ޮo���.���֩�Z_I]��:�\�췖8��
���`��m쿸�s8��s��gc�M��n��r����/�X$._���Z�pD�y�������/��LE�H��_�ȎΆ�������>��6�=L0�4�H�>�Cm!e?�U0���n{n �^ sy�ڳ�0����eL��V��	W�Ꮅ�*X��tw\�SY�(�5'B�* kN젻�ᲇ	�A`�#��`Op1�U�"N�����d�YCm��* k���\�0�4�,�%w�J�e���*|V�3��5I@�2�HW-�ж�3�U�s��[��H�l>�l��*Y��E㷅�M�:Z�4~t@���J.{�`˔q&��0��T��kfҞ߅��	dפў���k�iO'�=L�"e�MQ�2�I/� AhS������ZƁJz�O\�0�6-��6UE;��Kǯɝ�^UK|����ƃ4/
*x�4�ꋹ|�	�*^W��PއMS�FYR����d�9����Q�j���FYҨ��3�VE�F�RJ<��h�U��ӏ�|�K�t�l�����P�+�K���q��	�*��C���-��*XFI&����+�~`�`%sh�E� ,�$����r=L��B���*XG���T�����?��/�u�&Ӟm��[����6�k�`��i��f.KP�z�崻s�'�d	Y���v��z����\��m��6�,�%�dg'��R,���*Ӳ,TIg'���8�$���q�{d$iv��.�̚$����Rm�$	<����V0'��L]��#�=�:e+Vu�-,�U5�3C�Z���p��Z�HwA�`�tx�U�kcnP�U�\�x%<�uPӯp<�A�c����A�io�AWeF\���V�$@�A��t����L0eʕ��R)*ع�Ӵz���}�g� v��{�:* ;w�&.�3�4,�����j������R���G'�����Z����q��	�*��Y��T����t��yp���	dG}t�g�Y�Q���˵L�"�g3U�+�[T�<����(y1,<m��=S��"C�8�p��"ߦ��\>�{5�F�9�&]�;/��y�y�8ϋID`8�ŝ.��o{����η���ˇ�`�d�h�ʃ�g��^?�-Hǋ���E=�X�=�/����y�l��`\�Α>D>�G����y>MtL��Q��T�zR��L��`\�w��q�LK_�J>�,~�Q�D�r�|�[Aݙ%�ؐRO���ɾ�)?��[���	�j>�j���ƽ��"���[`+��<����ϱM9R��`m-�5X�J>s����:G��U;si���N��i���ɾG>!_���l��U�O�	=0���([)��"/hvuM*�r��13�U��R�P��h+�ʘ�V�OҸ���1��% ��~��K�&�V)����cg����>y!:��sh�;yː��Ik$��Wh�i���=G�+r��8b?����Y��'y��GϮ�:T��Pw�"��ل����(s�V����_
.�!�nl��9�$�X����K5�7��xZL�0�y�-���A��:<�O��K��L�4�����4b�Gv�4��K{�_��j"�j%$Z78���9�(��\�?ꊦ��iz��)}��Kl�)��>Vd��&t���qY9�ǝ��d��ْ��	Q/��}
)��t��6����Lj��RVoR*X���MJ�n@>�oXʩbWL�(Z0�O���+��ݡ��lb�.c0��a���)CRhq�2�A��#mZ����κ#��פsD��q�RSu"��$m2� w�:Ap���w.1�4օG6�A��3�a �fͫH�MlJ��?\�H���rd���k4f�l��H�!{d�,���\b�ˑQ�ߝ.;~V ���.ì����6�Dq���Cv��S�G�HƬMm�ʎ7V�Ѯ6��5��f�򤋏1�lj���c!sqJ}▿ƫ��Qf��a�!��j~E~rR�ie�*XˌY�C.�1���]�4�Yk4�P`�
ma�@[`�!ð���/�l!��'2j��=Y��4�3�B��	n�΁_`����3���Ǘ����R�������b���&t���\S�"� ��&/�4���m>��5��'���c_�'��)~������r�F\����+���27�����M�G�J�o�3��o�������QQ�[L�ď/cE�Е���	v�
�{�2��$��Ж�!o�����?�s����n��pl��xU�l��L�R~�GI�7���ђ`�/5m�Ȓ����h�����~$c��b��jA�mo�o-�T\�m����w���:�ъDok��Z)]͑�5����Ew��]kX~��fL�7��KH����m���l6��K �%˞�S�!�{�l6�d�H�J�9���W�*̃=s�5W����K�����"e[I?F���_���r���(����p�:�eק���zVv}΅\��M%<8�Wql�w}�����~>!m��m{���g��:�ž!\Ӕ�,�<�o�H�_}[�J嶿����J���&��ބ�����)���}�ߣ�!�fڀM��l�VnT�E�M���#3�dS�z!�6J��Na�R�UIY�����j~8Z"+!�ZU�D2!���G�"
w�x�暵���*���:ٵ�w��G��+�����zK�7y1*�-��6|m��K �F�k��r�4�`�L2�BގZ�u2!||���  ���]pU������$Z
��N�ZD�@�%7�7� B"�� ��H�K	/�����LZ���R��_��)�	HKgj��(�3Ŷ��Ԋe��g�����G`f���޻�|��sv������NS�@U˒�F�ȣ��г(����j/���r9���צ=���w�E�'�>�b�$v(�S���G���{�yd��Ӎ���6�Ӝ���<J�m�A�(���)@0�9��ǭ$����l�n������0yH~��M�u9���@lҔ��U�u�P�j��,�z1Ƿ�D�&:Y.֖잳0������Z`����#5]���3}�Eڹ	���=��2lꮓh��y%N�-�'�N��h�$_���ɶ�C�g�;��3�w���Q��9=���os�!�%�C;��e��Ȕ��������[�����G_���i;�/t�AF�kמ�z�)�/0�;t��o~��@�͘�A�@m+&"��S� F~�mm�� \��������g�=9��TWyl(� 6yW׵��ȷȣ#�a;ޡ�r��|��!�r��#�-�W��Nt�Ñ؀�Oߠa�P¡���{�q\�w��U�օ18�����h�3�P���fl7i�4����	_E�t}I�'�[멩�UV*� ��xf.��BbF�(�=Y<�8=��"�ur�{�<��: �x�9W�Be~� 8/���4	ᳰ-|A��y���@t��c.$$�J���C�B��vL�X{��q����&y
3}�En�&َ�9٢��T6i�4��H�0��Dk�d'e����|���D�ޏ��a�Cm
vZ4EZ\��By�����0�?�w6`��f�j�]���, ���Z`���+�:�+��
&��C�"��\n�1a�-�!�z9t�H\����?���:{$U\d���>.���ɇD��<D�n�x�]��%�v��/���f�%O����#F.bb������Tށ���')�bM��x8ӟ�-'P�;�ݗ��O��v���i;$z{�T���wp�Lw������;ڢ�9 �K7�Q�6e�	���6U@�3�G�J}?
���iR1���ѫ�8_k}���*ܣ9�4x���^Bp����st�y�,j�֪`��R.s�S���`����fܺd$L�e�?=� U�)�i�1.,�A`�)�K���c,!���5�=CY|An���uو�^��3"�g(���񑥓\h=�?VWW[h�1�J_g+��$��2إv��=��=�� �x!۪m/�\dK��̩���e�Sg-���i{��h���0lڮ��#�°����B��
M��^n��F��%L�[Q��[p���㺄��6���
-���/��S��&0��ӟ��Sa�7t�E�`�!�*D��?Ԣ'cꀙ��5��T��v�"������&��~���v?�k��s�E�b�t�1�0�C�|>�ӄe�Y}�0�{,S�7L��぀v�޸�{���g\i��n7X�Z�p!a�����=��t�1#�^�|6hN��i:nL����@� lz_�/���i���~=�4����.�Ф��a�����-����z����	�!�>�VI���:�&lc>����m�	�$g�a�'sX��5�kb���xR�@�u8�z�ݫ^���|?� �$� ^Qˁ��!�z9r+r��ջs���U�X�����8�Գz}U�'rn���6�����W0��HqÔ$ˢ���l�E���l)���8Ŀ�%�9]�n�_*��t��`�ַ�ү*B~�gc����aV�CQ�Ãa�1�U6��X�b0<�05��~x �;ah�h���1#5z�6c�(��BXtD�j���y  �۩Ř�)��e1J�`D1�G1����߃aEˣ�bXq�0 ��$FB�d�|������mֳ;�(J��u��6����h�2�/�D���%)�(����/9�zO�v}��"���n��9;�R4����Au���0�eZ`��Qh6]���$�Iڹ�U���a�L�$�0"�4���̬�S�x���Lߴ@�3�\Wޅ����.Ԧ2r9��3+�{*���ǊyZ�t�X�y�
�=�eSUUC��1�	��a�Z.�$�>�:#�}��w�,���өئ�6�q�Z��6��F6��W�VTW�]��ZV�6`a>Ӡ'��T кZ(@����C�')��gB�8��`*�lK$Lp���/K(k��F!ֱ]vW�h��1���P�	��P�A�:9�V�I1F6Y�V{1L��]hd�f(�R����RJ�F�D���B�K�2r�L��j�Vp'l�t���;Vd��U�{A��7CR���0���͸����?�Ӭ>�g�<�l��2OA��xI�������Z)/�:�IF�Z).tl��i~�N�i.6�Kj��:���"�~V�J(�ҵ�Jp�f��#���/��Z�iPk��S#w�sǏ���}��mkAOu�ol���}��U�ڒr�Z��Bsz��<A��jb�
���o>��@�*R�
9�ė�'"��d���M9�$�_0���&O�?\B%~O]0XZ�[[�ػ�⢲�f�x���k�efV��m�l�Ey�K!�r�cz_�U�К��`ǯf�&%,a_��+ϣ#Gk�?�[����k�!�S�/��n��V��ʋP���
�G�T!=�H��3%��k��Q3LwX���o���ce\�BIe���R�����3}�E��nL���}����q��=Mz?O�H�*���k�W{jʃu��R+��F}�����9����\W�|��?Dk��ouٻ0����j��������~�ݯ�����:������6�}H/�'�P<q�MHݖ v_�(͉Ƹ:��:�����B���R��A ��X��A���_n���J�ܟn�NA�=�
��	��ĺ�(cܯ{�'��e<-�mP����1}�PiHU��&%nS��>]T'�ȋ��݇n��Q����p��7��0#�_�.�~��*����/a���	�w��	��H�qH]������E��Z_�xS�3��ŕ�`H��r�;X6j��CcaQ,oG��a�wXX6��HI|�##3s
��a�ڶ	�r�:ʹ�W��9�v C��;:z>t��t[���B����	o�Vm���8���ߚ�l����l�I�sT�����f2V�������'��u�k"�:��Cq�����d�p7�{_ d���S��ʹ��0 G*���f�,����a!�f`�Q�?�&bi�R��y�3�`��I��ؠx/Ʌ�Z��.�u�S��y?�$c���4x�Fx�le�3n�yv,U�2�j�!�m�+�k��C��F`?м-UN1���i�}�����³�m"�3����{��.��-l��ݯӱ�~,�}f�0�;�n2}�AØ�9�� ���c��&�ޥ)�iMƋ��ᕹ�}������$�"~W��7��oHO���2�R��  ���]	pU�>�f�$H���Xe+�vd	Y���{�#""�`�$�l)��r�]-k$�l�������:��LA��b����9���^ �$ř��s�=��������}I�n.��i*�G[�s����4��Tq�x���*�ܢ�1�E'���1�}CG��ۋ���y(.n�@wә� ���!66N��bvfV\�]��k����tI��
FT�k�x�n�V�g`_ݭ3^qf����6�5��$�z6)�/r���mw�n�2�@V*����mc/wӘ�
��?��0�>���xf�y�Ms�]���P<y�O98����*1�O�FL�f�U�gr����ۧ�<�9%�~�e��1a���h$7��x�{cdRg�;/(�)a���<��ݺ+W�e$��#ǖ� �2�Cv;��Q	��|����)Q<��2�3������r\�}8$]R� �.Ɇ"yԾ�k"��鼄�݄�j��K�Ƞ��ވϿ�&^�k���^V�F5a��olceTϏ7g���WV�Wl��^<�
��ŷZC�a��u�Y�%V��.d���0��bj�?���l����T��u洘���z�W�ڙ���Z�8~�
��h�,qЖ+�*�?7��7w�����}�~9K1˹O7�}s;�Z9�U��r{!�j���>�âo��j�צ�4m��\�{��f��NM��=�j�Y�ȣUxv���n^�����X[:�۵��-b��1Z���q�gQ��hu�Gkvr�L�V,��Y?��*����lJQ�.Ea��ީl�G7�2s?Ѽ�����m��NA�0�\O��4�,Ǵ�u`7D_�i�9M�+mɐ�:WR��v�����q?s''���QRk�ő�up�z�;ܮ��������^x�9FBU�����eg_Ϭs"0�{�����{����P��
�`�2_���#�e4�������H�iu�����2o8d���p]�rP7���E���}���%��//*�'Z��U�����|U����s��өqPz#��M��t��O���,�R��?\�a����Y5�B+Ī���S���Y�a��vs��B���z�O������4f/�
���!J���@Db��(	j-N���YK�DI'��~�,�C*�������DO.� F|[{ⷺ$���VNH7��ϣf�Y�^�}���,�E��b�M�����~T�=��F���X�u�Ϥ�}I�䄭,,O�IIv��=�$%52S�l?�( ں � /cP�����	��3�s�ܤ�,AY��*|o�gG4�O��������:GE�D�v2��*�ᡪP�Y�+.����n��Go���&������_�~v� x[��R��Q�]�KW2�����I�[��;E����Y�8� �S>���k0���&��3?i�-���nG��$Z}~M�mf;�鸚�ێU�T
-�;�~�Hѡx&�ꆤWx

٧'�^9�3�@��I����Id��e��=q��P<��8����|�mlH���^�_�~�t@�,ln��$`�,Ԧ^�p�"�{�.����<�P}�M���.��N�3#�ŕk�͠\�R�������Z>�N�|��@j��Ɠ���#�0����1ˆ���^��on�C�;����福��1ߧ��Gy�z6�{���Z�ea-bG�-bGu(�G��J�mz��G��k �rE6l���{v�q�4Aώ�jٕ�D=���j������չ,
;��0���4!<*Ꮘu��v��̂���q WbY���:��♋x�V�Hn�e�VX]���97=�k�:{��<�ʘ@�/�ҳ_��VG���Xx�7̃m�O���9�ٶ�x~`=;gۖ�"ʿ��=�_�m��A��:N3���O��[�^�Y(b]�f:G_=�����*�e}�뮿�i��e�*t��$�}�u]/���;���j0 	����:Ŭ\g(�b�FE��]�3\*�ȭ]�KC�R,�Z���p��`��"`�о$����F�Z�ܟ@��w�)r-&���\և��k�:j6�jM���w� [�>�3��*�Y�!6*,���s�Q��`Y{�_m
���V��Ys��G��Đ�D�\f&�}��B#�B���j,/$R��X�bl�H��ܝ*\�����=M�Q�Y#1��6��¬��v�����]C�{�\`�V"�pa7�@����.n��TQj��0@���3>��3�u�'/4��5�9@�k�9@����ju@��^�>k7�Z�����PR/�|�����i�7��u���v9:MG~�r�m��$��򩡙m��R��%��C�(58��Uœ�k�F��5X�\��gUS�&��5���Y4I0�O��s`�ӨrR"���?���~ja�q�,�T_�z�>�4uk^c�)5��+�9!��6LD�Xg��a'i.���2I#��5�8��3;�:�x�l��|�B��e�CB�����ǧ^��9����N}�;��M�Q��)�m;��xT�<�ҝbǝ�;~�[@��3�?���D�MZ9�@�$�7ͺ�M�X����'E�;�}��\��S4yK w�hcׄ��� �`���&dx�����ۂ�ڱ�9!G���s�<�:�@������E�<5?�'��6� �`��k������=�Z_Q��ae�¡�5�Q%~��4n�.�К4k�.�n��ה�Z�)j.�5k�� �znW���v�s4��?v�����(�ݗ�[�y��p�H^�o�� m����c�>��'�Ϳh!m^���\�B�+f ⸌�A�jkAܵ�*4�=Sˮ�5���.(������6�jE��zu�T73.Ku�uS;1f���L[ݴ�a���/���B��Or���R��a���g^�*��ǉ��]3��V�YW�q�q�����H,q�[�5�{S�3�>��h��	�7���uWCB���/e~B*���k+K5ؚ�I����{k�Z�n��pw�Wb���	Z#$v�|M���p�(|��rUԺ�]��liT�31��67�����o�ﾾ�Er|���|>'�غc��r{%����`��<� ۹��Y� �(�P�sDZr[yT4��z��FL;_ii��ɉ�ɫ���Gk��vd��P�> �F��Wk��@HZJ"�EO$�9\I�Q��dLL?0�$�Ο����1?�x���g������}y�F�"���t�7��nZ��������57��?�������]n��'JXX�V��b#^n �X�QD}F�Ĩ���\(�P&zy���>R�ݠ�/$�B6-���hˡG+��m9��J�c��������i���-�am�в��xI2��O]H}��{[��B��?����vES!�*UG	�w�;�Į���+:6�Λ���?��/� ���#ug$f��j�B�rgx
Bk���.=8�M�i�NJ���:�$��-;)�y��OjB���ip�'�w(i�=	�|t+�J_�=	,�A�l�����@64�A�  ���]TUU��^E*�y����r�!����ǝ�VfM��"�)�4��Z�($�1�Ȝt�[:�Z��s�9[��+�|�=}���iY1����.�.��������������[��e����`��޲����l�v�P{l���Tʻ����cC��(g �?a:#8���w{|��U����,�v�*�o��q+��-V�堘�xӔ��z[&�!h����C����\el�,����7"�������--%���(	F�+�j�摰d���ј��(��cF�82��_쭊gy7&��r�UB����^0�y����8an]nD �$y�$���Qm�9�wqNT{�c]�&1|��g����B�p��T�%W��X��Pi!j�X@�\�����	L�� �ACkyZִB8{�K&Xk\��q�ˎ2U���6�mb� �v
�kl}�M�8q��o���G��;{2i2��?+��D�¸�F_���[�6�����6b��=bZo���� Dp;;�or�ñ�9�(mZ��m8폧���ؽ����F����l4��*���Ɉ�sߡs_a�s�?a�Df�pk?ٱ��#�w�X�`z�L��^ѿA,�J���M�Q>�𴭹�]N�&�H{;˶GؕV,����������C�Lȝ�N����	�?d�O����.?�Gx{g�
�.w 7It��|�X1�4�����u�R'�HzJx��d 'p�`Vy���|���w)�z�����ie�;��Wh��$7q{ze���V���F��̭8�,��j�΂}�B4�O�ǉ~����*htQ�.4�"�f�W_�q=�1�%�)�Ŗ!���X�Y��:��cCGS���ww�]ؔ�8��2B���u���[�G9����i�7s3͞F0���X�	lv���XU���/X����6V�L��X��X5���_�2\ö��Z'�}.V�W�@���}=c��x�����lB��C�#���f�qo��3RM�q�``�Q��(I�#DAд��{��m4�zѡL��y����+h�YSox@�_ϝ��cfȟ55TZ�/����,�I���I�!���lμ9e�s�C3���|d�7�l�)e.�G68*5T��x��c/!X�����¶?�g+2�Ğ�p�\�����Fg�Ol虦��Å�Ć�ij��/��.���pܪ/����5�~��)�1��Pk��7�QC_{�=�s�O����L�z��61x�FG��J�w{���t�Og�6x� KoO��68*5Tr����gh��O9��kͪ[��	q�8i�)��M�y|R�O�f�Fy+7-�q�00�ݧ�N��Xi��S4����%�y�s�
���,�))**$�;����Z��>���=�T8~���~кK��d�� I���΂� >���[>�"�;.>���_\d�#�������b��KRΘu��X�G&�9x�٪[��`q=���吙��/�7�˴җ��w4� l4�Z����]G�Kp9�v���k1f�p[_����n��a�g��{;��p���;mݥ��!�g<i$s	��*�s�2�9	a.Ame.�2Ȳ�B��yh	�`/+3*p	��lS�K�P�� � �-&w�A�w
�,}U������������Q��׮3��o�1�0A�x���(*��f�ob�C��-�ԣ(�J��r��/�tCwM0�/(.)��-��PV�pt	^���	mpB����Eu�k���d	���H}Pl�c,}O�R?���� �*5TZ-��l�t?3�{2���*^�ܩ�e��-�T�ZS�}�o���#���{��7;��t펬|!o�"�N"$���b���,�S���5��T���f�dʭ����s�F��}�ӹ�g����9�������x�U��c�TF�<y`��\g����BgdE�߁�/C-=�NY󲭽�0`�Z*��]���3'D�?x&��֬�W@��},0�����T�uQ�8.�����Nb�P�:L��Yn}����(<|���I��V�yl"Y/������g��Y�W�����!��߱��_�s�F�Q�c�\�3X�E#��d0R���~��f"x**=�G��7����c�A� ѳlzl�l\�t�5wH����@��ƫ�f�{<+��f&�-���_4����Uߌ4XI�JSS}?x�tV}��8��PB���7n��ؙ�o��g#�ʁ�I�0��i(D}Kt�7�Y[9�' ����7�.S;D�6����{K\�$�/�]�,�.�ˆ�=�K"�}�EAH����[�鞓��By�A@��Q�
���R��V:{AY�L�D�r��m����3	���I�.~��vU�("�Η������!�ҷ�WQKڌi�>u�B?�(�l��)�����h(�u�O\D¯-}�3J�(���PWB`�&D����NkDZ%�����r��_]����5���bz�C%8��%��,tԔ]�+��dWu�旕ͳ�͟��K���~��#xj���p�8�'�H"��I��Y���:��H�N�ۘ�t�JV�$'�������~�v�7!���mN��
YI��7��7~ȟ|SS���>�s�n#�/��#;�\露�����&l�=��Pִ�j�鎡�#�r��G̲�#�����b�ڶ�%"�f�0��]��{��<xZ6�WT��2*����1���,����?`�eD^~�a��2��є$a~���GH+&Ĳ��VG�Hq����6	�*j����2��4c%�@0Ib	������XyL��Md�/�<`���y��|K�GzD��K��^#Q�>8�W�q�u��l6]��|��DN{��uR�)���&�q�%ɤ�K�S^�+�x��C�{�x_��Pt�����E7�3L�ͻ�C�����1�s0/���s��9+�y��K��Ik�e��TE@:}��ǰlq[ɑ�j�ǖ-��K�D�95D�̦�l<}��QD���j�I�$��L�I'K�S���xd����!���}���h�O�0�j4ě6�%�D/Qq�q��kYW�OE����b��Š�/�+Cu�����K:�J�M"�}��*����eeZ�<�8+�L}Q��4׀�H�j"XY��>�
KD���
�|ejK�M]jhS?0��
��Pm*��sܺn��}9�OqIQY^7.�]���A�/�U������`"��@��0V���KtW!P_˸
����W�/����C��ǇC3-~���;Z<�^ʴxR��m;k�2��l4v�j��7~�l2"(B�;��#�m�twmc���2�!y�+d�kX�H��]2��Zf=(�Lg-�e����&#�"��   ���]lT���3�Ih�M�X����0	��o0$1�TQ����`
���͆�!	�R>6lL `llL T���Z���ID�*��j�
$ӟ��*=�>�ewͧ���]���w��̝{���RL�Q��;��l_��Q��M�Ö�!I�a��F�F;ws��o�O��'�`� �H�<]P��MKUdz���s�a�ow��$7���m]p#��%F5`���0�QQ�m��О�;k˫�`g�"�,�Z��d�5�	*�ڴ�M�B�.�rz@�r9��^@�.��=:P
�M ��`_��*��Erd�Z��c&[������ԝ�7�wG�H��Q�J�}X
�K�4�@`r�q��Xv?�?�TܩG�ou�=���l���B�	��S��;�T��2�_B�6ظ�7�.P��&�i�EMڏB���oWu����G%q*�8��(jNu��<~;��͟H.�����`m��b�ryk��)U+HT�!��%� !�~\eGLf`���qU;b���
1��~�k+s�
$1����E�-�5��A���}.���Z�B���A];��wUO�À�H:�w�t"��~n�p�u�8�pG�"`�3@# ޏ��z74�B+G��w�e���=e
[���Ԏ�����3���Q�+�e�f!����c��U�y��� �3�Eu��3�G�>	��wt��F)��Pu퓠3���B&�`���i(�r'��)�����d$�7���	�%�vFI����O~3��,�ǤP4x�����_�mU����O�*`5�hJ�A�K�N�J^*Rg�' L2Z��r� �?��49�Ԉ�n�'';�nS#�
f�b��Hk�q�$@0��ڋ�S&���JE�.�1��!2�Ef1��Ѵ3�~�q��l84r4�����r�����ο��;��+�G,���P��y����U;B�㝍����+��j�v�̬�D;n��"�ަ�l4	$��S|p�'�R�vƽ	d�B�{Ç��W�E�>�ѐ�,��Ӹ�
��O��]��N|?e&���A7�:=7=XQ/��1][OێY��B�,�]�t���a�P�lE7��ų����v��;��ޠ�@x�C��)��!_�G
*�2���>��Oqyyiū+;'���k"��8	k3Z�Ѥ��J���|�e����-�yܔ�|�xR@Z�Vi�'�3j3
H>�2�I.>[�< ОKƒ������Vi,C��f��!�I-.�!�H��Q����m�� �H��,����s�]4�$�U�o��$��<?|�+�v��_�@����T�ށ9f/�I��z���T��d��I ^��{�Wr�:�q}y�c}�Y!g�z�E�f)����������ϝ����7�����]�~�I@��!�-톫�:]�V.�X�����������!PN7h�h��D��t�T�џ;~\J.F�-�'�m�m��k�:��D����xe���*�L�;r��-؞�P9�b�~��}��]:M�j�j��*�Q|��j9������-��	�契����<HD��������T�N���� l����M��P�3]z�`w�8y	�Z$?V�k��ۂ�14�_�J����K���}d�Z��v�GA|Fv
Q������}bj���ΟRm#��C���n�JՈ�9��f�7[z�Nڶ_0R ��t1�vثo���)�],���/���u;�`8?l������T��w�ǭ��q�y}����ns��.�6�CW��y�vlэ�v��u�5�k��� pn!��ش�0`s�x)t4��3�
�5:ʯ��)��S\��ߙ�]��c�2��(��yg���*<���jR�ۆ-��������d�p|�嗘D6��
�=v�����◍f�9+�K���p�����	��+}�zu&���>^�oK�S�.�(��y�	b|l3um�(��m�[pC�³������¿��~5T[ezd�w�d��T��i�sf��Vo�G��B�	�ё�'����Tu<�jC"SZF�P¿Xz�n�-3�K���֠�P�˪��m���H����ZfL�7��/g��
����m
���aT/�j�qHԡ�\c��T���i��{4����TV��r��/!/p� 6��L/�����6	ꏹ��w67�>-��ɩZ�|q��� ���M֯�,����|ǾD� ����C*/o�����?�r$�Gqï���7&�M�<A ��e~��D$�N�B͞ر\1�Oh��0j��	P˲M�P���n��3�!�T��E`vR���%`����V��k�+����0�����%�sS�PK��c!�*�@a%K�-u�wo�򀘾#J�a��k #g�Sq��0г�>Swq�6������Y
�H`c���*�_��WX�R�ţCb����s�#: �Q�
FBאC"�Kq'�2:���勖�uM�v��e��fO�b���ƹ!"3�H
�&����t,�l��E2�>�->p#偡휏�x����B�@(�^�q�x
{+e��J��b-q�I�3m�ŗ�Ood�93�:��Y�����6)l�)UgO �x���CXڷ��8H�h;w	]!�Y���:�<�����6#j~��H�`��QX�(N#zp(�=؉,G�D)�*q]!������f�F�����E�R�T�>S��Z��|oP�#2��a��v�����?m�Z��C�vJ�*��Q��.���k?SCo�m�P)t��v�`�6�	�UX�P��xY����h��ߢ��K���\��Q����kD�҈��x���-!Lt�%Vy���I�n�f9���;���WT�9�}}tcn�=�l�gAyl,Y��j���Z2�H��b���wq3���mw�Q�M����l�i�h�����4WW�y�������x+��8�t[;�G,.�Mod�:1]
}ܥ�6���AH6�{B❭(Hg�r�խ[(�5r�.���g�(Y�o' G@�d��6O7��L7
���ؑIx�Ϭ�s��F�]Z�%~���q��_ڑ���s�&*9[!FqT`�Dv�+W���9'��1��;�=ǎ{�8/�����M�j�-]���6:�L����0	>�Vg�)�= ��݋�YO,�Q���g��=��='��s.'�X�s�	�JӜ��s;�=�΄����܍V�tK;ϻ�xz��tOZ�Hd*��Wܝz[g�U�:�5��v�C�!솄��?Jrw�/k���w�Lՙ�yN� _$�W,�/��.[�h����ga�#�t��e�֕��4�,�	
}��h�ՄTd��[:{�P2��sOL��e��}�s?8���}�dyx���,�Y���^p� /����]^���J������:xW!O��s�dv#QwI�%j?��ue++V��R�rI�e�O�"�@�����i)}㼕��Cu��y�µ/(\��Z�H&.�q�L��a�n�9x����t���cr��@���v�syx�gU�²��+V�૷�̅��臿|i������}$i.d�	,~��PUS��ŗ���İn�  ���]pT���%(ʘ8�T1� l�E��ts;h)F|@0�Y�,�.I�����52h"
T��EFL��3j�}�bP�:�`���CѪCѱ���;����MB�A'�3���;�9�?����/ځF���X���0|�T��-��ۤ�#�KJ�O=l�lD�����W&�E��B�'-���5\.��}�8i"2�B�}���I���0��1����@�ؒ�L�9	�B�R�X�X �$��1����eҸ�Ҹ]2�uI��8����e�&b�&�Zj�pm��A��C��x��چm�s�<�z�)�̖q%W�#t�L),8�
�GS�K8��� �z��=%�p<3Dg]JWSƑy��l�ٖ��W<�M���טf����u�<���4[�n-:w?�����6_���y#pH���BSl�@�}�Q%!�)6��.<F��HLAiY�b���	�X-޳�Ė�$�OOx�Ubn��+��K���C,�	cG��
�����x.�;�H���V�Q�[��4w��Wݦ����I��ƭ6��Y�<��~�/L��Mr�fVLL�o�D�Ts3zA�Y+*y߱�cǌ�ܪ����Zf�c�&A�·����NT���ob�V��ڛE&��7W��E�دw��RV��߹x�@n����o�{;�x>�P�B�rP0]��C���-�X3X.]�5���<�˘ T���ф�-l��rp���v:I���TbE��m{;����	�c/+��f��f{��4�`�M>��N����5g���n�k�|�Ϙk_[F�mܨ_���*&����c��[u��[���������n����l��#¥`e��AZJ�!�2QI�?g�|��߾L�$1入e�ܒ����n-�kJ�&�����x�[ԗ�`�n��b+��P�)v����:.�A[�#�)Y����zYj�9���8��7�_�Ō��QG��_%1�ˑ��꺪(���e����"�V� 8�j9� 8�J|7�V��y�N�sX�f!�sX�
9�Ә���p���% mS�/���U��r}7��t�(�i��;-�m�&�{��v��D\�x�S���e�� �o�G��!W�w;��^'Cʩo��W#]js�I{��2���|�<����r�ZD�����lT��'�'�^K�th��"�Ǭ�ȵ�%�[R ��E�N)�G��Hg�"���
�k	f\�����l�E!��)5pa�%�����4a�!,���(�8�ܣ#���ǣ�޿���/���Q�+D�_�e!nP�����v?���c��3��ш�g\����a�1���?�O�eP�ŧ
1ΠF7�;b�D�k��Ag�����1h�������v�j��w�[�q�ʏ���t�}�BGF���N�S���n���F�|�پ����s�'G쾋���z��Y9�s��}g��ZdI�_�Hd��lU��'(�H�N�E�����SBM]�x���B=_��g�z.�Z]�5���ou�y�i�_���/��m[�+6��B�Wr|k�F�U?�V��4MQ9�*�/b���c�W�C�J����9Ӑ�俚jk8�4.�V������&�+6�A�Sb��P�M�(��D�	ga�x&�"�s`���g���I�=�\5�0�:D�#_@b�(V�����P�jl#~?a��4����0#ďF7B��^L��L�ƶ
z��t�~���d̶鏆c����\�4{t�`�N��	���jn>]��0��!��h��ћV�<D�4I��u��/av��&���>9@o��a��}{�1��!��n{8�s)b�r��� a�>��\# y�( š�SO�QJª�|��H��n"��Tw/[���{c����$��Q��_f��Q�"��;��(����hu�I2 X5������Ŕm�V�$m��_��7��/��.�e�=0 waE�(`G_����
LC�Gh���/{�*�lpp��!�m�*�*�3� i�~��J3+��fG?¥�)��Ҵ�猙�@�c
 gЭ��*��X�ev^�N�&����ah*R$i�rgw��Nl�xaҺ�i�t�P$��s�Ϭ��@uns�X���s+Zn�zeC����b�L@9I�o�;��z@p�%4��,���6=�3_���T����GOA 8%�?1i�yF'�Sd�U�-�)ڲ)|wu����`�3Vi\�����.T�!��[m��T���M�^ul=O��X�b6��6�4�:`�Y�?i4��'l~�<�B���Q�
_�E��W&���:��1s`Qz�Q'��"����E�\Jx_W�g�Ԃ��e��Sjf`j�2�л�ЊY/����m@s�j�(�&�uNOZ����m�쟔�J��q8�ͥk�0��y��KNz�R�̙��O\|}P��a��?�,�wO	��@��Ќ��b.ר1k�*�����#��~��+%�B�d��R��׏>B���hl����~�֩��闿q>lۥ�ޤ��N�ɬ��Y���m��1�Hy�V��'4��p�SU�Xx��e�}#Vz�g�Wa"��~M�v"�����p�9��Wi�g^������k�Fgi���o�p���f�c�����	92���y����o�����w�L|P�D��x?/9���pn:��o��a�Y�5!���ߌ��s�J��d�̒�Y��ф�f��P:!_���_�H���#���͙l~&٭p�q�W㻣p�q3}3gA�˒b�Év���38��+�B��"� H�#5�0�Ov��F��riz�p��^�5�k�*p��5�g�.�6�B�k�����V�EFm���+>y����~׾'��V~����٭4ݳ�H���D�#�P�ه~�8��^�I�Y.�G�<������wfi���94�[�Wҳ����.�h�����q��I�>G�('�)E`R&#���F���0D.CX�5�A5�F����Zz��GZ~�m;|� ��.~�v�lE
�#[��O��x���X��v��U�c����%�d���smX������*R�9H����G�п�W<_�ʯ�*�˔i���� 3����X�[�9|d�y���� 9���!�ݛ]��Z��єvd'��W�۞/t{�,�g�����_����ȷ�~����R�Ҕr�/O�#��  ����pE�{3��B�N�D^Rޕ095�d3;�I ,Dy)d@�����&<
A�`����� 	��A2����{X�.�u�ǽ�κ;�O����UI�曞�7�_�L�t�P=Wp��s�1�=y'�73���KC-������W�����[��ꨮ�])��sK�0,���;����_���{,�����������z����K���u�,�W:�Z���oe9ë?�5�ݯ_<��r�f�k�[`R=���Q]��R ��I��T���r@�K}��{X��4]p�j�~�/���,�QN��b&��-:_
��	9-u�xj޾}�&�٭����Oy�}��iv�[l�kaPs�өn�])�8S��8`���2��eQ~��7��R��r�T��q�1�����V恼�oجX
6���x ��e,�F]���P��4Kǃ��V�k���2�:�W��Zێ��������[�}�q�1��me�G�o��w�t-;�4_�vX�����ީ�R�A��i;y^	8��a�;���A���ظ��aJ�N@Ϥz�A��@��8���qkG�6��9�9���{���*�S,RܯX�x@��!��Ê��G�*S,S<��P��I�S�����
�Jų����(�\��k/*^R��X�xE�N�^��5��F�&�f���7o*�R��تئ�S�+
�;�(�U��ةx_��C�.�G����(>U|��\�G��K�^�>�W���(�U�W|�8�8�8�8��^qD��G�Q�1�O���'�(N*N)N+�(~U�U���]��O�9�_���(�+.(.�DR�����5R�4Zc4�5E4E5�4�5%4���R�Қ2���r��
���J�ʚ*���j�����Z��4�5u4�k�p,GSOS_s����������������*Ms�՚���V�֚6�k4�j�ӴմӴ�t�djb�,M\�Q�Ih:k�h�j�i�kzh������ܠ���駹Q�_3@3P3Hs�f�f�f��j�i�kFhFjFiFk�hB�XM�f��f�x��-���I�ɚ[5�in�L�ܡ�Ss�f�f�f�f�f��n�,�lM�f�f���<�|��Bͽ��4�4�kk�<�yH�D�f��ͣ��4�4�k�k��<�yJ�&�<�Y�Y�yV�f�f�MB��y^�f��E�K��5k5�h�i�k^ռ�٠٨٤٬٢y]��M�[��5[5�4y�|M�f�f��ͻ��4;5�k>�|�٥�H�f��ͧ��4�k�h��|�٫٧�J��ͷ����445�4�5�k�h~���9�9��I�����I�)�i�ͯ����4�k����9��K���y��E�H�1a��A�A�������������!�P�P�P�P�P�P�P�P�P�P�P�P�P�P�P�P�P�P�p������r����z���+��MM�W��6�0�4�2�6�1\c��p���������!�3d↎�N��������������p������CoCC_C?Í������A���CC�0�0�0�0�0�0�0����7�&n1L4L2L6�j��p�a��Ý��S��33wffrss����5�gXd�߰����A�C�%��K�5<fXfxܰ�iن'O�6D�g++��3�2�6`Hr�^0�1�hx��a���:�zë����[��0�ix��a�a�!ϐo(0l7�0�cx��a��}���>6�6|b����s���/{�_�6|c�ְ�������{���G�?~67�0�b8i8e8m8c��p���w��?��6�c8o�`�hHGߓ�����d���pP$(�%���dP*(�	���A��bP)�T	�Ղ�A��fP+�,��	.�������A��a�(h4	�͂�����A��e�*h�	�	�����A� 3�YA<�t
��s�%�t�=�냞A����w�'��n������`p0$�`X0<�F��1A���q����`BpK01�Lnnn�wwwS�i��`F03�;��N� ���zַ�*����m[���m	�aK�R��-c��r���`+�J���b��j���ak�Z�2[�ֱ��+l][�ַW���md�&��mf����ն�mi[�ֶ���^k��mm;��v��6f�l�v��l`;�.���f���z����7�޶��k��m;����Mv�b�Zk���v�iG��v��X�m�ٛ�x;��b'�Iv����fo�S��N{��j���v��iﶳ�l�c�ع�;�η�B{���.�������}�.�ۥ���}�.�����	��}�>m#��]aW�g�sv�]m�	�k��/�5�E��}ٮ���uv�}վf7؍v��l�����M��}�n��l�ͷv��a߱����N����~hwُ��v���~j?���=����k�ٯ������o���A{����#���=j�ٟ����=a�'�){ڞ��ڳ�7�����i�ٿ���{�^��%��H���/")"%"-"#��"*"��"*&��"*!��Q)�Q�Q9�QUQ%UQUQ5UQ�Q-]&��"�#��Et��ꊨ����J5QC5Qc5QS5�U"j.��E�BD-E�JD�E�FD׈�Z]'��"j'��"� �L��(KDquQ'"�,�."�*�n"�.�"�^D=E�KD7������������F�� � �$��""��"�"&��"!��"%���  ���wtTU��s�>$ *E���� 00APPQAQ��d�&��L��(
"��|@��*e A@DP���RlX���Mx|�O}�޵��5�ܳ�������}�]k�"��W(
q�P�5�"E��D�P�*�)�劤�BQ����R�T\��Nq���(�hEJ1F1Vq�b��&�͊�[�*&(nSܮ�����C1Yq�b�b��.�݊{��3�*f*P�R�Vܧ�_1G1W��A�C���(�)U<�x\��I�|�S���(�U<�x^�H��E�K�Ŋ%���e��b�b�b��e�*�j�+�5���u�W��)6(^WlTlR��xS�Y�E��m�;�w[��)�W|��P�]�b��c�'�O�)>W|�ةإحأ�R��k�7�o{�)�W���Q�O��g�/�_�)~W�W��� ��h��X�ӈ�k�h25Y���z��4�5k��i�i�i�i�9Ls��M͑��4Gk��4�4ӄ4�5�j���9As����$�ɚS4�jZjNӴҜ�9Cs��������,�ٚv�s4�54�j:j:i:k.����&[�Ms������|����^�5i.���\��Ts������r��~�+5Wi�khjik�h��D59�\M�&���h
5q�P�5�"M��D�Дj�i�4嚤�BS����Ҍ�\��Ns���(�hMJ3F3Vs�f��&�͚�[4�j&hn�ܮ�����C3Ys�f�f��.�ݚ{4�4�534�jfj�����ܧ�_3G3W��A�C��5�h�i�<�y\��I�|�S��545�h��<�y^�H��E�K�Ś%���e��f�f�f��e�*�j�+�5���u�W5�5�i6h^�l�lҼ�yS�Y�E��m�;�w5[5�4�i��|��P�]�f��c�'�O5�i>�|�٩٥٭٣�R��k�7�o5{5�i�����Q�O��g�/�_5�i~��׳�� �2h�1X�3���2Y���z���1jh`hhhdhl8�p��CÑ��G�14543����3o8�p����$�ɆS�ZN3�2�n8�p��������,�نv�s��:::.����!���p������|����^�.6�6\b��p������r��~�+W���6D9�\C�!f�7
q�P�5�"C��Đ0���冤��Pina�2�4\k��p���(�hC�0�0�p�a��&�͆�[�&n3�n�h�d��0�p�a�a��.�݆{��3�f0�2�6�g��0�0����A�C����5<fx����I�|�S����5<gxް����E�K�ņ%���e��a�a�a��e�*�j�+�5���u�W��6^7l4l2�axӰٰ���m�;�w[���7|`�а��a��c�'�O�>7|a�i�e�m�c����k�7�o{��7�`�Ѱ���g�/�_�~7�7��� ��h��X����[�X2-Y���z��,�-[�ji`ihidil9�r��Kˑ��,G[��4�4��,�-�Z��o9�r����$�ɖS,�ZZZN����n9�r��������,�ٖv�s,�-,�Z:Z:Y:[.����%���r������|����^�-Y.���\b��r������r��~�+-WY�[XZY[�X��D-9�\K�%fɷX
-q�P�5�"K��Ē��Z�Y�,喤��Rina����\k��r���(�hK�2�2�r�e��&�͖�[,�Z&Xn��n�h�d��2�r�e�e��.�ݖ{,�,�-3,�ZfZ�̶̲�g��2�2���A�C��-�X�Y�<fy���I�|�S��-,-�X��<gy޲���E�K�Ŗ%���e��e�e�e��e�*�j�+�5���u�W-�-�Y6X^�l�l��ayӲٲ���m�;�w-[-�,�Y޷|`�в��e��c�'�O-�Y>�|a�i�e�m�c����k�7�o-{-�Y���`�Ѳ���g�/�_-�Y~�췳�� �rh�qX�s��;�82Y���z���;q�h�h�h�h�8�q��GǑ��G;�q4u4s���:�s�8�q����$�ɎS�:Z:Ns�r��8�q��������,�َv�s��::::9:;.����#���q������|����^�9.v�v\��q������r��~�+W9�;8:9;�8�vD9�\G�#��w8
q�P�5�"G��đp�:�9�厤��Q���r�t\��q���(�hG�1�1�q�c��&�͎�[�:&8ns�����1�q�c�c��.�ݎ{��3�:f:p�r�v���1�1���A�C���8�9u<�x���I�|�S���8�u<�xޱ���E�K�Ŏ%���e��c�c�c��e�*�j�+�5���u�W��968^wltlr��xӱٱ���m�;�w[��9�w|��б��c��c�'�O�9>w|�������������k�7�o{�9�w���ѱ���g�/�_�9~w�w��� A	Z0�� ���B�PW�'$��FBc�0�p���p�p�p�p��Th&���±�q���	B�$�d��T��p��J8]8C8Sh-��
g	g�s��B�\���I�,��.BW!"d݄��B�|����K�P�H�X�-\"\*\&��
�W��+����� a�0H,��B��+�	1!_(
��0T�F(��!!�
Ä2�\H
B�0\!T	#�k����Q�h!%��
7
ㄛ�����-­��6�va�0I�C�,�)L�
w	w�ӄ���^a��0K�-�'�/��

	��G�Ǆǅ'�'���S���a������HxAxQxIX,,�
˄��\X!�^V	��W�5�Za��^xM� �.l6	oo
��-�[���;»�Va������]�H�!|,|"|*|&|.|!�v	��=�W���7·�^�;�{��Ga��������_fU� ��h��X���{�x2=Y���z��<�={��i�i�i�i�9�s��Oϑ��<G{��4�4�<�=�z���9�s����$�ɞS<�zZzN���9�s��������,�ٞv�s<�=<�z:z:y:{.����'���s������|����^�=y.���\��s������r��~�+=Wy�{xzy{�x��D=9�\O�'���x
=q�P�5�"O��ē�z�y�<垤��S�����\��s���(�hO�3�3�s�g��&�͞�[<�z&xn������3�s�g�g��.�ݞ{<�<�=3<�zfz��������3�3���A�C��=�x�y�<�y���I�|�S��=<=�x��<�y޳���E�K�Ş%���e��g�g�g��e�*�j�+�5���u�W=�=�y6x^�l�l��yӳٳ���m�;�w=[=�<�y��|��г��g��c�'�O=�y>�|�������������k�7�o={=�y�����ѳ���g�/�_=�y~���T׾0�zT����B``��эWto���K�$��E�XYDE����%�":D�c%�d<�*b"u|N�(������"'O�".�$r�ɊhYUD"��%
k�!���������Dѿu"F䏈d��%y����YP���,��G�E���%j���"zEE�~ �-��J����<VV|HYU��G".-�V�ʆǢ����h�aĚhI�8Ҩ�`aUy<�<�8�8,�(͋��$�ey��Fi�,�\�[/MF����%��:Ҷ��4K�5Im?# DGB���:�Ըv�̤���N�>��޶!3`�Ti�^�<3��nå.V�z��ՙ��g�Jj��4J/�g�ۤ">U�"�ҝJ�ҋ�e6���1�*+�trVw�Z\ca`*+����ȡ��Y���f�����Mͱm���g3ӓ6e֎;�e��[��>k{fzUaVz�ج�1>���dJV8;��JT��ʇUD�B��E�P�0���B���hY,�S����Ze���M�+c��K�y�dsp�A���D+cy��e'�K�b��EKKcE��DEAa0��1��(�V�'k���%���x^^Q�������oT�?��y��d(���sa����.µ{�SQV �(I�k�Ɗ⹉Ҡ���Y�����?c�I�ڠ�m���n��� �g 
2Z�i�Eъ���PP�ɲDQ�,�(�['���`�wI�H�����Hfj��ٲ{(�����J�7=;�NM3=+¤�۞��M��=��K�=���F |j��yL���zE�(�w}g�s�Mz_o��?���orna�;���.�=G���%=q���o���}��g|j��T�t�*]o�Jןkҫ�4�������h�����scB��e'J���M��ܺO��d�P��xAAy��_,T��)V*��T$�Ae����n,^P�<��7��[n�^YEII��E(Q�LFC�xq�U��`Z�_�
!�����9�lQ�W��$�WM�Y[�U��hU {�_;n׷0Vբ2*OF˂dEC9E�D^U�7A��%��4��^S�U��CAME�+����
R+P��;-/�+��C�b��Pt��K�A��*��G�0��?����J�Z�X��.Z՞������rp�����j����qD������CpS�j���?H�������ju#uӓ����۞/��>�����.���>#���ӳ���}25�A� �?-{N�����d�{�>=�&��;��N���6ҥ�~ݢ����ս��Uz}#~m���22Fv���mH�����S�W�+ë��:1ҩkC��O:�;n��:fGGi��J3��i��&�2����cӁ�5��Y���g|3e�)�j��6�֭˸�>���l엍��Ǖ�KF�J����s��5=#c{����ȩ�kzDe�x���/�>�N��·�i�0<pҜpya*x�풺+Qz҄V�a}�ޑ�]�W[���,>e�㝛�ZW����mօ�~Z	gw�/n^����G��*�����hn�(���ȩ�ˏV%��W��d����ܖ���1z�H�閚���9��Ll��9�Z`�9&�Ќ[`��-�>�̶���XI�4$'xˍ)�%�E���O2���edT_Q�����.&U]�U���Q�**/�a���,���՘��y0�Z�t\p"G�`�#|���g��ώ�  ��Z���	vK�}�H����i�q��	��90Qq���M�}=C-����BD����[�7+Pľ�J}0(�8306� cM�                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                !      �3�5       V�o� 	� launchfacility_b                                                                                                                                                                                                                                                525 nightly Wed Oct 03 2007 06:03:10PM                                                                                          british                                                                                                                                                                                                                                                         levelshots / autosave / autosave_launchfacility_b4              AUTOSAVE_AUTOSAVE                                                                                                                                                                                                                                               profiles/RUXZ/save\autosave/launchfacility_b-4.svg              d          5   3            t      �      �    xs`   � A&  x|Y[w۸F���nn��[�8����͖-;�'��	}�HB#����e�%�i�i�f@R�$�ɉ�4 s�f���|���nr�4����Y��J�)ub���cf܏���*�?�6�ӛ�3�S쓴�Z/�4u��,7el��z1��cd��^���\N����w��}z}?�v�t'ua���(]�ź<)�|e��)gf��?e��������\�
��_��%�X1!�����N9!Z���$�� q
��:
�Z
=%+*DPۡ,�b;v���7Y�M�e�4Vv�-Ė�*D�\��B����b��#�BUYe��~r�Q���pH�����v����R������Wa���P�q��iY�Nϙc{���g�Ϋ����U��s�4�LN�nn�GY|�^���N;�(�⓳��s]��=Ev$eK<WQS.�S��N�f�a�1ё��G*����#���&8�.��k��e��e�s�a�T�AqV2� -�Z��q�_���^�Ҳs<�\��E�c�b���d G�^(xW*�gV�SX 7�X�V�@
;[�!�M���σ�-=�Ñ�� ����FD�*�<�ڭ������)�
�x;�0^_f��$�9{�r�����Xn��&)���ﮔ�����޸�s��8`˛�}1��r���,�'ײ�Y�ڨ�d)�f�S1vڛ+�>���2ו���R�2�8���S�L#�h�m�D��g{�$m���l�h�E�K�"PյZZ��LTl4{�5S�{NF�� ��[b�e+�����DE���{�:��F<n?��@�V��.b5�.6��n��Rp�}��ZBY�	��U8�*�F'����͡�"�z��_��G㟷�&�.K�,]f�[q}���L�n�5y�t�R|I�>ԝ1�����3$+Gי퓳�m��܁r�߶䁫�٦6����15v6o�Ϸv%(�lI�R�ǝk�@?뾴��t��4y���� ��_�I8`�v���k@-ma������Z���x�����>�PM�giK��
_���}��[�mh�ÄI��^vzS����
�um�:�&�=yV�D��A��$��=�lL�DLx$�N�E���'�)�Q�|澚�~�ݟvy��j���f����N�b�J�<Yw\*4�`]3�Sw$�����,Q2ܩkك
�@F��t :Q�|��o�*�H ��+���z[(�����C)W�cR���@R�%�f<U6���@	��O�!�+�g�WZ%H����^ȍ�G��(@!G��?�o��-�-�޹Y�
[��Wļ>�CR�R@�� X�Rsݦn�
�R5�IjaV��.Q�[���t����/����ŧ���W��3[��^�)��窧�	�����镪��

�,I��k���!�h%���)LB���R������r(W�8EV�in�!��?VY���
�E��2��&2���lYȬ	]�2p�d8�
u?7�bfSDD�4#ZO
�"�Jr.�u�Ä��.a�%L�r�R�/K������A��#�5��J��F1(mV��^�5M5ɛp<�Cl����
�u�YQ���m�����1!�G�F��:��BF�br;&3v<��T±�f�;�0�;*m/����ɫA�XN�Ud墥v�S�ƽ%@��n�
�	}E��G�s����kflg��+VU��(��po�/te�.�̴m��+X�p8"�,-3��Da��E[��c����� b��&#%�Y��(� x*ps���n��o�:$=�.�ς��;�0�֠���JL�o�_ٷ������p�kA��>����D4I���%Z\w0�H�9��w��i���� J4k��1������P,�<���$�ɫk*�����d�y:�|5�|�}~"&�^��V�/�3s��P�«�.�;Uk�AD 5f �FO��MQ�`��M�<"�FWZ�&��4:R4/%+�I�0����7.ڧS(�s[����ψ&36���w����F�ib�>7'��}� e"c���3S.*���N��ƙ:6�Gx6E��TV&�_]�s������2l�ǜ �F��I0A`Ò�$U#0fe# �θ(X3П�ȉ����/��K��N�K�[�V�;�3��0z��{"5HP�	����.g:�ȉY:�)	�Gݸ3O����GU���߷G�I�G�3ƾ.I᝼��:���Ȱ|�|�_� K`���/��ʣ�^��5^n�pM�tn�ߗkiQס:��b[�xi2g�5j����B� t `�A�sz �;#
�R�_�mo}p�2����k��xJ��
��݊��&9��K��kt��䗑F���V04gX�	kF����*&4��a�HC�m��*~�қ7$���@׍�a��$�1O��]�y7�C��(M��w6?��aJ���O�+�:�T�c'�	k����o����dR`��¸kA�.v�7��\3p�k"�s{Rhps�ӦD-���{TE� � �@�����
)�-��}50l�,�q�,�n�k�i�QM��:4��g�V�>����x$�Z,�ܼ��) �ĨսV���2C1T���x��m�Z��|Or��x�S&��E�<�(�b��뺕�a%+�n(�>A~�:�'��O���]��y=:�WW�AV�k�K#�0?PY����*n�������.=%�袇%[�zI�����%��U�K�͎�OO�#;u��\��Qt}dK]�XW�-ſ;�v�,Շ�+�����޶ER���3�jm�����
�a��<�ܙg�1�����bC/r��|e�9����zl���6N�5�<Ҋ�ph�63��v�D�V,�I �@-�J�l�QlC�ȯ7�ر^/H{1g�G8z�;G.�<G�H3Ԏ��Ȑ"e���#-�S�Μo6O���^��(�'�\P��C��ө��c�oUH��d�QҲ3z6��۶8��9݌w�U�����$��ژ+�#�ji"�
E@���	�(WR����������"F��.˧B�M���♠7~?� �7��P����ܧ��쉌G,:����(d[£8Tn�&�pB��긦�P9��/�����
PD��x��i��wx�B���T��c�Ҧ��Q!1�s8vC���
#L���a�b9t��%�U�W6�;̝.S����z�[X�n7}�;6��Z��H"�7%�)�@���#�~��v��
#�:������]� �g���M��df7��k�i��D��$����K�Vli~���
 �1wGg@�@�J��E����j�ѫ~G�IX�~�ߏ֯��)���yC,�M��&��0��3���(b�C�۱f��uJ��?]�O�Z%v��A煭=�2�
�h��m�D�я��&��ִt��@��  ���ZKO1�8�RKA}\
J�-=�6!�p2^�$kɻ��N(�P Q!B<�8џ֟��:�&�ph�H��g��e����G7�Wt1�Ju��qm-_8���ypJ�+��ٕ�hc����c��dYOI5����F��w�	t:>8��qǃ~���Lv�JǓ`w�n�O�O�!�h9�"\�~J�VO#%)�N��p��%�h��sf�����rl!�%���t`^Ro�ڙ���9�c�E&u���{q��y?p뢆�kVXnl�{�@��,c���\��C�T�z��l��)&0&tn�VF��U��B��'����f)h���F�{`ް�Fv,��<L����CjѕBW��3\�M���`��Q:�y{�J�Ɠ�����P^�Ǌ�Qܶ��P��($�X](���O��O������t� e rt����P�@��u9�#�MB=b^`�i�mMԧ�R��`���6���L���C���g)�h~�g�C��%�X��u�%w��� �XK!�@�Z�H��,.��1��Z+3|+)��T
��3�Y��6dS^�+OII����C��V�T�)~Am~?�EI9��*�y�K�c
+�3/=�]����$hQ��[�u��=v�>�Ϗ�Խ��-j8����D������ۋyp#�m�l77��S���٨~�o5��F�<g��m�b=�����F7����wT�Z=����t��  x�V�k#��b[�.yw�=ҳ2�$K^N�~ZZ�W,�'	���IU�R��Z$�d�3$��rJN}L&�����	�<9�9�@r9�1�|��Xv&�-$L��m���}�w��1�������J���(�LE�PE7t�X��|�Y�.NS������c29Au�ՙ��t�}�%���/���kdjҖ��[zUs�OU�sH8�\_!q�&;����f��>i	�t=�fnI��1�m�$����do��ț�v�xI)�&��rMw���L��46�Teצ
���jx����I��"A�9	�N�G�q�¹��rp:釥���ɱ(��P��7��:ӊ�z@�*��O\,KC��.k�ʶ��c��p�ؼI�-ù��JJ��T��|Rk��*Wl���q�CkL�>Ɍ$I$q��ɨ��h�2t3�1�'�3�\э�A���s(�.P�R"��ٲ�W*�ò��v��ё�,Z��u��s��l��<��Uf|��ڦ�W�D�o�����`v*(y�e`��Ҫqv�\�˼�QC�����KMU7�dxHJH���K�+�fQ��-�`���Y����
-�l�j��L�2Uv[�\��m�*�������m� Z�	: ��W%2:":_Ga��D�=
j�C�d
]��{���)�5��l�bO��*�f�m�m�.C�Tf����Ҏ�j�:�/�Q��>��̳��(%��i�U�1�R��3&��E�n��/���3E��u1,(D3_� ^Ayl�#w�5N�ɉVe���r\�K&��$�Q���Ui|��j<+�avd,�3p�՞�u�0�-29�kL��*�>3X� <�D1�L�j�d�@?���:Z����2�\�s10���]v����f��'z1=��@�,��D�Bw�f{�,P�=3w=� �a/%����n��b�Ay�ʲ�Y�����"�D�u��ԕ�}��>�$2�������4(�j�F�9� 2P��2�.���?�4�d�.zLt� ��T��o����4;S���Omf����*+Y�i�ev �T�3MW]1<C���׮ ��+��L��u���U^�����@����n3bp�0��L,�!��F�w��#;���͢n�N��%��%�q��;�s\������ܬ-b*|�,yfQ�7�$����3K�u����0
ZG���Ɣm���-�R��6uw!�"�..�[ו/t#��U!�h�ܡu�k�\j������w;V�<_�1�9j�@24(%�^�e��P�F���w�.��ZLM{1�ۚz��2�^<�/����["�O�W��ب(��x���Ǆtv6|�3i�8w�i��ڮ!��an�(�kdz
y�j���>��i�忒Lgp�hGC_V�&��/�}�!�3펫>��=�ձs h4"%�W��5#\����>�M�A�n�Z˄ү�����M�Z=�/cQ_�+����0v��ܫj"}�hg��/]݊�D&���װ�2nK�����w�w��Ԅpׅr`��w�Q���3���j
s�M�=�X<f-%�aⶱ���y�;F��^�����{b�`�U2p�zcԘ�X�v�D����Gߙ���ן�i�*����K�ȶ��Ԥ�Z�~K�n�h<_�.�=j瞥��uٚ���c��ob�5��6�B�S����Pl<f�O��U�-�?ԣ#�:��2 �Z�<\lw����o �K^�/:[Ƚ�����}Rē���?O_��#�e3�1��d�o���~9P��l/H~ߌ�$�Ƒ���#��8��く������lFo����T ��|����$������|�lϚ��ח���I��|���r��d�����#ۿݾ:�w @޺x����_Bd���j���k��&!2|�(�W?}|���������Qa|��ajپw���ٱ��m�5��Z��6ܲ���w������۶�1���¶���j#{q�i��1�h��y�7}5.L��������{��G��@4pu�l�/VF���|!���}���/��2�ϯ�����D�|������J x��l�U��9罷?�u5�	6\I�0�D$���u2`�l�1��Jh��
�����e�`�ck]5�v׷�k	1�c�1�'� ���|��=�N���=<?�Ϗs����\�P�T�%%���rN	:D��!�gեUI�.T���E?8b#
~�Kffƙ��M#h�@��8�&!T?���]a��'+��?}ӆި����iS�
+~�j@���Cp�#d�"�Xb]:��k^Jct��\p�Ap�@GpD`�>D���z���N�� Tee�厽&�x8��Je�Ɵ�����J�4�Ǥ8�H8t �`%��b��B]�a  ���Pp��"~X�]@1�C�k�?[`S|1�BpHG/ģ=/3*�pʖ��o�&f/~XM̶�9�	�F�V8B�e����f�\x��"B�@���C65�����iQ�_�iS<c�@h��l�a=�hV�٣U����T����vI/�����L0��8:c8�BU���2�!TGD��)k��|Vˡ8�.@:���XR��k.��JC�FB��M�Hуú����H����H��������ğXLV\D6:��B#(���#��c� P'�:%,tX!8C�����u�j��-)_qyu�`A@�TDj#��ԋk�.D0"��H�8�.��<�&"}���̧��gnے/ؓOq�NI��a��,Ӣ�6�+T�". DkXA��R�]�A"xD �Ă�J�#�o5���oO��I�$mR�7�d�q�۝_����w'~}Rܔ�jߔ�m��cq}���ec��/vQ�U����X��[\�"5��Ώ���o��Y��1�\8E�[0e&�,h��i��y�����%�*[��k��.Ү�D�-�~C��_�B��!�w8�����}�O[���.�n�]�
A��BH�5I���T��QHi�{�|ڦL��*�K	c�R�0(tq5�x�M��C�	�}�p�1�Џz�9��}/^d��uiߴh�km!Ē
5D14��D�1�M2n<(�P6Z�N�A�3~�uf���ou����V���n�����i`0�XGЩ�����-+��<�b∄Eg�a@�����pF�08HD���8�������&�WZ�c�*[4�'���B�.KI�Ϲ��i`���Jy�kP�p� �02t@�a%��'�2 �
")q��Ê$&g� %~u)1�08�q������a�ё�H<b!�Rp (D����x�����>���Ix�'��ћO��xR~n��ºz�P[^/ݏ���C��*�l`1 b�8s/����&' }ȥ�9��&�W@z�=�l8K?W(��p!m�������[�����+r�(Q��:����ݓ�R����G�F�� *�$/�M�l�R�~4] ��n�}��x9���j:���]����$m�y}���
�]ހg�7T�����\�J�4٫�N��V�1�����������_���]��Gk��m\��`��8�-^��l5���3�o�����?�����>�������M�'��tţ.�<f�)����a`�,Gt�V���iB�p�
~�Db�� ���?q��\�s`/�9��B�M�_[Y���?ƅb�l�r����Dօ����&�N�F	��|[���G���8�b[n$uc ���F)"{t �X5.aH����<" ��� D"��G^ �Qb�b�����A0����L�tDP���A(�R�c��!�ŵ��f������I�H�3��7�/��/N94J��a��<%_D�}�|a�,T3���
���z��gFR=3x���k�֓�X�:,[���^
�˾��gN��䴑ktج�цDO�sjUƩ�G���:ap�,VN�����+�oJ�������ο�����K �8@@(	?��#"�L� �q��0��BpA\�}�ገ_䈠8H��xT�!��X��G6\�Kd�f����� ;�I�ܨ��{R�+��4�c�7��g��(
��	:@�:j�\P  D��_]����p���gr@bD�[��U�y��*D�7��͓9�gμ�>��7�Ix��K�,)v$���9��%x����|��=h)�9}�h�����_�~*���j�b�P<p��ӞfaS�g@�@��9��٠[���|��P����ĳp�B���ȍ3:����;õ	6�A�K�7L����+ihzDZE�c[E���0Ґ�r"�!����1fGV��8�pab��ׁٽ�h�YU���p�&�����K�B�T�ɉ��1o4�����>ttN�� @Q+�9(\�b��!V@S�!������ ?\��������L2<�$��_��〚}��Tޮ�D�7��Tù��ȹJs�z)������$
H{A�p��@�<����8B8&
%pz�=�Q���k���|K�׷���C�d�I@R�X���7���S�7
��q���ډc}�!��� �@�[����.��%��+}<ѐ^��q���_|�'w�Ho�k��Z�T{�w����XZ`����=g�97-H�J�G����#+��;�%���M3'o�ɍ��u�^�Fv
_�ά��v�2���t-�ɬhM��]sͲ��ѻFs�s�>���krO4��72�����r�{�_��3��[�͓�����o����o��T�o��̆M��J�0~ۅ_�<=���zd������(�'|-2�妺s���ٟ�0]�k^jR)���ؚe�9�s��p���ܷq�����{��pnd��������u��m�p�=��JY��L���,�Z5�uz���V~ozhR�>�k��gZ����N���>���,�;9?�;�����l��yVY��L+��VOܐeW�Q_V�Z=qc�}I=�����:����E�U֧Zļ�ղ����[Wח%ə�ղ�����c kYz�t�z����E~�e��%���ko�/����!�=}��=�  ����}LUu�S��M�@EŗPP�&
t�97&M��r8:V��E��b�X���"���b��[ٛY��4g����Z���c��^������w�o�8������l�s��>WM�(��"j���&�=��|-1���T
}���J���4
�E5�)����lO*,_KL�BJ�R����"U�.��Ԏsâ)Tj��Ӓ&��Jk��[��^�$r��k��u���ܰh�����o�Md{Ra�Zb �ގ?�;ֺ��ގ��ܰ����x�Md{Ra�Z�(�J##ù���%X���ùOqâ�H ��gٞL.+��m%�V�$r���n[Y�`;7,�۶ ^�
gٞTX��8�#%߆),1&�M-XGJ�	~7"ZS���|d��E�'��%�����]y�n��:���h�ulI��U�9J�drY���ky��eV�Y�	֮奺6�v-/׵��$M*,_KV q:\�k�K+X�ĩpA'`g�_p��4��|-qX���Owc-N�8���{D?�`���}�s����ƃ�����8Y�+���Ͽ�X������%iRa�ZbXtn��US�~me��F�2� ��U�]�q��4��|-1�3�{�����w>�L�:���޲��t���s����.+���z[^�N�傕�@c`%2��m���$M*,_K��7�L��e�%f	Vo�J�?xq1�\��D��q*M*,_K�+��m�9������Uhd�������9�9J�drY�J��1�%�Z7k�`��ߩ��D���h��%iRa�Z�D������%���7N����z�'ܰ�:��q�&I�����}q��@� ߊ�����I��ʲ�Щ�n�$���e���E������I��P�����.����g��#p�"4����u�_8��ބ<8�अ���7��S'���b7n��5�Gc7,j\Ro{��IҤ��ޛ�k�����1����ܸ)��ˉF����F{/g��ɡppS�;Z9Ҹ���n�T�;zrâ� ���$iR��֊������@b���Ѝ��O�1�Ⱦ���l�4��\km�"����"~���<��.Fc67,�~y)g��ɡp/{�M��}���/qn��U݆F7,�:�\��$iR�Ik��a��:�Z���W�`M��� nXt�g�^�&I�
˵�W<<�|�z����Ӽ"._�zF��7,�y�o�&I�C�:=�f ��C;�+r�f���h|��V�����$iR��Z�L�j_�47�ߡ3�vK�aQm�Z�&I�
˵�'��;tp�+�4����Ͳq�Ѹ�mnB���I��P8/�m���ۼ�H�Yn�l7�/��2nX����&I�
NZ(��:���]ܖ��FLv��-�h��UZ��C�Ln�$M*8�Z��+ nG�F���w�
n�7��vԠ]��$ir(\����/M��&�kl��6g��`S^Q*
,Ҷ#�q6I�ypP�������6��l�j���<�m����n4vrâ�Sn4�;9�$M*8�R���+.p�V��}�w|�
\`/qâ��ȇ8�$M����R��kܳި�_�\��5�G�n���)��9�����I�Z�IOnp鱛����k�'p���Q���E��l�4��\k=�7���&�v��On���7�arâ�ϐ8�$M����Z��kݺ�hYß[\���^�F57,j=�|g��I�Z��w%p�ޔ~��7^)p���ھT�s�4�व���ĥ�`-,�F˾Q��&��
�%�S+(X�u
V�u\�|��%M*,i��ZW�%�K�*���R��,iRa�Z�B��]�`-,�"˾H��&��*K\�V�`ٷ(X�-
�4���%�W��ޏ����H��[8�N�Tp�V�,qK:X�˾B���P����J�W��U*X��	�}�%M*,i��?��%�H�L���,��K�TX��X���r��/O���,i�Y�  ����]lSe��I��1�+�Ɍ�n�6X����gP�
����-���fp�]��H$Ņ!���A��M0j�NQ��a�$DI����
��vI{�����ߞ��iO�o%�y`�Ś�,z���9����M��Y���0�(�e}��K������Y�5�Y����>`��`Y�⬏�Z�,���EY�D���k��Y���Y����>`�N��+qX���X��EY�(�����g},V3�(�e}����MT`q��b)fQ�,���%:=,_��ŉ��2��>`Q�,�,�,��X�fQ�,���%:=,_��,��X��̢�X��KtzX�6q	X���XK�EY�(������>+�,���EY�D���k���Y�(��K�EY�)���D�'�a���e`qb�b-ce}���X�3X�r�8�c��3��>`Q�,��a���`qb�b�`e}���X����+��Ď�Zɬ?�g}���X�3XV,N�X�(�(�e}����M\'v,�*fQ�,���%:=,_��,N�X��̢�X��Kt�j�;��Y����>`�N��&��ŉ���,���EY�D���k׀ŉ���Y����>`���X���*��d-p�۱pkG��(�����|me;X��.�n��:�ل�76��	TS=׾õ�Y]�*�w]'{F��}�����J��!d�$�������l���K����J;��hx�37�5_ҟ��?��Tz3n]rCq���0c�3Z4��W4�s��#Z�=>���Tf �I2+z�}�\���I,=g�~-ڰC��4v��<�S1G�
�����H���jH�r����T�[�j#T���Q���֬6�*��[����W����עm<Օ
T��J�jS1ՐP�X5����@3��?��k�Yń*��_��J��~75fu�^h+5�򿌉K��R��S"�t�SzJ�{�D�/��O�#i�'<����Euu
.;8�#X���q��Q�J�Ǽ��;����Wm�*�����p7�dL��A=j�r���:v�����f���RW̋�z#�B��ٷ���'fEBϾ��?�:�E'`�����ӟ*���Z�f5�Ċ�͊�n�yA鰩cZt��2;�q3���r뱴�q43<����X*:�Õ췂�9Xُԗx��Q�����.�Zp�o;q�7A_���U5aD��o�ep��E�1�j0�N��
����MS��,����ai���`���P�qK�k;�RGFU�K�J��C��kѪ�~/Ը�pս7�=7���q%�U׎Ǳ���Qn������P��J�u�~���l�%ƕb��;��p��u�˟7u^�ւK�˗k\Û�sC�5�k�����V� k�8�^S��,���N�"]a�ڶ��NvEfb�,�+r�+��k�Zp5�.��>7~}
\�.�E�Y�p�[s9��@}���Z��tP�U���g���.��v�	O�=�?;�;���ỡ����]�O��~�	ViŊMfEBG�F���cZt�[�8T��i��rG'�Ԥ�J3�����8�7�_F��YӢ3X�n���ι�����gj7�f���c�rF�u����h�)�3�#=�L��	O�=��T�g|<��n|`2�gR��Z��)��P���X�m�dtx�7~���Z���Xs�	o���{%�ޠ��lH�r�i��W��
^���e�q�ߘ�\8W��e^[�\4k2���MݯEo�s듰�ַp��   ����t�����;"��Ѻb�IȃE���;A��
�&&Y@7��J�L��$Q#	���!��d�Rk�*��ۣ �*m�� �7��; ZV8������o�k��^���V�[n�yn-p˃=uy$+\v�-5��9�{!��Ցg`S�e�+qN��B���|*�+�M���瞽�V>�諾���G�iH�-�����s3�m��Y��̙sq6G~'K��,����?K�~�r���f�d�N�)���]+:���l{ii���%@?�6�XiC�6��(�sg	��g�<�i�*��?>7v,�Z�㘝��`b��^q��P'ɔI'�-c�$B�I�َ��b��$9�K���B���'��������X�z��Lߋ����[���#A8B�R�{J�K���7�e�ҡ��F7�b�ܼ�1+�n���.��?�Ud��|��Z���H��T͆�;��(��]�Z ^���9��Z ��ٽH�b.T�Hw��R�ͫǚh����L�pf�:/�#0/�[q!x5?׏5��h_^�v�E!�7�f	:�	m�	�WBl׼
�kR?��|��*��u^8H�L).S⛕K��7�
|�Ȍ{i<�n[5ֻ����Tk[E
����7-�Q���M��낎*��(4P����4ͩ�h'�Q��-�o�+&�u�jP5HL����Z$��P����z�"7+N9GP�;�!��fE���U_�Q���h5�j�� T���F��@5f�`�}�iF���1�H�Co�c6C[���F���Q+!�kTK�j�`��O먖H�:*�K�~