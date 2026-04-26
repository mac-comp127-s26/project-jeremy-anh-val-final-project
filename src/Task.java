import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

public class Task extends GraphicsGroup {
    private Rectangle taskBox;
    private TextField textField;
    private Button button;

    public Task(){
        taskBox = new Rectangle(300, 300, 80, 65);
        textField = new TextField();
        button = new Button("Delete");
    }

    public Rectangle getTaskBox() {
        return taskBox;
    }

    public void setTaskDescription() {
        textField.setText("Task Description");
    }

    public double getTaskboxX() {
        return taskBox.getX();
    }

    public double getTaskboxY() {
        return taskBox.getY();
    }

    public void setButtonPosition(Button button, Rectangle taskBox) {
        button.setPosition(taskBox.getX() + (taskBox.getWidth()/5), 
                           taskBox.getY() + (taskBox.getHeight()/5));
    }
}
