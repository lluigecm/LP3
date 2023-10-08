class LampadaTresEstados{
    private int percentState;

    void acende(){
        percentState = 100;
    }
    void apaga(){
        percentState = 0;
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
        if(percentState == 100)
            return true;
        else  
            return false;
    }
}
