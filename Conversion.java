public class Conversion {
    /** Convert from feet to meters */
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    /** Convert from meters to feet */
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void main(String[] args) {
        System.out.println("Feet:\t\t\t\tMeters:");
        for (double feet = 1.0; feet <= 10.0; feet++) {
            double meters = footToMeter(feet);
            System.out.printf("%.1f\t\t\t\t%.3f\n", feet, meters);
        }

        System.out.println("\nFeet:\t\t\t\tMeters:");
        for (double feet = 20.0; feet <= 65.0; feet += 5.0) {
            double meters = footToMeter(feet);
            System.out.printf("%.1f\t\t\t\t%.3f\n", feet, meters);
        }
    }
}