package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.Categories;
import DiamonShop.Entity.MapperCategories;

@Repository
public class CategoriesDao extends BaseDao{ 
	
	public List<Categories> GetDataCategories(){
		String sql="SELECT * FROM categories";
		List<Categories> list = new ArrayList<Categories>();
		list = _jdbcTemplate.query(sql,new MapperCategories());
		return list;
	}
}
