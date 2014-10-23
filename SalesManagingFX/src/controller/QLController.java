package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import model.Customer;
import model.Main;
import model.Producer;
import model.Sales;
import javafx.beans.property.ReadOnlyObjectWrapper;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class QLController implements Initializable {
	public static final int NEW_SALE=0;
	public static final int EDIT_SALE=1;
	public static Stage stage;
	public static boolean checked;
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
	@FXML TableColumn<Sales, String> qlhhc02 ;
	@FXML TableColumn<Sales, String> qlhhc04;
	@FXML TableColumn<Customer, Integer> qlkhc01;
	@FXML TableColumn<Customer, String> qlkhc02, qlkhc03;
	@FXML TableColumn<Producer, Integer> qlnccc01;
	@FXML TableColumn<Producer, String> qlnccc02;
	@FXML TableColumn<QLKItem, Integer> qlkc01,qlkc02,qlkc03;
	@FXML TableColumn<QLKItem, String> qlkc04,qlkc05,qlkc06;	
	
	//Nhap hang hoa
	public static NewsaleController t1;
	@FXML ComboBox<String> namesale, nameSale, nameCustomer;
	@FXML ComboBox<Integer> idsale, idSale, idCustomer;
	@FXML Label pricesale, sumpricesale, producersale, alert, alertamount, address, priceSale, sumpriceSale, producerSale;
	@FXML TextField amountsale, datra, amountSale, datraSale;
	
	
	
	
	public static ObservableList<Sales> list=FXCollections.observableArrayList();
	public static ObservableList<Customer> qlkhList=FXCollections.observableArrayList();
	public static ObservableList<Producer> qlnccList=FXCollections.observableArrayList();
	public static ObservableList<QLKItem> qlkList=FXCollections.observableArrayList();
	public static ObservableList<String> listName=FXCollections.observableArrayList();
	public static ObservableList<String> listNameCustomer=FXCollections.observableArrayList();
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		qlhhc01.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("id"));
		qlhhc02.setCellValueFactory(new PropertyValueFactory<Sales, String>("name"));
		qlhhc03.setCellValueFactory(new PropertyValueFactory<Sales, Integer>("price"));
		qlhhc04.setCellValueFactory(new PropertyValueFactory<Sales, String>("producer"));
		/*Button in column
		 * qlhhc04.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Sales,Sales>, ObservableValue<Sales>>() {

			@Override
			public ObservableValue<Sales> call(
					CellDataFeatures<Sales, Sales> param) {
				// TODO Auto-generated method stub
				return new ReadOnlyObjectWrapper<Sales>(param.getValue());
			}
		});
		qlhhc04.setComparator(new Comparator<Sales>() {
			
			@Override
			public int compare(Sales o1, Sales o2) {
				// TODO Auto-generated method stub
				return o1.getProducer().compareTo(o2.getProducer());
			}
		});
		qlhhc04.setCellFactory(new Callback<TableColumn<Sales,Sales>, TableCell<Sales,Sales>>() {

			@Override
			public TableCell<Sales, Sales> call(TableColumn<Sales, Sales> param) {
				// TODO Auto-generated method stub
				return new TableCell<Sales, Sales>(){
					final Button button=new Button();
					{
						button.setMinWidth(130);
					}
					@Override
					protected void updateItem(Sales arg0, boolean arg1) {
						// TODO Auto-generated method stub
						super.updateItem(arg0, arg1);
						if (arg0!=null) {
							button.setText(arg0.getProducer());
						}
						setGraphic(button);
					}
				};
			}
		});*/
		qlhh.setItems(list);
		showDetailSale(new Sales(0, null, 0, null));
		qlhh.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Sales>() {

			@Override
			public void changed(ObservableValue<? extends Sales> observable,
					Sales oldValue, Sales newValue) {
				showDetailSale(newValue);
			}
			
		});
		
		qlkhc01.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("id"));
		qlkhc02.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
		qlkhc03.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
		showDetailCustomer(new Customer(0, null, null));
		qlkh.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Customer>() {

			@Override
			public void changed(ObservableValue<? extends Customer> observable,
					Customer oldValue, Customer newValue) {
				showDetailCustomer(newValue);
				
			}
		});
		qlkh.setItems(qlkhList);
		
		qlnccc01.setCellValueFactory(new PropertyValueFactory<Producer, Integer>("id"));
		qlnccc02.setCellValueFactory(new PropertyValueFactory<Producer, String>("name"));
		showDetailProducer(new Producer(0, null));
		qlncc.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Producer>() {

			@Override
			public void changed(ObservableValue<? extends Producer> observable,
					Producer oldValue, Producer newValue) {
				showDetailProducer(newValue);
			}
		});
		qlncc.setItems(qlnccList);

		qlkc01.setCellValueFactory(new PropertyValueFactory<QLKItem, Integer>("id"));
		qlkc02.setCellValueFactory(new PropertyValueFactory<QLKItem, Integer>("amount"));
		qlkc03.setCellValueFactory(new PropertyValueFactory<QLKItem, Integer>("price"));
		qlkc04.setCellValueFactory(new PropertyValueFactory<QLKItem, String>("date"));
		qlkc05.setCellValueFactory(new PropertyValueFactory<QLKItem, String>("name"));
		qlkc06.setCellValueFactory(new PropertyValueFactory<QLKItem, String>("producer"));
		qlk.setItems(qlkList);
		
		
		//List
		
		//Combobox
		listName=Main.mysql.getHangHoaFX(list);
		listNameCustomer=Main.mysql.getKhachHangFX(qlkhList);
		namesale.setItems(listName);
		nameSale.setItems(namesale.getItems());
		namesale.getSelectionModel().selectedItemProperty().addListener(new comboBoxNameSale(idsale));
		nameSale.getSelectionModel().selectedItemProperty().addListener(new comboBoxNameSale(idSale));
		idsale.getSelectionModel().selectedItemProperty().addListener(new comboBoxIdSale(pricesale, producersale, sumpricesale, amountsale));
		idSale.getSelectionModel().selectedItemProperty().addListener(new comboBoxIdSale(priceSale, producerSale, sumpriceSale, amountSale));
		nameCustomer.setItems(listNameCustomer);
		Main.mysql.getNhaCungCapFX(qlnccList);
	}
	
	
	
	//New Dialog
	
	@FXML public void newSale(ActionEvent event) throws IOException{
		code=NEW_SALE;
		showSaleDialog(code);
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
			int tra=Integer.parseInt(datra.getText());
			int sum=Integer.parseInt(sumpricesale.getText().trim());
			int amount=Integer.parseInt(amountsale.getText());
			String ncc=producersale.getText().trim();
			Main.mysql.storageSale(idsale.getSelectionModel().getSelectedItem(), amount, ncc, sum, tra);
			Main.mysql.getKhoFX(qlkList);
			alert.setText("Storage Successfully!!!!!!!!!!!!!");
			alert.setTextFill(Color.web("#0000FF"));
	} catch (Exception e) {
			alert.setText("Error!!!!!!!!!!!!!");
			alert.setTextFill(Color.web("#FF0000"));
		}
		
	}
	
	@FXML public void xuat(){
		try{
			int customerId=idCustomer.getSelectionModel().getSelectedItem();
			int saleId=idSale.getSelectionModel().getSelectedItem();
			int saleAmount=Integer.parseInt(amountSale.getText().trim());
			int saleSum=Integer.parseInt(sumpriceSale.getText().trim());
			int saleDatra=Integer.parseInt(datraSale.getText().trim());
			Main.mysql.insertXuat(customerId, saleId, saleAmount, saleSum, saleDatra);
			Main.mysql.getKhoFX(qlkList);
		}catch(Exception e){
			e.printStackTrace();
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
	@FXML public void refresh(){
		listName=Main.mysql.getHangHoaFX(list);
		namesale.setItems(listName);
		nameSale.setItems(listName);
		namesale.getSelectionModel().select(0);
		nameCustomer.setItems(Main.mysql.getKhachHangFX(qlkhList));
		Main.mysql.getNhaCungCapFX(qlnccList);
	}

	@FXML Label idLabel, nameLabel, pricesLabel, producerLabel;
	public void showDetailSale(Sales sale){
		idLabel.setText(sale.getId()+"");
		nameLabel.setText(sale.getName());
		pricesLabel.setText(sale.getPrice()+"");
		producerLabel.setText(sale.getProducer());
	}
	public static int code=0;
	@FXML public void editSale() throws IOException{
		try{
			code=qlhh.getSelectionModel().getSelectedItem().getId();
			showSaleDialog(EDIT_SALE);
		}catch(Exception e){
			
		}
	}
	public void showSaleDialog(int code) throws IOException{
		stage=new Stage();
		stage.initStyle(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(ClassLoader.getSystemResource("view/newsale.fxml"));
//		loader.setLocation(getClass().getResource("view/newsale.fxml"));
		Parent root=loader.load();
		Scene scene=new Scene(root, 400, 500);
		NewsaleController newsaleController=loader.getController();
		if (code == NEW_SALE) {
			stage.setTitle("Add new Sale");
		}else if (code == EDIT_SALE){
			stage.setTitle("Edit Sale");
			newsaleController.editSaleDialog(nameLabel.getText(), producerLabel.getText(), pricesLabel.getText());
		}
		stage.setScene(scene);
		stage.show();
	}
	@SuppressWarnings("deprecation")
	@FXML public void deleteSale(){
		Action action=Dialogs.create()
				.owner(stage)
				.title("Confirm Dialog")
				.masthead("Look! a Confirm dialog")
				.message("Do you want to delete this sale.")
				.actions(Dialog.ACTION_YES, Dialog.ACTION_NO)
				.showConfirm();
		if (action==Dialog.ACTION_YES) {
			Main.mysql.deleteSale(qlhh.getSelectionModel().getSelectedItem().getId());
			listName=Main.mysql.getHangHoaFX(list);
		}else{
			
		}
	}
	//Khach hang
	@FXML Label idLabel1, nameLabel1, addressLabel1;
	public static int customerCode=NEW_SALE;
	public void showDetailCustomer(Customer sale){
		idLabel1.setText(sale.getId()+"");
		nameLabel1.setText(sale.getName());
		addressLabel1.setText(sale.getAddress());
	}
	@FXML void newCustomer(ActionEvent event) throws IOException{
		customerCode=NEW_SALE;
		showCustomerDialog(NEW_SALE);
	}
	@FXML void editCustomer() throws IOException{
		customerCode=qlkh.getSelectionModel().getSelectedItem().getId();
		showCustomerDialog(EDIT_SALE);
	}
	@FXML void deleteCustomer(){
		Action action=Dialogs.create()
				.owner(stage)
				.title("Confirm Dialog")
				.masthead("Look! a Confirm dialog")
				.message("Do you want to delete this customer.")
				.actions(Dialog.ACTION_YES, Dialog.ACTION_NO)
				.showConfirm();
		if (action==Dialog.ACTION_YES) {
			Main.mysql.deleteCustomer(qlkh.getSelectionModel().getSelectedItem().getId());
			listNameCustomer=Main.mysql.getKhachHangFX(qlkhList);
		}else{
			
		}
	}
	
	public void showCustomerDialog(int code) throws IOException{
		stage=new Stage();
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(ClassLoader.getSystemResource("view/addCustomer.fxml"));
		Parent root=loader.load();
		AddCustomerController control=loader.getController();
		Scene scene=new Scene(root, 400, 500);
		if (code==NEW_SALE) {
			stage.setTitle("Add new Customer Dialog");
		}else {
			control.editCustomerDialog(nameLabel1.getText(), addressLabel1.getText());
			stage.setTitle("Update Customer Dialog");
		}
		stage.setScene(scene);
		stage.show();
	}
	//Nha cung cap
	@FXML Label idLabel2, nameLabel2;
	public static int producerCode;
	public void showDetailProducer(Producer pro){
		idLabel2.setText(pro.getId()+"");
		nameLabel2.setText(pro.getName());
	}
	@FXML void newProducer() throws IOException{
		producerCode=NEW_SALE;
		showProducerDialog(producerCode);
	}
	@FXML void editProducer() throws IOException{
		producerCode=qlncc.getSelectionModel().getSelectedItem().getId();
		showProducerDialog(producerCode);
	}
	@FXML void deleteProducer(){
		
	}
	
	public void showProducerDialog(int code) throws IOException{
		stage=new Stage();
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(ClassLoader.getSystemResource("view/newProducer.fxml"));
		Parent root=loader.load();
		NewProducerController control=loader.getController();
		Scene scene=new Scene(root, 400, 500);
		if (code==NEW_SALE) {
			stage.setTitle("Add new Producer Dialog");
		}else {
			control.editProducerDialog(nameLabel2.getText());
			stage.setTitle("Update Producer Dialog");
		}
		stage.setScene(scene);
		stage.show();
	}
	
}
