<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />    
    <script src="script/jquery-3.6.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>   
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">
    <link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <link rel="stylesheet" href="css/noticeDetail.css">
    <script src="script/script.js"></script>
</head>
<body>
  <%@ include file="header.jsp" %>

    <!--  ****** contents ******-->
    <div id="contents" class="inner">
        <h2 class="t">공지사항</h2>
        <div id="view_w"> 
            <div id="view_title">
                <div>
                    <div>
                        <h2>${noticeDetail.n_title }</h2><br>
                    <h3>관리자</h3>
                    <p>${noticeDetail.n_date } <span style="text-align: right;">조회수 : ${noticeDetail.n_count }</span></p>
                    </div>
                 </div>
                 <hr class="line">
            </div>
            <div id="view_cont">
                <div>
                    <!--게시판 내용 영역 시작-->
                    ${noticeDetail.n_content } <br> 
                    
                </div><!--게시판 내용 영역 끝-->
            </div>
         <div id="list">
                <span><a href="./notice"><i class="xi-view-list"></i>공지사항 전체보기</a></span>
                 <hr>
                <table>
                <tbody>
					<c:if test="${before ne null }">                
                    <tr>
                        <th>이전글</th>
                        		<td class="ct"><a href="./noticeDetail?n_no=${before.n_no }">${before.n_title }</a></td>
                        		<td class="date">${before.n_date }</td>
                    </tr>
                    </c:if>
                    <c:if test="${after ne null }">
                    <tr>
                        <th>다음글</th>
                        <td class="ct"><a href="./noticeDetail?n_no=${after.n_no }">${after.n_title }</a></td>
                        <td class="date">${after.n_date }</td>
                    </tr>
                    </c:if>
           	 	</tbody>
                </table>
            </div>
            <hr class="line under">
            <div id="view_bottom">
         </div>       
   </div>
</div>


<%@ include file="footer.jsp" %>

</body>
</html>

