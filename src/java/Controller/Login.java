/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.CustomerMapper;
import static Data.CustomerMapper.validate;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author felesiah
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    } 
    @Override
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String strUserName=request.getParameter("user");  
        String strPassword =request.getParameter("password"); 
        String strErrMsg = null;
        HttpSession session = request.getSession(false);
        
        boolean isValidLogon = false;
   try {
     isValidLogon = validate(strUserName, strPassword);
     
     if(isValidLogon) {
        session.setAttribute("user", strUserName); 
           forward("CarportInput.jsp",request,response);  
        }  
        else{  
            out.print("<p style=\"color:red\">Sorry user or password error</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
            rd.include(request,response);  
        }  
   } catch(ServletException | IOException e) {
     strErrMsg = "Unable to validate user / password in database";
   }

}
     private void forward( String url, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher( url )
                .forward( request, response );
   
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
