import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class hello extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
Connection con=null;
Statement st1=null;
ResultSet rs=null;
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms","root","");
       }
catch(ClassNotFoundException e)
{
pw.println(e);
 }
catch(SQLException e1)
{
pw.println(e1);
}

String a=req.getParameter("adminid");
String b=req.getParameter("password");
try 
  {
st1=con.createStatement();
rs=st1.executeQuery("select * from admin where adminid='"+a+"'");
             if(rs.next())
                {
                  HttpSession session =req.getSession();
                  session.setAttribute("room",a);
                  pw.println("admin login");
                  pw.println("<a href='student'>student Details</a>");
                  pw.println("<a href='alumani'>alumani Details</a>");
                  pw.println("<a href='logout'>logout</a>");
                  //HttpSession session =req.getSession();
                  //session.setAttribute("room",a);
                //  res.sendRedirect("index.html");
                }
             else
                  
                {
                	pw.println("invalid");
                  //res.sendRedirect("index.html");
                 }

    con.close(); 
}
catch(Exception e)
   {
pw.println(e);
   }
                                              
}
}
