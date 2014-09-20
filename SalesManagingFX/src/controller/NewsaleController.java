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
	@FXML TextField name, price;
	@FXML Label alert;
	@FXML ComboBox<String> producer;
	@FXML private void addSale(){
		if (!name.getText().trim().equals("") & !price.getText().trim().equals("")) {
			try {
				alert.setText(Main.mysql.addSale(name.getText(), Integer.parseInt(price.getText()), producer.getSelectionModel().getSelectedItem()));
				if (alert.getText().equals("1")) {
					QLController.stage.close();
					Main.mysql.getHangHoaFX(QLController.list);
				}
			} catch (Exception e) {
				alert.setText("Loi gia san pham!");
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
}
