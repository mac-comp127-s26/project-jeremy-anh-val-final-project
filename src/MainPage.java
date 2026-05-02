import edu.macalester.graphics.CanvasWindow;

public class MainPage {

    public static void main(String[] args) throws Exception {
        CanvasWindow canvas = new CanvasWindow("Po", 800, 600);
        new SoundBar(20, 300, canvas);
    }
    
}
 