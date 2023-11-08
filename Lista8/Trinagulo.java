package Lista8;
import Lista7.Ponto2D;

public class Triangulo{
    Ponto2D p1, p2, p3;

    public Triangulo(Ponto2D p1, Ponto2D p2, Ponto2D p3){
        if(isValid(p1, p2, p3)){
            this.p1 = new Ponto2D(p1);
            this.p2 = new Ponto2D(p2);
            this.p3 = new Ponto2D(p3);
        }else{
            System.out.println("Triangulo invalido");
        }
    }

    private boolean isValid(Ponto2D p1, Ponto2D p2, Ponto2D p3){
        if(p1.distancia(p2) + p1.distancia(p3) <= p2.distancia(p3))
            return false;
        else if(p1.distancia(p3) + p3.distancia(p2) <= p2.distancia(p1))
            return false;
            else if (p1.distancia(p2) + p2.distancia(p3) <= p1.distancia(p3))
                return false;
        return true;
    }

    public String imprimeTriangulo(){
        return "P1: " + p1.imprimePonto() + "\nP2: " + p2.imprimePonto() + "\nP3: " + p3.imprimePonto();
    }

    public boolean isRetangulo(){
        float hipotenusa;
        
        if(p1.distancia(p2) > p1.distancia(p3) && p1.distancia(p2) > p2.distancia(p3))
            hipotenusa = p1.distancia(p2);
        else if(p1.distancia(p3) > p1.distancia(p2) && p1.distancia(p3) > p2.distancia(p3))
            hipotenusa = p1.distancia(p3);
        else
            hipotenusa = p2.distancia(p3);

        if(Math.pow(hipotenusa, 2) == Math.pow(p1.distancia(p2), 2) + Math.pow(p1.distancia(p3), 2))
            return true;
        
        return false;
    }

    public boolean isIsoceles(){
        if (p1.distancia(p2) == p1.distancia(p3) || p1.distancia(p2) == p2.distancia(p3) || p1.distancia(p3) == p2.distancia(p3))
            return true;
        return false;
    }

    public boolean isEquilatero(){
        if(p1.distancia(p2) == p1.distancia(p3) && p1.distancia(p2) == p2.distancia(p3))
            return true;
        return false;
    }
}