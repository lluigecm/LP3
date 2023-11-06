import java.util.Calendar;

public class Time{
    private int hora, min, seg;

    public static void main(String[] args) {
       Time t1 = new Time(19, 40, 50);
       Time t2 = new Time(23, 50, 45);

        System.out.println(Time.diffTime(t1, t2));
        System.out.println(Time.diffTime(t1));

        System.out.println(Time.isAm(t1));
        System.out.println(Time.isPm(t2));
    }

    Time(int hora, int min, int seg){
        if(validateTima(hora, min, seg)){
            this.hora = hora;
            this.min = min;
            this.seg = seg;
        }else{
            this.hora = 0;
            this.min = 0;
            this.seg = 0;
        }
    }

    Time(Time obj){
        this(obj.hora, obj.min, obj.seg);
    }

    Time(int hora){
        this(hora,0,0);
    }

    Time(int hora, int min){
        this(hora, min, 0);
    }

    Time(){
        this(0,0,0);
    }

    public int getHora() {
        return this.hora;
    }

    public int getMin() {
        return this.min;
    }

    public int getSeg() {
        return seg;
    }

    public void setHora(int hora) {
        if(validateTima(hora, 0, 0))
            this.hora = hora;
    }

    public void setMin(int min) {
        if (validateTima(0,min ,0))
            this.min = min;
    }

    public void setSeg(int seg) {
        if (validateTima(0,0, seg))
            this.seg = seg;
    }

    public String mostraHora(){
        return (this.hora + ":" + this.min + ":" + this.seg);
    }

    public boolean isAm(){
        return this.hora < 12;
    }

    public int cron(Time outraHora){
        int segCron = outraHora.hora * 3600 - this.hora*3600;
        segCron += outraHora.min * 60 - this.hora * 60;
        segCron += outraHora.seg - this.seg;

        if(outraHora.hora > this.hora)
            return segCron;
        else
            return segCron + 86400;
    }

    public void addTime(int hora, int min, int seg){
        if(validateTima(hora, min, seg)){
            this.hora += hora;
            this.min += min;
            this.seg += seg;
        }
        if(this.seg > 59){
            this.seg -= 60;
            this.min++;
        }
        if(this.min > 59){
            this.min -= 60;
            this.hora++;
        }
        if(this.hora > 23){
            this.hora -= 24;
        }
    }

    public void addTime(int min, int seg){
        addTime(0, min, seg);
    }

    public void addTime(int seg){
        addTime(0,0, seg);
    }

    public void addTime(Time obj){
        addTime(obj.hora, obj.min, obj.seg);
    }

    private boolean validateTima(int hora, int min, int seg){
        return ((hora >= 0 && hora <= 23) && (min >= 0 && min <= 59) && (seg >= 0 && seg <= 59));
    }

    public static Time now(){
        Calendar today = Calendar.getInstance();
        int currentHour = today.get(Calendar.HOUR_OF_DAY);
        int currentMinute = today.get(Calendar.MINUTE);
        int currentSecond = today.get(Calendar.SECOND);

        return new Time(currentHour, currentMinute, currentSecond);
    }

    public static int diffTime(Time t1, Time t2){
        return t1.cron(t2);
    }

    public static int diffTime(Time t1){
        Time currentTime = Time.now();
        return t1.cron(currentTime);
    }

    public static boolean isAm(Time t1){
        return t1.hora < 12;
    }

    public static boolean isPm(Time t1){
        return t1.hora > 12;
    }

}