import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Label totalLabel;

    private final int BOWL_PRICE = 2;
    private final int BOARD_PRICE = 5;
    private final double SPOON_PRICE = 0.25;
    private final double KEV_PRICE = 0.75;




    private Spinner<Integer> spinnerBowl;
    private Spinner<Integer> spinnerBoard;
    private Spinner<Integer> spinnerSpoon;
    private Spinner<Integer> spinnerkev;


    @FXML
    public void initialize() {

        spinnerBowl = new Spinner<>(0, 20, 0);
        spinnerBoard = new Spinner<>(0, 20, 0);
        spinnerSpoon = new Spinner<>(0, 20, 0);
        spinnerkev= new Spinner<>(0, 20, 0);

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(15));

        mainBox.getChildren().addAll(
                createRow("($2)", "Asset/bowl.jpg", spinnerBowl),
                createRow("($5)", "Asset/cutting board.jpg", spinnerBoard),
                createRow("($0.25)", "Asset/spoon.jpg", spinnerSpoon),
                createRow("($0.75)", "Asset/kev.jpg", spinnerkev)
        );

        scrollPane.setContent(mainBox);
        scrollPane.setFitToWidth(true);
    }

    private HBox createRow(String name, String imgPath, Spinner<Integer> spinner) {

        HBox row = new HBox(20);
        row.setAlignment(Pos.CENTER_LEFT);

        Label label = new Label(name);

        ImageView image = new ImageView();
        try {
            String resourceUrl = getClass().getResource(imgPath).toExternalForm();
            image = new ImageView(new Image(resourceUrl));
            image.setFitWidth(100);
            image.setFitHeight(100);
            image.setPreserveRatio(true);
        } catch (NullPointerException | IllegalArgumentException e) {
            // Handle missing image file
            System.out.println("Warning: Could not load image - " + imgPath);
            image.setStyle("-fx-background-color: lightgray;");
            image.setFitWidth(100);
            image.setFitHeight(100);
        }

        row.getChildren().addAll(label, image, spinner);

        return row;
    }

    @FXML
    private void submitOrder() {

        int bowl = spinnerBowl.getValue();
        int board = spinnerBoard.getValue();
        int spoon = spinnerSpoon.getValue();
        int kev = spinnerkev.getValue();

        double total = (bowl * BOWL_PRICE) + (board * BOARD_PRICE) + (spoon * SPOON_PRICE) + (kev * KEV_PRICE) ;

        System.out.println("===== ORDER =====");
        System.out.println("Bowl: " + bowl);
        System.out.println("Board: " + board);
        System.out.println("Spoon: " + spoon);
        System.out.println("Kev: " + kev);
        System.out.println("TOTAL = $" + total);

        if (totalLabel != null) {
            totalLabel.setText("Total: $" + total);
        }
    }
}