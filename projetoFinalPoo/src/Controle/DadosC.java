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
 *
 * @author vinim
 */

//DEPOIS TEM QUE FAZER A DOCUMENTAÇÃO DA CLASSE E DAS FUNÇÕES
public class DadosC {
    DadosM informacoes = new DadosM();
    private BancoDados bd = new BancoDados();  
    private ResultSet rSet;
   
    public DadosC() {
    
    }
    //Cadastra o cnpj, modelo de gestão e atividades do projeto e manda para o banco de dados
    public void cadastroDadosGerais(){
        cadastraCNPJ();
        adicionarModeloGestao();
        cadastrarAtvdTecnoProjeto();
        
        System.out.println(informacoes.getPessoaJuridica() + "\n" +informacoes.getModeloGestao() + "\n" + informacoes.getAtividadeTecnologia() + "\n" + informacoes.getProjeto().getNomeProjeto());
        
        salvarDadosGerais(informacoes);
    }
    //pegar o nome do projeto e o cpnj da empresa
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
    //remove tudo que não for letras ou numeros da string
    public String removeCaracteresEspeciais(String texto){
        return texto.replaceAll("[^0-9]+","");
    }
    //verifica se o tamanho do cnpj está correto
    public boolean verficaCnpj(String cnpj){
        if(cnpj.length() != 14){
            System.out.println("CNPJ INVÁLIDO, TENTE NOVAMENTE: ");
            return false;
        }
        return true;
    }
    
    
    //adiciona o modelo de gestão
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
    
    
    //adiciona as atividades em uma única string
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
    //pega as atividades digitadas e retorna elas
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
    //verifica se a String possui algum valor que não seja nulo ou vazio
    public boolean verificaString(String texto){
        if( texto == null || texto.equals("") ){
            System.out.println("Digitação inválida, tente novamente");
            return false;
        }
        return true;
    }
    
    
    //salva o cnpj, modelo de gestão e atividades no banco de dados
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
  
    
    //métodod para pegar as informações da medicao e salvar elas no banco de dados
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
        
        System.out.println("ProjetoNome: " + informacoes.getProjeto().getNomeProjeto() + "\n" +
                           "etapaCompletada: " + informacoes.getEtapa() + "\n" +
                           "ValorTotal: " + valorTotal + "\n" +
                           "ValoPagar: " +  informacoes.getMedicao());
        
        //conexão com o BD para atualizar a etapa como completa e o valor da medicao;
        salvarMedicao(informacoes, valorTotal);
    }
    //função para retorna o valor pago na medicao, caso o usuário esteja ou não estja satisfeito com a entrega
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
    //salva a medição no banco de dados
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
    
    //Utilizada para pedir o nome a quantidade de etapas do projeto para inserir as informações no cronograma
    //e depois chama uma função para inserir os dados
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
        //for com o nome da etapa
        //for com o que será feito na etapa
        //for com a data de inicio e fim da etapa
        }catch(Exception e){
            System.out.println("ERRO:" + e.getMessage());
        }
    }
    //Pega as informações referente ao cronograma digitadas pelo usuário e depois chama uma função para salvar no banco de dados
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
        }catch(Exception e){
            System.out.println("ERRO: " + e.getMessage());
        }
    }
    //verifica se as datas de fim e inicio das etapas são válidas
    public boolean verificaDatasEtapa(LocalDate dateInicio, LocalDate dateFinal){
        if( dateFinal.getYear() < dateInicio.getYear() ||  ( dateFinal.getYear() == dateInicio.getYear() && dateFinal.getMonthValue() < dateInicio.getMonthValue() ) ){
            System.out.println("Datas da etapa Inválidas");
            return false;
        }
        
        return true;
    }
   //salva o cronograma no banco de dados
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
    
    
    //métodod para ajustar/mudar o cronograma. Pegar as informações do ajuste e salva no banco de dados
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
    }
    //converte uma string que representa uma data para uma LocalDate
    public LocalDate converteStringParaData(String dataStr){
        LocalDate data = null;
        
        try{
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        data = LocalDate.parse(dataStr, formato);
        
        System.out.println(data);
        
        }catch(Exception e){ 
            System.out.println("Erro: " + e.getMessage());
        }
        
        return data;
    }
    //salva os ajustes feitos no cronograma no banco de dados
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
    
    
    public void menu(){
        Scanner scan = new Scanner(System.in);
                
        int resp = 0;
        while(resp != -1){
            System.out.println("-----------------------MENU-------------------------");
            System.out.print("1 - Cadastrar CPNJ\n2 - Cadastrar Modelo De Gestão\n3 - Cadastrar tecnologias e ativiadades do projeto\n4 - Pagar medição\n5 - Cadastrar cronograma\n6 - Alterar cronograma\n7 - cadastrar projeto\n8 - cadastrar todos os dados gerais\n9 - cadastrar equipe e equipe projeto\n10 - cadastar equipe Exec\n11 - cadastar equipe terceirizada\n-1 - Sair\nEscolha: ");
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
                case 5 ->{
                    cadastrarCronograma();
                }
                case 6 ->{
                    ajustarCronograma();
                }
                case 7 ->{
                    ProjetoC projeto = new ProjetoC();
                    projeto.cadastrarProjeto();
                }
                case 8 ->{
                    cadastroDadosGerais();
                }
                case 9 ->{
                    EquipeProjetoC equipe1 = new EquipeProjetoC();
                    equipe1.cadastrarEquipe();
                    equipe1.cadastrarIntegrante();
                }
                case 10 ->{
                    EquipeExecC equipe2 = new EquipeExecC();
                    equipe2.cadastrarEquipe();
                    equipe2.cadastrarIntegrante();
                }
                case 11 ->{
                    EquipeTerceirizadoC equipe3 = new EquipeTerceirizadoC();
                    equipe3.cadastrarEquipe();
                    equipe3.cadastrarIntegrante();
                }
                case 12->{
                    ProjetoC projeto = new ProjetoC();
                    projeto.consultarInformaçõesProjeto();
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
