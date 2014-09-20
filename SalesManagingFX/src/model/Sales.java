package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sales {
		private SimpleIntegerProperty id=new SimpleIntegerProperty();
		private SimpleStringProperty name=new SimpleStringProperty();
		private SimpleIntegerProperty price=new SimpleIntegerProperty();
		private SimpleStringProperty producer=new SimpleStringProperty();
		public int getId() {
			return id.get();
		}
		public String getName() {
			return name.get();
		}
		public int getPrice() {
			return price.get();
		}
		public String getProducer() {
			return producer.get();
		}
		public Sales(int id, String name,
				int price, String producer) {
			this.id.setValue(id);
			this.name.setValue(name);
			this.price.setValue(price);
			this.producer.setValue(producer);
		}
}
