
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

    public String getIntegrantes() {
        return Integrantes;
    }

    public void setIntegrantes(String Integrantes) {
        this.Integrantes = Integrantes;
    }

    public String getResponsavelGeral() {
        return ResponsavelGeral;
    }

    public void setResponsavelGeral(String ResponsavelGeral) {
        this.ResponsavelGeral = ResponsavelGeral;
    }

    public String getResponsaveisEtapa() {
        return ResponsaveisEtapa;
    }

    public void setResponsaveisEtapa(String ResponsaveisEtapa) {
        this.ResponsaveisEtapa = ResponsaveisEtapa;
    }

    public LocalDate getInicioEtapa() {
        return inicioEtapa;
    }

    public void setInicioEtapa(LocalDate inicioEtapa) {
        this.inicioEtapa = inicioEtapa;
    }

    public LocalDate getFimEtapa() {
        return fimEtapa;
    }

    public void setFimEtapa(LocalDate fimEtapa) {
        this.fimEtapa = fimEtapa;
    }

    public int getEtapa() {
        return Etapa;
    }

    public void setEtapa(int Etapa) {
        this.Etapa = Etapa;
    }
    
    
    
    
    
    
}
