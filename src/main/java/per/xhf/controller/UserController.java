package per.xhf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import per.xhf.model.User;
import per.xhf.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login.html")
	public String login(){
		return "login";
	}
	
/*	@RequestMapping(value="/doLogin.html")
	@ResponseBody
	public Object doLogin(User user){
		Map<String,Object>dataMap = new HashMap<String, Object>();
		User dbUser = userService.findByUserName(user.getUserName());
		if(user.getUserPasswd().equals(dbUser.getUserPasswd())){
			dataMap.put("result", true);
		}else{
			dataMap.put("result", false);
		}
		return dataMap;
	}*/
	
	@RequestMapping(value="/doLogin.html")
	public ModelAndView doLogin(User user,HttpServletRequest request){
		ModelAndView view = null;
		boolean isExist = userService.getMatchCount(user.getUserName(), user.getUserPasswd());
		if(isExist){
			User dbUser = userService.findByUserName(user.getUserName());
			userService.loginSuccess(dbUser.getUserId());
			
			request.getSession().setAttribute("user", dbUser);
			view = new ModelAndView("main");
		}else{
			view = new ModelAndView("login", "error", "用户不存在");
		}
		return view;
	}
}
