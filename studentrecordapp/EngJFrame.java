/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentrecordapp;


import Students_Result.Student_Result;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class EngJFrame extends javax.swing.JFrame {

    /**
     * Creates new form EngJFrame
     */
    public EngJFrame() {
        initComponents();
        fillTable();
        
        
       // EngJFrame frame = new EngJFrame();
        //frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
    
    //Show or Add the data to the fields

    public ArrayList<EnglishBean> retrieveData(){
        
        String qry=null;
        PreparedStatement ps=null;

        Connection conn=MySqlConnection();

                        
                    ArrayList<EnglishBean> al=null;
                    al=new ArrayList<EnglishBean>();
                    try{
                        conn=MySqlConnection();
                        String q="SELECT * FROM term1";
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery(q);
                        EnglishBean student;
                        while (rs.next()){
                         student=new EnglishBean(rs.getInt(1), rs.getString("FirstName"),
                         rs.getString("LastName"), rs.getInt(4), rs.getInt(5)
                         , rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)
                         , rs.getInt(10), rs.getInt(11));
                         al.add(student);
                      
                            }
                         return al;
                            }catch (Exception e){
                            System.out.println("Error in retrieveData method: "+e);
                            }
                          return al;
                         
                /*         break;
                         
                          case "2": conn=MySqlConnection();
                        
                    al=null;
                    al=new ArrayList<EnglishBean>();
                    try{
                        conn=MySqlConnection();
                        String q="SELECT * FROM term2";
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery(q);
                        EnglishBean student;
                        while (rs.next()){
                         student=new EnglishBean(rs.getInt(1), rs.getString("FirstName"),
                         rs.getString("LastName"), rs.getInt(4), rs.getInt(5)
                         , rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)
                         , rs.getInt(10), rs.getInt(11), rs.getInt(12));
                         al.add(student);
                      
                            }
                         return al;
                            }catch (Exception e){
                            System.out.println("Error in retrieveData method: "+e);
                            }
                        
                         
                         break;
                         
                          case "3": conn=MySqlConnection();
                        
                    al=null;
                    al=new ArrayList<EnglishBean>();
                    try{
                        conn=MySqlConnection();
                        String q="SELECT * FROM term3";
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery(q);
                        EnglishBean student;
                        while (rs.next()){
                         student=new EnglishBean(rs.getInt(1), rs.getString("FirstName"),
                         rs.getString("LastName"), rs.getInt(4), rs.getInt(5)
                         , rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)
                         , rs.getInt(10), rs.getInt(11), rs.getInt(12));
                         al.add(student);
                      
                            }
                         return al;
                            }catch (Exception e){
                            System.out.println("Error in retrieveData method: "+e);
                            }
                        
                         
                         break;
                         
                          case "4": conn=MySqlConnection();
                        
                    al=null;
                    al=new ArrayList<EnglishBean>();
                    try{
                        conn=MySqlConnection();
                        String q="SELECT * FROM term4";
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery(q);
                        EnglishBean student;
                        while (rs.next()){
                         student=new EnglishBean(rs.getInt(1), rs.getString("FirstName"),
                         rs.getString("LastName"), rs.getInt(4), rs.getInt(5)
                         , rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)
                         , rs.getInt(10), rs.getInt(11), rs.getInt(12));
                         al.add(student);
                      
                            }
                         return al;
                            }catch (Exception e){
                            System.out.println("Error in retrieveData method: "+e);
                            }
                        
                         
                         break;     */
          //  }
            
            
            
  
}
     //show all data to jTable ( fill the table)
    public void fillTable(){
         ArrayList<EnglishBean> al=retrieveData();
         DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
         model.setRowCount(0); //Empty ( clear the table)
   
        Object[] row=new Object[140];
        for (int i = 0; i < al.size(); i++){
            row[0]=al.get(i).getStudent_ID();
            row[1]=al.get(i).getFirstName();
            row[2]=al.get(i).getLastName();
            row[3]=al.get(i).getEnglish();
            row[4]=al.get(i).getET1();
            row[5]=al.get(i).getET2();
            row[6]=al.get(i).getET3();
            row[7]=al.get(i).getEA1();
            row[8]=al.get(i).getEA2();
            row[9]=al.get(i).getEA3();
            row[10]=al.get(i).getEA4();
            model.addRow(row);
    }
    }  
    
    public void ShowItemToFields(int index){
       jTextFieldId.setText(Integer.toString(retrieveData().get(index).getStudent_ID()));
       jTextFieldFName.setText(retrieveData().get(index).getFirstName());
       jTextFieldSName.setText(retrieveData().get(index).getLastName());
       jTextFieldTest1.setText(Integer.toString(retrieveData().get(index).getET1()));
       jTextFieldTest2.setText(Integer.toString(retrieveData().get(index).getET2()));
       jTextFieldTest3.setText(Integer.toString(retrieveData().get(index).getET3()));
       jTextFieldAss1.setText(Integer.toString(retrieveData().get(index).getEA1()));
       jTextFieldAss2.setText(Integer.toString(retrieveData().get(index).getEA2()));
       jTextFieldAss3.setText(Integer.toString(retrieveData().get(index).getEA3()));
       jTextFieldAss4.setText(Integer.toString(retrieveData().get(index).getEA4()));
       jTextFieldTotal.setText(Integer.toString(retrieveData().get(index).getEnglish()));
      
     
            
       
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
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTest1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldAss1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldSName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTest2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldAss2 = new javax.swing.JTextField();
        jTextFieldId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTest3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldAss3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldAss4 = new javax.swing.JTextField();
        jButtonExit = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jtxtSearch = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Enter tests and assignments marks for English: Term 1");

        jLabel1.setText("Firstname");

        jTextFieldFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Test 1");

        jLabel12.setText("Assignment 1");

        jLabel6.setText("Surname");

        jLabel2.setText("Test 2");

        jLabel11.setText("Assignment 2");

        jLabel8.setText("ID ");

        jLabel4.setText("Test 3");

        jLabel10.setText("Assignment 3");

        jLabel5.setText("Total");

        jLabel9.setText("Assignment 4");

        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "StudenID", "First Name", "Last Name", "English Score", "Test 1", "Test 2", "Test 3", "Assmnt 1", "Assmnt 2", "Assmnt 3", "Assmnt 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

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

        jLabel16.setBackground(new java.awt.Color(0, 102, 102));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("SEARCH:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addComponent(jTextFieldFName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldSName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldId, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jButtonAdd))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTest2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTest3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAss4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAss3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonExit)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAss2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAss1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(21, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldSName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldTest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jTextFieldAss1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextFieldTest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(43, 43, 43)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextFieldTest3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel10))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldAss2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jTextFieldAss3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldAss4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdd)
                            .addComponent(jButtonUpdate)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(352, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(56, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 767, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFNameActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // exits out of the window
        try{
            dispose();
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // Updates the total of english marks to database
        String qry=null;
        PreparedStatement ps=null;

        Connection conn=MySqlConnection();

        if(jTextFieldId!=null && jTextFieldFName!=null && jTextFieldSName!=null
            || jTextFieldTest1!=null || jTextFieldTest2!=null || jTextFieldTest3!=null
            || jTextFieldTotal!=null || jTextFieldAss1!= null || jTextFieldAss2!=null
            || jTextFieldAss3!=null || jTextFieldAss4!=null){

            conn=MySqlConnection();
                 try{
                        qry=null;
                        ps=null;
                        qry="update term1 set FirstName=?, LastName=? , ET1=?, ET2=?, "
                        + "ET3=?, EA1=?,EA2=?, EA3=?, EA4=?, English=? "
                        +" where StudentID=?";
                        ps=conn.prepareStatement(qry);
                        ps.setString(1, jTextFieldFName.getText());
                        ps.setString(2, jTextFieldSName.getText());
                        ps.setInt(3, Integer.parseInt(jTextFieldTest1.getText()));
                        ps.setInt(4, Integer.parseInt(jTextFieldTest2.getText()));
                
                        ps.setInt(5, Integer.parseInt(jTextFieldTest3.getText()));
                        ps.setInt(6, Integer.parseInt(jTextFieldAss1.getText()));
                        ps.setInt(7, Integer.parseInt(jTextFieldAss2.getText()));
                        ps.setInt(8, Integer.parseInt(jTextFieldAss3.getText()));
                        ps.setInt(9, Integer.parseInt(jTextFieldAss4.getText()));
                        ps.setInt(10, Integer.parseInt(jTextFieldTotal.getText()));
                        ps.setInt(11, Integer.parseInt(jTextFieldId.getText()));
                                       
                              
                        int res=ps.executeUpdate();
                        
                        if(res>=1){
                        JOptionPane.showMessageDialog(null, res+" Number of students"
                        +" updated successfully...");                   
                        }else
                        JOptionPane.showMessageDialog(null, " Student updation fail: term1...");       
                        
         
                     }catch(Exception e){
                      JOptionPane.showMessageDialog(null, e);
                    }
                     
                    try{
                          //adds the english mark to the overall db         
                        String qry4=null;
                        PreparedStatement ps4=null;
                        qry4="update overall set FirstName=?, LastName=? , ET1=?, ET2=?, "
                        + "ET3=?, EA1=?,EA2=?, EA3=?, EA4=?, English=? "
                        +" where StudentID=?";
                        ps4=conn.prepareStatement(qry4);
                        ps4.setString(1, jTextFieldFName.getText());
                        ps4.setString(2, jTextFieldSName.getText());
                        ps4.setInt(3, Integer.parseInt(jTextFieldTest1.getText()));
                        ps4.setInt(4, Integer.parseInt(jTextFieldTest2.getText()));
                
                        ps4.setInt(5, Integer.parseInt(jTextFieldTest3.getText()));
                        ps4.setInt(6, Integer.parseInt(jTextFieldAss1.getText()));
                        ps4.setInt(7, Integer.parseInt(jTextFieldAss2.getText()));
                        ps4.setInt(8, Integer.parseInt(jTextFieldAss3.getText()));
                        ps4.setInt(9, Integer.parseInt(jTextFieldAss4.getText()));
                        ps4.setInt(10, Integer.parseInt(jTextFieldTotal.getText()));
                        ps4.setInt(11, Integer.parseInt(jTextFieldId.getText()));
                                       
                              
                        int res4=ps4.executeUpdate();
                        
                        if(res4>=1){
                        JOptionPane.showMessageDialog(null, res4+" Number of students"
                        +" updated successfully into overall database");                   
                        }else
                        JOptionPane.showMessageDialog(null, " Student updation fail: term1 ***");       
                        
                       
                     }catch(Exception e){
                         JOptionPane.showMessageDialog(null,e);
                     }
                     
                     
                     //calculates the new Total Score and updates the database
                     
                     String qry2=null;
                     PreparedStatement ps2=null;
        
           qry2 = "UPDATE term1" 
              + " SET Total_Score = English+Science+Social_Science" 
               + "+Maths+MAL+HPE+Arts" 
               + " WHERE StudentID = ?";
            
         int res2;
         try{
             ps2 = conn.prepareStatement(qry2);
             ps2.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res2=ps2.executeUpdate();
             
             
         }catch(Exception e){
             JOptionPane.showMessageDialog(null , e);
           
             
         }
         
         //updates the overall db with the Total Score the student
                     
                     String qry5=null;
                     PreparedStatement ps5=null;
        
           qry5 = "UPDATE overall" 
              + " SET Total_Score = English+Science+Social_Science" 
               + "+Maths+MAL+HPE+Arts" 
               + " WHERE StudentID = ?";
            
         int res5;
         try{
             ps5 = conn.prepareStatement(qry5);
             ps5.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res5=ps5.executeUpdate();
             
             
         }catch(Exception e){
             JOptionPane.showMessageDialog(null , e);
           
             
         }
         
     //Calculates the new average and updates database
          String qry3=null;
          //String ps3=null;
          PreparedStatement ps3=null;
         qry3="UPDATE term1 SET Average = Total_Score/7 WHERE StudentID = ?";
         int res3;
         try{
             ps3=conn.prepareStatement(qry3);
             ps3.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res3=ps3.executeUpdate();
         }catch(Exception e){
             
             JOptionPane.showMessageDialog(null,e);
         }
//Calculates the new average and updates the overall database
          String qry6=null;
          
          PreparedStatement ps6=null;
         qry6="UPDATE overall SET Average = Total_Score/28 WHERE StudentID = ?";
         int res6;
         try{
             ps6=conn.prepareStatement(qry6);
             ps6.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res6=ps6.executeUpdate();
         }catch(Exception e){
             
             JOptionPane.showMessageDialog(null,e);
         }
           

    /*            break;
                case "2": conn=MySqlConnection();
                try{
                         qry=null;
                         ps=null;
                        qry="update term2 set FirstName=?, LastName=? , ET1=?, ET2=?, "
                        + "ET3=?, EA1=?,EA2=?, EA3=?, EA4=?, English=? "
                        +" where StudentID=?";
                        ps=conn.prepareStatement(qry);
                        ps.setString(1, jTextFieldFName.getText());
                        ps.setString(2, jTextFieldSName.getText());
                        ps.setInt(3, Integer.parseInt(jTextFieldTest1.getText()));
                        ps.setInt(4, Integer.parseInt(jTextFieldTest2.getText()));
                
                        ps.setInt(5, Integer.parseInt(jTextFieldTest3.getText()));
                        ps.setInt(6, Integer.parseInt(jTextFieldAss1.getText()));
                        ps.setInt(7, Integer.parseInt(jTextFieldAss2.getText()));
                        ps.setInt(8, Integer.parseInt(jTextFieldAss3.getText()));
                        ps.setInt(9, Integer.parseInt(jTextFieldAss4.getText()));
                        ps.setInt(10, Integer.parseInt(jTextFieldTotal.getText()));
                        ps.setInt(11, Integer.parseInt(jTextFieldId.getText()));
                                       
                              
                        int res=ps.executeUpdate();
                        
                        if(res>=1){
                        JOptionPane.showMessageDialog(null, res+" Number of students"
                        +" updated successfully...");                   
                        }else
                        JOptionPane.showMessageDialog(null, " Student updation fail: term2...");       
                        
         
                     }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                        }
                     
                     try{
                          //adds the english mark to the overall db         
             
                         PreparedStatement ps4=null;
                         String qry4=null;
                        qry4="update overall set FirstName=?, LastName=? , ET1=?, ET2=?, "
                        + "ET3=?, EA1=?,EA2=?, EA3=?, EA4=?, English=? "
                        +" where StudentID=?";
                        ps4=conn.prepareStatement(qry4);
                        ps4.setString(1, jTextFieldFName.getText());
                        ps4.setString(2, jTextFieldSName.getText());
                        ps4.setInt(3, Integer.parseInt(jTextFieldTest1.getText()));
                        ps4.setInt(4, Integer.parseInt(jTextFieldTest2.getText()));
                
                        ps4.setInt(5, Integer.parseInt(jTextFieldTest3.getText()));
                        ps4.setInt(6, Integer.parseInt(jTextFieldAss1.getText()));
                        ps4.setInt(7, Integer.parseInt(jTextFieldAss2.getText()));
                        ps4.setInt(8, Integer.parseInt(jTextFieldAss3.getText()));
                        ps4.setInt(9, Integer.parseInt(jTextFieldAss4.getText()));
                        ps4.setInt(10, Integer.parseInt(jTextFieldTotal.getText()));
                        ps4.setInt(11, Integer.parseInt(jTextFieldId.getText()));
                                       
                              
                        int res4=ps4.executeUpdate();
                        if(res4>=1){
                        JOptionPane.showMessageDialog(null, res4+" Number of students"
                        +" updated in overall database...");                   
                        }else
                        JOptionPane.showMessageDialog(null, " Student updation fail: term1...");       
                        
                        
                     }catch(Exception e){
                         JOptionPane.showMessageDialog(null,e);
                     }
                     
                     
                     //calculates the new Total Score and updates the database
                     
                     qry2=null;
                     ps2=null;
        
           qry2 = "UPDATE term2" 
              + " SET Total_Score = English+Science+Social_Science" 
               + "+Maths+MAL+HPE+Arts" 
               + " WHERE StudentID = ?";
            
         
         try{
             ps2 = conn.prepareStatement(qry2);
             ps2.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res2=ps2.executeUpdate();
             
             
         }catch(Exception e){
             JOptionPane.showMessageDialog(null , e);
           
             
         }
         
         //updates the overall db with the Total Score the student
                     
                     qry5=null;
                     ps5=null;
        
           qry5 = "UPDATE overall" 
              + " SET Total_Score = English+Science+Social_Science" 
               + "+Maths+MAL+HPE+Arts" 
               + " WHERE StudentID = ?";
            
        // int res5;
         try{
             ps5 = conn.prepareStatement(qry5);
             ps5.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res5=ps5.executeUpdate();
             
             
         }catch(Exception e){
             JOptionPane.showMessageDialog(null , e);
           
             
         }
         
     //Calculates the new average and updates database
          qry3=null;
          //String ps3=null;
          ps3=null;
         qry3="UPDATE term2 SET Average = Total_Score/7 WHERE StudentID = ?";
         //int res3;
         try{
             ps3=conn.prepareStatement(qry3);
             ps3.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res3=ps3.executeUpdate();
         }catch(Exception e){
             
             JOptionPane.showMessageDialog(null,e);
         }
//Calculates the new average and updates the overall database
          qry6=null;
          
          ps6=null;
         qry6="UPDATE overall SET Average = Total_Score/7 WHERE StudentID = ?";
         //int res6;
         try{
             ps6=conn.prepareStatement(qry6);
             ps6.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res6=ps6.executeUpdate();
         }catch(Exception e){
             
             JOptionPane.showMessageDialog(null,e);
         }

                break;
                case "3": conn=MySqlConnection();
                try{
                    
                         qry=null;
                         ps=null;
                        qry="update term3 set FirstName=?, LastName=? , ET1=?, ET2=?, "
                        + "ET3=?, EA1=?,EA2=?, EA3=?, EA4=?, English=? "
                        +" where StudentID=?";
                        ps=conn.prepareStatement(qry);
                        ps.setString(1, jTextFieldFName.getText());
                        ps.setString(2, jTextFieldSName.getText());
                        ps.setInt(3, Integer.parseInt(jTextFieldTest1.getText()));
                        ps.setInt(4, Integer.parseInt(jTextFieldTest2.getText()));
                
                        ps.setInt(5, Integer.parseInt(jTextFieldTest3.getText()));
                        ps.setInt(6, Integer.parseInt(jTextFieldAss1.getText()));
                        ps.setInt(7, Integer.parseInt(jTextFieldAss2.getText()));
                        ps.setInt(8, Integer.parseInt(jTextFieldAss3.getText()));
                        ps.setInt(9, Integer.parseInt(jTextFieldAss4.getText()));
                        ps.setInt(10, Integer.parseInt(jTextFieldTotal.getText()));
                        ps.setInt(11, Integer.parseInt(jTextFieldId.getText()));
                                       
                              
                        int res=ps.executeUpdate();
                        
                        if(res>=1){
                        JOptionPane.showMessageDialog(null, res+" Number of students"
                        +" updated successfully...");                   
                        }else
                        JOptionPane.showMessageDialog(null, " Student updation fail: term3...");       
                        
         
                     }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                        }
                     
                     try{
                          //adds the english mark to the overall db         
             
                         PreparedStatement ps4=null;
                         String qry4=null;
                        qry4="update overall set FirstName=?, LastName=? , ET1=?, ET2=?, "
                        + "ET3=?, EA1=?,EA2=?, EA3=?, EA4=?, English=? "
                        +" where StudentID=?";
                        ps4=conn.prepareStatement(qry4);
                        ps4.setString(1, jTextFieldFName.getText());
                        ps4.setString(2, jTextFieldSName.getText());
                        ps4.setInt(3, Integer.parseInt(jTextFieldTest1.getText()));
                        ps4.setInt(4, Integer.parseInt(jTextFieldTest2.getText()));
                
                        ps4.setInt(5, Integer.parseInt(jTextFieldTest3.getText()));
                        ps4.setInt(6, Integer.parseInt(jTextFieldAss1.getText()));
                        ps4.setInt(7, Integer.parseInt(jTextFieldAss2.getText()));
                        ps4.setInt(8, Integer.parseInt(jTextFieldAss3.getText()));
                        ps4.setInt(9, Integer.parseInt(jTextFieldAss4.getText()));
                        ps4.setInt(10, Integer.parseInt(jTextFieldTotal.getText()));
                        ps4.setInt(11, Integer.parseInt(jTextFieldId.getText()));
                                       
                              
                        int res4=ps4.executeUpdate();
                        if(res4>=1){
                        JOptionPane.showMessageDialog(null, res4+" Number of students"
                        +" updated in overall database...");                   
                        }else
                        JOptionPane.showMessageDialog(null, " Student updation fail: term3...");       
                        
                        
                     }catch(Exception e){
                         JOptionPane.showMessageDialog(null,e);
                     }
                     
                     
                     //calculates the new Total Score and updates the database
                     
                     qry2=null;
                     ps2=null;
        
           qry2 = "UPDATE term3" 
              + " SET Total_Score = English+Science+Social_Science" 
               + "+Maths+MAL+HPE+Arts" 
               + " WHERE StudentID = ?";
            
         //int res2;
         try{
             ps2 = conn.prepareStatement(qry2);
             ps2.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res2=ps2.executeUpdate();
             
             
         }catch(Exception e){
             JOptionPane.showMessageDialog(null , e);
           
             
         }
         
         //updates the overall db with the Total Score the student
                     
                     qry5=null;
                     ps5=null;
        
           qry5 = "UPDATE overall" 
              + " SET Total_Score = English+Science+Social_Science" 
               + "+Maths+MAL+HPE+Arts" 
               + " WHERE StudentID = ?";
            
         //int res5;
         try{
             ps5 = conn.prepareStatement(qry5);
             ps5.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res5=ps5.executeUpdate();
             
             
         }catch(Exception e){
             JOptionPane.showMessageDialog(null , e);
           
             
         }
         
     //Calculates the new average and updates database
          qry3=null;
          //String ps3=null;
          ps3=null;
         qry3="UPDATE term3 SET Average = Total_Score/7 WHERE StudentID = ?";
         //int res3;
         try{
             ps3=conn.prepareStatement(qry3);
             ps3.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res3=ps3.executeUpdate();
         }catch(Exception e){
             
             JOptionPane.showMessageDialog(null,e);
         }
//Calculates the new average and updates the overall database
          qry6=null;
          
          ps6=null;
         qry6="UPDATE overall SET Average = Total_Score/7 WHERE StudentID = ?";
         //int res6;
         try{
             ps6=conn.prepareStatement(qry6);
             ps6.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res6=ps6.executeUpdate();
         }catch(Exception e){
             
             JOptionPane.showMessageDialog(null,e);
          }

                break;
                case "4": conn=MySqlConnection();
                try{
                         qry=null;
                         ps=null;
                        qry="update term4 set FirstName=?, LastName=? , ET1=?, ET2=?, "
                        + "ET3=?, EA1=?,EA2=?, EA3=?, EA4=?, English=? "
                        +" where StudentID=?";
                        ps=conn.prepareStatement(qry);
                        ps.setString(1, jTextFieldFName.getText());
                        ps.setString(2, jTextFieldSName.getText());
                        ps.setInt(3, Integer.parseInt(jTextFieldTest1.getText()));
                        ps.setInt(4, Integer.parseInt(jTextFieldTest2.getText()));
                
                        ps.setInt(5, Integer.parseInt(jTextFieldTest3.getText()));
                        ps.setInt(6, Integer.parseInt(jTextFieldAss1.getText()));
                        ps.setInt(7, Integer.parseInt(jTextFieldAss2.getText()));
                        ps.setInt(8, Integer.parseInt(jTextFieldAss3.getText()));
                        ps.setInt(9, Integer.parseInt(jTextFieldAss4.getText()));
                        ps.setInt(10, Integer.parseInt(jTextFieldTotal.getText()));
                        ps.setInt(11, Integer.parseInt(jTextFieldId.getText()));
                                       
                              
                        int res=ps.executeUpdate();
                        
                        if(res>=1){
                        JOptionPane.showMessageDialog(null, res+" Number of students"
                        +" updated successfully...");                   
                        }else
                        JOptionPane.showMessageDialog(null, " Student updation fail: term4...");       
                        
         
                     }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                        }
                     
                     try{
                          //adds the english mark to the overall db         
             
                         PreparedStatement ps4=null;
                         String qry4=null;
                        qry4="update overall set FirstName=?, LastName=? , ET1=?, ET2=?, "
                        + "ET3=?, EA1=?,EA2=?, EA3=?, EA4=?, English=? "
                        +" where StudentID=?";
                        ps4=conn.prepareStatement(qry4);
                        ps4.setString(1, jTextFieldFName.getText());
                        ps4.setString(2, jTextFieldSName.getText());
                        ps4.setInt(3, Integer.parseInt(jTextFieldTest1.getText()));
                        ps4.setInt(4, Integer.parseInt(jTextFieldTest2.getText()));
                
                        ps4.setInt(5, Integer.parseInt(jTextFieldTest3.getText()));
                        ps4.setInt(6, Integer.parseInt(jTextFieldAss1.getText()));
                        ps4.setInt(7, Integer.parseInt(jTextFieldAss2.getText()));
                        ps4.setInt(8, Integer.parseInt(jTextFieldAss3.getText()));
                        ps4.setInt(9, Integer.parseInt(jTextFieldAss4.getText()));
                        ps4.setInt(10, Integer.parseInt(jTextFieldTotal.getText()));
                        ps4.setInt(11, Integer.parseInt(jTextFieldId.getText()));
                                       
                              
                        int res4=ps4.executeUpdate();
                        if(res4>=1){
                        JOptionPane.showMessageDialog(null, res4+" Number of students"
                        +" updated in overall database...");                   
                        }else
                        JOptionPane.showMessageDialog(null, " Student updation fail: term4...");       
                        
                        
                     }catch(Exception e){
                         JOptionPane.showMessageDialog(null,e);
                     }
                     
                     
                     //calculates the new Total Score and updates the database
                     
                     qry2=null;
                     ps2=null;
        
           qry2 = "UPDATE term4" 
              + " SET Total_Score = English+Science+Social_Science" 
               + "+Maths+MAL+HPE+Arts" 
               + " WHERE StudentID = ?";
            
        
         try{
             ps2 = conn.prepareStatement(qry2);
             ps2.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res2=ps2.executeUpdate();
             
             
         }catch(Exception e){
             JOptionPane.showMessageDialog(null , e);
           
             
         }
         
         //updates the overall db with the Total Score the student
                     
                qry5=null;
                ps5=null;
        
           qry5 = "UPDATE overall" 
              + " SET Total_Score = English+Science+Social_Science" 
               + "+Maths+MAL+HPE+Arts" 
               + " WHERE StudentID = ?";
            
         
         try{
             ps5 = conn.prepareStatement(qry5);
             ps5.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res5=ps5.executeUpdate();
             
             
         }catch(Exception e){
             JOptionPane.showMessageDialog(null , e);
           
             
         }
         
     //Calculates the new average and updates database
          qry3=null;
          //String ps3=null;
           ps3=null;
         qry3="UPDATE term4 SET Average = Total_Score/7 WHERE StudentID = ?";
         //int res3;
         try{
             ps3=conn.prepareStatement(qry3);
             ps3.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res3=ps3.executeUpdate();
         }catch(Exception e){
             
             JOptionPane.showMessageDialog(null,e);
         }
//Calculates the new average and updates the overall database
         qry6=null;
          
         ps6=null;
         qry6="UPDATE overall SET Average = Total_Score/7 WHERE StudentID = ?";
         //int res6;
         try{
             ps6=conn.prepareStatement(qry6);
             ps6.setInt(1, Integer.parseInt(jTextFieldId.getText()));
             res6=ps6.executeUpdate();
         }catch(Exception e){
             
             JOptionPane.showMessageDialog(null,e);
         }

                break;
                default: break;                 */

            
        }

    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // Adds all the marks to give total
        double[] R = new double[14];
        R[0] = Double.parseDouble(jTextFieldTest1.getText());
        R[1] = Double.parseDouble(jTextFieldTest2.getText());
        R[2] = Double.parseDouble(jTextFieldTest3.getText());
        R[3] = Double.parseDouble(jTextFieldAss1.getText());
        R[4] = Double.parseDouble(jTextFieldAss2.getText());
        R[5] = Double.parseDouble(jTextFieldAss3.getText());
        R[6] = Double.parseDouble(jTextFieldAss4.getText());

        R[7]= R[0]+R[1]+R[2]+R[3]+R[4]+R[5]+R[6];
        String TotalEngScore = String.format("%.0f", R[7]);
        jTextFieldTotal.setText(TotalEngScore);

    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // code to bring the text in jTable onto the fields when clicked in table
         int ind=jTable2.getSelectedRow();
        ShowItemToFields(ind);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jtxtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtSearchActionPerformed

    private void jtxtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSearchKeyReleased
        ArrayList<StudentBean2> al=null;
        al=new ArrayList<StudentBean2>();
        String val=jtxtSearch.getText().toString();
        try{
            Connection conn=MySqlConnection();
            String qry="select * from term1 where FirstName like '%"+val+"%'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            StudentBean2 student;
            while (rs.next()){
                student =new StudentBean2(rs.getInt(1), rs.getString("FirstName"),
                    rs.getString("LastName"), rs.getInt(4), rs.getInt(13)
                    , rs.getInt(22), rs.getInt(31), rs.getInt(40), rs.getInt(49)
                    , rs.getInt(58), rs.getInt(67), rs.getInt(68), rs.getInt(70)
                    , rs.getString("Grade"));
                al.add(student);
            }
            DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
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
                //row[10]=al.get(i).getTotal_Score();
                row[10]=al.get(i).getTotal_Score();
                row[11]=al.get(i).getGrade();
                row[12]=al.get(i).getGPA();
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
            String qry="select * from term1 where FirstName like '%"+val+"%'";
            //Statement st=conn.createStatement();
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            StudentBean2 student;
            while (rs.next()){
                student =new StudentBean2(rs.getInt(1), rs.getString("FirstName"),
                    rs.getString("Lastname"), rs.getInt(4), rs.getInt(5)
                    , rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)
                    , rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(70),
                    rs.getString("Grade"));
                al.add(student);
            }
            DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
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
            java.util.logging.Logger.getLogger(EngJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EngJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EngJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EngJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EngJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFieldAss1;
    private javax.swing.JTextField jTextFieldAss2;
    private javax.swing.JTextField jTextFieldAss3;
    private javax.swing.JTextField jTextFieldAss4;
    private javax.swing.JTextField jTextFieldFName;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldSName;
    private javax.swing.JTextField jTextFieldTest1;
    private javax.swing.JTextField jTextFieldTest2;
    private javax.swing.JTextField jTextFieldTest3;
    private javax.swing.JTextField jTextFieldTotal;
    private javax.swing.JTextField jtxtSearch;
    // End of variables declaration//GEN-END:variables

     
    
}
