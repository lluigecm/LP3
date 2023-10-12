class Time:
    def __init__(self, hora, min, seg):
        if self.__validTime(hora, min, seg):
            self.__hora = hora
            self.__min = min
            self.__seg = seg
        else:
            print("Hora inválida, inicializando com 0")
            self.__hora = 0
            self.__min = 0
            self.__seg = 0

    @property
    def hora(self):
        return self.__hora
    
    @property
    def min(self):
        return self.__min   
    
    @property
    def seg(self):
        return self.__seg
    

    @hora.setter
    def hora(self, hora):
        print("Inside a setter")
        if hora < 0 or hora > 23:
            print("Hora inválida, inicializando com 0")
            self.__hora = 0
        self.__hora = hora

    @min.setter
    def min(self, min):
        print("Inside a setter")
        if min < 0 or min > 59:
            print("Minuto inválido, inicializando com 0")
            self.__min = 0
        self.__min = min
    
    @seg.setter
    def seg(self, seg):
        print("Inside a setter")
        if seg < 0 or seg > 59:
            print("Segundo inválido, inicializando com 0")
            self.__seg = 0
        self.__seg = seg

    def mostra_hora(self):
        return f'{self.__hora}:{self.__min}:{self.__seg}'
    
    def isAm(self):
        return self.__hora < 12
    
    def cron(self, outra_hora):
        hora_cron = outra_hora.hora*3600 - self.__hora*3600
        min_cron = outra_hora.min*60 - self.__min*60
        seg_cron = (outra_hora.seg - self.__seg) + min_cron + hora_cron

        if self.__hora < outra_hora.hora:
            return seg_cron
        else: 
            return seg_cron + 86400
    
    def add_seconds(self, seg):
        self.__seg += seg
        if self.__seg > 59:
            self.__min += self.__seg // 60
            self.__seg = self.__seg % 60
        if self.__min > 59:
            self.__hora += self.__min // 60
            self.__min = self.__min % 60
        if self.__hora > 23:
            self.__hora = self.__hora % 24
    
    def __validTime(self, hora, min, seg):
        return hora >= 0 and hora <= 23 and min >= 0 and min <= 59 and seg >= 0 and seg <= 59
  
def main():
    hour = Time(21, 28, 25);
    #hour.hora = 21
    #hour.min = 28
    #hour.seg = 25
    print(hour.mostra_hora())
    print(hour.isAm())

    hour.add_seconds(43200)
    print(hour.mostra_hora())

    hour2 = Time(7, 28, 25)
    #hour2.hora = 7
    #hour2.min = 28
    #hour2.seg = 25

    print(f"Diferença de {hour.cron(hour2)} segundos entre hour e hour2")

    print(f"{hour2.hora}:{hour2.min}:{hour2.seg}")


main()