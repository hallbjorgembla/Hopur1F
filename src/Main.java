import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Þetta er main skjalið okkar
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        primaryStage.setTitle("Welcome to flightSearch");
        primaryStage.setScene(new Scene(root, 400, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
