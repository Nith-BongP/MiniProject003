import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller {

    VBox vbox = new VBox();

    HBox hbox_1 = new HBox();
    HBox hbox_2 = new HBox();
    HBox hbox_3 = new HBox();

    @FXML
    private ScrollPane scrollPane;

    Label label_item_1 = new Label("item 1");
    Label label_item_1_price = new Label("$5");
    ImageView imageview_item_1;

    Spinner<Integer> spinner_item_1 = new Spinner<>(0, 10, 0);

    @FXML
    void initialize() {
        imageview_item_1.setFitHeight(88);
        imageview_item_1.setFitWidth(95);
        // Initialize ImageView with proper resource handling
        try {
            String resourcePath = getClass().getResource("Asset/bowl.jpg").toExternalForm();
            imageview_item_1 = new ImageView(resourcePath);
        } catch (Exception e) {
            // If resource not found, create empty ImageView
            imageview_item_1 = new ImageView();
            System.out.println("Warning: Image not found - " + e.getMessage());
        }

        hbox_1.getChildren().addAll(imageview_item_1, label_item_1, label_item_1_price, spinner_item_1);
        vbox.getChildren().addAll(hbox_1, hbox_2, hbox_3);
        scrollPane.setContent(vbox);
    }
}