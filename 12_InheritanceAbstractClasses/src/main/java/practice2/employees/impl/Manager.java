package practice2.employees.impl;

import practice2.Company;
import practice2.employees.Employee;
import practice2.options.BonusConfig;
import practice2.options.PaymentRates;

/**
 * Класс Manager.
 * Зарплата складывается из фиксированной части и бонуса в виде 5% от заработанных денег компании.
 *
 * @author RombyGyIde
 * @email romanblinov1613@gmail.com
 */
public class Manager implements Employee {

    private Company company;
    private Double salary;

    public Manager(Company company) {
        this.company = company;
        this.salary = getMonthSalary();
    }

    @Override
    public Double getSalary() {
        return salary;
    }

    /**
     * Метод double getMonthSalary().
     * Метод для расчета зарплаты менеджера.
     *
     * @return зарплата менеджера.
     */
    @Override
    public Double getMonthSalary() {
        return PaymentRates.MANAGER.getRate() * getRealWorkTime() +
                company.getIncome() * BonusConfig.MANAGER.getBonusSize();
    }
}
