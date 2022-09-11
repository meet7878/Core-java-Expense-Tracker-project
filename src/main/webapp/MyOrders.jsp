<%@page import="bean.OrderDetailBean"%>
<%@page import="bean.OrderBean"%>
<%@page import="bean.CartProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.CartBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>placed order</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	
<link rel="stylesheet" 
href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
</head>
<body>
	<jsp:include page="UserMenu.jsp"></jsp:include>
		<%
	   ArrayList<OrderBean> orders = (ArrayList<OrderBean>) request.getAttribute("orders");
	%>
	
	
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
			<h2><center>Placed order</center></h2>
				<table id="order"class="display table-hover table-bordered table-striped" >

					<thead class="thead-light">

						<tr>
							
							<th>OrderId</th>
							<th>Amount</th>
							 <th>PaymentMode</th> 
							<th>PaymentStatus</th>
							<th>OrderStatus</th>
							<th>Action</th>
						</tr>

					</thead>

				
						<%
						
						  
				 		    for (OrderBean  order : orders){
				 		    	
						%>
						<tr>
							<td><%=order.getOrderId()%></td>
							 <td><%=order.getAmount()%></td> 
							 <td><%=order.getPaymentMode()%></td> 
							<td><%=order.getPaymentStaus() %></td>
							<td><%=order.getOrderStatus() %></td>
							<td><a href="MyOrderDetailController?orderId=<%=order.getOrderId()%>">View Detail</a> </td>
							
							
							
						</tr>

						<%
						    }
						%>
					

				</table>
				
			
				
				
				

			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js" ></script>
	<script type="text/javascript">
	$(document).ready(function () {
	    $('#order').DataTable();
	});
	</script> 
	
</body>
</html>