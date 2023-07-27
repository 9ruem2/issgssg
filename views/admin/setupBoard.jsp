<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" href="../resources/css/admin.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style type="text/css">
th, td{
	text-align: center;
}
.title{
	text-align: left;
}
#paging{
	width: 100%;
	height: 30px;
	line-height: 30px;
	text-align: center;
}
.cateInput{
	margin: 0 auto;
	width: 500px;
	min-height: 250px;
	padding: 10px;
	background-color: #c1c1c1;
	text-align: center;
}
.cateInput input{
	width: 100%;
	height: 40px;
	margin-bottom: 10px;
	padding: 5px;
}
</style>
<script type="text/javascript">
function delBoardCate(no){
	if(confirm("글이 남아있으면 삭제할 수 없습니다.\n글을 먼저 삭제해야 합니다.\n삭제하시겠습니까?")){
		location.href="./delBoardCate.do?b_no="+no;	
	}	
}
//function updateBoardCate(no){}
function linkPage(pageNo){
	location.href = './board.do?pageNo='+pageNo;
}
$(function(){
	$(".updateBoardCate").click(function(){
		var no = $(this).parents("tr").children("td:eq(1)").text();
		var cate = $(this).parents("tr").children("td:eq(2)").text();
		var name = $(this).parents("tr").children("td:eq(3)").text();
		var url = $(this).parents("tr").children("td:eq(4)").text();
		var comment = $(this).parents("tr").children("td:eq(5)").text();
		
		alert(no + "/" + cate + "/" + name + "/" + url + "/" + comment);
	});
	$("#add").click(function(){		
		if($("#mb_cate").val() == ""){
			alert("올바른 카테고리 숫자를 입력하세요\n예) 5");
			$("#mb_cate").focus();
			return false;
		}
		if($("#mb_catename").val() == ""){
			alert("올바른 이름을 입력하세요");
			$("#mb_catename").focus();
			return false;
		}
		if($("#b_url").val() == ""){
			alert("올바른 경로를 입력하세요");
			$("#b_url").focus();
			return false;
		}
		
	    var form = document.createElement("form");       
			form.setAttribute("action" , "./setupBoard.do");
			form.setAttribute("method" , "POST");
			
		var mb_cate = document.createElement("input");	mb_cate.setAttribute("type", "hidden");
			mb_cate.setAttribute("name", "mb_cate");	mb_cate.setAttribute("value", $("#mb_cate").val());
		form.appendChild(mb_cate);
		
		var mb_catename = document.createElement("input");		mb_catename.setAttribute("type", "hidden");
			mb_catename.setAttribute("name", "mb_catename");	mb_catename.setAttribute("value", $("#mb_catename").val());
		form.appendChild(mb_catename);
		
		var b_url = document.createElement("input");	b_url.setAttribute("type", "hidden");
			b_url.setAttribute("name", "b_url");		b_url.setAttribute("value", $("#b_url").val());
		form.appendChild(b_url);
		
		var b_comment = document.createElement("input");	b_comment.setAttribute("type", "hidden");
			b_comment.setAttribute("name", "b_comment"); 	b_comment.setAttribute("value", $("#b_comment").val());
		form.appendChild(b_comment);
		
		document.body.appendChild(form);
		form.submit();
	});
});
</script>
<title>board</title>
</head>
<body>
<div class="continer">
	<div class="header">
		<%@ include file="menu.jsp" %>
	</div>
	<div class="main">
		<div class="article">
		<h1>report</h1>
		<p>카테고리에 글이 남아있으면 삭제할 수 없습니다.</p>
		<p>카테고리에 글이 남아있으면 삭제할 수 없습니다.</p>
		<c:choose><c:when test="${fn:length(list) gt 0}">
			<table class="table">
			<tr>
				<th>번호</th>
				<th>카테고리</th>
				<th>이름</th>
				<th>경로</th>
				<th>비고</th>
				<th>삭제</th>
			</tr><c:forEach items="${list }" var="a">
			<tr>
				<td>${a.b_no }</td>
				<td>${a.mb_cate }</td>
				<td class="title">${a.b_catename }</td>
				<td>${a.b_url }</td>
				<td>${a.b_comment }</td>
				<td><i class="xi-wrench updateBoardCate"></i> <i class="xi-trash" onclick="delBoardCate(${a.b_no })"></i></td>
			</tr></c:forEach>
		</table></c:when><c:otherwise><h2>데이터가 없습니다.</h2></c:otherwise></c:choose>
		<!-- 페이징 -->
		<div id="paging">
			<ui:pagination paginationInfo="${paginationInfo }" type="image" jsFunction="linkPage"/>
		</div>
			<input type="text" name="search" id=""><button class="xi-search">검색</button>
		<div class="cateInput">
			<input type="number" name="mb_cate" id="mb_cate" placeholder="카테고리번호를 입력하세요" required="required"><br>
			<input type="text" name="mb_catename" id="mb_catename" placeholder="카테고리명을 입력하세요" required="required"><br>
			<input type="text" name="b_url" id="b_url" placeholder="url을 입력하세요" required="required"><br>
			<input type="text" name="b_comment" id="b_comment" placeholder="설명을 입력하세요" ><br>
			<button type="button" class="btn btn-primary" id="add">저장하기</button>
		</div>
		</div>
	</div>
</div>
</body>
</html>