public class Data{
    private int dia, mes, ano;


    public void inicilizarData(){
        this.dia = 1; this.mes = 1;
        this.ano = 2000;
    }    

    public void setData(int dia, int mes, int ano){
        if(validDate(dia, mes, ano)){
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }else{
            this.dia = 0; this.mes = 0; this.ano = 0;
            System.out.println("Invalid date!!");
        }
    }

    public void imprimeData(){
        System.out.println("%02d/%02d/%02d", dia, mes, ano);
    }

    public void imprimeDataExtenso(){
        System.out.println(dia + " de " + checkMes(mes) + " de " +ano);
    }

    private String checkMes(int mes){
        if(mes != 0){
            String[] months = { "janeiro", "fevereiro", "março", "abril", "maio", "junho",
            "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};
            return months[mes - 1];
        }else{
            return ("0");
        }
    }

    public int getDia(){
        return this.dia;
    }
    public int getMes(){
        return this.mes;
    }
    public int getAno(){
        return this.ano;
    }


    private boolean leapYear(int a){
        return(a%400==0 || (a%4==0 && !(a%100==0)));
    }


    private boolean validDate(int d, int m, int a){
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