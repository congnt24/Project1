package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import model.Customer;
import model.Main;
import model.Producer;
import model.Sales;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
	
	@FXML TableView<Sales> qlhh;
	@FXML TableView<Customer> qlkh;
	@FXML TableView<Producer> qlncc;
	@FXML TableView<QLKItem> qlk;
	
	@FXML TableColumn<Sales, Integer> qlhhc01, qlhhc03 ;
	@FXML TableColumn<Sales, String> qlhhc02, qlhhc04 ;
	@FXML TableColumn<Customer, Integer> qlkhc01;
	@FXML TableColumn<Customer, String> qlkhc02, qlkhc03;
	@FXML TableColumn<Producer, Integer> qlnccc01;
	@FXML TableColumn<Producer, String> qlnccc02;
	@FXML TableColumn<QLKItem, Integer> qlkc01,qlkc02,qlkc03;
	@FXML TableColumn<QLKItem, String> qlkc04,qlkc05,qlkc06;	
	
	//Nhap hang hoa
	
	@FXML ComboBox<String> namesale, nameSale, nameCustomer;
	@FXML ComboBox<Integer> idsale, idSale, idCustomer;
	@FXML Label pricesale, sumpricesale, producersale, alert, alertamount, address, priceSale, sumpriceSale, producerSale;
	@FXML TextField amountsale, datra, amountSale, datraSale;
	
	
	
	
	public static ObservableList<Sales> list=FXCollections.observableArrayList();
	public static ObservableList<Customer> qlkhList=FXCollections.observableArrayList();
	public static ObservableList<Producer> qlnccList=FXCollections.observableArrayList();
	public static ObservableList<QLKItem> qlkList=FXCollections.observableArrayList();
	public static ObservableList<String> listName=FXCollections.observableArrayList();
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		qlhhc01.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("id"));
		qlhhc02.setCellValueFactory(new PropertyValueFactory<Sales, String>("name"));
		qlhhc03.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("price"));
		qlhhc04.setCellValueFactory(new PropertyValueFactory<Sales, String>("producer"));
		qlhh.setItems(list);
		
		qlkhc01.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("id"));
		qlkhc02.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
		qlkhc03.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
		qlkh.setItems(qlkhList);
		
		qlnccc01.setCellValueFactory(new PropertyValueFactory<Producer, Integer>("id"));
		qlnccc02.setCellValueFactory(new PropertyValueFactory<Producer, String>("name"));
		qlncc.setItems(qlnccList);

		qlkc01.setCellValueFactory(new PropertyValueFactory<QLKItem, Integer>("id"));
		qlkc02.setCellValueFactory(new PropertyValueFactory<QLKItem, Integer>("amount"));
		qlkc03.setCellValueFactory(new PropertyValueFactory<QLKItem, Integer>("price"));
		qlkc04.setCellValueFactory(new PropertyValueFactory<QLKItem, String>("date"));
		qlkc04.setCellValueFactory(new PropertyValueFactory<QLKItem, String>("name"));
		qlkc04.setCellValueFactory(new PropertyValueFactory<QLKItem, String>("producer"));
		qlk.setItems(qlkList);
		
		
		//List
		
		//Combobox
		listName=Main.mysql.getHangHoaFX(list);
		namesale.setItems(listName);
		nameSale.setItems(namesale.getItems());
		namesale.getSelectionModel().selectedItemProperty().addListener(new comboBoxNameSale(idsale));
		nameSale.getSelectionModel().selectedItemProperty().addListener(new comboBoxNameSale(idSale));
		idsale.getSelectionModel().selectedItemProperty().addListener(new comboBoxIdSale(pricesale, producersale, sumpricesale, amountsale));
		idSale.getSelectionModel().selectedItemProperty().addListener(new comboBoxIdSale(priceSale, producerSale, sumpriceSale, amountSale));
		nameCustomer.setItems(Main.mysql.getKhachHangFX(qlkhList));
		Main.mysql.getNhaCungCapFX(qlnccList);
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
	
	@FXML public void setAmountSale(){
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
	@FXML public void setAmountSale2(){
		try {
			int amounts=Integer.parseInt(priceSale.getText());
			sumpriceSale.setText(amounts*Integer.parseInt(amountSale.getText())+"");
		} catch (Exception e) {
		}
	}
	//Xuat hang hoa
	
	
	@FXML public void storage(ActionEvent event){
		try {
//			int tra=Integer.parseInt(datra.getText().trim());
//			int sum=Integer.parseInt(sumpricesale.getText().trim());
			Integer.parseInt(amountsale.getText());
//			Main.mysql.storageSale(idsale.getSelectionModel().getSelectedItem(), amountsale.getText(), sum+"", tra);
			alert.setText("Storage Successfully!!!!!!!!!!!!!");
			alert.setTextFill(Color.web("#0000FF"));
	} catch (Exception e) {
			alert.setText("Error!!!!!!!!!!!!!");
			alert.setTextFill(Color.web("#FF0000"));
		}
		
	}
	
	@FXML public void idChange(ActionEvent event){
		if (!idCustomer.getSelectionModel().isEmpty()) {
			address.setText(Main.mysql.getCustomerFX(idCustomer.getSelectionModel().getSelectedItem()));
		}
	}
	@FXML public void nameChange(ActionEvent event){
		idCustomer.setItems(Main.mysql.getIDCustomerFX(nameCustomer.getSelectionModel().getSelectedItem()));
		idCustomer.getSelectionModel().selectFirst();
	}
	
	
	//Class
	public class comboBoxNameSale implements ChangeListener<String>{
		ComboBox<Integer> idbox;
		public comboBoxNameSale(ComboBox<Integer> idbox) {
			this.idbox = idbox;
		}
		@Override
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			idbox.setItems(Main.mysql.getIDSaleFX(observable.getValue()));
			idbox.getSelectionModel().select(0);
		}
	}
	
	private class comboBoxIdSale implements ChangeListener<Integer>{
		Label pricesale, producersale, sumpricesale;
		TextField amountsale;
		public comboBoxIdSale(Label pricesale, Label producersale, Label sumpricesale, TextField amountsale) {
			this.pricesale = pricesale;
			this.producersale = producersale;
			this.sumpricesale = sumpricesale;
			this.amountsale=amountsale;
		}
		@Override
		public void changed(ObservableValue<? extends Integer> id, Integer arg1, Integer arg2) {
			try {
				int price=Main.mysql.getSaleFX(pricesale, producersale, id.getValue());
				int amount=Integer.parseInt(amountsale.getText().trim());
				sumpricesale.setText(price*amount+"");
			} catch (Exception e) {
				sumpricesale.setText("0");
			}
		}
	}
	
}
