package DiamonShop.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Entity.Users;
import DiamonShop.Service.User.UserServiceImpl;

@Controller
public class UserController extends BaseController {
	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "dang-ky", method = RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}

	@RequestMapping(value = "dang-ky", method = RequestMethod.POST)
	public ModelAndView CreateAccount(@ModelAttribute("user") Users users) {
		if (userService.AddAccount(users)) {
			_mvShare.addObject("status", "Đăng ký tài khoản thành công!");
		} else {
			_mvShare.addObject("status", "Đăng ký tài khoản thất bại!");
		}

		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}

	@RequestMapping(value = "dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute("user") Users users) {
		users = userService.CheckUser(users);
		if (users != null) {
			session.setAttribute("LoginInfo", users);
			_mvShare.setViewName("redirect:trang-chu");
		} else {
			_mvShare.addObject("status", "Đăng nhập thất bại!");
			_mvShare.setViewName("user/account/register");
		}
		return _mvShare;
	}

	@RequestMapping(value = "dang-xuat")
	public String Logout(HttpSession session, HttpServletRequest request) {

		session.removeAttribute("LoginInfo");

		return "redirect:"+request.getHeader("Referer");
	}
}
