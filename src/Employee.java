
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;

public class Employee {

    static ArrayList<Employee> employees = new ArrayList<>();

    static int iDGenerator = 1;
    static int input;

    private int salary;
    private String name;
    private int hiddenID;
    private String gender;
    private int age;
    private String occupation;

    public Employee(int salary, String name, String gender, int age, String occupation) {

        this.salary = salary;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.occupation = occupation;
        this.hiddenID = iDGenerator++;

    }

    public Employee() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHiddenID() {
        return hiddenID;
    }

    public void setHiddenID(int hiddenID) {
        this.hiddenID = hiddenID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static void dataBase() {

        Programmer prog1 = new Programmer(25000, "Gösta Ekman", "Male", "C#", 25, "Programmer");
        Janitor jan1 = new Janitor(15000, "Erika Freddesson", "Female", "Roomba", 39, "Janitor");
        Programmer prog2 = new Programmer(30000, "Uffe Nissesson", "Male", "Basic", 51, "Programmer");
        BossBoi b1 = new BossBoi(100000, "Krösus McRich", "Male", 69, "Boss", "Armani");

        employees.add(prog1);
        employees.add(jan1);
        employees.add(prog2);
        employees.add(b1);

        salaryModifierList();

    }

    public static void printAll() {

        for (Employee index : employees) {
            if (index instanceof Programmer) {
                Programmer p = (Programmer) index;
                System.out.println(p);

            } else if (index instanceof Janitor) {
                Janitor j = (Janitor) index;
                System.out.println(j);

            } else if (index instanceof BossBoi) {
                BossBoi b = (BossBoi) index;
                System.out.println(b);
            }
        }

    }

    public static void deleteByID() {

        System.out.println();
        System.out.print("Enter the ID of the employee you'd like to delete: ");
        int ID = readInt();

        for (int i = employees.size() - 1; i >= 0; i--) {
            if (employees.get(i).getHiddenID() == (ID)) {
                employees.remove(i);
            }
        }
        System.out.println("<Employee successfully removed>");
    }

    public static void searchByID() {

        boolean repeat = true;

        do {

            System.out.println();
            System.out.println("Enter the ID of the employee you'd like to display additional information about: ");
            int ID = readInt();

            for (Employee employee : employees) {

                if (employee.getHiddenID() == (ID)) {
                    System.out.println(employee);
                    repeat = false;

                }
            }
            System.out.println("<Input out of bounds>");

        } while (repeat);


    }

    public static void salaryModifierList() {

        double modifier;

        for (int i = employees.size() - 1; i >= 0; i--) {

            if (employees.get(i).getAge() >= (30) && employees.get(i).getAge() < 50) {

                modifier = employees.get(i).getSalary() * 1.10;

                int intModifier = (int) modifier;

                employees.get(i).setSalary(intModifier);

            } else if (employees.get(i).getAge() >= (50)) {

                modifier = employees.get(i).getSalary() * 1.20;

                int intModifier = (int) modifier;

                employees.get(i).setSalary(intModifier);
            }

        }
    }


    public static void addEmployee() {

        System.out.println();
        System.out.print("Enter name: ");
        String name = Menu.input.nextLine();

        System.out.print("\nEnter age: ");
        int age = readInt();

        System.out.print("\nEnter salary: ");
        int salary = readInt();

        System.out.print("\nEnter gender: ");
        String gender = Menu.input.nextLine();

        if (age >= (30) && (age < 50)) {

            double modifier = salary * 1.10;

            salary = (int) modifier;

        } else if (age >= (50)) {

            double modifier = salary * 1.20;

            salary = (int) modifier;

        }

        boolean repeat = true;

        while (repeat) {

            System.out.println("\nOccupation: ");
            System.out.println("<Please choose from 'Programmer', 'Boss', or 'Janitor'>");
            String occupation = Menu.input.nextLine();

            if (occupation.equalsIgnoreCase("Janitor")) {

                System.out.print("\nEnter equipment: ");
                String equipment = Menu.input.nextLine();

                Janitor j1 = new Janitor(salary, name, gender, equipment, age, occupation);

                j1.modifySalaryByJob();
                employees.add(j1);

                repeat = false;

            } else if (occupation.equalsIgnoreCase("Programmer")) {

                System.out.print("\nEnter programming language: ");
                String progLang = Menu.input.nextLine();

                Programmer p1 = new Programmer(salary, name, gender, progLang, age, occupation);

                p1.modifySalaryByJob();
                employees.add(p1);
                repeat = false;

            } else if (occupation.equalsIgnoreCase("Boss")) {
                System.out.print("\nEnter suit brand: ");
                String suitBrand = Menu.input.nextLine();

                BossBoi b1 = new BossBoi(salary, name, gender, age, occupation, suitBrand);

                b1.modifySalaryByJob();
                employees.add(b1);
                repeat = false;

            } else {

                System.out.println("<Invalid input>");

            }
        }
    }

    public static void editEmployee() {

        System.out.println();
        System.out.print("Enter the ID of the employee you'd like to EDIT: ");
        int ID = readInt();

        for (int i = employees.size() - 1; i >= 0; i--) {

            if (employees.get(i).getHiddenID() == (ID)) {

                System.out.println(employees.get(i));

                System.out.print("\nSelect which field you'd like to EDIT: ");
                System.out.println("\n1. Name");
                System.out.println("2. Age");
                System.out.println("3. Salary");
                System.out.println("4. Gender");
                System.out.println("5. Occupation");
                System.out.println("0. Return to Main Menu");

                int menuChoice = readInt();

                int intChoice;
                String choice;

                if (menuChoice == (1)) {

                    System.out.print("Enter new name: ");
                    choice = Menu.input.nextLine();

                    employees.get(i).setName(choice);

                    System.out.println("<Name successfully changed to " + choice + ">");

                } else if (menuChoice == (2)) {

                    System.out.print("New age: ");
                    intChoice = readInt();

                    employees.get(i).setAge(intChoice);

                    System.out.println("<Age successfully changed to " + intChoice + ">");

                } else if (menuChoice == (3)) {

                    System.out.print("Enter new salary: ");
                    intChoice = readInt();

                    employees.get(i).setSalary(intChoice);

                    System.out.println("<Salary successfully changed to " + intChoice + ">");

                } else if (menuChoice == (4)) {

                    System.out.print("New gender: ");
                    choice = Menu.input.nextLine();

                    employees.get(i).setGender(choice);

                    System.out.println("<Gender successfully changed to " + choice + ">");

                } else if (menuChoice == (5)) {

                    System.out.println("<Unable to edit field>");
                    System.out.println("<Please contact the administration for more information>");

                } else if (menuChoice == 0) {
                    System.out.println("\n<Returning to Main Menu>");
                }

            }
        }
    }

    public static void sortBySalary() {

        Comparator<Employee> sortBySalary = Comparator.comparingInt(Employee::getSalary);
        employees.sort(sortBySalary);
        System.out.println("<List successfully sorted!>");

    }

    public static void sortByID() {

        Comparator<Employee> sortByID = Comparator.comparingInt(Employee::getHiddenID);
        employees.sort(sortByID);
        System.out.println("<List successfully sorted!>");

    }

    public static void sortByName() {

        Comparator<Employee> sortByName = Comparator.comparing(Employee::getName);
        employees.sort(sortByName);
        System.out.println("<List successfully sorted!>");
    }

    public static void sortByAge() {

        Comparator<Employee> sortByAge = Comparator.comparingInt(Employee::getAge);
        employees.sort(sortByAge);
        System.out.println("<List successfully sorted!>");
    }

    public static int readInt() {

        boolean repeat = true;

        do {

            try {

                input = Menu.input.nextInt();

                repeat = false;


            } catch (InputMismatchException error) {

                System.out.println("<Input Error. Only Numbers Are Accepted>");
                System.out.println("<Please Try Again>");
                System.out.print("Input: ");
            } finally {

                Menu.input.nextLine();
            }


        } while (repeat);

        return input;
    }


    @Override
    public String toString() {
        return "\nID: " + getHiddenID() + "\nName: " + getName() + "\nAge: " + getAge() + "\nSalary: " + getSalary() + "kr" + "\nGender: " + getGender() + "\nOccupation: " + getOccupation();
    }
}
