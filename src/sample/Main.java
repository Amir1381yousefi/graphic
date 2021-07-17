package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\ali\\IdeaProjects\\graphicProject\\properties\\fxml\\sample.fxml").toURI().toURL());
        FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\Mr Ostadi\\IdeaProjects\\graphicProject\\properties\\fxml\\sample.fxml").toURI().toURL());

        Parent root = loader.load();
        primaryStage.setTitle("Start Menu");
        primaryStage.setScene(new Scene(root, 1300, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
