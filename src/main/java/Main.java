import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Arrangement;

import java.io.IOException;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root;

        root = FXMLLoader.load(getClass().getResource("startside.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        //Legger til noen dummy arrangementer bare for at sidene skal vise noe fra starten av
        Arrangement.leggTilDummyArrangementer();
    }

}
