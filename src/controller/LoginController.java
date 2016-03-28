package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Edmond Wu & Vincent Xie
 */
public class LoginController extends Controller {
	
	@FXML
	private TextField Username;
	
	@FXML
	private PasswordField Password;
	
	@FXML
	private Button Login;
	
	public void start(Stage mainStage) {                
		setController(mainStage);
	}
	
	/**
	 * Logs the user in.
	 * @param e Action event.
	 * @throws IOException 
	 */
	public void login(ActionEvent e) throws IOException{
		String username = Username.getText();
		String password = Password.getText();
		if(username.equalsIgnoreCase("admin")){
			return;
		} 
		//search through list
		
		//if found
		FXMLLoader loader = new FXMLLoader();   
		loader.setLocation(getClass().getResource("/view/Admin.fxml"));
	    AnchorPane root = (AnchorPane)loader.load();
	    AdminController Admin = loader.getController();
	    Admin.start(stage);
	    
	    Scene scene = new Scene(root, 800, 600);
	    stage.setScene(scene);
	    stage.setResizable(false);
	    stage.show(); 
		
		/* Alert error = new Alert(AlertType.INFORMATION);
		error.setHeaderText("Invalid Login!");
		error.setContentText("Incorrect username and/or password.");
		error.show();
		Username.setStyle("-fx-text-box-border: red; -fx-focus-color: red;");
		Password.setStyle("-fx-text-box-border: red; -fx-focus-color: red;"); */
	}
	
	/**
	 * Reset default colors and clears.
	 * @param e Mouse event.
	 */
	public void resetUsername(MouseEvent e){
		Username.setStyle("-fx-text-box-border: white; -fx-focus-color: #008ED6;");
	}
	
	/**
	 * Reset default colors and clears.
	 * @param e Mouse event.
	 */
	public void resetPassword(MouseEvent e){
		Password.setStyle("-fx-text-box-border: white; -fx-focus-color: #008ED6;");
	}
}