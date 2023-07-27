<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" href="../css/admin.css">
<style type="text/css">
.article{
	width: 100%;
	height: 100vh;
}
.boxs{
	clear:both;
 	margin:0 auto;
 	margin-top: 20%;
	width: 95%;
	height: 300px;
	display: flex;
}
.box{
	float: left;
	margin: 50px;
	height: 100px;
	width: 100px;
	padding: 10px;
	text-align: center; 
	line-height: 100px;
	border: 1px black solid;
	border-radius: 50%;
	overflow: hidden;
	transition:0.3s;
	border: 0px;
	font-weight: 600;
}
.box:hover{
	font-size: large;
	font-weight: bolder;
	margin: 5px;
	height: 210px;
	width: 200px;
	line-height: 105px;
	transition:0.4s;
	border-radius: 20px;
	
}
#comment{
	width: 100%; 
	height: 100px;
	padding:5px;
	line-height: 30px;
	overflow: visible;
	animation: fadeInUp 1s;
}
</style>
<title>admin</title>
</head>
<body>
<div class="continer">
	<div class="header">
		<%@ include file="menu.jsp" %>
	</div>
	<div class="main">
		<div class="article">
		<div class="boxs">
			<div class="box" style="background-color: #A5AA94;" onclick="location.href='./setupBoard'">
			소개<div id="comment">아이쓱쓱소개를<br>관리합니다 </div>
			</div>
			<div class="box" style="background-color: #8DAAA6;" onclick="location.href='./notice'">
			공지<div id="comment">공지사항을<br>관리합니다</div>
			</div>
			<div class="box" style="background-color: #C4C9B2;" onclick="location.href='./gallery'">
			갤러리<div id="comment">갤러리를<br>관리합니다 </div>
			</div>
			<div class="box" style="background-color: #EFE3D3;" onclick="location.href='./board'">
			전시회<div id="comment">전시회일정을<br>관리합니다</div>
			</div>
			<div class="box"  style="background-color: #F6D5B6;" onclick="location.href='./qna'">
			Q&A<div id="comment">Q&A를<br>관리합니다</div>
			</div>
			<div class="box" style="background-color: #F9AE8C;" onclick="location.href='./qnaComment'">
			QnA댓글<div id="comment">댓글을<br>관리합니다</div>
			</div>
			<div class="box" style="background-color: #FF9376;" onclick="location.href='./member'">
			회원<div id="comment">회원을<br>관리합니다</div>
			</div>
			
		</div>
		</div>
	</div>
</div>
</body>
</html>