import javax.swing.text.html.StyleSheet;

class LampadaTresEstados{
    private int percentState;

    void acende(){
        this.percentState = 100;
    }
    void apaga(){
        this.percentState = 0;
    }
    void mostraEstado(){
        if(percentState == 100){
            System.out.println("A lampada esta acesa");
        }else if(percentState == 0){
            System.out.println("A lampada esta apagada");
        }else{
            System.out.println("A lampada esta em meia luz");
        }
    }

    boolean estaLigada(){
        if(this.percentState == 100)
            return true;
        else  
            return false;
    }
}