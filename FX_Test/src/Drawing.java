import java.util.Random;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Drawing extends Application
{
	public Stage window;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception 
	{
		window = arg0;
		window.setTitle("Drawings");
		
		Group group = new Group();
		Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, 
        	       new EventHandler<MouseEvent>() {
        	           @Override
        	           public void handle(MouseEvent e) {
        	               gc.clearRect(e.getX() - 2, e.getY() - 2, 5, 5);
        	           }
        	       });
        
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, 
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {            
                        if (t.getClickCount() >1) {
                        	Random ran = new Random();
                        	Color temp = new Color(ran.nextDouble(),ran.nextDouble(),ran.nextDouble(), 1.0);
                            reset(canvas, temp);
                        }  
                    }
                });
        reset(canvas, Color.BLUE);
        drawShapes(gc);
        group.getChildren().add(canvas);
        
        window.setScene(new Scene(group));
        
        window.show();
        AlertBox.display("Instructions", "Double click to fill with a random color, drag to erase");
	}
	
	private void reset(Canvas canvas, Color color)
	{
	    GraphicsContext gc = canvas.getGraphicsContext2D();
	    gc.setFill(color);
	    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	public void drawShapes(GraphicsContext gc) 
	{
       	//gc.setFill(Color.GREEN);
        //gc.setStroke(Color.RED);
        //gc.setLineWidth(5);
        //gc.strokeLine(40, 10, 10, 40);
        //gc.fillOval(10, 60, 30, 30);
        //gc.strokeOval(60, 60, 30, 30);
        //gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        //gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        //gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        //gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        //gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        //gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        //gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        //gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        //gc.fillPolygon(new double[]{10, 40, 10, 40},
        //               new double[]{210, 210, 240, 240}, 4);
        //gc.strokePolygon(new double[]{60, 90, 60, 90},
        //                 new double[]{210, 210, 240, 240}, 4);
        //gc.strokePolyline(new double[]{110, 140, 110, 140},
        //                 new double[]{210, 210, 240, 240}, 4);
        
    }
}