import java.util.*;

public class Contato{
    private String nome, email, telefone, dataNasc;
    static public int inst = 0;

    Contato(String nome, String email, String telefone, String dataNasc){
        if(validaNome(nome))
            this.nome = nome;
        else
            this.nome = "";
        if(validaEmail(email))
            this.email = email;
        else
            this.email = "";  //depois de alguns testes, a atribuição a partir da vallidação, funcionou melhor individualmente
        if(validDate(dataNasc))
            this.dataNasc = dataNasc;
        else
            this.dataNasc = "";
        if(validaNumero(telefone))
            this.telefone = telefone;
        else
            this.telefone = "";
        inst++;
    }

    public Contato(){
        this("NONE","NONE", "NONE", "00/00/0000"); //é a unica sobrecarga possivel, deivdo ao tipo dos atributos serem iguais.
    }
    
    static public int getInst(){
        return inst;
    } 

    public static void main(String[] args){
        Contato cliente = new Contato("Fabricio", "fabdnt@gmail.com", "73988024718", "27/02/2001");

        //cliente.setNome("Fabricio");
        //cliente.setDataNasc("01/05/1989");
        //cliente.setEmail("fab_dant@gmail.com");
        //cliente.setTel("73988024718");

        System.out.println("Nome do cliente: " + cliente.getNome());
        System.out.println("Data de nascimento do cliente: " + cliente.getDataNasc());
        cliente.imprimeContato();
        System.out.println(cliente.nome + " tem " + cliente.calcularIdade() + " anos de idade");
        System.out.println("Instâncias da classe: " + Contato.getInst());

    }

    public void inicializaContato(){
        email = "NONE";
        telefone = "NONE";
        nome = "NONE";
        dataNasc = "00/00/0000";
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

    public String getNome(){return nome;}
    public String getEmail(){return email;}
    public String getTel(){return telefone;}
    public String getDataNasc(){return dataNasc;}
    private boolean validaEmail(String email){
        return email.contains("@") && (email.contains(".com") || email.contains(".br"));
    }
    private boolean validaNome(String nome){
        return nome.matches("[A-Z][a-z]{1,}");
    }

    public static boolean validaNumero(String tel)
    {
        if(tel.length() == 11) {
            //if (tel == null || tel.isEmpty()) {
            //  return false;
            // }

            for (int i = 0; i < tel.length(); i++) {
                char c = tel.charAt(i);
                if (c < '0' || c > '9') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    private boolean validDate(String dataN){
        String[] dt = dataN.split("/");
        if(dt.length != 3)
            return false;

        int day = Integer.parseInt(dt[0]);
        int month = Integer.parseInt(dt[1]);
        int year = Integer.parseInt(dt[2]);

        if(validDateValue(day, month, year))
            return true;
        return false;

    }
    public void imprimeContato(){
        System.out.println("Contatos:\n\tEmail: " + email + "\n\tTelefone: " + telefone);
    }

    public int calcularIdade(){
        String[] birth = dataNasc.split("/");
        if(birth.length != 3)
            return -1; //verifica se a data é valida(a questao em si não pede um metodo de verificação de data)

        int diaNasc = Integer.parseInt(birth[0]);
        int mesNasc = Integer.parseInt(birth[1]);
        int anoNasc = Integer.parseInt(birth[2]);

        Calendar today = Calendar.getInstance();

        int currentYear = today.get(Calendar.YEAR);
        int currentMonth = today.get(Calendar.MONTH) + 1; //mes comeca em 0
        int currentDay = today.get(Calendar.DAY_OF_MONTH);

        int idade = currentYear - anoNasc;

        if(currentMonth < mesNasc || (currentMonth == mesNasc && currentDay < diaNasc)){
            idade--;
        }

        return idade;
    }

    private boolean leapYear(int a){
        return(a%400==0 || (a%4==0 && !(a%100==0)));
    }


    private boolean validDateValue(int d, int m, int a){
        if((d >= 1 && d <= 31) && (m >= 1 && m <= 12)){
            if(m==2){
                if(leapYear(a) && d<=29)
                    return true;
                else return !(!leapYear(a) && d > 28);
            }
            return true;
        }
        return false;
    }
}
