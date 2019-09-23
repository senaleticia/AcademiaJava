package br.senai.sp.dao;

//import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.senai.sp.model.Aluno;

public class AlunoDAO {

	private Aluno aluno;
	
	public AlunoDAO(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public AlunoDAO() {
		
	}
	
	//Create
	public void gravar() {
		
		String sql = "INSERT INTO tbl_aluno "
				+ "(nome, telefone, email, data_nascimento, sexo, peso, altura, endereco) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, aluno.getNome());
			stm.setString(2, aluno.getTelefone());
			stm.setString(3, aluno.getEmail());
			stm.setString(4, aluno.getDataDeNascimento());
			stm.setString(5, String.valueOf(aluno.getSexo()));
			stm.setDouble(6, aluno.getPeso());
			stm.setDouble(7, aluno.getAltura());
			stm.setString(8, aluno.getEndereco());
			
			//Executar o comando no banco
			stm.execute();
			Conexao.fecharConexao();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Read
	public Aluno getAluno(int matricula) {
		String sql = "SELECT * FROM tbl_aluno WHERE matricula = ?";
		Aluno aluno = new Aluno();
		
		try {
			ResultSet resultado;
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, matricula);
			resultado = stm.executeQuery();
			
			resultado.next();
			aluno.setMatricula(resultado.getInt("matricula"));
			aluno.setNome(resultado.getString("nome"));
			aluno.setEmail(resultado.getString("email"));
			aluno.setTelefone(resultado.getString("telefone"));
			aluno.setAltura(resultado.getInt("altura"));
			aluno.setPeso(resultado.getDouble("peso"));
			aluno.setEndereco(resultado.getString("endereco"));
			aluno.setDataDeNascimento(resultado.getString("data_nascimento"));
			aluno.setSexo(resultado.getString("sexo").charAt(0));
			
			Conexao.fecharConexao();
			
			System.out.println(aluno.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aluno;
	}
	
	//Read
	public ArrayList<Aluno> listarAlunos() {
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		Aluno aluno;
		
		String sql = "SELECT * FROM tbl_aluno ORDER BY nome";
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				aluno = new Aluno();
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setAltura(rs.getInt("altura"));
				aluno.setPeso(rs.getDouble("peso"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setDataDeNascimento(rs.getString("data_nascimento"));
				aluno.setSexo(rs.getString("sexo").charAt(0));
				alunos.add(aluno);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		Conexao.fecharConexao();
		return alunos;
	}
	
	//Read
	public ArrayList<Aluno> listarAlunosPorSexo(char sexo) {
		
		String sql = "SELECT * FROM tbl_aluno WHERE sexo = ?";
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, String.valueOf(sexo));
			ResultSet rs = stm.executeQuery();
			
			ArrayList<Aluno> alunos = new ArrayList<>();
			
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getInt("matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setAltura(rs.getInt("altura"));
				aluno.setPeso(rs.getDouble("peso"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setDataDeNascimento(rs.getString("data_nascimento"));
				aluno.setSexo(rs.getString("sexo").charAt(0));
				alunos.add(aluno);
				
				stm.execute();
				
				Conexao.fecharConexao();
				return alunos;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
			
	}
	
	//Update
	public void atualizar() {
		String sql = "UPDATE tbl_aluno SET nome = ?, telefone = ?, email = ?, data_nascimento = ?, sexo = ?, peso = ?, altura = ?, endereco = ? "
				+ "WHERE matricula = ?";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, aluno.getNome());
			stm.setString(2, aluno.getTelefone());
			stm.setString(3, aluno.getEmail());
			stm.setString(4, aluno.getDataDeNascimento());
			stm.setString(5, String.valueOf(aluno.getSexo()));
			stm.setDouble(6, aluno.getPeso());
			stm.setDouble(7, aluno.getAltura());
			stm.setString(8, aluno.getEndereco());
			stm.setInt(9, aluno.getMatricula());
			
			stm.execute();
			Conexao.fecharConexao();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Delete
	public void excluir(int matricula) {
		String sql = "DELETE FROM tbl_aluno WHERE matricula = ?";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, matricula);
			
			stm.execute();
			Conexao.fecharConexao();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
