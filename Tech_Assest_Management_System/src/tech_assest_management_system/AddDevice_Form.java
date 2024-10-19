
package tech_assest_management_system;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import dbconnection.ConnectionString;

public class AddDevice_Form extends javax.swing.JFrame {

    //This is actually Form Load Event - If you want to load something when load the Form you can implement those code in here
    //Such as Drop Down loading ,  Table Loading
    public AddDevice_Form() {
        initComponents();
        
        
        //This is for Close only AddDevice_Form
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
        this.setLocationRelativeTo(null);
        
        //This is for Load the Device Category
        loadDeviceCategory();
        
    }

    //This is for Get Login User
    public void setLoggedInUser(String userName)
    {
        lbl_ShowUser.setText(userName);
    }
    
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
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null , "Database Connection Error " + e);
        }
    }
    
    
    //This is for Generate Device Code Automatically and getmax id with the Data Base
    private void generateDeviceCode(String selectedCategory)
    {
        try
        {
            String dbloc = "jdbc:mysql://localhost/techassest";
            String dbUname = "root";
            String dbpw = "";
            
            Connection con = DriverManager.getConnection(dbloc , dbUname , dbpw); 
            
            String query = "Select Count(*) as Count from DeviceMaster where category = ? ";
            
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, selectedCategory);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next())
            {
                int count = rs.getInt("Count");
                
                String codePrefix  = getCategoryPrefix(selectedCategory);
                String newDeviceCode = codePrefix + String.format("%03d" , count+1);
                
                lbl_showDCode.setText(newDeviceCode);
            }
            con.close();
        
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null , "Error Generating Device Code " + ex);
        }
    
    }
    
    //This Function for Set Prefix ---> and Also implement getCategoryPrefix
    private String getCategoryPrefix(String category)
    {
        switch(category.toLowerCase()) // those are in Drop Down, and Data Base
        {
            case "monitor": return "MTR";
            case "printer": return "PRT";
            case "laptop": return "LTP";
            case "desktop pc" : return "DPC";
            case "scanners" : return "SCN";
            case "key board" : return "KYB";
            case "mouse" : return "MSE";
            case "ups"  : return "UPS";
            
            default: return "DEV"; // Default prefix ----> I this is use for if the drop down Items are not matched this provide as a Other Code
        }
    
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_Category = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lbl_showDCode = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmb_Brand = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmb_condition = new javax.swing.JComboBox<>();
        txt_invoice = new javax.swing.JTextField();
        txt_sNumber = new javax.swing.JTextField();
        txt_vendor = new javax.swing.JTextField();
        dtp_warrenty = new com.toedter.calendar.JDateChooser();
        txt_price = new javax.swing.JTextField();
        dtp_purchase = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lbl_ShowUser = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Add your Device in here");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 390, 42));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Select Category");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 130, 30));

        cmb_Category.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmb_Category.setForeground(new java.awt.Color(51, 51, 51));
        cmb_Category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_CategoryActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 250, -1));

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Device Code");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 140, -1));

        lbl_showDCode.setBackground(new java.awt.Color(0, 51, 51));
        lbl_showDCode.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbl_showDCode.setForeground(new java.awt.Color(0, 0, 51));
        lbl_showDCode.setText("deCode");
        getContentPane().add(lbl_showDCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 90, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 51, 51));
        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Brand");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        cmb_Brand.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmb_Brand.setForeground(new java.awt.Color(51, 51, 51));
        cmb_Brand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Asus", "HP", "Apple", "Lenevo", "Dell", "MSI", "Razer", "Huawei" }));
        getContentPane().add(cmb_Brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 250, 30));

        jLabel5.setBackground(new java.awt.Color(0, 51, 51));
        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Warrenty End Date");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 51, 51));
        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Purchase Date");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 51, 51));
        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Vendor Name");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 51, 51));
        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Serial Number");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, -1, -1));

        jLabel9.setBackground(new java.awt.Color(0, 51, 51));
        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Purchase Price");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, 20));

        jLabel10.setBackground(new java.awt.Color(0, 51, 51));
        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Invoice Number");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, -1, -1));

        jLabel11.setBackground(new java.awt.Color(0, 51, 51));
        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Device Condition");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, 20));

        cmb_condition.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmb_condition.setForeground(new java.awt.Color(51, 51, 51));
        cmb_condition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Brand New", "Used" }));
        getContentPane().add(cmb_condition, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 250, -1));

        txt_invoice.setBackground(new java.awt.Color(153, 204, 255));
        txt_invoice.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txt_invoice.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txt_invoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 250, -1));

        txt_sNumber.setBackground(new java.awt.Color(153, 204, 255));
        txt_sNumber.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txt_sNumber.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txt_sNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, 250, -1));

        txt_vendor.setBackground(new java.awt.Color(153, 204, 255));
        txt_vendor.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txt_vendor.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txt_vendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 250, -1));

        dtp_warrenty.setBackground(new java.awt.Color(204, 204, 204));
        dtp_warrenty.setForeground(new java.awt.Color(102, 204, 255));
        getContentPane().add(dtp_warrenty, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 250, -1));

        txt_price.setBackground(new java.awt.Color(153, 204, 255));
        txt_price.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txt_price.setForeground(new java.awt.Color(0, 0, 0));
        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });
        getContentPane().add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 250, -1));

        dtp_purchase.setBackground(new java.awt.Color(204, 204, 204));
        dtp_purchase.setForeground(new java.awt.Color(102, 204, 255));
        getContentPane().add(dtp_purchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 250, -1));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD Device");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, 250, 50));

        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("User :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 50, -1));

        lbl_ShowUser.setForeground(new java.awt.Color(51, 51, 51));
        lbl_ShowUser.setText(" ");
        getContentPane().add(lbl_ShowUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 100, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon("D:\\Tech Asset Managemen System\\Images\\ICON\\Add  Window.png")); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 150, 150));

        lbl_image.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_image.setForeground(new java.awt.Color(51, 51, 51));
        lbl_image.setIcon(new javax.swing.ImageIcon("D:\\Tech Asset Managemen System\\Images\\mainAddDevice.jpg")); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(-230, 0, 1270, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String deCode;
        String category;
        String brand;
        String deCondition;
        String invoiceNo;
        String serialNo;
        double dePrice = 0;
        String vendor;
        String sys_user;
        
        category = cmb_Category.getSelectedItem().toString();
        brand = cmb_Brand.getSelectedItem().toString();
        deCondition = cmb_condition.getSelectedItem().toString();
        vendor = txt_vendor.getText();
        deCode = lbl_showDCode.getText();
        sys_user = lbl_ShowUser.getText();
        invoiceNo = txt_invoice.getText();
        serialNo = txt_sNumber.getText();
        
        //Check Price as not a String
        if(txt_price.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please Enter Values", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try
        {
            dePrice = Double.parseDouble(txt_price.getText());
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Invalid price format. Please enter a valid number.", "Data not inserted", JOptionPane.ERROR_MESSAGE);
            return;
        }
        

        // This is for Set Date Time for the Variable
        java.util.Date date1 = dtp_purchase.getDate();
        java.util.Date date2 = dtp_warrenty.getDate();
        
        //This is for Check Null Values
        if(txt_vendor.getText().trim().isEmpty() || txt_invoice.getText().trim().isEmpty() || txt_sNumber.getText().trim().isEmpty() || txt_price.getText().trim().isEmpty() || dtp_purchase.getDate() == null || dtp_warrenty.getDate() == null)
        {
            JOptionPane.showMessageDialog(this, "Please Enter Records", "Data not insert", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else
        {
            try
            {   
                //This is for Time Collect -----> PurchDate / Warrenty Date
                java.sql.Date purchDate = new java.sql.Date(date1.getTime());
                java.sql.Date warrEndDate = new java.sql.Date(date2.getTime());
                
                
                String dbloc = "jdbc:mysql://localhost/techassest";
                String dbUname = "root";
                String dbpw = "";

                Connection con = DriverManager.getConnection(dbloc , dbUname , dbpw);

                String query = " insert into DeviceMaster (DeCode , category , Brand , DeCondition , invoiceNo , serialNo, DePrice , purchDate , warrendDate , vendor , Status, sys_date , sys_user) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '3', now(), ?);";

                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, deCode);
                pstmt.setString(2, category);
                pstmt.setString(3, brand);
                pstmt.setString(4, deCondition);
                pstmt.setString(5, invoiceNo);
                pstmt.setString(6, serialNo);
                pstmt.setDouble(7, dePrice);
                pstmt.setDate(8, purchDate);        
                pstmt.setDate(9 ,warrEndDate);      //  we should get According to the MySQL , Mysql data type is Date, so we should pass it as date data type
                pstmt.setString(10, vendor);
                pstmt.setString(11 ,sys_user);
            
                int rowAffected = pstmt.executeUpdate();
                
                if(rowAffected > 0)
                {
                    JOptionPane.showMessageDialog(this, "Successfully Added the Device", "Done", JOptionPane.INFORMATION_MESSAGE);
                    
                    cmb_Brand.setSelectedIndex(0);
                    cmb_condition.setSelectedIndex(0);
                    cmb_Category.setSelectedIndex(0);
                    txt_vendor.setText("");
                    txt_invoice.setText("");
                    txt_price.setText("");
                    txt_sNumber.setText("");
                    //This is for set Date as Null
                    dtp_purchase.setDate(null);
                    dtp_warrenty.setDate(null);
                    
                    generateDeviceCode("monitor");
                
                }
            
                //Close the Connection
                con.close();
                
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(this , "Query Parameter Error - Prepared Statement" + ex);
            }
        
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    //This is for Generate Device Code According to the Selected Dropdown Item
    private void cmb_CategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_CategoryActionPerformed
        
        String selectedCategory = (String) cmb_Category.getSelectedItem();
        generateDeviceCode(selectedCategory);
        
        
    }//GEN-LAST:event_cmb_CategoryActionPerformed

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
            java.util.logging.Logger.getLogger(AddDevice_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDevice_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDevice_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDevice_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddDevice_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_Brand;
    private javax.swing.JComboBox<String> cmb_Category;
    private javax.swing.JComboBox<String> cmb_condition;
    private com.toedter.calendar.JDateChooser dtp_purchase;
    private com.toedter.calendar.JDateChooser dtp_warrenty;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl_ShowUser;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_showDCode;
    private javax.swing.JTextField txt_invoice;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_sNumber;
    private javax.swing.JTextField txt_vendor;
    // End of variables declaration//GEN-END:variables
}
