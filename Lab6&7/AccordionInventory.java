package accordionApp;
import java.util.Scanner;

public class AccordionInventory {
	static String[] productName = {
			"Hohner Panther", "Gabbanelli", "SofiaMari", "Reyes Accordions", "Parrot", 
			"Delicia", "Rosetti", "Excelsior", "Castagnari", "Mengascini",
			"Serenellini", "Bugari", "Weltmeister", "Victoria", "Giuletti",
			"Petosa", "Beltuna", "Guerrini", "Titano", "Beltuna" };
	
	static double[] productPrice = {
			1800.00, 5000.00, 3200.00, 4500.00, 3000.00,
			2800.00, 5200.00, 4000.00, 4800.00, 5500.00,
			3700.00, 4300.00, 4600.00, 5800.00, 5400.00,
			6000.00, 4900.00, 6300.00, 7500.00, 7000.00 };
	
	static int[] productQuantity = {
			5, 2, 3, 1, 4, 6, 2, 3, 5, 2, 4, 1, 5, 3, 2, 4, 3, 2, 1, 3 };
	
	static char[] productCategory = {
			'D', 'P', 'C', 'B', 'D', 'P', 'C', 'B', 'D', 'P', 'C', 'B', 'D', 'P', 'C', 'B', 'D', 'P', 'C', 'B' };
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display Report");
            System.out.println("2. Display Report by Category");
            System.out.println("3. Change Record");
            System.out.println("4. Sort by Name and Show Report");
            System.out.println("5. Sort by Price and Show Report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayReport();
                    break;
                case 2:
                    System.out.print("Enter category (D/P/C/B): ");
                    char cat = sc.next().charAt(0);
                    categoryReport(cat);
                    break;
                case 3:
                    changeRecord(sc);
                    break;
                case 4:
                    sortByNameReport();
                    break;
                case 5:
                    sortByPriceReport();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }

    static void displayReport() {
        productHeader();
        for (int i = 0; i < productName.length; i++) {
            productDetailLine(i);
        }
        productFooter();
    }

    static void productHeader() {
        System.out.printf("%-20s %10s %10s %10s %10s\n", "Product", "Price", "Qty", "Category", "Ext. Price");
        System.out.println("--------------------------------------------------------------------------------");
    }

    static void productDetailLine(int i) {
        System.out.printf("%-20s %10.2f %10d %10c %10.2f\n",
                productName[i], productPrice[i], productQuantity[i], productCategory[i],
                productPrice[i] * productQuantity[i]);
    }

    static void productFooter() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("Average Sales: %10.2f\n", findAverageSales());
        System.out.printf("Total Sales: %10.2f\n", findTotalSales());
    }

    static double findTotalSales() {
        double total = 0;
        for (int i = 0; i < productPrice.length; i++) {
            total += productPrice[i] * productQuantity[i];
        }
        return total;
    }

    static double findAverageSales() {
        return findTotalSales() / productName.length;
    }

    static void changeRecord(Scanner sc) {
        System.out.print("Enter product name to change: ");
        sc.nextLine();
        String name = sc.nextLine();

        for (int i = 0; i < productName.length; i++) {
            if (productName[i].equalsIgnoreCase(name)) {
                System.out.print("Enter new price: ");
                productPrice[i] = sc.nextDouble();
                System.out.print("Enter new quantity: ");
                productQuantity[i] = sc.nextInt();
                System.out.println("Record updated.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    static void categoryReport(char c) {
        productHeader();
        for (int i = 0; i < productCategory.length; i++) {
            if (productCategory[i] == c) {
                productDetailLine(i);
            }
        }
        productFooter();
    }

    static void sortByNameReport() {
        for (int i = 0; i < productName.length - 1; i++) {
            for (int j = 0; j < productName.length - 1 - i; j++) {
                if (productName[j].compareTo(productName[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
        displayReport();
    }

    static void sortByPriceReport() {
        for (int i = 0; i < productPrice.length - 1; i++) {
            for (int j = 0; j < productPrice.length - 1 - i; j++) {
                if (productPrice[j] > productPrice[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
        displayReport();
    }

    static void swap(int i, int j) {
        String tempName = productName[i];
        productName[i] = productName[j];
        productName[j] = tempName;

        double tempPrice = productPrice[i];
        productPrice[i] = productPrice[j];
        productPrice[j] = tempPrice;

        int tempQty = productQuantity[i];
        productQuantity[i] = productQuantity[j];
        productQuantity[j] = tempQty;

        char tempCat = productCategory[i];
        productCategory[i] = productCategory[j];
        productCategory[j] = tempCat;
    }
}
