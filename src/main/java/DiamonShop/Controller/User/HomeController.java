package DiamonShop.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{
	
	@RequestMapping(value = {"/","trang-chu"})
	public ModelAndView Index() {
		_mvShare.addObject("slides",_homeService.GetDataSlide());
		_mvShare.addObject("categories",_homeService.GetDataCategories());
		_mvShare.addObject("new_products",_homeService.GetDataNewProducts());
		_mvShare.addObject("highlight_products",_homeService.GetDataHighlightProducts());
		
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
	
}
