class Lampada{
    private boolean on;

    void acende(){
        on = true;
    }
    void apaga(){
        on = false;
    }
    void mostraEstado(){
        if(on){
            System.out.println("A lampada esta acesa");
        }else{
            System.out.println("A lampada esta apagada");
        }
    }

    boolean estaLigada(){
        if(this.on)
            return true;
        else
            return false;
    }
}