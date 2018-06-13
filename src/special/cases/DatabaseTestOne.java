package special.cases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTestOne {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		
		String dbUrl="jdbc:mysql://localhost:3306/db_ram_one";
		String uName="root";
		String uPass="root";
		String query1="select * from emp_data_one";
		
		//Loading mySql jdbc driver
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		//Create connection to Database.
		Connection con1=DriverManager.getConnection(dbUrl, uName, uPass);
		
		//Create Statement object
		Statement st1=con1.createStatement();
		
		//Create Result set object.
		ResultSet rs1=st1.executeQuery(query1);
		
		//Looping through result set and displaying the output or query
		while(rs1.next()){
			String sId=rs1.getString(1);
			System.out.println("Student Id is : "+sId +" Name : "+rs1.getString(2));
		}
		
		con1.close();
		
	}

}
