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
	public Main() {
		mysql.connect();
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root= FXMLLoader.load(ClassLoader.getSystemResource("view/gui.fxml"));
			Scene scene = new Scene(root,400,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
//			mysql.getKhachHangFX(QLController.qlkhList);
//			mysql.getNhaCungCapFX(QLController.qlnccList);
			mysql.getKhoFX(QLController.qlkList);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
