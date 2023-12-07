package controle;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A seguinte classe é responsável por estabelecer e manter a conexão com o banco de dados no ambiente Java.
 * 
 */
public class BancoDados {
      // Objeto de COnexÃ£o com BD
    public Connection conn;
    // Objeto de Consulta SQL
    public Statement stmt;
    // Objeto com dados SQL
    private ResultSet res;
    
    /**
     * Este método estabelece a conexão com o banco de dados utilizando as credenciais fornecidas diretamente no método.
     */
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
    
    /**
     * @return Connection
     */
     public Connection getConnection(){
        return conn;
    }
    
     /**
      * 
      * @return Statement
      */
    public Statement getStatement(){
        return stmt;
    }
    
    /**
     * Este método fecha a conexao com banco de dados
     */
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