package AC_2;

public class BankAccount {

    private int accountNumber;
    private String password;
    private String owner;
    private double balance;

    public BankAccount(int accountNumber, String password, String owner, double balance) {
        this.setAccountNumber(accountNumber);
        this.setPassword(password);
        this.setOwner(owner);
        this.setBalance(balance);
    }

    public String showBankAccount() {
        return "Numero da conta: " + this.getAccountNumber() + " Senha: " + this.getPassword() + " Dono: "
                + this.getOwner() + " Saldo: " + this.getBalance();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
