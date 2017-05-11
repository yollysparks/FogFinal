 package Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Casper
 */
public class DBconnector {


    private final static String HOST     = "localhost";
    private final static int    PORT     = 3306;
    private final static String DATABASE = "jdbc:mysql://localhost:3306/carport?useSSL=false";
    private final static String USERNAME = "root"; 
    private final static String PASSWORD = "indeche2013";
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final Connection connection = null;
    
    
    public static Connection getConnector() throws SQLException, ClassNotFoundException{
        if (connection == null) {
            Class.forName(Driver);// Register JDBC driver
            String url = String.format("jdbc:mysql://localhost:3306/carport?useSSL=false", HOST, PORT, DATABASE);
            return DriverManager.getConnection(url, USERNAME, PASSWORD);
        }
        return connection;
    }
    public Connection getConnection() {//Open a connection
     Connection conn = null;
        try{
            Class.forName(Driver);
            conn = DriverManager.getConnection(DBconnector.DATABASE,DBconnector.USERNAME,DBconnector.PASSWORD);
            
        } catch(ClassNotFoundException | SQLException se){
            
        }
        return conn;
    }
    public void close(Statement stmt, ResultSet rs, Connection conn){
        try{
            if(rs != null)//Clean-up environment
                rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se){
            
        } catch(Exception ex){
            
        }
        finally{
            try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
           }
        }
    }
  }
