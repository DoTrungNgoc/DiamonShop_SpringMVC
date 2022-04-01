package DiamonShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.CartDto;
import DiamonShop.Entity.Bills;
import DiamonShop.Entity.Users;
import DiamonShop.Service.User.BillServiceimpl;
import DiamonShop.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController{
	@Autowired
	private CartServiceImpl cartService;
	
	@Autowired
	private BillServiceimpl billService;
	
	@RequestMapping(value = "gio-hang")
	public ModelAndView Index() {
		_mvShare.addObject("slides",_homeService.GetDataSlide());
		_mvShare.addObject("categories",_homeService.GetDataCategories());
		_mvShare.addObject("new_products",_homeService.GetDataNewProducts());
		_mvShare.addObject("highlight_products",_homeService.GetDataHighlightProducts());
		
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}
	
	@RequestMapping(value = "AddCart/{id}")
	public String AddCart(HttpServletRequest request,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("cart");
		if (cart == null) {
			cart = new  HashMap<Long, CartDto>();
		}
		cart = cartService.AddCart(id, cart);
		cart.entrySet().forEach(e->{
			System.out.println(e.getKey() + " : " + e.getValue().getQuantity());
		});
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantityCart", cartService.ToatalQuantity(cart));
		session.setAttribute("totalPriceCart", cartService.ToatalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "EditCart/{id}/{quantity}")
	public String EditCart(HttpServletRequest request,HttpSession session, @PathVariable long id,@PathVariable int quantity) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("cart");
		if (cart == null) {
			cart = new  HashMap<Long, CartDto>();
		}
		cart = cartService.EditCart(id, quantity,cart);
		
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantityCart", cartService.ToatalQuantity(cart));
		session.setAttribute("totalPriceCart", cartService.ToatalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("cart");
		if (cart == null) {
			cart = new  HashMap<Long, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantityCart", cartService.ToatalQuantity(cart));
		session.setAttribute("totalPriceCart", cartService.ToatalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "checkout")
	public ModelAndView CheckOut(HttpServletRequest request,HttpSession session) {
		_mvShare.setViewName("user/bills/checkout");
		Bills bill =  new Bills();
		Users loginInfo = (Users) session.getAttribute("LoginInfo");
		if (loginInfo!=null) {
			bill.setDisplay_name(loginInfo.getDisplay_name());
			bill.setAddress(loginInfo.getAddress());
			bill.setUser(loginInfo.getUser());
		}
		_mvShare.addObject("bills", bill);
		return _mvShare;
	}
	
	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String CheckOutBill(HttpServletRequest request,HttpSession session,@ModelAttribute Bills bill) {
		bill.setQuantity(Integer.parseInt(session.getAttribute("totalQuantityCart").toString()));
		bill.setTotal(Double.parseDouble(session.getAttribute("totalPriceCart").toString()));
		if (billService.AddBills(bill)>0) {
			HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("cart");
			billService.AddBillDetail(cart);
		}
		session.removeAttribute("cart");
		return "redirect:gio-hang";
	}
}
