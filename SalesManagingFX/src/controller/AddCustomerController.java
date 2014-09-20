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
			alert.setText(Main.mysql.addCustomer(name.getText(), add.getText()));
			if (alert.getText().equals("1")) {
				QLController.stage.close();
				Main.mysql.getKhachHangFX(QLController.qlkhList);
			}
		}else {
			alert.setText("Vui long nhap day du thong tin.");
		}
	}
}
