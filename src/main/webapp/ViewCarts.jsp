<%@page import="bean.CartProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.CartBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view Cart</title>
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
	   ArrayList<CartProductBean> carts = (ArrayList<CartProductBean>) request.getAttribute("carts");
	%>
	
	
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<table id="carts"class="display table-hover table-bordered table-striped" >

					<thead class="thead-light">

						<tr>
							
							<th>ProductId</th>
							<th>ProductName</th>
							<!-- <th>CartId</th> -->
							<th>Price</th>
							<th>Action</th>
						</tr>

					</thead>

				
						<%
						
						   int total=0;
				 		    for (CartProductBean  cart : carts){
				 		    	total= total+cart.getPrice();
						%>
						<tr>
							<td><%=cart.getProductId()%></td>
							<%-- <td><%=cart.getCartId()%></td> --%>
							<%-- <td><%=cart.getUserId()%></td> --%>
							<td><%=cart.getName() %></td>
							<td><%=cart.getPrice() %></td>
							<td><a href="DeleteViewCartController?cartid=<%=cart.getCartId()%>">Delete</a> </td>
							
							
							
						</tr>

						<%
						    }
						%>
					

				</table>
				
				<h2>
				Total<%=total %>
				
				</h2>
				<a href="CheckoutController" class="btn btn-success">placeorder</a>

			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js" ></script>
	<script type="text/javascript">
	$(document).ready(function () {
	    $('#carts').DataTable();
	});
	</script> 
	
</body>
</html>