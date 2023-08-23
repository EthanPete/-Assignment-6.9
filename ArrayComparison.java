import java.util.Scanner;
import java.util.Arrays;

public class ArrayComparison {

    public static boolean equals(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false;
        }

        // Flatten the arrays and sort them
        int[] flatM1 = Arrays.stream(m1)
                .flatMapToInt(Arrays::stream)
                .sorted()
                .toArray();

        int[] flatM2 = Arrays.stream(m2)
                .flatMapToInt(Arrays::stream)
                .sorted()
                .toArray();

        return Arrays.equals(flatM1, flatM2);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter list1: ");
            int[][] list1 = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    list1[i][j] = scanner.nextInt();
                }
            }

            System.out.print("Enter list2: ");
            int[][] list2 = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    list2[i][j] = scanner.nextInt();
                }
            }

            boolean areIdentical = equals(list1, list2);
            if (areIdentical) {
                System.out.println("The two arrays are identical");
            } else {
                System.out.println("The two arrays are not identical");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}