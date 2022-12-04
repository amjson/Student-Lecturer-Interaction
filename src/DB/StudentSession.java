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

public class StudentSession {
    public static boolean isLogin(String email, String password, JFrame frame){
        try {
            Connection conn = DBConnection.setConnection();
            String mySqlQuery = "SELECT status,operator_id,reg_no,fullname,email,phone,gender FROM tbl_students WHERE email=? AND password =? ";
            PreparedStatement preparedStatement = conn.prepareStatement(mySqlQuery);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                StudentCredentials.status      = resultSet.getString("status");
                StudentCredentials.operator_id = resultSet.getString("operator_id");
                StudentCredentials.reg_no      = resultSet.getString("reg_no");
                StudentCredentials.fullname    = resultSet.getString("fullname");
                StudentCredentials.email       = resultSet.getString("email");
                StudentCredentials.phone       = resultSet.getString("phone");
                StudentCredentials.gender      = resultSet.getString("gender");
                
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentSession.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
