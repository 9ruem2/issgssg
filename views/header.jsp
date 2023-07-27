<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
.log_wrap {
    position: absolute;
    top: 25px;
    right: 0;
    display: flex;
    flex-wrap: wrap;
}

.log_wrap li {
    padding:0 10px;
    height: 20px;
    text-align: center;
    font-size: 16px;
    line-height: 20px;
    
}

#logout li span {
    font-weight:bold;
    font-size:15px;
}
</style>
	<!-- //////// header //////// -->
	<div id="gnb_bg">
		<header class="inner">
			<h1>
				<a href="/web"><img src="images/logo.png" alt="logo"></a>
			</h1>
			<nav>
				<ul id="gnb">
					<li><a href="./report">아이쓱쓱소개</a></li>
					<li><a href="./gallery">갤러리</a></li>
					<li><a href="./art">전시회안내</a></li>
					<li><a href="./notice">커뮤니티</a></li>
					<li><a href="./shop">쇼핑몰가기</a></li>
 
				</ul>
				<div id="close">
					<a href="#"><i class="fa-solid fa-xmark"></i></a>
				</div> 
			</nav>
			<div id="ham">
				<a href="#"><i class="fa-solid fa-bars"></i></a>
			</div>
			
			<ul id="login" class="log_wrap">
				<c:choose>
					<c:when test="${sessionScope.id eq null }">
						<li><a href="./login">로그인</a></li>
						<li><a href="./membership">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li class="dropdown"><a href="#"><span>${sessionScope.id }님</span></a></li>
						<c:if test="${m_grade eq '9' }">
						<li><a href="./admin/admin" target="_blank">관리자모드</a></li>
						</c:if>
						<ul>
							<li><a href="./mypage">마이페이지</a></li>
						</ul>
						<li><a href="./logout">로그아웃</a></li>
					</c:otherwise>
				</c:choose>
			
			</ul>
		</header>
	</div>

	<div class="slide_wrap">
		<div>
			<a href="#"><img src="images/slide4.jpg" alt="slide1"></a>
		</div>
		<div>
			<a href="#"><img src="images/slide2.jpg" alt="slide2"></a>
		</div>
		<div>
			<a href="#"><img src="images/slide3.jpg" alt="slide3"></a>
		</div>
		<div>
			<a href="#"><img src="images/slide1.png" alt="slide4"></a>
		</div>
	</div>
	<!-- //////// header //////// -->

</body>
</html>