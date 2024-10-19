
package tech_assest_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Repair_Form extends javax.swing.JFrame {


    public Repair_Form() {
        initComponents();
        
        //This is for Close and Center the Position
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
        this.setLocationRelativeTo(null);
        
        //This is a Load Category For the Dropdown
        loadDeviceCategory();
        
        
        //This is For Add Cateegory Details for the table
        cmb_Category.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                 cmb_CategoryActionPerformed(evt);
            }
        
        });
        
        
        
        
    }

    //This is for Get Login User ----> system User
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
    
    
    // This is for add Records When Select Category using the Drop down  -----> Constructor Connect With this
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
            String query = "SELECT a.DeCode as DeCode , b.Brand as Brand , a.Department as Department , a.EmpName as EmpName  FROM `handoverdetails`  as a inner join devicemaster as b on a.DeCode = b.DeCode where a.Status='4' and a.Category='"+selectedCat+"'";
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                String deviceCode = rs.getString("DeCode");
                String brand = rs.getString("Brand");
                String department = rs.getString("Department");
                String EmpName = rs.getString("EmpName");
                
                //This is add data to the Table Row
                model.addRow(new Object[] {model.getRowCount() + 1, deviceCode, brand, department ,EmpName });
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
        lbl_ShowUser = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmb_Category = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_DeCode = new javax.swing.JTextField();
        btn_checkWarranty = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea_RepairReason = new javax.swing.JTextArea();
        lbl_showWarrentyDetails = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ShowDevices = new javax.swing.JTable();
        btn_ConfirmRepair = new javax.swing.JButton();
        lbl_shoDevice = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Maintenance and Repair Pannel");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 390, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setText("User ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 50, -1));

        lbl_ShowUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ShowUser.setForeground(new java.awt.Color(153, 255, 255));
        lbl_ShowUser.setText(" ");
        getContentPane().add(lbl_ShowUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 120, -1));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Select the Device Category");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        cmb_Category.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(cmb_Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 420, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Enter Device Code which you want to repair ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, -1, -1));

        txt_DeCode.setBackground(new java.awt.Color(153, 153, 153));
        txt_DeCode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_DeCode.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txt_DeCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, 280, -1));

        btn_checkWarranty.setBackground(new java.awt.Color(0, 153, 153));
        btn_checkWarranty.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_checkWarranty.setText("Check Warranty");
        btn_checkWarranty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_checkWarranty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_checkWarrantyActionPerformed(evt);
            }
        });
        getContentPane().add(btn_checkWarranty, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 240, 150, 50));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Repair Reason");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, -1, -1));

        txtArea_RepairReason.setBackground(new java.awt.Color(153, 153, 153));
        txtArea_RepairReason.setColumns(20);
        txtArea_RepairReason.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtArea_RepairReason.setForeground(new java.awt.Color(0, 0, 0));
        txtArea_RepairReason.setRows(5);
        jScrollPane2.setViewportView(txtArea_RepairReason);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, 290, 130));

        lbl_showWarrentyDetails.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_showWarrentyDetails.setForeground(new java.awt.Color(0, 0, 0));
        lbl_showWarrentyDetails.setText(" ");
        getContentPane().add(lbl_showWarrentyDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 430, -1));

        tbl_ShowDevices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S No", "Device Code", "Brand", "Department", "Employee"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_ShowDevices);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 640, 370));

        btn_ConfirmRepair.setBackground(new java.awt.Color(0, 102, 102));
        btn_ConfirmRepair.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_ConfirmRepair.setForeground(new java.awt.Color(255, 255, 255));
        btn_ConfirmRepair.setText("Confirm Repair");
        btn_ConfirmRepair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ConfirmRepair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConfirmRepairActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ConfirmRepair, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 490, 170, 70));

        lbl_shoDevice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_shoDevice.setForeground(new java.awt.Color(0, 0, 0));
        lbl_shoDevice.setText(" ");
        getContentPane().add(lbl_shoDevice, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 430, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Tech Asset Managemen System\\Images\\Main Repair wall.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //This is for Check Warrenty
    private void btn_checkWarrantyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkWarrantyActionPerformed
        
        String deCode;
        String category;
        
        deCode = txt_DeCode.getText();
        category = cmb_Category.getSelectedItem().toString();
        
        if(txt_DeCode.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "PLease enter the Device Code", "Error", JOptionPane.ERROR);
        }
        else
        {
            try 
            {
                
                //This is for Check User Entered Device Code correct for Checking is this a Handoverded Device ---> Check Status as 4 
                if(isDeCodeValidation (deCode , category))
                {
                    JOptionPane.showMessageDialog(this, "Invalid or unavailable Device Code", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                
                
                String dbloc = "jdbc:mysql://localhost/techassest";
                String dbUname = "root";
                String dbpw = "";
            
                Connection con = DriverManager.getConnection(dbloc , dbUname , dbpw);
                
                String query = "SELECT warrEndDate , vendor FROM devicemaster WHERE DeCode ='"+deCode+"'";
                
                Statement stmt = con.createStatement();
                
                ResultSet rs = stmt.executeQuery(query);
                
                if(rs.next())
                {
                    String warrenty = rs.getString("warrEndDate");
                    String vendor = rs.getString("vendor");
                    lbl_showWarrentyDetails.setText("Warranty Period Valid Until : " + warrenty);
                    lbl_shoDevice.setText("Purchased Company : " + vendor);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "There is no Record found", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                
                con.close();
                
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this, "Database Exception" + e, "Eroor", JOptionPane.ERROR);
            }
            
        }
    }//GEN-LAST:event_btn_checkWarrantyActionPerformed

    private void btn_ConfirmRepairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConfirmRepairActionPerformed
       
        String deCode;
        String category;
        String remark;
        String sys_user;
        
        //this is for getting db and set it to the pass data for the Repair table --> In here we use two Queris for do that one of getting data and one of Inserting Data
        String empName = "";
        String department= "";
        
        
        deCode = txt_DeCode.getText();
        category = cmb_Category.getSelectedItem().toString();
        sys_user = lbl_ShowUser.getText();
        
        //This is for not required option for Text Area
        if(txtArea_RepairReason.getText().trim().isEmpty())
        {
            remark = null;
        }
        else
        {
            remark = txtArea_RepairReason.getText();
        }
        
        if(txt_DeCode.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter Required filds", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            try
            {
                String dbloc = "jdbc:mysql://localhost/techassest";
                String dbUname = "root";
                String dbpw = "";
            
                Connection con = DriverManager.getConnection(dbloc , dbUname , dbpw);  
                
                //This is for get Department and Empployee Name from the Database for pass it into the Repair Table with the Insert Query
                String query1 = "SELECT department , EmpName from handoverdetails where DeCode ='"+deCode+"' ";
                Statement stmt1 = con.createStatement();
                
                ResultSet rs = stmt1.executeQuery(query1);
                
                if(rs.next())
                {
                    department = rs.getString("department");
                    empName = rs.getString("EmpName");
                }
                
                
                //This is for Insert Data to the Repair Database
                String query2 = "insert into repair (DeCode , Category , department , EmpName , Reason , Status , Sys_user , Sys_date)  values ('"+deCode+"' , '"+category+"' , '"+department+"', '"+empName+"' , '"+remark+"' , '5'  ,'"+sys_user+"' , now()) ";
                Statement stmt2 = con.createStatement();
                
                int rowAffected = stmt2.executeUpdate(query2);
                
                if(rowAffected > 0)
                {
                    JOptionPane.showMessageDialog(this, "Successfully Submitted Repair Request", "Done", JOptionPane.INFORMATION_MESSAGE);
                }
                
                
                //This is for Update Handover table Status should as 5 -----> Because when we are submita a Machine from a some user. That Device Should Remove from the User
                String query3 = "Update handoverdetails set Status = '5' where DeCode = '"+deCode+"'";
                Statement stmt3 = con.createStatement();
                
                stmt3.executeUpdate(query3);
                
                
                
                //This is for Update DeviceMaster Table status should as 5 --> Because there should be a get Summery Report on Device Master Table 
                //In that situation we should update also that Device Master Table
                String query4 = "Update devicemaster set Status = '5' where DeCode = '"+deCode+"' ";
                Statement stmt4 = con.createStatement();
                
                stmt4.executeUpdate(query4);
                
                
                con.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this, "Database Exception" + e, "Eroor", JOptionPane.ERROR_MESSAGE);  
            }
        }
        
    }//GEN-LAST:event_btn_ConfirmRepairActionPerformed
    
    //This is for DeCode Validation ----> In here we are checking the user Entered device code is Valid 
    //Because this should be a Handovereded Device, because normally we did not handover have to do repair Devices
    private boolean isDeCodeValidation(String deCode , String category)
    {
        boolean isValid = true;
        
        try
        {
            String dbloc = "jdbc:mysql://localhost/techassest";
            String dbUname = "root";
            String dbpw = "";

            Connection con = DriverManager.getConnection(dbloc , dbUname , dbpw); 
            
            String query = "SELECT COUNT(*) AS count FROM deviceMaster WHERE DeCode = ? AND Category = ? AND Status = '4'";
            
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
            java.util.logging.Logger.getLogger(Repair_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Repair_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Repair_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Repair_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Repair_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConfirmRepair;
    private javax.swing.JButton btn_checkWarranty;
    private javax.swing.JComboBox<String> cmb_Category;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_ShowUser;
    private javax.swing.JLabel lbl_shoDevice;
    private javax.swing.JLabel lbl_showWarrentyDetails;
    private javax.swing.JTable tbl_ShowDevices;
    private javax.swing.JTextArea txtArea_RepairReason;
    private javax.swing.JTextField txt_DeCode;
    // End of variables declaration//GEN-END:variables
}
