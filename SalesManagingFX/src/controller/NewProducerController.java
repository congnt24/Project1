package controller;

import java.net.URL;
import java.util.ResourceBundle;

import model.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewProducerController implements Initializable{
	@FXML TextField name;
	@FXML Label alert;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	@FXML void newProducer(ActionEvent event){
		if (!name.getText().trim().equals("")) {
			int code = QLController.producerCode;
			if (code==QLController.NEW_SALE) {
				alert.setText(Main.mysql.addProducer(name.getText()));
			}else{
				alert.setText(Main.mysql.updateProducer(code, name.getText()));
			}
			if (alert.getText().equals("1")) {
				QLController.stage.close();
				Main.controller.refresh();
			}
		}
	}
	
	public void editProducerDialog(String name){
		this.name.setText(name);
	}
}
