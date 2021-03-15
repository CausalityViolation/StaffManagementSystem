import java.util.Scanner;

public class Menu {

    static Scanner input = new Scanner(System.in);
    static int choice;
    static Boolean repeat;

    public static void mainMenu() {

        do {

            System.out.println();
            System.out.println("1. Manage Employee");
            System.out.println("2. Statistics");
            System.out.println("3. Sorting");
            System.out.println("0. Exit");

            choice = Employee.readInt();

            if (choice == (1)) {

                System.out.println();
                System.out.println("1. Add new employee");
                System.out.println("2. Edit existing employee information");
                System.out.println("3. List all current employees");
                System.out.println("4. Search for employee by ID");
                System.out.println("5. Remove employee");
                System.out.println("0. Exit");

                choice = Employee.readInt();

                if (choice == (1)) {

                    Employee.addEmployee();

                } else if (choice == (2)) {

                    Employee.printAll();
                    Employee.editEmployee();

                } else if (choice == (3)) {

                    Employee.printAll();

                } else if (choice == (4)) {

                    Employee.searchByID();

                } else if (choice == (5)) {

                    Employee.printAll();
                    Employee.deleteByID();

                } else if (choice == (0)) {

                    System.exit(0);

                } else {
                    System.out.println("<Please input a number between 0-5, as shown on the screen>");
                    repeat = true;
                }

            } else if (choice == (2)) {

                Statistics.averageSalary();
                Statistics.genderRatio();
                Statistics.averageAge();

            } else if (choice == (3)) {

                System.out.println("<Select Sorting Method>");
                System.out.println("1. Sort by Salary (Ascending)");
                System.out.println("2. Sort by ID (Ascending)");
                System.out.println("3. Sort by Name (Alphabetical Order)");
                System.out.println("4. Sort by Age (Ascending)");
                System.out.println("0. Exit");

                choice = Employee.readInt();

                if (choice == (1)) {

                    Employee.sortBySalary();

                } else if (choice == (2)) {

                    Employee.sortByID();

                } else if (choice == (3)) {

                    Employee.sortByName();

                } else if (choice == (4)) {

                    Employee.sortByAge();
                } else if (choice == (0)) {

                    System.exit(0);

                } else {

                    System.out.println("<Invalid Input>");
                    System.out.println("<Please input a number between 0-5, as shown on the screen>");

                }


            } else if (choice == (0)) {

                System.exit(0);

            } else {

                System.out.println("<Please input the correct number as shown on screen>");
                repeat = true;
            }
        } while (repeat = true);


    }

}
