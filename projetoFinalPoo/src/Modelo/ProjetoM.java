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

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getEscopo() {
        return escopo;
    }

    public void setEscopo(String escopo) {
        this.escopo = escopo;
    }

    public String getStakeholders() {
        return stakeholders;
    }

    public void setStakeholders(String stakeholders) {
        this.stakeholders = stakeholders;
    }

    public double getCustoOrcado() {
        return custoOrcado;
    }

    public void setCustoOrcado(double custoOrcado) {
        this.custoOrcado = custoOrcado;
    }

    public double getCustoAprovado() {
        return custoAprovado;
    }

    public void setCustoAprovado(double custoAprovado) {
        this.custoAprovado = custoAprovado;
    }

    public EquipeProjetoM getEquipeProjeto() {
        return equipeProjeto;
    }

    public void setEquipeProjeto(EquipeProjetoM equipeProjeto) {
        this.equipeProjeto = equipeProjeto;
    }

    public EquipeExecM getEquipeExec() {
        return equipeExec;
    }

    public void setEquipeExec(EquipeExecM equipeExec) {
        this.equipeExec = equipeExec;
    }

    public EquipeTerceirizadoM getEquipeTerc() {
        return equipeTerc;
    }

    public void setEquipeTerc(EquipeTerceirizadoM equipeTerc) {
        this.equipeTerc = equipeTerc;
    }
    
    
    
}
