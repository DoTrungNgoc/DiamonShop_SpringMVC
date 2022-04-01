package DiamonShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;

@Service
public interface ICategoryService {
	public List<ProductsDto> GetDataProductsPaginates(int id,int start, int totalPage);
	public List<ProductsDto> GetAllProductsById(int id);
}
