import java.util.Scanner;

class Data16{
    static int dia, mes, ano;

    public static void main(String[] args) {

        Scanner info = new Scanner(System.in);
        int d, m, a;
        d = info.nextInt();
        m = info.nextInt();
        a = info.nextInt();

        Data16 date = new Data16();
        startDate(d,m,a);
        showDate();
        System.out.println(dayOfWeek(d,m,a));

    }

    static void startDate(int d, int m, int a){
        if(validDate(d,m,a)){
            dia = d;
            mes = m;
            ano = a;
        }else{
            dia = 0;
            mes = 0;
            ano = 0;
        }
    }

    static void showDate(){
        System.out.println(dia + "/" + mes + "/" + ano);
    }

    static boolean leapYear(int a){
        return(a%400==0 || (a%4==0 && !(a%100==0)));
    }


    static boolean validDate(int d, int m, int a){
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

    static String dayOfWeek(int day, int mont, int year){
        int a = ((12 - mes) / 10);
        int b = ano - a;
        int c = mes + (12 * a);
        int d = b / 100;
        int e = d / 4;
        int f = 2 - d + e;
        int g = (int) (365.25 * b);
        int h = (int) (30.6001 * (c + 1));
        int i = (int) ((f + g) + (h + dia) + 5);
        int j = (int) (i % 7);

        String[] diasDaSemana = {"Sábado", "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira"};
        return diasDaSemana[j];
    }
}

