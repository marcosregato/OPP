package AC_2_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Utils {

	public void errorMessage() {
		JOptionPane.showMessageDialog(null, "Digite um valor valido!!", "Erro", JOptionPane.ERROR_MESSAGE);
	}

	public int showIntJOptionPane(String message) {
		try {
			String input = JOptionPane.showInputDialog(null, message);
			if (this.isEmpty(input))
				return -1;
			return Integer.parseInt(input);
		} catch (Exception e) {
			this.errorMessage();
			return this.showIntJOptionPane(message);
		}
	}

	public Double showDoubleJOptionPane(String message) {
		try {
			String input = JOptionPane.showInputDialog(null, message);
			if (input == null || (input != null && ("".equals(input))))
				return -1.0;
			return Double.parseDouble(input);
		} catch (Exception e) {
			this.errorMessage();
			return this.showDoubleJOptionPane(message);
		}
	}

	public String showStringJOptionPane(String message) {
		return JOptionPane.showInputDialog(null, message);
	}

	public String showSelectionJOptionPane(Object[] possibilities) {
		return (String) JOptionPane.showInputDialog(
				null,
				"Seleciona uma conta",
				"Contas Salvas",
				JOptionPane.PLAIN_MESSAGE,
				null,
				possibilities,
				0);
	}

	public void showMessageJOptionPane(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public boolean isEmpty(Object value) {
		if (value == null || (value != null && ("".equals(value))))
			return true;
		return false;
	}

	//TODO NOVO METODO
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getContaUsuario(String usuario, String file) {
		try {

			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			List<String> lines = new ArrayList();

			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			String conta = null;
			String[] data = lines.toArray(new String[0]);
			for(int x =0; x<data.length;x++) {
				if(data[x].contains(usuario)) {
					conta = data[x];
				}
			}
			return conta;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//TODO NOVO METODO
	public Double getSomaTotal(String file) {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			String colValor[];
			Double soma =0.0;
			while ((line = reader.readLine()) != null) {
				colValor = line.split(",");
				soma = soma + Double.valueOf(colValor[3]);
				//coluna.add(colValor[3]);
			}

			return soma;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//TODO NOVO METODO
	public Double getMedia(String file) {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			String colValor[];
			Double soma =0.0;
			int qtdLine =0;

			while ((line = reader.readLine()) != null) {
				colValor = line.split(",");
				soma = soma + Double.valueOf(colValor[3]);
				qtdLine +=1;
			}

			Double media = soma / qtdLine; 
			return media;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//TODO NOVO METODO
	public String getConsultarSaldo(String file, String accountNumber) {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			String colValor[];
			String saldo =null;

			while ((line = reader.readLine()) != null) {
				colValor = line.split(",");
				if(colValor[0].contains(accountNumber)) {
					//saldo = colValor[1] +","+ colValor[3];
					saldo = colValor[3];
				}
			}

			return saldo;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//TODO NOVO METODO
	public Double getContaMaiorSaldo(String file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			String colValor[];
			List<Double> coluna = new ArrayList<>();

			while ((line = reader.readLine()) != null) {
				colValor = line.split(",");
				coluna.add(Double.valueOf(colValor[3]));
			}
			Double valor = Collections.min(coluna);

			return valor;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	//TODO NOVO METODO
	public Double getContaMenorSaldo(String file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			String colValor[];
			List<Double> coluna = new ArrayList<>();

			while ((line = reader.readLine()) != null) {
				colValor = line.split(",");
				coluna.add(Double.valueOf(colValor[3]));
			}
			Double valor = Collections.min(coluna);

			return valor;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	//TODO NOVO METODO
	public void getDepositoSaldo(String file, String saida, String accountNumber, Double valor) {
		try {

			File gravar = new File(saida);

			FileWriter fw = new FileWriter(gravar,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			Scanner sc = new Scanner(new File(file));
			sc.useDelimiter(",");

			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			String colValor[];
			double saldo =0.0;

			while ((line = reader.readLine()) != null) {
				colValor = line.split(",");
				if(colValor[0].contains(accountNumber)) {
					saldo = Double.valueOf(valor) + Double.valueOf(colValor[3]);
					String linha = colValor[0]+","+colValor[1]+","+colValor[2]+","+saldo;
					pw.println(linha);
				}else {
					String linha = colValor[0]+","+colValor[1]+","+colValor[2]+","+colValor[3];
					pw.println(linha);
				}
			}

			sc.close();
			pw.flush();
			pw.close();

			File removeLine = new File(file);
			gravar.renameTo(removeLine);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//TODO NOVO METODO
	public void getSacarSaldo(String file, String saida, String accountNumber, Double valor) {
		try {

			File gravar = new File(saida);

			FileWriter fw = new FileWriter(gravar,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			Scanner sc = new Scanner(new File(file));
			sc.useDelimiter(",");

			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			String colValor[];
			double saldo =0.0;

			while ((line = reader.readLine()) != null) {
				colValor = line.split(",");
				if(colValor[0].contains(accountNumber)) {

					saldo = valor - Double.valueOf(colValor[3]);
					String s = colValor[0]+","+colValor[1]+","+colValor[2]+","+saldo;
					pw.println(s);
				}else {
					String s = colValor[0]+","+colValor[1]+","+colValor[2]+","+colValor[3];
					pw.println(s);
				}
			}

			sc.close();
			pw.flush();
			pw.close();

			File removeLine = new File(file);
			gravar.renameTo(removeLine);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//TODO NOVO METODO
	public String comprarArquivo() {
		try {

			BufferedReader arqSaida = new BufferedReader(new FileReader(".\\saida.txt"));
			BufferedReader arqGravar = new BufferedReader(new FileReader(".\\gravar.txt"));
			String lineSaida;
			String lineGravar;
			String colSaida[];
			String colGravar[];

			List<String> listSaida = new ArrayList<>();
			List<String> listGravar = new ArrayList<>();

			while ((lineSaida = arqSaida.readLine()) != null) {
				colSaida = lineSaida.split(",");
				listSaida.add(colSaida[2]);
			}
			while ((lineGravar = arqGravar.readLine()) != null) {
				colGravar = lineGravar.split(",");
				listGravar.add(colGravar[2]);
			}

			String arrayIguais = "arrayIguais";
			if(listSaida.equals(listGravar)) {
				return arrayIguais;
			}else {
				listSaida.removeAll(listGravar);
				return String.valueOf(listSaida);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//TODO NOVO METODO
	public String getLineConta(String usuario) {
		try {
			
			String saida = ".\\saida.txt";

			BufferedReader reader = new BufferedReader(new FileReader(saida));
			String line;
			String colValor[];

			while ((line = reader.readLine()) != null) {
				colValor = line.split(",");
				if(colValor[2].contains(String.valueOf(usuario))) {
					String linha = colValor[0]+","+colValor[1]+","+colValor[2]+","+colValor[3];
 					return linha;
				} 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//TODO NOVO METODO
	public void salvarNovaConta(String novaLinha) {
		try {
			PrintWriter csvWriter;
			csvWriter = new  PrintWriter(new FileWriter(".\\gravar.txt",true));//arqSaida,true));
			csvWriter.println(novaLinha);
			csvWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//TODO NOVO METODO Sincronizar os arquivos 
	public void updateGravar() {
		try {
			String newLine = comprarArquivo();
			String novaLinha = newLine.replace("[", "").replace("]", "");
			
			salvarNovaConta(getLineConta(novaLinha));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
