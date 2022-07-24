import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
//        System.out.println(employeeMaxSalary);

        Integer[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};

//        Arrays.stream(digits)
//                .map(String::valueOf)
//                .reduce((s1, s2) -> s1 + s2)
//                .ifPresent(System.out::println);

        LRUCache<Employee> cache = new LRUCache(6);

        for (Employee employee : staff)
            cache.addElement(employee);

        cache.getAllElement().forEach(System.out::println);
    }

    private static LocalDate localDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year

        Employee employee = staff.stream()
                .filter(e -> localDate(e.getWorkStart()).getYear() == year)
                .max(Comparator.comparing(Employee::getSalary)).get();

        return employee;
    }
}