package Modelo;

/** A classe a seguir é o modelo do projeto.
 * nomeProjeto: String que representa o nome do projeto.
 * escopo:  String que representao resumo das especificações e objetivo do projeto.
 * stakeholders: String que representa as partes interessadas do projeto.
 * custoOrcado:  double que representa o valor total que será gasto com o projeto.
 * custoAprovado:  double que representa o valor aprovado para a imediata criação do projeto.
 * equipeProjeto: EquipeProjetoM que representa a equipe de gerenciamento do projeto.
 * equipeExec: EquipeExecM que representa a equipe de execução do projeto.
 * equipeTerc: EquipeTerceirizadoM que representa integrantes de empresas terceiras na equipe.
 * Métodos: Construtores com e sem passagem de paramêtros, Getters e setter de todas as variáveis.
 */
public class ProjetoM {
    private String nomeProjeto,
            escopo,
            stakeholders;
    private double custoOrcado, custoAprovado;
    private EquipeProjetoM equipeProjeto;
    private EquipeExecM equipeExec;
    private EquipeTerceirizadoM equipeTerc;

    public ProjetoM(String nomeProjeto, String escopo, String stakeholders, double custoOrcado, double custoAprovado, EquipeProjetoM equipeProjeto, EquipeExecM equipeExec, EquipeTerceirizadoM equipeTerc) {
        this.nomeProjeto = nomeProjeto;
        this.escopo = escopo;
        this.stakeholders = stakeholders;
        this.custoOrcado = custoOrcado;
        this.custoAprovado = custoAprovado;
        this.equipeProjeto = equipeProjeto;
        this.equipeExec = equipeExec;
        this.equipeTerc = equipeTerc;
    }

    public ProjetoM() {
    }
    
    /** método para resgatar o nome do projeto
     * @return String
     */
    public String getNomeProjeto() {
        return nomeProjeto;
    }
    /**
     * @param nomeProjeto String que representa o nome do projeto
     */
    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }
    /**Método para resgata o resumo/escopo do projeto
     * @return String
     */
    public String getEscopo() {
        return escopo;
    }
    /**Método para adicionar o escopo/resumo do projeto
     * @param escopo String que representa o resumo/escopo do projeto
     */
    public void setEscopo(String escopo) {
        this.escopo = escopo;
    }
    /**Método que resgata os stakeholders do projeto
     * @return  String
     */
    public String getStakeholders() {
        return stakeholders;
    }
    /** método que adiciona os stakeholders do projeto
     * @param stakeholders String que reprsenta os stakeholders
     */
    public void setStakeholders(String stakeholders) {
        this.stakeholders = stakeholders;
    }
    /**Método que resgata o custo orçado do projeto
     * @return double
     */
    public double getCustoOrcado() {
        return custoOrcado;
    }
    /**método que adiciona o custo orçado do projeto
     * @param custoOrcado 
     */
    public void setCustoOrcado(double custoOrcado) {
        this.custoOrcado = custoOrcado;
    }
    /**método que adiciona custos aprovados do projeto
     * @return double
     */
    public double getCustoAprovado() {
        return custoAprovado;
    }
    /**método que adiciona os custos aprovados do projeto
     * @param custoAprovado 
     */
    public void setCustoAprovado(double custoAprovado) {
        this.custoAprovado = custoAprovado;
    }
    /**método que resgata os integrantes da equipe de gerenciamento do projeto
     * @return EquipeProjetoM
     */
    public EquipeProjetoM getEquipeProjeto() {
        return equipeProjeto;
    }
    /**método que adiciona os integrantes da equipe de gerenciamento do projeto
     * @param equipeProjeto 
     */
    public void setEquipeProjeto(EquipeProjetoM equipeProjeto) {
        this.equipeProjeto = equipeProjeto;
    }
    /**método que resgata os integrantes da equipe de execução do projeto
     * @return EquipeExecM
     */
    public EquipeExecM getEquipeExec() {
        return equipeExec;
    }
    /**método que adiciona os integrantes da equipe de execução do projeto
     * @param equipeExec 
     */
    public void setEquipeExec(EquipeExecM equipeExec) {
        this.equipeExec = equipeExec;
    }
    /**método que resgata os integrantes terceirizados do projeto
     * @return EquipeTerceirizadoM
     */
    public EquipeTerceirizadoM getEquipeTerc() {
        return equipeTerc;
    }
    /**método que adiciona os integrantes terceirizados do projeto
     * @param equipeTerc 
     */
    public void setEquipeTerc(EquipeTerceirizadoM equipeTerc) {
        this.equipeTerc = equipeTerc;
    }
    
    
    
}
