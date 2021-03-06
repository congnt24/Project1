package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer {
	private SimpleIntegerProperty id=new SimpleIntegerProperty();
	private SimpleStringProperty name=new SimpleStringProperty();
	private SimpleStringProperty address=new SimpleStringProperty();
	public int getId() {
		return id.get();
	}
	public String getName() {
		return name.get();
	}
	public String getAddress() {
		return address.get();
	}
	public Customer(int id, String name, String address) {
		this.id.setValue(id);
		this.name.setValue(name);
		this.address.setValue(address);
	}
}
