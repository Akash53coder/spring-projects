<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mail App</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
			<div class="col-lg-6">
				<form action="sendmail.abc" method="POST">
					<h2>Send Mail</h2>
		<h3 style="color: green; margin-left: 30px; text-align: center;">${Mail_Sent_Message}</h3>
		<h3 style="color: red; margin-left: 30px; text-align: center;">${Mail_Not_Sent_Message}</h3>
					<div class="form-group">
						To:<input type="text" name="to" class="form-control">
					</div>
					<div class="form-group">
						Subject:<input type="text" name="subject" class="form-control">
					</div>
					<div class="form-group">
						Message:<input type="text" name="message" class="form-control">
					</div>
					<button type="submit" class="btn btn-primary pull-right">Submit</button>
				</form>
			</div>
		</div>
</body>
</html>