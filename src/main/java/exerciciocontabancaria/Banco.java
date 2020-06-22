package exerciciocontabancaria;



public class Banco {
	private String nome;
	private String agencia;
        
        
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

    @Override
    public String toString() {
        return "" + " nome = " + nome + "\n, agencia = " + agencia ;
    }
	
	
}
