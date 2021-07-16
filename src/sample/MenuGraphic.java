package sample;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MenuGraphic
{
    public void menu(Stage stage)
    {
        Button loginButton=new Button("Login");
        Button signupButton=new Button("Signup");
        GridPane gridPane=new GridPane();
        gridPane.getChildren().addAll(loginButton,signupButton);
        Scene scene=new Scene(gridPane,800,500);
        stage.setScene(scene);
        stage.show();
    }
}
