package biblioteca;



import biblioteca.model.database.SQLite;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BibliotecaJavaFX extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("view/FormAddBook.fxml"));
        stage.initStyle(StageStyle.UTILITY);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();        
        
        //Cria uma thread que gera a conexao com o bd, apos isso sera utilizado apenas a mesma instancia
        new Thread(new Runnable() {
            @Override
            public void run() {
                SQLite.getInstance();
            }
        }).start(); 
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
