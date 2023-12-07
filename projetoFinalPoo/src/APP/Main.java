package APP;

import Visualizacao.Menu;

/**A seguinte classe é responsável por compilar e rodas as funções de todas as outras classes do projeto
 * 
 */
public class Main {

    /**Classe principal que executará as rotinas das outras classes através da objeto da classe Menu;
     * 
     * @param args argumentos passados pelo usuário em formato de input
     */
    public static void main(String[] args) {
        Menu menus = new Menu();
        
        menus.menuGeral();
    }
    
}
