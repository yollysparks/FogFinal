/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author felesiah
 */
public class CustomerMapper {
    
     private  static  DBconnector conn;

    public CustomerMapper() {
        this.conn = new DBconnector();
    }
    
    
    
 public static boolean validate(String user, String pass) {        
        boolean status = false;
       
        PreparedStatement pst = null;
        ResultSet rs = null;
 
        try {  
            pst = conn.getConnection().prepareStatement("select * from login where user=? and password=?");
                    
            // process query results
            pst.setString(1, user);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            
            String Cuser = "",Cpass ="";
            
             if (rs.next()) {
                Cuser = rs.getString("user");
                Cpass = rs.getString("password");
            } //end if
            if (Cpass.equals(pass)&& user.equals(user)) {
                //do something
                out.println(" got user and password");
                return true;   
            } else {
                rs.close();
             //do something
            }

        } catch (Exception e) {
            out.println(e);
        } finally {
            if (conn != null) {
                conn.close(pst, rs, (Connection) conn);
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
}