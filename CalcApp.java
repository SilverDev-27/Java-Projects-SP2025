package calculatorApp;
import java.util.*;

//Main Application Class
public class CalcApp {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Calculator calcEngine = new Calculator();
     char choice;
     
     do {
         System.out.println("\nWelcome to the Calculator Program!");
         System.out.println("1. Create Multiplication Table (up to 10x10)");
         System.out.println("2. Create Exponentiation Table (up to 5x5)");
         System.out.println("3. Show the first 10 prime numbers");
         System.out.println("4. Show a list of prime numbers (up to 50)");
         System.out.println("5. Find the area and circumference of a circle (provide radius)");
         System.out.println("6. Generate statistics for a list of inputted values (up to 10)");
         System.out.println("7. Generate statistics for a list of random values (up to 10)");
         System.out.println("8. Generate a table showing ASCII values for a range (32-126)");
         System.out.println("9. Exit Program");
         System.out.println("q. Quit");
         System.out.print("Please enter your selection: ");
         choice = scanner.next().charAt(0);

         switch (choice) {
             case '1':
                 calcEngine.table(10, 10);
                 break;
             case '2':
                 calcEngine.table(3.0, 2);
                 break;
             case '3':
                 calcEngine.primes();
                 break;
             case '4':
                 System.out.print("Enter the number of primes to generate (up to 50): ");
                 int num = scanner.nextInt();
                 calcEngine.primes(num);
                 break;
             case '5':
                 calcEngine.circle();
                 break;
             case '6':
                 System.out.print("Enter how many values to input (1-10): ");
                 int n = scanner.nextInt();
                 System.out.println("Mean: " + calcEngine.stats(n));
                 break;
             case '7':
                 calcEngine.stats();
                 break;
             case '8':
                 calcEngine.ascii();
                 break;
             case '9':
                 System.out.println("Exiting program...");
                 System.exit(0);
                 break;
             case 'q':
                 System.out.println("Exiting program...");
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     } while (choice != 'q');
     scanner.close();
 }
}

//Calculator Class
class Calculator {
 private Scanner scanner = new Scanner(System.in);

 public void table(int rows, int cols) {
     System.out.printf("%4s", "");
     for (int i = 1; i <= cols; i++)
         System.out.printf("%4d", i);
     System.out.println();
     
     for (int i = 1; i <= rows; i++) {
         System.out.printf("%4d", i);
         for (int j = 1; j <= cols; j++)
             System.out.printf("%4d", i * j);
         System.out.println();
     }
 }

 public void table(double base, int exp) {
     System.out.printf("%4s", "");
     for (int i = 1; i <= exp; i++)
         System.out.printf("%8d", i);
     System.out.println();

     for (int i = 1; i <= base; i++) {
         System.out.printf("%4d", i);
         for (int j = 1; j <= exp; j++)
             System.out.printf("%8.0f", Math.pow(i, j));
         System.out.println();
     }
 }

 public void primes() {
     primes(10);
 }

 public void primes(int count) {
     int num = 2, found = 0;
     while (found < count) {
         if (isPrime(num)) {
             System.out.printf("%4d", num);
             found++;
             if (found % 10 == 0) System.out.println();
         }
         num++;
     }
 }

 private boolean isPrime(int num) {
     if (num < 2) return false;
     for (int i = 2; i <= Math.sqrt(num); i++) {
         if (num % i == 0) return false;
     }
     return true;
 }

 public void circle() {
     System.out.print("Enter the radius: ");
     double r = scanner.nextDouble();
     System.out.printf("Area: %.2f, Circumference: %.2f\n", Math.PI * r * r, 2 * Math.PI * r);
 }

 public double stats(int n) {
     double sum = 0;
     for (int i = 0; i < n; i++) {
         System.out.print("Enter a number: ");
         sum += scanner.nextDouble();
     }
     return sum / n;
 }

 public void stats() {
     Random rand = new Random();
     double sum = 0;
     System.out.print("Generated numbers: ");
     for (int i = 0; i < 10; i++) {
         int num = rand.nextInt(100);
         sum += num;
         System.out.print(num + " ");
     }
     System.out.printf("\nMean: %.2f, Sum: %.2f\n", sum / 10, sum);
 }

 public void ascii() {
     for (int i = 32; i <= 126; i++) {
         System.out.printf("%-3c %-4d %-4o %-4x %-10s", i, i, i, i, Integer.toBinaryString(i));
         if ((i - 31) % 5 == 0) System.out.println();
     }
     System.out.println();
 }
}
