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
    EquipeProjetoC equipeProjetoGerencia = new EquipeProjetoC();
    EquipeExecC equipeProjetoExec = new EquipeExecC();
    EquipeTerceirizadoC equipeProjetoTerc = new EquipeTerceirizadoC();
    private BancoDados bd = new BancoDados();  
    private ResultSet rSet;

    public EquipeProjetoC getEquipeProjetoGerencia() {
        return equipeProjetoGerencia;
    }

    public void setEquipeProjetoGerencia(EquipeProjetoC equipeProjetoGerencia) {
        this.equipeProjetoGerencia = equipeProjetoGerencia;
    }

    public EquipeExecC getEquipeProjetoExec() {
        return equipeProjetoExec;
    }

    public void setEquipeProjetoExec(EquipeExecC equipeProjetoExec) {
        this.equipeProjetoExec = equipeProjetoExec;
    }

    public EquipeTerceirizadoC getEquipeProjetoTerc() {
        return equipeProjetoTerc;
    }

    public void setEquipeProjetoTerc(EquipeTerceirizadoC equipeProjetoTerc) {
        this.equipeProjetoTerc = equipeProjetoTerc;
    }
    
    
   //cadastra um projeto, pegando todas as informaçõe do usuário e salva no banco de dados
    public void cadastrarProjeto(){
        projetoInfo = new ProjetoM();
       
        Scanner scan = new Scanner(System.in);
       
        try{
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
            
            System.out.println("Projeto salvo com sucesso!!!");
        }catch(Exception e){
            System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
        }
   }
   //função para adicionar vários stakeholder e salvar eles no banco de dados em duas tabelas diferentes
   public void adicionarStakeholders(ProjetoM projeto, int qtde){
        Scanner scan = new Scanner(System.in);
      
        for(int i = 0; i < qtde; i++){
            System.out.println("Digite o nome do stakeholder " + (i+1) + ": ");
            projeto.setStakeholders(scan.nextLine());
            
            salvarStakeholders(projeto);
            salvarProjetoStakeholders(projeto);
        }
   } 
   //salva o projeto no banco de dados
   public void salvarProjeto(ProjetoM projeto, int qtde){
       try{
           bd.conexao();
           String sql = "insert into projetos(nomeProjeto, escopo, qtdeStakeholders, custoOrcado, custoAprovado) "
                   + "values('" + projeto.getNomeProjeto() + "', '"+ projeto.getEscopo() + "', " + qtde + ", " + projeto.getCustoOrcado() + ", " + projeto.getCustoAprovado()+ ")" ;
       
           bd.getStatement().execute(sql);
           
           bd.desconecta();
       }catch(Exception e){
           System.out.println("ERRO AO SALVAR PROJETO: " + e.getMessage());
       }
   }
   //salva os stakeholders no banco de dados 
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
   //salva os stakeholder e os projetos em que eles estão participando em uma única tabela
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
   //pega e retorna o id do stakeholder através do nome dele
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
   
   
   //não vai usar isso aqui no menu -> so para testar se está puxando os dados coretamente
   public void consultarInformaçõesProjeto(String nomeProjeto){
       resgatarInfoProjeto(nomeProjeto);
       resgatarCodStakeholders(nomeProjeto);
   }
   
   public void resgatarInfoProjeto(String nomeProjeto){
        try{
           bd.conexao();
           String sql = "select * from projetos where nomeProjeto = '" + nomeProjeto + "';";
       
           rSet = bd.getStatement().executeQuery(sql);

           if(rSet.next()){
               System.out.println("--------------------------INFORMAÇÕES DO PROJETO--------------------------" + "\n" 
                                + "Nome do projeto........: " + rSet.getString("nomeProjeto") + "\n"
                                + "Escopo.................: " + rSet.getString("escopo") + "\n"
                                + "Quantidade de staholder: " + rSet.getInt("qtdeStakeholders") + "\n"
                                + "Custo orçado...........: " + rSet.getDouble("custoOrcado") + "\n"
                                + "Custo aprovado.........: " + rSet.getDouble("custoAprovado") + "\n");
           }else{
               System.out.println("Projeto não encontrado.");
           }
           
           bd.desconecta();
       }catch(Exception e){
           System.out.println("ERRO AO RESGATAR PROJETO: " + e.getMessage());
       }
   }
   
   public void resgatarCodStakeholders(String nomeProjeto){
        try{
           bd.conexao();
           String sql = "select projeto_stakeholders.codStakeholder, stakeholders.nomeStakeholder from projeto_stakeholders, stakeholders where nomeProjeto = '" + nomeProjeto + "' and projeto_stakeholders.codStakeholder = stakeholders.codStakeholder ;";

           rSet = bd.getStatement().executeQuery(sql);

            System.out.println("--------------------------STAKEHOLDERS--------------------------");  
            while(rSet.next()){
               System.out.println("Nome do stakeholder: " + rSet.getString("nomeStakeholder"));                           
           }
           
           bd.desconecta();
       }catch(Exception e){
           System.out.println("ERRO AO RESGATAR PROJETO: " + e.getMessage());
       }
   }
}
