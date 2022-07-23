package practice2.employees.impl;

import practice2.Company;
import practice2.employees.Employee;
import practice2.options.BonusConfig;
import practice2.options.PaymentRates;

/**
 * Класс TopManager.
 * Зарплата складывается из фиксированной части и бонуса в виде 150% от заработной платы,
 * если доход компании более 10 млн рублей
 *
 * @author RombyGyIde
 * @email romanblinov1613@gmail.com
 */
public class TopManager implements Employee {

    private static final double INCOME_PART = 0.05;
    private Company company;
    private Double salary;

    public TopManager(Company company) {
        this.company = company;
        this.salary = getMonthSalary();
    }

    @Override
    public Double getSalary() {
        return this.salary;
    }

    /**
     * Метод double getMonthSalary().
     * Метод для расчета зарплаты топ-менеджера.
     *
     * @return зарплата топ-менеджера.
     */
    @Override
    public Double getMonthSalary() {
        if (company.getIncome() > 10000000.00)
            return PaymentRates.TOP_MANAGER.getRate() * getRealWorkTime() +
                    company.getIncome() * BonusConfig.TOP_MANAGER.getBonusSize();
        return PaymentRates.TOP_MANAGER.getRate() * getRealWorkTime();
    }
}
