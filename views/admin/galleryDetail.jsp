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
#view_comment {
    width: 90%;
    margin: 20px auto 50px;
;
}
.flex {
    display: flex;
    width: 100%;
    justify-content: space-between;
    flex-wrap: wrap;
}
.flex h5 {
    width: 50%;
}
.flex span {
    width: 40%;
    text-align: right;
}
</style>

<title>admin:galleryView</title>
<script type="text/javascript">
$(function(){	
	$(".xi-trash-o").click(function(){
		var gc_no = $(this).parents("#shin").children("#cid").text();
		//alert(gc_no);
		if(confirm("댓글을 삭제하시겠습니까?")){
			location.href="./galleryCommentDelete?g_no=${galleryDetail.g_no }&gc_no="+gc_no+"&pageNo=${galleryDetail.pageNo }";
		}
	});

});

function dele(g_no){
	if(confirm("숨기시겠습니까?")){
		location.href="./galleryDelete?g_no="+g_no+"&pageNo=${galleryDetail.pageNo }";
	}
}

</script>
</head>
<body>

	<div class="header">
		<%@ include file="menu.jsp" %>
	</div>
	
	<div class="main">
		<h1>갤러리</h1>
		
		<div>
			<div id="detail">
				<div id="detailH">${galleryDetail.g_title }
					<i class="xi-trash" onclick="dele(${galleryDetail.g_no })"></i>   
				</div>
				<div id="detailIdDate">
					<div id="detailID">${galleryDetail.g_no }번글 <span>${galleryDetail.m_nick }님</span></div>
					<div id="detailDate">${galleryDetail.g_date }</div>
				</div>
				<div id="detailContent">
					${galleryDetail.g_content }
				</div>
			</div>
			
			<div id="view_comment"  style="margin-bottom: 50px;">
				<c:choose>
					<c:when test="${fn:length(galleryComments) > 0 }">
						<c:forEach items="${galleryComments }" var="gc">
							<div class="comment">
								<div class="co_1">
									<div id="shin">
										<div id="cid" style="height:0px; visibility: hidden;">${gc.gc_no }</div>
										<div class="flex">
											<h5>${gc.m_nick } 님
												<i class="xi-trash-o"></i>
											</h5>
											<span class="co_date">${gc.gc_date }</span>
										</div>
										<p class="co_txt">${gc.gc_comment }</p>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<h2>댓글이 없습니다.</h2>
					</c:otherwise>
				</c:choose>						
			</div>	
			
			<br>
			<br>
			
 		</div>
 </div>








</body>
</html>