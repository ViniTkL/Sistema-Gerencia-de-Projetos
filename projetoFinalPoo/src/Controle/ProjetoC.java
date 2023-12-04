/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.ProjetoM;
import java.util.Scanner;
import controle.BancoDados;
import java.sql.ResultSet;

/**
 *
 * @author vinim
 */
public class ProjetoC {
    
    private ProjetoM projetoInfo = null;
    
    private BancoDados bd = new BancoDados();  
    private ResultSet rSet;
   
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
        
        System.out.println("Digite a quantidade de stakeholders");
        int qtde = scan.nextInt();
        
        salvarProjeto(projetoInfo, qtde);
        
        adicionarStakeholders(projetoInfo, qtde);
   }
   
   public void adicionarStakeholders(ProjetoM projeto, int qtde){
        Scanner scan = new Scanner(System.in);
      
        for(int i = 0; i < qtde; i++){
            System.out.println("Digite o nome do stakeholder " + (i+1) + ": ");
            projeto.setStakeholders(scan.nextLine());
            
            salvarStakeholders(projeto);
            salvarProjetoStakeholders(projeto);
        }
   } 
   
   public void salvarProjeto(ProjetoM projeto, int qtde){
       try{
           bd.conexao();
           String sql = "insert into projetos(nomeProjeto, escopo, qtdeStakeholders, custoOrcado, custoAprovado) "
                   + "values('" + projeto.getNomeProjeto() + "', '"+ projeto.getEscopo() + "', " + qtde + ", " + projeto.getCustoOrcado() + ", " + projeto.getCustoAprovado()+")" ;
       
           bd.getStatement().execute(sql);
           
           bd.desconecta();
       }catch(Exception e){
           System.out.println("ERRO AO SALVAR PROJETO: " + e.getMessage());
       }
   }
    
   public void salvarStakeholders(ProjetoM projeto){
       try{
           bd.conexao();
           String sql = "insert into stakeholders(nomeStakeholder) values('" + projeto.getStakeholders() + "')";
       
           bd.getStatement().execute(sql);
           
           bd.desconecta();
           
           
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
   public void salvarProjetoStakeholders(ProjetoM projeto){
       int id  = pegarIdStakeholder(projeto.getStakeholders());
       
       try{
           bd.conexao();
           String sql = "insert into projeto_stakeholders(codStakeholder, nomeProjeto) values(" + id + ", '" + projeto.getNomeProjeto() +"')";
       
           bd.getStatement().execute(sql);
           
           bd.desconecta();
           
           
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
   public int pegarIdStakeholder(String nomeStakeholder){
      int id = 0;
       try{
           bd.conexao();
           String sql = "select codStakeholder from stakeholders where nomeStakeholder = '" + nomeStakeholder + "';";
       
           rSet = bd.getStatement().executeQuery(sql);

           if(rSet.next()){
               id = rSet.getInt("codStakeholder");
           }
           
           bd.desconecta();
       }catch(Exception e){
           System.out.println("ERRO AO SALVAR PROJETO: " + e.getMessage());
       }
       return id;
   } 
   
   
}
