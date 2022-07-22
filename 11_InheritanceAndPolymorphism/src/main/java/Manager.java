public class Manager implements Employee{

    private static final int FIX_SALARY = 80000;
    private final int earningsForCompany;

    public Manager() {
        this.earningsForCompany = (int) (Math.random() * 25000) + 115000;
    }

    @Override
    public int getMonthSalary() {
        return FIX_SALARY + (int) (earningsForCompany * 0.05);
    }
}
