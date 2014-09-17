package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import model.Main;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
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
	
	//Nhap hang hoa
	
	@FXML ComboBox<String> idsale, namesale;
	@FXML Label pricesale, sumpricesale, producersale, alert, alertamount;
	@FXML TextField amountsale, datra;
	
	
	
	
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
		
		//Combobox
		namesale.setItems(Main.mysql.getNameSale());
		
	}
	//New Dialog
	@FXML
	public void newCustomer(ActionEvent event) throws IOException{
		stage=new Stage();
		Parent root=FXMLLoader.load(ClassLoader.getSystemResource("view/addCustomer.fxml"));
		Scene scene=new Scene(root, 400, 500);
		stage.setTitle("Add new Customer Dialog");
		stage.setScene(scene);
		stage.show();
	}
	@FXML public void newSale(ActionEvent event) throws IOException{
		stage=new Stage();
		Parent root=FXMLLoader.load(ClassLoader.getSystemResource("view/newsale.fxml"));
		Scene scene=new Scene(root, 400, 500);
		stage.setTitle("Add new Sale");
		stage.setScene(scene);
		stage.show();
	}
	
	
	@FXML public void selectNameSale(){
		idsale.setItems(Main.mysql.getIDSaleFX(namesale.getSelectionModel().getSelectedItem()));
		idsale.getSelectionModel().select(0);
		try {
			int prices=Integer.parseInt(amountsale.getText().trim());
			sumpricesale.setText(prices*Main.mysql.getSaleFX(pricesale, producersale, namesale.getSelectionModel().getSelectedItem(), idsale.getSelectionModel().getSelectedItem())+"");
			alertamount.setText("OK");
			alertamount.setTextFill(Color.web("#0000FF"));
		} catch (Exception e) {
			sumpricesale.setText(0*Main.mysql.getSaleFX(pricesale, producersale, namesale.getSelectionModel().getSelectedItem(), idsale.getSelectionModel().getSelectedItem())+"");
			alertamount.setText("Exception!!!");
			alertamount.setTextFill(Color.web("#FF0000"));
		}
	}
		
	@FXML public void setAmountSale() throws Exception{
		try {
			int amounts=Integer.parseInt(pricesale.getText());
			sumpricesale.setText(amounts*Integer.parseInt(amountsale.getText())+"");
			alertamount.setText("OK");
			alertamount.setTextFill(Color.web("#0000FF"));
		} catch (Exception e) {
			alertamount.setText("Exception!!!");
			alertamount.setTextFill(Color.web("#FF0000"));
		}

	}
	
	@FXML public void addKho(ActionEvent event){
		try {
			int tra=Integer.parseInt(datra.getText().trim());
			int sum=Integer.parseInt(sumpricesale.getText().trim());
			Integer.parseInt(amountsale.getText());
			Main.mysql.storageSale(idsale.getSelectionModel().getSelectedItem(), amountsale.getText(), sum+"", tra);
			alert.setText("Storage Successfully!!!!!!!!!!!!!");
			alert.setTextFill(Color.web("#0000FF"));
	} catch (Exception e) {
			alert.setText("Error!!!!!!!!!!!!!");
			alert.setTextFill(Color.web("#FF0000"));
		}
		
	}
	
	

}
