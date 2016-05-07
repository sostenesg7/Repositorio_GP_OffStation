package projetos.gerencia.apresentacao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ui/FXML_FormLogin.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("LOGIN");
        
        stage.getIcons().add(new Image(getClass().getResourceAsStream("ui/icone.png")));
        
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
