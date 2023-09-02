import java.util.Scanner;

class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}

public class BinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary string: ");
        String binaryString = scanner.nextLine();

        try {
            int decimalValue = bin2Dec(binaryString);
            System.out.println("Decimal Value: " + decimalValue);
        } catch (BinaryFormatException e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        // Check if the input string contains only 0s and 1s
        for (char c : binaryString.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new BinaryFormatException("Invalid binary string: " + binaryString);
            }
        }

        // Convert binary string to decimal
        int decimalValue = 0;
        int binaryLength = binaryString.length();
        for (int i = 0; i < binaryLength; i++) {
            char binaryChar = binaryString.charAt(i);
            int power = binaryLength - i - 1;
            if (binaryChar == '1') {
                decimalValue += Math.pow(2, power);
            }
        }

        return decimalValue;
    }
}