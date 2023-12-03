

package Modelo;

import java.time.LocalDate;
import java.util.Date;


public class EquipeTerceirizadoM extends EquipeM{
    
    private String empresa;

    public EquipeTerceirizadoM(String empresa, String Integrantes, String ResponsavelGeral, String ResponsaveisEtapa, LocalDate inicioEtapa, LocalDate fimEtapa, int Etapa) {
        super(Integrantes, ResponsavelGeral, ResponsaveisEtapa, inicioEtapa, fimEtapa, Etapa);
        this.empresa = empresa;
    }

   

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    
    
}
