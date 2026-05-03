import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;
import java.awt.Color;

public class Task extends GraphicsGroup {
    private Rectangle taskBox;
    private Button deleteButton;
    // private GraphicsText textField;
    private TextField textField;
    private Button checkButton;
    private Rectangle checkBox;
   

    public Task(double x, double y, double width, double height) {
        // Create the background box
        taskBox = new Rectangle(0, 0, width, height);
        taskBox.setStrokeColor(Color.BLACK);
        add(taskBox);

        // Create the delete button
        deleteButton = new Button("Delete");
        deleteButton.setCenter(width/10, height / 2);
        add(deleteButton);

        // Create the textfield
        // textField = new GraphicsText();
        // textField.setPosition(taskBox.getWidth() / 2, taskBox.getHeight() / 2);
        // textField.setText("Enter a new task...");
        // add(textField);


        textField = new TextField();
        textField.setPosition(taskBox.getWidth() / 2, taskBox.getHeight() / 2);
        textField.onChange(null);
        add(textField);

        // Create the checkButton
        checkButton = new Button("Check");
        checkButton.setCenter(textField.getX() - deleteButton.getX(), textField.getY() - deleteButton.getY());
        add(checkButton);

        // Create the checkbox
        checkBox = new Rectangle(checkButton.getX(), checkButton.getY() + 30, 20, 20);
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