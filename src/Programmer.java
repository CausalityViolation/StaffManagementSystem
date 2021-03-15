public class Programmer extends Employee implements JobModifier {

    private String progLang;

    public Programmer(int salary, String name, String gender, String progLang, int age, String occupation) {
        super(salary, name, gender, age, occupation);
        this.progLang = progLang;
    }

    public Programmer(String progLang) {
        this.progLang = progLang;
    }

    public String getProgLang() {
        return progLang;
    }

    public void setProgLang(String progLang) {
        this.progLang = progLang;
    }

    @Override
    public String toString() {
        return super.toString() + "\nProgramming Language: " + getProgLang();
    }

    @Override
    public void modifySalaryByJob() {

        for (Employee index : employees) {

            if (index instanceof Programmer) {

                double newSalary = getSalary() * 1.1;

                int convertedInt = (int) newSalary;

                setSalary(convertedInt);

            }

        }

    }
}
