import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {

        System.out.println("Hello Micke!");


        System.out.println("Simon säger hej till alla!");


        //Alex test
        System.out.println("Hello Alex!");

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane pane = new AnchorPane();
        pane.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        Button exitButton = new Button("Avsluta spelet");
        exitButton.setOnAction((e)-> Platform.exit());
        Button playButton = new Button("Spela");
        Screen screen = Screen.getScreens().get(0);
        pane.getChildren().addAll(exitButton, playButton);
        Rectangle2D bounds = screen.getVisualBounds();
        Scene scene = new Scene(pane, bounds.getWidth(), bounds.getHeight());
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        exitButton.setLayoutY(bounds.getHeight()/2);
        playButton.setLayoutY(bounds.getHeight()/2);
        exitButton.getStyleClass().add("cool-button-close");
        playButton.getStyleClass().add("cool-button-play");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
//        primaryStage.setFullScreenExitHint("");
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.show();
        Platform.runLater(() -> {
            double exitButtonWidth = exitButton.getWidth();
            exitButton.setLayoutX(bounds.getWidth()/2-exitButtonWidth);
            playButton.setLayoutX(bounds.getWidth()/2);
        });
    }
}