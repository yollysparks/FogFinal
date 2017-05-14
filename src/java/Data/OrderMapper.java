/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Bussiness.DomainModel.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author felesiah
 */
public class OrderMapper {
    private DBconnector con;
    public OrderMapper() {
        
   
   }
   public Order getOrderId(int orderid){
       ResultSet rs = null;
        Statement stmt = null;
        Order order = null;
        String SQLString
                = "select name "
                + "from order "
                + "where idorder = " + orderid;
        try {
            stmt = con.getConnection().createStatement();
            rs = stmt.executeQuery(SQLString);

            if (rs.next()) {
                 order = new Order(rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println("Fail in orderMapper - getOrderId");
            System.out.println(e.getMessage());
        }       
        return order;
   }
}
