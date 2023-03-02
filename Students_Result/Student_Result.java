
package Students_Result;

/**
 *
 * @author MUC
 */
import studentrecordapp.*;
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
                    "root", "");
            //JOptionPane.showMessageDialog(null, "MySQL Connection successful");
            return conn;
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "MySQL Connection failed");
        return null;
    }
    }  
      
   //Show or Add the data to the jTable
    public ArrayList<StudentBean> retrieveData(){
        ArrayList<StudentBean> al=null;
        al=new ArrayList<StudentBean>();
        try{
            Connection conn=MySqlConnection();
            String q="SELECT * FROM marks";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(q);
            StudentBean student;
            while (rs.next()){
                student=new StudentBean(rs.getInt(1), rs.getString("Firstname"),
                rs.getString("Surname"), rs.getInt(4), rs.getInt(5)
                , rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)
                , rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13),
                rs.getString("Ranking"));
                al.add(student);
                
                
            }
                
            }catch (Exception e){
                System.out.println("Error in retrieveData method: "+e);
            }
        return al;
    }
    
    
    //show all data to jTable ( fill the table)
    public void fillTable(){
        ArrayList<StudentBean> al=retrieveData();
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
    }
    
    //show item/data to fields
    public void ShowItemToFields(int index){
        jtxtStudent.setText(Integer.toString(retrieveData().get(index).getStudent_ID()));
        jtxtFirstname.setText(retrieveData().get(index).getFirstName());
        jtxtSurname.setText(retrieveData().get(index).getLastName());
        jtxtMaths.setText(Integer.toString(retrieveData().get(index).getMaths()));
        jtxtEnglish.setText(Integer.toString(retrieveData().get(index).getEnglish()));
        jtxtBiology.setText(Integer.toString(retrieveData().get(index).getScience()));
        jtxtComputing.setText(Integer.toString(retrieveData().get(index).getSocial_Science()));
        jtxtChemistry.setText(Integer.toString(retrieveData().get(index).getMAL()));
        jtxtPhysics.setText(Integer.toString(retrieveData().get(index).getHealth_PE()));
        jtxtAddMaths.setText(Integer.toString(retrieveData().get(index).getArts()));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtTotalScore = new javax.swing.JTextField();
        jtxtAverage = new javax.swing.JTextField();
        jtxtRanking = new javax.swing.JTextField();
        jtxtSurname = new javax.swing.JTextField();
        jtxtFirstname = new javax.swing.JTextField();
        jtxtStudent = new javax.swing.JTextField();
        jtxtMaths = new javax.swing.JTextField();
        jtxtEnglish = new javax.swing.JTextField();
        jtxtBiology = new javax.swing.JTextField();
        jtxtComputing = new javax.swing.JTextField();
        jtxtChemistry = new javax.swing.JTextField();
        jtxtPhysics = new javax.swing.JTextField();
        jtxtAddMaths = new javax.swing.JTextField();
        jtxtBusiness = new javax.swing.JTextField();
        jbtnMaths = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jcmbCourseCode = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtTranscript = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jbtnRanking = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jbtnTranscripts = new javax.swing.JButton();
        jButton_Place = new javax.swing.JButton();
        jbtnReset = new javax.swing.JButton();
        jbtnRefresh = new javax.swing.JButton();
        jbtnAddRecord = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jButton_print = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jtxtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Result System");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 4, true), "Student Records", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 153, 204))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Student_ID:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Firstname:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Surname:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Maths:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("English:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Biology:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Computing:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Chemistry:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Physics:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Add Maths:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Business:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Total Score:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Average:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Ranking:");

        jtxtTotalScore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtxtAverage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtxtRanking.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtxtSurname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        jtxtBiology.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtBiology.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtBiologyKeyTyped(evt);
            }
        });

        jtxtComputing.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtComputing.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtComputingKeyTyped(evt);
            }
        });

        jtxtChemistry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtChemistry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtChemistryKeyTyped(evt);
            }
        });

        jtxtPhysics.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtPhysics.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtPhysicsKeyTyped(evt);
            }
        });

        jtxtAddMaths.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtAddMaths.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtAddMathsKeyTyped(evt);
            }
        });

        jtxtBusiness.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtBusiness.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtBusinessKeyTyped(evt);
            }
        });

        jbtnMaths.setText("Maths");
        jbtnMaths.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMathsActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Course Code:");

        jcmbCourseCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grade3", "Grade4", "Grade5", "Grade6", "Grade7", "Grade8" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtTotalScore)
                                    .addComponent(jtxtAverage)
                                    .addComponent(jtxtFirstname)
                                    .addComponent(jtxtSurname)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtxtStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                            .addComponent(jtxtRanking))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(6, 6, 6)
                        .addComponent(jcmbCourseCode, 0, 96, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(36, 36, 36)
                        .addComponent(jtxtMaths))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtComputing))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(28, 28, 28)
                        .addComponent(jtxtBiology))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(30, 30, 30)
                        .addComponent(jtxtEnglish))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtPhysics)
                            .addComponent(jtxtChemistry)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtBusiness)
                            .addComponent(jtxtAddMaths, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnMaths)
                .addGap(107, 107, 107))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(jtxtAverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtxtMaths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnMaths))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxtEnglish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtxtBiology, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtxtComputing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtxtChemistry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jtxtPhysics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jtxtAddMaths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jtxtBusiness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1181, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 4, true), "Results", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 153, 204))); // NOI18N

        jtxtTranscript.setColumns(20);
        jtxtTranscript.setRows(5);
        jScrollPane1.setViewportView(jtxtTranscript);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student_ID", "Firstname", "Surname", "Maths", "English", "Biology", "Computing", "Chemistry", "Physics", "Add Maths", "Business", "Total_Score", "Average", "Ranking"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jbtnRanking.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnRanking.setText("Grade");
        jbtnRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRankingActionPerformed(evt);
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

        jbtnTranscripts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnTranscripts.setText("Transcripts");
        jbtnTranscripts.setPreferredSize(new java.awt.Dimension(67, 23));
        jbtnTranscripts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTranscriptsActionPerformed(evt);
            }
        });

        jButton_Place.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_Place.setText("Ranking");
        jButton_Place.setPreferredSize(new java.awt.Dimension(67, 23));
        jButton_Place.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PlaceActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jbtnRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jbtnTranscripts, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jbtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbtnAddRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(270, 270, 270)
                        .addComponent(jButton_print, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton_Place, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jbtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(292, 292, 292)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 235, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnRanking)
                    .addComponent(jbtnTranscripts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnReset)
                    .addComponent(jbtnAddRecord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_print, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Place, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(219, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(15, 15, 15))))
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

    private void jtxtBiologyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBiologyKeyTyped
        // code to prevent user from entering any other data type other than int
        char iNumber = evt.getKeyChar();
        if(!(Character.isDigit(iNumber))
            ||(iNumber == KeyEvent.VK_BACK_SPACE)
            ||(iNumber == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_jtxtBiologyKeyTyped

    private void jtxtComputingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtComputingKeyTyped
        // code to prevent user from entering any other data type other than int
        char iNumber = evt.getKeyChar();
        if(!(Character.isDigit(iNumber))
            ||(iNumber == KeyEvent.VK_BACK_SPACE)
            ||(iNumber == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_jtxtComputingKeyTyped

    private void jtxtChemistryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtChemistryKeyTyped
        // code to prevent user from entering any other data type other than int
        char iNumber = evt.getKeyChar();
        if(!(Character.isDigit(iNumber))
            ||(iNumber == KeyEvent.VK_BACK_SPACE)
            ||(iNumber == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_jtxtChemistryKeyTyped

    private void jtxtPhysicsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtPhysicsKeyTyped
        // code to prevent user from entering any other data type other than int
        char iNumber = evt.getKeyChar();
        if(!(Character.isDigit(iNumber))
            ||(iNumber == KeyEvent.VK_BACK_SPACE)
            ||(iNumber == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_jtxtPhysicsKeyTyped

    private void jtxtAddMathsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtAddMathsKeyTyped
        // code to prevent user from entering any other data type other than int
        char iNumber = evt.getKeyChar();
        if(!(Character.isDigit(iNumber))
            ||(iNumber == KeyEvent.VK_BACK_SPACE)
            ||(iNumber == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_jtxtAddMathsKeyTyped

    private void jtxtBusinessKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBusinessKeyTyped
        // code to prevent user from entering any other data type other than int
        char iNumber = evt.getKeyChar();
        if(!(Character.isDigit(iNumber))
            ||(iNumber == KeyEvent.VK_BACK_SPACE)
            ||(iNumber == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_jtxtBusinessKeyTyped

    private void jbtnMathsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMathsActionPerformed
        try {
            new MathsJFrame().setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jbtnMathsActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int ind=jTable1.getSelectedRow();
        ShowItemToFields(ind);
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbtnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRankingActionPerformed
        // code to allocate their grade
        double[] R = new double[14];
        R[0] = Double.parseDouble(jtxtMaths.getText());
        R[1] = Double.parseDouble(jtxtEnglish.getText());
        R[2] = Double.parseDouble(jtxtBiology.getText());
        R[3] = Double.parseDouble(jtxtComputing.getText());
        R[4] = Double.parseDouble(jtxtChemistry.getText());
        R[5] = Double.parseDouble(jtxtPhysics.getText());
        R[6] = Double.parseDouble(jtxtAddMaths.getText());
        R[7] = Double.parseDouble(jtxtBusiness.getText());

        R[8] = (R[0] + R[1] + R[2] + R[3] + R[4] + R[5] + R[6] + R[7]) / 8;
        R[9] = (R[0] + R[1] + R[2] + R[3] + R[4] + R[5] + R[6] + R[7]);

        String Average = String.format("%.0f", R[0]);
        jtxtAverage.setText(Average);

        String TotalScore = String.format("%.0f", R[9]);
        jtxtTotalScore.setText(TotalScore);

        if (R[9] >= 700)
        {
            jtxtRanking.setText("A");
        }
        else if (R[9] >= 600)
        {
            jtxtRanking.setText("B");
        }
        else if (R[9] >= 500)
        {
            jtxtRanking.setText("C");
        }
        else if (R[9] >= 400)
        {
            jtxtRanking.setText("D");
        }
        else if (R[9] >= 300)
        {
            jtxtRanking.setText("E");
        }
        else if (R[9] >= 200)
        {
            jtxtRanking.setText("Fail");
        }

        /* DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{

            jtxtStudent.getText(),
            jcmbCourseCode.getSelectedItem(),
            jtxtMaths.getText(),
            jtxtEnglish.getText(),
            jtxtBiology.getText(),
            jtxtComputing.getText(),
            jtxtChemistry.getText(),
            jtxtPhysics.getText(),
            jtxtAddMaths.getText(),
            jtxtBusiness.getText(),
            jtxtTotalScore.getText(),
            jtxtAverage.getText(),
            jtxtRanking.getText(),

        }); */
    }//GEN-LAST:event_jbtnRankingActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        String qry=null;
        PreparedStatement ps=null;
        Connection conn=MySqlConnection();

        if(jtxtStudent!=null || jtxtFirstname!=null || jtxtSurname!=null
            || jtxtMaths!=null || jtxtEnglish!=null || jtxtBiology!=null
            || jtxtComputing!=null|| jtxtChemistry!=null|| jtxtPhysics!=null){
            // String qry=null;
            //PreparedStatement ps=null;
            //Connection conn=MySqlConnection();
            try{
                qry="update marks set Firstname=?, Surname=?, Maths=? "
                + ", English=?, Biology=?, Computing=?,"
                + "Chemistry=?, Physics=?, Add_Maths=?,"
                + "Business=?, Total_Score=?, Average=?,"
                + "Ranking=? where StudentID=?";
                ps=conn.prepareStatement(qry);
                ps.setString(1, jtxtFirstname.getText());
                ps.setString(2, jtxtSurname.getText());
                ps.setInt(3, Integer.parseInt(jtxtMaths.getText()));
                ps.setInt(4, Integer.parseInt(jtxtEnglish.getText()));
                ps.setInt(5, Integer.parseInt(jtxtBiology.getText()));
                ps.setInt(6, Integer.parseInt(jtxtComputing.getText()));
                ps.setInt(7, Integer.parseInt(jtxtChemistry.getText()));
                ps.setInt(8, Integer.parseInt(jtxtPhysics.getText()));
                ps.setInt(9, Integer.parseInt(jtxtAddMaths.getText()));
                ps.setInt(10, Integer.parseInt(jtxtBusiness.getText()));
                ps.setInt(11, Integer.parseInt(jtxtTotalScore.getText()));
                ps.setInt(12, Integer.parseInt(jtxtAverage.getText()));
                ps.setString(13, jtxtRanking.getText());
                ps.setInt(14, Integer.parseInt(jtxtStudent.getText()));

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
            jtxtBiology.setText("");
            jtxtComputing.setText("");
            jtxtChemistry.setText("");
            jtxtPhysics.setText("");
            jtxtAddMaths.setText("");
            jtxtBusiness.setText("");
            jtxtTotalScore.setText("");
            jtxtAverage.setText("");
            jtxtRanking.setText("");
            jtxtStudent.setText("");
        }else{

            JOptionPane.showMessageDialog(null, "Student Update failed...");

        }

    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jbtnTranscriptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTranscriptsActionPerformed
        // Code to display transcripts
        jtxtTranscript.setText(null);
        jtxtTranscript.append("\nStudent Result Recording System\n"
            + "===============================\n"
            + "\nStudent_ID:\t\t" + jtxtStudent.getText()
            + "\nFirstname:\t\t" + jtxtFirstname.getText()
            + "\nSurname:\t\t" + jtxtSurname.getText()
            +"\n"
            + "\nMaths:\t\t" + jtxtMaths.getText()
            + "\nEnglish:\t\t" + jtxtEnglish.getText()
            + "\nBiology:\t\t" + jtxtBiology.getText()
            + "\nComputing:\t\t" + jtxtComputing.getText()
            + "\nChemistry:\t\t" + jtxtChemistry.getText()
            + "\nPhysics:\t\t" + jtxtPhysics.getText()
            + "\nAdd Maths:\t\t" + jtxtAddMaths.getText()
            + "\nBusiness:\t\t" + jtxtBusiness.getText()
            + "\nTotal Score:\t\t" + jtxtTotalScore.getText()
            + "\nAverage:\t\t" + jtxtAverage.getText()
            + "\nOverall Grade:\t\t" + jtxtRanking.getText()

        );

    }//GEN-LAST:event_jbtnTranscriptsActionPerformed

    private void jButton_PlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PlaceActionPerformed
        jtxtTranscript.setText(null);
        jtxtTranscript.append("Students ranking in Mathematics\n"
            + "________________________________________________________________________________________________________________\n"
            + "Place \t Name\t Surname \n\n");
        try{
            Connection conn=MySqlConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT    marks.Firstname,    marks.Maths,  marks.Surname,    @prev := @curr,    @curr := Maths,\n" +
            "    @rank := IF(@prev = @curr,@rank, @rank +1) AS MathsRank    FROM\n" +
            "        marks,        (SELECT @curr := null, @prev := null, @rank :=0) tmp_tbl\n" +
            "        ORDER BY             marks.Maths DESC";
            ResultSet rs=stmt.executeQuery(sql);
            int[] scores;
            while(rs.next()){
                String firstname=rs.getString("Firstname");
                String surname=rs.getString("Surname");
                int maths=rs.getInt("MathsRank");

                int i=0;
                int[] arr=new int[300];
                String[] names = new String[300];
                names[i]=firstname;
                int rank=1;
                arr[i]=maths;
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
        }

    }//GEN-LAST:event_jButton_PlaceActionPerformed

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
            jtxtSurname.getText()!=null || jcmbCourseCode.getModel()!=null||
            jtxtTotalScore.getText()!=null || jtxtAverage.getText()!=null||
            jtxtRanking.getText()!=null || jtxtMaths.getText()!=null||
            jtxtEnglish.getText()!=null || jtxtBiology.getText()!=null||
            jtxtComputing.getText()!=null || jtxtChemistry.getText()!=null||
            jtxtPhysics.getText()!=null || jtxtBusiness.getText()!=null) && jtxtAddMaths.getText()!=null){

        try{
            Class<?> forName = Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/studentrecord", "root", "");
            // String qry="insert into marks values(Student_ID, Course_Code, Firstname, Surname, Maths, English"
            //         + "Biology, Computing, Chemistry, Physics, Add_Maths, Business)";
            PreparedStatement ps;
            ps = conn.prepareStatement("insert into marks (StudentID,"
                + "Firstname, Surname, Ranking, Total_Score,"
                + "Average, Maths, Biology, Computing, Chemistry, Physics,"
                + "Add_Maths, Business, English)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, Integer.parseInt(jtxtStudent.getText()));
            ps.setString(2, jtxtFirstname.getText());
            ps.setString(3, jtxtSurname.getText());
            ps.setString(4, jtxtRanking.getText());
            //ps.setObject(4, jcmbCourseCode.getModel());
            ps.setInt(5, Integer.parseInt(jtxtTotalScore.getText()));
            ps.setInt(6, Integer.parseInt(jtxtAverage.getText()));
            ps.setInt(7, Integer.parseInt(jtxtMaths.getText()));
            ps.setInt(8, Integer.parseInt(jtxtBiology.getText()));
            ps.setInt(9, Integer.parseInt(jtxtComputing.getText()));
            ps.setInt(10, Integer.parseInt(jtxtChemistry.getText()));
            ps.setInt(11, Integer.parseInt(jtxtPhysics.getText()));
            ps.setInt(12, Integer.parseInt(jtxtAddMaths.getText()));
            ps.setInt(13, Integer.parseInt(jtxtBusiness.getText()));
            ps.setInt(14, Integer.parseInt(jtxtEnglish.getText()));

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
        if (jtxtStudent.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter the Student ID...");
        } else{
            try{
                String qry="delete from marks where StudentID=?";
                Connection conn=MySqlConnection();
                PreparedStatement ps=conn.prepareStatement(qry);
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

    private JFrame frame;
    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        // Code to exit from the App
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "confirm if you want to exit"
            + "", "Student Result System",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
        System.exit(0);
        }
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
            String qry="select * from marks where name like '%"+val+"%'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            StudentBean student;
            while (rs.next()){
                student =new StudentBean(rs.getInt(1), rs.getString("Firstname"),
                    rs.getString("Surname"), rs.getInt(4), rs.getInt(5)
                    , rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)
                    , rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13),
                    rs.getString("Ranking"));
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
                //row[10]=al.get(i).getBusiness();
                row[11]=al.get(i).getTotal_Score();
                row[12]=al.get(i).getAverage();
                //row[13]=al.get(i).getRanking();
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
            String qry="select * from marks where Firstname like '%"+val+"%'";
            //Statement st=conn.createStatement();
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            StudentBean student;
            while (rs.next()){
                student =new StudentBean(rs.getInt(1), rs.getString("Firstname"),
                    rs.getString("Surname"), rs.getInt(4), rs.getInt(5)
                    , rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)
                    , rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13),
                    rs.getString("Ranking"));
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
                //row[10]=al.get(i).getBusiness();
                row[11]=al.get(i).getTotal_Score();
                row[12]=al.get(i).getAverage();
                //row[13]=al.get(i).getRanking();
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
            java.util.logging.Logger.getLogger(Student_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Result().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Place;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_print;
    private javax.swing.JButton jButton_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnAddRecord;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnMaths;
    private javax.swing.JButton jbtnRanking;
    private javax.swing.JButton jbtnRefresh;
    private javax.swing.JButton jbtnReset;
    private javax.swing.JButton jbtnTranscripts;
    private javax.swing.JComboBox<String> jcmbCourseCode;
    private javax.swing.JTextField jtxtAddMaths;
    private javax.swing.JTextField jtxtAverage;
    private javax.swing.JTextField jtxtBiology;
    private javax.swing.JTextField jtxtBusiness;
    private javax.swing.JTextField jtxtChemistry;
    private javax.swing.JTextField jtxtComputing;
    private javax.swing.JTextField jtxtEnglish;
    private javax.swing.JTextField jtxtFirstname;
    private javax.swing.JTextField jtxtMaths;
    private javax.swing.JTextField jtxtPhysics;
    private javax.swing.JTextField jtxtRanking;
    private javax.swing.JTextField jtxtSearch;
    private javax.swing.JTextField jtxtStudent;
    private javax.swing.JTextField jtxtSurname;
    private javax.swing.JTextField jtxtTotalScore;
    private javax.swing.JTextArea jtxtTranscript;
    // End of variables declaration//GEN-END:variables
}
