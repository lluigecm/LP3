public class Lampada{
    private boolean state = false;

    Lampada(boolean state){
        this.state = state;
    }

    public static void main(String[] args) {
        Lampada light = new Lampada(false);
        light.mostraEstado();;

        System.out.println(light.getState());
        light.setState(true);
        light.mostraEstado();
        if(light.estaLigada()){
            System.out.println("Lampada ligada");
        }else{
            System.out.println("Lampada apagada");
        }

    }
    
    public void setState(boolean state){
        this.state = state;
    }
    public boolean getState(){
        return state;
    }
    
    public void acende(){
        state = true;
    }
    public void apaga(){
        state = false;
    }
    public void mostraEstado(){
        if(state){
            System.out.println("A lampada esta acesa");
        }else{
            System.out.println("A lampada esta apagada");
        }
    }

    public boolean estaLigada(){
        return state;
    }
}
