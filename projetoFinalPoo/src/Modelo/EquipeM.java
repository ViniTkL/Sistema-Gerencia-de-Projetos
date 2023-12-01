
package Modelo;

import java.util.Date;


public class EquipeM {
   
    private String Integrantes;
    private String ResponsavelGeral;
    private String ResponsaveisEtapa;
    private Date inicioEtapa;
    private Date fimEtapa;
    private int Etapa;

    public EquipeM(String Integrantes, String ResponsavelGeral, String ResponsaveisEtapa, Date inicioEtapa, Date fimEtapa, int Etapa) {
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

    public Date getInicioEtapa() {
        return inicioEtapa;
    }

    public void setInicioEtapa(Date inicioEtapa) {
        this.inicioEtapa = inicioEtapa;
    }

    public Date getFimEtapa() {
        return fimEtapa;
    }

    public void setFimEtapa(Date fimEtapa) {
        this.fimEtapa = fimEtapa;
    }

    public int getEtapa() {
        return Etapa;
    }

    public void setEtapa(int Etapa) {
        this.Etapa = Etapa;
    }
    
    
    
    
    
    
}
