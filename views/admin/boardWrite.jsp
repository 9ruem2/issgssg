<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" href="../css/admin.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style type="text/css">

#main{
	margin: 0 auto;
	width:95%;
	margin-top: 60px;
}

#title{
	width: 100%;
	padding: 10px;
	box-sizing: border-box;
	margin-bottom: 5px;
}
#content{
	width: 100%;
	height: 500px;
	padding: 10px;
	box-sizing: border-box;
}
input, textarea {
	border: 1px solid #c0c0c0;
}
</style>

<title>board</title>
</head>
<body>

	<div class="header">
		<%@ include file="menu.jsp" %>
	</div>
	
	<div class="main">
		<h1>gallery</h1>
		<div>
			<form action="./boardWrite" method="post" enctype="multipart/form-data">
				<input type="text" name="title" id="title"
						placeholder="제목을 적어주세요" required="required">
				<textarea name="content" id="content"></textarea>
				<input type="file" name="file" accept=".png, .jpg, .gif, .jpeg, .bmp">
				<button class="btn btn-primary" type="submit">저장하기</button>
			</form>
		</div>	
 </div>	








</body>
</html>