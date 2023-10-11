public class Data{
    private int dia, mes, ano;

    Data(int dia, int mes, int ano){
        if(validDate(dia, mes, ano)){
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }else{
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }
    public static void main(String[] args) {
        Data date2 = new Data(23, 2, 2001);
        Data date1 = new Data(24, 1, 2002);

        System.out.println("A diferença entre as datas é de " + date1.howManyDays(date2) + " dias");
        System.out.println("O dia da semana da primeira data é " + date1.dayOfWeek());
        System.out.println("O dia da semana da segunda data é " + date2.dayOfWeek());


        //date.inicilizarData();
        //date.imprimeData();
        //date.imprimeDataExtenso();

        //System.out.println("");
        //date.setData(24, 2, 2018);
        //date.imprimeData();
        //date.imprimeDataExtenso();

        //System.out.println("\nData: " + date.getDia() + "/" + date.getMes() + "/" + date.getAno());


    }

    public void inicilizarData(){
        dia = 1;
        mes = 1;
        ano = 2000;
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
        System.out.printf("%02d/%02d/%02d\n", dia, mes, ano);
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
        return dia;
    }
    public int getMes(){
        return mes;
    }
    public int getAno(){
        return ano;
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

    public boolean isPrevious(Data outraData){
        if(outraData.ano < ano){
            return true;
        }else if(outraData.ano == ano){
            if(outraData.mes < mes){
                return true;
            }else if(outraData.mes == mes){
                if(outraData.dia < dia){
                    return true;
                }
            }
        }
        return false;
    }

    public int howManyDays(Data outraData){
        int dif;
        if(isPrevious(outraData)){
            dif = -(ano - outraData.ano) * 365;
            dif -= (mes - outraData.mes) * 30;
            dif -= dia - outraData.dia;
            dif++;
        }else{
            dif = (outraData.ano - ano) * 365;
            dif += (outraData.mes - mes) * 30;
            dif += outraData.dia - dia;
            dif--;
        }

        return dif;
    }

    public String dayOfWeek(){
        String[] days = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};
        int d = dia, m = mes, a = ano;
        if(m == 1 || m == 2){
            m += 12;
            a--;
        }
        int s = (d + 2*m + (3*(m+1))/5 + a + a/4 - a/100 + a/400) % 7;
        return days[s+1];
    }

}