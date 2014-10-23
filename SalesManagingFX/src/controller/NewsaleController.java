package controller;

import java.net.URL;
import java.util.ResourceBundle;

import model.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewsaleController implements Initializable{
	int code=QLController.NEW_SALE;

	@FXML TextField name, price;
	@FXML Label alert;
	@FXML ComboBox<String> producer;
	String name2=null;
	int price2=0;
	@FXML private void addSale(){
		if (!name.getText().trim().equals("") & !price.getText().trim().equals("")) {
			name2=name.getText();
			try{
				price2=Integer.parseInt(price.getText());
			}catch(Exception e){
				alert.setText("Loi gia san pham!");
			}

			code=QLController.code;
			if (code==QLController.NEW_SALE) {
				alert.setText(Main.mysql.addSale(name2, price2, producer.getSelectionModel().getSelectedItem()));
			}else{
				alert.setText(Main.mysql.updateSale(code, name2, price2, producer.getSelectionModel().getSelectedItem()));
			}
			if (alert.getText().equals("1")) {
				QLController.stage.close();
				Main.controller.refresh();
			}
			
		}else {
			alert.setText("Vui long nhap day du thong tin.");
		}
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		producer.setItems(Main.mysql.getComboboxNhaCungCap());
		producer.getSelectionModel().select(0);
	}
	public void editSaleDialog(String name, String producer, String prices){
		this.name.setText(name);
		this.price.setText(prices);
		this.producer.getSelectionModel().select(producer);
	}

	public void resultNewSale(ComboBox<String> namesale) {
		namesale.getItems().add(name2);
		
		System.out.println(name2);
		for (String str : namesale.getItems()) {
			System.out.println(str);
		}
	}


}
