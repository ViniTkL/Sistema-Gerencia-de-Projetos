/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.EquipeProjetoM;
import controle.BancoDados;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author anton
 */
public class EquipeProjetoC extends EquipeC{
    EquipeProjetoM equipeProjGeral = new EquipeProjetoM("","", "", "", null, null, 0);
    private BancoDados bd = new BancoDados();
    //pegar os valores do id da equipe a ser cadastrafa, o responsável por ela e o projeto que está trabalhando
    @Override
    public void cadastrarEquipe(){
        Scanner leitor = new Scanner(System.in);
       try{ 
        System.out.println("Informe o id da equipe a ser cadastrada: ");
        int idEquipe = leitor.nextInt();
        
        //limpando buffer do telcado
        leitor.nextLine();
        
        System.out.println("Informe o responsável geral da equipe: ");
        equipeProjGeral.setResponsavelGeral(leitor.nextLine()); 
        
        System.out.println("Digite o nome do projeto: ");
        String nomeProjeto = leitor.nextLine().toUpperCase();
        
        //mandar para o BD
        salvarEquipe(idEquipe, equipeProjGeral.getResponsavelGeral());
        salvarEquipeProjeto(idEquipe, nomeProjeto);
       }catch(Exception e){
           System.out.println("ERRO:" + e.getMessage());
       }
    }
    
    //salva o id e o responsável geral da equipe no banco de dados
    @Override
    public void salvarEquipe(int id, String respGeral){
        try{
           bd.conexao();
           String sql = "insert into equipes values(" + id + ", '" + respGeral + "');";
                   
           bd.getStatement().execute(sql);
           
           bd.desconecta();
           
       }catch(Exception e){
           System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
       }
    }
    
    //salva o id da equipe e o projeto em que ela está atuando
    @Override
    public void salvarEquipeProjeto(int id, String nomeProjeto){
        try{
           bd.conexao();
           String sql = "insert into equipe_projeto values(" + id + ", '" + nomeProjeto + "');";                   
           
           bd.getStatement().execute(sql);
           
           bd.desconecta();
           
       }catch(Exception e){
           System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
       }
    
    }
    
    
    
    //pega o id e a quantiade de integrantes da equipe
    @Override
    public void cadastrarIntegrante(){
        Scanner leitor = new Scanner(System.in);
        try{
        System.out.println("Digite o id da equipe à qual será adiciona os integrantes: ");
        int idEquipe = leitor.nextInt();
        
        System.out.println("Digite quantos integrantes a equipe de projetos têm: ");
        int qtde = leitor.nextInt();
        
        adicionarIntegrantes(qtde, idEquipe);
        }catch(Exception e){
            System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
        }
    }
    
    //Adiciona informações básicas sobre os integrantes
    @Override
    public void adicionarIntegrantes(int qtde, int id){ 
        Scanner leitor = new Scanner(System.in);
        
        try{
        for(int i = 0; i < qtde; i++){
            System.out.println("Informe o nome do "+ (i+1) + "° integrante: ");
            equipeProjGeral.setIntegrantes(leitor.nextLine());
            
            System.out.println("Informe o cargo na administração do projeto para o "+ (i+1) + "° integrante: ");
            equipeProjGeral.setCargoProjeto(leitor.nextLine());
            
            System.out.println("O "+ (i+1) + "° integrante é responsável por alguma etapa?: ");
            char eResponsavelEtapa = Character.toUpperCase(leitor.nextLine().charAt(0) );
            
            cadastrarResponsaveisEtapa(eResponsavelEtapa);
            
            //mandar para o banco de dados
            if(eResponsavelEtapa == 'S')
                salvarIntegrantes(eResponsavelEtapa, equipeProjGeral);
            else
                salvarIntegrantes(eResponsavelEtapa, equipeProjGeral, "");
                
            salvarEquipeIntegrante(id, equipeProjGeral.getIntegrantes());
            }
        }catch(Exception e){
            System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
        }
    }
    
    //Cadastra os responsáveis por etapas, pegando as informações e salvando elas
    @Override
    public void cadastrarResponsaveisEtapa(char eResponsavelEtapa){
        Scanner leitor = new Scanner(System.in);
        
        
        switch(eResponsavelEtapa){
            case 'S' -> {
                System.out.println("Digite a etapa: ");
                equipeProjGeral.setEtapa(leitor.nextInt());
                
                //limpando buffer do teclado
                leitor.nextLine();
            
                System.out.println("Digite a data de inicio da etapa: ");
                equipeProjGeral.setInicioEtapa(converteStringParaData(leitor.nextLine()));
        
                System.out.println("Digite a data final da etapa: ");
                equipeProjGeral.setFimEtapa(converteStringParaData(leitor.nextLine()));
                
                while( !verificaDatasEtapa(equipeProjGeral.getInicioEtapa(), equipeProjGeral.getFimEtapa()) ){
                    System.out.println("Digite a data de inicio da etapa: ");
                    equipeProjGeral.setInicioEtapa( converteStringParaData( leitor.nextLine() ) );

                    System.out.println("Digite a data final da etapa: ");
                    equipeProjGeral.setFimEtapa(converteStringParaData(leitor.nextLine() ) );
                }
            }
            case 'N' -> {
                // -1 significa que ele não é responsável por uma etapa
                equipeProjGeral.setEtapa(-1);
                equipeProjGeral.setInicioEtapa(null);
                equipeProjGeral.setFimEtapa(null);
            }
            default ->{
                System.out.println("Valor incorreto, integrante não receberá responsabiliade de etapas");
                equipeProjGeral.setEtapa(-1);
                equipeProjGeral.setInicioEtapa(null);
                equipeProjGeral.setFimEtapa(null);
            }
            
        }
            
    }
    
    //verifica se as datas de inicio e fim da etapa são válidas
    public boolean verificaDatasEtapa(LocalDate dateInicio, LocalDate dateFinal){
        if( dateFinal.getYear() < dateInicio.getYear() ||  ( dateFinal.getYear() == dateInicio.getYear() && dateFinal.getMonthValue() < dateInicio.getMonthValue() ) ){
            System.out.println("Datas da etapa Inválidas");
            return false;
        }
        
        return true;
    }
    
     //converte uma String que representa uma data para uma LocalDate
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
    
    //salva os integrantes responsáveis por etapa no banco de dados
    @Override
    public void salvarIntegrantes(char eResponsavelEtapa, EquipeProjetoM equipe){
        try{
           bd.conexao();
           String sql = "insert into integrantes values('" + equipe.getIntegrantes() +"', '"+ equipe.getCargoProjeto() + "', NULL, 'P' , '" + eResponsavelEtapa +"', "+ equipe.getEtapa() +", '" + equipe.getInicioEtapa() +"', '" + equipe.getFimEtapa() + "')" ;
                   
           bd.getStatement().execute(sql);
           
           bd.desconecta();
           
       }catch(Exception e){
           System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
       }
    
    }
    
    //salva os integrantes NÃO responsáveis por etapa no banco de dados
    public void salvarIntegrantes(char eResponsavelEtapa, EquipeProjetoM equipe, String dateNull){
        try{
           bd.conexao();
           String sql = "insert into integrantes values('" + equipe.getIntegrantes() +"', '"+ equipe.getCargoProjeto() + "', NULL, 'P' , '" + eResponsavelEtapa +"', NULL, NULL, NULL)" ;
                   
           bd.getStatement().execute(sql);
           
           bd.desconecta();
           
       }catch(Exception e){
           System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
       }
    
    }
    
    //salva o nome do integrante e o id da equipe que ele faz parte no banco de dados
    @Override
    public void salvarEquipeIntegrante(int id, String nomeIntegrante){
        try{
           bd.conexao();
           String sql = "insert into equipe_integrante values(" + id + ", '" + nomeIntegrante + "');";
                   
           bd.getStatement().execute(sql);
           
           bd.desconecta();
           
       }catch(Exception e){
           System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
       }
    
    }



    
   
}
