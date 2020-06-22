package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;

import exerciciocontabancaria.Empregado;

public class EmpregadoDao {

private Connection connection;
	
	public EmpregadoDao() {
	connection = SingleConnection.getConnection();
		
	}
	public void salvar( Empregado empregado) {
		try {
		String sql = "INSERT INTO empregado (codigo,nome,funcao) values (?,?,?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setInt(1, empregado.getCodigo());
		insert.setString(2, empregado.getNome());
		insert.setString(3, empregado.getFuncao());
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
	
	public List<Empregado> listar() throws Exception{
		List<Empregado> list = new ArrayList<Empregado>();
		String sql = "SELECT * FROM empregado";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		
		while (resultado.next()) {
			Empregado empregado = new Empregado();
			empregado.setCodigo(resultado.getInt("codigo"));
			empregado.setNome(resultado.getString("nome"));
			empregado.setFuncao(resultado.getString("funcao"));
			
			list.add(empregado);
		}
		
		return list; 
	}
	
}
