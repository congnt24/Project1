package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class QLController implements Initializable {
	public static Stage stage;
	public static class Item {
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
		public Item(int id, String name,
				int price, String producer) {
			this.id.setValue(id);
			this.name.setValue(name);
			this.price.setValue(price);
			this.producer.setValue(producer);
		}
	}
	
	public static class QLKHItem{
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
		public QLKHItem(int id, String name, String address) {
			this.id.setValue(id);
			this.name.setValue(name);
			this.address.setValue(address);
		}
	}
	
	public static class QLNCCItem{
		private SimpleIntegerProperty id=new SimpleIntegerProperty();
		private SimpleStringProperty name=new SimpleStringProperty();
		public int getId() {
			return id.get();
		}
		public String getName() {
			return name.get();
		}
		public QLNCCItem(int id, String name) {
			this.id.setValue(id);
			this.name.setValue(name);
		}
	}
	
	
	public static class QLKItem {
		private SimpleIntegerProperty id=new SimpleIntegerProperty();
		private SimpleIntegerProperty amount=new SimpleIntegerProperty();
		private SimpleIntegerProperty price=new SimpleIntegerProperty();
		private SimpleStringProperty date=new SimpleStringProperty();
		private SimpleStringProperty name=new SimpleStringProperty();
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
		public int getAmount() {
			return amount.get();
		}
		public String getDate() {
			return date.get();
		}
		public QLKItem(int id, int amount, int price, String date, String name, String producer) {
			this.amount.setValue(amount);
			this.date.setValue(date);
			this.id.setValue(id);
			this.name.setValue(name);
			this.price.setValue(price);
			this.producer.setValue(producer);
		}
		
	}
	
	@FXML TableView<Item> qlhh;
	@FXML TableView<QLKHItem> qlkh;
	@FXML TableView<QLNCCItem> qlncc;
	@FXML TableView<QLKItem> qlk;
	
	@FXML TableColumn<Item, Integer> qlhhc01, qlhhc03 ;
	@FXML TableColumn<Item, String> qlhhc02, qlhhc04 ;
	@FXML TableColumn<QLKHItem, Integer> qlkhc01;
	@FXML TableColumn<QLKHItem, String> qlkhc02, qlkhc03;
	@FXML TableColumn<QLNCCItem, Integer> qlnccc01;
	@FXML TableColumn<QLNCCItem, String> qlnccc02;
	@FXML TableColumn<QLKItem, Integer> qlkc01,qlkc02,qlkc03;
	@FXML TableColumn<QLKItem, String> qlkc04,qlkc05,qlkc06;
	public static ObservableList<Item> list=FXCollections.observableArrayList();
	public static ObservableList<QLKHItem> qlkhList=FXCollections.observableArrayList();
	public static ObservableList<QLNCCItem> qlnccList=FXCollections.observableArrayList();
	public static ObservableList<QLKItem> qlkList=FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		qlhhc01.setCellValueFactory(new PropertyValueFactory<Item, Integer>("id"));
		qlhhc02.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
		qlhhc03.setCellValueFactory(new PropertyValueFactory<Item, Integer>("price"));
		qlhhc04.setCellValueFactory(new PropertyValueFactory<Item, String>("producer"));
		qlhh.setItems(list);
		
		qlkhc01.setCellValueFactory(new PropertyValueFactory<QLKHItem, Integer>("id"));
		qlkhc02.setCellValueFactory(new PropertyValueFactory<QLKHItem, String>("name"));
		qlkhc03.setCellValueFactory(new PropertyValueFactory<QLKHItem, String>("address"));
		qlkh.setItems(qlkhList);
		
		qlnccc01.setCellValueFactory(new PropertyValueFactory<QLNCCItem, Integer>("id"));
		qlnccc02.setCellValueFactory(new PropertyValueFactory<QLNCCItem, String>("name"));
		qlncc.setItems(qlnccList);

		qlkc01.setCellValueFactory(new PropertyValueFactory<QLKItem, Integer>("id"));
		qlkc02.setCellValueFactory(new PropertyValueFactory<QLKItem, Integer>("amount"));
		qlkc03.setCellValueFactory(new PropertyValueFactory<QLKItem, Integer>("price"));
		qlkc04.setCellValueFactory(new PropertyValueFactory<QLKItem, String>("date"));
		qlkc04.setCellValueFactory(new PropertyValueFactory<QLKItem, String>("name"));
		qlkc04.setCellValueFactory(new PropertyValueFactory<QLKItem, String>("producer"));
		qlk.setItems(qlkList);
	}

	@FXML
	public void newCustomer(ActionEvent event) throws IOException{
		System.out.println("Clicked");
		stage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("addCustomer.fxml"));
		Scene scene=new Scene(root, 400, 500);
		stage.setTitle("Add new Customer Dialog");
		stage.setScene(scene);
		stage.show();
	}
	@FXML public void newSale(ActionEvent event) throws IOException{
		System.out.println("check");
		stage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("newsale.fxml"));
		Scene scene=new Scene(root, 400, 500);
		stage.setTitle("Add new Sale");
		stage.setScene(scene);
		stage.show();
	}

}
