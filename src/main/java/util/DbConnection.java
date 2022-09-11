package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {

	static String driver = "org.postgresql.Driver";
	static String url ="jdbc:postgresql://localhost:5432/ism2022";
	static String userName ="postgres";
	static String password ="root";
	
	public static Connection getConnection() {  //Add public static void main....
		//object
				
		try {
			//Driver Load
			Class.forName(driver);
			
				Connection con = DriverManager.getConnection(url,userName,password);
				//Statement
				//Preparedstatement
				
//				PreparedStatement pstmt = con.prepareStatement("insert into users (firstname,lastname,email,password,gender )values(?,?,?,?,?)");
//
//				pstmt.setString(1, "Ram");
//				pstmt.setString(2, "modi");
//				pstmt.setString(3, "meet@12");
//				pstmt.setString(4, "7878");
//				pstmt.setString(5, "male");
//
//				int records = pstmt.executeUpdate();


			//	System.out.println(records+"inserted");
				
				
				if(con !=null) {
					System.out.println("DB Connected...");
				}
				return con; //remove
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;  //remove
		}
	}


