package br.senai.sp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Connection conexao = null;

	public static Connection getConexao() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://10.107.134.23/db_academia_b?useTimezone=true&serverTimezone=UTC&useSSL=false";
			conexao = DriverManager.getConnection(dbUrl, "inf2m-b", "123");
			System.out.println("Ah mlk, tá conectado!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Não conectou, animal!!");
		} 
		return conexao;
	}
	public static void fecharConexao() {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
	