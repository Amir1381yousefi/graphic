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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.MalformedURLException;
import java.sql.*;

public class LoginController {
    public Button enterButton;
    public StackPane loginMenuStackPane;
    public TextField usernameTextField;
    public TextField passwordTextField;
    public Label alertLabel;
    public Button loginBackButton;
    Stage nowStage;
    public ScaleTransition scaleTransitionFirst;
    public ScaleTransition scaleTransitionSecond;
    public SequentialTransition sequentialTransition;
    private String currentUsername;
    public StackPane levelStageStackPane;
    public StackPane mainMenuStageStackPane;
    public Controller controller=new Controller();

    public void enterButtonMouseClicked(ActionEvent actionEvent) {
        boolean truePass=false,haveUser=false;
        String username=usernameTextField.getText();
        String pass=passwordTextField.getText();
        String url="jdbc:mysql://localhost:3306";
        String user="root";
        String password="@Mir1381";
        try {
            Connection connection= DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            String sql = "select username from users.user where username=('"+username+"')";
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                haveUser=true;
                System.out.println(resultSet.getString("username"));
            }
            nowStage=(Stage) enterButton.getScene().getWindow();
            if (haveUser){
                Connection passConnection= DriverManager.getConnection(url,user,password);
                Statement passStatement = passConnection.createStatement();
                String passSql = "select password from users.user where username=('"+username+"')";
                ResultSet passResultSet=passStatement.executeQuery(passSql);
                while (passResultSet.next()){
                    System.out.println(passResultSet.getString("password"));
                    if (passResultSet.getString("password").equals(pass)){
                        truePass=true;
                    }
                }
                if (truePass){
                    currentUsername=(username);
                    loginFadeOut();
                }else {
                    alertLabel.setVisible(true);
                    alertLabel.setText("your password is wrong!");
                    PauseTransition pauseTransition=new PauseTransition(Duration.seconds(2));
                    pauseTransition.setOnFinished(event -> alertLabel.setVisible(false));
                    pauseTransition.play();
                }
            }else {
                alertLabel.setVisible(true);
                alertLabel.setText("Signup first!!");
                PauseTransition pauseTransition=new PauseTransition(Duration.seconds(2));
                pauseTransition.setOnFinished(event -> alertLabel.setVisible(false));
                pauseTransition.play();
            }
            statement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
    }

    public void loginFadeOut(){
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(loginMenuStackPane);
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

    public void FadeOutTransitionForLogin(StackPane stackPane,Stage stage) {
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(stackPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(event ->{
            setLoginScene(stage);
        });
        fadeTransition.play();
    }

    public void setLoginScene(Stage stage){
        nowStage=stage;
        FXMLLoader loader = null;
        try {
            loader = new FXMLLoader(new File("C:\\Users\\ali\\IdeaProjects\\graphicProject\\src\\sample\\loginPage.fxml").toURI().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("1 : "+e.getMessage());
        }
        Parent root = null;
        try {
            root = loader.load();
            loginMenuStackPane=(StackPane) root;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("2 : "+e.getMessage());
        }
        root.setOpacity(0);
        loginMenuStackPane.setOpacity(0);
        stage.setTitle("Login");
        loginFadeInTransition();
        stage.setScene(new Scene(root, 1300, 700));
    }

    private void loginFadeInTransition() {
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setNode(loginMenuStackPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setDuration(Duration.millis(2000));
        fadeTransition.play();
    }

    public void loginBackButtonClicked(ActionEvent actionEvent) {
        loginFadeOutToMainMenu();
    }

    public void loginFadeOutToMainMenu(){
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(loginMenuStackPane);
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
            mainMenuStageStackPane=(StackPane) root;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("2 : "+e.getMessage());
        }
        mainMenuStageStackPane.setOpacity(0);
        nowStage.setTitle("Menu");
        mainMenuFadeIn();
        nowStage.setScene(new Scene(root, 1300, 700));
    }

    public void mainMenuFadeIn(){
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setNode(mainMenuStageStackPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setDuration(Duration.millis(2000));
        fadeTransition.play();
    }

    public void loginBackButtonEntered(MouseEvent mouseEvent) {
        sequentialTransition=new SequentialTransition();
        scaleTransitionFirst=new ScaleTransition(Duration.millis(200),loginBackButton);
        scaleTransitionFirst.setToX(1.5);
        scaleTransitionFirst.setToY(1.5);
        sequentialTransition.getChildren().addAll(scaleTransitionFirst);
        sequentialTransition.play();
    }

    public void loginBackButtonExited(MouseEvent mouseEvent) {
        scaleTransitionSecond=new ScaleTransition(Duration.millis(200),loginBackButton);
        scaleTransitionSecond.setToX(1);
        scaleTransitionSecond.setToY(1);
        scaleTransitionSecond.play();
    }

}
