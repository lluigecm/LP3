import java.util.*;


public class Craps {
    public static void main(String[] args) {
        Random gerador = new Random();
        int ponto = -1, lancamento = 1;

        while(true){
            int dado1 = gerador.nextInt(6 ) + 1;
            int dado2 = gerador.nextInt(6 ) + 1;
            int soma = 0;

            soma = dado1 + dado2;
            if (lancamento == 2){
                System.out.println("Iniciando estágio 2");
            }
            if (lancamento == 1){
                System.out.println("Dado 1: " + dado1 + ", Dado 2: " + dado2);
            }else{
                System.out.println("Jogada " + lancamento + ": " + soma);
            }

            if(lancamento == 1 && soma != 7 && soma > 3 && soma < 11) {
                System.out.println("Ponto: " + soma);
                ponto = soma;
            }

            if((soma == 7 || soma == 11) && lancamento == 1){
                System.out.println("Voce venceu");
                break;
            } else if (lancamento !=1 && soma == ponto) {
                System.out.println("Voce venceu");
                break;
            }

            if(soma == 2 || soma == 3 || soma == 12 || (soma == 7 && lancamento != 1)){
                System.out.println("Você perdeu!!");
                break;
            }
            lancamento++;
        }

    }
}
