package Lista8;
import Lista7.Data;
import Lista7.Time;

public class DataHoraAssos{
    Data data;
    Time hora;

    public DataHoraAssos(Data data, Time hora){
        this.data = new Data(data);
        this.hora = new Time(hora);
    }

    // Como é um relacionamento de assossiação, os metodos da outras questões não creio fazerem sentido aqui. Já que
    // o relacionento de Assossiação s métodos devem ser combinados, invocando diretamente os métodos da classe base.
}