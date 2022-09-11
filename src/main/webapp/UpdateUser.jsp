<!-- fetching all the data record on database table on page -->

<!-- Record insertd in database -->
<%@page import="bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>

<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">

				<%
				UserBean user = (UserBean)request.getAttribute("user");
				String genderValue = user.getGender();
				%>


				<h2>Update user</h2>


				<form method="post" action="UpdateUserController">
				<input type="hidden" value="${user.userId }" name="userId">
					<div class="form-group">
						FirstName : <input type="text" name="firstName"
							class="form-control" value="${user.firstName}" />${firstNameError}
						
					</div>

					<div class="form-group">
						LastName : <input type="text" name="lastName" class="form-control"
							value="${user.lastName}" />${lastNameError} 

					</div>
					
					<div class="form-group">
						Email : <input type="email" name="email" class="form-control" value="${user.email}"  disabled />${emailError}
					</div>
					
					<div class="form-group">
						Password : <input type="password" name="password" class="form-control"
							value="${user.password}" />${passwordError}
					</div>

					Gender : Male <input type="radio" name="gender" value="male"
						<%=genderValue != null && genderValue.equals("male") ? "checked" : ""%> />
					Female : <input type="radio" name="gender" value="female"
						<%=genderValue != null && genderValue.equals("female") ? "checked" : ""%> />
			<%-- 		<span class="error"><%=genderError == null ? "" : genderError%></span> --%>
					
					<br><br> <input type="submit" class="btn btn-primary" value="Updateuser"/>
					
					<!-- <button type="reset" class="btn btn-danger">Reset</button> -->
					
					<div>
				<!-- 	<a href="Login.jsp">Already Registerd?</a> -->
                    </div>   				
				</form>
			</div>
		</div>
	</div>
</body>
</html>