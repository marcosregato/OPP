package AC_2;


public class BankMain{

	public static void main(String[] asd) {

		


		Bank bank = new Bank();

	//	bank.saldoConta("conta_3");

		

	//	bank.somaSaldo();

	//	bank.mediaSaldo();

	//	bank.maiorSaldo();

	//	bank.menorSaldo();
		
		String line= "conta_2,200.00";
		
		bank.depositoConta("conta_2", 10.00, line);
		

	//	bank.removeConta(line);

	}
}