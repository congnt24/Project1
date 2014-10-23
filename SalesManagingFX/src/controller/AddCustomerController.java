package controller;

import java.net.URL;
import java.util.ResourceBundle;

import model.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddCustomerController implements Initializable{
	@FXML TextField name, add;
	@FXML Label alert;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	@FXML public void addCustomer(ActionEvent event){
		if (!name.getText().trim().equals("")) {
			int code=QLController.customerCode;
			if (code==QLController.NEW_SALE) {
				alert.setText(Main.mysql.addCustomer(name.getText(), add.getText()));
			}else{
				alert.setText(Main.mysql.updateCustomer(code, name.getText(), add.getText()));
			}
			if (alert.getText().equals("1")) {
				QLController.stage.close();
				Main.controller.refresh();
			}
		}else {
			alert.setText("Vui long nhap day du thong tin.");
		}
	}

	public void editCustomerDialog(String name, String add) {
		this.name.setText(name);
		this.add.setText(add);
	}
}
