package exerciciocontabancaria;

public class ClasseMain {

	public static void main(String[] args) {
		Banco b1 = new Banco();
		Cliente cl1 = new Cliente();
		Conta c1 = new Conta();
		
		b1.setNome("Itau");
		b1.setAgencia("6236");
		
		cl1.setNome("Cara ");
		cl1.setEndereco("Rua tal n°00");
		
		c1.setDataDeAbertura("19/04/2020");
		c1.setNumero(25064);
		c1.setAgencia(b1);
		c1.setTitular(cl1);
		c1.setSaldo(1200);
		
		c1.exibir();
		c1.saca(200);
		c1.exibir();

	}

}
