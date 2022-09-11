package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.UserBean;
import util.DbConnection;

public class UserDao {
	
	public UserBean login(String email,String password) {
		  UserBean user = null;
		try {
           Connection con = DbConnection.getConnection();
           PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and password = ?");
           pstmt.setString(1, email);
           pstmt.setString(2, password);
            
          ResultSet rs= pstmt.executeQuery(); //read data on db.
          
          if(rs.next()) {
        	  user = new UserBean();
        	  user.setUserId(rs.getInt("userid"));
        	  user.setFirstName(rs.getString("firstname"));
        	  user.setUsertype(rs.getString("usertype"));
        	  
          }
		} catch (Exception e) {
			System.out.println("smw in login dao");
		}
		return user;
	}
	
	//INSERTED DATA
 public void insertUser(UserBean userBean) {
	 
	 try {
	 Connection con = DbConnection.getConnection();
	 PreparedStatement pstmt = con.prepareStatement("insert into users (firstname,lastname,email,password,gender,usertype )values(?,?,?,?,?,?)");

	 pstmt.setString(1, userBean.getFirstName());
     pstmt.setString(2, userBean.getLastName());
     pstmt.setString(3, userBean.getEmail());
     pstmt.setString(4, userBean.getPassword());
	 pstmt.setString(5, userBean.getGender());
	 pstmt.setString(6, userBean.getUsertype());
	 
	 
	 
//	 pstmt.setString(1, firstName);
//     pstmt.setString(2, lastName);
//     pstmt.setString(3, email);
//     pstmt.setString(4, password);
//	 pstmt.setString(5, gender);

	 
	 
//	 pstmt.setString(1, "Ram");
//	 pstmt.setString(2, "modi");
//	 pstmt.setString(3, "meet@12");
//	 pstmt.setString(4, "7878");
//	 pstmt.setString(5, "male");

	 int records = pstmt.executeUpdate();


	 System.out.println(records+" inserted..."); 
	 }catch(Exception e) {
		 System.out.println("some thing wrong in insert user()");
	      e.printStackTrace();
	 }
	 
	 }
 //List of ALLDATA
   public ArrayList<UserBean>  getAllUsers() {
	   ArrayList<UserBean> users = new ArrayList<UserBean>();
	   try {
		   Connection con = DbConnection.getConnection();
		   PreparedStatement pstmt = con.prepareStatement("select * from users");
		  ResultSet rs =  pstmt.executeQuery();//show all data on db
		   
		  while(rs.next() == true)//1st row 2nd row
		  {
		  int userId = rs.getInt("userid");//db column name
		  String firstName = rs.getString("firstname");
		  String lasttName = rs.getString("lastname");
		  String email = rs.getString("email");
		  String password = rs.getString("password");
		  String gender = rs.getString("gender");
		  
		  UserBean user = new UserBean();
		  user.setUserId(userId);
		  user.setFirstName(firstName);
		  user.setLastName(firstName);
		  user.setEmail(email);
		  user.setPassword(password);
		  user.setGender(gender);
		  users.add(user);
		  
	   }
		  //go to line num 74
		  
		   
	} catch (Exception e) {
		System.out.println("smw in user Dao:getAllUser()");
		e.printStackTrace();
	}
	   return users;
	   
   }
   
   
   
   
   //update
   public UserBean getUserByUserId(int userId) {
	   UserBean user = new UserBean();
	   try(Connection con = DbConnection.getConnection();
		 PreparedStatement pstmt = con.prepareStatement("select * from users where userid=?");){
		 pstmt.setInt(1, userId);
		 ResultSet rs= pstmt.executeQuery();
		 
		 while(rs.next()) {
				user= new UserBean();
				user.setEmail(rs.getString("email"));
					user.setFirstName(rs.getString("firstname"));
					user.setLastName(rs.getString("lastname"));
					user.setGender(rs.getString("gender"));
					user.setPassword(rs.getString("password"));
					user.setUserId(userId);
		 }
		 
	   }
	   catch (Exception e) {
		// TODO: handle exception
		   e.printStackTrace();
	}
		   
	   
	   return user;
	   
   }
   
   public boolean updateUser(UserBean user) {
	   boolean flag = false;
	   try(Connection con = DbConnection.getConnection();
			   PreparedStatement psmt = con.prepareStatement("update users set firstname = ?, lastname=?,gender=?,password=? where userid=?");
			   		)
		 {
		   psmt.setString(1, user.getFirstName());
			psmt.setString(2, user.getLastName());
			psmt.setString(3, user.getGender());
			psmt.setString(4, user.getPassword());
			psmt.setInt(5, user.getUserId());
			int updateCount = psmt.executeUpdate();
			if(updateCount == 1) {
				flag = true;
	   }
		 }
	   
	   catch (Exception e) {
	   e.printStackTrace();	// TODO: handle exception
	}
	   return flag;
   }
   
   public boolean deleteUser(int userID) {
		boolean flag = false;
		try(
				Connection con = DbConnection.getConnection();
				PreparedStatement psmt = con.prepareStatement("delete from users where userid = ?");
				){
			psmt.setInt(1, userID);
			int deleteRows = psmt.executeUpdate();
			if(deleteRows==1) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
 
 
}
