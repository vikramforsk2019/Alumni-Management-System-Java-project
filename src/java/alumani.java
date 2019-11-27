import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/alumani") 
public class alumani extends HttpServlet{
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
String s1,s2,s3,s4,s5,s6,s7,s8=null;
try 
  {
st1=con.createStatement();
rs=st1.executeQuery("select fname,lname,email,department,course,join_year,graduation_year from alumani");
             pw.println("<table width='800' border='5' bgcolor='red' collspacing='0px'>");
pw.println("<tr bgcolor='blue'>");
 pw.println("<th>fname</th><th>lname</th><th>email</th><th>department</th><th>course</th><th>join_year</th><th>graduation_year</th>");
pw.println("</tr>");
while(rs.next())
{
s1=rs.getString(1);
s2=rs.getString(2);
s3=rs.getString(3);
s4=rs.getString(4);

s5=rs.getString(5);
s6=rs.getString(6);
s7=rs.getString(7);
  pw.println("<tr bgcolor='yellow'>");
  pw.println("<th>"+s1+"</th><th>"+s2+"</th><th>"+s3+"</th><th>"+s4+"</th><th>"+s5+"</th><th>"+s6+"</th><th>"+s7+"</th>");
  }

    con.close(); 
}
catch(Exception e)
   {
pw.println(e);
   }
                                              
}
}
