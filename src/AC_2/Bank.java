package AC_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Bank implements BankAccontOperation{

	File arqEntrada = new File(".\\entrada.txt");
	File arqSaida   = new File(".\\saida.txt");



	// saldo de um determinada conta ESTE ESTA PRONTO
	public void saldoConta(String conta){
		try{
			String ler 	  = ".\\entrada.txt";

			BufferedReader reader = new BufferedReader(new FileReader(ler));
			String linha;

			while ((linha= reader.readLine()) != null) {
				String[] d = linha.split(",");
				if(conta.equals(String.valueOf(d[0]))) {
					JOptionPane.showMessageDialog(null, "Conta => "+d[0]+" | valor da conta=> " + d[1]);
					break;
				}
			}

			reader.close();

		}catch(IOException e){
			e.printStackTrace();	
		}
	}

	
	public void depositoConta(String conta, double valor, String line){


		try {
			String ler 	  = ".\\entrada.txt";
			String gravar = ".\\saida.txt";

			BufferedReader reader = new BufferedReader(new FileReader(ler));
			PrintWriter printWriter = null;
			File file = new File(gravar);
			String linha;

			List<String> result = new ArrayList<>();
			removeConta(line);

			while ((linha = reader.readLine()) != null) {
				result.add(linha);
			}

			for(int x = 0 ; x < result.size();x++) {

				if(conta.equals(result.get(x).substring(0, 7))) {
					Double valorAtual = Double.valueOf(result.get(x).substring(8, 13));
					double soma = valor + valorAtual;
					
					if (!file.exists()) file.createNewFile();
					printWriter = new PrintWriter(new FileOutputStream(gravar, true));
					printWriter.write(conta+","+ soma);

					printWriter.flush();
					printWriter.close();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// retirada de uma determinada conta ESTE ESTA PRONTO
	public void removeConta(String conta){
		try{

			BufferedReader reader = new BufferedReader(new FileReader(arqEntrada));
			PrintWriter pw = new PrintWriter(new FileWriter(arqSaida));
			String linha;

			while ((linha = reader.readLine()) != null) {
				if (!linha.trim().equals(conta)) {
					pw.println(linha);
					pw.flush();
				}
			}

			reader.close();

		}catch(IOException e){
			e.printStackTrace();	
		}
	}

	// soma todos os saldos existente ESTE ESTA PRONTO
	public void somaSaldo(){

		try{
			String ler 	  = ".\\entrada.txt";
			BufferedReader reader = new BufferedReader(new FileReader(ler));
			String linha;
			double soma =0;

			while ((linha= reader.readLine()) != null) {
				String[] d = linha.split(",");
				soma = soma + Double.valueOf(d[1]);
			}

			JOptionPane.showMessageDialog(null, "Soma de todos os valores das contas é => " + soma);

			reader.close();

		}catch(IOException e){
			e.printStackTrace();	
		}

	}

	// media de todos os saldos ESTE ESTA PRONTO
	public void mediaSaldo(){

		try{
			String ler = ".\\entrada.txt";

			BufferedReader reader = new BufferedReader(new FileReader(ler));
			String linha;
			int count=0;
			double soma =0;

			while ((linha= reader.readLine()) != null) {

				String[] d = linha.split(",");
				soma = soma + Double.valueOf(d[1]);
				count +=1;
			}

			int result = (int)soma / count;

			JOptionPane.showMessageDialog(null, "Media de todos os valores das contas é => " + result);

			reader.close();

		}catch(IOException e){
			e.printStackTrace();
		}
	}

	// maior saldo ESTE ESTA PRONTO
	public void maiorSaldo(){

		try{
			String ler = ".\\entrada.txt";

			BufferedReader reader = new BufferedReader(new FileReader(ler));
			String linha;
			List<String> result = new ArrayList<>();
			Double valorProximo = 0.0;

			while ((linha= reader.readLine()) != null) {
				result.add(linha);
			}

			int conta=1;
			for(int x = 0 ; x < result.size();x++) {
				Double valorAtual = Double.valueOf(result.get(x).substring(8, 13));
				if( valorProximo > valorAtual) {
					JOptionPane.showMessageDialog(null, "Conta com saldo maior => conta_"+conta+","+valorProximo);
				}
				conta+=1;
				valorProximo = valorAtual;
			}

			reader.close();

		}catch(IOException e){
			e.printStackTrace();
		}
	}

	// menor saldo ESTE ESTA PRONTO
	public void menorSaldo(){

		try{
			String ler = ".\\entrada.txt";

			BufferedReader reader = new BufferedReader(new FileReader(ler));
			String linha;
			List<String> result = new ArrayList<>();
			Double valorProximo = 0.0;

			while ((linha= reader.readLine()) != null) {
				result.add(linha);
			}

			for(int x = 0 ; x < result.size();x++) {
				Double valorAtual = Double.valueOf(result.get(x).substring(8, 13));
				if( valorAtual < valorProximo) {
					JOptionPane.showMessageDialog(null, "Comta com saldo maior => "+result.get(x));
				}
				valorProximo = valorAtual;
			}

			reader.close();

		}catch(IOException e){
			e.printStackTrace();
		}
	}
}