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
.viewInfo{
	font-weight: bolder; 
	margin-bottom: 10px;
}
.viewDate{
	background-color: #c0c0c0;
	width : 100%;
	height:30px;
	line-height:30px;
	margin-bottom: 10px;
	
}
.viewbody{
	clear:both;
	width: 100%;
	margin-top:20x;
	height: 300px;
}
.modal-body{
	text-align: left;
}


.modal-body button {
	float:right;	
}
.viewData{
	background-color: #c0c0c0;
	margin-bottom: 5px;
}

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
function linkPage(pageNo){location.href ='./notice?pageNo='+pageNo;}
function noticeDetail(no){
	$.ajax({
		url: "./noticeView",
		data: { "no" : no, "pageNo" : ${pageNo}},
		method: "POST",
		dataType: "json"
	}).done(function(data) {
		var result = data.result;
		if(result != null){	
			$("#staticBackdropLabel").text(result.n_no + "번 글");
			$(".viewNo").val(result.n_no);
			$(".viewInfo").text("제목_"+result.n_title);
			$(".viewDate").text("날짜_"+result.n_date);
			$(".viewbody").html(result.n_content);
			$("#view").modal("show");
		}
	}).fail(function(xhr, status, errorThrown) {alert("오류 발생");});
}
$(function(){
	$("#reset").click(function(){location.href="./notice"});
	$(".selectCate").on("change", function(){location.href="./notice?n_no="+$("n_no").val();});
	$(".postDel").click(function(){
		if(confirm($(".viewNo").val()+"글을 삭제하시겠습니까?")){
			location.href="postDel?n_no="+$(".viewNo").val()+"&pageNo=${pageNo}";
		}
	});
});
</script>
<title>admin:notice</title>
</head>
<body>
<div class="continer">
	<div class="header">
	<%@ include file="menu.jsp" %>
	</div>
	
	<div class="main">
		<div class="article">
		 <ul>
            <li><a href="./notice">공지사항</a></li>
        </ul>
        
        
			<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">글쓰기</button> 
			<div class="tableDiv">
			<c:choose>
			<c:when test="${fn:length(list) gt 0}">
			<table class="table">
			<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>날짜</th>
			</tr>
			</thead><tbody><c:forEach items="${list }" var="a">
			<tr <c:if test="${a.n_del ne 0 }">style="background-color: #c0c0c0"</c:if>>
				<td>${a.n_no }</td>
				<td class="title">
					<a onclick="noticeDetail(${a.n_no})"><c:choose><c:when test="${a.n_del eq 0 }">
					<i class="xi-eye"></i></c:when><c:otherwise><i class="xi-eye-off-o"></i></c:otherwise></c:choose>${a.n_title }</a></td>
				<td>${a.n_date }</td>
			</tr></c:forEach>
			</tbody>
			
		</table></c:when><c:otherwise><h2>데이터가 없습니다.</h2></c:otherwise></c:choose>
		</div>
<!-- 페이징 -->
		<div id="paging">
			<ui:pagination paginationInfo="${paginationInfo }" type="image" jsFunction="linkPage"/>
		</div>
	</div>
		<!-- Button trigger modal -->
		
<!-- view Modal --><!-- data-bs-backdrop="static" -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="staticBackdropLabel">공지사항 글쓰기</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="./notice" method="post">
        	<input type="text" name="title" id="title" required="required">
        	<textarea name="content" id="content" required="required"></textarea>
        	<button class="btn btn-primary">글쓰기</button>
        </form>
      </div>
    </div>
  </div>
</div>
<!-- 글쓰기 모달 끝 -->

<div class="modal fade" id="view"  data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h2 class="modal-title fs-5" id="staticBackdropLabel"></h2>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      	<div class="viewNo"></div>
      	<div class="viewInfo"></div>
      	<div class="viewId"></div>
      	<div class="viewDate"></div>
        <div class="viewbody"></div>
        <div class="viewData"></div>
        <button class="btn btn-danger postDel">글 숨기기</button>        
      </div>
    </div>
  </div>
</div>
</div>










	</div>
	
<script type="text/javascript">
function linkPage(pageNo){
	location.href = "./notice?pageNo="+pageNo;
}
</script>
</div>
</body>
</html>