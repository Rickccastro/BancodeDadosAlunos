package hbd;

import java.util.List;

import hbd.entities.Alunos;

import hbd.operations.*;


public class App {
	

    public static void main(String[] args) {
    	hbdOperations hbdOperations = new hbdOperations();
  
    	 /*Exibindo todos os alunos e data de nascimento de cada um respectivamente*/
        List<Alunos> alunos = hbdOperations.obterTodosAlunos();
        hbdOperations.exibirAlunos(alunos);
        
        /*Exibindo todos os alunos matriculados*/
        Long totalAlunos = hbdOperations.obterTotalAlunos();
        
        System.out.println("Número total de alunos matriculados: " + totalAlunos);

        /*Operação update passando por parametro o novo nome*/
        hbdOperations.atualizarAlunoPeloNome("Windson Parmezan", "Ricardo Parmezan");

       
        hbdOperations.fecharRecursos();
        System.out.println("Fim da execução da classe principal.");
    }

  }

    	
