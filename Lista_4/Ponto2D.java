import java.lang.Math;

class Ponto2D{
    private double x, y;

    void setEixoX(double x){
        this.x = x;
    }

    void setEixoY(double y){
        this.y = y;
    }

    double getEixoX(){
        return x;
    }

    double getEixoY(){
        return y;
    }

    void imprimirPonto(){
        System.out.println("O ponto esta nas coordenadas (" + x + ", " + y + ")");
    }

    boolean isEixoX(){
        if(x==0)
            return true;
        else
            return false;
    }
    boolean isEixoY(){
        if(y==0)
            return true;
        else
            return false;
    }
    boolean isEixos(){
        if(x == 0 && y ==0)
            return true;
        else
            return false;
    }

    int quadrante(){
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

    double distancia(Ponto2D rand){
        return Math.sqrt(Math.pow(rand.x - this.x, 2) + Math.pow(rand.y - this.y, 2));
    }
    
 }