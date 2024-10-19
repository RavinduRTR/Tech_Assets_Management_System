
package tech_assest_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Handover_Form extends javax.swing.JFrame {

    public Handover_Form() {
        initComponents();
        
        //This is for Close and Center the Position
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
        this.setLocationRelativeTo(null);
        
        //This is a Load Category For the Dropdown
        loadDeviceCategory();
        
        
        //This is for Load Department for the Dropdown
        loadDepartment();
        
        //This is For Add Cateegory Details for the table --> Drop Down Listners
        cmb_Category.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                 cmb_CategoryActionPerformed(evt);
            }
        
        });
        
        
    }
    
    //This is for Get Login User
    public void setLoggedInUser(String userName)
    {
        lbl_ShowUser.setText(userName);
    }
    

    //Catergory Loading to the Drop Down Method
    private void loadDeviceCategory()
    {
        try 
        {
            String dbloc = "jdbc:mysql://localhost/techassest";
            String dbUname = "root";
            String dbpw = "";
            
            Connection con = DriverManager.getConnection(dbloc , dbUname , dbpw);
            String query = "Select DeviceName from deviceType where status ='1'";
            
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            
            //This is for Remove all Items before the Loading the Drop Down
            cmb_Category.removeAllItems();
            
            while(rs.next())
            {
                String catName = rs.getString("DeviceName");
                cmb_Category.addItem(catName);
            }
            con.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null , "Database Connection Error " + e);
        }
    }
    
    
    //Department loading for the Drop Down
    private void loadDepartment()
    {
        try 
        {
            String dbloc = "jdbc:mysql://localhost/techassest";
            String dbUname = "root";
            String dbpw = "";
            
            Connection con = DriverManager.getConnection(dbloc , dbUname , dbpw);
            String query = "Select Department from department where status ='1'"; 
            
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            
            //Remove all Items before adding Department for the Drop Down (if there is index 1 , index 2 Like Wise)
            cmb_Department.removeAllItems();
            
            while(rs.next())
            {
                String deptName = rs.getString("Department");
                cmb_Department.addItem(deptName);
            }
            con.close();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null , "Database Connection Error " + e);
        }
    }
    
    // This is for add Records When Select Category using the Drop down
    private void cmb_CategoryActionPerformed(java.awt.event.ActionEvent evt)
    {
        String selectedCat = cmb_Category.getSelectedItem().toString();
        
        //Addition ----> this is for Check Category is Selected or Not
        if(selectedCat != null)
        {
            loadAvailableDevices(selectedCat);
        }
    }
    
    //This is for Load Available Devices to the Table ----> When user Select the Drop Down Category
    private void loadAvailableDevices(String selectedCat)
    {
        //This is for Addition for Clear Items if have in the Table
        DefaultTableModel model = (DefaultTableModel) tbl_ShowDevices.getModel();
        model.setRowCount(0);
        
        try 
        {
            String dbloc = "jdbc:mysql://localhost/techassest";
            String dbUname = "root";
            String dbpw = "";
            
            Connection con = DriverManager.getConnection(dbloc , dbUname , dbpw);
            String query = "Select DeCode , Brand , DeCondition from deviceMaster where status ='3' and Category = '"+selectedCat+"' ";
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                String deviceCode = rs.getString("DeCode");
                String brand = rs.getString("Brand");
                String deCondi = rs.getString("DeCondition");
                
                //This is add data to the Table Row
                model.addRow(new Object[] {model.getRowCount() + 1, deviceCode, brand, deCondi});
            }
            con.close();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(this , "Data Base Error" + e , "Error" , JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_Category = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ShowDevices = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btn_Find = new javax.swing.JButton();
        txt_DeCode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmb_Department = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_EmpNo = new javax.swing.JTextField();
        lbl_ShowOfficer = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea_note = new javax.swing.JTextArea();
        btn_ConfirmHand = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lbl_ShowUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Asset Handover Panel");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Select Device Category");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        cmb_Category.setBackground(new java.awt.Color(153, 153, 153));
        cmb_Category.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        getContentPane().add(cmb_Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 300, -1));

        tbl_ShowDevices.setBackground(new java.awt.Color(153, 153, 153));
        tbl_ShowDevices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S No", "Device Code", "Brand", "Device Condition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Float.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_ShowDevices);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 540, 460));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Handover Device Code");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 190, -1));

        btn_Find.setBackground(new java.awt.Color(255, 51, 204));
        btn_Find.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btn_Find.setForeground(new java.awt.Color(255, 255, 255));
        btn_Find.setText("FIND");
        btn_Find.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FindActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Find, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 230, 90, -1));

        txt_DeCode.setBackground(new java.awt.Color(153, 153, 153));
        txt_DeCode.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        getContentPane().add(txt_DeCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 300, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Handover Department");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, -1, -1));

        cmb_Department.setBackground(new java.awt.Color(153, 153, 153));
        cmb_Department.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        getContentPane().add(cmb_Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 160, 300, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Handover Officer ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, -1, -1));

        txt_EmpNo.setBackground(new java.awt.Color(153, 153, 153));
        txt_EmpNo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        getContentPane().add(txt_EmpNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 230, 190, -1));

        lbl_ShowOfficer.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        lbl_ShowOfficer.setForeground(new java.awt.Color(0, 51, 51));
        lbl_ShowOfficer.setText(" ");
        getContentPane().add(lbl_ShowOfficer, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, 280, -1));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("Employee Name");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 170, -1));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setText("Additional Notes");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, -1, -1));

        txtArea_note.setBackground(new java.awt.Color(153, 153, 153));
        txtArea_note.setColumns(20);
        txtArea_note.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtArea_note.setRows(5);
        jScrollPane2.setViewportView(txtArea_note);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 350, 300, -1));

        btn_ConfirmHand.setBackground(new java.awt.Color(0, 51, 51));
        btn_ConfirmHand.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        btn_ConfirmHand.setForeground(new java.awt.Color(255, 255, 255));
        btn_ConfirmHand.setText("Confirm Handover");
        btn_ConfirmHand.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ConfirmHand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConfirmHandActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ConfirmHand, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 490, 300, 60));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("User : ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 40, -1));

        lbl_ShowUser.setText(" ");
        getContentPane().add(lbl_ShowUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 300, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Tech Asset Managemen System\\Images\\12.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, -20, 1460, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //This is for Find User when Insert Employee Number
    private void btn_FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FindActionPerformed
       
        String empNo;
        String department;
        empNo = txt_EmpNo.getText();
        department = cmb_Department.getSelectedItem().toString();
        
        
        try
        {
            String dbloc = "jdbc:mysql://localhost/techassest";
            String dbUname = "root";
            String dbpw = "";
            
            Connection con = DriverManager.getConnection(dbloc , dbUname , dbpw);

            String query = "Select EmpName from EmployeeDetails as a inner join Department as b on a.DeptID = b.DepID where a.status = '1' and a.EmpNo = '"+empNo+"' and b.department = '"+department+"'";
            
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            
            if(txt_EmpNo.getText().trim().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Please Enter Employee Number " , "Not Entered" , JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                if(rs.next())
                {
                    String empName = rs.getString("EmpName");
                    lbl_ShowOfficer.setText(empName);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "There is no Employee according to the Emp No and The Department " + empNo, "Not Found", JOptionPane.INFORMATION_MESSAGE);
                    lbl_ShowOfficer.setText("");
                }
            }
            
            con.close();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null , "Database Connection Error " + ex);
        }
        
        
    }//GEN-LAST:event_btn_FindActionPerformed

    private void btn_ConfirmHandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConfirmHandActionPerformed
        
        String deCode;
        String category;
        String department;
        String empNo;
        String empName;
        String remarks;
        String uName;
        
        deCode = txt_DeCode.getText();
        category = cmb_Category.getSelectedItem().toString();
        department = cmb_Department.getSelectedItem().toString();
        empNo = txt_EmpNo.getText();
        empName = lbl_ShowOfficer.getText();
        uName = lbl_ShowUser.getText();
        
        //This is for not required option for Text Area
        if(txtArea_note.getText().trim().isEmpty())
        {
            remarks = null;
        }
        else
        {
            remarks = txtArea_note.getText();
        }
     
        //This is for required Field checking
        if(txt_DeCode.getText().trim().isEmpty() || txt_EmpNo.getText().trim().isEmpty() || lbl_ShowOfficer.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Ennetr All Required Fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            
            //This is for Check User Entered Device Code correct
            if(isDeCodeValidation (deCode , category))
            {
                JOptionPane.showMessageDialog(this, "Invalid or unavailable Device Code", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try
            {
                String dbloc = "jdbc:mysql://localhost/techassest";
                String dbUname = "root";
                String dbpw = "";

                Connection con = DriverManager.getConnection(dbloc , dbUname , dbpw);

                String query1 = "insert into handoverdetails (DeCode , Category , Department , Empno , EmpName , Remarks , Status , Sys_user , Sys_date) values (? , ? , ? , ? , ? , ? , '4' , ? , now())";

                PreparedStatement pstmt = con.prepareStatement(query1);

                pstmt.setString(1 ,deCode );
                pstmt.setString(2, category);
                pstmt.setString(3, department);
                pstmt.setString(4 ,empNo);
                pstmt.setString(5, empName);
                pstmt.setString(6 , remarks);
                pstmt.setString(7, uName);

                int rowAffected = pstmt.executeUpdate();
                
                 //This is for Update Device Master Table Status
                String query2 = "Update deviceMaster set Status = '4' where Decode = '"+deCode+"'";
                Statement stmt = con.createStatement();
                
                int rowAffected2 = stmt.executeUpdate(query2);

                if(rowAffected> 0 || rowAffected2 > 0)
                {
                    JOptionPane.showMessageDialog(this, "Record Successfully Entered", "Done", JOptionPane.INFORMATION_MESSAGE);

                    txt_DeCode.setText("");
                    cmb_Category.setSelectedIndex(1);
                    cmb_Department.setSelectedIndex(1);
                    txt_EmpNo.setText("");
                    lbl_ShowOfficer.setText("");
                    txtArea_note.setText("");
                }
                
                con.close();

            }
            catch (SQLException e)
            {
                JOptionPane.showMessageDialog(null , "Database Connection Error " + e);
            }
            
        }
        
    }//GEN-LAST:event_btn_ConfirmHandActionPerformed

    //This is for DeCode Validation ----> In here we are checking the user Entered device code is Valid
    private boolean isDeCodeValidation(String deCode , String category)
    {
        boolean isValid = true;
        
        try
        {
            String dbloc = "jdbc:mysql://localhost/techassest";
            String dbUname = "root";
            String dbpw = "";

            Connection con = DriverManager.getConnection(dbloc , dbUname , dbpw); 
            
            String query = "SELECT COUNT(*) AS count FROM deviceMaster WHERE DeCode = ? AND Category = ? AND Status = '3'";
            
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, deCode);
            pstmt.setString(2, category);

            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next() && rs.getInt("count")>0)
            {
                isValid = false;
            }
            con.close();
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null , "Database Connection Error " + e);
        }
        
        //this method return a Value. ----> rhis is for the Checking Validation 
        return isValid;
    }
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(Handover_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Handover_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Handover_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Handover_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Handover_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConfirmHand;
    private javax.swing.JButton btn_Find;
    private javax.swing.JComboBox<String> cmb_Category;
    private javax.swing.JComboBox<String> cmb_Department;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_ShowOfficer;
    private javax.swing.JLabel lbl_ShowUser;
    private javax.swing.JTable tbl_ShowDevices;
    private javax.swing.JTextArea txtArea_note;
    private javax.swing.JTextField txt_DeCode;
    private javax.swing.JTextField txt_EmpNo;
    // End of variables declaration//GEN-END:variables
}
