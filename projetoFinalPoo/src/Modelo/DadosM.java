/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
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
  