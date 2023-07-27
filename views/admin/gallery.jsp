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
function linkPage(pageNo){location.href ='./gallery?pageNo='+pageNo;}

</script>
<title>admin:gallery</title>
</head>
<body>
<div class="continer">
	<div class="header">
		<%@ include file="menu.jsp" %>
	</div>
	
	<div class="main">
			<div class="gallery">
			<ul>
            	<li><a href="./gallery">갤러리</a></li>
        	</ul>
	        	
			<div class="tableDiv">
				<c:choose>
					<c:when test="${fn:length(galleryList) gt 0}">
						<table class="table">
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>날짜</th>
								</tr>
							</thead>
						<tbody>
							<c:forEach items="${galleryList }" var="a">
								<tr <c:if test="${a.g_del ne 0 }">style="background-color: #c0c0c0"</c:if>>
									<td>${a.g_no }</td>
									<td class="title">
										 <a onclick = "location.href='./galleryDetail?g_no=${a.g_no }&pageNo=${pageNo }'">
										 <c:choose>
										 	<c:when test="${a.g_del eq 0 }">
												<i class="xi-eye"></i>
											</c:when>
											<c:otherwise>
												<i class="xi-eye-off-o"></i>
											</c:otherwise>
										</c:choose>
											${a.g_title }
										</a>
									</td>
									<td>${a.m_nick }</td>
									<td>${a.g_date }</td>
								</tr>
							</c:forEach>
						</tbody>			
					</table>
				</c:when>
				<c:otherwise>
					<h2>데이터가 없습니다.</h2>
				</c:otherwise>
			</c:choose>
		</div>
		
		<!-- 페이징 -->
		<div id="paging">
			<ui:pagination paginationInfo="${paginationInfo }" type="image" jsFunction="linkPage"/>
		</div>
		<br>
		</div>
	</div>

</div>








</body>
</html>