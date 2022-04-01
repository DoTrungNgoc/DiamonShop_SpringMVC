package DiamonShop.Entity;

public class BillDetail {
	private long id;
	private long id_product;
	private long id_bill;
	private int quantity;
	private double total;
	public BillDetail() {
		super();
	}
	
	public BillDetail(long id_product, long id_bill, int quantity, double total) {
		super();
		this.id_product = id_product;
		this.id_bill = id_bill;
		this.quantity = quantity;
		this.total = total;
	}

	public BillDetail(long id, long id_product, long id_bill, int quantity, double total) {
		super();
		this.id = id;
		this.id_product = id_product;
		this.id_bill = id_bill;
		this.quantity = quantity;
		this.total = total;
	}

	public long getId_bill() {
		return id_bill;
	}

	public void setId_bill(long id_bill) {
		this.id_bill = id_bill;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_product() {
		return id_product;
	}
	public void setId_product(long id_product) {
		this.id_product = id_product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "BillDetail [id=" + id + ", id_product=" + id_product + ", id_bill=" + id_bill + ", quantity=" + quantity
				+ ", total=" + total + "]";
	}
	
	
	
	
}
