package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ProductBean;
import util.DbConnection;

public class ProductDao {

	public ArrayList<ProductBean> getAllProducts() {

		ArrayList<ProductBean> products = new ArrayList<>();

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from products");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductBean p = new ProductBean();
				p.setProductId(rs.getInt("productid"));
				p.setPrice(rs.getInt("price"));
				p.setQty(rs.getInt("qty"));
				p.setName(rs.getString("name"));
			    p.setImgUrl(rs.getString("imgurl")); 

				products.add(p);
			}

		} catch (Exception e) {
			System.out.println("SMW in ProductDao::getAllProducts()");
			e.printStackTrace();
		}

		return products;
	}
	
}	