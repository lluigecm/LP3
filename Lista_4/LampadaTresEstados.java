public class LampadaTresEstados{
    private int percentState;

    public static void main(String[] args) {
        LampadaTresEstados light = new LampadaTresEstados();

        light.setState(0);
        light.mostraEstado();
        light.estaLigada();

        light.setState(100);
        light.mostraEstado();
        light.estaLigada();

        light.setState(50);
        light.mostraEstado();
        light.estaLigada();

        light.acende();
        light.mostraEstado();

        light.apaga();
        light.mostraEstado();
    }

    public void acende(){
        percentState = 100;
    }
    public void apaga(){
        percentState = 0;
    }

    public void setState(int percent){
        if(percent > 100 || percent < 0)
            System.out.println("Percentual de estado inválido");
        else
            percentState = percent;
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
