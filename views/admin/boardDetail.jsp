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
	color: black;
}
#detail{
	background-color: white;
	margin: 0 auto;
	width: 90%;
	height: auto;
	margin-top: 15px;
}
#detailH{
	height: 80px;
	line-height: 60px;
	font-size: x-large;
	border-top: 1px gray solid;
	border-bottom: 1px solid black;
	padding:10px;
	box-sizing: border-box;
	overflow: hidden;
}
#detailIdDate{
	height: 50px;
	line-height: 30px;
	background-color: #D3D3D3;
	border-bottom: 1px gray solid;
	padding:10px;
	box-sizing: border-box;
}
#detailID, #detailDate{
	width: 45%;
	float: left;
}
#detailDate{
	float: right;
	text-align: right;
}
#detailContent{
	padding:10px;
	min-height:300px;
	height: auto;
	border-bottom: 1px solid white;
	box-sizing: border-box;
	margin: o auto;
}
</style>

<title>board</title>
<script type="text/javascript">
function dele(b_no){
	if(confirm("삭제하시겠습니까?")){
		location.href="./boardDelete?b_no="+b_no;
	}
}
</script>
</head>
<body>

	<div class="header">
		<%@ include file="menu.jsp" %>
	</div>
	
	<div class="main">
		<h1>전시회일정</h1>
		
		<div>
			<div id="detail">
			<div id="detailH">${boardDetail.b_title }
			<i class="xi-trash" onclick="dele(${boardDetail.b_no })"></i> 
			</div>
			<div id="detailIdDate">
				<div id="detailID">${boardDetail.b_no }번글
				</div>
				<div id="detailDate">${boardDetail.b_date }</div>
			</div>
			<div id="detailContent">
				<img alt="" src="../upFile/${boardDetail.b_img }">
				<br>
				${boardDetail.b_content }
			</div>
		</div>	
 	</div>
 </div>








</body>
</html>