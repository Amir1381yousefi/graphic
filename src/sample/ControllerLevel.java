package sample;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;

import static sample.Controller.currentUsername;

public class ControllerLevel {
    public Button oneButton;
    public Button twoButton;
    public Button fourButton;
    public Button fiveButton;
    public Button threeButton;
    public ScaleTransition scaleTransitionFirst;
    public ScaleTransition scaleTransitionSecond;
    public SequentialTransition sequentialTransition;
    public Button levelStageBackButton;
    public StackPane levelStageStackPane;
    alertLockLevel alertLockLevel=new alertLockLevel();
    public Stage nowStage;
    private StackPane mainMenuStageStackPane;
  //  public Manger manger=new Manger();
    private StackPane gameStageStackPane;

    public void threeMouseEntered(MouseEvent mouseEvent) {
        sequentialTransition=new SequentialTransition();
        scaleTransitionFirst=new ScaleTransition(Duration.millis(200),threeButton);
        scaleTransitionFirst.setToX(1.5);
        scaleTransitionFirst.setToY(1.5);
        sequentialTransition.getChildren().addAll(scaleTransitionFirst);
        sequentialTransition.play();
    }

    public void threeMouseExited(MouseEvent mouseEvent) {
        scaleTransitionSecond=new ScaleTransition(Duration.millis(200),threeButton);
        scaleTransitionSecond.setToX(1);
        scaleTransitionSecond.setToY(1);
        scaleTransitionSecond.play();
    }

    public void oneMouseEntered(MouseEvent mouseEvent) {
        sequentialTransition=new SequentialTransition();
        scaleTransitionFirst=new ScaleTransition(Duration.millis(200),oneButton);
        scaleTransitionFirst.setToX(1.5);
        scaleTransitionFirst.setToY(1.5);
        sequentialTransition.getChildren().addAll(scaleTransitionFirst);
        sequentialTransition.play();
    }

    public void oneMouseExited(MouseEvent mouseEvent) {
        scaleTransitionSecond=new ScaleTransition(Duration.millis(200),oneButton);
        scaleTransitionSecond.setToX(1);
        scaleTransitionSecond.setToY(1);
        scaleTransitionSecond.play();
    }

    public void fiveMouseExited(MouseEvent mouseEvent) {
        scaleTransitionSecond=new ScaleTransition(Duration.millis(200),fiveButton);
        scaleTransitionSecond.setToX(1);
        scaleTransitionSecond.setToY(1);
        scaleTransitionSecond.play();
    }

    public void fiveMouseEntered(MouseEvent mouseEvent) {
        sequentialTransition=new SequentialTransition();
        scaleTransitionFirst=new ScaleTransition(Duration.millis(200),fiveButton);
        scaleTransitionFirst.setToX(1.5);
        scaleTransitionFirst.setToY(1.5);
        sequentialTransition.getChildren().addAll(scaleTransitionFirst);
        sequentialTransition.play();
    }

    public void twoMouseEntered(MouseEvent mouseEvent) {
        sequentialTransition=new SequentialTransition();
        scaleTransitionFirst=new ScaleTransition(Duration.millis(200),twoButton);
        scaleTransitionFirst.setToX(1.5);
        scaleTransitionFirst.setToY(1.5);
        sequentialTransition.getChildren().addAll(scaleTransitionFirst);
        sequentialTransition.play();
    }

    public void twoMouseExited(MouseEvent mouseEvent) {
        scaleTransitionSecond=new ScaleTransition(Duration.millis(200),twoButton);
        scaleTransitionSecond.setToX(1);
        scaleTransitionSecond.setToY(1);
        scaleTransitionSecond.play();
    }

    public void fourMouseEntered(MouseEvent mouseEvent) {
        sequentialTransition=new SequentialTransition();
        scaleTransitionFirst=new ScaleTransition(Duration.millis(200),fourButton);
        scaleTransitionFirst.setToX(1.5);
        scaleTransitionFirst.setToY(1.5);
        sequentialTransition.getChildren().addAll(scaleTransitionFirst);
        sequentialTransition.play();
    }

    public void fourMouseExited(MouseEvent mouseEvent) {
        scaleTransitionSecond=new ScaleTransition(Duration.millis(200),fourButton);
        scaleTransitionSecond.setToX(1);
        scaleTransitionSecond.setToY(1);
        scaleTransitionSecond.play();
    }

    public void firstMouseClicked(ActionEvent actionEvent) {
        int maxLevel=getMaxLevel();
        levelFadeOutToGame();
    }

    public void scondMouseClicked(ActionEvent actionEvent) {
        nowStage=(Stage) twoButton.getScene().getWindow();
        if (getMaxLevel()<2){
            alertLockLevel.alertLockLevel();
        }
    }

    public void fourthMouseClicked(ActionEvent actionEvent) {
        nowStage=(Stage) fourButton.getScene().getWindow();
        if (getMaxLevel()<3){
            alertLockLevel.alertLockLevel();
        }
    }

    public void fifthMouseClicked(ActionEvent actionEvent) {
        nowStage=(Stage) fiveButton.getScene().getWindow();
        if (getMaxLevel()<4){
            alertLockLevel.alertLockLevel();
        }
    }

    public void thirdMouseClicked(ActionEvent actionEvent) {
        nowStage=(Stage) threeButton.getScene().getWindow();
        if (getMaxLevel()<5){
            alertLockLevel.alertLockLevel();
        }
    }

    public int getMaxLevel(){
        int maxLevel=1;
        String url="jdbc:mysql://localhost:3306";
        String user="root";
        String password="@Mir1381";
        try {
            Connection connection= DriverManager.getConnection(url,user,password);
            Statement statement=connection.createStatement();
            String sql="select maxLevel from users.user where username='"+currentUsername+"'";
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                maxLevel=resultSet.getInt("maxLevel");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return maxLevel;
    }

    public void levelStageBackButtonClicked(ActionEvent actionEvent) {
        levelFadeOutToMainMenu();
    }

    private void levelFadeOutToMainMenu() {
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(levelStageStackPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(event ->{
            mainMenuSceneSet();
        });
        fadeTransition.play();
    }

    private void mainMenuSceneSet() {
        nowStage=(Stage) oneButton.getScene().getWindow();
        FXMLLoader loader = null;
        try {
//            loader = new FXMLLoader(new File("C:\\Users\\ali\\IdeaProjects\\graphicProject\\properties\\fxml\\sample.fxml").toURI().toURL());
            loader = new FXMLLoader(new File("C:\\Users\\Mr Ostadi\\IdeaProjects\\graphicProject\\properties\\fxml\\sample.fxml").toURI().toURL());
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

    private void mainMenuFadeIn() {
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setNode(mainMenuStageStackPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setDuration(Duration.millis(2000));
        fadeTransition.play();
    }

    public void levelStageBackButtonEntered(MouseEvent mouseEvent) {
        sequentialTransition=new SequentialTransition();
        scaleTransitionFirst=new ScaleTransition(Duration.millis(200),levelStageBackButton);
        scaleTransitionFirst.setToX(1.5);
        scaleTransitionFirst.setToY(1.5);
        sequentialTransition.getChildren().addAll(scaleTransitionFirst);
        sequentialTransition.play();
    }

    public void levelStageBackButtonExited(MouseEvent mouseEvent) {
        scaleTransitionSecond=new ScaleTransition(Duration.millis(200), levelStageBackButton);
        scaleTransitionSecond.setToX(1);
        scaleTransitionSecond.setToY(1);
        scaleTransitionSecond.play();
    }

    public void levelFadeOutToGame(){
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(levelStageStackPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(event ->{
            gameSceneSet();
        });
        fadeTransition.play();
    }

    private void gameSceneSet() {
        nowStage=(Stage) oneButton.getScene().getWindow();
        FXMLLoader loader = null;
        try {
//            loader = new FXMLLoader(new File("C:\\Users\\ali\\IdeaProjects\\graphicProject\\properties\\fxml\\game.fxml").toURI().toURL());
            loader = new FXMLLoader(new File("C:\\Users\\Mr Ostadi\\IdeaProjects\\graphicProject\\properties\\fxml\\game.fxml").toURI().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("1 : "+e.getMessage());
        }
        Parent root = null;
        try {
            root = loader.load();
            gameStageStackPane=(StackPane) root;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("2 : "+e.getMessage());
        }
        gameStageStackPane.setOpacity(0);
        nowStage.setTitle("Farm Frenzy");
        gameFadeIn();
        nowStage.setScene(new Scene(root, 1300, 700));
    }

    private void gameFadeIn() {
     //   Manger manger=new Manger();
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setNode(gameStageStackPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setDuration(Duration.millis(2000));
        fadeTransition.play();
    }
}
