<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h2>User Login</h2>

				<form class="form-horizontal" action="LoginServlet" method="post">
					<div class="form-group">
						<label for="email">Email</label> 
						<input
							id="email" 
							type="email" 
							name="email"
							placeholder="email" 
							class="form-control" />
					</div>
					<div class="form-group">
						<label for="pass">Password</label> 
						<input  
						id="pass"
							type="password" 
							name="password"
							placeholder="password" 
							class="form-control" />
					</div>
					${error}
					<button type="submit" class="btn btn-outline-dark">Login</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>