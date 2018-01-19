package biblioteca.model.dao;

import biblioteca.model.domain.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class livroDAO {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean insertBook(Book book){
        String sql = "INSERT INTO livro(id, title, author, publisher, isAvail) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, book.getId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getPublisher());
            stmt.setBoolean(5,true);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(livroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
