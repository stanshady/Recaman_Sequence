import javafx.scene.shape.ArcTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Semicircle extends Path {
    private int radius;

    private boolean clockwise, right;

    private double startX, startY, endX;
    private ArcTo semicircle;

    Semicircle(int radius, double startX, double startY, boolean clockwise, boolean right){
        this.radius = radius;
        this.startX = startX;
        this.startY = startY;
        this.clockwise = clockwise;
        this.right = right;

        MoveTo moveTo = new MoveTo(startX, startY);

        semicircle = new ArcTo();
        semicircle.setSweepFlag(clockwise);
        semicircle.setRadiusX(radius);
        semicircle.setRadiusY(radius);

        if(right) {
            semicircle.setX(startX + 2 * radius);
            semicircle.setY(startY);

            endX = startX + radius * 2;
        }

        else {
            semicircle.setX(startX - 2 * radius);
            semicircle.setY(startY);

            endX = startX - radius * 2;
        }
        this.getElements().add(moveTo);
        this.getElements().add(semicircle);
    }

    public double getStartY() {
        return startY;
    }

    public double getEndX() {
        return endX;
    }
}
