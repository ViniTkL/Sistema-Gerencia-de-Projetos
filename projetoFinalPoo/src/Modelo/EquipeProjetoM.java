
package Modelo;

import java.time.LocalDate;
import java.util.Date;

/**  A classe a seguir é o modelo filho de EquipeM que representa a equipe de gerenciamento do projeto.
 * Possui todas as variáveis de EquipeM.
 * cargoProjeto: String que representa o cargo no projeto de determinado integrante.
 * Métodos: Construtores com e sem passagem de paramêtros, Getters e setter de todas as variáveis.
 */
public class EquipeProjetoM extends EquipeM{
   
    private String cargoProjeto;

    public EquipeProjetoM(String cargoProjeto, String Integrantes, String ResponsavelGeral, String ResponsaveisEtapa, LocalDate inicioEtapa, LocalDate fimEtapa, int Etapa) {
        super(Integrantes, ResponsavelGeral, ResponsaveisEtapa, inicioEtapa, fimEtapa, Etapa);
        this.cargoProjeto = cargoProjeto;
    }

  
    
    /**Método que resgata o cargo do integrante
     * @return String
     */
    public String getCargoProjeto() {
        return cargoProjeto;
    }
    /**Método que adiciona o cargo do integrante
     * @param cargoProjeto 
     */
    public void setCargoProjeto(String cargoProjeto) {
        this.cargoProjeto = cargoProjeto;
    }
    
    
    
    
}
