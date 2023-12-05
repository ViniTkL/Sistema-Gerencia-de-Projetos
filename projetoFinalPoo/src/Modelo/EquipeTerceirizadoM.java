

package Modelo;

import java.time.LocalDate;
import java.util.Date;

/** A classe a seguir é o modelo filho de EquipeM que representa a equipe terceirizada.
 * Possui todas as variáveis de EquipeM.
 * empresa: String que representa de que empresa terceirizada o funcionário veio.
 * Métodos: Construtores com e sem passagem de paramêtros, Getters e setter de todas as variáveis.
 */
public class EquipeTerceirizadoM extends EquipeM{
    
    private String empresa;

    public EquipeTerceirizadoM(String empresa, String Integrantes, String ResponsavelGeral, String ResponsaveisEtapa, LocalDate inicioEtapa, LocalDate fimEtapa, int Etapa) {
        super(Integrantes, ResponsavelGeral, ResponsaveisEtapa, inicioEtapa, fimEtapa, Etapa);
        this.empresa = empresa;
    }

   
    /**Método que resgata de qual empresa terceirizada o integrante veio
     * @return String
     */
    public String getEmpresa() {
        return empresa;
    }
    /**Método que adiciona de qual empresa terceirizada o integrante veio
     * @param empresa 
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    
    
}
