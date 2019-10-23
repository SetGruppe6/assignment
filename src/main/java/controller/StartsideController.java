package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Bruker;

import java.util.ArrayList;

public class StartsideController {

    @FXML
    private Button registrerButton;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passordPasswordField;

    @FXML
    private TextField navnTextField;

    @FXML
    private TextField etternavnTextField;

    private ArrayList<Bruker> nyBrukerListe;


    @FXML
    public void initialize(){

        registrerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String email = emailTextField.getText();
                String pass = passordPasswordField.getText();

                Bruker nyBruker = new Bruker(email, pass);

                nyBrukerListe.add(nyBruker);
            }
        });


    }

}
