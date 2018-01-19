package biblioteca.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

public final class SQLite {
    
    private static SQLite handler;
    private static final String DB_URL = "jdbc:sqlite:bibliotecajavafx.db";
    private static Connection connection;

    private SQLite() {
        conectar();
    }
    
    //Verifica se a instancia ja existe, se existir retorna a mesma, senao cria uma nova
    public static SQLite getInstance() {
        if (handler == null)
            handler = new SQLite();
        return handler;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    //metodo para fazer a conexão com banco de dados
    public void conectar() {
        try {
            if (connection == null) {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(DB_URL);
                System.out.println("Conexão realizada com sucesso!");
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Conexão Falhou");
            alert.setHeaderText("Erro ao conectar com o Banco de dados!");
            alert.setContentText(""+e);
            Logger.getLogger(SQLite.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}