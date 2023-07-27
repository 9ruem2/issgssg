<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div class="menu">
			<!-- <div class="logo">logo</div> -->
			<div class="menu-item" onclick="url('admin')"><i class="xi-home-o xi-2x"></i> 홈</div>
			<div class="menu-item" onclick="url('board')"><i class="xi-paper-o xi-2x"></i> 게시글 관리</div>
			<div class="menu-item" onclick="url('member')"><i class="xi-user-o xi-2x"></i> 회원 관리</div>
			<div class="menu-item" onclick="url('qnaComment')"><i class="xi-comment-o xi-2x"></i> Q&A 댓글 관리</div>
			<div class="menu-item" onclick="url('galleryComment')"><i class="xi-comment-o xi-2x"></i> 갤러리 댓글 관리</div>
			<div class="menu-item" onclick="url('qna')"><i class="xi-message-o xi-2x"></i> Q&A</div>
			<div class="menu-item" onclick="url('notice')"><i class="xi-bell-o xi-2x"></i> 공지사항 관리</div>
			<c:if test="${sessionScope.admin ne null }"><div class="menu-item" onclick="url('logout')"><i class="xi-flag-o  xi-2x"></i> ${sessionScope.mname } 로그아웃</div></c:if>
			<div class="menu-item" onclick="url('system')" style="position: absolute; bottom: 0;"><i class="xi-info-o xi-2x"></i> 시스템 정보</div>
		</div>
<script>function url(link){location.href='./'+link;}</script>