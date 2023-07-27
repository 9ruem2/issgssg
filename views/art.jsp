<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이쓱쓱 전시회일정</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />    
    <script src="script/jquery-3.6.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>   
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">    
    
    <link rel="stylesheet" href="./css/art.css">
    <script src="script/script.js"></script>
<script type="text/javascript">
$(function(".wood_b"){
	
	$(".wood_b").click(function(){
		
			location.href="./artDetail?b_no=${artDetail.b_no }&pageNo=${artDetail.pageNo}";
	});
	  
});

function viewCount(){
	 
	   location.href="artCount?b_no=${artDetail.b_no }&pageNo=${pageNo }";
	}


</script>
</head>
<body>
    
    <%@ include file="header.jsp" %>


    <!--  ****** contents ******-->
    <div id="contents" class="inner">
	        <h2 class="t" >어떤 전시회가 있을까?</h2>
	        <div id="poster_w">
	        <ul class="poster">
	        <c:forEach items="${artList }" var="a">
	                <li onclick = "location.href='./artDetail?b_no=${a.b_no}&pageNo=${pageNo}'">
	                        <img onclick = "viewCount()" alt="img" src="./thumbnail/${a.b_thumb }" height="420px">
	                        <div class="wood_b">
	                            <p>${a.b_title } </p>
	                        </div>
	                </li> 
        </c:forEach>
        </ul>
        </div>
       <!-- pagination 페이지네이-->
        <div id="page">
			<ui:pagination paginationInfo="${paginationInfo }" type="image" jsFunction="linkPage"/>
        </div>
    </div>




   <%@ include file="footer.jsp" %>
   
   
<script type="text/javascript">
function linkPage(pageNo){
	location.href = "./art?pageNo="+pageNo;
}
</script>

</body>
</html>
