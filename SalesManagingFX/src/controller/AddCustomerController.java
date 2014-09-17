package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class AddCustomerController implements Initializable{
	@FXML TextField name, add;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	@FXML public void addCustomer(ActionEvent event){
		if (!name.getText().trim().equals("")) {
			MySQL.addCustomer(name.getText(), add.getText());
			System.out.println("Add Customer Successfully!!");
		}
		QLController.stage.close();
	}
	

}
