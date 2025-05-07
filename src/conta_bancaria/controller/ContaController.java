package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;
import conta_bancaria.util.Cores;

public class ContaController implements ContaRepository {
	
	//Criar a Collection ArrayList
	private ArrayList<Conta> listaContas = new ArrayList <Conta> ();
	
	//Variável para controlar os números das contas
	int numero = 0;
	

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection (numero);
		
		if (conta != null)
			conta.visualizar();
		else
			System.out.printf(Cores.TEXT_RED_BOLD + "\nA Conta número %d não foi encontrada", numero);
		
	}

	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
		
	}
		
	@Override
	public void listarPorTitular(String titular) {
	
		List<Conta> listaTitulares = listaContas.stream()
				.filter(c -> c.getTitular().contains(titular))
				.collect(Collectors.toList());
		
		if (listaTitulares.isEmpty())
			System.out.printf("Nenhuma conta foi encontrada com base no critério: %s", titular);
		
		for (var conta : listaTitulares)
			conta.visualizar();
		
			
		}	
		
	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println(Cores.TEXT_GREEN_BRIGHT + "A Conta foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	// Métodos Auxiliares 
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	//Método
	
	public Conta buscarNaCollection (int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero)
				return conta;
		}
		
		return null;
	}

}
