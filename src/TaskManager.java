import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;

public class TaskManager extends Task {
    private static Task task;
    private static Rectangle taskbox;

    public TaskManager(double taskX, double taskY, double taskWidth, double taskHeight) {
        super(taskX, taskY, taskWidth, taskHeight);
    }

    public static Rectangle createTaskWindow(Task task) {
        taskbox = task.getTaskBox();
        return taskbox;
    }

    public static Button createDeleteButton(CanvasWindow canvas, Task task) {
        Button deleteButton = new Button("delete");
        task.setButtonPosition(deleteButton, taskbox);
        deleteButton.onClick(() -> {
            canvas.remove(deleteButton);
            canvas.remove(taskbox);
        });
        return deleteButton;
    }
}

