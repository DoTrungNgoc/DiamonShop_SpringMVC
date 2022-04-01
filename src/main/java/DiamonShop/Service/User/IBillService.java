package DiamonShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.CartDto;
import DiamonShop.Entity.Bills;

@Service
public interface IBillService {
	public int AddBills(Bills bills);
	
	public void AddBillDetail(HashMap<Long, CartDto> cart);
}
