package Lista8;
import Lista7.Contato;
import Lista7.Data;
import Lista7.Time;


public class Agendamento{
    private Contato contato;
    private Data data;
    private Time hora;

    public Agendamento(String nome, String email, String telefone, String dataNasc, int dia, int mes, int ano, int hora, int minuto, int seg){
        this.contato = new Contato(nome, email, telefone, dataNasc);
        this.data = new Data(dia, mes, ano);
        this.hora = new Time(hora, minuto, seg);
    }

    public String imprimeAgendamento(){
        return ("Informações: \n" + contato.imprimeContato() + "\nData de Agendamento: " + data.imprimeData() + "\nHora de Agendamento: " + hora.imprimeTime());
    }

    public Contato getContato(){
        return contato;
    }

    public Data getData(){
        return data;
    }

    public Time getTime(){
        return hora;
    }
}