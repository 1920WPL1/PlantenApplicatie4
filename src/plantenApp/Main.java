package plantenApp;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/PlantToevoegen.fxml"));

        primaryStage.setTitle("Planten applicatie");
        primaryStage.setScene(new Scene(root, 1300, 780));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

   /* public void stop() {
        System.out.println("closing...");
        System.exit(0);
        //0: Sluit alles
        //-1 er is iets verkeerd gegaan dat ik niet verwachte : systeem errors, threads die blijven draaien,...
        // 1: iets dat ik dacht dat verkeerd zou lopen maar ook niet dat dan toch verkeerd loopt
   */ }
