package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import exerciciocontabancaria.Banco;
import exerciciocontabancaria.Cliente;
import exerciciocontabancaria.Conta;


public class ContaDao {
	private Connection connection;
	
	public ContaDao() {
		connection = SingleConnection.getConnection();
			
		}
		public void salvar( Conta conta) {
			try {
			String sql = "INSERT INTO public.conta(titular, numero, banco, saldo, funcao)VALUES (?, ?, ?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, conta.getTitular().getNome());
			insert.setInt(2, conta.getNumero());
			insert.setString(3, conta.getAgencia().getNome());
			insert.setDouble(4, conta.getSaldo());
			insert.setString(4, conta.getDataDeAbertura());
			insert.execute();
			connection.commit();
			
			}catch (Exception e) {
				try {
					connection.rollback();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				e.printStackTrace();
			}
			
			}
		
		public List<Conta> listar() throws Exception{
			List<Conta> list = new ArrayList<Conta>();
			String sql = "SELECT * FROM conta";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();
			
			
			while (resultado.next()) {
				Conta conta = new Conta();
				Cliente cliente = new Cliente();
				Banco banco = new Banco();
				
				cliente.setNome(resultado.getString("titular")); 
				
				conta.setTitular(cliente);
				conta.setNumero(resultado.getInt("numero"));
				banco.setNome(resultado.getString("banco"));
				conta.setAgencia(banco);
				conta.setSaldo(resultado.getDouble("saldo"));
				conta.setDataDeAbertura(resultado.getString("funcao"));
				list.add(conta);
			}
			
			return list; 
		}

}
