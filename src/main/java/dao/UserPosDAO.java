package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import exerciciocontabancaria.Banco;


public class UserPosDAO {
	
		private Connection connection;
		
		public UserPosDAO() {
		connection = SingleConnection.getConnection();
			
		}
		public void salvar( Banco banco) {
			try {
			String sql = "INSERT INTO banco (nome,agencia) values (?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, banco.getNome());
			insert.setString(2, banco.getAgencia());
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
		
		public List<Banco> listar() throws Exception{
			List<Banco> list = new ArrayList<Banco>();
			String sql = "SELECT * FROM banco";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();
			
			
			while (resultado.next()) {
				Banco banco = new Banco();
				banco.setNome(resultado.getString("nome"));
				banco.setAgencia(resultado.getString("agencia"));
				
				list.add(banco);
			}
			
			return list; 
		}
		
		public Banco buscar( String nome) throws SQLException {
			Banco retorno = new Banco();
			String sql = "SELECT * FROM banco where nome = "+nome;
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();
			
			
			while (resultado.next()) {
			
				retorno.setNome(resultado.getString("nome"));
				retorno.setAgencia(resultado.getString("agencia"));
				
				
			}
			
			return retorno; 
		}
		
		public void atualizar(Banco banco) {
			
			
			try {
				String sql = "UPDATE public.banco SET  name = ? WHERE name = "+banco.getNome();
				PreparedStatement statement;
				statement = connection.prepareStatement(sql);
				statement.setString(1, banco.getNome());
				
				statement.execute();
				connection.commit();
			} catch (SQLException e) {
					try {
						connection.rollback();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				e.printStackTrace();
			}
			
		}
		public void deletar(String nome) {
			try {
				String sql = "delete from banco where nome = "+nome;
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.execute();
				connection.commit();
				
				
			} catch (Exception e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		}
}

