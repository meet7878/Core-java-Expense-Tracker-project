<%@page import="bean.OrderDetailProductBean"%>
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
<title>My order Detail</title>
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
	   ArrayList<OrderDetailProductBean> details = (ArrayList<OrderDetailProductBean>) request.getAttribute("details");
	%>
	
	
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
			<h2><center> Order Detail</center></h2>
				<table id="details"class="display table-hover table-bordered table-striped" >

					<thead class="thead-light">

						<tr>
							
							<th>Name</th>
							<th>Price</th>
							 <th>Image</th> 
							
						</tr>

					</thead>

				
						<%
						
						  
				 		    for (OrderDetailProductBean  detail : details){
				 		    	
						%>
						<tr>
							<td><%=detail.getName()%></td>
							 <td><%=detail.getPrice()%></td> 
							 <td><img height="100px" width="100px" src ="<%=detail.getImgUrl()%>"/></td> 
							
							
							
							
							
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
	    $('#details').DataTable();
	});
	</script> 
	
</body>
</html>