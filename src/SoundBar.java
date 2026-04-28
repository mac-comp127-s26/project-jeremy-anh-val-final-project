import edu.macalester.graphics.*;

public class SoundBar {

    private GraphicsGroup group;

    private Rectangle track;
    private Ellipse knob;
    private GraphicsText label;

    private double minX;
    private double maxX;

    public SoundBar(String name, double x, double y, CanvasWindow canvas) {
        group = new GraphicsGroup();

        label = new GraphicsText(name, x, y - 10);

        //track
        track = new Rectangle(x, y, 200, 8);
        track.setFilled(true);
       // track.setFillColor("lightgray");

        //knob
        knob = new Ellipse(x, y - 6, 12, 20);
        knob.setFilled(true);
       // knob.setFillColor("blue");

        minX = x;
        maxX = x + 200;

        group.add(label);
        group.add(track);
        group.add(knob);

        canvas.add(group);

        //drag to higher/lower sound
        // canvas.onMouseDrag(event -> {
        //     if (knob.contains(event.getPosition())) {
        //         moveKnob(event.getPosition().getX());
        //     }
        // });
    }

    private void moveKnob(double mouseX) {
        double clampedX = Math.max(minX, Math.min(maxX, mouseX));
        knob.setPosition(clampedX, knob.getY());
    }

    public GraphicsGroup getGraphics() {
        return group;
    }
}