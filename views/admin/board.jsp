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

a{
	color:black;
	text-decoration: none;
}
#title, #content{
	width: 100%;
	padding: 5px;
}
#title{
	height: 40px;
	margin-bottom: 5px;
}
#content{
	height: 300px;
}
</style>
<script type="text/javascript">
function linkPage(pageNo){location.href ='./board?pageNo='+pageNo;}

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
			 <ul>
	            <li><a href="./board">전시회일정</a></li>
	        </ul>
	        	<button type="button" class="btn btn-primary" onclick="location.href='./boardWrite'">글쓰기</button>
	        	
				<div class="tableDiv">
				<c:choose>
				<c:when test="${fn:length(boardList) gt 0}">
				<table class="table">
				<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>날짜</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${boardList }" var="a">
				<tr <c:if test="${a.b_del ne 0 }">style="background-color: #c0c0c0"</c:if>>
					<td>${a.b_no }</td>
					<td class="title">
						 <a onclick = "location.href='./boardDetail?b_no=${a.b_no}'">
						 <c:choose>
						 	<c:when test="${a.b_del eq 0 }">
								<i class="xi-eye"></i>
							</c:when>
							<c:otherwise>
								<i class="xi-eye-off-o"></i>
							</c:otherwise>
						</c:choose>
							${a.b_title }
						</a>
						</td>
					<td>${a.b_date }</td>
				</tr></c:forEach>
				</tbody>
				
			</table></c:when><c:otherwise><h2>데이터가 없습니다.</h2></c:otherwise></c:choose>
			</div>
		<!-- 페이징 -->
		<div id="paging">
			<ui:pagination paginationInfo="${paginationInfo }" type="image" jsFunction="linkPage"/>
		</div>
		</div>
	</div>

</div>








</body>
</html>