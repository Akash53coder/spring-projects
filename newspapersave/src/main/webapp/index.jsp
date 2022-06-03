<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.footer {
	bottom: 0; 
	margin-bottom: 0px; 
	margin-top: 10%; 
	text-align: center; 
	background-color: #595959; 
	padding-top: 10px; 
	padding-bottom: 10px; 
	width: 100%; 
	color: white;
}
</style>
</head>
<body>
	<h2 style="margin-top: 0px; text-align: center; background-color: #009999; padding-top: 10px; padding-bottom: 10px; width: 100%; color: white">Welcome
		to Newspaper App</h2>

	<h3 style="color: green; margin-left: 30px; text-align: center;">${DataSaved}</h3>
	<h3 style="color: red; margin-left: 30px; text-align: center;">${DataNotSaved}</h3>

	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-lg-6">
				<a href="getAllNewsPaper.zzz" style="text-decoration: underline"><h4>View
						all NewsPaper</h4></a>
				<div class="container" style="margin-top: 8px">
					<table class="table table-bordered table-responsive" style="width: 500px">
						<thead>
							<tr>
								<th>Name</th>
								<th>Price</th>
								<th>No Of Pages</th>
								<th>Langauge</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ListOfNewsPaper}" var="newspaperobj">
								<tr>
									<td>${newspaperobj.name}</td>
									<td>${newspaperobj.price}</td>
									<td>${newspaperobj.noOfPages}</td>
									<td>${newspaperobj.language}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-lg-6">
				<form action="send.zzz" method="POST">
					<h4>Save News Paper</h4>
					<div class="form-group">
						Name:<input type="text" name="name" class="form-control">
						<span style="color: red">${nameNotValid}</span>
					</div>
					<div class="form-group">
						Price:<input type="text" name="price" class="form-control" value="0">
						<span style="color: red">${priceNotValid}</span>
					</div>
					<div class="form-group">
						NoOfPages:<input type="text" name="noOfPages" class="form-control" value="0">
						<span style="color: red">${pageNotValid}</span>
					</div>
					<div class="form-group">
						Language:<input type="text" name="language" class="form-control">
						<span style="color: red">${langNotValid}</span>
					</div>
					<button type="submit" class="btn btn-primary pull-right">Submit</button>

				</form>
			</div>
		</div>
	</div>
	<!-- search news paper -->
	<div class="container" style="margin-top: 8px">
		<div class="row">
			<div class="col-lg-6">
				<h4 style="color: red; text-align: center;">${isSearchValid}</h4>
				<h4 style="color: red; text-align: center;">${newsPaperNotFound}</h4>
				<h4>Search News Paper</h4>
				<form action="search.zzz" method="POST">
					<input type="text" name="searchNewsPaper" class="form-control"
						placeholder="search news paper" width="100px">
					<button type="submit" class="btn btn-success pull-right"
						style="margin-top: 8px;margin-bottom:10px">Search</button>
				</form>
				<table class="table table-bordered" style="width: 500px;">
					<thead>
						<tr>
							<th>Name</th>
							<th>Price</th>
							<th>No Of Pages</th>
							<th>Langauge</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${newsPapername}</td>
							<td>${newsPaperPrice}</td>
							<td>${newsPaperPages}</td>
							<td>${newsPaperLang}</td>
						</tr>
					</tbody>
				</table>
				<hr>
					<form action="updateNewsPaper.zzz" method="POST">
						<h4>Update News Paper By Search</h4>
						<h4 style="color:green;">${newsPaperUpdated}</h4>
						<h4 style="color:red;">${invalidNewsPaper}</h4>
						<div class="form-group">
							Name:<input type="text" name="name" class="form-control" value="${newsPapername}">
						</div>
						<div class="form-group">
							Price:<input type="text" name="price" class="form-control" value="${newsPaperPrice}">
						</div>
						<div class="form-group">
							NoOfPages:<input type="text" name="noOfPages" class="form-control" value="${newsPaperPages}">
						</div>
						<div class="form-group">
							Language:<input type="text" name="language" class="form-control" value="${newsPaperLang}">
						</div>
						<button type="submit" class="btn btn-warning pull-right">Update</button>

				</form>
			</div>
			<div class="col-lg-6">
				<h4 style="color: green; text-align: center;">${NewsPaperDeleted}</h4>
				<h4 style="color: red; text-align: center;">${NoNewsPaperFound}</h4>
				<h4 style="color: red; text-align: center;">${InvalidNewsPaper}</h4>
				<h4>Delete News Paper</h4>
				<form action="deleteNewsPaper.zzz" method="POST">
					<input type="text" name="deleteNewsPaper" class="form-control"
						placeholder="search news paper" width="100px">
					<button type="submit" class="btn btn-danger pull-right"
						style="margin-top: 8px;">Delete</button>
				</form>
			</div>
		</div>
	</div>
	<h5 class="footer">
		<b>@2021 CopyRight NewsPaper</b>
		<br><br><b>By Akash-XWorkz</b>
	</h5>
</body>
</html>