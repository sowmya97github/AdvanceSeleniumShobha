package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import Generic_Utilities.BaseClass;



//public class FetchDataFromDataBaseTest extends BaseClass{
//
//	@Test
//	public void FetchDataFromDataBaseTest() throws Throwable {
//	
//		//step1:- register/ load the mysql database
//	//	Driver driverRef = new Driver();
//    //    DriverManager.registerDriver(driverRef);
//        
//        //step2:-get connect to database
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders", "root", "root");
//        
//        //step3:-Create sql statement
//        Statement state = con.createStatement();
//	     String query = "select * from student";
//	
//	     //step4:-Execute Statement/Query 
//	     ResultSet result=   state.executeQuery(query);
//	
//	     while (result.next())
//	     {
// System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getString(4));
//		}
//	     //step5:- close database
//	  //   con.close();
//	}
//
//}
