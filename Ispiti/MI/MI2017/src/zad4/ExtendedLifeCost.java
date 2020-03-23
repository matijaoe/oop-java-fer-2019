package zad4;

public class ExtendedLifeCost extends BasicLifeCost {

    private double additionalExpenses;

    @Override
    public String getCostType() {
        return "Extended";
    }

    public static void info(ExtendedLifeCost cost) {
        System.out.println("E: " + cost.getCostType());
    }

    public ExtendedLifeCost(double income, double basicCost) {
        //additionalExpenses are equal to basicCost
        this(income, basicCost, basicCost);
    }

    public ExtendedLifeCost(double income, double basicCost, double additionalExpenses) {
        super(income, basicCost);
        this.additionalExpenses = additionalExpenses;
    }

    @Override
    public double totalCost() {
        return super.totalCost() + additionalExpenses;
    }

}
