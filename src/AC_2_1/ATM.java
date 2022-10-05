package AC_2_1;

public class ATM implements BankAccountOperation {
    private Bank bank;
    private double fee;
    private Utils utils = new Utils();

    public ATM(Bank bank, double fee) {
        setBank(bank);
        setFee(fee);
    }

    public double getBalance(int accountNumber) {
        BankAccount bankAccount = getBank().find(accountNumber);
        return bankAccount.getBalance();
    }

    public void deposit(int accountNumber, double value) {
        BankAccount bankAccount = getBank().find(accountNumber);

        bankAccount.setBalance(bankAccount.getBalance() + value);
    }

    public void withdraw(int accountNumber, double value) {
        BankAccount bankAccount = getBank().find(accountNumber);
        bankAccount.setBalance(bankAccount.getBalance() - value - getFee());
    }

    public void getTESTE(double message) {
        System.out.println(message);
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

}
