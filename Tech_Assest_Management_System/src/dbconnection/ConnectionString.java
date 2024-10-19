
package dbconnection;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionString {
    
    static Connection con; // We dont need Create object because this is Static
    
        public static Connection dbcon()
    {
        try
        {
            String dbloc = "jdbc:mysql://localhost/techassest";
            String dbUname = "root";
            String dbpw = "";
            
            Connection con = DriverManager.getConnection(dbloc, dbUname , dbpw);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "SQL Error", "Error", JOptionPane.ERROR_MESSAGE); // We cant use 'this' key word from here, Because this referes to an instance of the class
        }
        
        return con  ;  
    }
    
    
}
