package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Xuat {
	SimpleStringProperty customer=new SimpleStringProperty();
	SimpleStringProperty sale=new SimpleStringProperty();
	SimpleIntegerProperty id=new SimpleIntegerProperty();
	SimpleIntegerProperty amount=new SimpleIntegerProperty();
	SimpleIntegerProperty prices=new SimpleIntegerProperty();
	SimpleIntegerProperty sum=new SimpleIntegerProperty();
	SimpleIntegerProperty paid=new SimpleIntegerProperty();
	public Xuat(String customer, String sale,int id, int amount, int prices, int sum, int paid) {
		this.customer.setValue(customer);
		this.sale.setValue(sale);
		this.id.setValue(id);
		this.amount.setValue(amount);
		this.prices.setValue(prices);
		this.sum.setValue(sum);
		this.paid.setValue(paid);
	}
	public String getCustomer() {
		return customer.getValue();
	}
	public String getSale() {
		return sale.getValue();
	}
	public int getId() {
		return id.getValue();
	}
	public int getAmount() {
		return amount.getValue();
	}
	public int getPrices() {
		return prices.getValue();
	}
	public int getSum() {
		return sum.getValue();
	}
	public int getPaid() {
		return paid.getValue();
	}
	
}
