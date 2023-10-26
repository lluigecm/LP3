import java.lang.Math;

public class Ponto2D{
    private float x, y;
    private boolean init = false;

    Ponto2D(float x, float y){
        this.x = x;
        this.y = y;
        this.init = true;
    }
    Ponto2D(){
        this(0, 0);
    }

    public static void main(String[] args) {
        Ponto2D randP = new Ponto2D(15.7F, -25F);
        Ponto2D randP2 = new Ponto2D(-20F, 15.7F);

        System.out.println("Ponto p1: ");
        randP.setEixoX(12.5F);
        randP.setEixoY(-15.2F);
        randP.imprimirPonto();
        System.out.println("O ponto p1 esta no " + randP.quadrante() + "º quadrante");


        System.out.println("Ponto P2: ");
        randP2.setEixoX(-10.7F);
        randP2.setEixoY(-14.8F);
        randP2.imprimirPonto();
        System.out.println("O ponto p2 esta no " + randP2.quadrante() + "º quadrante");


        if(randP.isEixoX())
            System.out.println("O ponto esta sobre o eixo x");
        if(randP.isEixoY())
            System.out.println("O ponto esta sobre o eixo y");
        if(randP.isEixos())
            System.out.println("O ponto esta sobre o eixo x, e o eixo y");

        System.out.println("Distancia entre os pontos: " + (float) Math.round((randP.distancia(randP2)*100.0F)/100.0F));
        System.out.println("Distancia para (12, 5): " + (float) Math.round((randP.distancia(12F, 5F)*100.0F)/100.0F));
        System.out.println("Distancia para (0, 0): " + (float) Math.round((randP.distancia()*100.0F)/100.0F));

    }

    public void setEixoX(float x){
        if(!init)
            this.x = x;
        else
            System.out.println("Valor imutavel!!");
    }

    public void setEixoY(float y){
        if(!init)
            this.y = y;
        else
            System.out.println("Valor imutavel!!");
    }

    public float getEixoX(){
        return x;
    }

    public float getEixoY(){
        return y;
    }

    public void imprimirPonto(){
        System.out.println("O ponto esta nas coordenadas (" + x + ", " + y + ")");
    }

    public boolean isEixoX(){
        return x == 0;
    }
    public boolean isEixoY(){
        return y == 0;
    }
    public boolean isEixos(){
        return x == 0 && y == 0;
    }

    public int quadrante(){
        if(isEixos())
            return 0;
        else{
            if(x > 0 && y > 0)
                return 1;
            else if(x < 0 && y > 0)
                return 2;
            else if(x < 0 && y < 0)
                return 3;
            else
                return 4;
        }
    }

    public float distancia(float x, float y){
        return (float) Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    }
    public float distancia(Ponto2D rand){
        return distancia(rand.x, rand.y);
    }
    public float distancia(){
        return distancia(0, 0);
    }
}

