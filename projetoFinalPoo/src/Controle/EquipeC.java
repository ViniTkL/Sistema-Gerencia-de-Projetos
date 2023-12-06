
package Controle;

import Modelo.EquipeExecM;
import Modelo.EquipeProjetoM;
import Modelo.EquipeTerceirizadoM;

public class EquipeC {
    

    public void cadastrarEquipe(){ }
    //este métodod n vai ter nada aq porém as classes filhas vão utilizar
    public void cadastrarIntegrante(int idEquipe){ }
    
    public void adicionarIntegrantes(int qtde, int id){ }
    
    public void cadastrarResponsaveisEtapa(char eResponsavelEtapa){}
     
    public void salvarEquipe(int id, String respGeral){}
    
    public void salvarEquipeIntegrante(int id, String nomeIntegrante){}
    
    public void salvarEquipeProjeto(int id, String nomeProjeto){}
    
    public void salvarIntegrantes(char eResponsavelEtapa, EquipeProjetoM equipe){}
    
    public void salvarIntegrantes(char eResponsavelEtapa, EquipeExecM equipe){}
    
    public void salvarIntegrantes(char eResponsavelEtapa, EquipeTerceirizadoM equipe, String cargotTerc){}
    
    public void resgatarEquipe(String nomeProjeto){}
    
   
}
