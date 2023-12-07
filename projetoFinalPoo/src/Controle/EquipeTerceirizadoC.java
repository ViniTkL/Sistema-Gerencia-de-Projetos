/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.EquipeTerceirizadoM;
import controle.BancoDados;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * A classe EquipeTerceirizadoC é uma extensão da classe EquipeC, dedicada a operações específicas relacionadas à equipe de terceirizados de um projeto. 
 * Ela inclui métodos para cadastrar integrantes terceirizados, adicionar informações sobre eles, cadastrar 
 * responsáveis por etapas e salvar essas informações no banco de dados.
 * 
 */
public class EquipeTerceirizadoC extends EquipeC{
    private BancoDados bd = new BancoDados();
    EquipeTerceirizadoM equipeTerc = new EquipeTerceirizadoM(" ", " ", " ", " ", null, null, 0);
    
     /**
     * Cadastra integrantes terceirizados, solicitando a quantidade e adicionando informações sobre cada um. Os dados são salvos no banco de dados.
     * 
     * @param idEquipe ID da equipe.
    */
    @Override
        public void cadastrarIntegrante(int idEquipe){
            Scanner leitor = new Scanner(System.in);

            try{
            System.out.println("Digite quantos integrantes a equipe de terceirizados têm: ");
            int qtde = leitor.nextInt();

            adicionarIntegrantes(qtde, idEquipe);
            }catch(Exception e){
                System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
            }
        }
        
        /**
         * Adiciona informações sobre os integrantes terceirizados da equipe, solicitando o nome, a empresa e o cargo. 
         * Além disso, pergunta se o integrante é responsável por alguma etapa e, caso afirmativo, cadastra essas informações. 
         * Todas as informações são salvas no banco de dados.
         * 
         * @param qtde Quantidade de integrantes terceirizados.
         * @param id ID da equipe.
        */
        @Override
        public void adicionarIntegrantes(int qtde, int id){
            Scanner leitor = new Scanner(System.in);
            try{
            for(int i = 0; i < qtde; i++){
                System.out.println("Informe o nome do "+ (i+1) + "° integrante: ");
                equipeTerc.setIntegrantes(leitor.nextLine().toLowerCase());

                System.out.println("Informe a empresa responsável pelo "+ (i+1) + "° integrante: ");
                equipeTerc.setEmpresa(leitor.nextLine());

                System.out.println("Informe o cargo do "+ (i+1) + "° integrante terceirizado: ");
                String cargoTerc = leitor.nextLine();
                
                System.out.println("O "+ (i+1) + "° integrante é responsável por alguma etapa?: ");
                char eResponsavelEtapa = Character.toUpperCase(leitor.nextLine().charAt(0) );

                cadastrarResponsaveisEtapa(eResponsavelEtapa);

                //mandar para o banco de dados
                if(eResponsavelEtapa == 'S')
                    salvarIntegrantes(eResponsavelEtapa, equipeTerc, cargoTerc);
                else
                    salvarIntegrantes(eResponsavelEtapa, equipeTerc, "", cargoTerc);

                salvarEquipeIntegrante(id, equipeTerc.getIntegrantes());
                
                System.out.println("Integrante salvo com sucesso!!!");
                }   
            }catch(Exception e){
                System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
            }
        }

         /**
         * Cadastra os responsáveis por etapas, coletando informações e salvando-as.
         * 
         * @param eResponsavelEtapa Indica se o integrante é responsável por uma etapa ('S' ou 'N').
        */
        @Override
        public void cadastrarResponsaveisEtapa(char eResponsavelEtapa){
            Scanner leitor = new Scanner(System.in);


            switch(eResponsavelEtapa){
                case 'S' -> {
                    System.out.println("Digite a etapa: ");
                    equipeTerc.setEtapa(leitor.nextInt());

                    //limpando buffer do teclado
                    leitor.nextLine();

                    System.out.println("Digite a data de inicio da etapa: ");
                    equipeTerc.setInicioEtapa(converteStringParaData(leitor.nextLine()));

                    System.out.println("Digite a data final da etapa: ");
                    equipeTerc.setFimEtapa(converteStringParaData(leitor.nextLine()));

                    while( !verificaDatasEtapa(equipeTerc.getInicioEtapa(), equipeTerc.getFimEtapa()) ){
                        System.out.println("Digite a data de inicio da etapa: ");
                        equipeTerc.setInicioEtapa( converteStringParaData( leitor.nextLine() ) );

                        System.out.println("Digite a data final da etapa: ");
                        equipeTerc.setFimEtapa(converteStringParaData(leitor.nextLine()));
                    }
                }
                case 'N' -> {
                    // -1 significa que ele não é responsável por uma etapa
                    equipeTerc.setEtapa(-1);
                    equipeTerc.setInicioEtapa(null);
                    equipeTerc.setFimEtapa(null);
                }
                default ->{
                    System.out.println("Valor incorreto, integrante não receberá responsabiliade de etapas");
                    equipeTerc.setEtapa(-1);
                    equipeTerc.setInicioEtapa(null);
                    equipeTerc.setFimEtapa(null);
                }

            }
        }
      
        /**
          * Verifica se as datas de início e fim da etapa são válidas.
          * 
          * @param dateInicio Data de início da etapa.
          * @param dateFinal Data de fim da etapa.
          * @return true se as datas são válidas, false caso contrário.
         */
        public boolean verificaDatasEtapa(LocalDate dateInicio, LocalDate dateFinal){
            if( dateFinal.getYear() < dateInicio.getYear() ||  ( dateFinal.getYear() == dateInicio.getYear() && dateFinal.getMonthValue() < dateInicio.getMonthValue() ) ){
                System.out.println("Datas da etapa Inválidas");
                return false;
            }

            return true;
        }
        
         /**
          * Converte uma String que representa uma data para um objeto LocalDate.
          * 
          * @param dataStr String representando a data.
          * @return Objeto LocalDate.
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
     * Salva os integrantes responsáveis por etapas no banco de dados.
     * 
     * @param eResponsavelEtapa Indica se o integrante é responsável por uma etapa ('S').
     * @param equipe Instância da classe EquipeTerceirizadoM contendo informações do integrante.
     * @param cargo Cargo do integrante terceirizado.
    */
    @Override
    public void salvarIntegrantes(char eResponsavelEtapa, EquipeTerceirizadoM equipe, String cargo){
        try{
           bd.conexao();
           String sql = "insert into integrantes values('" + equipe.getIntegrantes() +"', '" + cargo + "', '"+ equipe.getEmpresa() +"', 'T' , '" + eResponsavelEtapa +"', "+ equipe.getEtapa() +", '" + equipe.getInicioEtapa() +"', '" + equipe.getFimEtapa() + "')" ;
                   
           bd.getStatement().execute(sql);
           
           bd.desconecta();
           
       }catch(Exception e){
           System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
       }
    
    }
    
   /**
     * Salva os integrantes não responsáveis por etapa no banco de dados.
     * 
     * @param eResponsavelEtapa Indica se o integrante é responsável por uma etapa ('N').
     * @param equipe Instância da classe EquipeTerceirizadoM contendo informações do integrante.
     * @param dateNull String representando uma data nula.
     * @param cargo Cargo do integrante terceirizado.
    */
    public void salvarIntegrantes(char eResponsavelEtapa, EquipeTerceirizadoM equipe, String dateNull, String cargo){
        try{
           bd.conexao();
           String sql = "insert into integrantes values('" + equipe.getIntegrantes() +"', '" + cargo + "', '" + equipe.getEmpresa() + "', 'T' , '" + eResponsavelEtapa +"', NULL, NULL, NULL)" ;
                   
           bd.getStatement().execute(sql);
           
           bd.desconecta();
           
       }catch(Exception e){
           System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
       }
    
    }
    
     /**
     * Salva o nome do integrante e o ID da equipe à qual ele pertence no banco de dados.
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
