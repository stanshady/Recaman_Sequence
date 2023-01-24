import javafx.scene.layout.Pane;

public class Circles extends Pane {

    private int n;
    private int scaleR;
    private boolean clockwise;
    private Recaman recaman;

    Circles(int n, int scaleR) {
        this.n = n;
        this.scaleR = scaleR;
        clockwise = false;
        recaman = new Recaman();
        this.setPrefSize(1000, 1000);
    }

    public void makeCircles() {
        if (n <= 1) {
            return;
        }

        recaman.nextRecaman();
        Semicircle semi = new Semicircle(scaleR, 10, 500, clockwise, true);
        this.getChildren().add(semi);

        for (int i = 2; i < n; i++) {

            boolean right = recaman.nextRecaman();
            double startX = semi.getEndX();
            double startY = semi.getStartY();
            int radius = recaman.getSize() * scaleR;
            if (recaman.isSwitched()) {
                clockwise = !clockwise;
            }

            semi = new Semicircle(radius, startX, startY, clockwise, right);

            this.getChildren().add(semi);
        }
    }
}
