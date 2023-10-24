class Time{
    private int hora, min, seg;
    
    public static void main(String[] args) {
        Time time = new Time(23, 59, 59);
        Time time2 = new Time(time);
        Time time3 = new Time(19);
        Time time4 = new Time(19, 20);

        System.out.println("Time: " + time.mostraHora());
        System.out.println("Time2: " + time2.mostraHora());

        System.out.println("Time é AM? " + time.isAm());
        System.out.println("Time2 é AM? " + time2.isAm());

        System.out.println("Time2 é maior que time? " + time2.cron(time));
        System.out.println("Time é maior que time2? " + time.cron(time2));
        System.out.println("Time4 é maior que time3? " + time4.cron(time3));
        

        time.addTime(time3);
        System.out.println("Time: " + time.mostraHora());
        time2.addTime(20,40);
        System.out.println("Time: " + time2.mostraHora());
        time3.addTime(12, 10, 30);
        System.out.println("Time: " + time3.mostraHora());
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
        int horaCron = outraHora.hora * 3600 - this.hora*3600;
        int minCron = outraHora.min * 60 - this.hora * 60;
        int segCron = outraHora.seg - this.seg;

        if(this.hora < outraHora.hora)
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
}