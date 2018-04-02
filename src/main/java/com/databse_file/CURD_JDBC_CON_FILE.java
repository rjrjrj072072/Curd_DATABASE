package com.databse_file;






import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

 

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

@WebServlet("/CurdO")

public class CURD_JDBC_CON_FILE extends HttpServlet {

                private static final long serialVersionUID = 1L;

      

   

    public  CURD_JDBC_CON_FILE() {

        super();

    }

                protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                	CURD_JDBC_CON_FILE curd =new  CURD_JDBC_CON_FILE();

                                response.getWriter().append("Served at: ").append(request.getContextPath());

                                String  operation = (String)request.getSession().getAttribute("operation");

                                if(operation.equals("insert"))

                                {

                                                try {

                                                                String name =request.getParameter("name");

                                                                int id =Integer.parseInt(request.getParameter("id"));

                                                                String dept =request.getParameter("dept");

                                                                String location =request.getParameter("location");

                                                                int i= curd.insert(name,id,dept,location);

                                                }

                                catch(Exception e)

                                                {

                                                e.printStackTrace();

                                                }

                                }

                                if(operation.equals("update"))

                                {

                                                try {

                                                                String name =request.getParameter("name");

                                                                int id =Integer.parseInt(request.getParameter("id"));

                                                                String dept =request.getParameter("dept");

                                                                String location =request.getParameter("location");

                                                                int i= curd.update(name, id, dept,location);

                                                }

                                catch(Exception e)

                                                {

                                                e.printStackTrace();

                                                }

                                }

                                if(operation.equals("delete"))

                                {

                                                try {

                                                                int id =Integer.parseInt(request.getParameter("id"));

                                                                int i= curd.delete(id);

                                                }

                                catch(Exception e)

                                                {

                                                e.printStackTrace();

                                                }

                                }

                                if(operation.equals("select"))

                                {

                                                try {

                                                                PrintWriter out=response.getWriter();

                                        ResultSet rs=curd.select();

                                                                while(rs.next())

                                                                {

                                                         String name1  = rs.getString(1);

                                                         long id1 = rs.getInt(2);

                                                         String dept1 = rs.getString(3);

                                                         String loc = rs.getString(4);

                                                         out.println("ID: " + id1);

                                                         out.println(", name: " + name1);

                                                        out.println(", dept: " + dept1);

                                                        out.println(", Location: " + loc);

                                                                }

                                                }

                                                catch(Exception e)

                                                {

                                                                e.printStackTrace();

                                                }

                }

                }

               

                public Connection con()

                  

                   {

                                   Connection connection =null;

                                   try

                                   {

                                                   Class.forName("org.postgresql.Driver");

                                                   connection = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/curd","postgres", "admin");

                                   }

                                                catch(Exception e)

                                   {

                                                                e.printStackTrace();

                                   }

                                   return connection;

                   }

                   public int insert(String name, int id, String dept, String location) throws Exception

                   {

                                                Class.forName("org.postgresql.Driver");

                                                Connection connection = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/curd","postgres", "admin");

                                                PreparedStatement ps = connection.prepareStatement("insert into emp(name,id,dept,location) values(?,?,?,?)");

                                                ps.setString(1, name);

                                                ps.setInt(2, id);

                                                ps.setString(3, dept);

                                                ps.setString(4, location);

                                                int i=ps.executeUpdate(); 

                                                System.out.println(i+" records inserted");

                                                return i;

                                }

                   public int update(String name, int id, String dept,String location) throws Exception{

                        

                                   Class.forName("org.postgresql.Driver");

                                   Connection connection = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/curd","postgres", "admin");

                       PreparedStatement ps=connection.prepareStatement("update emp set name=?,dept=?,location=? where id= ?");

                       ps.setString(1,name);

                       ps.setString(2,dept);

                       ps.setString(3,location);

                       ps.setInt(4,id);

                       int i=    ps.executeUpdate();

                      return i;  

                   

                }  

                   public int delete(int id) throws Exception{

                      Class.forName("org.postgresql.Driver");

                      Connection connection = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/curd","postgres", "admin");

                        PreparedStatement ps= connection.prepareStatement("delete from emp where id = ?");

                        ps.setInt(1,id);

                        int i = ps.executeUpdate();

                        return i;

                    }

                   public ResultSet select() throws Exception

       {

            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/curd","postgres", "admin");

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM emp");

            ResultSet rs = ps.executeQuery();

            return rs;

        

       }

 

}