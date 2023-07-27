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
</style>
<script type="text/javascript">
function linkPage(pageNo){
	location.href = './qnaComment?pageNo='+pageNo;
}

function dele(qc_no){
	if(confirm("삭제하시겠습니까?")){
		location.href="./qnaCommentPostDel?qc_no="+qc_no;
	}
}


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
		<h1>Q&Acomment</h1>
		<c:choose><c:when test="${fn:length(qnaCommentList) gt 0}">
			<table class="table">
			<tr>
				<th>번호</th>
				<th>글번호</th>
				<th>작성자</th>
				<th>글내용</th>
				<th>작성일</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${qnaCommentList }" var="qc">
			<tr>
				<td>${qc.qc_no }</td>
				<td>${qc.q_no }</td>
				<td>${qc.m_id }</td>
				<td class="title">${qc.qc_comment }
				<td>${qc.qc_date }</td>
				<td>
				<i class="xi-trash" onclick="dele(${qc.qc_no })"></i> 
				</td>
				
			</tr>
			</c:forEach>
		</table></c:when><c:otherwise><h2>데이터가 없습니다.</h2></c:otherwise></c:choose>
		<!-- 페이징 -->
		<div id="paging">
			<ui:pagination paginationInfo="${paginationInfo }" type="image" jsFunction="linkPage"/>
		</div>
	</div>
</div>
</div>
</body>
</html>