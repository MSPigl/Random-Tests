import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneTest extends Application implements EventHandler<ActionEvent>
{
	Stage window;
	Scene scene1, scene2;
	Button button1, button2;

	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primary) throws Exception
	{
		window = primary;
		
		Label label1 = new Label("Welcome to the first Scene");
		button1 = new Button("Go to Scene 2");
		button1.setOnAction(e -> window.setScene(scene2));
		
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		
		scene1 = new Scene(layout1, 200, 200);
		
		Label label2 = new Label("Welcome to the second Scene");
		button2 = new Button("Go to Scene 1");
		button2.setOnAction(e -> window.setScene(scene1));
		
		StackPane layout2 = new StackPane();
		layout2.getChildren().addAll(label2, button2);
		
		scene2 = new Scene(layout2, 400, 300);
		
		window.setScene(scene1);
		window.setTitle("Testing 1...2...3...");
		window.show();
	}

	@Override
	public void handle(ActionEvent event) 
	{
		
	}
}