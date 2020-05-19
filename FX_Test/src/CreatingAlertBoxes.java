import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CreatingAlertBoxes extends Application
{
	Stage window;
	Button button;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primary) throws Exception 
	{
		window = primary;
		window.setTitle("Alert Boxes");
		
		button = new Button("Click muh");
		button.setOnAction(e -> {
			boolean response = ConfirmBox.display("Title", "Sure brah?");
			System.out.println(response);
		});
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}
}
