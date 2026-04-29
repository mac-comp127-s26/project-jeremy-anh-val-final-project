import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.ui.Button;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private CanvasWindow canvas;
    private List<Task> tasks;
    private double nextTaskY = 10;
    private Button addTaskButton;

    public TaskManager(CanvasWindow canvas) {
        this.canvas = canvas;
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a new task to the list and the canvas.
     */
    public void addTask(String description) {
        Task newTask = new Task(20, nextTaskY, 200, 50);
        
        // Setup the delete logic
        newTask.getDeleteButton().onClick(() -> {
            removeTask(newTask);
        });

        tasks.add(newTask);
        canvas.add(newTask);
        
        nextTaskY += 60; // Move the position for the next task
    }

    /**
     * Removes the task from the list and the canvas.
     */
    private void removeTask(Task task) {
        canvas.remove(task);
        tasks.remove(task);
        // Note: You might want to reposition remaining tasks here
    }

    public Button getAddTaskButton() {
        return addTaskButton;
    }
}