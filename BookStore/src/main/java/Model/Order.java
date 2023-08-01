package Model;

import java.sql.Date;
import java.util.Objects;

public class Order {
	private String orderID;
	private Customer customer;
	private String deliveryAddress;
	private String customerAddress;
	private String status;
	private String payments;
	private String paymentStatus;
	private double amountPaid;
	private double missingAmount;
	private Date orderDate;
	private Date deliveryDate;

	public Order () {
		
	}

	public Order(String orderID, Customer customer, String deliveryAddress, String customerAddress, String status,
			String payments, String paymentStatus, double amountPaid, double missingAmount, Date orderDate,
			Date deliveryDate) {
		this.orderID = orderID;
		this.customer = customer;
		this.deliveryAddress = deliveryAddress;
		this.customerAddress = customerAddress;
		this.status = status;
		this.payments = payments;
		this.paymentStatus = paymentStatus;
		this.amountPaid = amountPaid;
		this.missingAmount = missingAmount;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayments() {
		return payments;
	}

	public void setPayments(String payments) {
		this.payments = payments;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public double getMissingAmount() {
		return missingAmount;
	}

	public void setMissingAmount(double missingAmount) {
		this.missingAmount = missingAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountPaid, customer, customerAddress, deliveryAddress, deliveryDate, missingAmount,
				orderDate, orderID, paymentStatus, payments, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Double.doubleToLongBits(amountPaid) == Double.doubleToLongBits(other.amountPaid)
				&& Objects.equals(customer, other.customer) && Objects.equals(customerAddress, other.customerAddress)
				&& Objects.equals(deliveryAddress, other.deliveryAddress)
				&& Objects.equals(deliveryDate, other.deliveryDate)
				&& Double.doubleToLongBits(missingAmount) == Double.doubleToLongBits(other.missingAmount)
				&& Objects.equals(orderDate, other.orderDate) && Objects.equals(orderID, other.orderID)
				&& Objects.equals(paymentStatus, other.paymentStatus) && Objects.equals(payments, other.payments)
				&& Objects.equals(status, other.status);
	}
	
	
	
}
