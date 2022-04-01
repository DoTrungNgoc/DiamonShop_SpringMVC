package DiamonShop.Dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DiamonShop.Dto.CartDto;
import DiamonShop.Dto.ProductsDto;

@Repository
public class CartDao extends BaseDao {
	
	@Autowired
	private ProductsDao productsDao;
	
	public HashMap<Long, CartDto> AddCart (long id, HashMap<Long, CartDto> cart) {
		CartDto itemCart = null;
		
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity() + 1);
			itemCart.setTotalPrice(itemCart.getQuantity() * itemCart.getProduct().getPrice());
		}else {
			itemCart =  new CartDto();
			ProductsDto product = productsDao.GetProductById(id);
			if (product!=null) {
				itemCart.setProduct(product);
				itemCart.setQuantity(1);
				itemCart.setTotalPrice(product.getPrice());
			}
		}
		
		cart.put(id, itemCart);
		return cart;
	}
	
	public HashMap<Long, CartDto> EditCart (long id,int quantity, HashMap<Long, CartDto> cart) {
		if (cart == null)
			return cart;
		if(quantity == 0) {
			return DeleteCart(id, cart);
		}
		
		CartDto itemCart = new CartDto();
		if (cart.containsKey(id)) {
			
			itemCart = cart.get(id);
			itemCart.setQuantity(quantity);
			itemCart.setTotalPrice(quantity * itemCart.getProduct().getPrice());
		}
		
		cart.put(id, itemCart);
		return cart;
	}
	
	public HashMap<Long, CartDto> DeleteCart (long id,HashMap<Long, CartDto> cart) {
		if (cart == null)
			return cart;
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		
		return cart;
	}
	
	public int ToatalQuantity (HashMap<Long, CartDto> cart) {
		if (cart == null)
			return 0;
		int total=0;
		for (Map.Entry<Long, CartDto> item : cart.entrySet()) {
			total+=item.getValue().getQuantity();
		}
		
		return total;
	}
	
	public double ToatalPrice (HashMap<Long, CartDto> cart) {
		double totalPrice=0;
		for (Map.Entry<Long, CartDto> item : cart.entrySet()) {
			totalPrice+=item.getValue().getTotalPrice();
		}
		
		return totalPrice;
		
	}
	
}
