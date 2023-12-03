
package Controle;

import Modelo.EquipeM;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class EquipeC {
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        
        //ArrayList para armazenar as informações
        ArrayList<EquipeM> listaInformacoes = new ArrayList<>();
        
        //Obter informações do usuário e adicionar à lista
        
        for (int i = 1; i <= 2; i++) { //Nota mental: Pedir a informação para o usuário antes
            
            System.out.println("Informe os integrantes (separados por vírgula): ");
            String integrantes = leitor.nextLine();

            System.out.println("Informe o responsável geral: ");
            String responsavelGeral = leitor.nextLine();

            System.out.println("Informe os responsáveis pela etapa (separados por vírgula): ");
            String responsaveisEtapa = leitor.nextLine();

            System.out.println("Informe a data de início da etapa (no formato YYYY-MM-DD): ");
            String inicioEtapaStr = leitor.nextLine();
            LocalDate inicioEtapa = LocalDate.parse(inicioEtapaStr);
            
            System.out.println("Informe a data de fim da etapa (no formato YYYY-MM-DD): ");
            String fimEtapaStr = leitor.nextLine();
            LocalDate fimEtapa = LocalDate.parse(fimEtapaStr);
            
            System.out.println("Informe o número da etapa: ");
            int etapa = leitor.nextInt();
            leitor.nextLine();

            // Adicionar informações à lista
            listaInformacoes.add(new EquipeM(integrantes, responsavelGeral, responsaveisEtapa, inicioEtapa, fimEtapa, etapa));
        }
        
        //Como acessar as informações na lista
        for (EquipeM informacao : listaInformacoes) {
            System.out.println("Integrantes: " + informacao.getIntegrantes());
            System.out.println("Responsavel Geral: " + informacao.getResponsavelGeral());
            System.out.println("Responsaveis Etapa: " + informacao.getResponsaveisEtapa());
            System.out.println("Inicio Etapa: " + informacao.getInicioEtapa());
            System.out.println("Fim Etapa: " + informacao.getFimEtapa());
            System.out.println("Etapa: " + informacao.getEtapa());
            System.out.println("-------------------------");
            
        }
        
    }
}
