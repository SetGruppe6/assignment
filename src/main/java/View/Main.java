package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Arrangement;
import model.Lag;
import model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class Main extends Application {
    public static Main application;
    public Main() {application = this;}

    private ArrayList<Person> medlemmerITufte = new ArrayList<>();
    private ArrayList<Arrangement> arrangementerTufteErMeldtPaa = new ArrayList<>();
    private Lag tufte = new Lag("Tufte IL", medlemmerITufte, arrangementerTufteErMeldtPaa);


    @Override
    public void start(Stage primaryStage)  {

        Parent root;

        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("startside.fxml")));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Legger til noen dummy arrangementer bare for at sidene skal vise noe fra starten av
        Arrangement.leggTilDummyArrangementer();
        tufte.leggTilDummyMedlemmer(tufte);
    }

    public Lag getTufte() {
        return tufte;
    }

    public static Main getApplication() {
        return application;
    }
}
