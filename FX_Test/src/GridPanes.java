import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GridPanes extends Application 
{
	public Stage window;
	public Scene loginScreen;
	public Scene logoutScreen;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception
	{
		window = arg0;
		window.setTitle("Login Screen");
		
		VBox lyot = new VBox();
		Button logout = new Button("Logout");
		logout.setOnAction(e -> window.setScene(loginScreen));
		lyot.getChildren().add(logout);
		logoutScreen = new Scene(lyot, 300, 300);
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		Label name = new Label("Username: ");
		GridPane.setConstraints(name, 0, 0);
		
		TextField nameInput = new TextField();
		nameInput.setPromptText("Username");
		GridPane.setConstraints(nameInput, 1, 0);
		
		Label password = new Label("Password: ");
		GridPane.setConstraints(password, 0, 1);
		
		TextField passInput = new TextField();
		passInput.setPromptText("Password");
		GridPane.setConstraints(passInput, 1, 1);
		
		Label alert = new Label("Invalid input!");
		alert.setStyle("-fx-text-fill: red;");
		alert.setVisible(false);
		GridPane.setConstraints(alert, 1, 3);
		
		Button login = new Button("Login");
		login.setOnAction(e -> {
			String userText = nameInput.getText();
			String passText = passInput.getText();
			
			if (!userText.equals("") && !passText.equals(""))
			{	
				System.out.println(userText + "\n" + passText); 
				nameInput.clear();
				passInput.clear();
				
				GridPane.setConstraints(alert, 1, 3);
				GridPane.setConstraints(login, 1, 2);
				alert.setVisible(false);
				
				window.setScene(logoutScreen);
			}
			else
			{
				GridPane.setConstraints(alert, 1, 2);
				GridPane.setConstraints(login, 1, 3);
				alert.setVisible(true);
			}
		});
		GridPane.setConstraints(login, 1, 2);
		
		grid.getChildren().addAll(name, nameInput, password, passInput, login, alert);
		
		loginScreen = new Scene(grid, 300, 300);
		
		window.setScene(loginScreen);
		window.setMinHeight(150);
		window.setMinWidth(260);
		window.show();
	}
}