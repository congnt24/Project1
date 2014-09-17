package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class NewsaleController implements Initializable{
	@FXML TextField name, price;
	@FXML ComboBox<String> producer;
	
	
	@FXML private void addSale(){
		if (!name.getText().trim().equals("") & !price.getText().trim().equals("")) {
			System.out.println(name.getText());
			System.out.println(price.getText());
		}
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		producer.setItems(Main.mysql.getComboboxNhaCungCap());
	}
}
