package zad4;

public class BasicLifeCost {

    private double income;
    private double basicCost;

    public BasicLifeCost(double income, double basicCost) {
        this.income = income;
        this.basicCost = basicCost;
    }

    public String getCostType() {
        return "Basic";
    }

    public static void info(BasicLifeCost cost) {
        System.out.println("B: " + cost.getCostType());
    }

    public double totalCost() {
        return basicCost;
    }

    public final double monthlySavings() {
        if (income <= totalCost()) {
            return 0;
        }

        return income - totalCost();

    }

    @Override
    public String toString() {
        String prompt;
        if (totalCost() > income) {
            return "You can't afford to live... Total cost is " + totalCost();
        } else {
            return "Total cost is " + totalCost();
        }
    }

}
