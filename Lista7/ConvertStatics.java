public class ConvertStatics {
    public static float gramsToKilograms(float grams) {
        return grams / 1000;
    }

    public static float gramsToPounds(float grams) {
        return grams / 453.59f;
    }

    public static float gramsToOunces(float grams) {
        return grams / 28.35f;
    }

    public static float kiloToGrams(float kilo) {
        return kilo * 1000;
    }

    public static float kiloToPounds(float kilo) {
        return kilo * 2.2046f;
    }

    public static float kiloToOunces(float kilo) {
        return kilo * 35.274f;
    }

    public static float poundsToGrams(float pounds) {
        return pounds * 453.59f;
    }

    public static float poundsToKilo(float pounds) {
        return pounds / 2.2046f;
    }

    public static float poundsToOunces(float pounds) {
        return pounds * 16;
    }

    public static float ouncesToGrams(float ounces) {
        return ounces * 28.35f;
    }

    public static float ouncesToKilo(float ounces) {
        return ounces / 35.274f;
    }

    public static float ouncesToPounds(float ounces) {
        return ounces / 16;
    }

}