package conta_bancaria.conta_bancaria;

import java.util.List;

import org.junit.Test;

import dao.ClientDao;
import dao.ContaDao;
import dao.UserPosDAO;
import exerciciocontabancaria.Banco;
import exerciciocontabancaria.Cliente;
import exerciciocontabancaria.Conta;

public class TesteNoBanco {
	
	
	@Test
	public void intiBanco() {
		UserPosDAO posDAO = new UserPosDAO();
		Banco banco = new Banco();
		
		banco.setNome("Itau");
		banco.setAgencia("6844");
		posDAO.salvar(banco);
				
	}
	@Test
	public void intiListar() {
		UserPosDAO posDAO = new UserPosDAO();
		List<Banco> list;
		
		try {
			list = posDAO.listar();
			for (Banco banco : list) {
				System.out.println(banco);
				System.out.println("-----------------------------");
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void intiCliente() {
		ClientDao clientDao = new ClientDao();
		Cliente cliente = new Cliente();
		
		cliente.setNome("Marcelo");
		cliente.setEndereco("Rua 8");
		clientDao.salvar(cliente);
				
	}
	
	@Test
	public void initconta() {
		ContaDao contaDao = new ContaDao();
		Conta conta = new Conta();
		Cliente cliente = new Cliente();
		Banco banco = new Banco();
		cliente.setNome("Marcelo");
		banco.setNome("Itau");
		
		conta.setTitular(cliente);
		conta.setNumero(001);
		conta.setAgencia(banco);
		conta.setSaldo(1000);
		conta.setDataDeAbertura("10052020");
		contaDao.salvar(conta);
	}

}
