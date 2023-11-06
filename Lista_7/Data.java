public class Data{
    private int dia, mes, ano;

     public static void main(String[] args) {
        Data date2 = new Data(23, 2, 2001);
        Data date1 = new Data(24, 1, 2002);

        System.out.println(Data.howManyDaysUntilNextMonth(date2));
        System.out.println(Data.howManyDaysUntilEndYear(date1));

        System.out.println(Data.isBissexto(date1));

        System.out.println(Data.dayToPrintLong(date2));
        System.out.println(Data.dayToPrintShort(date1));
    }

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
    Data(Data obj){
        this(obj.dia, obj.mes, obj.ano);
    }
    Data(){
        this(1, 1, 1970);
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
    public void setData(Data obj){
        setData(obj.dia, obj.mes, obj.ano);
    }
    public void setData(int daquiAxDias){
        addDays(daquiAxDias);
    }
    public void setData(int primeiroDiaDoMesX, int ano){
        if(validDate(0,primeiroDiaDoMesX,ano))
            setData(1, primeiroDiaDoMesX,ano);
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

    public String getData(){
        return (this.dia + "/" + this.mes + "/" + this.ano);
    }

    private static boolean leapYear(int a){
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
    public int howManyDays(int dia, int mes, int ano){
        Data aux = new Data(dia, mes, ano);
        return howManyDays(aux);
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

    public void addDays(int days){
        int d = this.dia, m = this.mes, a = this.ano;
        d += days;
        while(d > 30){
            d -= 30;
            m++;
        }
        while(m > 12){
            m -= 12;
            a++;
        }
        this.dia = d;
        this.mes = m;
        this.ano = a;
    }

    public static int howManyDaysUntilEndYear(Data aux){
        int days = 0;
        int d = aux.dia, m = aux.mes, a = aux.ano;
        while(m < 12){
            if(m ==2){
                if(leapYear(a))
                    days += 29;
                else
                    days += 28;
            }else if(m%2 == 0)
                days += 31;
            else
                days += 30;
            m++;
        }
        days += 30 - d;
        return days;
    }

    public static int howManyDaysUntilNextMonth(Data aux){
        int d = aux.dia, m = aux.mes;
        if(m == 2){
            if(leapYear(aux.ano))
                return 29 - d;
            else
                return 28 - d;
        } else if(m%2 == 0)
            return 31 - d;
        else
            return 30 - d;
    }

    public static boolean isBissexto(Data aux){
        return leapYear(aux.ano);
    }

    public static String dayOfWeek(Data aux){
        return aux.dayOfWeek();
    }

    public static String dayToPrintShort(Data aux){
        return (aux.dia + "/" + aux.mes + "/" + aux.ano);
    }

    public static String dayToPrintLong(Data aux){
        return (aux.dia + " de " + aux.checkMes(aux.mes) + " de " + aux.ano);
    }
}