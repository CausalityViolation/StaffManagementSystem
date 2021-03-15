public class Statistics {

    public static void averageSalary() {

        int salary = 0;
        int averageSalary;

        for (int i = 0; i < Employee.employees.size(); i++) {

            salary = salary + Employee.employees.get(i).getSalary();
        }

        averageSalary = salary / Employee.employees.size();
        System.out.println("<Company Statistics>");
        System.out.println("Company average salary: " + averageSalary);

    }

    public static void genderRatio() {

        int maleCounter = 0;
        int femaleCounter = 0;
        int notAGender = 0;

        for (int i = 0; i < Employee.employees.size(); i++) {

            if (Employee.employees.get(i).getGender().equalsIgnoreCase("Male")) {
                maleCounter++;
            } else if (Employee.employees.get(i).getGender().equalsIgnoreCase("Female")) {
                femaleCounter++;
            } else {
                notAGender++;
            }
        }

        System.out.println("Male to Female ratio: " + maleCounter + "/" + femaleCounter);
        System.out.println("Unspecified gender: " + notAGender);

    }

    public static void averageAge() {

        int age = 0;
        int averageAge;

        for (int i = 0; i < Employee.employees.size(); i++) {

            age = age + Employee.employees.get(i).getAge();
        }

        averageAge = age / Employee.employees.size();
        System.out.println("Company average age: " + averageAge);

    }


}
