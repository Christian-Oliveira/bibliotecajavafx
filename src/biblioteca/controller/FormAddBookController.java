package biblioteca.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

public class FormAddBookController implements Initializable {

    @FXML
    private JFXTextField txtFieldTitleBook;
    @FXML
    private JFXTextField txtFieldBookID;
    @FXML
    private JFXTextField txtFieldAuthor;
    @FXML
    private JFXTextField txtFieldPublisher;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnCancel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void handleSave(ActionEvent event) {
        if (validarDados()){
            
        }
    }

    @FXML
    private void handleCancel(ActionEvent event) {
        System.exit(0);
    }
    
    //Função para validar os dados
    public boolean validarDados(){
        if (txtFieldTitleBook.getText().isEmpty() || txtFieldBookID.getText().isEmpty() || txtFieldAuthor.getText().isEmpty() || txtFieldPublisher.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Livro não cadastrado!");
            alert.setContentText("Livro já cadastrado na base de dados.");
            return false;
        }else{
            return true;
        }
    }
    
}
