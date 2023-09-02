import java.util.Scanner;
import static java.lang.Math.*;

public class Multimetro {
    public static void main(String[] args) {
        float[] volt = new float [10];
        float media_volt = 0, desvio_P, variancia = 0;
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 10 ; i++){
            volt[i] = scan.nextFloat();
            media_volt += volt[i];
            System.out.println("Leitura " + (i+1) + " : " + volt[i]);
        }
        media_volt /= 10;

        System.out.println("Media: " + media_volt);
        for(int i = 0; i < 10; i++){
            variancia += (float) pow(volt[i]-media_volt, 2);
        }
        variancia /= 10;

        desvio_P = (float) sqrt(variancia);
        System.out.println("Desvio Padrão: " + desvio_P);

        if(desvio_P > (0.1*media_volt)){
            System.out.println("O multimetro está com problea e não pode ser utilizado.");
        }else{
            System.out.println("O multimetro está funcionalidade corretamente e pode ser utilizado.");
        }

    }
}
