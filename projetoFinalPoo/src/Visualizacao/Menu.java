package Visualizacao;

import Controle.DadosC;
import java.util.Scanner;


public class Menu {
    DadosC dadosGerais = new DadosC();
 

public void menuGeral(){
    Scanner scan = new Scanner(System.in);
                
        int resp = 0;
        while(resp != -1){
            System.out.println("-----------------------SISTEMA GERENCIA PROJETOS-------------------------");
            System.out.print("1 - Cadastrar informações do projeto\n2 - Atualizar informações do projeto\n3 - Consultar Projeto\n-1 - sair\nEscolha: ");
            resp = scan.nextInt();
            
            switch (resp) {
                case 1 -> {
                    menuCadastrar();
                }
                case 2 -> {
                    menuAtualizar();
                }
                case 3 -> {
                    menuConsulta();
                }
                case -1 -> {
                    System.out.println("saindo...");
                }
                default -> {
                    System.out.println("Valor inválido.");
                }
            }
        }
}

public void menuCadastrar(){
    Scanner scan = new Scanner(System.in);
                
        int resp = 0;
        while(resp != -1){
            System.out.println("-----------------------MENU DE CADASTRO-------------------------");
            System.out.print("1 - Cadastrar Projeto\n2 - Cadastrar dados gerais do projeto\n3 - Cadastrar equipe e seus integrantes\n4 - Cadastrar medição paga\n5 - Cadastrar cronograma\n-1 - voltar ao menu principal\nEscolha: ");
            resp = scan.nextInt();
            
            switch (resp) {
                case 1 -> {
                    dadosGerais.getProjetoInfo().cadastrarProjeto();
                }
                case 2 -> {
                    dadosGerais.cadastroDadosGerais();
                }
                case 3-> {
                    dadosGerais.getProjetoInfo().getEquipeProjetoGerencia().cadastrarEquipe();
                    //equipeProjetoGerencia.cadastrarEquipe();
                    escolherTipoEquipeCadastrar();
                }
                case 4 -> {
                    dadosGerais.pagarMedicao();
                }
                case 5 ->{
                    dadosGerais.cadastrarCronograma();
                }
                case -1 -> {
                    System.out.println("voltando ao menu principal...");
                }
                default -> {
                    System.out.println("Valor inválido.");
                } 
            }
        }
}

public void escolherTipoEquipeCadastrar(){
        Scanner scan = new Scanner(System.in);
        
        int resp = 0,id = 0;
        
        System.out.println("Digite o id da equipe que terá seus integrantes inseridos: ");
        id = scan.nextInt();
        
        while(resp != -1){
            System.out.println("-----------------------Cadastro de integrantes-------------------------");
            System.out.print("1 - Cadastrar integrante de gerencia de projeto\n2 -Cadastrar integrante de execução de projeto\n3 - Cadastrar integrante terceirizado\n-1 - voltar ao menu principal\nEscolha: ");
            resp = scan.nextInt();
            
            switch (resp) {
                case 1 -> {
                    dadosGerais.getProjetoInfo().getEquipeProjetoGerencia().cadastrarIntegrante(id);
                    //equipeProjetoGerencia.cadastrarIntegrante(id);
                }
                case 2 -> {
                    dadosGerais.getProjetoInfo().getEquipeProjetoExec().cadastrarIntegrante(id);
                    //equipeProjetoExec.cadastrarIntegrante(id);
                }
                case 3-> {
                    dadosGerais.getProjetoInfo().getEquipeProjetoTerc().cadastrarIntegrante(id);
                    //equipeProjetoTerc.cadastrarIntegrante(id);
                }
                case -1 -> {
                    System.out.println("voltando ao menu principal...");
                }
                default -> {
                    System.out.println("Valor inválido.");
                } 
            }
        }
}

public void menuAtualizar(){
    Scanner scan = new Scanner(System.in);
                
        int resp = 0;
        while(resp != -1){
            System.out.println("-----------------------MENU DE ATUALIZAÇÃO-------------------------");
            System.out.print("1 - Ajustar cronograma\n-1 - voltar ao menu principal\nEscolha: ");
            resp = scan.nextInt();
            
            switch (resp) {
                case 1 -> {
                    dadosGerais.ajustarCronograma();
                }
                case -1 -> {
                    System.out.println("Voltando ao menu principal...");
                }
                default -> {
                    System.out.println("Valor inválido.");
                }
            }
        }
}

public void menuConsulta(){
    Scanner scan = new Scanner(System.in);
        
    System.out.print("Digite o nome do projeto que deseja conultar: ");
        String nomeProjeto = scan.nextLine().toUpperCase();
    
        int resp = 0;
        while(resp != -1){
            System.out.println("-----------------------CONSULTA DE PROJETOS-------------------------");
            System.out.println("1 - Consultar informações gerais do projeto\n2 - consultar equipe do projeto\n3 - consultar cronograma geral\n4 - consultar ajustes do cronograma\n-1 - voltar ao menu principal");
            resp = scan.nextInt();
            
            switch (resp) {
                case 1 -> {
                    dadosGerais.getProjetoInfo().consultarInformaçõesProjeto(nomeProjeto);
                    dadosGerais.consultarInfomaçõesGerais(nomeProjeto);
                }
                case 2 -> {
                    dadosGerais.getProjetoInfo().getEquipeProjetoGerencia().resgatarEquipe(nomeProjeto);
                    //equipeProjetoGerencia.resgatarEquipe(nomeProjeto);
                }
                case 3 -> {
                    dadosGerais.resgatarCronograma(nomeProjeto);
                }
                case 4 -> {
                    dadosGerais.resgatarAjusteCronograma(nomeProjeto);
                }
                case -1 -> {
                    System.out.println("voltando ao menu principal...");
                }
                default -> {
                    System.out.println("Valor inválido.");
                }
            }
        }
}



}
