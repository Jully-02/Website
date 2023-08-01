package Model;

public class Product {
	private String productID;
	private String productName;
	private Author author;
	private int publishYear;
	private double entryPrice;
	private double cost;
	private double price;
	private int quantities;
	private Category category;
	private String language;
	private String description;

	public Product() {

	}

	public Product(String productID, String productName, Author author, int publishYear, double entryPrice, double cost,
			double price, int quantities, Category category, String language, String description) {
		this.productID = productID;
		this.productName = productName;
		this.author = author;
		this.publishYear = publishYear;
		this.entryPrice = entryPrice;
		this.cost = cost;
		this.price = price;
		this.quantities = quantities;
		this.category = category;
		this.language = language;
		this.description = description;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public double getEntryPrice() {
		return entryPrice;
	}

	public void setEntryPrice(double entryPrice) {
		this.entryPrice = entryPrice;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantities() {
		return quantities;
	}

	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
