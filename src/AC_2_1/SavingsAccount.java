package AC_2_1;

public class SavingsAccount extends BankAccount {
    private double interestRate; // taxa de juros

    public SavingsAccount(int accountNumber, String password, String owner,
            double balance, double interestRate) {
        super(accountNumber, password, owner, balance);
        this.interestRate = interestRate;
    }

    public double getBalance() {
        // Devolve o saldo da poupança
        return super.getBalance() * (1 + interestRate);
    }

}
