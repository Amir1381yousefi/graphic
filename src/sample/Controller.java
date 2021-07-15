package sample;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Controller {
    static String currentUsername;
    public Button exitButton;
    public Button loginButton;
    public Button settingButton;
    public Button signUpButton;
    public AnchorPane firstMenuAnchorPane;
    public ScaleTransition scaleTransitionFirst;
    public ScaleTransition scaleTransitionSecond;
    public SequentialTransition sequentialTransition;
    public Stage nowStage=new Stage();
    public AnchorPane levelAnchorPane;
    public TextField usernameTextField;
    public TextField passwordTextField;
    public Button enterButton;
    public StackPane signupMenuStackPane;
    public StackPane firstMenuStackPane;
    public Label alertLabel;
    public StackPane levelStageStackPane;
    public Button signUpBackButton;

    public void signUpMouseEntered(MouseEvent mouseEvent) {
        sequentialTransition=new SequentialTransition();
        scaleTransitionFirst=new ScaleTransition(Duration.millis(200),signUpButton);
        scaleTransitionFirst.setToX(1.5);
        scaleTransitionFirst.setToY(1.5);
        sequentialTransition.getChildren().addAll(scaleTransitionFirst);
        sequentialTransition.play();
    }

    public void signUpMouseExited(MouseEvent mouseEvent) {
        scaleTransitionSecond=new ScaleTransition(Duration.millis(200),signUpButton);
        scaleTransitionSecond.setToX(1);
        scaleTransitionSecond.setToY(1);
        scaleTransitionSecond.play();
    }

    public void settingMouseEntered(MouseEvent mouseEvent) {
        sequentialTransition=new SequentialTransition();
        scaleTransitionFirst=new ScaleTransition(Duration.millis(200),settingButton);
        scaleTransitionFirst.setToX(1.5);
        scaleTransitionFirst.setToY(1.5);
        sequentialTransition.getChildren().addAll(scaleTransitionFirst);
        sequentialTransition.play();
    }

    public void settingMouseExited(MouseEvent mouseEvent) {
        scaleTransitionSecond=new ScaleTransition(Duration.millis(200),settingButton);
        scaleTransitionSecond.setToX(1);
        scaleTransitionSecond.setToY(1);
        scaleTransitionSecond.play();
    }

    public void loginMouseEntered(MouseEvent mouseEvent) {
        sequentialTransition=new SequentialTransition();
        scaleTransitionFirst=new ScaleTransition(Duration.millis(200),loginButton);
        scaleTransitionFirst.setToX(1.5);
        scaleTransitionFirst.setToY(1.5);
        sequentialTransition.getChildren().addAll(scaleTransitionFirst);
        sequentialTransition.play();
    }

    public void loginMouseExited(MouseEvent mouseEvent) {
        scaleTransitionSecond=new ScaleTransition(Duration.millis(200),loginButton);
        scaleTransitionSecond.setToX(1);
        scaleTransitionSecond.setToY(1);
        scaleTransitionSecond.play();
    }

    public void exitMouseEntered(MouseEvent mouseEvent) {
        sequentialTransition=new SequentialTransition();
        scaleTransitionFirst=new ScaleTransition(Duration.millis(200),exitButton);
        scaleTransitionFirst.setToX(1.5);
        scaleTransitionFirst.setToY(1.5);
        sequentialTransition.getChildren().addAll(scaleTransitionFirst);
        sequentialTransition.play();
    }

    public void exitMouseExited(MouseEvent mouseEvent) {
        scaleTransitionSecond=new ScaleTransition(Duration.millis(200),exitButton);
        scaleTransitionSecond.setToX(1);
        scaleTransitionSecond.setToY(1);
        scaleTransitionSecond.play();
    }

    public void enterButtonMouseEntered(MouseEvent mouseEvent) {
        sequentialTransition=new SequentialTransition();
        scaleTransitionFirst=new ScaleTransition(Duration.millis(200),enterButton);
        scaleTransitionFirst.setToX(1.5);
        scaleTransitionFirst.setToY(1.5);
        sequentialTransition.getChildren().addAll(scaleTransitionFirst);
        sequentialTransition.play();
    }

    public void enterButtonMouseExited(MouseEvent mouseEvent) {
        scaleTransitionSecond=new ScaleTransition(Duration.millis(200),enterButton);
        scaleTransitionSecond.setToX(1);
        scaleTransitionSecond.setToY(1);
        scaleTransitionSecond.play();
    }







    public void makeFadeOutTransition(){
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(firstMenuStackPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(event ->{
            setScene();
        });
        fadeTransition.play();
    }

    public void makeFadeInTransition(){
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setNode(signupMenuStackPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setDuration(Duration.millis(2000));
        fadeTransition.play();
    }

    public void setScene(){
        nowStage=(Stage) signUpButton.getScene().getWindow();
        FXMLLoader loader = null;
        try {
            loader = new FXMLLoader(new File("C:\\Users\\ali\\IdeaProjects\\graphicProject\\src\\sample\\signupPage.fxml").toURI().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("1 : "+e.getMessage());
        }
        Parent root = null;
        try {
            root = loader.load();
            signupMenuStackPane=(StackPane) root;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("2 : "+e.getMessage());
        }
        root.setOpacity(0);
        signupMenuStackPane.setOpacity(0);
        nowStage.setTitle("SignUp");
        makeFadeInTransition();
        nowStage.setScene(new Scene(root, 1300, 700));
    }

    public void signUpMouseClicked(ActionEvent actionEvent) {
        makeFadeOutTransition();
    }

    public void settingMouseClicked(ActionEvent actionEvent) {
        nowStage=(Stage) settingButton.getScene().getWindow();
    }

    public void loginMouseClicked(ActionEvent actionEvent) {
        LoginController  loginController=new LoginController();
        nowStage=(Stage) loginButton.getScene().getWindow();
        loginController.FadeOutTransitionForLogin(firstMenuStackPane,nowStage);
    }

    public void exitMouseClicked(ActionEvent actionEvent) {
        nowStage=(Stage) exitButton.getScene().getWindow();
    }

    public void enterButtonMouseClicked(ActionEvent actionEvent) {
        String username=usernameTextField.getText();
        String pass=passwordTextField.getText();
        String url="jdbc:mysql://localhost:3306";
        String user="root";
        String password="@Mir1381";
        try {
            Connection connection= DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            String sql = "insert into users.user values ('"+username+"','"+pass+"','"+1+"')";
            statement.execute(sql);
            currentUsername=(username);
            statement.close();
            nowStage=(Stage) enterButton.getScene().getWindow();
            signUpFadeOut();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
            if (throwables.getMessage().contains("Duplicate entry")){
                alertLabel.setVisible(true);
                alertLabel.setText("This username has already used!");
                PauseTransition pauseTransition=new PauseTransition(Duration.seconds(2));
                pauseTransition.setOnFinished(event -> alertLabel.setVisible(false));
                pauseTransition.play();
            }
        }
    }

    public void signUpFadeOut(){
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(signupMenuStackPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(event ->{
            levelSceneSet();
        });
        fadeTransition.play();
    }

    public void levelSceneSet(){
        FXMLLoader loader = null;
        try {
            loader = new FXMLLoader(new File("C:\\Users\\ali\\IdeaProjects\\graphicProject\\src\\sample\\levelStage.fxml").toURI().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("1 : "+e.getMessage());
        }
        Parent root = null;
        try {
            root = loader.load();
            levelStageStackPane=(StackPane) root;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("2 : "+e.getMessage());
        }
        levelStageStackPane.setOpacity(0);
        nowStage.setTitle("Level");
        levelStageFadeIn();
        nowStage.setScene(new Scene(root, 1300, 700));
    }

    public void levelStageFadeIn(){
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setNode(levelStageStackPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setDuration(Duration.millis(2000));
        fadeTransition.play();
    }

    public boolean isNumberic(String s) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (s == null) {
            return false;
        }
        return pattern.matcher(s).matches();
    }

    public void signUpBackButtonClicked(ActionEvent actionEvent) {
        signUpFadeOutToMainMenu();
    }

    private void signUpFadeOutToMainMenu() {
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(signupMenuStackPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(event ->{
            mainMenuSceneSet();
        });
        fadeTransition.play();
    }

    private void mainMenuSceneSet() {
        nowStage=(Stage) enterButton.getScene().getWindow();
        FXMLLoader loader = null;
        try {
            loader = new FXMLLoader(new File("C:\\Users\\ali\\IdeaProjects\\graphicProject\\src\\sample\\sample.fxml").toURI().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("1 : "+e.getMessage());
        }
        Parent root = null;
        try {
            root = loader.load();
            firstMenuStackPane=(StackPane) root;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("2 : "+e.getMessage());
        }
        firstMenuStackPane.setOpacity(0);
        nowStage.setTitle("Menu");
        mainMenuFadeIn();
        nowStage.setScene(new Scene(root, 1300, 700));
    }

    private void mainMenuFadeIn() {
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setNode(firstMenuStackPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setDuration(Duration.millis(2000));
        fadeTransition.play();
    }

    public void signUpBackButtonEntered(MouseEvent mouseEvent) {
        sequentialTransition=new SequentialTransition();
        scaleTransitionFirst=new ScaleTransition(Duration.millis(200),signUpBackButton);
        scaleTransitionFirst.setToX(1.5);
        scaleTransitionFirst.setToY(1.5);
        sequentialTransition.getChildren().addAll(scaleTransitionFirst);
        sequentialTransition.play();
    }

    public void signUpBackButtonExited(MouseEvent mouseEvent) {
        scaleTransitionSecond=new ScaleTransition(Duration.millis(200),signUpBackButton);
        scaleTransitionSecond.setToX(1);
        scaleTransitionSecond.setToY(1);
        scaleTransitionSecond.play();
    }
}
