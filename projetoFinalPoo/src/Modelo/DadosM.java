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

    
    /** método para resgatar o cnpj do projeto
     * @return String
    */
    public String getPessoaJuridica() {
        return pessoaJuridica;
    }
    /** método para adicionar o cnpj do projeto
     * @param pessoaJuridica cnpj do projeto
    */
    public void setPessoaJuridica(String pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }
    /** método para resgatar o modelo de gestão do projeto
     * @return String
    */
    public String getModeloGestao() {
        return modeloGestao;
    }
    /** método para adicionar o modelo gestão do projeto
     * @param modeloGestao modelo de gestão em formato String
    */
    public void setModeloGestao(String modeloGestao) {
        this.modeloGestao = modeloGestao;
    }
    /** método para resgatar o impacto da alteração no cronograma do projeto
     * @return String
    */
    public String getImpacto() {
        return impacto;
    }
    /** método para adicionar o impacto da alteração no cronograma do projeto
     * @param impacto String do impacto causado com a alteração
    */
    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }
    /** método para resgatar o risco da alteração no cronograma do projeto
     * @return String
    */
    public String getRisco() {
        return risco;
    }
    /** método para adicionar o impacto da alteração no cronograma do projeto
     * @param risco String do risco da alteração
    */
    public void setRisco(String risco) {
        this.risco = risco;
    }
    /** método para resgatar o motivo da alteração no cronograma do projeto
     * @return String
    */
    public String getCausa() {
        return causa;
    }
    /** método para adicionar o motivo da alteração no cronograma do projeto
     * @param causa String do motivo da alteração
    */
    public void setCausa(String causa) {
        this.causa = causa;
    }
    /** método para resgatar as tecnologias e/ou atividades do projeto
     * @return String
    */
    public String getAtividadeTecnologia() {
        return atividadeTecnologia;
    }
    /** método para adicionar as tecnologias e/ou atividades do projeto
     * @param atividadeTecnologia String das atividades e/ou tecnologias do projeto
    */
    public void setAtividadeTecnologia(String atividadeTecnologia) {
        this.atividadeTecnologia = atividadeTecnologia;
    }
    /** método para resgatar as etapas do projeto
     * @return int
    */
    public int getEtapa() {
        return etapa;
    }
    /** método para adicionar as etapas do projeto
     * @param etapa valor int do número da etapa
    */
    public void setEtapa(int etapa) {
        this.etapa = etapa;
    }
    /** método para resgatar o valor das medições do projeto
     * @return double
    */
    public double getMedicao() {
        return medicao;
    }
    /** método para adicionar o valor das medições do projeto
     * @param medicao double do valor pago na medição
    */
    public void setMedicao(double medicao) {
        this.medicao = medicao;
    }
    /** método para resgatar as data do cronograma geral do projeto
     * @return LocalDate
    */
    public LocalDate getGeral() {
        return geral;
    }
    /** método para adicionar as data do cronograma geral do projeto
     * @param geral LocalDate do cronograma geral
    */
    public void setGeral(LocalDate geral) {
        this.geral = geral;
    }
    /** método para resgatar as data do cronograma atual do projeto
     * @return LocalDate
    */
    public LocalDate getAtual() {
        return atual;
    }
    /** método para adicionar as data do cronograma geral do projeto
     * @param atual LocalDate do cronograma atual
    */
    public void setAtual(LocalDate atual) {
        this.atual = atual;
    }
    /** método para resgatar as data ajustadas cronograma geral do projeto
     * @return  LocalDate
    */
    public LocalDate getAjustes() {
        return ajustes;
    }
    /** método para adicionar as data ajustadas cronograma geral do projeto
     * @param ajustes LocalDate das datas ajustadas
    */
    public void setAjustes(LocalDate ajustes) {
        this.ajustes = ajustes;
    }
    /** método para resgatar o objeto do projeto
     * @return ProjetoM
    */
    public ProjetoM getProjeto() {
        return projeto;
    }
    /** método para adicionar o objeto do projeto
     * @param projeto objeto da classe ProjetoM, responsável por representar as informações do projeto
    */
    public void setProjeto(ProjetoM projeto) {
        this.projeto = projeto;
    }
    /** método para resgatar o nome da etapa do projeto
     * @return String
    */
    public String getNomeEtapa() {
        return nomeEtapa;
    }
    /** método para adicionar o nome da etapa do projeto
     * @param nomeEtapa String que representa o nome da etapa
    */
    public void setNomeEtapa(String nomeEtapa) {
        this.nomeEtapa = nomeEtapa;
    }
   
}
  