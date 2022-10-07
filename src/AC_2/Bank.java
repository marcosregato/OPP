package AC_2;

import java.util.ArrayList;

public class Bank implements BankAccountOperation {

    private ArrayList<BankAccount> bankAccounts; // contas bancárias

    public Bank() {
        setBankAccounts(new ArrayList<BankAccount>());
    }

    public double getBalance(int accountNumber) {
        return this.find(accountNumber).getBalance();
    }

    public void deposit(int accountNumber, double value) {
        BankAccount bankAccount = this.find(accountNumber);
        bankAccount.setBalance(bankAccount.getBalance() + value);
    }

    public void withdraw(int accountNumber, double value) {
        BankAccount bankAccount = this.find(accountNumber);
        bankAccount.setBalance(bankAccount.getBalance() - value);
    }

    public void addAccount(BankAccount account) {
        getBankAccounts().add(account);
    }

    public BankAccount find(int accountNumber) {
        for (BankAccount bankAccount : getBankAccounts()) {
            if (bankAccount != null && bankAccount.getAccountNumber() == accountNumber)
                return bankAccount;
        }
        return null;
    }

    public BankAccount getAccountBiggestBalance() {
        BankAccount maiorSaldo = getBankAccounts().get(0);
        for (BankAccount bankAccount : getBankAccounts()) {
            if (bankAccount != null && bankAccount.getBalance() > maiorSaldo.getBalance())
                maiorSaldo = bankAccount;
        }
        return maiorSaldo;
    }

    public BankAccount getAccountLowestBalance() {
        BankAccount menorSaldo = getBankAccounts().get(0);
        for (BankAccount bankAccount : getBankAccounts()) {
            if (bankAccount != null && bankAccount.getBalance() < menorSaldo.getBalance())
                menorSaldo = bankAccount;
        }
        return menorSaldo;
    }

    public double getAverageBalance() {
        double mediaSaldo = getBankAccounts().get(0).getBalance();
        for (BankAccount bankAccount : getBankAccounts()) {
            mediaSaldo += bankAccount.getBalance();
        }
        return mediaSaldo / getBankAccounts().size();
    }

    public double getSumBalanceAccounts() {
        double somaSaldo = 0;
        for (BankAccount bankAccount : getBankAccounts()) {
            somaSaldo += bankAccount.getBalance();
        }
        return somaSaldo;
    }

    public int count(int limit) {
        int countContas = 0;
        for (BankAccount bankAccount : getBankAccounts()) {
            if (bankAccount != null && bankAccount.getBalance() >= limit)
                countContas += 1;
        }
        return countContas;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

}
