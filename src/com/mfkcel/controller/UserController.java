package com.mfkcel.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mfkcel.model.User;
import com.mfkcel.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userSerice;
	
	//这里为什么不使用ModelAndView 或者说Model
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request) {
		User resultUser = userSerice.login(user);
		if(resultUser.getId() == null) {
			request.setAttribute("user", user);
			request.setAttribute("erroMsg", "用户名或密码错误");
			return "login";
		}
		else{
			HttpSession session=request.getSession();
			session.setAttribute("currentUser", resultUser);
			// return "forward:/hello" => 转发到能够匹配 /hello 的 controller 上  
		    // return "hello" => 实际上还是转发，只不过是框架会找到该逻辑视图名对应的 View 并渲染  
		    // return "/hello" => 同 return "hello"  
			//springmvc 重定向 redirect
			//springmvc forward 请求转发
			//ModelAndView的用法有疑问
			return "redirect:/main.jsp";
		}
	}
}
