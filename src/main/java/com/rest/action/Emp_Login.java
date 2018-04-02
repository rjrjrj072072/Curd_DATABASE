package com.rest.action;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.POJO.Emplyee_POJO_class;
import com.rest.database.DBConnection;

public class  Emp_Login {
    DBConnection  dbCoN;
    Connection conn;
    ResultSet rslt;
    String target;
    public void LoginUserValidation(HttpServletRequest request,HttpServletResponse response)throws ServletException ,IOException,SQLException
    {
    
    String userName=request.getParameter("UserName");
    
    Emplyee_POJO_class emp= new Emplyee_POJO_class(userName);
    String ILoginQuery="select * from emp where name=";
    ILoginQuery=ILoginQuery+"'"+emp.getempName()+"';";
    
    
    System.out.println(""+ILoginQuery);
    dbCoN=new DBConnection();
    try {
        
    conn=DBConnection.setDBConnection();
    rslt=dbCoN.getResultSet(ILoginQuery, conn);
    if(rslt.next()) {
        
        target="Sucess.jsp";
    }
    else {
        target="Error.jsp";
    }
    }
    catch(Exception e) {
        System.out.println(e);
    }
    finally {
        
        if(conn!=null) {
            
            conn.close();
        }
        
        
    }
    RequestDispatcher rd=request.getRequestDispatcher(target);
    rd.forward(request, response);
    
    }
     
}