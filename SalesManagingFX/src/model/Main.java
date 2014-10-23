package model;
	


import controller.MySQL;
import controller.QLController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	public static MySQL mysql=new MySQL();
	public static QLController controller;
	public Main() {
		mysql.connect();
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(ClassLoader.getSystemResource("view/gui.fxml"));
			Parent root= loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
//			mysql.getKhachHangFX(QLController.qlkhList);
//			mysql.getNhaCungCapFX(QLController.qlnccList);
			mysql.getKhoFX(QLController.qlkList);
			
			controller=loader.getController();
//			TableView<Sales> saleView=controller.ql
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
