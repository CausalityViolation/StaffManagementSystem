public class BossBoi extends Employee implements JobModifier {

    private String suit;

    public BossBoi(int salary, String name, String gender, int age, String occupation, String suit) {
        super(salary, name, gender, age, occupation);
        this.suit = suit;
    }

    public BossBoi(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSuit Brand: " + getSuit();
    }

    @Override
    public void modifySalaryByJob() {

        for (Employee index : employees) {

            if (index instanceof BossBoi) {

                double newSalary = getSalary() * 1.3;

                int convertedInt = (int) newSalary;

                setSalary(convertedInt);

            }

        }

    }
}
