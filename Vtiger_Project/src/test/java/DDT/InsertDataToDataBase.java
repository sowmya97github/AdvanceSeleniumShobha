package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataToDataBase {

	public static void main(String[] args) throws Throwable {
		
Driver driverRef = new Driver();
DriverManager.registerDriver(driverRef);

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders", "root", "root");
Statement state = conn.createStatement();	

	String query = "insert into student(first_name,last_name,address)values('ram','sam','Goa'),('sam','ram','bglr'),('jam','pam','pune')";
	int result = state.executeUpdate(query);
	
	if(result==1)
	{
		System.out.println("data updated");
	}
	else
	{
		System.out.println("data not updated");
	}
	conn.close();
}

}
