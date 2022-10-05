package AC_2;


public interface BankAccontOperation{
	
	// saldo de um determinada conta
	public void saldoConta(String conta);
	
	// depósito de uma determinada conta
	public void depositoConta(String conta, double valor, String line);
	
	// retirada de uma determinada conta
	public void removeConta(String conta);
	
	// so,a de todos os saldos
	public void somaSaldo();
	
	// media de todos os saldos
	public void mediaSaldo();
	
	// maior saldo
	public void maiorSaldo();
	
	// menor saldo
	public void menorSaldo();
	


}