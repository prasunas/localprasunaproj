package automation;
import java.sql.*;


public class DbExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try 
		{
			//Class.forName("com.mysql.jdbc.Driver);"
			Connection con=DriverManager.getConnection("jbdc:mysql://localhost:8808/test", "root", "");
			Statement stmt=con.createStatement();
			String sUpdateQuery="update admin set password='admin1'where username=test";
			int val=stmt.executeUpdate(sUpdateQuery);
			if(val==1)
			{
				System.out.println("update is successful");
			}
			else
				{
					System.out.println("update is not successful");
				}
				
			ResultSet rs=stmt.executeQuery("select * from admin");
			while(rs.next())
			System.out.println(rs.getObject(1)+ " "+rs.getString(2)+" "+rs.getString(3)+"");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
			}
			
					
			
		
	}


