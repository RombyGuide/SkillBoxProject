public class Account {

    private long money;
    private String accNumber;
    private volatile boolean blockingAccounts;

    public Account() {
        money = 0;
        accNumber = "";
        blockingAccounts = false;
    }

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
        blockingAccounts = false;
    }

    public boolean isBlockingAccounts() {
        return blockingAccounts;
    }

    public void setBlockingAccounts() {
        blockingAccounts = true;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public void addMoney(long amount) {
        money += amount;
    }

    public void reduceMoney(long amount) {
        money -= amount;
    }
}
