package com.issg2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.issg2.service.GalleryService;
import com.issg2.util.CommandMap;
import com.issg2.util.Util;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class GalleryController {

	// service(Interface), serviceImpl, DAO(extends AbstraceDAO), Mapper
	@Resource(name = "galleryService")
	private GalleryService galleryService;

	@Autowired
	private ServletContext context;
	

	// gallery
	@GetMapping("/gallery")
	public ModelAndView galleryList(CommandMap map) {		
		int pageNo = 1;
		if(map.containsKey("pageNo")
				|| Util.checkNumber(String.valueOf(map.get("pageNo")))) {
			pageNo = Util.str2Int(String.valueOf(map.get("pageNo")));
		}
		
		//전체 글수를 가져와 주세요
		int galleryTotalCount = galleryService.galleryTotalCount(map.getMap());
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalRecordCount(galleryTotalCount);
		paginationInfo.setCurrentPageNo(pageNo);
		paginationInfo.setRecordCountPerPage(16);
		paginationInfo.setPageSize(10);
		//계산
		map.put("startPage", paginationInfo.getFirstRecordIndex());
		map.put("lastPage", paginationInfo.getRecordCountPerPage());
		
		
		ModelAndView mv = new ModelAndView("gallery");
		List<Map<String, Object>> galleryList = galleryService.galleryList(map.getMap());
		mv.addObject("galleryList", galleryList);
		mv.addObject("pageNo", pageNo);
		mv.addObject("paginationInfo", paginationInfo);
		return mv;
	}

	@GetMapping("/galleryWrite")
	public String galleryWrite(HttpSession session) {
		if (session.getAttribute("id") != null) {
			return "galleryWrite";
		} else {
			return "redirect:/login";
		}
	}
		
	@PostMapping("/galleryWrite")
	public String galleryWrite(HttpServletRequest request, MultipartFile file) throws Exception{
		//System.out.println("dfdfdfd");
		HttpSession session = request.getSession();
		if(session.getAttribute("id") != null 
				&& request.getParameter("title") != null 
				&& request.getParameter("content") != null) {
			
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getSize());//17423
			System.out.println(file.getContentType());//image/png
			//경로 설정하기
			String realPath = context.getRealPath("resources/");
			System.out.println("실제 저장 경로" + realPath);
			//C:\workspace-spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\nov25_bootstrap\resources\
			String upFile = Util.fileSave(realPath, file);
			System.out.println("저장된 파일명 : " + upFile);
			
			//썸네일 만들기   fe83fewf.png = 파일명과 동일하게 만들었습니다.
			String thumbFile = Util.makeThumbnail(realPath, upFile);
			System.out.println("썸네일 파일명 : " + thumbFile);
			
			//데이터 베이스에 저장하기 title, content, upFile, id
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("title", request.getParameter("title"));
			map.put("content", request.getParameter("content"));
			map.put("id", session.getAttribute("id"));
			map.put("upFile", upFile);
			map.put("thumbFile", thumbFile);
			
			galleryService.galleryWrite(map);
			return "redirect:/gallery";
		} else {
			return "redirect:/login";
		}
	}
	
	//galleryDetail
	@GetMapping("/galleryDetail")
	public ModelAndView galleryDetail(CommandMap map) {
		ModelAndView mv = new ModelAndView("galleryDetail");
		galleryService.galleryCount(map.getMap());
		//System.out.println(map.getMap());
		Map<String, Object> galleryDetail = galleryService.galleryDetail(map.getMap());	
		galleryDetail.put("pageNo", map.get("pageNo"));
		System.out.println(galleryDetail);
		//댓글도 출력하기
		if (Util.str2Int(galleryDetail.get("galleryCommentCount")) > 0) {
			//System.out.println("댓글이 있어요. " + galleryDetail.get("galleryCommentCount"));
			List<Map<String, Object>> galleryComments = galleryService.galleryCommentsList(map.getMap());			
			//System.out.println(galleryComments);
			List<Map<String, Object>> comments = new ArrayList<Map<String, Object>>();
			mv.addObject("galleryComments", galleryComments);
			//System.out.println("comments"+comments);
			mv.addObject("comments", comments);
		}
		
		mv.addObject("pageNo", map.get("pageNo"));
		mv.addObject("galleryDetail", galleryDetail);
		return mv;
	}

	//galleryDelete
	@GetMapping("/galleryDelete")
	public String galleryDelete(CommandMap map, HttpSession session) {
		if(session.getAttribute("id") != null) {
			map.put("id", session.getAttribute("id"));
			galleryService.galleryDelete(map.getMap());
			return "redirect:/gallery";
		}else {
			return "redirect/login";
		}
	}
	
	//galleryUpdate
	@GetMapping("/galleryUpdate")
	public ModelAndView galleryUpdate(CommandMap map, HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:/login");			
		if(session.getAttribute("id") != null) {
			map.put("id", session.getAttribute("id"));
			Map<String, Object> galleryUpdate = galleryService.galleryDetail(map.getMap());
			//System.out.println("내꺼> : " + update);
			mv.setViewName("galleryUpdate");
			mv.addObject("galleryUpdate", galleryUpdate);
		}
		return mv;
	}
	
	@PostMapping("/galleryUpdate")
	public String galleryUpdate1(CommandMap map, HttpSession session, 
			HttpServletRequest request, MultipartFile file ) throws Exception{
		if(session.getAttribute("id") != null 
				&& request.getParameter("title") != null 
				&& request.getParameter("content") != null) {			

			//System.out.println(file);//image/png
			//System.out.println(file.getOriginalFilename());
			//System.out.println(file.getSize());//17423
			//System.out.println(file.getContentType());//image/png
			
			if(file != null) {
				//경로 설정하기
				String realPath = context.getRealPath("resources/");
				System.out.println("실제 저장 경로" + realPath);
				//C:\workspace-spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\nov25_bootstrap\resources\
				String upFile = Util.fileSave(realPath, file);
				System.out.println("저장된 파일명 : " + upFile);
				
				//썸네일 만들기   fe83fewf.png = 파일명과 동일하게 만들었습니다.
				String thumbFile = Util.makeThumbnail(realPath, upFile);
				System.out.println("썸네일 파일명 : " + thumbFile);		
				map.put("upFile", upFile);
				map.put("thumbFile", thumbFile);
			}
			
			//데이터 베이스에 저장하기 title, content, upFile, id
			map.put("title", request.getParameter("title"));
			map.put("content", request.getParameter("content"));
			map.put("id", session.getAttribute("id"));
			

			galleryService.galleryUpdate1(map.getMap());
			return "redirect:/galleryDetail?g_no="+map.get("g_no")+"&pageNo="+map.get("pageNo");
		}else {
			return "redirect:/login";
		}
		
	}
		
	//galleryPicDel
	@ResponseBody
	@PostMapping("/galleryPicDel")
	public String galleryPicDel(CommandMap map, HttpSession session) {
		if(session.getAttribute("id") != null) {			
			//System.out.println("map.get : " + map.getMap());{g_no=23}
			String realPath = context.getRealPath("resources/");
			map.put("realPath", realPath);//실제 경로가 있어야 파일이 삭제됩니다.
			map.put("id", session.getAttribute("id"));
			int result = galleryService.galleryPicDel(map.getMap());//파일을 삭제합니다.
			return String.valueOf(result);
		}else {
			return "0";
		}
	}
	
	//좋아요 - 수정필요 : 한 글에 한 번만 누를 수 있도록 테이블을 만들어야 함.
	@GetMapping("/galleryLike")
	public String galleryLike(CommandMap map) {
		System.out.println("/galleryLike"+map.getMap());
		galleryService.galleryLike(map.getMap());
		String url = "redirect:/galleryDetail?g_no="+map.get("g_no")+"&pageNo="+map.get("pageNo");
		return url;
	}
	
	//galleryCommentInsert
	@PostMapping("/galleryCommentInsert")
	public String galleryCommentInsert(CommandMap map, HttpSession session) {
		//System.out.println("commentInsert : "+map.getMap());
		if(session.getAttribute("id") != null) {
			map.put("id", session.getAttribute("id"));
			//저장하기
			//엔터키 처리
			map.put("gcComment", Util.removeSC((String)map.get("gcComment")));
			map.put("gcComment", Util.addBR((String)map.get("gcComment")));
			galleryService.galleryCommentInsert(map.getMap());
			
			String url = "redirect:/galleryDetail?g_no="+map.get("g_no")+"&pageNo="+map.get("pageNo");
			return url;
		}else {
			return "redirect:/login";
		}

	}
	
//	//대댓글 commentInsert2
//	@PostMapping("/galleryCommentInsert2")
//	public String galleryCommentInsert2(CommandMap map, HttpSession session) {
//		System.out.println("kkkkkkkk"+map.getMap());
//		//{c_no=27, mb_no=186, pageNo=1, comment=ㅁㅈㄻㅈㄷㄹ ㄹㄷㅈㄻㄷㄹ ㅁㄹㄷㅁ}
//		if(session.getAttribute("id") != null) {
//			map.put("id", session.getAttribute("id"));
//			//특수문자, 엔터키 처리
//			map.put("gcComment", Util.removeSC((String)map.get("gcComment")));
//			map.put("gcComment", Util.addBR((String)map.get("gcComment")));
//			galleryService.galleryCommentInsert2(map.getMap());
//			return "redirect:galleryDetail?g_no="+map.get("g_no")+"&pageNo="+map.get("pageNo");
//		} else {
//			return "redirect:/login";
//		}
//	}

	//galleryDelete
	@GetMapping("/galleryCommentDelete")
	public String galleryCommentDelete(CommandMap map, HttpSession session) {
		if(session.getAttribute("id") != null) {
			map.put("id", session.getAttribute("id"));
			galleryService.galleryCommentDelete(map.getMap());
			return "redirect:/galleryDetail?g_no="+map.get("g_no")+"&pageNo="+map.get("pageNo");
		}else {
			return "redirect/login";
		}
	}

}
