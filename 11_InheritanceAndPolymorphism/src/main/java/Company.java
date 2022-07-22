import java.util.*;

public class Company {
    private final List<Employee> employeeList = new ArrayList<>();

    public void hire(Employee employee) {
        this.employeeList.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        this.employeeList.addAll(employees);
    }

    public void fire(Employee employee) {
        this.employeeList.remove(employee);
    }

    public static int getIncome() {
        return 50000000;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        return getFilteredLimitedList(count, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getMonthSalary() - o1.getMonthSalary();
            }
        });
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        return getFilteredLimitedList(count, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getMonthSalary() - o2.getMonthSalary();
            }
        });
    }

    private List<Employee> getFilteredLimitedList(int count, Comparator<Employee> comparator) {
        List<Employee> copyList = new ArrayList<>(employeeList);
        Collections.sort(copyList, comparator);
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(copyList.get(i));
        }
        return result;
    }

    public int countEmployees() {
        return employeeList.size();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
