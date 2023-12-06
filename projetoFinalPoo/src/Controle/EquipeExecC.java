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
 *
 * @author anton
 */
public class EquipeExecC extends EquipeC{
        private BancoDados bd = new BancoDados();
        EquipeExecM equipe = new EquipeExecM(" ", " ", " ", " ", null, null, 0);

        @Override
        public void cadastrarIntegrante(){
            Scanner leitor = new Scanner(System.in);
            
            try{
            System.out.println("Digite o id da equipe à qual será adiciona os integrantes: ");
            int idEquipe = leitor.nextInt();

            System.out.println("Digite quantos integrantes a equipe de execução têm: ");
            int qtde = leitor.nextInt();

            adicionarIntegrantes(qtde, idEquipe);
            }catch(Exception e){
                System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
            }
                    
        }
        
        @Override
        public void adicionarIntegrantes(int qtde, int id){
            Scanner leitor = new Scanner(System.in);
            
            try{
            for(int i = 0; i < qtde; i++){
                System.out.println("Informe o nome do "+ (i+1) + "° integrante: ");
                equipe.setIntegrantes(leitor.nextLine());

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
                }
            }catch(Exception e){
                System.out.println("ERRO AO SALVAR DADOS: " + e.getMessage());
            }
        }

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
    
    //salva os integrantes NÃO responsáveis por etapa no banco de dados
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


