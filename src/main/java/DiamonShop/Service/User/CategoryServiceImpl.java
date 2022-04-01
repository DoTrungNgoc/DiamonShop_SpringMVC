package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private ProductsDao productsDao;

	public List<ProductsDto> GetDataProductsPaginates(int id,int start, int totalPage) {
		return productsDao.GeDataProductsPaginates(id,start, totalPage);
	}

	public List<ProductsDto> GetAllProductsById(int id) {
		return productsDao.GeAllProductsById(id);
	}

}
