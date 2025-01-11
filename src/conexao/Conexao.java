package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * conexao
 */

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/Unip";
    private static final String user = "root";
    private static final String password = "12345";

    private static Connection conn;
    
    public static Connection getconexao(){

        try {
            
     
        if (conn == null) {
            System.out.println("Conexão sucedida!");
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        }else {
            return conn;
        }
    }catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
    }
}