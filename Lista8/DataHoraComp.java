package Lista8;
import Lista7.Data;
import Lista7.Time;

public class DataHoraComp {
    Data data;
    Time hora;

    public DataHoraComp(int dia, int mes, int ano, int hora, int min, int seg){
        this.data = new Data(dia, mes, ano);
        this.hora = new Time(hora, min, seg);
    }

    public String toString(){
        return (this.data.toString() + " " + this.hora.toString());
    }

    public boolean isEquals(DataHoraComp obj){
        return (this.data.isEquals(obj.data) && this.hora.isEquals(obj.hora));
    }

    public boolean isGreather(DataHoraComp obj){
        if(obj.data.isPrevious(data))
            return true;
        else if(obj.hora.getHora() > data.getHora())
            return true;
            else if(obj.hora.getHora() == data.getHora() && obj.hora.getMin() > data.getMin())
                return true;
                else if(obj.hora.getHora() == data.getHora() && obj.hora.getMin() == data.getMin() && obj.hora.getSeg() > data.getSeg())
                    return true;
        return false;
    }

    public boolean isLower(DataHoraComp obj){
        return !this.isGreather(obj);
    }
}