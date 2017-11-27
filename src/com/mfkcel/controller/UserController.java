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
	
	//����Ϊʲô��ʹ��ModelAndView ����˵Model
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request) {
		User resultUser = userSerice.login(user);
		if(resultUser.getId() == null) {
			request.setAttribute("user", user);
			request.setAttribute("erroMsg", "�û������������");
			return "login";
		}
		else{
			HttpSession session=request.getSession();
			session.setAttribute("currentUser", resultUser);
			// return "forward:/hello" => ת�����ܹ�ƥ�� /hello �� controller ��  
		    // return "hello" => ʵ���ϻ���ת����ֻ�����ǿ�ܻ��ҵ����߼���ͼ����Ӧ�� View ����Ⱦ  
		    // return "/hello" => ͬ return "hello"  
			//springmvc �ض��� redirect
			//springmvc forward ����ת��
			//ModelAndView���÷�������
			return "redirect:/main.jsp";
		}
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request) {
		request.setAttribute("mainPage", "./jsp/user/list.jsp");
		request.setAttribute("users", userSerice.getUsers());
		return "main";
	}
	
	@RequestMapping("/save")
	public String add(HttpServletRequest request, User user) {
		if(user.getId() != null)
			userSerice.update(user);
		else {
			userSerice.add(user);
		}
		return "forward:/user/list.do";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		userSerice.deleteById(request.getParameter("id"));
		return "forward:/user/list.do";
	}
	
	@RequestMapping("/pre")
	public String pre(HttpServletRequest request) {
		String id = request.getParameter("id");
		if(id != null) {
			request.setAttribute("user", userSerice.getUserById(id));
		}
		request.setAttribute("mainPage", "./jsp/user/pre.jsp");
		return "main";
	}
}
