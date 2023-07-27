<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
    <link rel="stylesheet" href="./css/report.css">
    <script src="script/script.js"></script>
    
      
</head>
<body>
<%@ include file="header.jsp" %>

  <!--  ****** contents ******-->
    <div id="contents" class="inner">

    </div>
    <!--  ****** contents ******-->
    <div id="contents" class="inner">
        <h2>아이쓱쓱 소개</h2>
        <c:forEach items="${reportList }" var="r">
        <div id="top_wrap">
            <div id="main_img"><img src="./images/report/${r.r_image1 }" alt="main"></div>
            <div id="txt_wrap">
                <h3>${r.r_title}</h3>
                <p class="txt_first">${r.r_content}</p>
                <p class="txt_second">${r.r_content2 }</p>
            </div>
        </div>

        <div id="cont_wrap">
            <ul>
                <li>
                    <img src="./images/report/${r.r_image2 }" alt="img1">
                    <p>${r.r_imgcontent1 }</p>
                </li>
                <li>
                    <img src="./images/report/${r.r_image3 }" alt="img2">
                    <p>${r.r_imgcontent2 }</p>
                </li>
                <li>
                    <img src="./images/report/${r.r_image4 }"  alt="img3">
                    <p>${r.r_imgcontent3 }</p>
                </li>
                <li>
                    <img src="./images/report/${r.r_image5 }" alt="img4">
                    <p>${r.r_imgcontent4 }</p>
                </li>
            </ul>
        </div>
        </c:forEach>
    </div>



<%@ include file="footer.jsp" %>
</body>
</html>