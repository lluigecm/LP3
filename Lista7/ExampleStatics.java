public class ExampleStatics {
    public static void main(String[] args) {

        System.out.println("Exemplo de uso de métodos estáticos: ");

        System.out.println("Conversão de gramas para quilogramas: " + ConvertStatics.gramsToKilograms(6075));
        System.out.println("Conversão de gramas para libras: " + ConvertStatics.gramsToPounds(346));
        System.out.println("Conversão de gramas para onças: " + ConvertStatics.gramsToOunces(7898));

        System.out.println("Conversão de quilogramas para gramas: " + ConvertStatics.kiloToGrams(1590));
        System.out.println("Conversão de quilogramas para libras: " + ConvertStatics.kiloToPounds(100));
        System.out.println("Conversão de quilogramas para onças: " + ConvertStatics.kiloToOunces(4456));

        System.out.println("Conversão de libras para gramas: " + ConvertStatics.poundsToGrams(234));
        System.out.println("Conversão de libras para quilogramas: " + ConvertStatics.poundsToKilo(675));
        System.out.println("Conversão de libras para onças: " + ConvertStatics.poundsToOunces(123));

        System.out.println("Conversão de onças para gramas: " + ConvertStatics.ouncesToGrams(736));
        System.out.println("Conversão de onças para quilogramas: " + ConvertStatics.ouncesToKilo(2356));
        System.out.println("Conversão de onças para libras: " + ConvertStatics.ouncesToPounds(375));

    }
}
