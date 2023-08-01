	package Model;

import java.util.Objects;

public class OrderDetails {
	private String orderDetailsID;
	private Order order;
	private Product product;
	private int quantities;
	private double cost;
	private double discount;
	private double price;
	private double tax;
	private double totalMoney;
	
	public OrderDetails () {
		
	}

	public OrderDetails(String orderDetailsID, Order order, Product product, int quantities, double cost,
			double discount, double price, double tax, double totalMoney) {
		this.orderDetailsID = orderDetailsID;
		this.order = order;
		this.product = product;
		this.quantities = quantities;
		this.cost = cost;
		this.discount = discount;
		this.price = price;
		this.tax = tax;
		this.totalMoney = totalMoney;
	}

	public String getOrderDetailsID() {
		return orderDetailsID;
	}

	public void setOrderDetailsID(String orderDetailsID) {
		this.orderDetailsID = orderDetailsID;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantities() {
		return quantities;
	}

	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
}
