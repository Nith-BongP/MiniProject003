import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller {

    VBox vbox = new VBox(10); // 10px spacing between rows

    HBox hbox_1 = new HBox(10);
    HBox hbox_2 = new HBox(10);
    HBox hbox_3 = new HBox(10);
    HBox hbox_4 = new HBox(10);
    @FXML
    private ScrollPane scrollPane;

    Label label_item_1       = new Label("Bowl");
    Label label_item_1_price = new Label("$5");
    ImageView imageview_item_1;

    Label label_item_2       = new Label("Cutting Board");
    Label label_item_2_price = new Label("$10");
    ImageView imageview_item_2;

    Label label_item_3       = new Label("Knife");
    Label label_item_3_price = new Label("$15");
    ImageView imageview_item_3;

    Label label_item_4       = new Label("Spoon");
    Label label_item_4_price = new Label("2$");
    ImageView imageview_item_4;

    Spinner<Integer> spinner_item_1 = new Spinner<>(0, 10, 0);
    Spinner<Integer> spinner_item_2 = new Spinner<>(0, 10, 0);
    Spinner<Integer> spinner_item_3 = new Spinner<>(0, 10, 0);
    Spinner<Integer> spinner_item_4 = new Spinner<>(0, 10, 0);
    @FXML
    void initialize() {
        // --- Load images safely (both items) ---
        imageview_item_1 = loadImage("Asset/bowl.jpg");
        imageview_item_2 = loadImage("Asset/cutting board.jpg");
        imageview_item_3 = loadImage("Asset/KNIFT.jpg");
        imageview_item_4 = loadImage("Asset/spoon.jpg");
        // --- Size images ---
        setImageSize(imageview_item_1, 95, 88);
        setImageSize(imageview_item_2, 95, 88);
        setImageSize(imageview_item_3, 95, 88);
        setImageSize(imageview_item_4, 95, 88);

        // --- Build rows ---
        hbox_1.getChildren().addAll(imageview_item_1, label_item_1, label_item_1_price, spinner_item_1);
        hbox_2.getChildren().addAll(imageview_item_2, label_item_2, label_item_2_price, spinner_item_2);
        hbox_3.getChildren().addAll(imageview_item_3, label_item_3, label_item_3_price, spinner_item_3);
        hbox_1.getChildren().addAll(imageview_item_4, label_item_4, label_item_4_price, spinner_item_4);
        // --- Add rows to VBox, set as ScrollPane content ---
        vbox.getChildren().addAll(hbox_1, hbox_2, hbox_3, hbox_4);
        scrollPane.setContent(vbox);
    }

    // Helper: load image or fall back to empty ImageView
    private ImageView loadImage(String path) {
        try {
            String url = getClass().getResource(path).toExternalForm();
            return new ImageView(new Image(url)); // wrap in Image for proper scaling
        } catch (Exception e) {
            System.out.println("Warning: Image not found - " + path);
            return new ImageView(); // safe fallback — never null
        }
    }

    // Helper: set fit size + preserve ratio
    private void setImageSize(ImageView iv, double width, double height) {
        iv.setFitWidth(width);
        iv.setFitHeight(height);
        iv.setPreserveRatio(true);
    }
}