package AC_2_1;

public interface BankAccountOperation {
    public double getBalance(int accountNumber);

    public void deposit(int accountNumber, double value);

    public void withdraw(int accountNumber, double value);
}
