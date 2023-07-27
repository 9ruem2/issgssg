<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>아이쓱쓱 글 쓰기</title>
<meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />    
    <script src="./script/jquery-3.6.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>   
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">    
    <link rel="stylesheet" href="./css/main.css">
    <script src="./script/script.js"></script>
    

<link rel="stylesheet" href="./css/galleryWrite.css">

<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script type="text/javascript">
$(function(){
	//alert("!");
	$("#picDel").click(function(){
		alert("삭제합니다");
		var p = $(this).parent();
		//여기 ajax
		$.ajax({
			url : "./galleryPicDel?g_no=${galleryUpdate.g_no}",
			type : "POST",
			dataType : "text",
			success : function(data){
				if(data == "1"){
					//alert(data + "라고 들어왔습니다.");
					p.html('<input type="file" name="file" accept=".png, .jpg, .gif, .jpeg, .bmp">');
				}
			},
			error: function(){
				alert("썸네일을 삭제 할 수 없습니다.");
			}
		});
		return false;
	});
});
//
</script>
</head>
<body>
	<!--****** header ******-->
	<%@ include file="header.jsp"%>
	<!--****** header ******-->


	<!--****** content ******-->	
		
	<div class="container">
		<form action="./galleryUpdate" method="post" enctype="multipart/form-data">
			<input type="text" name="title" id="title" value="${galleryUpdate.g_title }" placeholder="제목을 적어주세요" required="required" style="width: 100%; height: 40px; margin-bottom: 10px;">
			<textarea id="summernote" name="content">${galleryUpdate.g_content }</textarea>
			<c:choose>
				<c:when test="${galleryUpdate.g_thumb ne null }">
					<div class="picForm">
						<img alt="" src="./thumbnail/${galleryUpdate.g_thumb }" style="height:200px;">
						<button type="button" class="btn btn-danger" id="picDel">삭제하기</button>
					</div>
				</c:when>
				<c:otherwise>
					<input type="file" name="file" accept=".png, .jpg, .gif, .jpeg, .bmp" style="margin-bottom: 15px;">
				</c:otherwise>
			</c:choose>
				<input type="hidden" name="g_no" value="${galleryUpdate.g_no }">
				<input type="hidden" name="pageNo" value="${param.pageNo }">
				<button class="btn btn-warning" type="submit" style="margin-top:15px; margin-bottom: 50px;">저장하기</button>
		</form>
	</div>

	<script>
		$(document).ready(function() {
			$('#summernote').summernote({
				height : 400
			});
		});
	</script>
	<!--****** content ******-->

	<!--****** footer ******-->
	<%@ include file="footer.jsp"%>
	<!--****** footer ******-->


</body>
</html>
