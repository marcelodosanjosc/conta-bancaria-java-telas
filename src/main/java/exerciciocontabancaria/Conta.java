package exerciciocontabancaria;



public class Conta {
	private Cliente titular;
	private int numero;
	private Banco agencia;
	private double saldo;
	private String dataDeAbertura;
	
	public void saca(double valor) {
		if(this.saldo >= valor) {
		this.saldo -= valor;
		System.out.println(" Realizado com sucesso");
		} else {
			System.out.println("Saldo insuficiente: "+getSaldo());
		}
	}
	public void depositar(double valor) {
		this.saldo += valor;
		System.out.println("Desposito com sucesso ");
	}
	
	public double calcularRendimento() {
		return 0;
	}
	
	public void exibir() {
		System.out.println("Nome: "+getTitular().getNome());
		System.out.println("Agencia: "+getAgencia().getNome());
		System.out.println("Conta: "+getNumero());
		System.out.println("Saldo: "+getSaldo());
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getDataDeAbertura() {
		return dataDeAbertura;
	}
	public void setDataDeAbertura(String dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}
	public Cliente getTitular() {
		return titular;
	}
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	public Banco getAgencia() {
		return agencia;
	}
	public void setAgencia(Banco agencia) {
		this.agencia = agencia;
	}

    @Override
    public String toString() {
        return "Conta{" + "titular=" + titular + ", numero=" + numero + ", agencia=" + agencia + ", saldo=" + saldo + ", dataDeAbertura=" + dataDeAbertura + '}';
    }

    
	
	
}

