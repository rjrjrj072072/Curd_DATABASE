package curd_project;

import static org.junit.Assert.*;

import org.junit.Test;

import com.databse_file.CURD_JDBC_CON_FILE;

import junit.framework.TestCase;


import static org.junit.Assert.assertEquals;



import java.sql.Connection;

import java.sql.ResultSet;

 

import org.junit.Ignore;

import org.junit.Test;

 

public class CURD_JUNIT_TEST extends TestCase{

 

    @Test

   public void test() throws Exception

    {

    	CURD_JDBC_CON_FILE obj = new CURD_JDBC_CON_FILE();

        Connection con = obj.con();

        assertEquals(true,con!=null);

    }

    @Test

   public  void test1() throws Exception

    {

 

    	CURD_JDBC_CON_FILE obj = new CURD_JDBC_CON_FILE();

        int c = obj.insert("Harsha",299,"devloper","Indore");

        assertEquals(1, c);

     

      

    }

    @Test

    public  void test3() throws Exception

     {

    	CURD_JDBC_CON_FILE obj = new CURD_JDBC_CON_FILE();

         int c = obj.update("anil",279,"linux","Indore");

         assertEquals(1, c);

     }

 

    @Test

    public  void test4() throws Exception

     {

    	CURD_JDBC_CON_FILE obj = new CURD_JDBC_CON_FILE();

         int c = obj.delete(198);

         assertEquals(1, c);      

     }

 

    @Test

   public  void test2() throws Exception

   {

    	CURD_JDBC_CON_FILE obj = new CURD_JDBC_CON_FILE();

        ResultSet c = obj.select();

        assertEquals(true, c.next());

     

    }

 

}