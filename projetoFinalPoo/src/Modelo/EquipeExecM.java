

package Modelo;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author anton
 */
public class EquipeExecM extends EquipeM{
    
    private String cargoEmpresa;

    public EquipeExecM(String cargoEmpresa, String Integrantes, String ResponsavelGeral, String ResponsaveisEtapa, LocalDate inicioEtapa, LocalDate fimEtapa, int Etapa) {
        super(Integrantes, ResponsavelGeral, ResponsaveisEtapa, inicioEtapa, fimEtapa, Etapa);
        this.cargoEmpresa = cargoEmpresa;
    }

    

    public String getCargoEmpresa() {
        return cargoEmpresa;
    }

    public void setCargoEmpresa(String cargoEmpresa) {
        this.cargoEmpresa = cargoEmpresa;
    }
    
    
}
