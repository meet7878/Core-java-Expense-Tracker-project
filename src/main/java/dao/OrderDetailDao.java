package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.OrderDetailBean;
import bean.OrderDetailProductBean;
import util.DbConnection;

public class OrderDetailDao {

	 public void addOrderDetail(OrderDetailBean orderDetailBean) {
		 try {
			 Connection con = DbConnection.getConnection();
   		  PreparedStatement pstmt = con.prepareStatement("insert into orderdetails(orderid,productid,price)values(?,?,?) ");
   		  pstmt.setInt(1, orderDetailBean.getOrderId());
   		 pstmt.setInt(2, orderDetailBean.getProductId());
   		 pstmt.setInt(3, orderDetailBean.getPrice());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("smw OrderDetailDao :: addOrderDetail()");
			e.printStackTrace();
		}
	 }
	  
 public ArrayList<OrderDetailProductBean> getOrderDetails(int orderId){
	 ArrayList<OrderDetailProductBean> details = new ArrayList<OrderDetailProductBean>();
	 
	 
	 try {
		 Connection con = DbConnection.getConnection();
		  PreparedStatement pstmt = con.prepareStatement("select p.imgurl,p.name,od.orderdetailid,od.orderid,od.price,p.productid  from orderdetails od,products p where p.productid = od.productid and od.orderid = ?  ");
		  pstmt.setInt(1, orderId);
		  ResultSet rs =pstmt.executeQuery();
		  
		  while(rs.next()) {
			  OrderDetailProductBean bean = new OrderDetailProductBean();
			  bean.setImgUrl(rs.getString("imgurl"));
			  bean.setName(rs.getString("name"));
			  bean.setOrderDetailId(rs.getInt("orderdetailid"));
			  bean.setOrderId(rs.getInt("orderid"));
			  bean.setPrice(rs.getInt("price"));
			  bean.setProductId(rs.getInt("productid"));
			  
			  System.out.println(bean);
			  details.add(bean);
		  }
		
	} catch (Exception e) {
		System.out.println("smw OrderDetailDao :: getOrderdetail()");
		e.printStackTrace();
	}
	 return details;
 
 }
 }

