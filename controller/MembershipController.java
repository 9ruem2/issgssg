package com.issg2.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.issg2.service.MembershipService;
import com.issg2.util.CommandMap;


@Controller
public class MembershipController {

	//serviceImpl, service(Inteface), DAO(exdends AbstraceDAO), Mapper
	@Resource(name="membershipService")
	private MembershipService membershipService;
	
	@GetMapping("/membership")//이렇게 변경했습니다.
	public String membership() {
		return "membership";
	}
	
	@PostMapping("/idCheck")
	@ResponseBody 
	public String idCheck(@RequestParam("id") String id) {
		int result = membershipService.idCheck(id);
		
		JSONObject json = new JSONObject();
		json.put("result", result); //  {result : 1}
		
		return json.toString();
	}
	
	
	@PostMapping("/nickCheck")
	@ResponseBody 
	public String nickCheck(@RequestParam("nick") String nick) {
		int result = membershipService.nickCheck(nick);
		
		JSONObject json1 = new JSONObject();
		json1.put("result", result); //  {result : 1}
		
		return json1.toString();
	}
	
	
	@PostMapping("/membership")
	public String membership(CommandMap map) {
		
		
		membershipService.membership(map.getMap());
		
		return "redirect:/?msg=ok";//정상 가입이 되었다면
		
		
	}
	
	
}
