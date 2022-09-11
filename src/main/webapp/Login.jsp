<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>

	<div class="container-fluid">
		<div class=row>
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form action="Logincontroller" method="post">
					<div class="form-group">
						Email<input type="email" name="email" class="form-control" />
					</div>

					<div class="form-group">
						password<input type="password" name="password"
							class="form-control" />
					</div>
                       
					<input type="submit" value="Login" class="btn btn-primary" />



				</form>
				<div>
					<a href="Signup.jsp">New User?</a>
				</div>
				
				<div>
				<a href="fogetpassword.jsp">forgetpassword</a>
				</div>
				<div>
					<a href="ListUserController">ListUser</a>
				</div>
				${msg}
				<span class="text-danger">${errormsg}</span>
			</div>
		</div>
	</div>
</body>
</html>