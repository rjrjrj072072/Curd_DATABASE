package com.rest.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    
    public static Connection dbCon;
    public Statement dbStmt;
    public ResultSet dbRst;
    public static Connection setDBConnection() throws SQLException {
        try {
        System.out.println("Inside DB Connection");
        Class.forName("org.postgresql.Driver");
        dbCon =DriverManager.getConnection("jdbc:postgresql://localhost:5432/curd", "postgres", "admin");
        }
        catch(ClassNotFoundException e) {
            
            System.out.println(e);
            
        }
        return dbCon;
        
        
    }
     
    
    public ResultSet getResultSet(String sqlQuery,Connection conn) throws SQLException{
        System.out.println(sqlQuery);
        String sqlquery=sqlQuery;
        dbCon=conn;
        try {
            dbStmt=dbCon.createStatement();
            dbRst =dbStmt.executeQuery(sqlquery);
             
            
            
        }
        catch(Exception e) {}
    return dbRst;
    
    
    }
    
    
    
}