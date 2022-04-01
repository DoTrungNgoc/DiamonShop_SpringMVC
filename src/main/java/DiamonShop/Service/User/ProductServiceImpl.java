package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private ProductsDao productsDao;
	
	public ProductsDto GetProductById(long id) {
		// TODO Auto-generated method stub
		return productsDao.GetProductById(id);
	}

	public List<ProductsDto> GetProductsByIdCategory(int id) {
		// TODO Auto-generated method stub
		return productsDao.GeAllProductsById(id);
	}

}
