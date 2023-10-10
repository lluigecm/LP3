public class Lampada{
    private boolean on = false;

    public static void main(String[] args) {
        Lampada light = new Lampada();

        light.mostraEstado();
        light.acende();
        light.mostraEstado();;
        if(light.estaLigada()){
            System.out.println("Lampada ligada");
        }else{
            System.out.println("Lampada apagada");
        }

    }

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
        return on;
    }
}
