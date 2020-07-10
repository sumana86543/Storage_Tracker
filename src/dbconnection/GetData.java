package dbconnection;
import java.sql.*;
public class GetData {
	static Connection cn=null;
	static String driver="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/storage_space_tracker";
	static String user="root";
	static String pass="Sum@n@.98";
	public static Connection getCn(){
		try{
			Class.forName(driver);
			cn=DriverManager.getConnection(url,user,pass);
			
		}catch(Exception e){
			System.out.println(e);
		}
		return cn;
	}

}