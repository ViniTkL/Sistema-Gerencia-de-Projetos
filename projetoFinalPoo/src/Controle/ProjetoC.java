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
 * A classe ProjetoC faz parte de um sistema de gestão de projetos.
 * Ela gerencia informações do projeto, equipes associadas e stakeholders.
 */
public class ProjetoC {
    
    private ProjetoM projetoInfo = null;
    EquipeProjetoC equipeProjetoGerencia = new EquipeProjetoC();
    EquipeExecC equipeProjetoExec = new EquipeExecC();
    EquipeTerceirizadoC equipeProjetoTerc = new EquipeTerceirizadoC();
    private BancoDados bd = new BancoDados();  
    private ResultSet rSet;

    /**
    * Retorna a equipe de gerência associada ao projeto.
    * 
    * @return Uma instância da classe EquipeProjetoC representando a equipe de gerência do projeto.
    * 
    * Esta função retorna a equipe de gerência associada a um projeto.
    * 
    * Pré-condições:
    * - A variável 'equipeProjetoGerencia' deve ser declarada e inicializada corretamente.
    * 
    * Pós-condições:
    * - A equipe de gerência do projeto é retornada como uma instância da classe EquipeProjetoC.
    */
    public EquipeProjetoC getEquipeProjetoGerencia() {
        return equipeProjetoGerencia;
    }

    /**
    * Define a equipe de gerência associada ao projeto.
    * 
    * @param equipeProjetoGerencia Uma instância da classe EquipeProjetoC representando a equipe de gerência do projeto.
    * 
    * Esta função define a equipe de gerência associada a um projeto.
    * 
    * Pré-condições:
    * - A variável 'equipeProjetoGerencia' deve ser declarada antes de chamar esta função.
    * 
    * Pós-condições:
    * - A equipe de gerência do projeto é definida com base na instância fornecida como argumento.
    */
    public void setEquipeProjetoGerencia(EquipeProjetoC equipeProjetoGerencia) {
        this.equipeProjetoGerencia = equipeProjetoGerencia;
    }

     /**
    * Retorna a equipe de execução associada ao projeto.
    * 
    * @return Uma instância da classe EquipeExecC representando a equipe de execução do projeto.
    * 
    * Esta função retorna a equipe de execução associada a um projeto.
    * 
    * Pré-condições:
    * - A variável 'equipeProjetoExec' deve ser declarada e inicializada corretamente.
    * 
    * Pós-condições:
    * - A equipe de execução do projeto é retornada como uma instância da classe EquipeExecC.
    */
    public EquipeExecC getEquipeProjetoExec() {
        return equipeProjetoExec;
    }

    /**
    * Define a equipe de execução associada ao projeto.
    * 
    * @param equipeProjetoExec Uma instância da classe EquipeExecC representando a equipe de execução do projeto.
    * 
    * Esta função define a equipe de execução associada a um projeto.
    * 
    * Pré-condições:
    * - A variável 'equipeProjetoExec' deve ser declarada antes de chamar esta função.
    * 
    * Pós-condições:
    * - A equipe de execução do projeto é definida com base na instância fornecida como argumento.
    */
    public void setEquipeProjetoExec(EquipeExecC equipeProjetoExec) {
        this.equipeProjetoExec = equipeProjetoExec;
    }

    /**
    * Retorna a equipe de terceirizados associada ao projeto.
    * 
    * @return Uma instância da classe EquipeTerceirizadoC representando a equipe de terceirizados do projeto.
    * 
    * Esta função retorna a equipe de terceirizados associada a um projeto.
    * 
    * Pré-condições:
    * - A variável 'equipeProjetoTerc' deve ser declarada e inicializada corretamente.
    * 
    * Pós-condições:
    * - A equipe de terceirizados do projeto é retornada como uma instância da classe EquipeTerceirizadoC.
    */
    public EquipeTerceirizadoC getEquipeProjetoTerc() {
        return equipeProjetoTerc;
    }

    /**
    * Define a equipe de terceirizados associada ao projeto.
    * 
    * @param equipeProjetoTerc Uma instância da classe EquipeTerceirizadoC representando a equipe de terceirizados do projeto.
    * 
    * Esta função define a equipe de terceirizados associada a um projeto.
    * 
    * Pré-condições:
    * - A variável 'equipeProjetoTerc' deve ser declarada antes de chamar esta função.
    * 
    * Pós-condições:
    * - A equipe de terceirizados do projeto é definida com base na instância fornecida como argumento.
    */
    public void setEquipeProjetoTerc(EquipeTerceirizadoC equipeProjetoTerc) {
        this.equipeProjetoTerc = equipeProjetoTerc;
    }
    
    
   /**
    * Esta função solicita ao usuário informações sobre o projeto, como nome, escopo, custo orçado,
    * custo aprovado e quantidade de stakeholders. Posteriormente, salva essas informações no banco de dados
    * e adiciona os stakeholders associados ao projeto.
    * 
    * Pré-condições:
    * - A classe ProjetoM deve ser instanciada antes de chamar esta função.
    * 
    * Pós-condições:
    * - As informações do projeto são salvas no banco de dados.
    * - Os stakeholders associados ao projeto são cadastrados no banco de dados.
    * - Caso ocorra algum erro durante o processo, uma mensagem de erro é exibida.
    */
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
    
   /**
    * @param projeto Uma instância da classe ProjetoM representando o projeto ao qual os stakeholders serão adicionados.
    * @param qtde A quantidade de stakeholders a serem adicionados ao projeto.
    * 
    * Esta função solicita ao usuário o nome de cada stakeholder e os adiciona ao projeto.
    * Em seguida, salva esses stakeholders em duas tabelas diferentes no banco de dados.
    * 
    * Pré-condições:
    * - A instância de ProjetoM 'projeto' deve ser corretamente inicializada.
    * 
    * Pós-condições:
    * - Os stakeholders são adicionados ao projeto.
    * - Os stakeholders são salvos em duas tabelas diferentes no banco de dados.
    */
   public void adicionarStakeholders(ProjetoM projeto, int qtde){
        Scanner scan = new Scanner(System.in);
      
        for(int i = 0; i < qtde; i++){
            System.out.println("Digite o nome do stakeholder " + (i+1) + ": ");
            projeto.setStakeholders(scan.nextLine());
            
            salvarStakeholders(projeto);
            salvarProjetoStakeholders(projeto);
        }
   } 
   
   /**
    * Salva as informações do projeto no banco de dados.
    * 
    * @param projeto Uma instância da classe ProjetoM representando o projeto a ser salvo.
    * @param qtde A quantidade de stakeholders associados ao projeto.
    * 
    * Esta função salva as informações do projeto, como nome, escopo, quantidade de stakeholders, custo orçado e custo aprovado,
    * em uma tabela no banco de dados.
    * 
    * Pré-condições:
    * - A instância de ProjetoM 'projeto' deve conter as informações do projeto.
    * 
    * Pós-condições:
    * - As informações do projeto são salvas no banco de dados.
    * - Caso ocorra algum erro durante o processo, uma mensagem de erro é exibida.
    */
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
   
   /**
    * @param projeto Uma instância da classe ProjetoM representando o projeto associado ao stakeholder.
    * 
    * Esta função salva o nome do stakeholder em uma tabela no banco de dados.
    * 
    * Pré-condições:
    * - A instância de ProjetoM 'projeto' deve conter o nome do stakeholder.
    * 
    * Pós-condições:
    * - O stakeholder é salvo no banco de dados.
    * - Caso ocorra algum erro durante o processo, uma mensagem de erro é exibida.
    */
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
   
   /**
    * @param projeto Uma instância da classe ProjetoM representando o projeto associado ao stakeholder.
    * 
    * Esta função salva a associação entre o stakeholder e o projeto em uma tabela no banco de dados.
    * 
    * Pré-condições:
    * - A instância de ProjetoM 'projeto' deve conter o nome do stakeholder e o nome do projeto.
    * 
    * Pós-condições:
    * - A associação entre o stakeholder e o projeto é salva no banco de dados.
    * - Caso ocorra algum erro durante o processo, uma mensagem de erro é exibida.
    */
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
   
   /**
    * @param nomeStakeholder O nome do stakeholder para o qual deseja obter o ID.
    * @return O ID do stakeholder, ou 0 se o stakeholder não for encontrado.
    * 
    * Esta função realiza uma consulta no banco de dados para obter o ID de um stakeholder com base no seu nome.
    * 
    * Pré-condições:
    * - O parâmetro 'nomeStakeholder' deve conter o nome do stakeholder.
    * 
    * Pós-condições:
    * - O ID do stakeholder é retornado.
    * - Se o stakeholder não for encontrado, é retornado 0.
    * - Caso ocorra algum erro durante o processo, uma mensagem de erro é exibida.
    */
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
   
   
    /**
    * @param nomeProjeto O nome do projeto para o qual deseja consultar informações.
    * 
    * Esta função realiza consultas no banco de dados para obter informações específicas de um projeto,
    * como detalhes do projeto e códigos dos stakeholders associados a ele.
    * 
    * Pré-condições:
    * - O parâmetro 'nomeProjeto' deve conter o nome do projeto.
    * 
    * Pós-condições:
    * - As informações do projeto, como detalhes do projeto e códigos dos stakeholders, são exibidas.
    * - Caso ocorra algum erro durante o processo, uma mensagem de erro é exibida.
    */
   public void consultarInformaçõesProjeto(String nomeProjeto){
       resgatarInfoProjeto(nomeProjeto);
       resgatarCodStakeholders(nomeProjeto);
   }
   
   /**
    * @param nomeProjeto O nome do projeto para o qual deseja resgatar informações.
    * 
    * Esta função realiza uma consulta no banco de dados para obter informações específicas de um projeto,
    * como nome, escopo, quantidade de stakeholders, custo orçado e custo aprovado.
    * 
    * Pré-condições:
    * - O parâmetro 'nomeProjeto' deve conter o nome do projeto.
    * 
    * Pós-condições:
    * - As informações do projeto são exibidas.
    * - Se o projeto não for encontrado, uma mensagem informando isso é exibida.
    * - Caso ocorra algum erro durante o processo, uma mensagem de erro é exibida.
    */
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
   
   /**
   * Resgata os stakeholders associados a um projeto no banco de dados.
   * 
   * @param nomeProjeto O nome do projeto para o qual deseja resgatar os stakeholders.
   * 
   * Esta função realiza uma consulta no banco de dados para obter os stakeholders associados a um projeto,
   * exibindo o nome de cada stakeholder.
   * 
   * Pré-condições:
   * - O parâmetro 'nomeProjeto' deve conter o nome do projeto.
   * 
   * Pós-condições:
   * - Os stakeholders associados ao projeto são exibidos.
   * - Se não houver stakeholders associados ou o projeto não for encontrado, uma mensagem informando isso é exibida.
   * - Caso ocorra algum erro durante o processo, uma mensagem de erro é exibida.
   */
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
