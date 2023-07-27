<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이쓱쓱 공지사항</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />    
    <script src="script/jquery-3.6.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>   
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">    
    
    <link rel="stylesheet" href="./css/notice.css">
    <script src="script/script.js"></script>
<script type="text/javascript">
    function viewCount(){
    	  
    	   location.href="noticeCount?n_no=${noticeDetail.n_no }&pageNo=${pageNo }";
    	}
</script>
    
</head>
<body>
    
  <%@ include file="header.jsp" %>
 


    <!--  ****** contents ******-->
    <div id="contents" class="inner">
        <ul>
            <li class="a"><a href="./notice">공지사항</a></li>
            <li class="b"><a href="./qna">Q&amp;A</a></li>
        </ul>
        <div id="notice">
        <br><br>
            <h2><img src="images/icon/txt_icon1.png" alt="txt_icon1">&nbsp;공지사항</h2>
            <table>
                <thead>
                    <tr class="row">
                        <th>번호</th>
                        <th class="to">제목</th>
                        <th>조회수</th>
                        <th>날짜</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${noticeList }" var="n">
                <tr class="row" onclick="location.href='./noticeDetail?n_no=${n.n_no}'">
                    <th>${n.n_no}</th>
                    <td class="to">${n.n_title }</td>
                    <th onclick = "viewCount()">${n.n_count }</th>
                    <td class="date">${n.n_date }</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
 
        <!-- pagination 페이지네이-->
        <div id="page">
			<ui:pagination paginationInfo="${paginationInfo }" type="image" jsFunction="linkPage"/>
        </div>
        
        
        <div id="find">
            <select>
                <option>일주일</option>
                <option>1개월</option>
                <option>6개월</option>
                <option>1년</option>
            </select>
            <span>제목</span>
            <input type="text">
            <a href="#"><i class="fa-solid fa-magnifying-glass"></i></a>
        </div>
    </div>
    <!--  ****** contents ******-->



    <%@ include file="footer.jsp" %>
<script type="text/javascript">
function linkPage(pageNo){
	location.href = "./notice?pageNo="+pageNo;
}
</script>
</body>
</html>
