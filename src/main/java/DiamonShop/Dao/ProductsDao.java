package DiamonShop.Dao;

import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {

	private final boolean YES = true;
	private final boolean NO = false;

	private StringBuffer sqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("    p.id as id_product, ");
		sql.append("    p.id_category, ");
		sql.append("    p.sizes, ");
		sql.append("    p.name, ");
		sql.append("    p.price, ");
		sql.append("    p.sale, ");
		sql.append("    p.title, ");
		sql.append("    p.highlight, ");
		sql.append("    p.new_product, ");
		sql.append("    p.details, ");
		sql.append("    c.id AS id_color, ");
		sql.append("    c.name AS name_color, ");
		sql.append("    c.code AS code_color, ");
		sql.append("    c.img, ");
		sql.append("    p.created_at, ");
		sql.append("    p.updated_at ");
		sql.append("FROM ");
		sql.append("products AS p ");
		sql.append("INNER JOIN ");
		sql.append("colors AS c ");
		sql.append("ON p.id = c.id_product ");

		return sql;
	}
	
	private StringBuffer SqlProductsById(int id) {
		StringBuffer sql = sqlString();
		sql.append("WHERE id_category = " + id + " ");

		return sql;
	}

	private String SqlProduct(boolean newProduct, boolean highlight) {
		StringBuffer sql = sqlString();
		if (highlight) {
			sql.append("WHERE p.highlight = true ");
		}
		if (newProduct) {
			sql.append("AND p.new_product = true ");
		}
		sql.append("GROUP BY p.id,c.id_product ");
		sql.append("ORDER BY RAND() ");
		if (highlight) {
			sql.append("LIMIT 9");
		}
		if (newProduct) {
			sql.append("LIMIT 12");
		}

		return sql.toString();
	}
	
	private String SqlProductPaginates(int id,int start, int totalPage) {
		StringBuffer sql = SqlProductsById(id);
		sql.append("LIMIT " + start + ", " + totalPage);

		return sql.toString();
	}

	public List<ProductsDto> GetDataNewProducts() {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = SqlProduct(NO, YES);
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	public List<ProductsDto> GetDataHighlightProducts() {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = SqlProduct(YES, NO);
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	
	public List<ProductsDto> GeAllProductsById(int id) {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = SqlProductsById(id).toString();
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	
	private String SqlProductById(long id) {
		StringBuffer sql = sqlString();
		sql.append("WHERE p.id = " + id + " ");
		sql.append("LIMIT 1");

		return sql.toString();
	}
	
	public List<ProductsDto> GeDataProductsPaginates(int id,int start, int totalPage) {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = SqlProductPaginates(id,start, totalPage);
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	
	public ProductsDto GetProductById(long id){
		String sql = SqlProductById(id);
		ProductsDto productsDto = _jdbcTemplate.query(sql, new ProductsDtoMapper()).get(0);
		return productsDto;
	}
}
