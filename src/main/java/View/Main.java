package View;

import datahandler.Datahandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Arrangement;
import model.Bruker;
import model.Lag;
import model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class Main extends Application {
    public static Main application;
    public Main() {application = this;}

    /* Laget som er innlogget når man går inn på idrettslag*/
    private ArrayList<Person> medlemmerITufte = new ArrayList<>();
    private ArrayList<Arrangement> arrangementerTufteErMeldtPaa = new ArrayList<>();
    private Lag tufte = new Lag("Tufte IL", medlemmerITufte, arrangementerTufteErMeldtPaa);

    /*Bruker som er logget inn når man går inn på bruker*/
    private ArrayList<Arrangement> arrangementerDummyErPaameldt = new ArrayList<>();
    private Bruker dummyBruker = new Bruker("Per", "Sandfjeld","per.sandfjeld@sandfjeld.no", Boolean.FALSE,arrangementerDummyErPaameldt, "Persan76", "per76*jada");


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
        Datahandler.leggTilDummyArrangementer(Datahandler.getArrangementer());
        //Legger til dummymedler til "innlogget lag"
        tufte.leggTilDummyMedlemmer(tufte);
    }

    public Lag getTufte() {
        return tufte;
    }

    public Bruker getDummyBruker() {
        return dummyBruker;
    }

    public static Main getApplication() {
        return application;
    }

    public static void main(String[] args) {
        Application.launch(args);

    }
}
