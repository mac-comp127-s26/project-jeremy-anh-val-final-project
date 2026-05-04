import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;
import java.awt.Color;

public class Task extends GraphicsGroup {
    private Rectangle taskBox;
    private Button deleteButton;
    private TextField textField;
    private Button checkButton;
    private Rectangle checkBox;
   

    public Task(double x, double y, double width, double height) {
        // Create a background box
        taskBox = new Rectangle(0, 0, width, height);
        taskBox.setStrokeColor(Color.BLACK);
        add(taskBox);

        // Create a delete button
        deleteButton = new Button("Delete");
        deleteButton.setCenter(width/10 + 15, height/2 + 15);
        add(deleteButton);

        // Create a text field
        textField = new TextField();
        textField.setPosition(taskBox.getX() + deleteButton.getWidth() + 40, 
                              taskBox.getY() + taskBox.getHeight()/2 - 20);
        textField.onChange(null);
        add(textField);

        // Create a checkButton
        checkButton = new Button("Check");
        checkButton.setPosition(deleteButton.getX(), deleteButton.getY() - 30);
        add(checkButton);

        // Create a checkbox
        checkBox = new Rectangle(taskBox.getX() + taskBox.getWidth() - 30, 
                                 taskBox.getY() + taskBox.getHeight()/2 - 10, 
                                 20, 
                                 20);
        checkBox.setStrokeColor(Color.RED);
        add(checkBox);

        // Position the entire group on the canvas
        setPosition(x, y);
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public String getTaskText() {
        return textField.getText();
    }

    public Button getCheckButton() {
        return checkButton;
    }

    public Rectangle getCheckBox() {
        return checkBox;
    }
}