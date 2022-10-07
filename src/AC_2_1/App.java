package AC_2_1;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class App {

	public static void main(String[] args) throws Exception {
		ATM atm = new ATM(new Bank(), 5);
		HandleNumber handleNumber = new HandleNumber();
		Utils utils = new Utils();

		do {
			int accountNumber = 0;
			int valor = 0;
			String password = "";
			String owner = "";
			double balance = 0;

			handleNumber.newHandleNumber(
					"Selecione uma opção: "
							+ "\n1 - Adicionar Conta " // PRONTO
							+ "\n2 - Visualizar Contas " 
							+ "\n3 - Consultar Saldo " // PRONTO
							+ "\n4 - Sacar " // PRONTO
							+ "\n5 - Depositar " // PRONTO
							+ "\n6 - Soma de todas contas " // PRONTO
							+ "\n7 - Conta com maior saldo " // PRONTO
							+ "\n8 - Conta com menor saldo " // PRONTO
							+ "\n9 - Saldo médio das contas " // PRONTO
							+ "\n0 - Cancelar");

			switch (handleNumber.getHandleNumber()) {
			case 1:
				accountNumber = utils.showIntJOptionPane("Digite um numero para a conta.");
				password = utils.showStringJOptionPane("Digite uma senha para a conta.");
				owner = utils.showStringJOptionPane("Digite o nome do responsavel da conta.");
				balance = utils.showIntJOptionPane("Digite o saldo para a conta.");
				atm.getBank().addAccount(new BankAccount(accountNumber, password, owner,
						balance));

				utils.salvarNovaConta(accountNumber+","+password+","+owner+","+ balance);
				
				Thread thread = new Thread(){
				    public void run(){
				    	utils.updateGravar();
				    }
				  };

				  thread.start();
				
				break;
			case 2:
				String showBankAccounts = "";
				for (int i = 0; i < atm.getBank().getBankAccounts().size(); i++) {
					showBankAccounts += "Numero da Conta: " + atm.getBank().getBankAccounts().get(i).getAccountNumber()
							+ " -- Dono: " + atm.getBank().getBankAccounts().get(i).getOwner();

					if (i != (atm.getBank().getBankAccounts().size() - 1))
						showBankAccounts += "\n";
				}
				utils.showMessageJOptionPane(showBankAccounts);
				break;
			case 3:
				accountNumber = utils.showIntJOptionPane("Digite o numero da conta que deseja consultar o saldo.");
				utils.showMessageJOptionPane("O saldo da conta é: " + utils.getConsultarSaldo(".\\saida.txt", String.valueOf(accountNumber)));
				
				//utils.showMessageJOptionPane("O saldo da conta é: " + atm.getBalance(accountNumber));
				break;
			case 4:
				
				accountNumber = utils.showIntJOptionPane("Digite o numero da conta que deseja consultar o saldo.");
				valor = utils.showIntJOptionPane("Digite o o valor do deseja consultar.");
				
				utils.getSacarSaldo("saida.txt", "gravar.txt", String.valueOf(accountNumber), Double.valueOf(valor));
				utils.showMessageJOptionPane("O saldo do depósito é: " + utils.getConsultarSaldo(".\\gravar.txt", String.valueOf(accountNumber)));
				
				//doDepositOrWithdraw(atm, "withdraw");
				break;
			case 5:
				accountNumber = utils.showIntJOptionPane("Digite o numero da conta que deseja consultar o saldo.");
				valor = utils.showIntJOptionPane("Digite o o valor do deseja consultar.");
				
				utils.getDepositoSaldo("saida.txt", "gravar.txt", String.valueOf(accountNumber), Double.valueOf(valor));
				utils.showMessageJOptionPane("O saldo do depósito é: " + utils.getConsultarSaldo(".\\gravar.txt", String.valueOf(accountNumber)));
				//doDepositOrWithdraw(atm, "deposit");
				break;
			case 6:
				//utils.showMessageJOptionPane("O valor da soma de todas contas é " + atm.getBank().getSumBalanceAccounts());
				utils.showMessageJOptionPane("O valor da soma de todas contas é "+utils.getSomaTotal(".\\saida.txt"));
				
				break;
			case 7:
				utils.showMessageJOptionPane("A conta com o maior saldo:\n" + utils.getContaMaiorSaldo(".\\saida.txt"));
				//utils.showMessageJOptionPane("A conta com o maior saldo:\n" + atm.getBank().getAccountBiggestBalance().showBankAccount());
				break;
			case 8:
				utils.showMessageJOptionPane("A conta com o menor saldo:\n" + utils.getContaMenorSaldo(".\\saida.txt"));
				//utils.showMessageJOptionPane("A conta com o menor saldo:\n" + atm.getBank().getAccountLowestBalance().showBankAccount());
				break;
			case 9:
				utils.showMessageJOptionPane("A média de saldo das contas é: " +utils.getMedia(".\\saida.txt"));
				//utils.showMessageJOptionPane("A média de saldo das contas é: " + atm.getBank().getAverageBalance());
				break;
			}

			// bankAccounts.get(0).showBankAccount();

		} while (handleNumber.getHandleNumber() != 0);

	}

	static void doDepositOrWithdraw(BankAccountOperation bao, String type) throws Exception {
		Utils utils = new Utils();
		int accountNumber = utils.showIntJOptionPane("Digite o numero da conta que deseja fazer o deposito.");
		double value = utils.showDoubleJOptionPane("Digite o valor do " + type + " \nSaldo Atual: " + bao.getBalance(accountNumber));
		bao.getClass().getDeclaredMethod(type, int.class, double.class).invoke(bao, accountNumber, value);
	}

}
