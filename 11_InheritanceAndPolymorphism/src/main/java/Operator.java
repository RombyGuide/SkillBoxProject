public class Operator implements Employee{

    private static final int FIX_SALARY = 40000;

    @Override
    public int getMonthSalary() {
        return FIX_SALARY;
    }
}
