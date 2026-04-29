import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import java.awt.Color;

public class Task extends GraphicsGroup {
    private Rectangle taskBox;
    private Button deleteButton;
   

    public Task(double x, double y, double width, double height) {
        // Create the background box
        taskBox = new Rectangle(0, 0, width, height);
        taskBox.setStrokeColor(Color.BLACK);
        add(taskBox);

        // Create the delete button
        deleteButton = new Button("Delete");
        deleteButton.setCenter(width / 2, height / 2);
        add(deleteButton);

        // Position the entire group on the canvas
        setPosition(x, y);
    }

    public Button getDeleteButton() {
        return deleteButton;
    }
}