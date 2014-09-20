package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Producer {
	private SimpleIntegerProperty id=new SimpleIntegerProperty();
	private SimpleStringProperty name=new SimpleStringProperty();
	public int getId() {
		return id.get();
	}
	public String getName() {
		return name.get();
	}
	public Producer(int id, String name) {
		this.id.setValue(id);
		this.name.setValue(name);
	}
}
