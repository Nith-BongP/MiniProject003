@Override
public void start(Stage stage) throws Exception {

    //
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("scene_main/View.fxml"));
    loader.setController(new scene_main.Controller());

    //
    Parent root = loader.load();

    //
    Scene scene = new Scene(root);

    //
    Image icon = new Image(getClass().getResourceAsStream("asset/itc_logo.png"));

    //
    stage.setScene(scene);
    stage.setTitle("Shopping Cart");
    stage.getIcons().add(icon);
    stage.show();
}