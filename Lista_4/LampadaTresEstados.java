public class LampadaTresEstados{
    private int percentState;

    public void acende(){
        percentState = 100;
    }
    public void apaga(){
        percentState = 0;
    }
    public void mostraEstado(){
        if(percentState == 100){
            System.out.println("A lampada esta acesa");
        }else if(percentState == 0){
            System.out.println("A lampada esta apagada");
        }else{
            System.out.println("A lampada esta em meia luz");
        }
    }

    public boolean estaLigada(){
        if(percentState == 100)
            return true;
        else  
            return false;
    }
}
