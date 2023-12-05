

package Modelo;

import java.time.LocalDate;
import java.util.Date;

/**A classe a seguir é o modelo filho de EquipeM que representa a equipe de execução do projeto.
 * Possui todas as variáveis de EquipeM.
 * cargoEmpresa: String que representa o cargo do integrante dentro da empresa.
 * Métodos: Construtores com e sem passagem de paramêtros, Getters e setter de todas as variáveis.
 */
public class EquipeExecM extends EquipeM{
    
    private String cargoEmpresa;

    public EquipeExecM(String cargoEmpresa, String Integrantes, String ResponsavelGeral, String ResponsaveisEtapa, LocalDate inicioEtapa, LocalDate fimEtapa, int Etapa) {
        super(Integrantes, ResponsavelGeral, ResponsaveisEtapa, inicioEtapa, fimEtapa, Etapa);
        this.cargoEmpresa = cargoEmpresa;
    }

    /**Método que resgata o cargo do integrante dentro a empresa
     * @return String
     */
    public String getCargoEmpresa() {
        return cargoEmpresa;
    }
    /**Método que adiciona o cargo do integrante dentro a empresa  
     * @param cargoEmpresa 
     */
    public void setCargoEmpresa(String cargoEmpresa) {
        this.cargoEmpresa = cargoEmpresa;
    }
    
    
}
