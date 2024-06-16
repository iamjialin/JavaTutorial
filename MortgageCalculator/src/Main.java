import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        System.out.println();

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate  = scanner.nextFloat();
        double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        System.out.println();

        System.out.print("Period (Years): ");
        byte years  = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;
        System.out.println();

        double mortgage  = principal
                * (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments))
                / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.printf("Mortgage: %s%n", mortgageFormatted);
        scanner.close();
    }
}
