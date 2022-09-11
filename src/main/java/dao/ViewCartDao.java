package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DbConnection;

public class ViewCartDao {

	public boolean deleteViewCart(int cartid) {
		boolean flag = false;
		try(
				Connection con = DbConnection.getConnection();
				PreparedStatement psmt = con.prepareStatement("delete from carts where cartid = ?");
				){
			psmt.setInt(1, cartid);
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
