import java.util.Objects;

public class RoboSimples {
    private  String nomeDoRobo;
    private int posicaoXAtual,posicaoYAtual;
    private String direcaoAtual;

    RoboSimples(String nome, int px, int py, String d) {
        if (validaRobo(nome, d)) {
            nomeDoRobo = nome;
            posicaoXAtual = px;
            posicaoYAtual = py;
            direcaoAtual = d;
        }
    }

    RoboSimples(String nome){
        this(nome, 0, 0, "N");
    }

    RoboSimples(){
        this("Wally");
    }

    public void move(){
        this.move(1);
    }

    public void move(int passos){
        if (Objects.equals(direcaoAtual, "N")) posicaoYAtual += passos;
        if (Objects.equals(direcaoAtual, "S")) posicaoYAtual -= passos;
        if (Objects.equals(direcaoAtual, "L")) posicaoXAtual += passos;
        if (Objects.equals(direcaoAtual, "O")) posicaoXAtual -= passos;
        if (Objects.equals(direcaoAtual, "NE")) {
            posicaoYAtual += passos;
            posicaoXAtual += passos;
        }
        if (Objects.equals(direcaoAtual, "NO")){
            posicaoYAtual += passos;
            posicaoXAtual -= passos;
        }
        if (Objects.equals(direcaoAtual, "SE")){
            posicaoXAtual += passos;
            posicaoYAtual -= passos;
        }
        if (Objects.equals(direcaoAtual, "SO")){
            posicaoXAtual -= passos;
            posicaoYAtual -= passos;
        }
    }

    public void mudaDireção(String novaDirecao){
        if(validaDirecao(novaDirecao))
            direcaoAtual = novaDirecao;
    }

    public String toString(){
        String str = "\nNome do robo: "+nomeDoRobo+"\n";
        str = str + "Posicao do robo: ("+posicaoXAtual+", "+posicaoYAtual+")\n";
        str = str + "Direcao do robo: "+direcaoAtual;

        return str;
    }

    private boolean validaRobo(String nome, String direcao) {
        if (nome != null && validaDirecao(direcao))
            return true;

        return false;
    }

    private boolean validaDirecao(String dir){
        if(Objects.equals(dir, "N") || Objects.equals(dir, "S") ||
                Objects.equals(dir, "L") || Objects.equals(dir, "O") ||
                Objects.equals(dir, "NE") || Objects.equals(dir, "NO") ||
                Objects.equals(dir, "SE") || Objects.equals(dir, "SO"))
            return true;
        return false;
    }

}