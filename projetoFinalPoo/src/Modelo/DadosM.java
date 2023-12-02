/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author vinim
 */
public class DadosM {
    private String pessoaJuridica,
            modeloGestao,
            impacto,
            risco,
            causa,
            atividadeTecnologia;
    private int etapa;
    private double medicao;
    private Date geral, 
            atual, 
            ajustes;
    private ProjetoM projeto = new ProjetoM();

    public DadosM() {
    
    }
    
    public DadosM(String pessoaJuridica, String modeloGestao, String impacto, String risco, String causa, String atividadeTecnologia, int etapa, double medicao, Date geral, Date atual, Date ajustes) {
        this.pessoaJuridica = pessoaJuridica;
        this.modeloGestao = modeloGestao;
        this.impacto = impacto;
        this.risco = risco;
        this.causa = causa;
        this.atividadeTecnologia = atividadeTecnologia;
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

    public Date getGeral() {
        return geral;
    }

    public void setGeral(Date geral) {
        this.geral = geral;
    }

    public Date getAtual() {
        return atual;
    }

    public void setAtual(Date atual) {
        this.atual = atual;
    }

    public Date getAjustes() {
        return ajustes;
    }

    public void setAjustes(Date ajustes) {
        this.ajustes = ajustes;
    }

    public ProjetoM getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoM projeto) {
        this.projeto = projeto;
    }

}
  