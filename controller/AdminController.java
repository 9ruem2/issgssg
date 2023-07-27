package com.issg2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.issg2.service.AdminService;
import com.issg2.util.CommandMap;
import com.issg2.util.Util;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@RequestMapping(path="/admin")
@Controller
public class AdminController {
 
	//serviceImpl, service(Inteface), DAO(exdends AbstraceDAO), Mapper
	@Resource(name="adminService")
	private AdminService adminService;
	
	@Autowired
	private ServletContext context;
	
	
	
	
	
	//관리자 로그인 페이지
		@GetMapping("/login") 
		public String login(HttpSession session) {
			if(session.getAttribute("admin") != null) {			
				return "redirect:/admin/admin";
			}else {
				return "/admin/login";
			}
		}
		
		@PostMapping("/login")
		public String login(CommandMap map, HttpSession session) {
			System.out.println(map.getMap());
				if(map.containsKey("id") && map.containsKey("pw")) {
					Map<String, Object> result =  adminService.login(map.getMap());
					if(Util.str2Int(result.get("count")) == 1) {
						session.setAttribute("admin", result.get("m_grade"));
						session.setAttribute("name", result.get("m_name"));
						//System.out.println(result);
						return "redirect:/admin/admin";
					} else {
						return "redirect:/admin/login";
					}
				}
				return "redirect:/admin/admin";
		}
		
		
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			if(session.getAttribute("admin") != null) {
				session.removeAttribute("admin");
			}
			if(session.getAttribute("mname") != null) {
				session.removeAttribute("mname");
			}
			session.invalidate();
			return "redirect:/admin/login";
		}
		
		@GetMapping("/admin") 
		public String admin(HttpSession session) {
			if(session.getAttribute("admin") != null) {			
				return "/admin/admin";
			} else {
				return "redirect:/admin/login";
			}
		}
		
		//setupBoard.do
		@GetMapping("/setupBoard")
		public ModelAndView setupBoard(CommandMap map, HttpSession session) {
			ModelAndView mv = new ModelAndView("redirect:/admin/login");
			if(session.getAttribute("admin") != null) {
				mv.setViewName("/admin/setupBoard");
				
				if(!map.containsKey("pageNo")) {map.put("pageNo", 1);}
				
				PaginationInfo paginationInfo = adminService.setupBoardPaginationInfo(map.getMap());
				map.put("startPage", paginationInfo.getFirstRecordIndex());
				map.put("lastPage", paginationInfo.getRecordCountPerPage());

				List<Map<String,Object>> setupBoardList = adminService.setupBoardList(map.getMap());

				mv.addObject("list", setupBoardList);			
				mv.addObject("paginationInfo", paginationInfo);
				mv.addObject("pageNo", map.get("pageNo"));
			}
			return mv;
		}
		
		@PostMapping("/setupBoard")
		public String setupBoardInsert(CommandMap map, HttpSession session) {
			String url = "redirect:/login";
			System.out.println(map.getMap());
			if(session.getAttribute("admin") != null) {
				int result = adminService.setupBoardInsert(map.getMap());
				System.out.println("입력 결과 : " + result);
				url = "redirect:/setupBoard";	
			}
			return url;
		}
		
		  
	      //게시글 관리
	      @GetMapping("/board")
	      public ModelAndView board(CommandMap map, HttpSession session) {
	         ModelAndView mv = new ModelAndView("redirect:/admin/login");
	         if (session.getAttribute("admin") != null) {
	            mv.setViewName("/admin/board");
	            if (!map.containsKey("pageNo")) {
	               map.put("pageNo", 1);
	            }

	            PaginationInfo paginationInfo = adminService.boardPaginationInfo(map.getMap());
	            
	            // 계산
	            map.put("startPage", paginationInfo.getFirstRecordIndex());
	            map.put("lastPage", paginationInfo.getRecordCountPerPage());

	            List<Map<String, Object>> boardList = adminService.boardList(map.getMap());
	            mv.addObject("boardList", boardList);
	            mv.addObject("pageNo", Util.str2Int(map.get("pageNo")));
	            mv.addObject("paginationInfo", paginationInfo);
	         }
	         return mv;
	      }
		

		@GetMapping("/boardDetail")
		public ModelAndView boardDetail(CommandMap map) {
			ModelAndView mv = new ModelAndView("admin/boardDetail");
			System.out.println(map.getMap());
			Map<String, Object> boardDetail = adminService.boardDetail(map.getMap());
			System.out.println(boardDetail);
			mv.addObject("boardDetail", boardDetail);
			return mv;
		}
		
		
		
		@PostMapping("/board")
		public String boardInsert(CommandMap map, HttpSession session) {
			if (session.getAttribute("admin") != null) {
				adminService.boardInsert(map.getMap());
				return "redirect:/admin/board";
			}else {
				return "redirect:/admin/login";
			}
		}
		
		
		
		@GetMapping("/boardWrite")
		public String boardWrite() {
				
			return "admin/boardWrite";
				
		}
		
		@PostMapping("/boardWrite")
		public String boardWrite(HttpServletRequest request, MultipartFile file) throws Exception{

			HttpSession session = request.getSession();
			
				//System.out.println(request.getParameter("title"));
				//System.out.println(request.getParameter("content"));
				
				//System.out.println(file.getOriginalFilename());//2853114.png
				//System.out.println(file.getSize());//17423
				//System.out.println(file.getContentType());//image/png
				//경로 설정하기
				String realPath = context.getRealPath("resources/");
				System.out.println("실제 저장 경로" + realPath);
				//C:\workspace-spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\nov25_bootstrap\resources\
				String upFile = Util.fileSave(realPath, file);
				//System.out.println("저장된 파일명 : " + upFile);
				
				//썸네일 만들기   fe83fewf.png = 파일명과 동일하게 만들었습니다.
				String thumbFile = Util.makeThumbnail(realPath, upFile);
				//System.out.println("썸네일 파일명 : " + thumbFile);
				
				//데이터 베이스에 저장하기 title, content, upFile, id
				
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("title", request.getParameter("title"));
				map.put("content", request.getParameter("content"));
				map.put("id", session.getAttribute("id"));
				map.put("upFile", upFile);
				map.put("thumbFile", thumbFile);
				
				adminService.write(map);
				return "redirect:/admin/board";
			
		}
		
		//boardDelete
		@GetMapping("/boardDelete")
		public String boardDelete(CommandMap map) {
				adminService.boardDelete(map.getMap());
				return "redirect:/admin/board?b_no="+map.get("b_no");
		}
		
		
		  //qna 관리
	      @GetMapping("/qna")
	      public ModelAndView qna(CommandMap map, HttpSession session) {
	         ModelAndView mv = new ModelAndView("redirect:/admin/login");
	         if (session.getAttribute("admin") != null) {
	            mv.setViewName("/admin/qna");
	            if (!map.containsKey("pageNo")) {
	               map.put("pageNo", 1);
	            }

	            PaginationInfo paginationInfo = adminService.qnaPaginationInfo(map.getMap());
	            
	            // 계산
	            map.put("startPage", paginationInfo.getFirstRecordIndex());
	            map.put("lastPage", paginationInfo.getRecordCountPerPage());

	            List<Map<String, Object>> qnaList = adminService.qnaList(map.getMap());
	            mv.addObject("qnaList", qnaList);
	            mv.addObject("pageNo", Util.str2Int(map.get("pageNo")));
	            mv.addObject("paginationInfo", paginationInfo);
	         }
	         return mv;
	      }
	      
	      
	  	//notice
			@PostMapping(value="/qnaView",  produces="application/json;charset=UTF-8")
			public @ResponseBody String qnaView(CommandMap map, HttpSession session) {
				System.out.println(map.getMap());
				JSONObject json = new JSONObject();
				
				Map<String,Object> result = adminService.qnaView(map.getMap());
				json.put("result", result);
				
				System.out.println(json.toString());
				return json.toString();
			}
			
			
			
	  	//postDel
			@GetMapping("/qnaPostDel")
			public String qnaPostDel(CommandMap map, HttpSession session) {
				//System.out.println(map.getMap()); {mb_no=191}
				if (map.containsKey("q_no") && session.getAttribute("admin") != null) {
					adminService.qnaPostDel(map.getMap());
				}
				return "redirect:/admin/qna?pageNo="+map.get("pageNo");
			}
			
			
			
			
			  @GetMapping("/qnaComment")
		      public ModelAndView qnaComment(CommandMap map, HttpSession session) {
		         ModelAndView mv = new ModelAndView("redirect:/admin/login");
		         if (session.getAttribute("admin") != null) {
		            mv.setViewName("/admin/qnaComment");
		            if (!map.containsKey("pageNo")) {
		               map.put("pageNo", 1);
		            }

		            PaginationInfo paginationInfo = adminService.qnaCommentPaginationInfo(map.getMap());
		            
		            // 계산
		            map.put("startPage", paginationInfo.getFirstRecordIndex());
		            map.put("lastPage", paginationInfo.getRecordCountPerPage());

		            List<Map<String, Object>> qnaCommentList = adminService.qnaCommentList(map.getMap());
		            mv.addObject("qnaCommentList", qnaCommentList);
		            mv.addObject("pageNo", Util.str2Int(map.get("pageNo")));
		            mv.addObject("paginationInfo", paginationInfo);
		         }
		         return mv;
		      }
			
			//postDel
				@GetMapping("/qnaCommentPostDel")
				public String qnaCommentPostDel(CommandMap map, HttpSession session) {
					//System.out.println(map.getMap()); {mb_no=191}
						adminService.qnaCommentPostDel(map.getMap());
					
					return "redirect:/admin/qnaComment?qc_no="+map.get("qc_no");
				}
				
				
	      
	      
		//회원관리
		@GetMapping("/member")
		public ModelAndView member(CommandMap map, HttpSession session) {
			ModelAndView mv = new ModelAndView("redirect:/admin/login");
			if(session.getAttribute("admin") != null) {
				mv.setViewName("/admin/member");
				int pageNo = 1;
				if(map.containsKey("pageNo") || Util.checkNumber(String.valueOf(map.get("pageNo")))) {
					pageNo = Util.str2Int(String.valueOf(map.get("pageNo")));
				}
				int totalCount = adminService.memberTotalCount(map.getMap());
				
				PaginationInfo paginationInfo = new PaginationInfo();
				paginationInfo.setTotalRecordCount(totalCount);
				paginationInfo.setCurrentPageNo(pageNo);
				paginationInfo.setRecordCountPerPage(10);
				paginationInfo.setPageSize(10);
				
				//계산
				map.put("startPage", paginationInfo.getFirstRecordIndex());
				map.put("lastPage", paginationInfo.getRecordCountPerPage());
				
				List<Map<String,Object>> memberList = adminService.memberList(map.getMap());
				mv.addObject("list", memberList);
				mv.addObject("pageNo", pageNo);
				mv.addObject("paginationInfo", paginationInfo);
			}
			return mv;
		}
		
		//postDel
		@GetMapping("/memberPostDel")
		public String memberPostDel(CommandMap map, HttpSession session) {
			System.out.println(map.getMap());// {mb_no=191}
			if (map.containsKey("m_no") && session.getAttribute("admin") != null) {
				adminService.memberPostDel(map.getMap());
			}
			return "redirect:/admin/member?pageNo="+map.get("pageNo");
		}

		
		// notice 관리자
		@GetMapping("/notice")
		public ModelAndView notice(CommandMap map, HttpSession session) {
			ModelAndView mv = new ModelAndView("redirect:/admin/login");
			if (session.getAttribute("admin") != null) {
				mv.setViewName("/admin/notice");
				if (!map.containsKey("pageNo")) {
					map.put("pageNo", 1);
				}

				PaginationInfo paginationInfo = adminService.noticePaginationInfo(map.getMap());
				
				// 계산
				map.put("startPage", paginationInfo.getFirstRecordIndex());
				map.put("lastPage", paginationInfo.getRecordCountPerPage());

				List<Map<String, Object>> noticeList = adminService.noticeList(map.getMap());
				mv.addObject("list", noticeList);
				mv.addObject("pageNo", Util.str2Int(map.get("pageNo")));
				mv.addObject("paginationInfo", paginationInfo);
			}
			return mv;
		}
		
		@PostMapping("/notice")
		public String noticeInsert(CommandMap map, HttpSession session) {
			if (session.getAttribute("admin") != null) {
				adminService.noticeInsert(map.getMap());
				return "redirect:/admin/notice";
			}else {
				return "redirect:/admin/login";
			}
		}
		
		
		//notice
		@PostMapping(value="/noticeView",  produces="application/json;charset=UTF-8")
		public @ResponseBody String noticeView(CommandMap map, HttpSession session) {
			System.out.println(map.getMap());
			JSONObject json = new JSONObject();
			
			Map<String,Object> result = adminService.noticeView(map.getMap());
			json.put("result", result);
			
			System.out.println(json.toString());
			return json.toString();
		}
		
		//postDel
		@GetMapping("/postDel")
		public String postDel(CommandMap map, HttpSession session) {
			//System.out.println(map.getMap()); {mb_no=191}
			if (map.containsKey("n_no") && session.getAttribute("admin") != null) {
				adminService.postDel(map.getMap());
			}
			return "redirect:/admin/notice?pageNo="+map.get("pageNo");
		}
		
		//gallery 게시글 관리
		 @GetMapping("/gallery")
	      public ModelAndView gallery(CommandMap map, HttpSession session) {
	         ModelAndView mv = new ModelAndView("redirect:/admin/login");
	         if (session.getAttribute("admin") != null) {
	            mv.setViewName("/admin/gallery");
	            if (!map.containsKey("pageNo")) {
	               map.put("pageNo", 1);
	            }

	            PaginationInfo paginationInfo = adminService.galleryPaginationInfo(map.getMap());
	            
	            // 계산
	            map.put("startPage", paginationInfo.getFirstRecordIndex());
	            map.put("lastPage", paginationInfo.getRecordCountPerPage());

	            List<Map<String, Object>> galleryList = adminService.galleryList(map.getMap());
	            mv.addObject("galleryList", galleryList);
	            mv.addObject("pageNo", Util.str2Int(map.get("pageNo")));
	            mv.addObject("paginationInfo", paginationInfo);
	         }
	         return mv;
	      }
	      
		 @GetMapping("/galleryDetail")
			public ModelAndView galleryDetail(CommandMap map) {
				ModelAndView mv = new ModelAndView("admin/galleryDetail");
				System.out.println(map.getMap());
				Map<String, Object> galleryDetail = adminService.galleryDetail(map.getMap());	
				galleryDetail.put("pageNo", map.get("pageNo"));
				System.out.println(galleryDetail);
				//댓글도 출력하기
				if (Util.str2Int(galleryDetail.get("galleryCommentCount")) > 0) {
					//System.out.println("댓글이 있어요. " + galleryDetail.get("galleryCommentCount"));
					List<Map<String, Object>> galleryComments = adminService.galleryCommentsList(map.getMap());			
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
	      
	    //galleryCommentDelete
	  	@GetMapping("/galleryCommentDelete")
	  	public String galleryCommentDelete(CommandMap map, HttpSession session) {
	  		if(session.getAttribute("id") != null) {
	  			map.put("id", session.getAttribute("id"));
	  			adminService.galleryCommentDelete(map.getMap());
	  			return "redirect:/admin/galleryDetail?g_no="+map.get("g_no")+"&pageNo="+map.get("pageNo");
	  		}else {
	  			return "redirect/login";
	  		}
	  	}
	  	
	  //boardDelete
		@GetMapping("/galleryDelete")
		public String galleryDelete(CommandMap map) {
			adminService.galleryDelete(map.getMap());
			return "redirect:/admin/gallery?g_no="+map.get("g_no");
		}

			

}