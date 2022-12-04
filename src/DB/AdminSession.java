package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author JoeAlpha
 */

public class AdminSession {
    public static boolean isLogin(String email, String password, JFrame frame){
        try {
            Connection conn = DBConnection.setConnection();
            String mySqlQuery = "SELECT status,serial_no,fullname,email,phone,operator_id FROM tbl_admin WHERE email=? AND password =? ";
            PreparedStatement preparedStatement = conn.prepareStatement(mySqlQuery);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                AdminCredentials.status      = resultSet.getString("status");
                AdminCredentials.serial_no   = resultSet.getString("serial_no");
                AdminCredentials.fullname    = resultSet.getString("fullname");
                AdminCredentials.email       = resultSet.getString("email");
                AdminCredentials.phone       = resultSet.getString("phone");
                AdminCredentials.operator_id = resultSet.getString("operator_id");
                
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminSession.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
