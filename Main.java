import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("View.fxml")
        );

        Scene scene = new Scene(loader.load());

        stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Asset/Logo-GTRSC-png.png")));

        stage.setTitle("Mini Project 3 - Shopping System");
        stage.setScene(scene);

        stage.setWidth(1000);
        stage.setHeight(700);

        stage.centerOnScreen();
        stage.setResizable(true);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}