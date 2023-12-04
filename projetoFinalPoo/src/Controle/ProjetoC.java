/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.ProjetoM;
import java.util.Scanner;

/**
 *
 * @author vinim
 */
public class ProjetoC {
    
    private ProjetoM projetoInfo = null;
    
   public void cadastrarProjeto(){
        projetoInfo = new ProjetoM();
       
        Scanner scan = new Scanner(System.in);
       
       
        System.out.println("Digite o nome do projeto: ");
        projetoInfo.setNomeProjeto(scan.nextLine().toUpperCase());
       
        System.out.println("Digite o escopo do projeto: ");
        projetoInfo.setEscopo(scan.nextLine().toUpperCase());
       
        System.out.println("Digite o custo Orçado do projeto: ");
        projetoInfo.setCustoOrcado(scan.nextDouble());
       
        System.out.println("Digite o custo aprovado para o projeto: ");
        projetoInfo.setCustoAprovado(scan.nextDouble());
        
        adicionarStakeholders(projetoInfo.getNomeProjeto());
   }
   
   public void adicionarStakeholders(String nomeProjeto){
        Scanner scan = new Scanner(System.in);
      
        System.out.println("Digite a quantidade de stakeholders");
        int qtde = scan.nextInt();
        
        //limpar o buffer do teclado para não impactar a digitação dos nomes abaixo
        scan.nextLine();
        
        for(int i = 0; i < qtde; i++){
            System.out.println("Digite o nome do stakeholder " + (i+1) + ": ");
            String stakeholders = scan.nextLine();
            
            //função para passar para o BD
        }
   } 
   
    
    
}
