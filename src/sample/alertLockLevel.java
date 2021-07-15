package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class alertLockLevel {

    public Button okButton;
    public AnchorPane lockAnchorpane;
    Stage stage=new Stage();

    public void alertLockLevel(){
        FXMLLoader loader = null;
        try {
            loader = new FXMLLoader(new File("C:\\Users\\ali\\IdeaProjects\\graphicProject\\src\\sample\\lockLevel.fxml").toURI().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Lock");
        stage.setScene(new Scene(root, 400, 195));
        stage.setResizable(false);
        stage.show();
    }

    public void okButtonClicked(ActionEvent actionEvent) {
        Stage stage1=(Stage) okButton.getScene().getWindow();
        stage1.close();
    }
}
