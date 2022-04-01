package DiamonShop.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.BillsDao;
import DiamonShop.Dto.CartDto;
import DiamonShop.Dto.ProductsDto;
import DiamonShop.Entity.BillDetail;
import DiamonShop.Entity.Bills;

@Service
public class BillServiceimpl implements IBillService{
	
	@Autowired
	private BillsDao billsDao;
	
	@Override
	public int AddBills(Bills bills) {
		return billsDao.AddBills(bills);
	}

	@Override
	public void AddBillDetail(HashMap<Long, CartDto> cart) {
		long idBill = billsDao.GetIdLastBills();
		
		for (Map.Entry<Long, CartDto> item : cart.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setId_bill(idBill);
			billDetail.setId_product(item.getValue().getProduct().getId_product());
			billDetail.setQuantity(item.getValue().getQuantity());
			billDetail.setTotal(item.getValue().getTotalPrice());
			billsDao.AddBillsDetail(billDetail);
		}
		
	}

}
