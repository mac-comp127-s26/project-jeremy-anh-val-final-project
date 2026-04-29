import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import java.awt.Color;

public class Task extends GraphicsGroup {
    private Rectangle taskBox;
    private Button deleteButton;
    private GraphicsText textField;
   

    public Task(double x, double y, double width, double height) {
        // Create the background box
        taskBox = new Rectangle(0, 0, width, height);
        taskBox.setStrokeColor(Color.BLACK);
        add(taskBox);

        // Create the delete button
        deleteButton = new Button("Delete");
        deleteButton.setCenter(width/10, height / 2);
        add(deleteButton);

        textField = new GraphicsText();
        textField.setPosition(taskBox.getWidth() / 2, taskBox.getHeight() / 2);
        textField.setText("Enter a new task...");
        add(textField);

        // Position the entire group on the canvas
        setPosition(x, y);
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public String getTaskText() {
        return textField.getText();
    }
}