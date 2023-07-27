package com.issg2.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.issg2.service.LoginService;
import com.issg2.util.CommandMap;
import com.issg2.util.Util;

@Controller
public class LoginController {

	// service(Interface), serviceImpl, DAO(extends AbstraceDAO), Mapper
	@Resource(name = "loginService")
	private LoginService loginService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(CommandMap map, HttpSession session) {
			//System.out.println(map.getMap());//map을 꺼내야 합니다.
		Map<String, Object> result = loginService.login(map.getMap());
			//System.out.println(result);

		if (String.valueOf(result.get("count")).equals("1")) {
			// 정상 로그인
			// 세션
			session.setAttribute("id", map.get("id"));
			session.setAttribute("name", result.get("m_name"));
			//System.out.println(result);

			// home으로 이동
			return "redirect:/"; // home은 따로 작성 하지 않아도 됨
		} else {
			return "redirect:/login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("id") != null) {
			session.removeAttribute("id");
		}
		if (session.getAttribute("name") != null) {
			session.removeAttribute("name");
		}

		session.invalidate();// 삭제!!!!
		return "redirect:/";
	}	
	
	//mypage
	@GetMapping("/mypage")
	public String mypage(HttpSession session) {
		if(session.getAttribute("id") != null) {
			//System.out.println("id : " + id);
			//System.out.println("세션 : " + session.getAttribute("id"));
			return "mypage";			
		}else{
			return "redirect:/login";
		}
	}
	
	@PostMapping("/mypage")
	public ModelAndView mypage(CommandMap map, HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:/login");
		if(session.getAttribute("id") != null) {
			//System.out.println(map.getMap());//{pw=asdfasdfasdf}
			//암호 있는지, 로그인 했는지 
			mv.setViewName("mypage");//
			map.put("id", session.getAttribute("id"));
			Map<String, Object> result = loginService.mypage(map.getMap());
			//System.out.println(result);
			mv.addObject("result", result);
		}
		return mv;
	}

	@PostMapping("/mypageUpdate")
	public String mypageUpdate(CommandMap map, HttpSession session) {
		System.out.println(map.getMap());
		if(session.getAttribute("id") != null) {
			loginService.mypageUpdate(map.getMap());
		}
		return "mypageDetail";
	}
	
	
	@PostMapping("/nickCheck1")
	@ResponseBody 
	public String nickCheck1(@RequestParam("nick") String nick) {
		int result = loginService.nickCheck1(nick);
		
		JSONObject json1 = new JSONObject();
		json1.put("result", result); //  {result : 1}
		
		return json1.toString();
	}

	@GetMapping("/memberDel")
	public String memberDel1(CommandMap map, HttpSession session) {
		System.out.println(map.getMap());
		if(session.getAttribute("id") != null) {
			map.put("id", session.getAttribute("id"));
			loginService.memberDel1(map.getMap());
			return "redirect:/logout";			
		}else{
			return "redirect:/login";
		}
	}
	



	
	
	


}
