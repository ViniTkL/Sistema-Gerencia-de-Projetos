/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.EquipeExecM;
import controle.BancoDados;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * A classe EquipeExecC é uma extensão da classe EquipeC e controla as operações específicas
 * relacionadas à equipe de execução de um projeto. Ela implementa métodos para cadastrar integrantes,
 * adicionar integrantes, cadastrar responsáveis por etapa, e salvar informações no banco de dados.
 * 
 */
public class EquipeExecC extends EquipeC{
        private BancoDados bd = new BancoDados();
        EquipeExecM equipe = new EquipeExecM(" ", " ", " ", " ", null, null, 0);
        
         /**
           * Cadastra integrantes na equipe de execução.
           * 
           * @param idEquipe ID da equipe a ser associada.
        */
        @Override
        public void cadastrarIntegrante(int idEquipe){
            Scanner leitor = new Scanner(System.in);
            
            try{
            System.out.println("Digite quantos integrantes a equipe de execução têm: ");
            int qtde = leitor.nextInt();

            adicionarIntegrantes(qtde, idEquipe);
            }catch(Exception e){
                System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
            }
                    
        }
        
        /**
            * Adiciona integrantes à equipe de execução.
            * 
            * @param qtde Quantidade de integrantes a serem adicionados.
            * @param id ID da equipe.
        */
        @Override
        public void adicionarIntegrantes(int qtde, int id){
            Scanner leitor = new Scanner(System.in);
            
            try{
            for(int i = 0; i < qtde; i++){
                System.out.println("Informe o nome do "+ (i+1) + "° integrante: ");
                equipe.setIntegrantes(leitor.nextLine().toLowerCase());

                System.out.println("Informe o cargo na empresa do "+ (i+1) + "° integrante: ");
                equipe.setCargoEmpresa(leitor.nextLine());

                System.out.println("O "+ (i+1) + "° integrante é responsável por alguma etapa?: ");
                char eResponsavelEtapa = Character.toUpperCase(leitor.nextLine().charAt(0) );

                cadastrarResponsaveisEtapa(eResponsavelEtapa);

                //mandar para o banco de dados
                if(eResponsavelEtapa == 'S')
                    salvarIntegrantes(eResponsavelEtapa, equipe);
                else
                    salvarIntegrantes(eResponsavelEtapa, equipe, "");

                salvarEquipeIntegrante(id, equipe.getIntegrantes());
                
                System.out.println("Integrante salvo com sucesso!!!");
                }
            }catch(Exception e){
                System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
            }
        }

        /**
            * Cadastra os responsáveis por uma etapa na equipe de execução.
            * 
            * @param eResponsavelEtapa Caractere indicando a responsabilidade pela etapa.
        */
        @Override
        public void cadastrarResponsaveisEtapa(char eResponsavelEtapa){
            Scanner leitor = new Scanner(System.in);


            switch(eResponsavelEtapa){
                case 'S' -> {
                    System.out.println("Digite a etapa: ");
                    equipe.setEtapa(leitor.nextInt());

                    //limpando buffer do teclado
                    leitor.nextLine();

                    System.out.println("Digite a data de inicio da etapa: ");
                    equipe.setInicioEtapa(converteStringParaData(leitor.nextLine()));

                    System.out.println("Digite a data final da etapa: ");
                    equipe.setFimEtapa(converteStringParaData(leitor.nextLine()));

                    while( !verificaDatasEtapa(equipe.getInicioEtapa(), equipe.getFimEtapa()) ){
                        System.out.println("Digite a data de inicio da etapa: ");
                        equipe.setInicioEtapa( converteStringParaData( leitor.nextLine() ) );

                        System.out.println("Digite a data final da etapa: ");
                        equipe.setFimEtapa(converteStringParaData(leitor.nextLine() ) );
                    }
                }
                case 'N' -> {
                    // -1 significa que ele não é responsável por uma etapa
                    equipe.setEtapa(-1);
                    equipe.setInicioEtapa(null);
                    equipe.setFimEtapa(null);
                }
                default ->{
                    System.out.println("Valor incorreto, integrante não receberá responsabiliade de etapas");
                    equipe.setEtapa(-1);
                    equipe.setInicioEtapa(null);
                    equipe.setFimEtapa(null);
                }

            }
        }
      
         /**
            * Verifica se as datas de início e fim da etapa são válidas.
            * 
            * @param dateInicio Data de início da etapa.
            * @param dateFinal Data final da etapa.
            * @return True se as datas são válidas, False caso contrário.
        */
        public boolean verificaDatasEtapa(LocalDate dateInicio, LocalDate dateFinal){
            if( dateFinal.getYear() < dateInicio.getYear() ||  ( dateFinal.getYear() == dateInicio.getYear() && dateFinal.getMonthValue() < dateInicio.getMonthValue() ) ){
                System.out.println("Datas da etapa Inválidas");
                return false;
            }

            return true;
        }
        
        /**
            * Converte uma String que representa uma data para uma LocalDate.
            * 
            * @param dataStr String que representa a data.
            * @return Objeto LocalDate representando a data.
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
            * Salva os integrantes responsáveis por etapa no banco de dados.
            * 
            * @param eResponsavelEtapa Caractere indicando a responsabilidade pela etapa.
            * @param equipe Objeto da classe EquipeExecM.
        */
    @Override
    public void salvarIntegrantes(char eResponsavelEtapa, EquipeExecM equipe){
        try{
           bd.conexao();
           String sql = "insert into integrantes values('" + equipe.getIntegrantes() +"', '"+ equipe.getCargoEmpresa()+ "', NULL, 'E' , '" + eResponsavelEtapa +"', "+ equipe.getEtapa() +", '" + equipe.getInicioEtapa() +"', '" + equipe.getFimEtapa() + "')" ;
                   
           bd.getStatement().execute(sql);
           
           bd.desconecta();
           
       }catch(Exception e){
           System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
       }
    
    }
    
    /**
            * Salva os integrantes não responsáveis por etapa no banco de dados.
            * 
            * @param eResponsavelEtapa Caractere indicando a responsabilidade pela etapa.
            * @param equipe Objeto da classe EquipeExecM.
            * @param dateNull String representando data nula.
        */
    public void salvarIntegrantes(char eResponsavelEtapa, EquipeExecM equipe, String dateNull){
        try{
           bd.conexao();
           String sql = "insert into integrantes values('" + equipe.getIntegrantes() +"', '"+ equipe.getCargoEmpresa()+ "', NULL, 'E' , '" + eResponsavelEtapa +"', NULL, NULL, NULL)" ;
                   
           bd.getStatement().execute(sql);
           
           bd.desconecta();
           
       }catch(Exception e){
           System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
       }
    
    }
    
    /**
            * Salva o nome do integrante e o ID da equipe que ele faz parte no banco de dados.
            * 
            * @param id ID da equipe.
            * @param nomeIntegrante Nome do integrante.
        */
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


