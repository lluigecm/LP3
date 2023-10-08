public class Lampada{
    private boolean on;

    public void acende(){
        on = true;
    }
    public void apaga(){
        on = false;
    }
    public void mostraEstado(){
        if(on){
            System.out.println("A lampada esta acesa");
        }else{
            System.out.println("A lampada esta apagada");
        }
    }

    public boolean estaLigada(){
        if(this.on)
            return true;
        else
            return false;
    }
}
