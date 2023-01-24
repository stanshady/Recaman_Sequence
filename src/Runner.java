import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Runner extends Application {

    private Group root;

    private Parent initRoot() {
        root = new Group();

        Circles c = new Circles(64, 5);
        c.makeCircles();

        root.getChildren().addAll(c);

        return root;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(initRoot()));
        primaryStage.show();

    }
}