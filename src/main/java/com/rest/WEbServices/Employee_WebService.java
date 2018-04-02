package com.rest.WEbServices;


import java.sql.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.database.DBConnection;

@Path("/db")


public class Employee_WebService {

    
    DBConnection  dbCoN;
    Connection conn;
    ResultSet rslt;
    String Iuser="Invalid User";
    @Path("/{userName}")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String LoginUserValidation(@PathParam("userName") String userName)throws SQLException {
    String ILoginQuery="select * from emp where name='"+userName+"'";
    System.out.println(""+ILoginQuery);
    dbCoN = new DBConnection();
    try {
        
        
        conn=DBConnection.setDBConnection();
        rslt=dbCoN.getResultSet(ILoginQuery,conn);
        
        
        if(rslt.next()) {
            String name=rslt.getString(1);
            int id=rslt.getInt(2);
            String dept=rslt.getString(3);
            String location=rslt.getString(4);
            return "---"+name+"---"+id+"---"+dept+"---"+location+"---";
            
            
        }
        else
        {return Iuser;}
    }
    
    
    catch(Exception e) {
        System.out.println(e);
    
    //return null;
    }
    finally {
        
        
        if(conn!=null) {
            
            conn.close();
        }
        
    }return Iuser;
    }
    
    
    
}
