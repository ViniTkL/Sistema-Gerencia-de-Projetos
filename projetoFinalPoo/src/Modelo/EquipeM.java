
package Modelo;

import java.time.LocalDate;
import java.util.Date;


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
