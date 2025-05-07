import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    private int id;
    private double amount;
    private String category;
    private String date;
    private String description;
    private String paymentMethod;
    private String vendor;

    public Expense(int id, double amount, String category, String date, String description, String paymentMethod, String vendor) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String toString() {
        return id + "\t" + amount + "\t" + category + "\t" + date + "\t" + description + "\t" + paymentMethod + "\t" + vendor;
    }
}

class FoodExpense extends Expense {
    private String mealType; 

    public FoodExpense(int id, double amount, String date, String description, String paymentMethod, String vendor, String mealType) {
        super(id, amount, "Food", date, description, paymentMethod, vendor);
        this.mealType = mealType;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + mealType;
    }
}


class EntertainmentExpense extends Expense {
    private String eventName; 

    public EntertainmentExpense(int id, double amount, String date, String description, String paymentMethod, String vendor, String eventName) {
        super(id, amount, "Entertainment", date, description, paymentMethod, vendor);
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + eventName;
    }
}


class UtilityExpense extends Expense {
    private String utilityType; 

    public UtilityExpense(int id, double amount, String date, String description, String paymentMethod, String vendor, String utilityType) {
        super(id, amount, "Utility", date, description, paymentMethod, vendor);
        this.utilityType = utilityType;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + utilityType;
    }
}

public class ExpenseTracker {
    private static List<Expense> expenses = new ArrayList<>();
    private static int nextId = 1;
    private static double budget = 0.0;

    public static void setBudget(Scanner scanner) {
        System.out.print("Enter your budget amount: ");
        try {
            budget = Double.parseDouble(scanner.nextLine());
            System.out.println("Budget set successfully to " + budget);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    
    public static void addExpense(Scanner scanner) {
        try {
            System.out.print("Enter amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            System.out.print("Enter payment method: ");
            String paymentMethod = scanner.nextLine();

            System.out.print("Enter vendor: ");
            String vendor = scanner.nextLine();

            System.out.println("Choose type of expense:");
            System.out.println("1. Food");
            System.out.println("2. Entertainment");
            System.out.println("3. Utility");
            int choice = Integer.parseInt(scanner.nextLine());

            Expense expense = null;

            switch (choice) {
                case 1:  // Food Expense
                    System.out.print("Enter meal type (e.g., breakfast, lunch, dinner): ");
                    String mealType = scanner.nextLine();
                    expense = new FoodExpense(nextId++, amount, date, description, paymentMethod, vendor, mealType);
                    break;
                case 2:  // Entertainment Expense
                    System.out.print("Enter event name (e.g., concert, movie): ");
                    String eventName = scanner.nextLine();
                    expense = new EntertainmentExpense(nextId++, amount, date, description, paymentMethod, vendor, eventName);
                    break;
                case 3:  // Utility Expense
                    System.out.print("Enter utility type (e.g., electricity, water): ");
                    String utilityType = scanner.nextLine();
                    expense = new UtilityExpense(nextId++, amount, date, description, paymentMethod, vendor, utilityType);
                    break;
                default:
                    System.out.println("Invalid choice. Expense not added.");
                    return;
            }

            expenses.add(expense);
            System.out.println("Expense added successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to show.");
        } else {
            System.out.println("ID\tAmount\tCategory\tDate\t\tDescription\tPayment\tVendor\tDetails");
            for (Expense e : expenses) {
                System.out.println(e);
            }
        }
    }

    public static void savingsPerMonth(Scanner scanner) {
        if (budget <= 0) {
            System.out.println("Budget not set. Please set your budget first.");
            return;
        }

        System.out.print("Enter year (YYYY): ");
        String year = scanner.nextLine();

        System.out.print("Enter month (MM): ");
        String month = scanner.nextLine();

        double totalExpenses = 0.0;

        for (Expense e : expenses) {
            String[] dateParts = e.getDate().split("-");
            if (dateParts[0].equals(year) && dateParts[1].equals(month)) {
                totalExpenses += e.getAmount();
            }
        }

        double savings = budget - totalExpenses;

        System.out.println("Total expenses for " + year + "-" + month + ": " + totalExpenses);
        System.out.println("Savings for " + year + "-" + month + ": " + savings);

        if (savings < 0) {
            System.out.println("Alert: You have overspent this month!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Set Budget");
            System.out.println("2. Add Expense");
            System.out.println("3. View Expenses");
            System.out.println("4. Check Savings Per Month");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    setBudget(scanner);
                    break;
                case 2:
                    addExpense(scanner);
                    break;
                case 3:
                    viewExpenses();
                    break;
                case 4:
                    savingsPerMonth(scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using Expense Tracker!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
