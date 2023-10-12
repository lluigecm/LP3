public class Circulo {
    private float x, y, raio;
    
    Circulo(float x, float y, float raio){
        this.x = x;
        this.y = y;
        if(validaCirculo(raio))
            this.raio = raio;
        else{ 
            this.raio = 1F;
            System.out.println("Raio invalido, inicializado como 1");
        }
    }

    public static void main(String[] args) {
        Ponto2D point = new Ponto2D(5F, 10F);
        Circulo circle = new Circulo(3F, 6F, 7.5F);
        Circulo circle2 = new Circulo(1F, 3F, 4.5F);

        System.out.println("Area do circulo: "+ circle.area());
        System.out.println("Perimetro do circulo: "+ circle.perimeter());

        System.out.println("point esta dentro de circle? " + circle.isInnerPoint(point));
        System.out.println("Circle1 é maior q circle2? "+ circle.isBiggerThan(circle2));
    }

    public void setX(float x) {
         this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setRaio(float raio) {
        if(validaCirculo(raio))
            this.raio = raio;
        else{
            System.out.println("Valçr invalido");
        }
    }

    public float getRaio() {
        return raio;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    public float area(){
        return raio*raio*3.14F;
    }
    public float perimeter(){
        return 2*raio*3.14F;
    }

    public boolean isBiggerThan(Circulo rnd){
        return this.area() > rnd.area();
    }
    public boolean isInnerPoint(Ponto2D rnd){
        Ponto2D aux = new Ponto2D(x, y);
        return rnd.distancia(rnd) < raio;
    }
    private boolean validaCirculo(float raio){
        return (raio > 0);
    }
}
