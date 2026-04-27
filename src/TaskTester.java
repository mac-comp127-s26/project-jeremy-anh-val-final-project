import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

public class TaskTester extends Task {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private CanvasWindow canvas;
    private Task task;
    private Rectangle taskbox;
    private Button deleteButton;
    private Button createTaskButton;

    public TaskTester(double taskX, double taskY, double taskWidth, double taskHeight) {
        super(taskX, taskY, taskWidth, taskHeight);
        canvas = new CanvasWindow("Task Manager tester", CANVAS_WIDTH, CANVAS_HEIGHT);
        // task = new Task(100, 100, CANVAS_WIDTH/10, CANVAS_HEIGHT/10);
        task = new Task(taskX, taskY, taskWidth, taskHeight);

        taskbox = task.getTaskBox();
        deleteButton = new Button("delete");
        createTaskButton = new Button("Add a new task");

        task.setButtonPosition(deleteButton, taskbox);
        canvas.add(taskbox);
        canvas.add(deleteButton);
        deleteButton.onClick(() -> {
            canvas.remove(deleteButton);
            canvas.remove(taskbox);
        });
    }

    public static void main(String[] args) {
        new TaskTester(100, 100, 60, 80);
    }
}
