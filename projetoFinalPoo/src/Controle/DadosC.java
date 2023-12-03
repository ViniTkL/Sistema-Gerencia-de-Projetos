/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DadosM;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            informacoes.setAtividadeTecnologia(adicionarAtvdTecno()); 
            
            //mandar para o banco de dados 
        }
    }
    
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
    
    public boolean verificaString(String texto){
        if( texto == null || texto.equals("") ){
            System.out.println("Modelo de gestão inválido, tente novamente");
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
        
        System.out.println("Digite o nome do projeto que terá a medição paga: ");
        projetoNome = scan.nextLine();
        
        System.out.println("Qual etapa do projeto foi completa?: ");
        etapaCompletada = scan.nextInt();
        
        System.out.println("Qual o valor cheio a ser paga nesta medição?: ");
        valorTotal = scan.nextDouble();
        
        scan.nextLine();
        
        System.out.println("A entrega foi satisfatória?[S/N]: ");
        satisfacao = Character.toUpperCase(scan.nextLine().charAt(0));
        
        informacoes.setMedicao(valorPagoMedicao(satisfacao, valorTotal));
        
        System.out.println("ProjetoNome: " + projetoNome + "\n" +
                           "etapaCompletada: " + etapaCompletada + "\n" +
                           "ValorTotal: " + valorTotal + "\n" +
                           "ValoPagar: " +  informacoes.getMedicao());
        
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
    
    
    
    public void cadastrarCronograma(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite a quantidade de etapas que o proejto possui: ");
        int quantidadeEtapas = scan.nextInt();
        
        for(int i = 0; i < quantidadeEtapas; i++ ){
            inserirInformacoesCronograma();
        }
        //for com o nome da etapa
        //for com o que será feito na etapa
        //for com a data de inicio e fim da etapa
    }
    
    public void inserirInformacoesCronograma(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite o número da etapa: ");
        int numEtapa = scan.nextInt();
        
        scan.nextLine();
        
        System.out.println("Digite o nome da etapa " + numEtapa + ": ");
        String nomeEtapa = scan.nextLine();
        
        System.out.println("Digite oque será feito na etapa " + numEtapa + ": ");
        String descricaoEtapa = scan.nextLine();
        
        System.out.println("Digite a data de início da etapa " + numEtapa + ": ");
        LocalDate dataInicio = converteStringParaData( scan.nextLine() );
        
        System.out.println("Digite a data de conclusão da etapa " + numEtapa + ": ");
        LocalDate dataFinal =  converteStringParaData(scan.nextLine());
        
        while( !verificaDatasEtapa(dataInicio, dataFinal) ){
            System.out.println("Digite a data de início da etapa " + numEtapa + ": ");
            dataInicio = converteStringParaData( scan.nextLine() );
        
            System.out.println("Digite a data de conclusão da etapa " + numEtapa + ": ");
            dataFinal =  converteStringParaData(scan.nextLine());
        }
        
        
        
        //mandar para o banco de dados :)
    }
    
    public boolean verificaDatasEtapa(LocalDate dateInicio, LocalDate dateFinal){
        if( dateFinal.getYear() < dateInicio.getYear() || dateFinal.getMonthValue() < dateInicio.getMonthValue() ){
            System.out.println("Datas da etapa Inválidas");
            return false;
        }
        
        return true;
    }
   
    
    
    public void ajustarCronograma(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Qual projeto terá o cronograma ajustado: ");
        String nomeProjeto = scan.nextLine();
        
        System.out.println("Qual etapa do projeto será alterada: ");
        int etapa = scan.nextInt();
        
        scan.nextLine();
        
        System.out.println("Digite o risco do ajuste feito: ");
        String riscoAlteracao = scan.nextLine();
        
        System.out.println("Digite o impacto que esse ajuste causará no projeto: ");
        String impactoAlteracao = scan.nextLine();
        //Fazer o motivo ser sempre diferente de vazio
        System.out.println("Digite a motivação do ajuste no cronograma: ");
        String motivoAlteracao = scan.nextLine(); 
        
        System.out.println("Digite a nova data final desta etapa: ");
        LocalDate dataAjustada = converteStringParaData(scan.nextLine());
        
        informacoes.setEtapa(etapa);
        informacoes.setImpacto(impactoAlteracao);
        informacoes.setRisco(riscoAlteracao);
        informacoes.setAjustes(dataAjustada);
        informacoes.setNomeEtapa(nomeProjeto);

        while( motivoAlteracao.length() < 50){
            System.out.println("Motivo de alteração inválido: deve ter no mínimo 50 caracteres.\nDigite novamente a motivação do ajuste no cronograma: ");
            motivoAlteracao = scan.nextLine(); 
        }
            

        informacoes.setCausa(motivoAlteracao);
        
        //mandar para o banco de dados
    }
    
    public LocalDate converteStringParaData(String dataStr){
        LocalDate data = null;
        
        try{
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        data = LocalDate.parse(dataStr, formato);
        
        System.out.println(data);
        
        }catch(Exception e){ 
            e.printStackTrace();
        }
        
        return data;
    }
    
    
    
    
    public void menu(){
        Scanner scan = new Scanner(System.in);
                
        int resp = 0;
        while(resp != -1){
            System.out.println("-----------------------MENU-------------------------");
            System.out.print("1 - Cadastrar CPNJ\n2 - Cadastrar Modelo De Gestão\n3 - Cadastrar tecnologias e ativiadades do projeto\n4 - Pagar medição\n5 - Cadastrar cronograma\n6 - Alterar cronograma\n-1 - Sair\nEscolha: ");
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
