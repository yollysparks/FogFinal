/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import Bussiness.DomainModel.Parts;
import Data.DBconnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author felesiah
 */
public class PartsMapper {
    private final DBconnector conn;

    public PartsMapper() {
        this.conn = new DBconnector();
    }
     public int getPart()
    {
        return 1;
    }
    
      public ArrayList<Parts> getAll() throws SQLException
    {
        Statement stmt = conn.getConnection().createStatement();
        String sql = "select * from parts";
        ArrayList<Parts> prices = new ArrayList<Parts>();
        Parts parts = null;
        try
        {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                int id = rs.getInt("itemId");
                String name = rs.getString("name");
                int length = rs.getInt("length");
                int amount = rs.getInt("amount");
                
                parts = new Parts(id,name,length,amount);
                
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(PartsMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return prices;
    }

    
}
