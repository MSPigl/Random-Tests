import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * USED WITH THE CreatingAlertBoxes CLASS
 */
public class ConfirmBox 
{
	public static boolean answer;
	
	public static boolean display(String title, String message)
	{
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(200);
		window.setMinHeight(200);
		
		Button yes = new Button("Ye");
		Button no = new Button("Nah");
		
		yes.setOnAction(e -> {
			answer = true;
			window.close();
		});
		
		no.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		Label label = new Label(message);
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yes, no);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		
		window.showAndWait();
		
		return answer;
	}
}
