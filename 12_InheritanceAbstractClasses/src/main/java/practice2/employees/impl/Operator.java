package practice2.employees.impl;

import practice2.Company;
import practice2.employees.Employee;
import practice2.options.BonusConfig;
import practice2.options.PaymentRates;

/**
 * Класс Operator.
 * Зарплата складывается только из фиксированной части.
 *
 * @author RombyGyIde
 * @email romanblinov1613@gmail.com
 */
public class Operator implements Employee {

    private Company company;
    private Double salary;

    public Operator(Company company) {
        this.company = company;
        this.salary = getMonthSalary();
    }

    @Override
    public Double getSalary() {
        return this.salary;
    }

    /**
     * Метод double getMonthSalary().
     * Метод для расчета зарплаты оператора.
     *
     * @return зарплата оператора.
     */
    @Override
    public Double getMonthSalary() {
        return PaymentRates.OPERATOR.getRate() * getRealWorkTime() +
                company.getIncome() * BonusConfig.OPERATOR.getBonusSize();
    }
}
