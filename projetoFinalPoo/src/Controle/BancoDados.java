package controle;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rf5974
 */
public class BancoDados {
      // Objeto de COnexÃ£o com BD
    public Connection conn;
    // Objeto de Consulta SQL
    public Statement stmt;
    // Objeto com dados SQL
    private ResultSet res;
    
    public void conexao(){
       try
       {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(
               "jdbc:postgresql://localhost:5432/sisProjeto","postgres", "Receba321@");
        //System.out.println("Conectado ao PostGreSQL.");  //remover esse system out depois      
        }catch(Exception e){
            System.out.println("Falha ao tentar a conexÃ£o");
            e.printStackTrace();
        }
       
       try{
           stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);      
       }catch(Exception e){
           System.out.println("Falha no Cursor de ExecuÃ§Ã£o");
           e.printStackTrace();
       }
    }
    
     public Connection getConnection(){
        return conn;
    }
    
    public Statement getStatement(){
        return stmt;
    }
    
    public void desconecta(){
        if(conn != null){
            try{
                conn.close();
               // System.out.println("Desconectado do Banco de dados :)"); //remover esse system out depois    
            }catch(SQLException erro){
                erro.printStackTrace();
            }
            
        }
    }
}