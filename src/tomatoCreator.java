import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import java.awt.Color;

public class tomatoCreator {
    CanvasWindow tomato = new CanvasWindow("tomato",800, 800);
    private final Color tomatoShellColor = new Color(224, 90, 90);
    private final Color tomatoStemColor = new Color(48,130,31);
    private GraphicsText timeText = new GraphicsText("mm:ss", 240,270);
    private PomoTimer Pomodoro = new PomoTimer();
    private double elapsedTime = 0;
    //all buttons as variables
    Button stopTimerButton = new Button("Stop");
    Button startTimerButton = new Button ("Start");
    Button resetTimerButton = new Button ("Reset");
    Button workSetButton = new Button ("Work");
    Button shortBreakButton = new Button ("Short Break");
    Button longBreakButton = new Button ("Long Break");

    public tomatoCreator () {
        //all graphical elements to create tomato shape
        Ellipse tomato1 = new Ellipse (150,200,150,150);
        tomato1.setFillColor(tomatoShellColor);
        tomato1.setStroked(false);
        Ellipse tomatoshell = new Ellipse(212, 200, 150, 150);
        tomatoshell.setFillColor(tomatoShellColor);
        tomatoshell.setStroked(false);
        Rectangle stem = new Rectangle (250, 175, 12, 32);
        stem.setFillColor(tomatoStemColor);
        timeText.setFontSize(18);
        timeText.setFont("Times New Roman", FontStyle.BOLD, 30); // classic
        //canvas adds all graphical elements
        tomato.add(tomatoshell);
        tomato.add(tomato1);
        tomato.add(stem);
        tomato.add(timeText);

       //stop timer
        stopTimerButton.setPosition(145, 380);
        stopTimerButton.onClick(() -> {
            Pomodoro.Stop();
        }); 
        tomato.add(stopTimerButton);

        //start timer
          startTimerButton.setPosition(213, 380);
        startTimerButton.onClick(() -> {
            Pomodoro.Start();
        });
        tomato.add(startTimerButton);

        resetTimerButton.setPosition(278, 380);
        resetTimerButton.onClick(() -> {
            Pomodoro.Reset();
        });
        tomato.add(resetTimerButton);
        
        workSetButton.setPosition(105, 420);
        workSetButton.onClick(() -> {
            Pomodoro.setCurrentSessiontoWork();
        });
        tomato.add(workSetButton);

        shortBreakButton.setPosition(178, 420);
        shortBreakButton.onClick(() -> {
            Pomodoro.setCurrentSessiontoBreak1();
        });
        tomato.add(shortBreakButton);
       
        longBreakButton.setPosition(285, 420);
        longBreakButton.onClick(() -> {
            Pomodoro.setCurrentSessiontoBreak2();
        });
        tomato.add(longBreakButton);
      

        tomato.animate(dt -> {
            if (Pomodoro.running == true) {
                elapsedTime += dt;
                if (elapsedTime >= 1.0) {
                    Pomodoro.tick();
                    elapsedTime = 0;
                }
                timerTextChange();
            }
        }
    );
    
}
    public void timerTextChange () {
        int minutes = (int) Pomodoro.getTimer () /60;
        int seconds = (int) Pomodoro.getTimer () % 60;
        timeText.setText(String.format("%02d:%02d", minutes, seconds));
    }

    public static void main(String[] args){
        new tomatoCreator();
    }
}
