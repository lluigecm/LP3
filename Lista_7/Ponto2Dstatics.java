public class Ponto2Dstatics {
    public static float distancia(Ponto2D p1, Ponto2D p2){
        float p1X = p1.getEixoX();
        float p1Y = p1.getEixoY();

        float p2X = p2.getEixoX();
        float p2Y = p2.getEixoY();

        return (float) Math.sqrt(Math.pow(p2X - p1X, 2) + Math.pow(p2Y - p1Y, 2));
    }

    public static float distancia(Ponto2D p1){
        return (float) Math.sqrt(Math.pow(0 - p1.getEixoX(), 2) + Math.pow(0 - p1.getEixoY(), 2));
    }

    public static int quadrante(Ponto2D p1){
        if(p1.isEixos())
            return 0;
        else{
            if(p1.getEixoX() > 0 && p1.getEixoY() > 0)
                return 1;
            else if(p1.getEixoX() < 0 && p1.getEixoY() > 0)
                return 2;
            else if(p1.getEixoX() < 0 && p1.getEixoY() < 0)
                return 3;
            else
                return 4;
        }
    }
}
