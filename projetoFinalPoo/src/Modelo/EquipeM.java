
package Modelo;

import java.time.LocalDate;
import java.util.Date;

/** A classe a seguir é o modelo base das quipes contidas no projeto.
 * Integrantes: String que representa o nome do projeto.
 * ResponsavelGeral:  String que representa o modelo de gestão que a empresa está utilizando neste projeto.
 * ResponsaveisEtapa: String que representa o impacto da mudança feita no cronograma geral.
 * etapa: int que representa o número da etapa do projeto. Ex.: etapa 4.
 * inicioEtapa: LocalDate que representa o cronograma geral.
 * fimEtapa: LocalDate que representa o cronograma atual.
 * Métodos: Construtores com e sem passagem de paramêtros, Getters e setter de todas as variáveis.
 */
public class EquipeM {
   
    private String Integrantes;
    private String ResponsavelGeral;
    private String ResponsaveisEtapa;
    private LocalDate inicioEtapa;
    private LocalDate fimEtapa;
    private int Etapa;

    public EquipeM(String Integrantes, String ResponsavelGeral, String ResponsaveisEtapa, LocalDate inicioEtapa, LocalDate fimEtapa, int Etapa) {
        this.Integrantes = Integrantes;
        this.ResponsavelGeral = ResponsavelGeral;
        this.ResponsaveisEtapa = ResponsaveisEtapa;
        this.inicioEtapa = inicioEtapa;
        this.fimEtapa = fimEtapa;
        this.Etapa = Etapa;
    }
    /**método que resgata o integrantes da equipe
     * @return String
     */
    public String getIntegrantes() {
        return Integrantes;
    }
    /**Método que adiciona os integrantes da equipe
     * @param Integrantes 
     */
    public void setIntegrantes(String Integrantes) {
        this.Integrantes = Integrantes;
    }
    /** Método que adiciona o responsável geral da equipe
     * @return String
     */
    public String getResponsavelGeral() {
        return ResponsavelGeral;
    }
    /** Método que adiciona o responsável geral da equipe
     * @param ResponsavelGeral 
     */
    public void setResponsavelGeral(String ResponsavelGeral) {
        this.ResponsavelGeral = ResponsavelGeral;
    }
    /**Método que resgata os responsáveis por cada etapa do projeto
     * @return String
     */
    public String getResponsaveisEtapa() {
        return ResponsaveisEtapa;
    }
    /**Método que adiciona os responsáveis por cada etapa do projeto
     * @param ResponsaveisEtapa 
     */
    public void setResponsaveisEtapa(String ResponsaveisEtapa) {
        this.ResponsaveisEtapa = ResponsaveisEtapa;
    }
    /**Método que resgata o inicio da etapa
     * @return LocalData
     */
    public LocalDate getInicioEtapa() {
        return inicioEtapa;
    }
    /**Método que adiciona o inicio da etapa
     * @param inicioEtapa 
     */
    public void setInicioEtapa(LocalDate inicioEtapa) {
        this.inicioEtapa = inicioEtapa;
    }
    /**Método que resgata o fim da etapa
     * @return LocalDate
     */
    public LocalDate getFimEtapa() {
        return fimEtapa;
    }
    /**Método que adiciona o fim da etapa
     * @param fimEtapa 
     */
    public void setFimEtapa(LocalDate fimEtapa) {
        this.fimEtapa = fimEtapa;
    }
    /**Método que resgata a etapa do projeto
     * @return int
     */
    public int getEtapa() {
        return Etapa;
    }
    /** Método que adiciona a etapa do projeto
     * @param Etapa 
     */
    public void setEtapa(int Etapa) {
        this.Etapa = Etapa;
    }
    
    
    
    
    
    
}
