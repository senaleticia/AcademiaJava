package br.senai.sp.model;

public class Aluno {

	private int matricula;
	private String nome;
	private int idade;
	private char sexo;
	private double peso;
	private double altura;
	private String endereco;
	private String telefone;
	private String email;
	private String dataDeNascimento;
	
	// Setter e Getter
	public void setNome(String nome) {
		if (nome.isEmpty()) {
			System.out.println("Campo Obrigatório");
		}else {
			this.nome = nome;
		}
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public char setSexo(char sexo) {
		return this.sexo = sexo;
	}
	
	public char getSexo() {
		return this.sexo;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getAltura() {
		return this.altura;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Aluno [matricula= " + matricula + ", nome= " + nome + ", idade= " + idade + ", sexo= " + sexo + ", peso= "
				+ peso + ", altura= " + altura + ", endereco= " + endereco + ", telefone= " + telefone + ", email= " + email
				+ ", dataDeNascimento= " + dataDeNascimento + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public int getMatricula() {
		return matricula;
	}	
	
	
}
