package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Service.User.ProductServiceImpl;

@Controller
public class ProductController extends BaseController{

	@Autowired
	private ProductServiceImpl productService;
	
	@RequestMapping(value = "chi-tiet-san-pham/{id}")
	public ModelAndView Product(@PathVariable long id) {
		ProductsDto product = productService.GetProductById(id);
		_mvShare.addObject("product", product);
		_mvShare.addObject("productsByIdCategory", productService.GetProductsByIdCategory(product.getId_category()));
		_mvShare.setViewName("user/products/product");
		return _mvShare;
	}
}
