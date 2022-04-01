package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.PaginatesDto;
import DiamonShop.Service.User.CategoryServiceImpl;
import DiamonShop.Service.User.PaginateServiceImpl;

@Controller
public class CategoryController extends BaseController{
	
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private PaginateServiceImpl paginateService;

	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Product(@PathVariable String id) {
		int totalProductsPage = 9;
		
		_mvShare.setViewName("user/products/category");
		int totalData = categoryService.GetAllProductsById(Integer.parseInt(id)).size();
		PaginatesDto paginatesDto = paginateService.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvShare.addObject("paginateInfo",paginatesDto);
		_mvShare.addObject("categoryId",id);
		_mvShare.addObject("productsPaginate",categoryService.GetDataProductsPaginates(Integer.parseInt(id),paginatesDto.getStart(), totalProductsPage));
		return _mvShare;
	}
	
	@RequestMapping(value = "/san-pham/{id}/{currentPage}")
	public ModelAndView Product(@PathVariable String id,@PathVariable String currentPage) {
		int totalProductsPage = 9;
		_mvShare.setViewName("user/products/category");
		int totalData = categoryService.GetAllProductsById(Integer.parseInt(id)).size();
		PaginatesDto paginatesDto = paginateService.GetInfoPaginates(totalData, totalProductsPage,
				Integer.parseInt(currentPage));
		
		_mvShare.addObject("paginateInfo",paginatesDto);
		_mvShare.addObject("categoryId",id);
		_mvShare.addObject("productsPaginate",categoryService.GetDataProductsPaginates(Integer.parseInt(id),paginatesDto.getStart(), totalProductsPage));
		
		System.out.println(paginatesDto);
		
		return _mvShare;
	}
}
