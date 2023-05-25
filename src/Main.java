import java.util.Scanner;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // double principal = 1000.00 // initial amount before interest
        // double rate = 0.05 // interest rate
        // double userPrincipal
        // double userRate

        BigDecimal principal = BigDecimal.valueOf(1000.0);
        BigDecimal interestRate = BigDecimal.valueOf(0.05);
        BigDecimal userPrincipal;
        BigDecimal userRate;
        int years;

        // user-definable rate, years, & amount
        System.out.printf("Enter the principal [1000.00]: $");
        userPrincipal = scan.nextBigDecimal();

        // test the value
        // if(userPrincipal > 0)
        if(userPrincipal.compareTo(BigDecimal.ZERO) > 0) {
            principal = userPrincipal;
        }

        System.out.printf("Enter the interest rate (as a decimal) [0.05]: ");
        // userRate = scan.nextDouble();
        userRate = scan.nextBigDecimal();

        // test the value
        // if(userRate > 0)
        if(userRate.compareTo(BigDecimal.ZERO) > 0) {
            interestRate = userRate;
        }

        System.out.printf("Enter the number of years [10]: ");
        years = scan.nextInt();

        // test the value
        // if(years <= 0)
        if(years <= 0) {
            years = 10;
        }

        // display headers
        System.out.printf("%s\t%20s\n", "Year:", "Amount of deposit:");

        // doing leading dollar signs can be hard
        NumberFormat USformat = NumberFormat.getCurrencyInstance(Locale.US);

        // calculate amount of deposit for each of 10 years
        for(int year = 1; year <= years; year++) {
            // calculate new amount on deposit for specified year
            // a = p(1 + r)^n
            // BigDecimal for currency vales
            // BigDecimal amount = new BigDecimal(principal * Math.pow(1.0 + rate, year))
            BigDecimal amount = principal.multiply(interestRate.add(BigDecimal.ONE).pow(year));

            // display the year and amount
            System.out.printf("%-4d\t", year);
            System.out.printf("%20s\n", USformat.format(amount));
        }
    }
}
