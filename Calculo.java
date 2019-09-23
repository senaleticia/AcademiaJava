package br.senai.sp.model;

import br.senai.sp.utils.Data;

public class Calculo {
	
	private Aluno aluno;
	
	public Calculo(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public String pesoIdeal;
	
	public double calcularTMB() {
		
		if (aluno.getSexo() == 'M') {
			return 66 + (13.7 * aluno.getPeso()) + (5 * aluno.getAltura()) - (6.8 * aluno.getIdade());
		}else{
			return 665 + (9.6 * aluno.getPeso()) + (1.8 * aluno.getAltura()) - (4.7 * aluno.getIdade());
		}
			
	}
	
	public double calcularIMC() {
		double resultado = aluno.getPeso() / (aluno.getAltura()/100 * aluno.getAltura()/100);
		
		 if (resultado <= 17) {
			 pesoIdeal = "Muito Abaixo do Peso";
		 }else if(resultado <= 18.49) {
			 pesoIdeal = "Abaixo do Peso";
		 }else if(resultado <= 24.99) {
			 pesoIdeal = "Peso Normal";
		 }else if(resultado <= 34.99) {
			 pesoIdeal = "Obesidade I";
		 }else if(resultado <= 39.99) {
			 pesoIdeal = "Obesidade II (severa)";
		 }else {
			 pesoIdeal = "Obesidade III (mórbida)";
		 }
		return resultado;
	}
	
	public double calcularFCM() {
		
		if (aluno.getSexo() == 'M') {
			return 220 - Data.calcularIdade(Data.coverterDataParaPtBr(aluno.getDataDeNascimento()));
		}else {
			return 226 - Data.calcularIdade(Data.coverterDataParaPtBr(aluno.getDataDeNascimento()));
		}
	}
}
