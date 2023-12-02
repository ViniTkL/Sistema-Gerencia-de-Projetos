/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DadosM;
import java.util.Scanner;

/**
 *
 * @author vinim
 */

//DEPOIS TEM QUE FAZER A DOCUMENTAÇÃO DA CLASSE
public class DadosC {
    DadosM informacoes = new DadosM();

    public DadosC() {
    
    }
    
    public void cadastraCNPJ(){
        Scanner scan = new Scanner(System.in);
        String cnpj = null;
        
        System.out.println("Digite o CNPJ da empresa responável pelo projeto: ");
        cnpj = removeCaracteresEspeciais(scan.nextLine());
        
        while(!verficaCnpj(cnpj)){
            System.out.println("Digite o CNPJ da empresa responável pelo projeto: ");
            cnpj = removeCaracteresEspeciais(  scan.nextLine());
        }
        
        informacoes.setPessoaJuridica(cnpj);
        
    }
    
    public String removeCaracteresEspeciais(String texto){
        return texto.replaceAll("[^0-9]+","");
    }
    
    public boolean verficaCnpj(String cnpj){
        if(cnpj.length() != 14){
            System.out.println("CNPJ INVÁLIDO, TENTE NOVAMENTE: ");
            return false;
        }
        return true;
    }
    
    
    
    public void adicionarModeloGestao(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite a metodologia utilizada no projeto: ");
        String modeloGestao = scan.nextLine();
        
       
        
         while(!verificaString(modeloGestao)){
            System.out.println("Digite a metodologia utilizada no projeto: ");
            modeloGestao = scan.nextLine();
        }
        
        informacoes.setModeloGestao(modeloGestao);
        
    }
    
    
    
    public void cadastrarAtvdTecnoProjeto(){
        Scanner scan = new Scanner(System.in);        
        
        System.out.println("Quantas atividades/Tecnologias foram utilizadas no projeto: ");
        int quantidade =  scan.nextInt();
        
        for(int i = 0; i < quantidade; i++){
            adicionarAtvdTecno();
        }
    }
    
    public void adicionarAtvdTecno(){
        Scanner scan = new Scanner(System.in);
        
        String atvdTecno;
        
        System.out.println("Digite a atividade/Tecnologia: ");
        atvdTecno = scan.nextLine();
        
        while(!verificaString(atvdTecno)){
            System.out.println("Digite a metodologia utilizada no projeto: ");
        }
        
        informacoes.setAtividadeTecnologia(atvdTecno);                
    }
    
    public boolean verificaString(String texto){
        if(texto.equals("") || texto == null){
            System.out.println("Modelo de gestão inválido");
            return false;
        }
        return true;
    }
    
    

    public void pagarMedicao(){
        Scanner scan = new Scanner(System.in);
        
        String projetoNome;
        int etapaCompletada = 0;
        double valorTotal = 0;
        char satisfacao;
        
        System.out.println("A medição a ser paga se refere a qual projeto?: ");
        projetoNome = scan.nextLine();
        
        System.out.println("Qual etapa do projeto foi completa");
        etapaCompletada = scan.nextInt();
        
        System.out.println("Qual o valor cheio a ser paga nesta medição");
        valorTotal = scan.nextDouble();
        
        scan.nextLine();
        
        System.out.println("A entrega foi satisfatória[S/N]: ");
        satisfacao = Character.toUpperCase(scan.nextLine().charAt(0));
        
        double valorPagar = valorPagoMedicao(satisfacao, valorTotal);
        informacoes.setMedicao(valorPagar);
        
        System.out.println("ProjetoNome: " + projetoNome +
                           "etapaCompletada: " + etapaCompletada +
                           "ValorTotal: " + valorTotal +
                           "ValoPagar: " + valorPagar);
        
        //conexão com o BD para atualizar a etapa como completa e o valor da medicao;
    }
    
    public double valorPagoMedicao(char satisfacao, double valorTotal){
        Scanner scan = new Scanner(System.in);
        
        switch (satisfacao) {
            case 'S' -> {
                informacoes.setMedicao(valorTotal);
                return valorTotal;
            }
            case 'N' -> {
                System.out.println("Digite o valor que deseja pagar pela etapa completada: ");
                double valorParcial = scan.nextDouble();
                do{
                    if(valorParcial < (valorTotal/3) ){
                        System.out.println("Valor Inválido, tente novamente: ");
                        System.out.println("Digite o valor que deseja pagar pela etapa completada: ");
                        valorParcial = scan.nextDouble();
                    }
                }while( valorParcial < (valorTotal/3));
                return valorParcial;
            }
            default -> {
                System.out.println("Valor inválido");
            }
        }
        return 0.0;
    }
    
    
    public void menu(){
        Scanner scan = new Scanner(System.in);
                
        int resp = 0;
        while(resp != -1){
            System.out.println("-----------------------MENU-------------------------");
            System.out.print("1 - Cadastrar CPNJ\n2 - Cadastrar Modelo De Gestão\n3 - Cadastrar tecnologias e ativiadades do projeto\n4 - Pagar medição\n-1 - Sair\nEscolha: ");
            resp = scan.nextInt();
            
            switch (resp) {
                case 1 -> {
                    cadastraCNPJ();
                }
                case 2 -> {
                    adicionarModeloGestao();
                }
                case 3 -> {
                    cadastrarAtvdTecnoProjeto();
                }
                case 4 -> {
                    pagarMedicao();
                }
                case -1 -> {
                    System.out.println("saindo...");
                }
                default -> throw new AssertionError();
            }
        }
    }

    public static void main(String[] args) {
        DadosC dados = new DadosC();
        
        dados.menu();
    }




}
