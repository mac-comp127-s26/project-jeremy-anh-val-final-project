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
        createTaskButton = new Button("Add a new task");                //to be implemented

        Task task1 = new Task(60, 60, 80, 100);
        Rectangle taskBox1 = TaskManager.createTaskWindow(task1);
        Button deleteButton1 = TaskManager.createDeleteButton(canvas, task1);
        canvas.add(taskBox1);
        canvas.add(deleteButton1);
    }

    public static void main(String[] args) {
        new TaskTester(100, 100, 60, 80);
    }
}
