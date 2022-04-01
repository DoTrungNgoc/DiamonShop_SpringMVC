package DiamonShop.Entity;

public class Bills {
	private long id;
	private String user;
	private String phone;
	private String password;
	private String display_name;
	private String address;
	private double total;
	private int quantity;
	private String note;

	public Bills() {
	}

	public Bills(long id, String user, String phone, String password, String display_name, String address, double total,
			int quantity, String note) {
		super();
		this.id = id;
		this.user = user;
		this.phone = phone;
		this.password = password;
		this.display_name = display_name;
		this.address = address;
		this.total = total;
		this.quantity = quantity;
		this.note = note;
	}

	public Bills(String user, String phone, String password, String display_name, String address, double total,
			int quantity, String note) {
		super();
		this.user = user;
		this.phone = phone;
		this.password = password;
		this.display_name = display_name;
		this.address = address;
		this.total = total;
		this.quantity = quantity;
		this.note = note;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Bills [id=" + id + ", user=" + user + ", phone=" + phone + ", password=" + password + ", display_name="
				+ display_name + ", address=" + address + ", total=" + total + ", quantity=" + quantity + ", note="
				+ note + "]";
	}
	
}
