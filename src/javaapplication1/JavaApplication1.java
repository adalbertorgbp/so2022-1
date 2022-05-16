

package javaapplication1;

import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

public class JavaApplication1 {

    static int n_processos = 4;  
    int[] id = new int[n_processos];
    static int[] tempo_execucao = new int[n_processos];
    static int[] tempo_espera = new int[n_processos];
    static int[] tempo_restante = new int[n_processos];
     
    public static void main(String[] args) {
      
      int aleatorio;
      
      //Popular Processos
      Scanner teclado = new Scanner (System.in);
      Random random = new Random();
      
      System.out.print("Será aleatório?:  ");
      aleatorio =  teclado.nextInt();
      
      for (int i = 0; i < n_processos; i++) {
        //Popular Processos Aleatorio
        if (aleatorio == 1){
            tempo_execucao[i] = random.nextInt(10)+1;
        }
        //Popular Processos Manual
        else {
            System.out.print("Digite o tempo de execução do processo["+i+"]:  ");
            tempo_execucao[i] = teclado.nextInt();
        }
        tempo_restante[i] = tempo_execucao[i];
      }
      
      //Imprime lista de processos
      for (int i = 0; i < n_processos; i++) {
          System.out.println("Process["+i+"]: tempo_execucao="+ tempo_execucao[i] + " tempo_restante="+tempo_restante[i]);
      }
      
      //Escolher algoritmo
      int alg;
      
      
      System.out.print("Escolha o argoritmo?: [1=FCFS 2=SJF Preemptivo 3=SJF Não Preemptivo]: ");
      alg =  teclado.nextInt();
     
      
      if (alg == 1) { //FCFS
          FCFS();
      }
      else if (alg == 2) {
          SJF_preemptivo();
      }
      else if (alg == 3) {
          SJF_nao_preemptivo();
        
      }
      
     
    
    //Calcula e imprime estatisticas
    float tempo_total = 0;
    for (int i = 0; i < n_processos; i++) {
          System.out.println("Process["+i+"]: tempo_espera="+ tempo_espera[i]);
          tempo_total = tempo_espera[i] + tempo_total;
    }
    System.out.println("Tempo medio de espera: "+tempo_total/n_processos);
       
              
    }
    
    public static void FCFS(){
        //Executar processos
      int processo_em_execucao;
      processo_em_execucao = 0;
      for (int tempo = 1; tempo<= 1000; tempo++){
          try {
              if (tempo_restante[processo_em_execucao] == tempo_execucao[processo_em_execucao])
                    tempo_espera[processo_em_execucao] = tempo -1;
                
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
    }
    
    public static void SJF_preemptivo(){
        //Executar processo preemptivo
      int processo_em_execucao;
      processo_em_execucao = 0;
      for (int tempo = 1; tempo<= 1000; tempo++){
          try {
              if (tempo_restante[processo_em_execucao] == tempo_execucao[processo_em_execucao])
                    tempo_espera[processo_em_execucao] = tempo -1;
                
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
    }
    public static void SJF_nao_preemptivo(){
        //Executar processo não peemptivo
      int processo_em_execucao;
      processo_em_execucao = 0;
      for (int tempo = 1; tempo<= 1000; tempo++){
          try {
              if (tempo_restante[processo_em_execucao] == tempo_execucao[processo_em_execucao])
                    tempo_espera[processo_em_execucao] = tempo -1;
                
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
    }
}
