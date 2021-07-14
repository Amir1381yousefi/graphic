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
import java.util.regex.Pattern;

//

public class Controller {
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
    public String currentUserName;
    public Button oneButton;
    public Button twoButton;
    public Button fourButton;
    public Button fiveButton;
    public Button threeButton;

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
        nowStage=(Stage) loginButton.getScene().getWindow();
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
            currentUserName=username;
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
        System.out.println("cu : "+currentUserName);
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

    public void firstMouseClicked(ActionEvent actionEvent) {
        String url="jdbc:mysql://localhost:3306";
        String user="root";
        String password="@Mir1381";
        try {
            Connection connection=DriverManager.getConnection(url,user,password);
            Statement statement=connection.createStatement();
            String sql="select maxLevel from users.user where username='"+currentUserName+"'";
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getInt("maxLevel"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void scondMouseClicked(ActionEvent actionEvent) {
        System.out.println(currentUserName);
    }

    public void fourthMouseClicked(ActionEvent actionEvent) {
    }

    public void fifthMouseClicked(ActionEvent actionEvent) {
    }

    public void thirdMouseClicked(ActionEvent actionEvent) {
    }
}
