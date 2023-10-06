import java.util.Calendar;

class Contato{
    private String nome, email, telefone, dataNasc;

    public void inicializaContato(){
        this.email = "NONE";
        this.telefone = "NONE";
        this.nome = "NONE";
        this.dataNasc = "00/00/0000";
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTel(String telefone){
        this.telefone = telefone;
    }
    public void setDataNasc(String dataNasc){
        this.dataNasc = dataNasc;
    }

    public String getNome(){return this.nome;}
    public String getEmail(){return this.email;}
    public String getTel(){return this.telefone;}
    public String getDataNasc(){return this.dataNasc;}

    public String imprimeContato(){
        return ("Contatos:\n\tEmail: " + this.email + "\n\tTelefone: " + this.telefone);
    }

    public int calcularIdade(){
        String[] birth = this.dataNasc.split("/");
        if(birth.length != 3)
            return -1; //verifica se a data é valida(a questao em si não pede um metodo de verificação de data)

        int diaNasc = Integer.parseInt(birth[0]);
        int mesNasc = Integer.parseInt(birth[1]);
        int anoNasc = Integer.parseInt(birth[2]);

        Calendar today = getInstance();

        int curretYear = dataAtual.get(YEAR);
        int currentMonth = dataAtual.get(MONTH) + 1; //mes comeca em 0
        int currentDay = dataAtual.get(DAY_OF_MONTH);

        int idade = curretYear - anoNasc;

        if(currentMonth < mesNasc || (currentMonth == mesNasc && currentDay < diaNasc)){
            idade--;
        }
        
        return idade;     
    }
}