import java.lang.Math;

public class Ponto2D{
    private double x, y;

    public void setEixoX(double x){
        this.x = x;
    }

    public void setEixoY(double y){
        this.y = y;
    }

    public double getEixoX(){
        return x;
    }

    public double getEixoY(){
        return y;
    }

    public void imprimirPonto(){
        System.out.println("O ponto esta nas coordenadas (" + x + ", " + y + ")");
    }

    public boolean isEixoX(){
        if(x==0)
            return true;
        else
            return false;
    }
    public boolean isEixoY(){
        if(y==0)
            return true;
        else
            return false;
    }
    public isEixos(){
        if(x == 0 && y ==0)
            return true;
        else
            return false;
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

    public double distancia(Ponto2D rand){
        return Math.sqrt(Math.pow(rand.x - this.x, 2) + Math.pow(rand.y - this.y, 2));
    }
    
 }
