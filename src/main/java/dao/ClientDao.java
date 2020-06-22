package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;

import exerciciocontabancaria.Cliente;

public class ClientDao {
	private Connection connection;
	
	public ClientDao() {
	connection = SingleConnection.getConnection();
		
	}
	public void salvar( Cliente cliente) {
		try {
		String sql = "INSERT INTO cliente (nome,endereco) values (?,?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setString(1, cliente.getNome());
		insert.setString(2, cliente.getEndereco());
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
	
	public List<Cliente> listar() throws Exception{
		List<Cliente> list = new ArrayList<Cliente>();
		String sql = "SELECT * FROM cliente";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		
		while (resultado.next()) {
			Cliente cliente = new Cliente();
			cliente.setNome(resultado.getString("nome"));
			cliente.setEndereco(resultado.getString("endereco"));
			
			list.add(cliente);
		}
		
		return list; 
	}
	
	
}
