package Modelo;

import java.time.LocalDate;
import java.util.Date;


/** A classe a seguir é o modelo das informações contidas no projeto.
 * pessoaJuridica: String que representa o cnpj da empresa responsável pelo projeto.
 * modeloGestao:  String que representa o modelo de gestão que a empresa está utilizando neste projeto.
 * impacto: String que representa o impacto da mudança feita no cronograma geral.
 * risco:  String que representa o risco que a mudança no cronograma geral têm.
 * causa:  String que representa a causa/motivo da mudança no cronograma geral.
 * atividadeTecnologia:  String que representa a(s) tecnologias e atividades empregradas no projeto.
 * nomeEtapa: String que representa o nome das etapas do projeto.
 * etapa: int que representa o número da etapa do projeto. Ex.: etapa 4 - nome etapa.
 * medicao: double que representa o valor pago na medição de determinada etapa do porjeto.
 * geral: LocalDate que representa o cronograma geral.
 * atual: LocalDate que representa o cronograma atual.
 * ajustes:  LocalDate que representa o ajuste do cronograma.
 * projeto: Objeto que representa as informações relacionadas a um projeto específico.
 * Métodos: Construtores com e sem passagem de paramêtros, Getters e setter de todas as variáveis.
 */
public class DadosM {
    private String pessoaJuridica,
            modeloGestao,
            impacto,
            risco,
            causa,
            atividadeTecnologia,
            nomeEtapa;
    private int etapa;
    private double medicao;
    private LocalDate geral, 
            atual, 
            ajustes;
    private ProjetoM projeto = new ProjetoM();

    public DadosM() {
    }

    public DadosM(String pessoaJuridica, String modeloGestao, String impacto, String risco, String causa, String atividadeTecnologia, String nomeEtapa, int etapa, double medicao, LocalDate geral, LocalDate atual, LocalDate ajustes) {
        this.pessoaJuridica = pessoaJuridica;
        this.modeloGestao = modeloGestao;
        this.impacto = impacto;
        this.risco = risco;
        this.causa = causa;
        this.atividadeTecnologia = atividadeTecnologia;
        this.nomeEtapa = nomeEtapa;
        this.etapa = etapa;
        this.medicao = medicao;
        this.geral = geral;
        this.atual = atual;
        this.ajustes = ajustes;
    }

    

    public String getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(String pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public String getModeloGestao() {
        return modeloGestao;
    }

    public void setModeloGestao(String modeloGestao) {
        this.modeloGestao = modeloGestao;
    }

    public String getImpacto() {
        return impacto;
    }

    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getAtividadeTecnologia() {
        return atividadeTecnologia;
    }

    public void setAtividadeTecnologia(String atividadeTecnologia) {
        this.atividadeTecnologia = atividadeTecnologia;
    }

    public int getEtapa() {
        return etapa;
    }

    public void setEtapa(int etapa) {
        this.etapa = etapa;
    }

    public double getMedicao() {
        return medicao;
    }

    public void setMedicao(double medicao) {
        this.medicao = medicao;
    }

    public LocalDate getGeral() {
        return geral;
    }

    public void setGeral(LocalDate geral) {
        this.geral = geral;
    }

    public LocalDate getAtual() {
        return atual;
    }

    public void setAtual(LocalDate atual) {
        this.atual = atual;
    }

    public LocalDate getAjustes() {
        return ajustes;
    }

    public void setAjustes(LocalDate ajustes) {
        this.ajustes = ajustes;
    }

    public ProjetoM getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoM projeto) {
        this.projeto = projeto;
    }

    public String getNomeEtapa() {
        return nomeEtapa;
    }

    public void setNomeEtapa(String nomeEtapa) {
        this.nomeEtapa = nomeEtapa;
    }
   
}
  