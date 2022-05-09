

package javaapplication1;

import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

public class JavaApplication1 {

     
    public static void main(String[] args) {
      
      
      final int n_processos = 4;  
      
      
      int[] id = new int[n_processos];
      int[] tempo_execucao = new int[n_processos];
      int[] tempo_espera = new int[n_processos];
      int[] tempo_restante = new int[n_processos];
      int aleatorio;
     
      Scanner teclado = new Scanner (System.in);
      Random random = new Random();
      
      System.out.print("Será aleatório?:  ");
      aleatorio =  teclado.nextInt();
      
      //sim = random. nextInt(30);
      for (int i = 0; i < n_processos; i++) {
        if (aleatorio == 1){
            tempo_execucao[i] = random.nextInt(10)+1;
        }
        else {
            System.out.print("Digite o tempo de execução do processo["+i+"]:  ");
            tempo_execucao[i] = teclado.nextInt();
        }
        tempo_restante[i] = tempo_execucao[i];
      }
      
      for (int i = 0; i < n_processos; i++) {
          System.out.println("Process["+i+"]: tempo_execucao="+ tempo_execucao[i] + " tempo_restante="+tempo_restante[i]);
      }
    
      int processo_em_execucao;
      processo_em_execucao = 0;
      
     
      
      for (int tempo = 1; tempo<= 1000; tempo++){
          try {
              if (tempo_restante[processo_em_execucao] == tempo_execucao[processo_em_execucao])
                    tempo_espera[processo_em_execucao] = tempo;
                
            if (tempo_restante[processo_em_execucao]!=1){ 
                
                if (processo_em_execucao != (n_processos)) {
                    System.out.println("tempo["+tempo+"]: processo["+processo_em_execucao+"] restante="+(tempo_restante[processo_em_execucao]-1));
                    tempo_restante[processo_em_execucao]--;
                }
                else
                    break;
            }
            else {
                System.out.println("tempo["+tempo+"]: processo["+processo_em_execucao+"] restante="+(tempo_restante[processo_em_execucao]-1));
                tempo_restante[processo_em_execucao]--;
                if ((processo_em_execucao+1) != (n_processos))
                    processo_em_execucao++;
                else
                    break;
            }
            
//            Thread.sleep(1000);
          }
          catch (Exception e) {
            
            // catching the exception
            System.out.println(e);
        }
      }
    
    int tempo_total = 0;
    for (int i = 0; i < n_processos; i++) {
          System.out.println("Process["+i+"]: tempo_espera="+ tempo_espera[i]);
          tempo_total = tempo_espera[i] + tempo_total;
    }
    
    System.out.println("Tempo medio de espera: "+tempo_total/n_processos);
       
              
    }
   
}
