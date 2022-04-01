package DiamonShop.Entity;

public class Menus {
	private int id;
	private String name;
	private String url;
	
	public Menus() {
		super();
	}

	public Menus(int id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Menus [id=" + id + ", name=" + name + ", url=" + url + "]";
	}
	
	
}
