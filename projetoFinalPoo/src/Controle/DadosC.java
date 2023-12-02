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
        
    }
    
    
    
    public void menu(){
        Scanner scan = new Scanner(System.in);
                
        int resp = 0;
        while(resp != -1){
            System.out.println("-----------------------MENU-------------------------");
            System.out.print("1 - Cadastrar CPNJ\n2 - Cadastrar Modelo De Gestão\n3 - Cadastrar tecnologias e ativiadades do projeto\n-1 - Sair\nEscolha: ");
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
