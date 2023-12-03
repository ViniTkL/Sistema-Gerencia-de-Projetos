
package Modelo;

import java.time.LocalDate;
import java.util.Date;


public class EquipeProjetoM extends EquipeM{
   
    private String cargoProjeto;

    public EquipeProjetoM(String cargoProjeto, String Integrantes, String ResponsavelGeral, String ResponsaveisEtapa, LocalDate inicioEtapa, LocalDate fimEtapa, int Etapa) {
        super(Integrantes, ResponsavelGeral, ResponsaveisEtapa, inicioEtapa, fimEtapa, Etapa);
        this.cargoProjeto = cargoProjeto;
    }

  
    

    public String getCargoProjeto() {
        return cargoProjeto;
    }

    public void setCargoProjeto(String cargoProjeto) {
        this.cargoProjeto = cargoProjeto;
    }
    
    
    
    
}
