import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public class tomatoCreator {
    CanvasWindow tomato = new CanvasWindow("tomato",800, 800);
    private final Color tomatoShellColor = new Color(224, 90, 90);
    private final Color tomatoStemColor = new Color(48,130,31);
    private GraphicsText timeText = new GraphicsText("mm:ss", 240,270);
    private PomoTimer Pomodoro = new PomoTimer();
    private double elapsedTime = 0;

    public tomatoCreator () {
        Ellipse tomato1 = new Ellipse (150,200,150,150);
        tomato1.setFillColor(tomatoShellColor);
        tomato1.setStroked(false);
        Ellipse tomatoshell = new Ellipse(212, 200, 150, 150);
        tomatoshell.setFillColor(tomatoShellColor);
        tomatoshell.setStroked(false);
        Rectangle stem = new Rectangle (250, 175, 12, 32);
        stem.setFillColor(tomatoStemColor);
        tomato.add(tomatoshell);
        tomato.add(tomato1);
        tomato.add(stem);
        tomato.add(timeText);

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
