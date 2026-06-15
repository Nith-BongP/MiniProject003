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

    private final int BOWL_PRICE = 5;
    private final int BOARD_PRICE = 10;
    private final int SPOON_PRICE = 2;
    private final int KEV_PRICE = 15;




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
                createRow("($5)", "Asset/bowl.jpg", spinnerBowl),
                createRow("($10)", "Asset/cutting board.jpg", spinnerBoard),
                createRow(" ($2)", "Asset/spoon.jpg", spinnerSpoon),
                createRow("($15)", "Asset/kev.jpg", spinnerkev)
        );

        scrollPane.setContent(mainBox);
        scrollPane.setFitToWidth(true);
    }

    private HBox createRow(String name, String imgPath, Spinner<Integer> spinner) {

        HBox row = new HBox(20);
        row.setAlignment(Pos.CENTER_LEFT);

        Label label = new Label(name);

        ImageView image = new ImageView(
                new Image(getClass().getResource(imgPath).toExternalForm())
        );
        image.setFitWidth(150);
        image.setFitHeight(150);
        image.setPreserveRatio(true);

        row.getChildren().addAll(label, image, spinner);

        return row;
    }

    @FXML
    private void submitOrder() {

        int bowl = spinnerBowl.getValue();
        int board = spinnerBoard.getValue();
        int spoon = spinnerSpoon.getValue();
        int kev = spinnerkev.getValue();

        int total = (bowl * BOWL_PRICE) + (board * BOARD_PRICE) + (spoon * SPOON_PRICE) + (kev * KEV_PRICE) ;

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