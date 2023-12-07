
package Controle;

import Modelo.EquipeExecM;
import Modelo.EquipeProjetoM;
import Modelo.EquipeTerceirizadoM;

/**
 * A classe EquipeC é responsável por controlar as operações relacionadas à equipe de um projeto,
 * como cadastrar equipes, integrantes, responsáveis por etapa e salvar informações no banco de dados.
 * As subclasses (EquipeProjetoC, EquipeExecC, EquipeTerceirizadoC) utilizarão os métodos desta classe.
 * 
 */
public class EquipeC {
    
     /**
     * Cadastra uma equipe no sistema.
     */
    public void cadastrarEquipe(){ }

      /**
     * Método genérico para cadastrar integrantes em uma equipe.
     * 
     * @param idEquipe ID da equipe a ser associada.
     */
    public void cadastrarIntegrante(int idEquipe){ }
    
     /**
     * Adiciona integrantes a uma equipe.
     * 
     * @param qtde Quantidade de integrantes a serem adicionados.
     * @param id ID da equipe.
     */
    public void adicionarIntegrantes(int qtde, int id){ }
    
       /**
     * Cadastra os responsáveis por uma etapa na equipe.
     * 
     * @param eResponsavelEtapa Caractere indicando a responsabilidade pela etapa.
     */
    public void cadastrarResponsaveisEtapa(char eResponsavelEtapa){}
     
    
        /**
     * Salva as informações da equipe no sistema.
     * 
     * @param id ID da equipe.
     * @param respGeral Responsável geral pela equipe.
     */
    public void salvarEquipe(int id, String respGeral){}
    
    
     /**
     * Salva as informações do integrante da equipe no sistema.
     * 
     * @param id ID do integrante.
     * @param nomeIntegrante Nome do integrante.
     */
    public void salvarEquipeIntegrante(int id, String nomeIntegrante){}
    
    /**
     * Salva as informações do projeto associadas à equipe no sistema.
     * 
     * @param id ID do projeto associado à equipe.
     * @param nomeProjeto Nome do projeto.
     */ 
    public void salvarEquipeProjeto(int id, String nomeProjeto){}
    
       /**
     * Salva os integrantes da equipe no sistema.
     * 
     * @param eResponsavelEtapa Caractere indicando a responsabilidade pela etapa.
     * @param equipe Objeto da classe EquipeProjetoM.
     */
    public void salvarIntegrantes(char eResponsavelEtapa, EquipeProjetoM equipe){}
    
     /**
     * Salva os integrantes da equipe executiva no sistema.
     * 
     * @param eResponsavelEtapa Caractere indicando a responsabilidade pela etapa.
     * @param equipe Objeto da classe EquipeExecM.
     */
    public void salvarIntegrantes(char eResponsavelEtapa, EquipeExecM equipe){}
    
     /**
     * Salva os integrantes da equipe terceirizada no sistema.
     * 
     * @param eResponsavelEtapa Caractere indicando a responsabilidade pela etapa.
     * @param equipe Objeto da classe EquipeTerceirizadoM.
     * @param cargoTerc Cargo do terceirizado.
     */
    public void salvarIntegrantes(char eResponsavelEtapa, EquipeTerceirizadoM equipe, String cargoTerc){}
    
    
        /**
     * Resgata informações sobre a equipe de um projeto.
     * 
     * @param nomeProjeto Nome do projeto.
     */
    public void resgatarEquipe(String nomeProjeto){}
    
   
}
