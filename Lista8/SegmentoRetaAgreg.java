package Lista8;
import Lista7.Ponto2D;

public class SegmentoRetaComp{
    Ponto2D p1, p2;

    public SegmentoRetaComp(Ponto2D p1, Ponto2D p2){
        this.p1 = new Ponto2D(p1);
        this.p2 = new Ponto2D(p2);
    }

    public float calculaDimensao(){
        return (float) Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + 
            Math.pow((p2.getY() - p1.getY()), 2));
    }

    public String imprimeSegmentoDeReta(){
        return ("P1: " + p1.toString() + "\nP2: " + p2.toString() + "\nDimensao: " + calculaDimensao());
    }
}
