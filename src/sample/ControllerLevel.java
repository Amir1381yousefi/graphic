package sample;

import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

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
    alertLockLevel alertLockLevel=new alertLockLevel();

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
    }

    public void scondMouseClicked(ActionEvent actionEvent) {
        if (getMaxLevel()<2){
            alertLockLevel.alertLockLevel();
        }
    }

    public void fourthMouseClicked(ActionEvent actionEvent) {
        if (getMaxLevel()<3){
            alertLockLevel.alertLockLevel();
        }
    }

    public void fifthMouseClicked(ActionEvent actionEvent) {
        if (getMaxLevel()<4){
            alertLockLevel.alertLockLevel();
        }
    }

    public void thirdMouseClicked(ActionEvent actionEvent) {
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
}
