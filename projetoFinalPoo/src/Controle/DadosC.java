/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DadosM;
import controle.BancoDados;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * A classe DadosC é responsável por controlar as operações relacionadas aos dados gerais do projeto,
 * como cadastrar informações, medir entregas, cadastrar e ajustar cronograma, e recuperar informações do banco de dados. 
 */
public class DadosC {
    DadosM informacoes = new DadosM();
    ProjetoC projetoInfo = new ProjetoC();
    private BancoDados bd = new BancoDados();  
    private ResultSet rSet;
   
    public DadosC() {
    
    }

    public ProjetoC getProjetoInfo() {
        return projetoInfo;
    }

    public void setProjetoInfo(ProjetoC projetoInfo) {
        this.projetoInfo = projetoInfo;
    }
    
    
  
    /**
    * Realiza o cadastro de informações gerais de um projeto, incluindo CNPJ, modelo de gestão e atividades do projeto,
    * e armazena os dados no banco de dados.
    * 
    * Este método executa as seguintes etapas:
    * 1. Solicita e cadastra o CNPJ do projeto através do método `cadastraCNPJ()`.
    * 2. Adiciona o modelo de gestão do projeto utilizando o método `adicionarModeloGestao()`.
    * 3. Cadastra as atividades tecnológicas do projeto por meio do método `cadastrarAtvdTecnoProjeto()`.
    * 4. Exibe as informações cadastradas, incluindo CNPJ, modelo de gestão, atividades tecnológicas e o nome do projeto.
    * 5. Salva os dados gerais no banco de dados através do método `salvarDadosGerais()`.
    * 6. Exibe uma mensagem indicando o sucesso do processo.
    * 
    * Pré-condições:
    * - Os métodos `cadastraCNPJ()`, `adicionarModeloGestao()`, e `cadastrarAtvdTecnoProjeto()` devem estar implementados
    *   para obter as informações necessárias do usuário ou de outras fontes.
    * - A variável de instância `informacoes` deve ser acessível e conter as informações do projeto.
    * - O método `salvarDadosGerais()` deve ser implementado para persistir as informações no banco de dados.
    * 
    * Pós-condições:
    * - As informações gerais do projeto são cadastradas e armazenadas no banco de dados.
    * - Uma mensagem indicando o sucesso do cadastro é exibida no console.
    */
    public void cadastroDadosGerais(){
        cadastraCNPJ();
        adicionarModeloGestao();
        cadastrarAtvdTecnoProjeto();
        
        System.out.println(informacoes.getPessoaJuridica() + "\n" +informacoes.getModeloGestao() + "\n" + informacoes.getAtividadeTecnologia() + "\n" + informacoes.getProjeto().getNomeProjeto());
        
        salvarDadosGerais(informacoes);
        
        System.out.println("Dados salvos com sucesso!!!");
    }
    
   /**
    * Realiza o cadastro do CNPJ do projeto e do nome associado a ele.
    * Solicita ao usuário que insira o nome do projeto e o CNPJ da empresa responsável pelo projeto.
    * Remove caracteres especiais do CNPJ inserido e verifica sua validade.
    * Armazena o CNPJ na instância de informações do projeto.
    * 
    * Pré-condições:
    * - A variável 'informacoes' deve ser acessível e conter informações do projeto.
    * - O método 'verificaCnpj()' deve estar implementado para validar o CNPJ inserido.
    * - O método 'removeCaracteresEspeciais()' deve estar implementado para limpar o CNPJ de caracteres especiais.
    * 
    * Pós-condições:
    * - O nome do projeto e o CNPJ da empresa responsável pelo projeto são cadastrados.
    * - O CNPJ válido é armazenado na instância de informações do projeto.
    */
    public void cadastraCNPJ(){
        Scanner scan = new Scanner(System.in);
        String cnpj = null;
        
        System.out.println("Digite o nome do projeto: ");
        informacoes.getProjeto().setNomeProjeto(scan.nextLine().toUpperCase());
        
        System.out.println("Digite o CNPJ da empresa responável pelo projeto: ");
        cnpj = removeCaracteresEspeciais(scan.nextLine());
        
        while(!verficaCnpj(cnpj)){
            System.out.println("Digite o CNPJ da empresa responável pelo projeto: ");
            cnpj = removeCaracteresEspeciais(  scan.nextLine());
        }
        
        informacoes.setPessoaJuridica(cnpj);
        
    }
    
    /**
    * Remove caracteres especiais de uma string, mantendo apenas os dígitos numéricos.
    * Utiliza expressão regular para substituir todos os caracteres não numéricos por uma string vazia.
    * 
    * @param texto A string da qual os caracteres especiais serão removidos.
    * @return Uma nova string contendo apenas os dígitos numéricos da string original.
    */
    public String removeCaracteresEspeciais(String texto){
        return texto.replaceAll("[^0-9]+","");
    }
    
    /** Verifica se o tamanho do CNPJ fornecido está correto.
    * 
    * @param cnpj O CNPJ a ser verificado.
    * @return true se o tamanho do CNPJ for igual a 14, indicando um CNPJ válido; false caso contrário.
    */
    public boolean verficaCnpj(String cnpj){
        if(cnpj.length() != 14){
            System.out.println("CNPJ INVÁLIDO, TENTE NOVAMENTE: ");
            return false;
        }
        return true;
    }
    
    
    /**
    * Solicita e adiciona o modelo de gestão utilizado no projeto.
    * 
    * Solicita ao usuário que insira a metodologia utilizada no projeto.
    * Verifica se a string inserida é válida utilizando o método 'verificaString()'.
    * Armazena a metodologia na instância de informações do projeto.
    * 
    * Pré-condições:
    * - A variável 'informacoes' deve ser acessível e conter informações do projeto.
    * - O método 'verificaString()' deve estar implementado para validar a string inserida.
    * 
    * Pós-condições:
    * - O modelo de gestão utilizado no projeto é adicionado às informações do projeto.
    */
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
    
    
    /**
    * Solicita e cadastra as atividades/tecnologias utilizadas no projeto em uma única string.
    * 
    * Solicita ao usuário a quantidade de atividades/tecnologias utilizadas no projeto.
    * Utiliza um loop para iterar sobre as atividades, chamando o método 'adicionarAtvdTecno()' para cada uma.
    * Concatena as atividades em uma única string e armazena na instância de informações do projeto.
    * 
    * Pré-condições:
    * - A variável 'informacoes' deve ser acessível e conter informações do projeto.
    * - O método 'adicionarAtvdTecno()' deve estar implementado para obter e validar cada atividade/tecnologia.
    * 
    * Pós-condições:
    * - As atividades/tecnologias utilizadas no projeto são cadastradas em uma única string e armazenadas nas informações do projeto.
    */
    public void cadastrarAtvdTecnoProjeto(){
        Scanner scan = new Scanner(System.in);        
        
        System.out.println("Quantas atividades/Tecnologias foram utilizadas no projeto: ");
        int quantidade =  scan.nextInt();
        
        for(int i = 0; i < quantidade; i++){
           
            if(i > 0)
                informacoes.setAtividadeTecnologia(informacoes.getAtividadeTecnologia() + ", " + adicionarAtvdTecno()); 
            else
                informacoes.setAtividadeTecnologia(adicionarAtvdTecno());           
        }
    }
    
    /**
    * Solicita e retorna uma atividade/tecnologia digitada pelo usuário.
    * 
    * Solicita ao usuário que insira uma atividade/tecnologia.
    * Verifica se a string inserida é válida utilizando o método 'verificaString()'.
    * Retorna a atividade/tecnologia.
    * 
    * @return String da atividade ou tecnologia digitada
    * 
    * Pré-condições:
    * - O método 'verificaString()' deve estar implementado para validar a string inserida.
    * 
    * Pós-condições:
    * - Uma atividade/tecnologia válida é retornada.
    */
    public String adicionarAtvdTecno(){
        Scanner scan = new Scanner(System.in);
        
        String atvdTecno;
        
        System.out.println("Digite a atividade/Tecnologia: ");
        atvdTecno = scan.nextLine();
        
        while(!verificaString(atvdTecno)){
            System.out.println("Digite a metodologia utilizada no projeto: ");
            atvdTecno = scan.nextLine();
        }
        
        return atvdTecno;                
    }
    
    /**
    * Verifica se a string fornecida não é nula ou vazia.
    * 
    * @param texto A string a ser verificada.
    * @return true se a string não for nula e não estiver vazia; false caso contrário.
    */
    public boolean verificaString(String texto){
        if( texto == null || texto.equals("") ){
            System.out.println("Digitação inválida, tente novamente");
            return false;
        }
        return true;
    }
    
    
     /**
    * Salva os dados gerais (CNPJ, modelo de gestão, nome do projeto e atividades) no banco de dados.
    * 
    * @param infosGerais Objeto contendo as informações gerais a serem salvas no banco de dados.
    */
    public void salvarDadosGerais(DadosM infosGerais){
        try{
            bd.conexao();
            String sql="insert into dadosGerais values('"+ infosGerais.getPessoaJuridica()+"', '"+ infosGerais.getModeloGestao() + "', '" + infosGerais.getProjeto().getNomeProjeto() + "', '" + infosGerais.getAtividadeTecnologia()+"')" ;
            bd.getStatement().execute(sql);
            
            bd.desconecta();
        }catch(Exception e){
            System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
        }
        
    }
  
    
    /**
    * Registra o pagamento da medição associada a um projeto, atualizando a etapa completa, o valor pago e a satisfação da entrega.
    * 
    * Solicita ao usuário o nome do projeto, a etapa completa, o valor total a ser pago e a satisfação com a entrega.
    * Calcula o valor pago considerando a satisfação com a entrega.
    * Atualiza a etapa como completa e o valor da medição no banco de dados.
    * 
    * Pré-condições:
    * - A variável 'informacoes' deve ser acessível e conter informações do projeto.
    * - O método 'valorPagoMedicao()' deve estar implementado para calcular o valor pago com base na satisfação.
    * - O método 'salvarMedicao()' deve estar implementado para atualizar as informações no banco de dados.
    * 
    * Pós-condições:
    * - A etapa do projeto é marcada como completa.
    * - O valor da medição é calculado e atualizado no banco de dados.
    * - Uma mensagem indicando o sucesso do processo é exibida no console.
    */
    public void pagarMedicao(){
        Scanner scan = new Scanner(System.in);
        
        double valorTotal = 0;
        char satisfacao;
        
        System.out.println("Digite o nome do projeto que terá a medição paga: ");
        informacoes.getProjeto().setNomeProjeto(scan.nextLine().toUpperCase());
        
        System.out.println("Qual etapa do projeto foi completa?: ");
        informacoes.setEtapa(scan.nextInt());
        
        System.out.println("Qual o valor cheio a ser paga nesta medição?: ");
        valorTotal = scan.nextDouble();
        
        scan.nextLine();
        
        System.out.println("A entrega foi satisfatória?[S/N]: ");
        satisfacao = Character.toUpperCase(scan.nextLine().charAt(0));
        
        informacoes.setMedicao(valorPagoMedicao(satisfacao, valorTotal));
        
        //conexão com o BD para atualizar a etapa como completa e o valor da medicao;
        salvarMedicao(informacoes, valorTotal);
        
        System.out.println("Medição salva com sucesso!!!");

    }
    
    /**
    * Calcula e retorna o valor pago na medição, considerando a satisfação do usuário com a entrega.
    * Se o usuário estiver satisfeito ('S'), o valor pago é o valor total. Se estiver insatisfeito ('N'),
    * solicita ao usuário o valor parcial desejado, com validação para garantir que esteja entre 1/3 e o valor total.
    * Em caso de entrada inválida, o usuário é solicitado novamente até fornecer um valor válido.
    * Se a satisfação não for 'S' ou 'N', continua solicitando ao usuário até obter uma resposta válida.
    * 
    * @param satisfacao A satisfação do usuário com a entrega ('S' para satisfeito, 'N' para insatisfeito).
    * @param valorTotal O valor total a ser pago na medição.
    * @return O valor pago, calculado com base na satisfação do usuário.
    */
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
                    if( valorParcial < (valorTotal/3) || valorParcial > valorTotal ){
                        System.out.println("Valor Inválido, tente novamente: ");
                        System.out.println("Digite o valor que deseja pagar pela etapa completada: ");
                        valorParcial = scan.nextDouble();
                    }
                }while( valorParcial < (valorTotal/3) || valorParcial > valorTotal );
                return valorParcial;
            }
            default -> {
                System.out.println("Valor inválido sobre satisfação, digite novamente");
            }
        }
       
        System.out.println("A entrega foi satisfatória[S/N]: ");
        satisfacao = Character.toUpperCase(scan.nextLine().charAt(0));
               
        return valorPagoMedicao(satisfacao, valorTotal);
    }
    
    /**
    * Salva os dados da medição no banco de dados.
    * 
    * @param informacoes Objeto contendo as informações necessárias para a medição.
    * @param valorTotal O valor total a ser pago na medição.
    */
    public void salvarMedicao(DadosM informacoes, double valorTotal){
       try{
           bd.conexao();
           String sql = "insert into medicao values(" + informacoes.getEtapa() + ", " + valorTotal +", "+ informacoes.getMedicao() + ", '" + informacoes.getProjeto().getNomeProjeto() +"');" ;
       
           bd.getStatement().execute(sql);
           
           bd.desconecta();
           
           
       }catch(Exception e){
           System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
       }
    }
    
     /**
    * Solicita o nome do projeto e a quantidade de etapas para inserir as informações no cronograma.
    * Em seguida, chama uma função para inserir os dados no cronograma.
    * 
    * Pré-condições:
    * - A variável 'informacoes' deve ser acessível e conter informações do projeto.
    * - O método 'inserirInformacoesCronograma()' deve estar implementado para inserir os dados no cronograma.
    * 
    * Pós-condições:
    * - As informações sobre o cronograma do projeto são inseridas no banco de dados.
    * - Em caso de erro, uma mensagem de erro é exibida no console.
    */
    public void cadastrarCronograma(){
        Scanner scan = new Scanner(System.in);
        try{
            System.out.println("Digite o nome do projeto: ");
            informacoes.getProjeto().setNomeProjeto(scan.nextLine().toUpperCase());

            System.out.println("Digite a quantidade de etapas que o proejto possui: ");
            int quantidadeEtapas = scan.nextInt();

            for(int i = 0; i < quantidadeEtapas; i++ ){
                inserirInformacoesCronograma(informacoes.getProjeto().getNomeProjeto(), i );
            }
        }catch(Exception e){
            System.out.println("ERRO:" + e.getMessage());
        }
    }
    
    /**
    * @param nomeProjeto O nome do projeto ao qual o cronograma está associado.
    * @param numEtapa O número da etapa no cronograma.
    * 
    * Esta função solicita ao usuário as informações necessárias para cada etapa do cronograma,
    * incluindo o nome, descrição, data de início e data de conclusão. As datas são validadas para garantir
    * que a data de início seja anterior à data de conclusão. Após a coleta das informações, a função chama
    * outra função para salvar esses dados no banco de dados.
    * 
    * Pré-condições:
    * - A variável 'informacoes' deve ser acessível e conter informações do projeto.
    * - O método 'converteStringParaData()' deve estar implementado para converter a entrada do usuário para o tipo LocalDate.
    * - O método 'verificaDatasEtapa()' deve estar implementado para validar as datas da etapa.
    * - O método 'salvarCronograma()' deve estar implementado para inserir as informações no banco de dados.
    * 
    * Pós-condições:
    * - As informações sobre a etapa do cronograma são inseridas no banco de dados.
    * - Em caso de erro, uma mensagem de erro é exibida no console.
    */
    public void inserirInformacoesCronograma(String nomeProjeto,int numEtapa){
        Scanner scan = new Scanner(System.in);
        try{        
            informacoes.getProjeto().setNomeProjeto(nomeProjeto);
            informacoes.setEtapa(numEtapa + 1);

            System.out.println("Digite o nome da etapa " + informacoes.getEtapa() + ": ");
            String nomeEtapa = scan.nextLine();

            System.out.println("Digite oque será feito na etapa " + informacoes.getEtapa() + ": ");
            String descricaoEtapa = scan.nextLine();

            System.out.println("Digite a data de início da etapa " + informacoes.getEtapa() + ": ");
            LocalDate dataInicio = converteStringParaData( scan.nextLine() ); 

            System.out.println("Digite a data de conclusão da etapa " + informacoes.getEtapa() + ": ");
            LocalDate dataFinal =  converteStringParaData(scan.nextLine());

            while( !verificaDatasEtapa(dataInicio, dataFinal) ){
                System.out.println("Digite a data de início da etapa " + informacoes.getEtapa() + ": ");
                dataInicio = converteStringParaData( scan.nextLine() );

                System.out.println("Digite a data de conclusão da etapa " + informacoes.getEtapa() + ": ");
                dataFinal =  converteStringParaData(scan.nextLine());
            }

           


            //mandar para o banco de dados :)
            salvarCronograma(informacoes, nomeEtapa, descricaoEtapa, dataInicio, dataFinal);
            
            System.out.println("Cronograma salvo com sucesso!!!");

        }catch(Exception e){
            System.out.println("ERRO: " + e.getMessage());
        }
    }
    
    /**
    * Verifica se as datas de início e fim das etapas são válidas.
    * 
    * @param dateInicio A data de início da etapa.
    * @param dateFinal A data de conclusão da etapa.
    * @return true se as datas são válidas, false caso contrário.
    * 
    * Esta função compara as datas de início e fim da etapa para garantir que a data de fim seja igual ou posterior
    * à data de início. Caso as datas sejam inválidas, uma mensagem é exibida no console e a função retorna false.
    */
    public boolean verificaDatasEtapa(LocalDate dateInicio, LocalDate dateFinal){
        if( dateFinal.getYear() < dateInicio.getYear() ||  ( dateFinal.getYear() == dateInicio.getYear() && dateFinal.getMonthValue() < dateInicio.getMonthValue() ) ){
            System.out.println("Datas da etapa Inválidas");
            return false;
        }
        
        return true;
    }
    
   /**
    * Salva as informações do cronograma no banco de dados.
    * 
    * @param informacoes Objeto contendo informações relacionadas ao cronograma.
    * @param nomeEtapa Nome da etapa no cronograma.
    * @param descricaoEtapa Descrição do que será feito na etapa.
    * @param dataInicio Data de início da etapa no cronograma.
    * @param dataFinal Data de conclusão da etapa no cronograma.
    * 
    * Esta função realiza a conexão com o banco de dados, monta a consulta SQL para inserção das informações
    * do cronograma e executa a consulta. As informações incluem o número da etapa, nome da etapa, descrição,
    * data de início, data de conclusão e o nome do projeto associado. Em caso de erro, uma mensagem de erro
    * é exibida no console.
    * 
    * Pré-condições:
    * - A variável 'informacoes' deve ser acessível e conter informações do projeto.
    * 
    * Pós-condições:
    * - As informações sobre a etapa do cronograma são inseridas no banco de dados.
     * - Em caso de erro, uma mensagem de erro é exibida no console.
    */
    public void salvarCronograma(DadosM informacoes, String nomeEtapa, String descricaoEtapa, LocalDate dataInicio, LocalDate dataFinal){
       try{
           bd.conexao();
           String sql = "insert into cronograma values(" + informacoes.getEtapa() + ", '" + nomeEtapa + "', '" + descricaoEtapa +"', '" +  dataInicio + "', '" +  dataFinal + "', '" + informacoes.getProjeto().getNomeProjeto()+ "' );";
       
           bd.getStatement().execute(sql);
           
           bd.desconecta();
           
           
       }catch(Exception e){
           System.out.println("ERRO: " + e.getMessage());
       }
    }
    
    
    /**
    * Ajusta o cronograma de um projeto, coletando informações sobre o ajuste e salvando no banco de dados.
    * 
    * Esta função interativa solicita ao usuário informações necessárias para ajustar uma etapa específica do cronograma,
    * incluindo o nome do projeto, número da etapa, risco, impacto, motivo do ajuste e a nova data de conclusão da etapa.
    * As informações são validadas, garantindo que o motivo de alteração tenha pelo menos 50 caracteres.
    * Após a coleta das informações, a função chama outra função para salvar esses dados no banco de dados.
    * 
    * Pré-condições:
    * - A variável 'informacoes' deve ser acessível e conter informações do projeto.
     * - O método 'converteStringParaData()' deve estar implementado para converter a entrada do usuário para o tipo LocalDate.
    * - O método 'salvarAjusteCronograma()' deve estar implementado para inserir as informações no banco de dados.
    * 
    * Pós-condições:
    * - As informações sobre o ajuste no cronograma são inseridas no banco de dados.
    * - Em caso de erro, uma mensagem de erro é exibida no console.
    */
    public void ajustarCronograma(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Qual projeto terá o cronograma ajustado: ");
        informacoes.getProjeto().setNomeProjeto(scan.nextLine().toUpperCase());
        
        System.out.println("Qual etapa do projeto será alterada: ");
        informacoes.setEtapa(scan.nextInt());
        
        //limpando buffer do teclado
        scan.nextLine();
        
        System.out.println("Digite o risco do ajuste feito: ");
        informacoes.setRisco ( scan.nextLine() );
        
        System.out.println("Digite o impacto que esse ajuste causará no projeto: ");
        informacoes.setImpacto( scan.nextLine() );
        //Fazer o motivo ser sempre diferente de vazio
        System.out.println("Digite a motivação do ajuste no cronograma: ");
        String motivoAlteracao = scan.nextLine(); 
        
        System.out.println("Digite a nova data final desta etapa: ");
        informacoes.setAjustes( converteStringParaData(scan.nextLine() ) );
        

        while( motivoAlteracao.length() < 50){
            System.out.println("Motivo de alteração inválido: deve ter no mínimo 50 caracteres.\nDigite novamente a motivação do ajuste no cronograma: ");
            motivoAlteracao = scan.nextLine(); 
        }
            

        informacoes.setCausa(motivoAlteracao);
        
        //mandar para o banco de dados
        salvarAjusteCronograma(informacoes);
        
        System.out.println("Ajustes de cronograma salvo com sucesso!!!");
    }
    
    /**
    * Converte uma string que representa uma data para um objeto LocalDate.
    * 
    * @param dataStr A string contendo a representação da data no formato "dd/MM/yyyy".
    * @return Um objeto LocalDate representando a data convertida.
    * 
    * Esta função utiliza um formato predefinido "dd/MM/yyyy" para converter a string da data em um objeto LocalDate.
     * Em caso de erro, a função exibe uma mensagem de erro no console e retorna null.
    */
    public LocalDate converteStringParaData(String dataStr){
        LocalDate data = null;
        
        try{
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        data = LocalDate.parse(dataStr, formato);
        
        
        }catch(Exception e){ 
            System.out.println("Erro: " + e.getMessage());
        }
        
        return data;
    }
    
    /**
    * Salva os ajustes feitos no cronograma no banco de dados.
    * 
    * @param informacoes Objeto contendo informações sobre os ajustes no cronograma.
    * 
    * Esta função realiza a conexão com o banco de dados, monta a consulta SQL para inserção das informações
    * dos ajustes no cronograma e executa a consulta. As informações incluem o número da etapa, motivo do ajuste,
    * impacto, risco, nova data de conclusão e o nome do projeto associado. Em caso de erro, uma mensagem de erro
    * é exibida no console.
    * 
    * Pré-condições:
    * - A variável 'informacoes' deve ser acessível e conter informações do ajuste no cronograma.
    * 
    * Pós-condições:
    * - As informações sobre o ajuste no cronograma são inseridas no banco de dados.
    * - Em caso de erro, uma mensagem de erro é exibida no console.
    */
    public void salvarAjusteCronograma(DadosM informacoes){
         try{
           bd.conexao();
           String sql = "insert into ajusteCronograma values(" + informacoes.getEtapa() + ", '" + informacoes.getCausa() + "', '" + informacoes.getImpacto() +"', '" +  informacoes.getRisco() + "', '" +  informacoes.getAjustes() + "', '" + informacoes.getProjeto().getNomeProjeto()+ "' );";
       
           bd.getStatement().execute(sql);
           
           bd.desconecta();
           
           
       }catch(Exception e){
           System.out.println("ERRO: " + e.getMessage());
       }
    }
    
    /**
    * Consulta as informações gerais de um projeto e exibe na console para teste.
    * 
    * @param nomeProjeto Nome do projeto para o qual as informações serão consultadas.
    * 
    * Esta função é destinada apenas para testes e consulta as informações gerais e medições de um projeto
    * utilizando as funções 'resgatarInformacoesGerais' e 'resgatarMedicao'. As informações são exibidas no console.
    * 
    * Pré-condições:
    * - As funções 'resgatarInformacoesGerais' e 'resgatarMedicao' devem estar implementadas e acessíveis.
    * 
    * Pós-condições:
    * - As informações gerais e medições do projeto são exibidas no console.
    */
    public void consultarInfomaçõesGerais(String nomeProjeto){
        resgatarInformaçõesGerais(nomeProjeto);
        resgatarMedicao(nomeProjeto); 
    }
    
    /**
    * Resgata e exibe as informações gerais de um projeto no console.
    * 
    * @param nomeProjeto Nome do projeto para o qual as informações serão resgatadas.
    * 
    * Esta função realiza uma consulta no banco de dados para obter as informações gerais (CNPJ, modelo de gestão,
    * atividades/tecnologias) de um projeto específico. As informações são exibidas no console.
    * 
    * Pré-condições:
    * - O método 'bd.conexao()' deve ser implementado para conectar ao banco de dados.
    * - O método 'bd.getStatement()' deve ser implementado para obter um objeto Statement.
    * - A variável 'bd' deve ser acessível e estar corretamente configurada.
    * 
    * Pós-condições:
    * - As informações gerais do projeto são exibidas no console.
    * - Em caso de erro, uma mensagem de erro é exibida no console.
    */
    public void resgatarInformaçõesGerais(String nomeProjeto){
          try{
           bd.conexao();
           String sql = "select cnpj, modeloGestao, atividadeTecnologia from dadosGerais where nomeProjeto = '" + nomeProjeto + "';";

           rSet = bd.getStatement().executeQuery(sql);

             
            if(rSet.next()){
                System.out.println("--------------------------DadosGerais--------------------------" + "\n" 
                                + "CNPJ..................: " + rSet.getString("cnpj") + "\n"
                                + "Modelo de gestão......: " + rSet.getString("modeloGestao") + "\n"
                                + "Atividades/Tecnologias: " + rSet.getString("atividadeTecnologia"));                    
           }else{
                System.out.println("Projeto não possui dados gerais cadastrados.");
            }
           
           bd.desconecta();
       }catch(Exception e){
           System.out.println("ERRO AO RESGATAR PROJETO: " + e.getMessage());
       }
    }
    
    
    /**
    * Resgata e exibe a quantidade de medições pagas de um projeto no console.
    * 
    * @param nomeProjeto Nome do projeto para o qual a informação será resgatada.
    * 
    * Esta função realiza uma consulta no banco de dados para obter a quantidade de medições pagas de um projeto específico.
    * A quantidade é exibida no console.
    * 
    * Pré-condições:
    * - O método 'bd.conexao()' deve ser implementado para conectar ao banco de dados.
    * - O método 'bd.getStatement()' deve ser implementado para obter um objeto Statement.
    * - A variável 'bd' deve ser acessível e estar corretamente configurada.
    * 
    * Pós-condições:
    * - A quantidade de medições pagas do projeto é exibida no console.
    * - Em caso de erro, uma mensagem de erro é exibida no console.
    */
    public void resgatarMedicao(String nomeProjeto){
        try{
           bd.conexao();
           String sql = "select count(nomeProjeto) as totMedicao from medicao where nomeProjeto = '" + nomeProjeto + "';";

           rSet = bd.getStatement().executeQuery(sql);

             
            if(rSet.next()){
                System.out.println("Quantidade de medições pagas no projeto: " + rSet.getInt("totMedicao"));                    
           }
           
           bd.desconecta();
       }catch(Exception e){
           System.out.println("ERRO AO RESGATAR PROJETO: " + e.getMessage());
       }
    }
    

    
    /**
    * Resgata e exibe as informações do cronograma de um projeto no console.
    * 
    * @param nomeProjeto Nome do projeto para o qual as informações do cronograma serão resgatadas.
    * 
    * Esta função realiza uma consulta no banco de dados para obter as informações do cronograma de um projeto específico.
    * As informações, incluindo número da etapa, nome da etapa, descrição, data de início e data de finalização, são exibidas
    * no console em um formato tabular.
    * 
    * Pré-condições:
    * - O método 'bd.conexao()' deve ser implementado para conectar ao banco de dados.
    * - O método 'bd.getStatement()' deve ser implementado para obter um objeto Statement.
    * - A variável 'bd' deve ser acessível e estar corretamente configurada.
    * 
    * Pós-condições:
    * - As informações do cronograma do projeto são exibidas no console.
    * - Em caso de erro, uma mensagem de erro é exibida no console.
     */
    public void resgatarCronograma(String nomeProjeto){
        try{
           bd.conexao();
           String sql = "select *  from cronograma where nomeProjeto = '" + nomeProjeto + "';";

           rSet = bd.getStatement().executeQuery(sql);

             
            System.out.println("--------------------------CRONOGRAMA--------------------------");  
            while(rSet.next()){
               System.out.println("Número etapa.......: " + rSet.getInt("etapa") + "\n"
                                + "Nome etapa.........: " + rSet.getString("nomeEtapa") + "\n"
                                + "Descrição..........: " + rSet.getString("descEtapa") + "\n"
                                + "Data de início.....: " + rSet.getDate("dataInicio") + "\n"
                                + "Data de finalização: " + rSet.getDate("dataFinal") + "\n" );                           
           }
           
           bd.desconecta();
        }catch(Exception e){
           System.out.println("ERRO AO RESGATAR PROJETO: " + e.getMessage());
        }
    }
    
    
    /**
    * Resgata e exibe as informações de ajustes no cronograma de um projeto no console.
    * 
    * @param nomeProjeto Nome do projeto para o qual as informações de ajustes serão resgatadas.
    * 
    * Esta função realiza uma consulta no banco de dados para obter as informações de ajustes no cronograma de um projeto específico.
    * As informações, incluindo número da etapa alterada, motivo, impactos, riscos e nova data de finalização, são exibidas
    * no console em um formato tabular.
    * 
    * Pré-condições:
    * - O método 'bd.conexao()' deve ser implementado para conectar ao banco de dados.
    * - O método 'bd.getStatement()' deve ser implementado para obter um objeto Statement.
    * - A variável 'bd' deve ser acessível e estar corretamente configurada.
    * 
    * Pós-condições:
    * - As informações de ajustes no cronograma do projeto são exibidas no console.
    * - Em caso de erro, uma mensagem de erro é exibida no console.
    */
    public void resgatarAjusteCronograma(String nomeProjeto){
        try{
           bd.conexao();
           String sql = "select *  from ajusteCronograma where nomeProjeto = '" + nomeProjeto + "';";

           rSet = bd.getStatement().executeQuery(sql);

             
            System.out.println("--------------------------AJUSTES PROJETO--------------------------");  
            while(rSet.next()){
               System.out.println("Número etapa alterada.......: " + rSet.getInt("etapaAlterada") + "\n"
                                + "Motivo......................: " + rSet.getString("motivoAlteracao") + "\n"
                                + "Impactos....................: " + rSet.getString("impactoAlteracao") + "\n"
                                + "Riscos......................: " + rSet.getString("riscoAlteracao") + "\n"
                                + "nova data de finalização....: " + rSet.getDate("novaDataFim") + "\n" );                           
           }
           
           bd.desconecta();
        }catch(Exception e){
           System.out.println("ERRO AO RESGATAR PROJETO: " + e.getMessage());
        }
    }
    
    
}
