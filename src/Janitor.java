public class Janitor extends Employee implements JobModifier {

    private String equipment;

    public Janitor(int salary, String name, String gender, String equipment, int age, String occupation) {
        super(salary, name, gender, age, occupation);
        this.equipment = equipment;
    }

    public Janitor(String equipment) {
        this.equipment = equipment;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEquipment: " + getEquipment();
    }

    @Override
    public void modifySalaryByJob() {

        for (Employee index : employees) {

            if (index instanceof Janitor) {

                double newSalary = getSalary() * 0.8;

                int convertedInt = (int) newSalary;

                setSalary(convertedInt);

            }

        }

    }
}
