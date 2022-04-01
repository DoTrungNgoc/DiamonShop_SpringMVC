package DiamonShop.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.CartDao;
import DiamonShop.Dto.CartDto;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	private CartDao cartDao;

	public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart) {
		
		return cartDao.AddCart(id, cart);
	}

	public HashMap<Long, CartDto> EditCart(long id, int quantity, HashMap<Long, CartDto> cart) {
		
		return cartDao.EditCart(id, quantity, cart);
	}

	public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart) {
		
		return cartDao.DeleteCart(id, cart);
	}

	@Override
	public int ToatalQuantity(HashMap<Long, CartDto> cart) {
		
		return cartDao.ToatalQuantity(cart);
	}

	@Override
	public double ToatalPrice(HashMap<Long, CartDto> cart) {
		
		return cartDao.ToatalPrice(cart);
	}

}
