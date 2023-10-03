import java.util.Scanner;

class Data15{
    static int dia, mes, ano;

    public static void main(String[] args) {

        Scanner info = new Scanner(System.in);
        int d, m, a;
        d = info.nextInt();
        m = info.nextInt();
        a = info.nextInt();

        Data15 date = new Data15();
        startDate(d,m,a);
        showDate();

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
}

