import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.TextField;

public class Task extends GraphicsGroup {
    private Rectangle taskBox;
    private TextField textField;

    public Task(){
        taskBox = new Rectangle(300, 300, 80, 65);
        textField = new TextField();
    }

    public Rectangle getTaskBox() {
        return taskBox;
    }

    public void setTaskDescription() {
        textField.setText("Task Description");
    }
}
